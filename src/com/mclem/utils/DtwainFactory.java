package com.mclem.utils;

import java.io.IOException;
import java.nio.file.Path;

import com.dynarithmic.twain.DTwainConstants.LoggingOptions;
import com.dynarithmic.twain.DTwainConstants.SessionStartupMode;
import com.dynarithmic.twain.exceptions.DTwainJavaAPIException;
import com.dynarithmic.twain.exceptions.DTwainRuntimeException;
import com.dynarithmic.twain.highlevel.ImageHandler;
import com.dynarithmic.twain.highlevel.TwainFileLogger;
import com.dynarithmic.twain.highlevel.TwainLogger;
import com.dynarithmic.twain.highlevel.TwainSession;
import com.dynarithmic.twain.highlevel.TwainSource.AcquireReturnInfo;

public class DtwainFactory {

    private static boolean USE_NATIVE_LOGGING = false;

    public static TwainSession createTwainSession() throws DTwainJavaAPIException, IOException {
        TwainSession session = new TwainSession(SessionStartupMode.NONE);

        Path logPath = LogManager.getImplicitLogPath();

        if (!USE_NATIVE_LOGGING) {
            session.enableLogging(true);
            TwainLogger logging = TwainSession.getLogger();
            logging.setVerbosity(TwainLogger.LoggerVerbosity.CUSTOM) // set to LOGALL & ~DECODE_SOURCE & ~DECODE_DEST & ~SHOW_ISTWAINMSG & ~DECODE_TWEVENT
                    .addLogger(new TwainFileLogger(logPath.toString()));
        }

        session.start();

        if (USE_NATIVE_LOGGING) {
            // Native flags may not be equivalent to the Java ones - to be verified!
            int flags = LoggingOptions.LOGALL.value() & ~LoggingOptions.DECODE_SOURCE.value() & ~LoggingOptions.DECODE_DEST.value() & ~LoggingOptions.SHOW_ISTWAINMSG.value() & ~LoggingOptions.DECODE_TWEVENT.value();
            session.getAPIHandle().DTWAIN_SetTwainLog(flags, logPath.toString());
            session.getAPIHandle().DTWAIN_EnableMsgNotify(1);
        }

        Runtime.getRuntime().addShutdownHook(new Thread(() -> LogManager.compactLogFile(logPath)));

        return session;
    }

    public static void debugReturnInfo(AcquireReturnInfo retInfo) throws DTwainRuntimeException {
        System.out.println("Return code: " + retInfo.getReturnCode());
        ImageHandler iHandler = retInfo.getImageHandler();
        if (iHandler == null) {
            System.out.println("ImageHandler is null");
        } else {
            System.out.println("Number of acquisitions: " + iHandler.getNumAcquisitions());
            System.out.println("Number of images: " + iHandler.getNumImages(0));
            System.out.println("Image bytes: " + iHandler.getImageData(0, 0).length);
        }
    }

}
