package com.aconite.apm.gui.automation.webpages;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser
{
    private static int underThreshold = 0;
    private static int overThreshold = 0;
    private static int threshold = 1500;

    private static final Pattern START_PATTERN = Pattern.compile("([0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2},[0-9]{3}) DEBUG \\[(.*)] org.springframework.security.authentication.ProviderManager: Authentication attempt using org.springframework.security.ldap.authentication.LdapAuthenticationProvider");
    private static final Pattern STOP_PATTERN = Pattern.compile("([0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2},[0-9]{3}) DEBUG \\[(.*)] org.eclipse.jetty.server.Server: RESPONSE /ws  200 handled=true");

    private static final int TIME_GROUP = 1;
    private static final int THREAD_NAME_GROUP = 2;

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");

    //Map of: ThreadName -> StartTime
    private static Map<String, Long> jobsInProgressMap = new HashMap<>();

    public static void main(String[] args) throws Exception
    {

        File dir1 = new File("C:\\temp\\pin_logs\\prod_pingmanage_logs\\Core\\Node1");
        File dir2 = new File("C:\\temp\\pin_logs\\prod_pingmanage_logs\\Core\\Node3");

        File[] directoryListing1 = dir1.listFiles();
        File[] directoryListing2 = dir2.listFiles();

        assert directoryListing1 != null;
        assert directoryListing2 != null;

        Arrays.sort(directoryListing1, Comparator.comparingLong(File::lastModified));
        Arrays.sort(directoryListing2, Comparator.comparingLong(File::lastModified));

//        File file = new File("C:\\temp\\pin_logs\\prod_pingmanage_logs\\Core\\Node2\\PinManagerCore_DBPIBMWAS04Node01.log.9");
//        parse(file);

        for (File child : directoryListing1)
        {
            parse(child);

            System.out.println("Processing file: " + child.toString());
            System.out.println("Running total of transactions that were under " + threshold + " milliseconds = " +underThreshold);
            System.out.println("Running total of transactions that were over " + threshold + " milliseconds = " +overThreshold);
            System.out.println();
        }

        for (File child : directoryListing2)
        {
            parse(child);

            System.out.println("Processing file: " + child.toString());
            System.out.println("Running total of transactions that were under " + threshold + " milliseconds = " +underThreshold);
            System.out.println("Running total of transactions that were over " + threshold + " milliseconds = " +overThreshold);
            System.out.println();
        }

        System.out.println("===========================SUMMARY======================================");
        System.out.println("Total number of transactions that were under " + threshold + " milliseconds = " +underThreshold );
        System.out.println("Total number of transactions that were over " + threshold + " milliseconds = " +overThreshold );
        System.out.println("=========================================================================");
    }


    private static void parse(File file) throws Exception
    {
        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String line;
            while ((line = br.readLine()) != null)
            {
                processLine(line);
            }
        }
    }

    private static void processLine(String line) throws Exception
    {
        Matcher m = START_PATTERN.matcher(line);
        if (m.matches())
        {
            String logTimeStr = m.group(TIME_GROUP);
            long logTime = DATE_FORMAT.parse(logTimeStr).getTime();
            String threadName = m.group(THREAD_NAME_GROUP);

            processStartTime(logTime, threadName);
        }
        else
        {
            m = STOP_PATTERN.matcher(line);
            if (m.matches())
            {
                String logTimeStr = m.group(TIME_GROUP);
                long logTime = DATE_FORMAT.parse(logTimeStr).getTime();
                String threadName = m.group(THREAD_NAME_GROUP);

                processStopTime(logTime, threadName);
            }
        }
    }

    private static void processStartTime(long time, String threadName)
    {
        Long oldTime = jobsInProgressMap.put(threadName, time);
        if (oldTime != null)
        {
            System.out.println("OOPS - thread " + threadName + " seems to be processing multiple jobs at once!");
        }
    }

    private static void processStopTime(long time, String threadName)
    {
        Long startTime = jobsInProgressMap.remove(threadName);
        if (startTime == null)
        {
            System.out.println("OOPS - thread " + threadName + " completed a job which never seemed to be started!");
        }
        else
        {
            long timeTaken = time - startTime;

//            System.out.println("Thread " + threadName + " processed a job which took " + timeTaken + " ms");

            if (timeTaken <= threshold)
            {
                underThreshold++;
            }
            else
            {
                overThreshold ++;
            }
        }
    }
}
