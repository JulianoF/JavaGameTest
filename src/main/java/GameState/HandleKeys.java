/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameState;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author JJ
 */
public class HandleKeys implements KeyListener {
    
    public boolean upPress;
    public boolean downPress;
    public boolean leftPress;
    public boolean rightPress;

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        int keyCode = e.getKeyCode();
        
        if(keyCode == KeyEvent.VK_W){
            upPress = true;
        }
        if(keyCode == KeyEvent.VK_S){
            downPress = true;
        }
        if(keyCode == KeyEvent.VK_A){
            leftPress = true;
        }
        if(keyCode == KeyEvent.VK_D){
            rightPress = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        
        if(keyCode == KeyEvent.VK_W){
            upPress = false;
        }
        if(keyCode == KeyEvent.VK_S){
            downPress = false;
        }
        if(keyCode == KeyEvent.VK_A){
            leftPress = false;
        }
        if(keyCode == KeyEvent.VK_D){
            rightPress =false;
        }
           
    }
    
}
