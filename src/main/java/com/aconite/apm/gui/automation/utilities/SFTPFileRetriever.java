package com.aconite.apm.gui.automation.utilities;

import com.jcraft.jsch.*;
import java.util.Vector;

public class SFTPFileRetriever
{
   private static Session jschSession;

    private static ChannelSftp setupJsch() throws JSchException
    {
        String remoteHost;
        String username;
        String password;

        remoteHost = ConfigUtils.cfgProperty("sftp_host");
        username = ConfigUtils.cfgProperty("sftp_username");
        System.out.println("Get Session: " + username + "@" + remoteHost);

//DP
        password = ConfigUtils.cfgProperty("sftp_password");

        JSch jsch = new JSch();
        jsch.setConfig("StrictHostKeyChecking", "no");
        jschSession = jsch.getSession(username, remoteHost);
        jschSession.setPassword(password);

        jschSession.connect();

        System.out.println("JSCH Connect: " + jschSession.isConnected());

        return (ChannelSftp) jschSession.openChannel("sftp");
    }

    public static void downloadFile(String remoteFilePath, String remoteFileName, String localFilePath) throws JSchException, SftpException
    {
        System.out.println("Attempting to download " + remoteFilePath + "\\" + remoteFileName + " to " + localFilePath);
        ChannelSftp channelSftp = setupJsch();
        channelSftp.connect();
        System.out.println("Current Remote Directory: " + channelSftp.pwd());
        System.out.println("Change Remote Directory to : " + "/" + remoteFilePath);
        channelSftp.cd("/" + remoteFilePath);//"/C:/PinManager/files/abc/extract/output/"
        System.out.println("Current Remote Directory: " + channelSftp.pwd());
        System.out.println("Current Local Directory: " + channelSftp.lpwd());

        channelSftp.get(remoteFileName, localFilePath);

        channelSftp.exit();
        jschSession.disconnect();
    }

    public static void uploadFile(String remoteFilePath, String localFilePath) throws JSchException, SftpException
    {
        ChannelSftp channelSftp = setupJsch();
        channelSftp.connect();

        System.out.println("Upload to Remote Directory: " + remoteFilePath);
        System.out.println("Upload from Local Directory: " + localFilePath);

        channelSftp.put(localFilePath, remoteFilePath);

        channelSftp.exit();
        jschSession.disconnect();
    }

    public static String downloadAndDeleteFile(String remoteFilePath, String localFilePath) throws JSchException, SftpException
    {
        String outfile = null;

        ChannelSftp channelSftp = setupJsch();
        channelSftp.connect();
//        System.out.println("Current Remote Directory: " + channelSftp.pwd());
//        System.out.println("Change Remote Directory to : " + "/" + remoteFilePath);
//        System.out.println("Attempting to connect to " + remoteFilePath);
        channelSftp.cd("/" + remoteFilePath);//"/C:/PinManager/files/abc/extract/output/"
//        System.out.println("Current Remote Directory: " + channelSftp.pwd());
//        System.out.println("Current Local Directory: " + channelSftp.lpwd());

        Vector<ChannelSftp.LsEntry> list = channelSftp.ls("*.*");
        for(ChannelSftp.LsEntry entry:list) {
            outfile = entry.getFilename();
            channelSftp.get(entry.getFilename(), localFilePath);
            channelSftp.rm(entry.getFilename());
        }

        channelSftp.exit();
        jschSession.disconnect();

        return(outfile);

    }

    public static boolean sftpFileExists(String remoteFilePath, String fileName) throws Exception{

        Vector<ChannelSftp.LsEntry> list;
        boolean fExist = false;

        ChannelSftp channelSftp = setupJsch();
        channelSftp.connect();
        channelSftp.cd("/" + remoteFilePath);

        try {
            list = channelSftp.ls(fileName);
            if (list.size() > 0){
                fExist = true;
            }
        } catch (SftpException e){
            if(e.id != ChannelSftp.SSH_FX_NO_SUCH_FILE){
                throw e;
            }
        }

        return(fExist);
    }


}
