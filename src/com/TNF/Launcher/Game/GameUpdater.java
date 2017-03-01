package com.TNF.Launcher.Game;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.TNF.Launcher.utils.AppOutput;
import com.TNF.Launcher.utils.Connection;
import com.TNF.Launcher.utils.Data;

public class GameUpdater {

	public static void main(String GameName){
		if(Info.VersionURL.equals("Default")){
			Info.VersionURL.equals(Data.BaseUrl + "Games/" + GameName + "/version");
		}
		isClientUpToDate();
		getLatestGameVersion();
	}
	
	private static int isClientUpToDate() {
		String lVersion = getLatestGameVersion();
		return lVersion.equals("Could not connect to webserver.") ? -1:Info.Version.equalsIgnoreCase(getLatestGameVersion()) ? 0:1;
	}
	
	private static String getLatestGameVersion() {
		try {
			Connection c = new Connection(new URL(Info.VersionURL));
			c.createConnection();
			for(String s : c.readURL()) {
				return s.trim();
			}
		} catch (MalformedURLException ex) {
			AppOutput.printLine("Could not connect to WebServer!", AppOutput.ERROR);
			return "Could not connect to WebServer";
		} catch (IOException ex) {
			AppOutput.printLine("Could not connect to WebServer!", AppOutput.ERROR);
			return "Could not connect to WebServer";
		}
		return Info.Version;
	}
}
