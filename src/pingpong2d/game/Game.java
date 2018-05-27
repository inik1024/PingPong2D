/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pingpong2d.game;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import pingpong2d.display.Display;
import pingpong2d.states.GameState;
import pingpong2d.states.State;
import pingpong2d.userinput.KeyboardManager;
import pingpong2d.userinput.MouseManager;

/**
 *
 * @author Drahos
 */
public class Game implements Runnable{
    
    private Thread thread;
    private boolean running = false;
    private final int WIDTH, HEIGHT;
    private int FPS_LIMIT = 344;
    private int fps = FPS_LIMIT;
    
    private Display display;
    
    private KeyboardManager keyboard;
    
    private MouseManager mouse;
    
    //States
    private GameState gameState;
    
    //tmp
    //private int time = 0;

    /**
     *
     * @param width
     * @param height
     */
    
    public Game(int width, int height) {
        WIDTH = width;
        HEIGHT = height;
    }
    
    /**
     *
     */
    public void start() {
        if(running) {
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    
    /**
     *
     */
    public void stop() {
        if(!running) {
            return;
        }
        running = false;
        try {
            thread.join();
        } catch (Exception e) {}
    }
    
    private void setup() {
        keyboard = new KeyboardManager(this);
        mouse = new MouseManager(this);
        
        gameState = new GameState(this);
        State.setState(gameState);
        
        display = new Display(WIDTH, HEIGHT, "Ping-Pong");
        JFrame jframe = display.getJFrame();
        Canvas canvas = display.getCanvas();
        
        jframe.setVisible(true);
        jframe.addKeyListener(keyboard);
        canvas.addMouseListener(mouse);
        canvas.addMouseMotionListener(mouse);
    }
    
    private void update(int fps) {
        if(State.getState() != null) {
            State.getState().update();
        }
    }
    
    private void render() {
        BufferStrategy bs = display.getCanvas().getBufferStrategy();
        if(bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        //clear screen
        
        g.clearRect(0, 0, WIDTH, HEIGHT);
        
        
        //draw
        if(State.getState() != null) {
            State.getState().render(g);
        }
        //g.drawRect(100, 100, 100, 100);
        if(System.getProperty("os.name").toUpperCase().contains("LINUX")) {
            Toolkit.getDefaultToolkit().sync();
        }
        
        bs.show();
        g.dispose();
        
    }
    
    @Override
    public void run() {
        setup();
        
        long now, last;
        double max = 1000000000.0 / (double)FPS_LIMIT;
        double pt = 0;
        
        
        int updates = 0;
        double pu = 0;
        last = System.nanoTime();
        while(running) {   
            
            now  = System.nanoTime();
            pu   += (now - last) / max;
            pt   += (now - last) / max;
            last = now;
            
            if(pu >= 1) {
                update(fps);
                render();
                pu = 0;
                updates++;
            }
            if(pt >= FPS_LIMIT*2) {
                fps = updates/2;
                System.out.println("FPS:"+fps);
                updates = 0;
                pt = 0;
            }
        }
    }
    
    /**
     *
     * @return
     */
    public int getFPS() {
        return fps;
    }

    /**
     *
     * @return
     */
    public KeyboardManager getKeyboard() {
        return keyboard;
    }

    /**
     *
     * @return
     */
    public MouseManager getMouse() {
        return mouse;
    }

    /**
     *
     * @return
     */
    public int getWIDTH() {
        return WIDTH;
    }

    /**
     *
     * @return
     */
    public int getHEIGHT() {
        return HEIGHT;
    }
}
