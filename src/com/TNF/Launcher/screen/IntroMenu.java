package com.TNF.Launcher.screen;

import com.TNF.Launcher.gfx.Screen;
import com.TNF.Launcher.utils.AppOutput;

public class IntroMenu extends Menu {
	
	public void tick() {
		DialogMenu welcome = new DialogMenu(0, "");
		welcome.setTitle("Welcome");
		welcome.setText("I see you are new.\n\n" +
			"Lets get started!\nFirst, we need a code.\n" +
			"This code is given to you by the developer of the game. " +
			"All you need to do is enter it on the next screen.\n" +
			"\nIt will download the game and keep it up-to-date all the time. " +
			"Press ENTER to continue.");
		game.setMenu(welcome);
		
		
		if(input.c.clicked){
			AppOutput.enabledDebug();
			AppOutput.printDebug("C was pressed");
			this.game.setMenu(new NewCodeMenu());
		}
	}

	public void render(Screen screen) {
		screen.clear(0);

	}
}
