/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pingpong2d.display;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Drahos
 */
public class Display {
    
    private JFrame frame;
    private int width, height;
    private String title;
    private Canvas canvas;
    
    /**
     *
     * @param width
     * @param height
     * @param title
     */
    public Display(int width, int height, String title) {
        this.width  = width;
        this.height = height;
        this.title  = title;
        
        initW();
        
    }
    
    /**
     *
     */
    public void initW() {
        canvas = new Canvas();
        Dimension d = new Dimension(width, height);
        canvas.setPreferredSize(d);
        canvas.setMaximumSize(d);
        canvas.setMinimumSize(d);
        canvas.setFocusable(false);
        canvas.setBackground(Color.BLACK);
        
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setFocusable(true);
        frame.setUndecorated(true);
        
        frame.add(canvas);
        frame.pack();
    }

    /**
     *
     * @return
     */
    public JFrame getJFrame() {
        return frame;
    }

    /**
     *
     * @return
     */
    public Canvas getCanvas() {
        return canvas;
    }
    
}
