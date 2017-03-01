package com.TNF.Launcher.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

import javax.imageio.ImageIO;

import com.TNF.Launcher.Main;
import com.TNF.Launcher.config.ReadGeneral;
import com.TNF.Launcher.config.WriteGeneral;
import com.TNF.Launcher.gfx.Screen;
import com.TNF.Launcher.gfx.SpriteSheet;

public class StartUtils {

	/**
	 * This class has everything it is going to do when it is starting.
	 * This includes, generating the Config, Checking it, Loading the sprites
	 * downloading the assets, etc.
	 */
	
	public static Boolean isNew;
	public static Boolean anyInstalled;
	
	public static void main(){
		WriteGeneral.main("", "");
		configs();
		check();
	}
	
	private static void configs(){
		ReadGeneral.main(WriteGeneral.FirstTime);
		isNew = Boolean.valueOf(ReadGeneral.Result);
		ReadGeneral.Result = "";
		
		ReadGeneral.main(WriteGeneral.AnyInstalled);
		anyInstalled = Boolean.valueOf(ReadGeneral.Result);
		ReadGeneral.Result = "";
	}
	
	private static void check(){
		if(isNew){
			download("images");
		}
	}
	
	private static void download(String toDownload){
		if(toDownload.equals("images")){
			try(
				ReadableByteChannel in=Channels.newChannel(
						  
				new URL(Data.BaseUrl + "Res/" + "res.zip").openStream());	
				FileChannel out=new FileOutputStream(Data.location + "res.zip").getChannel() ) {
				out.transferFrom(in, 0, Long.MAX_VALUE);
			}
			catch(IOException ex){
				AppOutput.printLine("Could not download sprites.", AppOutput.ERROR);
			}
			UnZip.main(Data.location + "res.zip", Data.locationRes);
			WriteGeneral.main(WriteGeneral.FirstTime, "False");
		}
	}
	
	public static void setImages(){
		try{
			Main.screen = new Screen(Main.WIDTH, Main.HEIGHT, new SpriteSheet(ImageIO.read(new File(Data.locationRes +"icons.png"))));
			Main.fogScreen = new Screen(Main.WIDTH, Main.HEIGHT, new SpriteSheet(ImageIO.read(new File(Data.locationRes +"icons.png"))));
			Main.lightScreen = new Screen(Main.WIDTH, Main.HEIGHT, new SpriteSheet(ImageIO.read(new File(Data.locationRes +"icons.png"))));
		}catch (IOException e){
			AppOutput.printLine(e);
		}
	}
}
