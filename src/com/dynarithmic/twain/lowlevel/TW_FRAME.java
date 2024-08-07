/*
    This file is part of the Dynarithmic TWAIN Library (DTWAIN).
    Copyright (c) 2002-2024 Dynarithmic Software.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

    FOR ANY PART OF THE COVERED WORK IN WHICH THE COPYRIGHT IS OWNED BY
    DYNARITHMIC SOFTWARE. DYNARITHMIC SOFTWARE DISCLAIMS THE WARRANTY OF NON INFRINGEMENT
    OF THIRD PARTY RIGHTS.

 */
package com.dynarithmic.twain.lowlevel;

public class TW_FRAME extends TwainLowLevel
{
    private TW_FIX32 Left = new TW_FIX32();
    private TW_FIX32 Top = new TW_FIX32();
    private TW_FIX32 Right = new TW_FIX32();
    private TW_FIX32 Bottom = new TW_FIX32();

    public TW_FRAME()
    {
        super();
        this.setBottom(Double.MIN_VALUE).
             setLeft(Double.MIN_VALUE).
             setRight(Double.MIN_VALUE).
             setTop(Double.MIN_VALUE);
    }

    public TW_FIX32 getLeft()
    {
        return Left;
    }

    public TW_FIX32 getTop()
    {
        return Top;
    }

    public TW_FIX32 getRight()
    {
        return Right;
    }

    public TW_FIX32 getBottom()
    {
        return Bottom;
    }

    public TW_FRAME setLeft(TW_FIX32 left)
    {
        Left = left;
        return this;
    }

    public TW_FRAME setTop(TW_FIX32 top)
    {
        Top = top;
        return this;
    }

    public TW_FRAME setRight(TW_FIX32 right)
    {
        Right = right;
        return this;
    }

    public TW_FRAME setBottom(TW_FIX32 bottom)
    {
        Bottom = bottom;
        return this;
    }
    public TW_FRAME setLeft(double left)
    {
        Left.setValue(left);
        return this;
    }

    public TW_FRAME setTop(double top)
    {
        Top.setValue(top);
        return this;
    }

    public TW_FRAME setRight(double right)
    {
        Right.setValue(right);
        return this;
    }

    public TW_FRAME setBottom(double bottom)
    {
        Bottom.setValue(bottom);
        return this;
    }

    public boolean isFrameValid()
    {
        return Left.getValue() != Double.MIN_VALUE &&
               Right.getValue() != Double.MIN_VALUE &&
               Top.getValue() != Double.MIN_VALUE &&
               Bottom.getValue() != Double.MIN_VALUE;
    }
}
