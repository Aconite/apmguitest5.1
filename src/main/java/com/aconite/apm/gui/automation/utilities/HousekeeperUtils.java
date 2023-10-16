package com.aconite.apm.gui.automation.utilities;

import java.util.*;
import java.io.*;
import java.util.List;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;


public class HousekeeperUtils
{


    private void getGUIPropertiesFile() throws SftpException, JSchException {

        String outputFilePath = ConfigUtils.cfgProperty("local_folder");

        String srcFolder = ConfigUtils.cfgProperty("gui_config_folder");
        String srcFileName = "gui.properties";

        SFTPFileRetriever.downloadFile(srcFolder, srcFileName, outputFilePath);
    }

    public static List<String> getHousekeeperTaskList() throws SftpException, JSchException {

        HousekeeperUtils housekeeperUtils = new HousekeeperUtils();
        housekeeperUtils.getGUIPropertiesFile();

        List<String> housekeeperInterimTaskList = new ArrayList<>();
        List<String> housekeeperTaskList = new ArrayList<>();

        File file =new File(ConfigUtils.cfgProperty("local_folder") + "\\gui.properties");
        Scanner in;

        try {
            in = new Scanner(file);
            while(in.hasNext())
            {
                String line=in.nextLine();
                if(line.contains("_task") && !line.startsWith("#")) {
//                    System.out.println(line);
                    housekeeperInterimTaskList.add(line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Collections.sort(housekeeperInterimTaskList);

        for (int iCounter = 0; iCounter<housekeeperInterimTaskList.size() ; iCounter++){

            String[] hTaskDetail = housekeeperInterimTaskList.get(iCounter).split("=");

            if (iCounter < housekeeperInterimTaskList.size() - 1 && hTaskDetail[0].contains("task.name") && housekeeperInterimTaskList.get(iCounter+1).contains("task.param")){
                String[] hTaskDetail1 = housekeeperInterimTaskList.get(iCounter+1).split("=");
                housekeeperTaskList.add(hTaskDetail[1] + "(" + hTaskDetail1[1] + ")");
            }
            else if(hTaskDetail[0].contains("task.name")){
                housekeeperTaskList.add(hTaskDetail[1]);
            }

        }

        return(housekeeperTaskList);

    }

}