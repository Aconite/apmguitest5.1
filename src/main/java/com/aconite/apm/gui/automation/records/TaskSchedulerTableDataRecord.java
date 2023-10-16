package com.aconite.apm.gui.automation.records;

public class TaskSchedulerTableDataRecord
{
    private String id;
    private String rowNumber;
    private String name;
    private String active;
    private String lastRun;
    private String nextRun;
    private String issuer;

    private String nullEmptyFix(String param){
        if (param==null || param.equals("") || param.equals("\u00A0")){
            param = " ";
        }
        return param;
    }

    private String setToTrueFalse(String param){
        if (param.equals("Y") || param.equals("A")){
            param = "true";
        }
        if (param.equals("N")){
            param = "true";
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

    public String getRowNumber() { return rowNumber; }

    public void setRowNumber(String rowNumber) { this.rowNumber = rowNumber; }

    public String getName()
    {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public String getActive()
    {
        return active;
    }

    public void setActive(String active) { this.active = setToTrueFalse(active); }

    public String getLastRun() { return lastRun; }

    public void setLastRun(String lastRun) { this.lastRun = setToTrueFalse(lastRun); }

    public String getNextRun() { return nextRun; }

    public void setNextRun(String nextRun) { this.nextRun = setToTrueFalse(nextRun); }

    public String getIssuer()
    {
        return issuer;
    }

    public void setIssuer(String issuer) { this.issuer = issuer; }


    @Override
    public String toString()
    {
        return "Record: [ID=" + getId() + ", NAME=" + getName() + ", ACTIVE=" + getActive() +
                ", LASTRUN=" + getLastRun() + ", NEXTRUN=" + getNextRun() +
                ", ISSUER=" + getIssuer() + "]";
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

        final TaskSchedulerTableDataRecord other = (TaskSchedulerTableDataRecord) obj;

        if (!this.getId().equals(other.getId()))
        {
            return false;
        }

        if (!this.getName().equals(other.getName()))
        {
            return false;
        }

        if (!this.getActive().equals(other.getActive()))
        {
            return false;
        }

        if (!this.getLastRun().equals(other.getLastRun()))
        {
            return false;
        }

        if (!this.getNextRun().equals(other.getNextRun()))
        {
            return false;
        }

        if (!this.getIssuer().equals(other.getIssuer()))
        {
            return false;
        }

        return true;
    }
}