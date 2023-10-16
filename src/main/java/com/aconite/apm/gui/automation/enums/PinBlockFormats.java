package com.aconite.apm.gui.automation.enums;

public enum PinBlockFormats
{
    FORMAT_0 ("0"),
    FORMAT_1 ("1"),
    FORMAT_3 ("3");

    String pinBlockFormat;

    PinBlockFormats (String pinBLockFormat)
    {
        this.pinBlockFormat = pinBLockFormat;
    }

    @Override
    public String toString()
    {
        return pinBlockFormat;
    }
}
