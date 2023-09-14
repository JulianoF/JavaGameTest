/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import GameState.GameStateManager;

/**
 *
 * @author JJ
 */
public class EntityRenderer extends Entity{
    
    Player player = null;
    Enemy1 enemy1 = null;
    
    public EntityRenderer(GameStateManager gsm, Player entityType){
        super(gsm);
        player = entityType;
    }
    public EntityRenderer(GameStateManager gsm, Enemy1 entityType){
        super(gsm);
        enemy1 = entityType;
    }    

    @Override
    public void init() {
        
    }

    @Override
    public void update() {
        if(player != null){
            player.update();
        }
        if(enemy1!= null){
            enemy1.update();
        }
    }

    @Override
    public void draw(java.awt.Graphics2D g) {
        if(player != null){
            player.draw(g);
        }
        if(enemy1!= null){
            enemy1.draw(g);
        }        
    }
    
}
