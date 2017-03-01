package com.TNF.Launcher.screen;

import java.io.File;

import com.TNF.Launcher.gfx.Color;
import com.TNF.Launcher.gfx.Font;
import com.TNF.Launcher.gfx.Screen;

public class MakeGame extends Menu{

	private int wncol;
	private String code, Header, Part1String, Part2String, Part3String;
	
	public MakeGame(){
		this.code = "";
		this.Header = "";
		this.Part1String = "";
		this.Part2String = "";
		this.Part3String = "";
		this.wncol = Color.get(-1, 0, Color.rgb(0, 0, 0), Color.rgb(255, 0, 0));
	}
	
	public void tick(){
		this.typecode();
		if(this.Header.isEmpty()) this.Header = "Game Name:";
		if (input.enter.clicked){
			if(this.Part1String.isEmpty()){
				this.Part1String = code;
				this.Header = "Game Code:";
			}else if(this.Part2String.isEmpty()){
				this.Part2String = code;
				this.Header = "Game Version:";
			}else if(this.Part3String.isEmpty()){
				this.Part3String = code;
				isDone(Part1String, Part2String, Part3String);
				//this.game.setMenu(new SelectMenu());
			}
			this.code = "";
		}
	}
	
	public void render(Screen screen){
		screen.clear(0);
		
		final int col2 = Color.get(-1, 555, 555, 555);
        Font.draw(Header, screen, this.centertext(Header), 20, Color.get(-1, 500, 500, 500));
        Font.draw(this.code, screen, this.centertext(this.code), 50, this.wncol);
        Font.draw("A-Z, 0-9, 36 Characters", screen, this.centertext("A-Z, 0-9, 36 Characters"), 80, col2);
        Font.draw("(Backspace as well)", screen, this.centertext("(Backspace as well)"), 92, col2);

        Font.draw("Press Enter to create", screen, this.centertext("Press Enter to create"), 162, Color.get(-1, 40, 40, 40));
        Font.draw("Press Esc to cancel", screen, this.centertext("Press Esc to cancel"), 172, Color.get(-1, 400, 400, 400));
	}
	
	private void isDone(String Name, String Code, String Version){
		//File f = new File(Data.locat);
	}
	
	private void typecode() {

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
            if (this.input.stop.clicked) {
            	this.code = String.valueOf(this.code) + ".";
            }
        }
    }
}
