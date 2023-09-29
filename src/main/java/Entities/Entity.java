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
public abstract class Entity {
    
    protected GameStateManager gsm;
    
    public Entity(GameStateManager gsm){
        this.gsm = gsm;
    }
    
    public abstract void init();
    public abstract void update();
    public abstract void draw(java.awt.Graphics2D g);
}
