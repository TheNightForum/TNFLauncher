package com.TNF.Launcher.config;


import java.io.*;
import java.util.Properties;

import com.TNF.Launcher.utils.Data;

/**
 * Created by Brayden on 1/12/2016.
 */
public class ReadGeneral {

    public static String Result = "";

    public static String main(String string){
        Properties prop = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream(Data.locationConfigs + "config.properties");

            // load a properties file
            prop.load(input);

            Result = prop.getProperty(string);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return string;
    }
}
