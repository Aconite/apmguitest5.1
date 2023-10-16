package com.aconite.apm.gui.automation.records;

@SuppressWarnings("Annotation")
public class SMSTemplateDataRecord
{
    private String parentinstitution; // for searches on data - not for comparison
    private String id;
    private String name;
    private String institutionName;
    private String templateType;

    private String nullEmptyFix(String param){
        if (param==null || param.equals("")){
            param = " ";
        }
        return param;
    }

    public String getParentInstitution(){ return parentinstitution; }

    public void setParentInstitution(String parentinstitution){ this.parentinstitution = nullEmptyFix(parentinstitution); }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = nullEmptyFix(name);
    }

    public String getInstitutionName(){ return institutionName; }

    public void setInstitutionName(String institutionName){ this.institutionName = nullEmptyFix(institutionName); }

    public String getTemplateType()
    {
        return templateType;
    }

    public void setTemplateType(String templateType)
    {
        this.templateType = nullEmptyFix(templateType);
    }



    @Override
    public String toString()
    {
        return "Record: [ID=" + getId() + ", ISSUERNAME=" + getName() +
                ", INSTITUTIONNAME=" + getInstitutionName() + ", TEMPLATETYPE=" + getTemplateType() + "]";
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

        final SMSTemplateDataRecord other = (SMSTemplateDataRecord) obj;

        if (!this.getId().equals(other.getId()))
        {
            return false;
        }

        if (!this.getName().equals(other.getName()))
        {
            return false;
        }

        if (!this.getInstitutionName().equals(other.getInstitutionName()))
        {
            return false;
        }

        if (!this.getTemplateType().equals(other.getTemplateType()))
        {
            return false;
        }

        return true;
    }
}