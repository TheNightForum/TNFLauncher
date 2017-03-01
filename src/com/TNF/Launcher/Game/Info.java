package com.TNF.Launcher.Game;

public class Info {

	public static String GameTitle = "", JarDir = "", Version = "", VersionURL = "", CreditsURL = "", WebsiteURL = "";
	public static String ChangelogURL = "";
	public static Boolean AutoUpdate, EnableCredits, EnableForceUpdate, EnableWebsite, EnableChangeLog;
	
	public static void main(String GameName){
		ReadGame.main("Game_Title", GameName);
		if (!ReadGame.Result.equals("NUL")) GameTitle = String.valueOf(ReadGame.Result);
		else GameTitle = GameName;
		ReadGame.Result = "";
		
		ReadGame.main("Jar_Dir", GameName);
		if (!ReadGame.Result.equals("NUL")) JarDir = String.valueOf(ReadGame.Result);
		else JarDir = "/bin/"+GameName+".jar";
		ReadGame.Result = "";
		
		ReadGame.main("Version", GameName);
		if (!ReadGame.Result.equals("NUL")) Version = String.valueOf(ReadGame.Result);
		else Version = "NUL";
		ReadGame.Result = "";
		
		ReadGame.main("Version_Url", GameName);
		if (!ReadGame.Result.equals("NUL")) VersionURL = String.valueOf(ReadGame.Result);
		else VersionURL = "Default";
		ReadGame.Result = "";
		
		ReadGame.main("Auto_Update", GameName);
		if (!ReadGame.Result.equals("NUL")) AutoUpdate = Boolean.valueOf(ReadGame.Result);
		else AutoUpdate = true;
		ReadGame.Result = "";
		
		ReadGame.main("Enable_Credits", GameName);
		if (!ReadGame.Result.equals("NUL")) EnableCredits = Boolean.valueOf(ReadGame.Result);
		else EnableCredits = false;
		ReadGame.Result = "";
		
		ReadGame.main("Enable_Force_Update", GameName);
		if (!ReadGame.Result.equals("NUL")) EnableForceUpdate = Boolean.valueOf(ReadGame.Result);
		else EnableForceUpdate = false;
		ReadGame.Result = "";
		
		ReadGame.main("Enable_Website", GameName);
		if (!ReadGame.Result.equals("NUL")) EnableWebsite = Boolean.valueOf(ReadGame.Result);
		else EnableWebsite = false;
		ReadGame.Result = "";
		
		ReadGame.main("Enable_ChangeLog", GameName);
		if (!ReadGame.Result.equals("NUL")) EnableChangeLog = Boolean.valueOf(ReadGame.Result);
		else EnableChangeLog = false;
		ReadGame.Result = "";
		
		ReadGame.main("Credits_URL", GameName);
		CreditsURL = String.valueOf(ReadGame.Result);
		ReadGame.Result = "";
		
		ReadGame.main("Website_URL", GameName);
		WebsiteURL = String.valueOf(ReadGame.Result);
		ReadGame.Result = "";
		
		ReadGame.main("ChangeLog_URL", GameName);
		ChangelogURL = String.valueOf(ReadGame.Result);
		ReadGame.Result = "";
	}
}
