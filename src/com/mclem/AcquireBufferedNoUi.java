package com.mclem;

import com.dynarithmic.twain.DTwainConstants.AcquireType;
import com.dynarithmic.twain.highlevel.ImageHandler;
import com.dynarithmic.twain.highlevel.TwainSession;
import com.dynarithmic.twain.highlevel.TwainSource;
import com.dynarithmic.twain.highlevel.TwainSource.AcquireReturnInfo;
import com.mclem.utils.DtwainFactory;
import com.mclem.utils.PrintingCallback;

public class AcquireBufferedNoUi {

    public static void main(String[] args) throws Exception {
        TwainSession session = DtwainFactory.createTwainSession();
        TwainSource source = session.selectDefaultSource();
        session.registerCallback(source, new PrintingCallback());
        
        if (source.isOpened()) {
            source.getAcquireCharacteristics().getUserInterfaceOptions().showUI(false);
            source.getAcquireCharacteristics().getGeneralOptions().setAcquireType(AcquireType.BUFFERED);
            source.getAcquireCharacteristics().getGeneralOptions().setMaxAcquisitions(1);

            AcquireReturnInfo retInfo = source.acquire();
            // Observations:
            // - The TwainCallback does not receive messages
            // => The method returns with ERROR_NONE and we have an ImageHandler with 1 acquisition of 1 image

            DtwainFactory.debugReturnInfo(retInfo);
        }
    }

}
