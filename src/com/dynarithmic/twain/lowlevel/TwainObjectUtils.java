package com.dynarithmic.twain.lowlevel;

import java.util.ArrayList;
import java.util.List;

public final class TwainObjectUtils
{
    private TwainObjectUtils() {}
    private static final int [] integralTypes = new int [] {
            TwainConstants.TWTY.TWTY_INT8,
            TwainConstants.TWTY.TWTY_INT16,
            TwainConstants.TWTY.TWTY_INT32,
            TwainConstants.TWTY.TWTY_UINT8,
            TwainConstants.TWTY.TWTY_UINT16,
            TwainConstants.TWTY.TWTY_UINT32,
            TwainConstants.TWTY.TWTY_BOOL};

    private static final int [] stringTypes = new int [] {
            TwainConstants.TWTY.TWTY_STR32,
            TwainConstants.TWTY.TWTY_STR64,
            TwainConstants.TWTY.TWTY_STR128,
            TwainConstants.TWTY.TWTY_STR255,
            TwainConstants.TWTY.TWTY_STR1024,
            TwainConstants.TWTY.TWTY_UNI512};

    private static final int [] fix32Types = new int [] {
            TwainConstants.TWTY.TWTY_FIX32};

    private static final int [] frameTypes = new int [] {
            TwainConstants.TWTY.TWTY_FRAME};

    public static <T> List<T> getObjectListAsType(List<Object> obj)
    {
        List<T> retList = new ArrayList<>();
        for (Object o : obj)
        {
            @SuppressWarnings("unchecked")
            T o2 = (T)o;
            retList.add(o2);
        }
        return retList;
    }

    public static boolean isIntegralType(int twainDataType)
    {
        for (int iType : integralTypes)
        {
            if ( twainDataType == iType)
                return true;
        }
        return false;
    }

    public static boolean isStringType(int twainDataType)
    {
        for (int iType : stringTypes)
        {
            if ( twainDataType == iType)
                return true;
        }
        return false;
    }

    public static boolean isFix32Type(int twainDataType)
    {
        for (int iType : fix32Types)
        {
            if ( twainDataType == iType)
                return true;
        }
        return false;
    }

    public static boolean isFrameType(int twainDataType)
    {
        for (int iType : frameTypes)
        {
            if ( twainDataType == iType)
                return true;
        }
        return false;
    }

}
