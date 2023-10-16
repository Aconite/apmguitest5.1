package com.aconite.apm.gui.automation.crypto;

import com.sun.media.sound.InvalidDataException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public class DesEncryptDecrypt
{
    static final String CIPHER_INSTANCE = "DESede/ECB/NoPadding";

    /**
     * Method to encrypt data
     * @param secretKey - 24 byte DES key (can be a double length 3DES key)
     * @param clearByteVal - byte array containing clear data
     * @return a byte array containing encrypted data
     */
    public static byte[] encrypt (SecretKey secretKey, byte[] clearByteVal) throws Exception
    {
        dataSanityCheck(clearByteVal);
        Cipher cipher = Cipher.getInstance(CIPHER_INSTANCE);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(clearByteVal);
    }

    /**
     * Method to encrypt data
     * @param secretKey - 24 byte DES key (can be a double length 3DES key)
     * @param cipherByteVal - byte array containing the encrypted data
     * @return a byte array containing clear data
     */
    public static byte[] decrypt (SecretKey secretKey, byte[] cipherByteVal) throws Exception
    {
        dataSanityCheck(cipherByteVal);
        Cipher cipher = Cipher.getInstance(CIPHER_INSTANCE);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return cipher.doFinal(cipherByteVal);
    }

    /**
     * Method to convert a 16 byte key to a 24 byte DESede key (i.e. DESede Key)
     * @param key 16 byte DES key
     * @return
     */
    public static byte[] convert16ByteKeyTo24ByteKey(byte[] key)
    {
        byte[] retKey = new byte[24];

        if (key != null && key.length != 16)
        {
            throw new IllegalArgumentException("Key needs to be 16 bytes. Current size: " + key.length);
        }

        System.arraycopy(key, 0, retKey, 0, 16);
        System.arraycopy(key, 0, retKey, 16, 8);

        return retKey;
    }

    /**
     * Method to ensure that input data is not zero length and is a multiple of 8 bytes
     * @param data - input data
     * @throws InvalidDataException
     */
    static void dataSanityCheck(byte[] data) throws InvalidDataException
    {
        if (data != null && data.length == 0 )
        {
            throw new InvalidDataException("Data size cannot be 0");
        }
        if (data.length%8 != 0)
        {
            throw new InvalidDataException("Data must be a multiple of 8 bytes. Current data is " + data.length + " bytes");
        }
    }
}
