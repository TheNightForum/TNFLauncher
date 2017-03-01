package com.TNF.Launcher.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

import com.TNF.Launcher.Main;
import com.TNF.Launcher.config.WriteGeneral;

public class Worker {

	/**
	 * This method is for downloading the game from the server
	 * after it has been verified to be a game.
	 * @param GameName
	 */
	public static void Download(String GameName){
		File f = new File(Data.locationGames + GameName);
		if (!f.exists()){
			f.mkdirs();
			AppOutput.printLine("Downloading " + GameName + "...");
			try(
					ReadableByteChannel in=Channels.newChannel(
							  
					new URL(Data.BaseUrl + "Games/" + GameName + "/" + GameName +".zip").openStream());	
					FileChannel out=new FileOutputStream(Data.locationTemp + GameName + ".zip").getChannel() ) {
					out.transferFrom(in, 0, Long.MAX_VALUE);
				}
				catch(IOException ex){
					AppOutput.printLine("Could not download sprites.", AppOutput.ERROR);
				}
				AppOutput.printLine("Unziping game files...");
				UnZip.main(Data.locationTemp + GameName + ".zip", Data.locationGames + "/" + GameName);
				Do(GameName);
		}else{
			f.delete();
			Download(GameName);
		}
	}
	
	/**
	 * This method writes the @GameName to a file
	 * so then it can be chosen as a playable game. 
	 * @param GameName
	 */
	
	public static void Do(String GameName){
		if(!StartUtils.anyInstalled){
			WriteGeneral.main(WriteGeneral.AnyInstalled, "true");
		}
		try(FileWriter fw = new FileWriter(Data.locationConfigs + "installed", true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
			    out.println(GameName);
			} catch (IOException e) {
			    //exception handling left as an exercise for the reader
			}
	}
	
	public static void DownloadUpdate(){
		float Version = Float.valueOf(Main.VERSION);
		Version = Version + 0.1f;
		AppOutput.printLine(String.valueOf(Version), AppOutput.WARNING);
		File f = new File(Data.locationBin + "Launcher.jar");
		if(f.exists()){
			f.delete();
		}
		try(
				ReadableByteChannel in=Channels.newChannel(
						
				new URL(Data.BaseUrl + "Launcher/Launcher-" + Version + ".zip").openStream());	
				FileChannel out=new FileOutputStream(Data.locationTemp + "Launcher.zip").getChannel() ) {
				out.transferFrom(in, 0, Long.MAX_VALUE);
				UnZip.main(Data.locationTemp + "Launcher.zip", Data.locationBin);
			}
			catch(IOException ex){
				AppOutput.printLine("Could not download Launcher.", AppOutput.ERROR);
			}
		
	}
}
