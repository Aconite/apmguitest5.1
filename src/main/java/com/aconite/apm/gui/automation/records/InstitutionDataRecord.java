package com.aconite.apm.gui.automation.records;

@SuppressWarnings("Annotation")
public class InstitutionDataRecord
{
    private String id;
    private String institutionName;
    private String localZone;
    private String institutionZone;
    private String interfaceZone;
    private String maxVppPinIdSeconds;

    private String nullEmptyFix(String param){
        if (param==null || param.equals("")){
            param = " ";
        }
        return param;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getInstitutionName()
    {
        return institutionName;
    }

    public void setInstitutionName(String institutionName)
    {
        this.institutionName = nullEmptyFix(institutionName);
    }

    public String getLocalZone()
    {
        return localZone;
    }

    public void setLocalZone(String localZone)
    {
        this.localZone = nullEmptyFix(localZone);
    }

    public String getInstitutionZone()
    {
        return institutionZone;
    }

    public void setInstitutionZone(String institutionZone)
    {
        this.institutionZone = nullEmptyFix(institutionZone);
    }

    public String getInterfaceZone()
    {
        return interfaceZone;
    }

    public void setInterfaceZone(String interfaceZone)
    {
        this.interfaceZone = nullEmptyFix(interfaceZone);
    }

    public String getMaxVppPinIdSeconds()
    {
        return maxVppPinIdSeconds;
    }

    public void setMaxVppPinIdSeconds(String maxVppPinIdSeconds)
    {
        this.maxVppPinIdSeconds =nullEmptyFix(maxVppPinIdSeconds);
    }

    @Override
    public String toString()
    {
        return "Record: [ID=" + getId() + ", INSTITUTIONNAME=" + getInstitutionName() +
                ", LOCALZONE=" + getLocalZone() + ", INSTITUTIONZONE=" + getInstitutionZone() +
                ", INTERFACEZONE=" + getInterfaceZone() +
                ", MAXVPPPINIDSECONDS=" + getMaxVppPinIdSeconds() + "]";
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }

        if (obj.getClass() != this.getClass())
        {
            return false;
        }

        final InstitutionDataRecord other = (InstitutionDataRecord) obj;

        if (!this.getId().equals(other.getId()))
        {
            return false;
        }

        if (!this.getInstitutionName().equals(other.getInstitutionName()))
        {
            return false;
        }

        if (!this.getLocalZone().equals(other.getLocalZone()))
        {
            return false;
        }

        if (!this.getInstitutionZone().equals(other.getInstitutionZone()))
        {
            return false;
        }

        if (!this.getInterfaceZone().equals(other.getInterfaceZone()))
        {
            return false;
        }

        if (!this.getMaxVppPinIdSeconds().equals(other.getMaxVppPinIdSeconds()))
        {
            return false;
        }

        return true;
    }
}