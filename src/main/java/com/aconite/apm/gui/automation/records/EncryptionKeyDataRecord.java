package com.aconite.apm.gui.automation.records;

public class EncryptionKeyDataRecord {

    private String id;
    private String status;
    private String keyType;
    private String expiryDate;
    private String index;
    private String decimalisationTable;
    private String decimalisationTableEncryption;
    private String validationPattern;
    private String name;
    private String hsmType;
    private String mkCheckValue;
    private String sciKeyType;
    private String keyAlgorithm;
    private String blockSize;
    private String keyValue;
    private String checkValue;
    private String extension;

    private String nullEmptyFix(String param){
        if (param==null || param.equals("")){
            param = " ";
        }
        return param;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getKeyType() {
        return keyType;
    }

    public void setKeyType(String keyType) {
        this.keyType = keyType;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getDecimalisationTable() {
        return decimalisationTable;
    }

    public void setDecimalisationTable(String decimalisationTable) {
        this.decimalisationTable = decimalisationTable;
    }

    public String getDecimalisationTableEncryption() {
        return decimalisationTableEncryption;
    }

    public void setDecimalisationTableEncryption(String decimalisationTableEncryption) {
        this.decimalisationTableEncryption = decimalisationTableEncryption;
    }
    
    public String getValidationPattern() {
        return validationPattern;
    }

    public void setValidationPattern(String validationPattern) {
        this.validationPattern = validationPattern;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHsmType() {
        return hsmType;
    }

    public void setHsmType(String hsmType) {
        this.hsmType = hsmType;
    }

    public String getMkCheckValue() {
        return mkCheckValue;
    }

    public void setMkCheckValue(String mkCheckValue) {
        this.mkCheckValue = mkCheckValue;
    }

    public String getSciKeyType() {
        return sciKeyType;
    }

    public void setSciKeyType(String sciKeyType) {
        this.sciKeyType = sciKeyType;
    }

    public String getKeyAlgorithm() {
        return keyAlgorithm;
    }

    public void setKeyAlgorithm(String keyAlgorithm) {
        this.keyAlgorithm = keyAlgorithm;
    }

    public String getBlockSize() {
        return blockSize;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setBlockSize(String blockSize) {
        this.blockSize = blockSize;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }

    public String getCheckValue() {
        return checkValue;
    }

    public void setCheckValue(String checkValue) {
        this.checkValue = checkValue;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    @Override
    public String toString() {
        return "Record: [" +
                "ID=" + getId() +
                ", STATUS=" + getStatus() +
                ", KEYTYPE=" + getKeyType() +
                ", EXPIRYDATE=" + getExpiryDate() +
                ", INDEX=" + getIndex() +
                ", DECIMALISATIONTABLE=" + getDecimalisationTable() +
                ", DECIMALISATIONTABLEENCRYPTION=" + getDecimalisationTableEncryption() +
                ", VALIDATIONPATTERN=" + getValidationPattern() +
                ", NAME=" + getName() +
                ", HSMTYPE=" + getHsmType() +
                ", MKCHECKVALUE=" + getMkCheckValue() +
                ", SCIKEYTYPE=" + getSciKeyType() +
                ", KEYALGORITHM=" + getKeyAlgorithm() +
                ", BLOCKSIZE=" + getBlockSize() +
                ", KEYVALUE=" + getKeyValue() +
                ", CHECKVALUE=" + getCheckValue() +
                ", EXTENSION=" + getExtension() +
                "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final EncryptionKeyDataRecord other = (EncryptionKeyDataRecord) obj;


        if (!this.getId().equals(other.getId())) {
            return false;
        }

        if (!this.getStatus().equals(other.getStatus())) {
            return false;
        }

        if (!this.getKeyType().equals(other.getKeyType())) {
            return false;
        }

        if (!this.getExpiryDate().equals(other.getExpiryDate())) {
            return false;
        }

        if (!this.getIndex().equals(other.getIndex())) {
            return false;
        }

        if (!this.getDecimalisationTable().equals(other.getDecimalisationTable())) {
            return false;
        }

        if (!this.getDecimalisationTableEncryption().equals(other.getDecimalisationTableEncryption())) {
            return false;
        }

        if (!this.getValidationPattern().equals(other.getValidationPattern())) {
            return false;
        }

        if (!this.getName().equals(other.getName())) {
            return false;
        }

        if (!this.getHsmType().equals(other.getHsmType())) {
            return false;
        }

        if (!this.getMkCheckValue().equals(other.getMkCheckValue())) {
            return false;
        }

        if (!this.getSciKeyType().equals(other.getSciKeyType())) {
            return false;
        }

        if (!this.getKeyAlgorithm().equals(other.getKeyAlgorithm())) {
            return false;
        }

        if (!this.getBlockSize().equals(other.getBlockSize())) {
            return false;
        }

        if (!this.getKeyValue().equals(other.getKeyValue())) {
            return false;
        }

        if (!this.getCheckValue().equals(other.getCheckValue())) {
            return false;
        }

        if (!this.getExtension().equals(other.getExtension())) {
            return false;
        }

        return true;
    }


}
