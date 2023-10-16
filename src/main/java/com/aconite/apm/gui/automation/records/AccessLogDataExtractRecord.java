package com.aconite.apm.gui.automation.records;

public class AccessLogDataExtractRecord
{
    private String id;
    private String dateTime;
    private String userName;
    private String originator;
    private String description;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getDateTime()
    {
        return dateTime;
    }

    public void setDateTime(String dateTime)
    {
        this.dateTime = dateTime;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getOriginator()
    {
        return originator;
    }

    public void setOriginator(String originator)
    {
        this.originator = originator;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    @Override
    public String toString()
    {
        return "Record: [ID=" + getId() + ", DATETIME=" + getDateTime() + ", USERNAME=" + getUserName() + ", ORIGINATOR=" + getOriginator() + ", DESCRIPTION=" +
                getDescription() + "]";
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

        final AccessLogDataExtractRecord other = (AccessLogDataExtractRecord) obj;

        if (!this.getId().equals(other.getId()))
        {
            return false;
        }

        if (!this.dateTime.equals(other.dateTime))
        {
            return false;
        }

        if (!this.userName.equals(other.userName))
        {
            return false;
        }

        if (!this.originator.equals(other.originator))
        {
            return false;
        }

        if (!this.description.equals(other.description))
        {
            return false;
        }

        return true;
    }
}
