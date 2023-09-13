/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameState;

import java.awt.Graphics2D;
import jf.Main.constValues;

/**
 *
 * @author JJ
 */
public class PlayingState extends GameState {

    private int pX = 0;
    private int pY = 0;
    
    public PlayingState(GameStateManager gsm) {
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
        //test code below

        g.setColor(java.awt.Color.BLACK);
        g.fillRect(0, 0, constValues.WIDTH, constValues.HEIGHT);
        g.setColor(java.awt.Color.RED);
        g.draw3DRect(pX, pY, 150, 250, true);
    }

    @Override
    public void handleInput() {
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
    
}
