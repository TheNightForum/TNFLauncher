package com.TNF.Launcher.screen;

import com.TNF.Launcher.Game.Info;
import com.TNF.Launcher.Game.Launch;
import com.TNF.Launcher.gfx.Color;
import com.TNF.Launcher.gfx.Font;
import com.TNF.Launcher.gfx.Screen;
import com.TNF.Launcher.sound.Sound;

public class MainMenu extends Menu{
	private int selected = 0;

	private static final String[] options = { "Play", "Force Update", "Credits", "Choose Another Game" };
	private static String Name;
	
	public MainMenu(String GameName){
		Name = GameName;
		Info.main(Name);
		if(Info.AutoUpdate){
			
		}
	}
	
	public void tick() {
		if (input.up.clicked) selected--;
		if (input.down.clicked) selected++;

		int len = options.length;
		if (selected < 0) selected += len;
		if (selected >= len) selected -= len;

		if (input.attack.clicked || input.menu.clicked) {
			if (selected == 0) {
				Sound.test.play();
				Launch.main(Name, false);
			}
			if (selected == 1) {
				Sound.test.play();
				if(!Info.EnableForceUpdate){
					this.game.setMenu(new MessagesScreen(-1, Name));
				}
			}
			if (selected == 2) {
				Sound.test.play();
				if(Info.EnableCredits){
					this.game.setMenu(new MessagesScreen(1, Name));
				}else{
					this.game.setMenu(new MessagesScreen(-1, Name));
				}
			}
			if (selected == 3) {
				Sound.test.play();
				this.game.setMenu(new SelectGame());
			}
		}
	}
	
	public void render(Screen screen) {
		screen.clear(0);

		// version
		//TODO: Grab the games version.
		if(!Info.Version.equals("NUL")){
			Font.draw("v" + Info.Version, screen, 2, 2, Color.get(0, 111, 111, 111));
		}
		
		// Game Name
		Font.draw(Info.GameTitle, screen, (screen.w - Info.GameTitle.length() *8) /2, (screen.h - 57) / 2, Color.get(0, 110, 330, 553));
		
		// options
		for (int i = 0; i < options.length; i++) {
			String msg = options[i];
			int col = Color.get(0, 222, 222, 222);
			if (i == selected) {
				msg = "> " + msg + " <";
				col = Color.get(0, 555, 555, 555);
			}
			Font.draw(msg, screen, (screen.w - msg.length() * 8) / 2, (10 + i) * 12, col);
		}
		
	}
}
