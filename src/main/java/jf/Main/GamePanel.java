/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jf.Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author juliano
 */
public class GamePanel extends JPanel{
    public static final int HEIGHT = 1024;
    public static final int WIDTH = 1280;
    public static final int SCALE = 2;
    
    private Thread gameThread;
    private Graphics gphs;
    private boolean running;
    
    public GamePanel(){
        setBackground(Color.white);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        requestFocus();
    }


}
