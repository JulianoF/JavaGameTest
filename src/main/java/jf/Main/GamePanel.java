/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jf.Main;

import GameState.GameStateManager;
import GameState.HandleKeys;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author juliano
 */
public class GamePanel extends JPanel implements Runnable{
    
    public static final int HEIGHT = 1024;
    public static final int WIDTH = 1280;
    public static final int SCALE = 2;
    
    private Thread gameThread;
    private boolean running;
    
    private Graphics2D gphs;
    private BufferedImage image;
    
    private GameStateManager gsm;
    
    HandleKeys keyHandler = new HandleKeys();

    
    public GamePanel(){
        super();
        setBackground(Color.white);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        requestFocus();
    }
    public void init(){
        image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
        gphs = (Graphics2D) image.getGraphics();
        running = true;
        
        gsm = new GameStateManager(keyHandler);
    }
    @Override
    public void addNotify(){
        super.addNotify();
        if(gameThread == null){
            gameThread = new Thread(this);
            addKeyListener(keyHandler);
            gameThread.start();
        }
    }    
    
    @Override
    public void run() {
	long lastime = System.nanoTime();
	double AmountOfTicks = 60;
	double ns = 1000000000 / AmountOfTicks;
	double delta = 0;
	int frames = 0;
	long time = System.currentTimeMillis();
        
        init();
		
	while(running == true) {
		long now = System.nanoTime();
		delta += (now - lastime) / ns;
		lastime = now;	
		if(delta >= 1) {
			Update();
                        draw();
			Render();
			frames++;
			delta--;
                      
			if(System.currentTimeMillis() - time >= 1000) {
				System.out.println("fps:" + frames);
                             
				time += 1000;
				frames = 0;
			}
                    try{
                        Thread.sleep(8);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                        
		}
	}
    }
        
    public void Update(){
        gsm.update();
    }
    private void draw(){
        gsm.draw(gphs);
    }
    public void Render(){
        Graphics g2 = getGraphics();
        g2.drawImage(image,0,0,null);
        g2.dispose();
    }
    


}
