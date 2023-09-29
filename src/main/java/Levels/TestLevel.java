
package Levels;

import Entities.Player;
import GameState.GameStateManager;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author JJ
 */
public class TestLevel implements level {
    
    GameStateManager gsm;
    int tileSize = 16;
    
    BufferedImage tileset;
    BufferedImage[] grass;
    
    public TestLevel(GameStateManager gsm){
        this.gsm = gsm;
        tileset= null;
        grass = new BufferedImage[6];
        init();
    }
    
    public void loadTileMap(){
        try {
            tileset = ImageIO.read(Player.class.getResource("../assets/tilemap16.png"));
        } catch (IOException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
        int j = 0;
        for(int i = 0; i < 96; i+= 16){
            grass[j] = tileset.getSubimage(i, 464, tileSize, tileSize);

            j++;
        }
    }

    
    
    @Override
    public void init() {
        loadTileMap();
    }

    @Override
    public void draw(Graphics2D g) {
        for(int i = 0; i < 1024; i+=16){
        g.drawImage(grass[0], i, 128, null);
        g.drawImage(grass[1], i, 256, null);
        g.drawImage(grass[2], i, 512, null);
        }
    }

    @Override
    public void update() {
    }
    
    
}
