package com.aconite.apm.gui.automation.crypto;

import com.aconite.apm.gui.automation.utilities.CryptoUtils;
import javax.crypto.SecretKey;
import static com.aconite.apm.gui.automation.enums.PinBlockFormats.*;

/**
 * This class can be used to produce a DESede encrypted Pin Block.
 *
 * The supported pin block formats are:
 *      ISO9564-1 Format 0
 *      ISO9564-1 Format 1
 *      ISO9564-1 Format 3 - (not implemented yet)
 *
 * The key used for encryption will be read from a properties file called 'pm.properties'
 */
class EncryptedPinPukBlockGenerator
{
    static final String ALGORITHM = "DESede";

    public static String getEncryptedPinBlock(String blockFormat, String pinPuk, String encKey, String pan) throws Exception
    {
        byte[] clearPinPukBlock;

        SecretKey secretZpk = CryptoUtils.convertHexKeyToSecretKey(encKey);

        if (blockFormat.equalsIgnoreCase(FORMAT_0.toString()))
        {
            if (pan == null || pan.length() > 16)
            {
                throw new IllegalArgumentException("Pan is needed for pin/puk block format 0");
            }

            clearPinPukBlock = PinBlock0.calculatePinBlock(pinPuk, pan);
        }
        else if (blockFormat.equalsIgnoreCase(FORMAT_1.toString()))
        {
            clearPinPukBlock = PinBlock1.calculatePinBlock(pinPuk);
        }
        else if (blockFormat.equalsIgnoreCase(FORMAT_3.toString()))
        {
            throw new Exception("Not implemented");
        }
        else
        {
            throw new IllegalArgumentException("Unknown PIN/PUK Block Format");
        }

        byte[] encryptedPinPukBlock = DesEncryptDecrypt.encrypt(secretZpk, clearPinPukBlock);

        return CryptoUtils.hexify(encryptedPinPukBlock);
    }
}
