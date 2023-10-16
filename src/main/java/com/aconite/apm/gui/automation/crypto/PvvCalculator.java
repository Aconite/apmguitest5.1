package com.aconite.apm.gui.automation.crypto;

import com.aconite.apm.gui.automation.utilities.CryptoUtils;

public class PvvCalculator
{
    public static String generatePvv(String clearPan, String clearPin, String clearPVKKey, String pvki) throws Exception
    {
        sanityChecks(clearPan, clearPin, clearPVKKey, pvki);

        int clearPanLength = clearPan.length();
        String panString = clearPan.substring(clearPanLength - 12, clearPanLength - 1);

        String clearTsp = panString + pvki + clearPin;

        String encTsp = CryptoUtils.desEncryptData(clearTsp, clearPVKKey);

        StringBuffer pvv = new StringBuffer();

        getNumericDigits(pvv, encTsp);
        getAlphaDigits(pvv, encTsp);

        return pvv.toString();

    }

    private static void sanityChecks(String clearPan, String clearPin, String clearPVKKey, String pvki)
    {
        assert clearPan!= null;
        assert clearPin!= null;
        assert clearPVKKey!= null;
        assert pvki!= null;

        if (clearPVKKey.length() != 32)
        {
            throw new IllegalArgumentException("Clear text PVK key must be 32 digits. Supplied length is: " + clearPVKKey.length());
        }

        if (pvki.length() != 1)
        {
            throw new IllegalArgumentException("PVKI must be 1 digit in length. Supplied length is: " + pvki.length());
        }

        if (clearPin.length() > 12 || clearPin.length() < 4)
        {
            throw new IllegalArgumentException("PIN must be between 4 and 12 digits in length. Supplied length is: " + clearPin.length());
        }
    }

    private static void getNumericDigits(StringBuffer pvv, String encTsp) throws Exception
    {
        assert encTsp != null;

        if (encTsp.length() < 4)
        {
            throw new Exception("Encrypted TSP is invalid");
        }

        for (int i = 0; (pvv.length() < 4) && (i < encTsp.length()); i++)
        {
            char c = encTsp.charAt(i);
            if (c >= '0' && c <= '9')
            {
                pvv.append(c);
            }
        }
    }

    private static void getAlphaDigits(StringBuffer pvv, String encTsp)
    {
        assert encTsp != null;

        //If numDigits digits were not selected, select A-F digits and subtract 10
        for (int i = 0; (pvv.length() < 4) && (i < encTsp.length()); i++)
        {
            char c = encTsp.charAt(i);
            if (c >= 'A' && c <= 'F')
            {
                int v = c - 'A';
                pvv.append(v);
            } else if (c >= 'a' && c <= 'f')
            {
                int v = c - 'a';
                pvv.append(v);
            }
        }
    }

    public static void main(String[] args) throws Exception
    {
        System.out.println(PvvCalculator.generatePvv("9348101655506123513", "0504", "D0AD2CB357193EDCAB317CD6AD077010", "1"));
    }

}