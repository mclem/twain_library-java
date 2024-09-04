package com.mclem;

import com.dynarithmic.twain.highlevel.TwainSession;
import com.dynarithmic.twain.highlevel.TwainSource;
import com.dynarithmic.twain.highlevel.TwainSource.AcquireReturnInfo;
import com.mclem.utils.DtwainFactory;
import com.mclem.utils.PrintingCallback;

public class AcquireFile {

    public static void main(String[] args) throws Exception {
        TwainSession session = DtwainFactory.createTwainSession();
        TwainSource source = session.selectDefaultSource();
        session.registerCallback(source, new PrintingCallback());

        if (source.isOpened()) {
            //source.getAcquireCharacteristics().getImageTypeOptions().setBitDepth(8);

            AcquireReturnInfo retInfo = source.acquire();
            // Observations:
            // - The TwainCallback does not receive messages
            // - The UI opens, I can click "Scan" then "Cancel", the UI closes
            // => The method returns with ERROR_NONE and "test.bmp" is created

            DtwainFactory.debugReturnInfo(retInfo);
        }
    }

}
