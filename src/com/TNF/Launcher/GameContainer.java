package com.TNF.Launcher;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

import com.TNF.Launcher.screen.SplashMenu;
import com.TNF.Launcher.utils.StartUtils;

/**
 * 		Game Container
 * 
 * Main class used as a manager of a currently running game.
 * 
 * Purpose, responsibilities, functions:
 *  - Entry-point for starting the game.
 *  - Creator and owner of the UI (JFrame).
 *  - Singleton interface, handles one "main" game (though the number of games
 *  	running at the same time is theoretically not limited by this).
 *  - Save and load function (+ GUI), swaps loaded game with the active one. 
 * 
 * @author Dejvino
 */
public class GameContainer
{
	private static GameContainer singleton;
	
	private JFrame jFrame;
	
	private Main game;
	private GameSetup setup;
	
	private GameContainer()
	{
		this.setup = new GameSetup();
		// TODO: load setup from file
		
		this.game = new Main();
		this.game.initGraphics();
		this.game.setMenu(new SplashMenu());
	}
	
	/**
	 * Returns a singleton instance of this class.
	 * 
	 * @return singleton
	 */
	public static GameContainer getInstance()
	{
		if (singleton == null) {
			singleton = new GameContainer();
		}
		return singleton;
	}
	
	/**
	 * Returns the currently active game.
	 * 
	 * @return game
	 */
	public Main getGame()
	{
		return this.game;
	}
	
	/**
	 * Changes the currently active game.
	 * 
	 * @param game
	 */
	public void setGame(Main game)
	{
		this.game = game;
	}
	
	/**
	 * Returns the current game setup.
	 * 
	 * @return
	 */
	public GameSetup getSetup()
	{
		return this.setup;
	}
	
	/**
	 * Changes the game setup.
	 * 
	 * @param setup
	 */
	public void setSetup(GameSetup setup)
	{
		this.setup = setup;
	}
	
	/**
	 * Performs a one-time initialization of the environment.
	 * Namely it creates a UI window (JFrame) which is later used to display the game.
	 */
	public void init()
	{
		JFrame frame = new JFrame(Main.NAME);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setResizable(false);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
		
		jFrame = frame;
	}
	
	/**
	 * The currently active game is attached to the UI window and then started.
	 */
	public void startGame()
	{
		game.setMinimumSize(new Dimension(Main.WIDTH * Main.SCALE, Main.HEIGHT * Main.SCALE));
		game.setMaximumSize(new Dimension(Main.WIDTH * Main.SCALE, Main.HEIGHT * Main.SCALE));
		game.setPreferredSize(new Dimension(Main.WIDTH * Main.SCALE, Main.HEIGHT * Main.SCALE));
		
		jFrame.add(game, BorderLayout.CENTER);
		jFrame.pack();
		
		this.game.start();
	}
	
	/**
	 * Stops the currently active game and removes it from the UI window.
	 */
	public void stopGame()
	{
		this.game.stop();
		this.jFrame.remove(game);
	}
	
	public static void main(String[] args)
	{
		StartUtils.main();
		GameContainer cont = GameContainer.getInstance();
		cont.init();
		cont.startGame();
	}

}
