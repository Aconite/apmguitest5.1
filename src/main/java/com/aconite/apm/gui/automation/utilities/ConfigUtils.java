package com.aconite.apm.gui.automation.utilities;

import java.util.Properties;
import java.io.IOException;

public class ConfigUtils
{
    public static String cfgProperty(String propertyName){

        Properties prop = new Properties();
        try{
            prop.load(DatabaseConnection.class.getClassLoader().getResourceAsStream("config.properties"));
        }
        catch (IOException iox){
            iox.printStackTrace();
        }

        if(prop.getProperty(propertyName) != null) {
            return (prop.getProperty(propertyName));
        }
        else{
            System.out.println("ConfigUtils Warning: " + propertyName + " not found");
            return (propertyName + " not found");
        }

    }

}





