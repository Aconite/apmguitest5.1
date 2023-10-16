package com.aconite.apm.gui.automation.utilities;

import com.aconite.apm.gui.automation.crypto.DesEncryptDecrypt;
import com.aconite.apm.gui.automation.crypto.PinBlock0;
import com.aconite.apm.gui.automation.crypto.PinBlock1;
import com.sun.media.sound.InvalidDataException;
import org.apache.commons.lang.BooleanUtils;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import static com.aconite.apm.gui.automation.enums.PinBlockFormats.*;

public class CryptoUtils
{
    static final String ALGORITHM = "DESede";

    private CryptoUtils() {}

    public static String hexify(byte[] bytes)
    {
        return DatatypeConverter.printHexBinary(bytes);
    }

    public static String hexify(String utf8Str)
    {
        return hexify(utf8Str.getBytes(StandardCharsets.UTF_8));
    }

    public static String hexify(BigInteger bigInteger)
    {
        return hexify(bigInteger.toByteArray());
    }

    public static byte[] byteify(String str)
    {
        return DatatypeConverter.parseHexBinary(str);
    }

    public static byte[] bytefy(String str, boolean isHex) throws Exception
    {
        String hexString;

        if (!isHex)
        {
            hexString = hexify(str);
        }
        else
        {
            if (str.matches("[0-9a-fA-F]+"))
            {
                hexString = str;
            }
            else
            {
                throw new InvalidDataException("Not a valid hexstring: " + str);
            }
        }

        return DatatypeConverter.parseHexBinary(hexString);
    }

    public static int toInt(String str)
    {
        return Integer.parseInt(str, 16);
    }

    public static Map<String, String> panBlockChecker(String decPanBlock) throws Exception
    {

        Map<String, String> map = new HashMap<>();

        if (decPanBlock == null || decPanBlock.length() != 32)
        {
            throw new Exception("PAN Block cannot be null and must be 32 characters in length");
        }

        String retrievedPanLength = decPanBlock.substring(0,2);

        if (!retrievedPanLength.matches("[0-9]+"))
        {
            throw new Exception("First two characters (pan length) can only be in the [0-9] range. Current value: " + retrievedPanLength);
        }

        String retrievedPan = decPanBlock.substring(2, 2 + (Integer.parseInt(retrievedPanLength)));

        if (!retrievedPan.matches("[0-9]+"))
        {
            throw new Exception("The retrieved PAN value can only be in the [0-9] range. Current value: " + retrievedPan);
        }

        String retrievePadding = decPanBlock.substring(2 + (Integer.parseInt(retrievedPanLength)));

        if (!retrievePadding.matches("[F]+"))
        {
            throw new Exception("Mandatory padding can only contain FFs. Current value: " + retrievePadding);
        }

        map.put("panLength", retrievedPanLength);
        map.put("pan", retrievedPan);
        map.put("padding", retrievePadding);

        return map;
    }

    public static SecretKey convertHexKeyToSecretKey(String encKey) throws Exception
    {
        byte[] key24Bytes;

        if (encKey.length()/2 == 16)
        {
            key24Bytes = DesEncryptDecrypt.convert16ByteKeyTo24ByteKey(CryptoUtils.bytefy(encKey, true));
        }
        else if (encKey.length()/2 == 24)
        {
            key24Bytes = bytefy(encKey, true);
        }
        else
        {
            throw new IllegalArgumentException("Illegal key size: " + encKey.length() + " bytes.");
        }

        return new SecretKeySpec(key24Bytes, ALGORITHM);
    }


    public static String getPanFromDecPanBlock(String decPanBlock) throws Exception
    {
        Map<String, String> map = panBlockChecker(decPanBlock);
        return map.get("pan");
    }

    public static String getPanFromEncPanBlock(String encPanBlock, String srcZek) throws Exception
    {
        String decPanBlock = desDecryptData(encPanBlock, srcZek);
        return getPanFromDecPanBlock(decPanBlock);
    }

    public static String reDesEncryptData(String encData, String srcKey, String destKey) throws Exception
    {
        SecretKey secretSrcKey = convertHexKeyToSecretKey(srcKey);
        SecretKey secretDestKey = convertHexKeyToSecretKey(destKey);
        byte[] cipherText = bytefy(encData, true);

        byte[] clearData = DesEncryptDecrypt.decrypt(secretSrcKey, cipherText);

        return hexify(DesEncryptDecrypt.encrypt(secretDestKey, clearData));
    }

    public static String desDecryptData(String encData, String srcKey) throws Exception
    {
        SecretKey secretSrcKey = convertHexKeyToSecretKey(srcKey);
        byte[] cipherText = bytefy(encData, true);

        byte[] clearData = DesEncryptDecrypt.decrypt(secretSrcKey, cipherText);

        return hexify(clearData);
    }

    public static String desEncryptData(String clearHexData, String srcKey) throws Exception
    {
        SecretKey secretSrcKey = convertHexKeyToSecretKey(srcKey);
        byte[] clearByteVal = bytefy(clearHexData, true);

        byte[] cipherText = DesEncryptDecrypt.encrypt(secretSrcKey, clearByteVal);

        return hexify(cipherText);
    }

    public static String translatePan(String srcPanValue, String srcPanEncryptedFlag, String destPanEncryptedFlag, String srcZek, String destZek) throws Exception
    {
        String value;
        String tempValue;

//        System.out.println("******************************************");
//        System.out.println("PAN VALUE: " + srcPanValue);
//        System.out.println("SRC PAN ENC FLAG: " + srcPanEncryptedFlag);
//        System.out.println("DEST PAN ENC FLAG: " + destPanEncryptedFlag);
//        System.out.println("SRC ZEK: " + srcZek);
//        System.out.println("DEST ZEK: " + destZek);

        if (BooleanUtils.toBoolean(srcPanEncryptedFlag))
        {
            tempValue = desDecryptData(srcPanValue, srcZek);
//            System.out.println("TEMP VALUE (Decrypted): " + tempValue);
        }
        else
        {
            tempValue = srcPanValue;
        }

        if (BooleanUtils.toBoolean(destPanEncryptedFlag))
        {
            value = desEncryptData(tempValue, destZek);
        }
        else
        {
            value = tempValue;
        }
//        System.out.println("END VALUE (Decrypted): " + value);
//        System.out.println("******************************************");
        return getPanFromDecPanBlock(value);
    }

    public static String translatePin(String srcPinBlock, String srcPinBlockFormat, String srcZpk,
                                      String destPinBlockFormat, String destZpk, String pan)  throws Exception
    {
        String value;

        String decSrcPinBlock = desDecryptData(srcPinBlock, srcZpk);
        String clearTextPin;
        String decDestPinBlock;

        if (srcPinBlockFormat.equals(FORMAT_0.toString()))
        {
            clearTextPin = PinBlock0.retrievePinFromPinBlock(decSrcPinBlock, pan);
        }
        else if (srcPinBlockFormat.equals(FORMAT_1.toString()))
        {
            clearTextPin = PinBlock1.retrievePinFromPinBlock(decSrcPinBlock);
        }
        else
        {
            throw new Exception("Only format 0 and 1 PIN Blocks supported. Source PIN Block format: " + srcPinBlockFormat);
        }

        if (destPinBlockFormat.equals(FORMAT_0.toString()))
        {
            decDestPinBlock = hexify(PinBlock0.calculatePinBlock(clearTextPin, pan));
        }
        else if (destPinBlockFormat.equals(FORMAT_1.toString()))
        {
            decDestPinBlock = hexify(PinBlock1.calculatePinBlock(clearTextPin));
        }
        else
        {
            throw new Exception("Only format 0 and 1 PIN Blocks supported. Destination PIN Block format: " + destPinBlockFormat);
        }

        return desEncryptData(decDestPinBlock, destZpk);
    }

    public static String extractPinFromPinBlock(String pinBlock, String pinBlockFormat, String zpk, String pan) throws Exception
    {
        String decPinBlock = desDecryptData(pinBlock, zpk);
        String clearPin;

        if (pinBlockFormat.equals(FORMAT_0.toString()))
        {
            clearPin = PinBlock0.retrievePinFromPinBlock(decPinBlock, pan);
        }
        else if (pinBlockFormat.equals(FORMAT_1.toString()))
        {
            clearPin = PinBlock1.retrievePinFromPinBlock(decPinBlock);
        }
        else
        {
            throw new Exception("Only format 0 and 1 PIN Blocks supported. Source PIN Block format: " + pinBlockFormat);
        }

        return clearPin;
    }

}
