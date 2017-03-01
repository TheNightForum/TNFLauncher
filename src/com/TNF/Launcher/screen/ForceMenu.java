package com.TNF.Launcher.screen;

import com.TNF.Launcher.Game.Launch;
import com.TNF.Launcher.gfx.Color;
import com.TNF.Launcher.gfx.Font;
import com.TNF.Launcher.gfx.Screen;

public class ForceMenu extends Menu {
	private int selected = 0;
	
	public static int DEFAULT_TEXT_COLOR = Color.get(-1, 555, 555, 555);
	public static int DEFAULT_TITLE_COLOR = Color.get(112, 445, 445, 445);
	public static int DEFAULT_BACKGROUND_COLOR = Color.get(112, 112, 112, 112);
	public static int DEFAULT_BORDER_COLOR = Color.get(-1, 2, 112, 445);
	
	private static final String[] options = { "OK" };
	
	
	public ForceMenu() {
	}

	public void tick() {
		
		if (input.up.clicked) selected--;
		if (input.down.clicked) selected++;
		
		int len = options.length;
		if (selected < 0) selected += len;
		if (selected >= len) selected -= len;

		if (input.attack.clicked || input.menu.clicked) {
			if (selected == 0) Launch.main("", true);
		}
	}

	public void render(Screen screen) {
		screen.clear(0);
		
		Font.renderFrame(screen, "", 8, 6, 28, 17,
				DEFAULT_BACKGROUND_COLOR, DEFAULT_BORDER_COLOR,
				DEFAULT_TITLE_COLOR);

		// options
		for (int i = 0; i < options.length; i++) {
			String msg = options[i];
			int col = Color.get(-1, 222, 222, 222);
			if (i == selected) {
				msg = "> " + msg + " <";
				col = Color.get(-1, 555, 555, 555);
			}
			Font.draw(msg, screen, (screen.w - msg.length() * 8) / 2, (8 + i) * 12 - 10, col);
		}
		
		Font.draw("Please Restart", screen, 95, screen.h - 145, DEFAULT_TITLE_COLOR);
	}
}
