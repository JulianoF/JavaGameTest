/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import jf.Main.GamePanel;
import jf.Main.constValues;

/**
 *
 * @author JJ
 */
public class MainMenu extends GameState {
    public MainMenu(GameStateManager gsm){
        super(gsm);
    }

    @Override
    public void init() {  
    }

    @Override
    public void update() {
        handleInput();
    }

    @Override
    public void draw(Graphics2D g) {
        // draw bg
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, constValues.WIDTH, constValues.HEIGHT);
		
		// draw title
		g.setColor(Color.RED);
		g.setFont(new Font("Arial", Font.PLAIN, 68));
		g.drawString("2D PLATFORMER", (constValues.WIDTH/3)-68 , constValues.HEIGHT/3);
		
		// draw menu options
		g.setFont(new Font("Arial", Font.PLAIN, 48));
		g.setColor(Color.WHITE);
		g.drawString("Start", (constValues.WIDTH/3)-68, (constValues.HEIGHT/3)+168);
                g.drawString("Settings (WIP)", (constValues.WIDTH/3)-68, (constValues.HEIGHT/3)+236);
		g.drawString("Quit", (constValues.WIDTH/3)-68, (constValues.HEIGHT/3)+304);

    }

    @Override
    public void handleInput() {
        
    }
}
