package com.TNF.Launcher.Game;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.TNF.Launcher.utils.AppOutput;
import com.TNF.Launcher.utils.Data;

public class Launch {

	public static void main(String GameName, Boolean isSelfUpdate){
		if(!isSelfUpdate){
			File game = new File(Data.locationGames + GameName);
	        final ProcessBuilder pb = new ProcessBuilder(new String[] { getJavaProgramFile(), "-jar", String.valueOf(game) + String.valueOf(Info.JarDir)});
	        pb.directory(new File(String.valueOf(game)));
	        try {
	            pb.inheritIO();
	            pb.start();
	            //TODO: Just hide the window.
	            System.exit(0);
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
		}else{
			File game = new File(Data.locationBin + File.separator);
			AppOutput.printLine(String.valueOf(game), AppOutput.WARNING);
			final List<String> arguments = new ArrayList<>();
	        arguments.add(getJavaProgramFile());
	        arguments.add("-jar");
	        arguments.add("Launcher.jar");
	        AppOutput.printLine(String.valueOf(arguments));
			try {
				final ProcessBuilder pb = new ProcessBuilder();
				pb.command(arguments);
				pb.directory(game);
				pb.start();
				System.exit(0);
			} catch (IOException | RuntimeException e) {
				AppOutput.printLine("Failed to restart launcher process after update!", AppOutput.ERROR);
				System.exit(1);
			}
		}
	}
	
	private static String getJavaProgramFile() {
        return System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
	}
}
