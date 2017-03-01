package com.TNF.Launcher.Game;

import java.io.File;

import com.TNF.Launcher.utils.Data;
import com.TNF.Launcher.utils.Worker;

public class GameUpdate {

	// Force Update Wipe Dir
	private Boolean FUWD = false;
	// Force Update NO Wipe Dir
	private Boolean FUNWD = false;
	// Normal Update Wipe Dir
	private Boolean NUWD = false;
	// Normal Update NO Wipe Dir
	private Boolean NUNWD = false;
	
	private String GameName;
	
	/**
	 * This method takes an int, this int will determine what we are doing.
	 * if @Number = 0, force update & wipe dir.
	 * if @Number = 1, force update & NO wipe dir.
	 * if @Number = 2, normal update & wipe dir.
	 * if @Number = 3, normal update & NO wipe dir.
	 * @param Number
	 */
	public GameUpdate(int Number, String Name){
		GameName = Name;
		if(Number == 0){
			FUWD = true;
		}else if (Number == 1){
			FUNWD = true;
		}else if (Number == 2){
			NUWD = true;
		}else if (Number == 3){
			NUNWD = true;
		}
		Update(GameName);
	}
	
	private void Update(String Name){
		if (FUWD && !FUNWD && !NUWD && !NUNWD){
			File f = new File(Data.locationGames + Name);
			if (f.exists()){
				f.delete();
			}
			Worker.Download(Name);
		}
		if (!FUWD && FUNWD && !NUWD && !NUNWD){
			
		}
		if (!FUWD && !FUNWD && NUWD && !NUNWD){
			
		}
		if (!FUWD && !FUNWD && !NUWD && NUNWD){
			
		}
	}
}
