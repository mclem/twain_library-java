package com.dynarithmic.twain.highlevel;

import java.util.ArrayList;
import java.util.List;

import com.dynarithmic.twain.exceptions.DTwainRuntimeException;

/**
 *
 * <p>The TwainAcquisitionData class describes pages and page image data acquired
 * from TWAIN device during one acquisition session. An acquisition session is
 * defined when a set of &quot;pages&quot;&nbsp; is acquired from the TWAIN device.&nbsp; </p>
 * <p>The programmer does not directly create instances of TwainAcquisitionData.&nbsp;
 * Instead, instances of TwainAcquisitionData are returned when the programmer
 * utilizes the DTwainAcquirer.getAllAcquisitions() method for images retrieved in
 * memory.&nbsp;&nbsp; </p>
 * <p><br>
 * An overview of an acquisition session is as follows:<br>
 * &nbsp;</p>
 * <ul>
 * <li>TWAIN device opened</li>
 * <li>&nbsp;&nbsp;&nbsp; TWAIN device UI is displayed</li>
 * <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; User scans 10 pages from
 * document feeder (an acquisition that consists of 10 pages)</li>
 * <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; User places 20 pages in
 * document feeder, and scans these pages (another acquisition of 20 pages)</li>
 * <li>&nbsp;&nbsp;&nbsp;&nbsp; TWAIN device UI is closed </li>
 * <li>&nbsp;TWAIN device is closed<br>
 * &nbsp;</li>
 * </ul>
 * <p>In the above scenario, there are two acquisition sessions, one that consists
 * of 10 pages,&nbsp; and another that consists of 20 pages.&nbsp; If the images
 * are stored in memory, a vector of TwainAcquisitionData describes the
 * acquisitions attempted, and the pages and image data represented by each
 * acquisition.<br>
 * &nbsp;</p>
 */
public class TwainAcquisitionData
{
    List<TwainImageData> imagePages;

    /**
     * @param allpages
     * A vector that on return, will be initialized to the page data that was acquired
     * for this acquisition.  This method need not be called by the DTWAIN Java program,
     * as this will be filled in automatically by the JNI native code.
     */
    public TwainAcquisitionData(List<TwainImageData> allpages)
    {
        imagePages = allpages;
    }

    public TwainAcquisitionData()
    {
        imagePages = new ArrayList<>();
    }

    public void setAcquisitionData(List<TwainImageData> allPages)
    {
        imagePages = allPages;
    }

    public void addImageData(TwainImageData theData)
    {
        imagePages.add(theData);
    }

    /**
     * @return Number of pages acquired from TWAIN device during this acquisition
     */
    public int getNumPages()
    {
        return imagePages.size();
    }

    /**
     * @param nWhichPage
     * Determines which page of the acquisition to retrieve the image data.<p>
     * @return
     * A byte array containing the image data.  The image data describes a complete JPEG, PNG, or BMP image of the acquired page.<p>     *
     * Note that acquiring images to memory is only available for JPEG, PNG, or BMP formats.
     */
    public byte [] getImageData(int nWhichPage) throws DTwainRuntimeException
    {
        if ( imagePages.isEmpty() )
            return new byte[0];
        if ( nWhichPage < 0 || nWhichPage >= imagePages.size() )
            return new byte[0];
        TwainImageData theData = imagePages.get(nWhichPage);
        try {
            return theData.getImageData();
        }
        catch (DTwainRuntimeException e)
        {
            throw new DTwainRuntimeException(e.getError());
        }
    }

    public TwainImageData getImageDataObject(int nWhichPage)
    {
        if ( imagePages.isEmpty() )
            return new TwainImageData(); //null;
        if ( nWhichPage < 0 || nWhichPage >= imagePages.size() )
            return null;
        return imagePages.get(nWhichPage);
    }
}