/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameState;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author juliano
 */
public class MouseHandler implements MouseListener {

    public Point p = new Point();
    int clickCount = 0;
        
    @Override
    public void mouseClicked(MouseEvent e) {
        p = e.getPoint();
        clickCount = e.getClickCount();
        System.out.println(String.format("X: %s, Y: %s", p.x, p.y));
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
