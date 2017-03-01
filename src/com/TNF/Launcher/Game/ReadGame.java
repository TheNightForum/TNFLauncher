package com.TNF.Launcher.Game;

import java.io.*;
import java.util.Properties;

import com.TNF.Launcher.utils.Data;

/**
 * Created by Brayden on 1/12/2016.
 */
public class ReadGame {

    public static String Result = "";

    public static String main(String string, String name){
        Properties prop = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream(Data.locationGames + name  + "/config.properties");

            // load a properties file
            prop.load(input);
            if(prop.getProperty(string) != null){
            	Result = prop.getProperty(string);
            }else{
            	Result = "NUL";
            }

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
