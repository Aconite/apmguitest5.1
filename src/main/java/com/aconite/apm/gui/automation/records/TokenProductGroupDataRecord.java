package com.aconite.apm.gui.automation.records;

@SuppressWarnings("Annotation")
public class TokenProductGroupDataRecord
{
    private String parentInstitution;// for searches on data - not for comparison
    private String parentIssuer;// for searches on data - not for comparison
    private String id;
    private String name;
    private String issuer;
    private String groupCode;


    private String nullEmptyFix(String param){
        if (param==null || param.equals("")){
            param = " ";
        }
        return param;
    }

    public String getParentInstitution()
    {
        return parentInstitution;
    }

    public void setParentInstitution(String parentInstitution)
    {
        this.parentInstitution = parentInstitution;
    }

    public String getParentIssuer()
    {
        return parentIssuer;
    }

    public void setParentIssuer(String parentIssuer)
    {
        this.parentIssuer = parentIssuer;
    }

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

    public String getIssuer()
    {
        return issuer;
    }

    public void setIssuer(String issuer)
    {
        this.issuer = nullEmptyFix(issuer);
    }

    public String getGroupCode()
    {
        return groupCode;
    }

    public void setGroupCode(String groupCode)
    {
        this.groupCode = nullEmptyFix(groupCode);
    }



    @Override
    public String toString()
    {
        return "Record: [ID=" + getId() + ", TOKENPRODUCTGROUPNAME=" + getName() +
                ", ISSUER=" + getIssuer() + ", GROUPCODE=" + getGroupCode() + "]";
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

        final TokenProductGroupDataRecord other = (TokenProductGroupDataRecord) obj;

        if (!this.getId().equals(other.getId()))
        {
            return false;
        }

        if (!this.getName().equals(other.getName()))
        {
            return false;
        }

        if (!this.getIssuer().equals(other.getIssuer()))
        {
            return false;
        }

        if (!this.getGroupCode().equals(other.getGroupCode()))
        {
            return false;
        }

        return true;
    }
}