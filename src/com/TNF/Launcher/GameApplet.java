package com.TNF.Launcher;

import java.applet.Applet;
import java.awt.BorderLayout;

import com.TNF.Launcher.screen.SplashMenu;

public class GameApplet extends Applet {
	private static final long serialVersionUID = 1L;

	public void init() {
		// create a new game
		Main game = new Main();
		game.initGraphics();
		game.setMenu(new SplashMenu());
		GameContainer.getInstance().setGame(game);
		
		// init design
		setLayout(new BorderLayout());
		add(game, BorderLayout.CENTER);
		setSize(Main.WIDTH * Main.SCALE, Main.HEIGHT * Main.SCALE);
	}

	public void start() {
		GameContainer.getInstance().getGame().start();
	}

	public void stop() {
		GameContainer.getInstance().getGame().stop();
	}
	
	
}