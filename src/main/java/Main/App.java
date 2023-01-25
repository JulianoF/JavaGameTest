

package Main;

import javax.swing.JFrame;
/**
 *
 * @author juliano
 */
public class App {

    public static void main(String[] args) {
        JFrame game = new JFrame("Hello World");
        game.setContentPane( new GamePanel());
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setResizable(false);
        game.pack();
        game.setVisible(true);
    }
}
