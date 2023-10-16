package com.aconite.apm.gui.automation.crypto;

import com.aconite.apm.gui.automation.utilities.CryptoUtils;

public class PinBlock1
{
    private static final String VERSION = "1";
    private static final String PADDING = "AB12CD34EF56GH78";

    /**
     * Method to calculate an ISO 9564-1 Format 1 PIN Block
     * @param pin - Clear text PIN (must be between 4 and 12 digits in length)
     * @return a byte array containing the PIN Block
     */
    public static byte[] calculatePinBlock(String pin) throws Exception
    {
        int pinLength = pin.length();
        if (pinLength < 4 || pinLength > 12)
        {
            throw new Exception("Invalid PIN length: " + pin);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(VERSION);
        sb.append(Integer.toString(pinLength, 16).toUpperCase());
        sb.append(pin);
        sb.append(PADDING.substring(0, 16 - sb.length()));

        return CryptoUtils.byteify(sb.toString());
    }

    /**
     * Method to retrieve the clear text PIN from a ISO 9564-1 Format 1 PIN Block
     * @param pinBlock - clear text ISO 9564-1 Format 1 PIN Block
     * @return clear text PIN
     */
    public static String retrievePinFromPinBlock(String pinBlock) throws Exception
    {
        if (pinBlock.length() != 16)
        {
            throw new IllegalArgumentException("PIN Block 1 is not 16 characters. It is: " + pinBlock.length());
        }
        if (!pinBlock.substring(0, 1).equalsIgnoreCase(VERSION))
        {
            throw new Exception("PIN block is not of PIN Block format: $VERSION or has been decrypted incorrectly");
        }

        int pinLength = Integer.parseInt(pinBlock.substring(1,2), 16);
        if (pinLength > 12 | pinLength < 4)
        {
            throw new Exception("PIN length must be between 4 and 12. Currently: " + pinLength);
        }

        return pinBlock.substring(2, 2 + pinLength);
    }
}
