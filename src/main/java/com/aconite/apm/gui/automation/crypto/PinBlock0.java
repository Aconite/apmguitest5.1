package com.aconite.apm.gui.automation.crypto;

import com.aconite.apm.gui.automation.utilities.CryptoUtils;

public class PinBlock0
{
    private static final String FIXED_PADDING = "FFFFFFFFFFFFFFF";
    private static final String ZEROES = "0000";
    private static final String VERSION = "0";

    /**
     * Method to calculate an ISO 9564-1 Format 0 PIN Block
     * @param pin - Clear text PIN (must be between 4 and 12 digits in length)
     * @param pan - Clear text PAN
     * @return a byte array containing the PIN Block
     */
    public static byte[] calculatePinBlock(String pin, String pan) throws Exception
    {
        int pinLength = pin.length();
        if (pinLength < 4 || pinLength > 12)
        {
            throw new Exception("Invalid PIN length: " + pin);
        }

        byte[] pinBlock = new byte[8];

        //Build block 1: 0 | Length | PIN | Fixed Padding(FFFF...)
        StringBuilder sb_block1 = new StringBuilder();
        sb_block1.append(VERSION);
        sb_block1.append(Integer.toString(pinLength, 16).toUpperCase());
        sb_block1.append(pin);
        sb_block1.append(FIXED_PADDING.substring(0, 16 - sb_block1.length()));
        byte[] block1 = CryptoUtils.byteify(sb_block1.toString());

        //Build block 2: 0000 | StrippedPan
        //where StrippedPan is the last 13 digits of the PAN excluding the very last one.
        //i.e. StrippedPan is 12 digits in length.

        String panWithoutLuhnCheck = pan.substring(0, pan.length()-1);
        String strippedPan = panWithoutLuhnCheck.substring(panWithoutLuhnCheck.length() - 12);
        StringBuilder sb_block2 = new StringBuilder();
        sb_block2.append(ZEROES);
        sb_block2.append(strippedPan);
        byte[] block2 = CryptoUtils.byteify(sb_block2.toString());

        //XOR the two blocks: PIN Block = Block1 XOR Block2
        for (int i = 0; i < 8; i++)
        {
            pinBlock[i] = (byte)(block1[i] ^ block2[i]);
        }

        return pinBlock;
    }

    /**
     * Method to retrieve the clear text PIN from a ISO 9564-1 Format 0 PIN Block
     * @param pinBlock - clear text ISO 9564-1 Format 0 PIN Block
     * @param pan - clear text PAN
     * @return clear text PIN
     */
    public static String retrievePinFromPinBlock(String pinBlock, String pan) throws Exception
    {
        if (!pinBlock.substring(0, 1).equalsIgnoreCase(VERSION))
        {
            System.out.println(pinBlock);
            throw new Exception("PIN block is not of PIN Block format: " + VERSION + " or has been decrypted incorrectly");
        }

        if (pan == null || pan.length() < 13)
        {
            throw new Exception("PAN is either null or less than 13 digits: " + pan);
        }

        //Form pan block: 0000 | StrippedPan
        //where StrippedPan is the last 13 digits of the PAN excluding the very last one.
        //i.e. StrippedPan is 12 digits in length.
        String panWithoutLuhnCheck = pan.substring(0, pan.length() - 1);
        String strippedPan =  panWithoutLuhnCheck.substring(panWithoutLuhnCheck.length() - 12);
        StringBuilder sb_block1 = new StringBuilder();
        sb_block1.append(ZEROES);
        sb_block1.append(strippedPan);
        byte[] panBlockByteArr = CryptoUtils.byteify(sb_block1.toString());

        //Pin block: 0 | Length | PIN | RandomPadding(A-F)
        byte[] pinBlockByteArr = CryptoUtils.byteify(pinBlock);

        //XOR the two blocks
        byte[] resultantBlockByteArr = new byte[8];
        for (int i = 0; i < 8; i++)
        {
            resultantBlockByteArr[i] = (byte)(panBlockByteArr[i] ^ pinBlockByteArr[i]);
        }

        String str = CryptoUtils.hexify(resultantBlockByteArr);
        int pinLength = CryptoUtils.toInt(str.substring(1, 2));

        return str.substring(2, 2 + pinLength);
    }
}
