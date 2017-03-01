package com.TNF.Launcher.screen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.TNF.Launcher.gfx.Color;
import com.TNF.Launcher.gfx.Font;
import com.TNF.Launcher.gfx.Screen;
import com.TNF.Launcher.utils.Data;

public class SelectGame extends Menu {

	List<String>
	GameNames = new ArrayList<String>();
	private int GameSelected = 0;
	public static String Name = "";

	public SelectGame() {
		try (BufferedReader br = new BufferedReader(new FileReader(Data.locationConfigs + "installed"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		       GameNames.add(line);
		    }
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public void tick() {
		 if (this.input.up.clicked) {
             --this.GameSelected;
         }
         if (this.input.down.clicked) {
             ++this.GameSelected;
         }
         if (this.GameSelected < 0) {
             this.GameSelected = 0;
         }
         if (this.GameSelected > this.GameNames.size() - 1) {
             this.GameSelected = this.GameNames.size() - 1;
         }

		if (this.input.enter.clicked){
			Name = this.GameNames.get(this.GameSelected);
			this.game.setMenu(new MainMenu(Name));
		}
		if (this.input.escape.clicked){
			this.game.setMenu(new SelectMenu());
		}
	}

	public void render(Screen screen) {
		screen.clear(0);

		{
            String msg2 = "Select Game";
            int col2 = Color.get(-1, 555, 555, 555);
            final int col3 = Color.get(-1, 222, 222, 222);
            if (this.GameNames.size() > 0) {
                Font.draw(msg2, screen, this.centertext(msg2), 20, col2);
                Font.draw(this.GameNames.get(this.GameSelected), screen, this.centertext(this.GameNames.get(this.GameSelected)), 80, col2);
                if (this.GameSelected > 0) {
                    Font.draw(this.GameNames.get(this.GameSelected - 1), screen, this.centertext(this.GameNames.get(this.GameSelected - 1)), 70, col3);
                }
                if (this.GameSelected > 1) {
                    Font.draw(this.GameNames.get(this.GameSelected - 2), screen, this.centertext(this.GameNames.get(this.GameSelected - 2)), 60, col3);
                }
                if (this.GameSelected > 2) {
                    Font.draw(this.GameNames.get(this.GameSelected - 3), screen, this.centertext(this.GameNames.get(this.GameSelected - 3)), 50, col3);
                }
                if (this.GameSelected < this.GameNames.size() - 1) {
                    Font.draw(this.GameNames.get(this.GameSelected + 1), screen, this.centertext(this.GameNames.get(this.GameSelected + 1)), 90, col3);
                }
                if (this.GameSelected < this.GameNames.size() - 2) {
                    Font.draw(this.GameNames.get(this.GameSelected + 2), screen, this.centertext(this.GameNames.get(this.GameSelected + 2)), 100, col3);
                }
                if (this.GameSelected < this.GameNames.size() - 3) {
                    Font.draw(this.GameNames.get(this.GameSelected + 3), screen, this.centertext(this.GameNames.get(this.GameSelected + 3)), 110, col3);
                }
            }
            else {
                this.game.setMenu(new SelectMenu());
            }
            
            Font.draw("Arrow keys to move", screen, this.centertext("Arrow keys to move"), screen.h - 44, Color.get(0, 444, 444, 444));
            Font.draw("ENTER to confirm", screen, this.centertext("ENTER to confirm"), screen.h - 32, Color.get(0, 40, 40, 40));
            Font.draw("ESCAPE to go back", screen, this.centertext("ESCAPE to go back"), screen.h - 20, Color.get(0, 400, 400, 400));
        }
	}
}