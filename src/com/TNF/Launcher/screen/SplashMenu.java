// 
// Decompiled by Procyon v0.5.30
// 

package com.TNF.Launcher.screen;

import com.TNF.Launcher.InputHandler;
import com.TNF.Launcher.Main;
import com.TNF.Launcher.gfx.Color;
import com.TNF.Launcher.gfx.Font;
import com.TNF.Launcher.gfx.Screen;
import com.TNF.Launcher.utils.Client;
import com.TNF.Launcher.utils.StartUtils;


public class SplashMenu extends Menu
{
    protected Main game;
    protected InputHandler input;
    private int rdm;
    private int tickc;
    
        
    public SplashMenu() {
        this.tickc = 0;  
        Client.isClientUpToDate();
        Client.getLatestClientVersion();
    }
    
    @Override
    public void init(final Main game, final InputHandler input) {
        this.input = input;
        this.game = game;
    }
    
    @Override
    public void tick() {
        ++this.tickc;
        if (this.tickc >= 200) {
        	if (Client.isClientUpToDate() == 1){
	        	this.game.setMenu(new UpdateMenu());
        	}else{
        		if (!StartUtils.anyInstalled){
	        		this.game.setMenu(new IntroMenu());
	        	}else{
	        		this.game.setMenu(new SelectMenu());
	        	}
        	}
        }
    }
    
    @Override
    public void render(final Screen screen) {
        int h = 5;
        int w = 46;
        ++this.rdm;
        screen.clear(0);
        for (int y = 3; y < h; ++y) {
            for (int x = 17; x < w; ++x) {
                final int titleColor = Color.get(this.rdm + x * 8, this.rdm + x * 8, this.rdm + x * 8, this.rdm + x * 8);
                screen.render(x * 4, y * 8, 352, titleColor, 0);
            }
        }
        h = Main.HEIGHT;
        w = Main.WIDTH;
        ++this.rdm;
        for (int y = 0; y < h; ++y) {
            for (int x = 0; x < w; ++x) {
                final int titleColor = Color.get(0, 0, this.rdm + x * 5 + y * 2, 551);
                screen.render(x * 8, y * 8, 355, titleColor, 0);
            }
        }
        Font.renderFrame(screen, "", 9, 2, 28, 20);
        h = 20;
        w = 28;
        for (int y = 3; y < h; ++y) {
            for (int x = 10; x < w; ++x) {
                final int titleColor = Color.get(0, 0, 1, 551);
                screen.render(x * 8, y * 8, 355, titleColor, 0);
            }
        }
        final int h2 = 2;
        final int w2 = 16;
        final int titleColor = Color.get(-1, 107, 8, 999);
        final int xo = (screen.w - w2 * 8) / 2;
        final int yo = 24;
        for (int y2 = 0; y2 < h2; ++y2) {
            for (int x2 = 0; x2 < w2; ++x2) {
                screen.render(xo + x2 * 8, yo + y2 * 8, x2 + 14 + (y2 + 6) * 32, titleColor, 0);
            }
        }
        Font.draw("CrazyWolf", screen, 115, 60, Color.get(-1, 500, 500, 500));
    }
}
