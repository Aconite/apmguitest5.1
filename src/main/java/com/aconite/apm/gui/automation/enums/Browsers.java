package com.aconite.apm.gui.automation.enums;

public enum Browsers
{
    FIREFOX ("Firefox"),
    CHROME ("Chrome"),
    EDGE ("Edge");

    private final String browserStr;

    Browsers(String browserStr)
    {
        this.browserStr = browserStr;
    }

    @Override
    public String toString()
    {
        return browserStr;
    }
}
