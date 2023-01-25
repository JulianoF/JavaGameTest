/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameState;

import java.awt.Graphics2D;
import java.util.ArrayList;
/**
 *
 * @author JJ
 */
public class GameStateManager {
    
    public int pX = 0;
    public int pY = 0;
    
    private ArrayList<GameState> gameStates;
    private HandleKeys keyHandler;
    
    public GameStateManager(HandleKeys kh){
        gameStates = new ArrayList<>();
        keyHandler = kh;
    }

    public void update() {
        if(keyHandler.rightPress == true){
            pX = pX+10;
        }
        if(keyHandler.downPress == true){
            pY = pY+10;
        }
        if(keyHandler.leftPress == true){
            pX = pX-10;
        }
        if(keyHandler.upPress == true){
            pY = pY-10;
        }         
    }

    public void draw(Graphics2D gphs) {
        gphs.setColor(java.awt.Color.BLACK);
        gphs.fillRect(0, 0, 1280, 1024);
        
        //test code below
        gphs.setColor(java.awt.Color.RED);
        gphs.draw3DRect(pX, pY, 150, 250, true);
    }
}
