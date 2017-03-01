package com.TNF.Launcher.screen;

import com.TNF.Launcher.gfx.Color;
import com.TNF.Launcher.gfx.Font;
import com.TNF.Launcher.gfx.Screen;
import com.TNF.Launcher.sound.Sound;

public class SelectMenu extends Menu {
	private int selected = 0;
	private static final String NAME = "The Night Forum - Launcher";
	private Boolean isDev = false;
	private static String[] options;

	public SelectMenu() {
		if(isDev){
			options = new String[]{ "Select Game", "Add Game", "Share Game", "Quit" };
		}else{
			options = new String[]{ "Select Game", "Add Game", "Quit" };
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
				this.game.setMenu(new SelectGame());
			}
			if (selected == 1) {
				Sound.test.play();
				this.game.setMenu(new NewCodeMenu());
			}
			if (selected == 2) {
				Sound.test.play();
				System.exit(0);
			}
			if(isDev){
				if(selected == 3){
					Sound.test.play();
					this.game.setMenu(new MakeGame());
				}
			}
			
		}
	}

	public void render(Screen screen) {
		screen.clear(0);

		Font.draw(NAME, screen, (screen.w - NAME.length() *8) /2, (screen.h - 57) / 2, Color.get(0, 110, 330, 553));
		
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

		Font.draw("(Arrow keys,X and C, F5 and F9)", screen, 0, screen.h - 8, Color.get(0, 111, 111, 111));
	}
}