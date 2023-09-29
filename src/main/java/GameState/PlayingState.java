/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameState;

import Entities.EntityRenderer;
import Entities.Player;
import Levels.TestLevel;
import java.awt.Graphics2D;
import jf.Main.constValues;

/**
 *
 * @author JJ
 */
public class PlayingState extends GameState {

    EntityRenderer player1;
    TestLevel test1;
    
    public PlayingState(GameStateManager gsm) {
        super(gsm);
        init();
    }

    @Override
    public void init() {
        player1 = new EntityRenderer(gsm,new Player(gsm));
        test1 = new TestLevel(gsm);
    }

    @Override
    public void update() {
        player1.update();
        handleInput();
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(java.awt.Color.BLACK);
        g.fillRect(0, 0, constValues.WIDTH, constValues.HEIGHT);
        //test code below
        test1.draw(g);
        player1.draw(g);
        

    }

    @Override
    public void handleInput() {
    }
    
}
