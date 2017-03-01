package com.TNF.Launcher.screen;

import com.TNF.Launcher.Main;
import com.TNF.Launcher.gfx.Color;
import com.TNF.Launcher.gfx.Font;
import com.TNF.Launcher.gfx.Screen;
import com.TNF.Launcher.utils.AppOutput;
import com.TNF.Launcher.utils.Client;
import com.TNF.Launcher.utils.Worker;

/**
 * Created by brayden on 6/1/17.
 */
public class NewCodeMenu extends Menu{

    public static final int MINIGAME_WIDTH = Main.WIDTH >> 4;
    public static final int MINIGAME_HEIGHT = Main.HEIGHT >> 4;
    private String code = "";
    private static String Header = "Your code.";
    private static boolean running = true;
    private int wncol = Color.get(-1, 0, Color.rgb(0, 0, 0), Color.rgb(255, 0, 0));
    public static int DEFAULT_TEXT_COLOR = Color.get(-1, 555, 555, 555);
    public static int DEFAULT_TITLE_COLOR = Color.get(112, 445, 445, 445);
    public static int DEFAULT_BACKGROUND_COLOR = Color.get(112, 112, 112, 112);
    public static int DEFAULT_BORDER_COLOR = Color.get(-1, 2, 112, 445);
    

    public void tick() {
    	AppOutput.enabledDebug();
    	if (running){
    		this.typecode();
    		if (input.enter.clicked){
    			String Final = "https://crazywolf132.github.io/TNFLauncher/Games/" + code + "/version";
    			if(Client.checkIfURLExists(Final)) {
    	    		AppOutput.printLine("Game exists. Will start downloading.");
    	    		Worker.Download(code);
    	    		this.game.setMenu(new SelectGame());
    	    	}
    			this.code = "";
    		}
    	}
    }
    
    public void render(Screen screen) {
        screen.clear(0);

        final int col2 = Color.get(-1, 555, 555, 555);
        Font.draw(Header, screen, this.centertext(Header), 20, Color.get(-1, 500, 500, 500));
        Font.draw(this.code, screen, this.centertext(this.code), 50, this.wncol);
        Font.draw("A-Z, 0-9, 36 Characters", screen, this.centertext("A-Z, 0-9, 36 Characters"), 80, col2);
        Font.draw("(Backspace as well)", screen, this.centertext("(Backspace as well)"), 92, col2);

        Font.draw("Press Enter to create", screen, this.centertext("Press Enter to create"), 162, col2);
        Font.draw("Press Esc to cancel", screen, this.centertext("Press Esc to cancel"), 172, col2);
    }

    public void typecode() {

        if (this.input.backspace.clicked && this.code.length() > 0) {
            this.code = this.code.substring(0, this.code.length() - 1);
        }
        if (this.code.length() < 36) {
            if (this.input.a0.clicked) {
                this.code = String.valueOf(this.code) + "0";
            }
            if (this.input.a1.clicked) {
                this.code = String.valueOf(this.code) + "1";
            }
            if (this.input.a2.clicked) {
                this.code = String.valueOf(this.code) + "2";
            }
            if (this.input.a3.clicked) {
                this.code = String.valueOf(this.code) + "3";
            }
            if (this.input.a4.clicked) {
                this.code = String.valueOf(this.code) + "4";
            }
            if (this.input.a5.clicked) {
                this.code = String.valueOf(this.code) + "5";
            }
            if (this.input.a6.clicked) {
                this.code = String.valueOf(this.code) + "6";
            }
            if (this.input.a7.clicked) {
                this.code = String.valueOf(this.code) + "7";
            }
            if (this.input.a8.clicked) {
                this.code = String.valueOf(this.code) + "8";
            }
            if (this.input.a9.clicked) {
                this.code = String.valueOf(this.code) + "9";
            }
            if (this.input.a.clicked) {
                this.code = String.valueOf(this.code) + "a";
            }
            if (this.input.b.clicked) {
                this.code = String.valueOf(this.code) + "b";
            }
            if (this.input.c.clicked) {
                this.code = String.valueOf(this.code) + "c";
            }
            if (this.input.d.clicked) {
                this.code = String.valueOf(this.code) + "d";
            }
            if (this.input.e.clicked) {
                this.code = String.valueOf(this.code) + "e";
            }
            if (this.input.f.clicked) {
                this.code = String.valueOf(this.code) + "f";
            }
            if (this.input.g.clicked) {
                this.code = String.valueOf(this.code) + "g";
            }
            if (this.input.h.clicked) {
                this.code = String.valueOf(this.code) + "h";
            }
            if (this.input.i.clicked) {
                this.code = String.valueOf(this.code) + "i";
            }
            if (this.input.j.clicked) {
                this.code = String.valueOf(this.code) + "j";
            }
            if (this.input.k.clicked) {
                this.code = String.valueOf(this.code) + "k";
            }
            if (this.input.l.clicked) {
                this.code = String.valueOf(this.code) + "l";
            }
            if (this.input.m.clicked) {
                this.code = String.valueOf(this.code) + "m";
            }
            if (this.input.n.clicked) {
                this.code = String.valueOf(this.code) + "n";
            }
            if (this.input.o.clicked) {
                this.code = String.valueOf(this.code) + "o";
            }
            if (this.input.p.clicked) {
                this.code = String.valueOf(this.code) + "p";
            }
            if (this.input.q.clicked) {
                this.code = String.valueOf(this.code) + "q";
            }
            if (this.input.r.clicked) {
                this.code = String.valueOf(this.code) + "r";
            }
            if (this.input.s.clicked) {
                this.code = String.valueOf(this.code) + "s";
            }
            if (this.input.t.clicked) {
                this.code = String.valueOf(this.code) + "t";
            }
            if (this.input.u.clicked) {
                this.code = String.valueOf(this.code) + "u";
            }
            if (this.input.v.clicked) {
                this.code = String.valueOf(this.code) + "v";
            }
            if (this.input.w.clicked) {
                this.code = String.valueOf(this.code) + "w";
            }
            if (this.input.x.clicked) {
                this.code = String.valueOf(this.code) + "x";
            }
            if (this.input.y.clicked) {
                this.code = String.valueOf(this.code) + "y";
            }
            if (this.input.z.clicked) {
                this.code = String.valueOf(this.code) + "z";
            }
            if (this.input.space.clicked) {
                this.code = String.valueOf(this.code) + " ";
            }
        }
    }
}
