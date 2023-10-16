package com.aconite.apm.gui.automation.utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import org.apache.commons.lang.StringUtils;

public class LogUtils
{
    private static String logPath;
    private static String logName;
    private static File logFile;

    public static void setLogPath(String path){
       LogUtils.logPath = path;
    }

    public static String getLogPath(){
        return logPath;
    }

    public static void setLogName(String fileName){
        LogUtils.logName = fileName;
    }

    public static String getLogName(){
        return logName;
    }

    public static void logWrite(String input) throws Exception{

//        System.out.println("In logWrite=>" + input);

        FileWriter fw = new FileWriter(getLogPath() + "\\" + getLogName(), true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw);
        out.println(input);
        out.close();

        out = null;
        bw = null;
        fw = null;

    }

    public static void logTS(String stepName, String stepStatus, String stepDetail) throws Exception{

//        System.out.println("In logWrite=>" + input);

        FileWriter fw = new FileWriter(getLogPath() + "\\" + getLogName(), true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw);
        out.println("\n");
        out.println(StringUtils.repeat("-".toString(), 80));
        out.println("TEST STEP: " + stepName + "\t\t\t" + stepStatus);
        out.println(StringUtils.repeat("-".toString(), 80));
        out.println(stepDetail + "\n");
        out.close();

        out = null;
        bw = null;
        fw = null;

    }

}