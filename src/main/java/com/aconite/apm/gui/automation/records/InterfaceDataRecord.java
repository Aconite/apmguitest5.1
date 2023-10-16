package com.aconite.apm.gui.automation.records;

public class InterfaceDataRecord {

    private String id;
    private String name;
    private String type;
    private String institution;
    private String encryptionZone;
    private String host;
    private String port;
    private String timeout;
    private String ssl;
    private String keystorePath;
    private String keystorePassword;
    private String certificateAlias;
    private String keyPassword;
    private String context;
    private String username;
    private String password;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getEncryptionZone() {
        return encryptionZone;
    }

    public void setEncryptionZone(String encryptionZone) {
        this.encryptionZone = encryptionZone;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getTimeout() {
        return timeout;
    }

    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    public String getSsl() {
        return ssl;
    }

    public void setSsl(String ssl) {
        this.ssl = setToTrueFalse(ssl);
    }

    public String getKeystorePath() {
        return keystorePath;
    }

    public void setKeystorePath(String keystorePath) {
        this.keystorePath = nullEmptyFix(keystorePath);
    }

    public String getKeystorePassword() {
        return keystorePassword;
    }

    public void setKeystorePassword(String keystorePassword) {
        this.keystorePassword = keystorePassword;
    }

    public String getCertificateAlias() {
        return certificateAlias;
    }

    public void setCertificateAlias(String certificateAlias) {
        this.certificateAlias = nullEmptyFix(certificateAlias);
    }

    public String getKeyPassword() {
        return keyPassword;
    }

    public void setKeyPassword(String keyPassword) {
        this.keyPassword = keyPassword;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = nullEmptyFix(context);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Record: [" +
                "ID=" + getId() +
                ", NAME=" + getName() +
                ", TYPE=" + getType() +
                ", INSTITUTION=" + getInstitution() +
                ", ENCRYPTIONZONE=" + getEncryptionZone() +
                ", HOST=" + getHost() +
                ", PORT=" + getPort() +
                ", TIMEOUT=" + getTimeout() +
                ", SSL=" + getSsl() +
                ", KEYSTOREPATH=" + getKeystorePath() +
//                ", KEYSTOREPASSWORD=" + getKeystorePassword() +
                ", CERTIFICATEALIAS=" + getCertificateAlias() +
//                ", KEYPASSWORD=" + getKeyPassword() +
                ", CONTEXT=" + getContext() +
                ", USERNAME=" + getUsername() +
//                ", PASSWORD=" + getPassword() +
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

        final InterfaceDataRecord other = (InterfaceDataRecord) obj;


        if (!this.getId().equals(other.getId())) {
            return false;
        }

        if (!this.getName().equals(other.getName())) {
            return false;
        }

        if (!this.getType().equals(other.getType())) {
            return false;
        }

        if (!this.getInstitution().equals(other.getInstitution())) {
            return false;
        }

        if (!this.getEncryptionZone().equals(other.getEncryptionZone())) {
            return false;
        }

        if (!this.getHost().equals(other.getHost())) {
            return false;
        }

        if (!this.getPort().equals(other.getPort())) {
            return false;
        }

        if (!this.getTimeout().equals(other.getTimeout())) {
            return false;
        }

        if (!this.getSsl().equals(other.getSsl())) {
            return false;
        }

        if (!this.getKeystorePath().equals(other.getKeystorePath())) {
            return false;
        }

//        if (!this.getKeystorePassword().equals(other.getKeystorePassword())) {
//            return false;
//        }

        if (!this.getCertificateAlias().equals(other.getCertificateAlias())) {
            return false;
        }

//        if (!this.getKeyPassword().equals(other.getKeyPassword())) {
//            return false;
//        }

        if (!this.getContext().equals(other.getContext())) {
            return false;
        }

        if (!this.getUsername().equals(other.getUsername())) {
            return false;
        }

//        if (!this.getPassword().equals(other.getPassword())) {
//            return false;
//        }

        return true;
    }

}
