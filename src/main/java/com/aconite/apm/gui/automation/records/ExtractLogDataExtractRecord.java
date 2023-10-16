package com.aconite.apm.gui.automation.records;

import java.sql.SQLOutput;

public class ExtractLogDataExtractRecord
{
    private String id;
    private String originator;
    private String extractTypeId;
    private String startDateTime;
    private String finishDateTime;
    private String idFrom;
    private String idTo;
    private String datetimeFrom;
    private String datetimeTo;
    private String status;
    private String files;
    private String issuerId;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getOriginator()
    {
        return originator;
    }

    public void setOriginator(String originator)
    {
        this.originator = originator;
    }

    public String getExtractTypeId()
    {
        return extractTypeId;
    }

    public void setExtractTypeId(String extractTypeId)
    {
        this.extractTypeId = extractTypeId;
    }

    public String getStartDateTime()
    {
        return startDateTime;
    }

    public void setStartDateTime(String startDateTime)
    {
        this.startDateTime = startDateTime;
    }

    public String getFinishDateTime()
    {
        return finishDateTime;
    }

    public void setFinishDateTime(String finishDateTime)
    {
        this.finishDateTime = finishDateTime;
    }

    public String getIdFrom()
    {
        return idFrom;
    }

    public void setIdFrom(String idFrom)
    {
        this.idFrom = idFrom;
    }

    public String getIdTo()
    {
        return idTo;
    }

    public void setIdTo(String idTo)
    {
        this.idTo = idTo;
    }

    public String getDateTimeFrom()
    {
        return datetimeFrom;
    }

    public void setDateTimeFrom(String datetimeFrom)
    {
        this.datetimeFrom = datetimeFrom;
    }

    public String getDateTimeTo()
    {
        return datetimeTo;
    }

    public void setDateTimeTo(String datetimeTo)
    {
        this.datetimeTo = datetimeTo;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getFiles()
    {
        return files;
    }

    public void setFiles(String files)
    {
        this.files = files;
    }

    public String getIssuerId()
    {
        return issuerId;
    }

    public void setIssuerId(String issuerId)
    {
        this.issuerId = issuerId;
    }

    @Override
    public String toString()
    {
        return "Record: [ID=" + getId() + ", ORIGINATOR=" + getOriginator() + ", EXTRACT_TYPE_ID=" + getExtractTypeId() +
                ", START_DATETIME=" + getStartDateTime() + ", FINISH_DATETIME=" + getFinishDateTime() +
                ", ID_FROM=" + getIdFrom() + ", ID_To=" + getIdTo() +
                ", DATETIME_FROM=" + getDateTimeFrom() + ", DATETIME_To=" + getDateTimeTo() +
                ", STATUS=" + getStatus() + ", FILES=" + getFiles() +
                ", ISSUER_ID=" + getIssuerId() + "]";
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

        final ExtractLogDataExtractRecord other = (ExtractLogDataExtractRecord) obj;

        if (!this.getId().equals(other.getId()))
        {
            return false;
        }

        if (!this.originator.equals(other.getOriginator()))
        {
            return false;
        }

        if (!this.extractTypeId.equals(other.getExtractTypeId()))
        {
            return false;
        }

        if (!this.startDateTime.equals(other.getStartDateTime()))
        {
            return false;
        }

        if (!this.finishDateTime.equals(other.getFinishDateTime()))
        {
            return false;
        }

        if (!this.idFrom.equals(other.getIdFrom()))
        {
            return false;
        }
        if (!this.idTo.equals(other.getIdTo()))
        {
            return false;
        }
        if (!this.datetimeFrom.equals(other.getDateTimeFrom()))
        {
            return false;
        }
        if (!this.datetimeTo.equals(other.getDateTimeTo()))
        {
            return false;
        }
        if (!this.status.equals(other.getStatus()))
        {
            return false;
        }
        if (!this.files.equals(other.getFiles()))
        {
            return false;
        }
        if (!this.issuerId.equals(other.getIssuerId()))
        {
            return false;
        }


        return true;
    }
}
