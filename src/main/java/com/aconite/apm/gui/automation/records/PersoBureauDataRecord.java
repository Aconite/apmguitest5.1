package com.aconite.apm.gui.automation.records;

public class PersoBureauDataRecord {

    private String id;
    private String name;
    private String code;
    private String destinationDirectory;
    private String encryptionZone;
    private String extractPan;
    private String extractPanDisplay;

    private String nullEmptyFix(String param){
        if (param==null || param.equals("")){
            param = " ";
        }
        return param;
    }

    private String setToTrueFalse(String param){
        if(param!=null) {
            if (param.equals("Y") || param.equals("A")) {
                param = "true";
            }
            if (param.equals("I") || param.equals("N")) {
                param = "false";
            }
        }
        return param;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDestinationDirectory() {
        return destinationDirectory;
    }

    public void setDestinationDirectory(String destinationDirectory) {
        this.destinationDirectory = destinationDirectory;
    }

    public String getEncryptionZone() {
        return encryptionZone;
    }

    public void setEncryptionZone(String encryptionZone) {
        this.encryptionZone = encryptionZone;
    }

    public String getExtractPan() {
        return extractPan;
    }

    public void setExtractPan(String extractPan) {
        this.extractPan = setToTrueFalse(extractPan);
    }

    public String getExtractPanDisplay() {
        return extractPanDisplay;
    }

    public void setExtractPanDisplay(String extractPanDisplay) {
        this.extractPanDisplay = setToTrueFalse(extractPanDisplay);
    }

    @Override
    public String toString() {
        return "Record: [" +
                "ID=" + getId() +
                ", NAME=" + getName() +
                ", CODE=" + getCode() +
                ", DESTINATIONDIRECTORY=" + getDestinationDirectory() +
                ", ENCRYPTIONZONE=" + getEncryptionZone() +
                ", EXTRACTPAN=" + getExtractPan() +
                ", EXTRACTPANDISPLAY=" + getExtractPanDisplay() +
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

        final PersoBureauDataRecord other = (PersoBureauDataRecord) obj;


        if (!this.getId().equals(other.getId())) {
            return false;
        }

        if (!this.getName().equals(other.getName())) {
            return false;
        }

        if (!this.getCode().equals(other.getCode())) {
            return false;
        }

        if (!this.getDestinationDirectory().equals(other.getDestinationDirectory())) {
            return false;
        }

        if (!this.getEncryptionZone().equals(other.getEncryptionZone())) {
            return false;
        }

        if (!this.getExtractPan().equals(other.getExtractPan())) {
            return false;
        }

        if (!this.getExtractPanDisplay().equals(other.getExtractPanDisplay())) {
            return false;
        }

        return true;
    }

}
