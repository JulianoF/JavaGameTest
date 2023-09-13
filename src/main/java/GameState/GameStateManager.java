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
    
    private final ArrayList<GameState> gameStates;
    private StateList currentState = StateList.MENUSTATE;
    public HandleKeys keyHandler;
    public MouseHandler mouseHandler;
    
    public GameStateManager(HandleKeys kh, MouseHandler mh){
        
        gameStates = new ArrayList<>();
        keyHandler = kh;
        mouseHandler = mh;
        
        gameStates.add(new MainMenu(this));
        gameStates.add(new PauseMenu(this));
        gameStates.add(new PlayingState(this));
    }

    public void update() {  
        
        switch(currentState){
            case MENUSTATE:
                //System.out.println(currentState);
                gameStates.get(0).update();
                break;
            case PLAYINGSTATE:
                gameStates.get(2).update();
                break;
        }  
    }

    public void draw(Graphics2D gphs) {
        
        switch(currentState){
            case MENUSTATE:
                //System.out.println(currentState);
                gameStates.get(0).draw(gphs);
                break;
            case PLAYINGSTATE:
                gameStates.get(2).draw(gphs); 
                break;
        }        
    }
    
    public void setState(StateList STATE){
        currentState = STATE;
    }
    
    public StateList getState(){
        return currentState;
    }
}
