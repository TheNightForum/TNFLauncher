package com.TNF.Launcher.config;

import java.io.*;
import java.util.Properties;

import com.TNF.Launcher.Main;
import com.TNF.Launcher.utils.Data;

/**
 * Created by Brayden on 1/12/2016.
 */
public class WriteGeneral {

    public static final String FirstTime = "First_Time";
    public static final String Version = "Version";
    public static final String AnyInstalled = "Any_Installed";

    public static void main(String String1, String String2 ) {
        OutputStream out = null;
        try {

            Properties props = new Properties();

            File f = new File(Data.locationConfigs + "config.properties");
            if (f.exists()) {

                props.load(new FileReader(f));

                props.setProperty(String1, String2);
            } else {
                props.setProperty(FirstTime, "True");
                props.setProperty(Version, String.valueOf(Main.VERSION));
                props.setProperty(AnyInstalled, "False");

                f.createNewFile();
            }


            out = new FileOutputStream(f);
            props.store(out, "Please do not manually edit this file.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (out != null) {

                try {

                    out.close();
                } catch (IOException ex) {

                    System.out.println("IOException: Could not close config.properties output stream; " + ex.getMessage());
                    ex.printStackTrace();
                }
            }
        }
    }
}
