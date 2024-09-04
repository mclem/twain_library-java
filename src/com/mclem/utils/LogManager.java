package com.mclem.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LogManager {

    // "user.dir" is the directory where the JVM was started
    private static final Path ROOT_DIR = Paths.get(System.getProperty("user.dir"));

    public static Path getImplicitLogPath() {
        String testName = Arrays.stream(new RuntimeException().getStackTrace())
                .filter(element -> element.getMethodName().equals("main"))
                .findFirst()
                .map(element -> element.getClassName().substring(element.getClassName().lastIndexOf('.') + 1))
                .orElseThrow();
        return ROOT_DIR.resolve("dtwain_" + testName + ".log").toAbsolutePath();
    }

    public static void compactLogFile(Path logFile) {
        System.out.println("Compacting log file: " + logFile);
        try {
            List<String> in = Files.readAllLines(logFile);
            List<String> out = compactLogEntries(in);
            Files.write(logFile, out);
            System.out.println("Reduced log file: " + logFile + " from: " + in.size() + " to: " + out.size() + " lines");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> compactLogEntries(List<String> logs) {
        List<String> result = new ArrayList<>();
        
        List<List<String>> twrcNotdseventLines = new ArrayList<>();
        for (int i = 0; i < logs.size(); i++) {
            String line = logs.get(i);
            if (i < logs.size() + 3 && line.endsWith("Input: ") && logs.get(i + 1).endsWith("Output: return code from DSM=5 (TWRC_NOTDSEVENT)")) {
                twrcNotdseventLines.add(Arrays.asList(line, logs.get(++i), logs.get(++i), logs.get(++i)));
            } else {
                result.addAll(handleTwrcNotdsevent(twrcNotdseventLines));
                result.add(line);
            }
        }
        result.addAll(handleTwrcNotdsevent(twrcNotdseventLines));

        return result;
    }

    private static List<String> handleTwrcNotdsevent(List<List<String>> lines) {
        List<String> result = new ArrayList<>();
        if (lines.size() > 0) {
            // Show first occurrence
            result.addAll(lines.get(0));
            if (lines.size() > 2) {
                // Compact middle occurrences
                result.add("[... " + (lines.size() - 2) + " occurrences]");
            }
            if (lines.size() > 1) {
                // Show last occurrence
                result.addAll(lines.get(lines.size() - 1));
            }
        }
        lines.clear();
        return result;
    }

}
