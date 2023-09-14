/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import GameState.GameStateManager;
import jf.Main.constValues;

/**
 *
 * @author JJ
 */
public class Player extends Entity {
    
    private int pX = 0; 
    private int pY = 0;
    
    public Player(GameStateManager gsm){
        super(gsm);
        init();
    }

    @Override
    public void init() {
    }

    @Override
    public void update() {
        if(gsm.keyHandler.rightPress == true){
            pX = pX+10;
        }
        if(gsm.keyHandler.downPress == true){
            pY = pY+10;
        }
        if(gsm.keyHandler.leftPress == true){
            pX = pX-10;
        }
        if(gsm.keyHandler.upPress == true){
            pY = pY-10;
        }
    }

    @Override
    public void draw(java.awt.Graphics2D g) {
        g.setColor(java.awt.Color.BLACK);
        g.fillRect(0, 0, constValues.WIDTH, constValues.HEIGHT);
        g.setColor(java.awt.Color.RED);
        g.draw3DRect(pX, pY, 150, 250, true);
    }
    
}
