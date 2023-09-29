/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import jf.Main.constValues;

/**
 *
 * @author JJ
 */
public class MainMenu extends GameState {
    
    private FontMetrics metric; 
    
    boolean startSelect = false;
    boolean settingSelect = false;
    boolean quitSelect = false;
    
    public MainMenu(GameStateManager gsm){
        super(gsm);
    }

    @Override
    public void init() {}

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
                
        metric = g.getFontMetrics();

        //Draw Test Bounding Box for click control  
        ////////////////////////////////////////////////////////////////////////
        g.drawRect((constValues.WIDTH/3)-68, (constValues.HEIGHT/3)+120,
                metric.stringWidth("Start"), metric.getHeight());
        
        g.drawRect((constValues.WIDTH/3)-68, (constValues.HEIGHT/3)+188,
                metric.stringWidth("Settings (WIP)"), metric.getHeight());
        
        g.drawRect((constValues.WIDTH/3)-68, (constValues.HEIGHT/3)+256,
                metric.stringWidth("Quit"), metric.getHeight());
        ////////////////////////////////////////////////////////////////////////

        if(startSelect){
            g.setColor(Color.CYAN);
            g.drawString("Start", (constValues.WIDTH/3)-68, (constValues.HEIGHT/3)+168);
            g.setColor(Color.WHITE);
                    
        }else{
            g.drawString("Start", (constValues.WIDTH/3)-68, (constValues.HEIGHT/3)+168);
        }
        
        if(settingSelect){
            g.setColor(Color.CYAN);
            g.drawString("Settings (WIP)", (constValues.WIDTH/3)-68, (constValues.HEIGHT/3)+236);
            g.setColor(Color.WHITE);
                    
        }else{
            g.drawString("Settings (WIP)", (constValues.WIDTH/3)-68, (constValues.HEIGHT/3)+236);
        }       	
        if(quitSelect){
            g.setColor(Color.CYAN);
            g.drawString("Quit", (constValues.WIDTH/3)-68, (constValues.HEIGHT/3)+304);
            g.setColor(Color.WHITE);
                    
        }else{
            g.drawString("Quit", (constValues.WIDTH/3)-68, (constValues.HEIGHT/3)+304);
        }               

        

                
                

    }

    @Override
    public void handleInput() {
       if(gsm.mouseHandler.p.x >= (constValues.WIDTH/3)-68 &&
          gsm.mouseHandler.p.x <= ((constValues.WIDTH/3)-68)+metric.stringWidth("Start") &&
          gsm.mouseHandler.p.y >= (constValues.HEIGHT/3)+120 &&
          gsm.mouseHandler.p.y <= ((constValues.HEIGHT/3)+120)+metric.getHeight() ){
            startSelect = true;
            System.out.println("Click in Bounds");
            if(gsm.mouseHandler.clickCount == 2){
                System.out.println("Double Click Detected");
                gsm.setState(StateList.PLAYINGSTATE);
            }
       }
       else{
            startSelect = false;
            //System.out.println("Click out of Bounds");
       }
       
       if(gsm.mouseHandler.p.x >= (constValues.WIDTH/3)-68 &&
          gsm.mouseHandler.p.x <= ((constValues.WIDTH/3)-68)+metric.stringWidth("Setting (WIP)") &&
          gsm.mouseHandler.p.y >= (constValues.HEIGHT/3)+188 &&
          gsm.mouseHandler.p.y <= ((constValues.HEIGHT/3)+188)+metric.getHeight() ){
            settingSelect = true;
            System.out.println("Click in Bounds");
            if(gsm.mouseHandler.clickCount == 2){
                System.out.println("Double Click Detected");
            }            
       }
       else{
            settingSelect = false;
            //System.out.println("Click out of Bounds");
       } 
       
       if(gsm.mouseHandler.p.x >= (constValues.WIDTH/3)-68 &&
          gsm.mouseHandler.p.x <= ((constValues.WIDTH/3)-68)+metric.stringWidth("Quit") &&
          gsm.mouseHandler.p.y >= (constValues.HEIGHT/3)+256 &&
          gsm.mouseHandler.p.y <= ((constValues.HEIGHT/3)+256)+metric.getHeight() ){
            quitSelect = true;
            System.out.println("Click in Bounds");
            if(gsm.mouseHandler.clickCount == 2){
                System.out.println("Double Click Detected");
                System.exit(0);
            }            
       }
       else{
            quitSelect = false;
            //System.out.println("Click out of Bounds");
       }       
    }
}
