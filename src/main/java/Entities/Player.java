package Entities;

import GameState.GameStateManager;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import jf.Main.constValues;

/**
 *
 * @author JJ
 */
public class Player extends Entity {
    
    int spriteSize = 64;
    int spriteCounter = 0;
    
    BufferedImage spriteSheet = null;
    BufferedImage lastSprite = null;
    BufferedImage[] walkForward;
    BufferedImage[] walkBackward;
    
    private int velocityX = 0; 
    private int velocityY = 0;
    public int worldPosX;
    public int worldPosY;
    
    public Player(GameStateManager gsm){
        super(gsm);
        walkForward = new BufferedImage[9];
        walkBackward = new BufferedImage[9];
        init();
    }

    @Override
    public void init() {
        try {
            spriteSheet = ImageIO.read(Player.class.getResource("/assets/PlayerSprites.png"));
        } catch (IOException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
        int j = 0;
        for(int i = 0; i < 576; i+= 64){
            walkForward[j] = spriteSheet.getSubimage(i, 704, spriteSize, spriteSize);
            walkBackward[j] = spriteSheet.getSubimage(i, 576, spriteSize, spriteSize);
            //System.out.println(walkForward[j]);
           // System.out.println(walkBackward[j]);
            j++;
        }
        
        
    }

    @Override
    public void update() {
        if(gsm.keyHandler.rightPress == true){
            velocityX = velocityX+8;
        }
        if(gsm.keyHandler.downPress == true){
            velocityY = velocityY+8;
        }
        if(gsm.keyHandler.leftPress == true){
            velocityX = velocityX-8;
        }
        if(gsm.keyHandler.upPress == true){
            velocityY = velocityY-8;
        }
        System.out.println(spriteCounter++);
    }

    @Override
    public void draw(java.awt.Graphics2D g) {
       
        g.setColor(java.awt.Color.BLACK);
        g.fillRect(0, 0, constValues.WIDTH, constValues.HEIGHT);        
        
        if(gsm.keyHandler.rightPress){
            g.drawImage(walkForward[0], velocityX, velocityY,null);
            lastSprite = walkForward[0];
        }
        else if(gsm.keyHandler.leftPress){
            g.drawImage(walkBackward[0], velocityX, velocityY,null);
            lastSprite = walkBackward[0];
        }else{
            g.drawImage(lastSprite, velocityX, velocityY,null);
        }
        
        
    }
    
}
