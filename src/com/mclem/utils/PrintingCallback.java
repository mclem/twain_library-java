package com.mclem.utils;

import com.dynarithmic.twain.highlevel.TwainCallback;
import com.dynarithmic.twain.highlevel.TwainSource;

public class PrintingCallback extends TwainCallback {

    @Override
    public int onAcquireCancelled(TwainSource sourceHandle) {
        System.out.println("onAcquireCancelled");
        return 1;
    }

    @Override
    public int onAcquireDone(TwainSource sourceHandle) {
        System.out.println("onAcquireDone");
        return 1;
    }

    @Override
    public int onAcquireFailed(TwainSource sourceHandle) {
        System.out.println("onAcquireFailed");
        return 1;
    }

    @Override
    public int onAcquireStarted(TwainSource sourceHandle) {
        System.out.println("onAcquireStarted");
        return 1;
    }

    @Override
    public int onAcquireTerminated(TwainSource sourceHandle) {
        System.out.println("onAcquireTerminated");
        return 1;
    }

    @Override
    public int onAppUpdatedDIB(TwainSource sourceHandle) {
        System.out.println("onAppUpdatedDIB");
        return 1;
    }

    @Override
    public int onBlankPageDetectedAdjustedImage(TwainSource sourceHandle) {
        System.out.println("onBlankPageDetectedAdjustedImage");
        return 1;
    }

    @Override
    public int onBlankPageDetectedEvent3(TwainSource sourceHandle) {
        System.out.println("onBlankPageDetectedEvent3");
        return 1;
    }

    @Override
    public int onBlankPageDetectedOriginalImage(TwainSource sourceHandle) {
        System.out.println("onBlankPageDetectedOriginalImage");
        return 1;
    }

    @Override
    public int onBlankPageDiscardedEvent1(TwainSource sourceHandle) {
        System.out.println("onBlankPageDiscardedEvent1");
        return 1;
    }

    @Override
    public int onBlankPageDiscardedEvent2(TwainSource sourceHandle) {
        System.out.println("onBlankPageDiscardedEvent2");
        return 1;
    }

    @Override
    public int onClipTransferDone(TwainSource sourceHandle) {
        System.out.println("onClipTransferDone");
        return 1;
    }

    @Override
    public int onCropImageFailedEvent(TwainSource sourceHandle) {
        System.out.println("onCropImageFailedEvent");
        return 1;
    }

    @Override
    public int onDeviceEvent(TwainSource sourceHandle) {
        System.out.println("onDeviceEvent");
        return 1;
    }

    @Override
    public int onEOJBeginFileSave(TwainSource sourceHandle) {
        System.out.println("onEOJBeginFileSave");
        return 1;
    }

    @Override
    public int onEOJDetected(TwainSource sourceHandle) {
        System.out.println("onEOJDetected");
        return 1;
    }

    @Override
    public int onEOJDetectedEndTransfer(TwainSource sourceHandle) {
        System.out.println("onEOJDetectedEndTransfer");
        return 1;
    }

    @Override
    public int onEOJEndFileSave(TwainSource sourceHandle) {
        System.out.println("onEOJEndFileSave");
        return 1;
    }

    @Override
    public int onEndOfJobDetected(TwainSource sourceHandle) {
        System.out.println("onEndOfJobDetected");
        return 1;
    }

    @Override
    public int onFeederLoaded(TwainSource sourceHandle) {
        System.out.println("onFeederLoaded");
        return 1;
    }

    @Override
    public int onFeederNotLoaded(TwainSource sourceHandle) {
        System.out.println("onFeederNotLoaded");
        return 1;
    }

    @Override
    public int onFileNameChanged(TwainSource sourceHandle) {
        System.out.println("onFileNameChanged");
        return 1;
    }

    @Override
    public int onFileNameChangint(TwainSource sourceHandle) {
        System.out.println("onFileNameChangint");
        return 1;
    }

    @Override
    public int onFilePageSaveError(TwainSource sourceHandle) {
        System.out.println("onFilePageSaveError");
        return 1;
    }

    @Override
    public int onFilePageSaveOk(TwainSource sourceHandle) {
        System.out.println("onFilePageSaveOk");
        return 1;
    }

    @Override
    public int onFilePageSaving(TwainSource sourceHandle) {
        System.out.println("onFilePageSaving");
        return 1;
    }

    @Override
    public int onFileSaveCancelled(TwainSource sourceHandle) {
        System.out.println("onFileSaveCancelled");
        return 1;
    }

    @Override
    public int onFileSaveError(TwainSource sourceHandle) {
        System.out.println("onFileSaveError");
        return 1;
    }

    @Override
    public int onFileSaveOk(TwainSource sourceHandle) {
        System.out.println("onFileSaveOk");
        return 1;
    }

    @Override
    public int onGeneralError(TwainSource sourceHandle) {
        System.out.println("onGeneralError");
        return 1;
    }

    @Override
    public int onImageInfoError(TwainSource sourceHandle) {
        System.out.println("onImageInfoError");
        return 1;
    }

    @Override
    public int onInvalidImageFormat(TwainSource sourceHandle) {
        System.out.println("onInvalidImageFormat");
        return 1;
    }

    @Override
    public int onManDupAcquireDone(TwainSource sourceHandle) {
        System.out.println("onManDupAcquireDone");
        return 1;
    }

    @Override
    public int onManDupFileError(TwainSource sourceHandle) {
        System.out.println("onManDupFileError");
        return 1;
    }

    @Override
    public int onManDupFileSaveError(TwainSource sourceHandle) {
        System.out.println("onManDupFileSaveError");
        return 1;
    }

    @Override
    public int onManDupFlipPages(TwainSource sourceHandle) {
        System.out.println("onManDupFlipPages");
        return 1;
    }

    @Override
    public int onManDupMemoryError(TwainSource sourceHandle) {
        System.out.println("onManDupMemoryError");
        return 1;
    }

    @Override
    public int onManDupMergeError(TwainSource sourceHandle) {
        System.out.println("onManDupMergeError");
        return 1;
    }

    @Override
    public int onManDupPageCountError(TwainSource sourceHandle) {
        System.out.println("onManDupPageCountError");
        return 1;
    }

    @Override
    public int onManDupSide1Done(TwainSource sourceHandle) {
        System.out.println("onManDupSide1Done");
        return 1;
    }

    @Override
    public int onManDupSide1Start(TwainSource sourceHandle) {
        System.out.println("onManDupSide1Start");
        return 1;
    }

    @Override
    public int onManDupSide2Done(TwainSource sourceHandle) {
        System.out.println("onManDupSide2Done");
        return 1;
    }

    @Override
    public int onManDupSide2Start(TwainSource sourceHandle) {
        System.out.println("onManDupSide2Start");
        return 1;
    }

    @Override
    public int onOCRTextRetrieved(TwainSource sourceHandle) {
        System.out.println("onOCRTextRetrieved");
        return 1;
    }

    @Override
    public int onPDFOCRDone(TwainSource sourceHandle) {
        System.out.println("onPDFOCRDone");
        return 1;
    }

    @Override
    public int onPDFOCRError(TwainSource sourceHandle) {
        System.out.println("onPDFOCRError");
        return 1;
    }

    @Override
    public int onPDFOCRReady(TwainSource sourceHandle) {
        System.out.println("onPDFOCRReady");
        return 1;
    }

    @Override
    public int onPageCancelled(TwainSource sourceHandle) {
        System.out.println("onPageCancelled");
        return 1;
    }

    @Override
    public int onPageContinue(TwainSource sourceHandle) {
        System.out.println("onPageContinue");
        return 1;
    }

    @Override
    public int onPageDiscarded(TwainSource sourceHandle) {
        System.out.println("onPageDiscarded");
        return 1;
    }

    @Override
    public int onPageFailed(TwainSource sourceHandle) {
        System.out.println("onPageFailed");
        return 1;
    }

    @Override
    public int onProcessAudioFinalAccepted(TwainSource sourceHandle) {
        System.out.println("onProcessAudioFinalAccepted");
        return 1;
    }

    @Override
    public int onProcessDIBAccepted(TwainSource sourceHandle) {
        System.out.println("onProcessDIBAccepted");
        return 1;
    }

    @Override
    public int onProcessDIBFinalAccepted(TwainSource sourceHandle) {
        System.out.println("onProcessDIBFinalAccepted");
        return 1;
    }

    @Override
    public int onProcessedAudioFile(TwainSource sourceHandle) {
        System.out.println("onProcessedAudioFile");
        return 1;
    }

    @Override
    public int onProcessedAudioFinal(TwainSource sourceHandle) {
        System.out.println("onProcessedAudioFinal");
        return 1;
    }

    @Override
    public int onProcessedDib(TwainSource sourceHandle) {
        System.out.println("onProcessedDib");
        return 1;
    }

    @Override
    public int onProcessedDibFinal(TwainSource sourceHandle) {
        System.out.println("onProcessedDibFinal");
        return 1;
    }

    @Override
    public int onQueryOCRText(TwainSource sourceHandle) {
        System.out.println("onQueryOCRText");
        return 1;
    }

    @Override
    public int onQueryPageDiscard(TwainSource sourceHandle) {
        System.out.println("onQueryPageDiscard");
        return 1;
    }

    @Override
    public int onSetCallBack64Init(TwainSource sourceHandle) {
        System.out.println("onSetCallBack64Init");
        return 1;
    }

    @Override
    public int onSetCallBackInit(TwainSource sourceHandle) {
        System.out.println("onSetCallBackInit");
        return 1;
    }

    @Override
    public int onTransferCancelled(TwainSource sourceHandle) {
        System.out.println("onTransferCancelled");
        return 1;
    }

    @Override
    public int onTransferDone(TwainSource sourceHandle) {
        System.out.println("onTransferDone");
        return 1;
    }

    @Override
    public int onTransferReady(TwainSource sourceHandle) {
        System.out.println("onTransferReady");
        return 1;
    }

    @Override
    public int onTransferStripDone(TwainSource sourceHandle) {
        System.out.println("onTransferStripDone");
        return 1;
    }

    @Override
    public int onTransferStripFailed(TwainSource sourceHandle) {
        System.out.println("onTransferStripFailed");
        return 1;
    }

    @Override
    public int onTransferStripReady(TwainSource sourceHandle) {
        System.out.println("onTransferStripReady");
        return 1;
    }

    @Override
    public int onTwainPageCancelled(TwainSource sourceHandle) {
        System.out.println("onTwainPageCancelled");
        return 1;
    }

    @Override
    public int onTwainPageFailed(TwainSource sourceHandle) {
        System.out.println("onTwainPageFailed");
        return 1;
    }

    @Override
    public int onTwainTripletBegin(TwainSource sourceHandle) {
        System.out.println("onTwainTripletBegin");
        return 1;
    }

    @Override
    public int onTwainTripletEnd(TwainSource sourceHandle) {
        System.out.println("onUIOpenFailure");
        return 1;
    }

    @Override
    public int onUIClosed(TwainSource sourceHandle) {
        System.out.println("onUIClosed");
        return 1;
    }

    @Override
    public int onUIClosing(TwainSource sourceHandle) {
        System.out.println("onUIClosing");
        return 1;
    }

    @Override
    public int onUIOpenFailure(TwainSource sourceHandle) {
        System.out.println("onUIOpenFailure");
        return 1;
    }

    @Override
    public int onUIOpened(TwainSource sourceHandle) {
        System.out.println("onUIOpened");
        return 1;
    }

    @Override
    public int onUIOpening(TwainSource sourceHandle) {
        System.out.println("onUIOpening");
        return 1;
    }
    
}
