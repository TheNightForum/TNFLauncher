package com.TNF.Launcher.screen;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;

import com.TNF.Launcher.Game.Info;
import com.TNF.Launcher.gfx.Screen;

public class MessagesScreen extends Menu {
	private static int Status;
	private String GameName;
	
	public MessagesScreen(int code, String Game){
		Status = code;
		GameName = Game;
	}
	/**
	 * Status -1 	= Dev did not enable it.
	 * Status 1  	= Display Credits.
	 * Status 2		= Display ChangeLog.
	 */
	public void tick() {
		DialogMenu welcome = new DialogMenu(1, GameName);
		if(Status == -1){
			welcome.setTitle("");
			welcome.setText("Sorry... \n\n"
					+ "The Dev has disabled this feature.\n\n"
					+ "Press ENTER to go back.");
		}else if (Status == 1){
			welcome.setTitle("");
			welcome.setText(pullSite(Info.CreditsURL));
		}else if (Status == 2){
			welcome.setTitle("");
			welcome.setText(pullSite(Info.ChangelogURL));
		}
		game.setMenu(welcome);
		
	}

	private static String pullSite(String siteURL){
		try{
			URL link = new URL(siteURL);
			InputStream in = new BufferedInputStream(link.openStream());
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			int n = 0;
			while (-1 != (n = in.read(buf)))
			{
				out.write(buf, 0, n);
			}
			out.close();
			in.close();
			byte[] bytes = out.toByteArray();			
			String raw = new String(bytes, "UTF-8");			
			return raw;
		}catch(Exception e) {
			return "Must be connected to the internet to view logs!";
		}
	}
	
	public void render(Screen screen) {
		screen.clear(0);
	}
}
