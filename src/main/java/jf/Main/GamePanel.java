/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jf.Main;

import GameState.GameStateManager;
import GameState.HandleKeys;
import GameState.MouseHandler;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static jf.Main.constValues.*;
/**
 *
 * @author juliano
 * Game loop to implement functionality. Gets the basics down,
 * will need to be optimized in the future.
 */
public class GamePanel extends JPanel implements Runnable{
    
   /* static Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int HEIGHT = (int)size.height;
    public static final int WIDTH = (int)size.width;
    public static final int SCALE = 2;*/
    int lastFPS;
    
    private Thread gameThread;
    private boolean running;
    
    private Graphics2D gphs;
    private BufferedImage image;
    
    private GameStateManager gsm;
    
    HandleKeys keyHandler = new HandleKeys();
    MouseHandler mouseHandler = new MouseHandler();

    
    public GamePanel(){
        super();
        setBackground(Color.white);
        setPreferredSize(new Dimension(constValues.WIDTH, constValues.HEIGHT));
        setFocusable(true);
        requestFocus();
    }
    public void init(){
        image = new BufferedImage(constValues.WIDTH,constValues.HEIGHT,BufferedImage.TYPE_INT_RGB);
        gphs = (Graphics2D) image.getGraphics();
        running = true;
        
        gsm = new GameStateManager(keyHandler,mouseHandler);
    }
    @Override
    public void addNotify(){
        super.addNotify();
        if(gameThread == null){
            gameThread = new Thread(this);
            addKeyListener(keyHandler);
            addMouseListener(mouseHandler);
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
                        Render();
                        draw();
			frames++;
			delta--;
                      
			if(System.currentTimeMillis() - time >= 1000) {
				System.out.println("fps:" + frames);
                                lastFPS = frames;
                             
				time += 1000;
				frames = 0;
			}
                    try{
                        Thread.sleep(5);
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
        
        //FPS COUNTER
        gphs.setFont(new Font("Arial", Font.PLAIN, 16));
	gphs.setColor(Color.WHITE);
	gphs.drawString("FPS: "+lastFPS, constValues.WIDTH-70, 16);
        
    }
    public void Render(){
        Graphics g2 = getGraphics();
        g2.drawImage(image,0,0,null);
        g2.dispose();
    }
    


}
