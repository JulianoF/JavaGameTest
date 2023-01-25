

package jf.Main;

import javax.swing.JFrame;
/**
 *
 * @author juliano
 */
public class App {

    public static void main(String[] args) {
        JFrame game = new JFrame("2D Platformer");
        game.setContentPane( new GamePanel());
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setResizable(false);
        game.pack();
        game.setLocationRelativeTo(null);
        game.setVisible(true);
    }
}
