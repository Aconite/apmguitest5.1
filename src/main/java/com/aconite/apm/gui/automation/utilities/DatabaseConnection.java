package com.aconite.apm.gui.automation.utilities;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection
{
    public static Connection getConnection()
    {
        String host;
        String port;
        String sid;
        String username;
        String password;
        Connection connection = null;

        try
        {
            host = ConfigUtils.cfgProperty("db_host");
            port = ConfigUtils.cfgProperty("db_port");
            sid = ConfigUtils.cfgProperty("db_sid");
            username = ConfigUtils.cfgProperty("db_username");
            password = ConfigUtils.cfgProperty("db_password");

            String dbURL = "jdbc:oracle:thin:@" + host + ":" + port + "/" + sid;
//            System.out.println("Connecting to: " + dbURL);
            connection = DriverManager.getConnection(dbURL, username, password);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return connection;
    }
}
