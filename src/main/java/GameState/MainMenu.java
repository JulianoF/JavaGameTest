/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import jf.Main.GamePanel;

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
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		
		// draw title
		g.setColor(Color.RED);
		g.setFont(new Font("Arial", Font.PLAIN, 28));
		g.drawString("2D PLATFORMER", GamePanel.WIDTH/3 , GamePanel.HEIGHT/4 - 40);
		
		// draw menu options
		g.setFont(new Font("Arial", Font.PLAIN, 18));
		g.setColor(Color.WHITE);
		g.drawString("Start", 145, 165);
		g.drawString("Quit", 145, 185);

    }

    @Override
    public void handleInput() {
        
    }
}
