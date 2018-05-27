/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pingpong2d.entities;

import java.awt.Color;
import java.awt.Graphics;
import pingpong2d.game.Game;
import pingpong2d.userinput.KeyboardManager;

/**
 *
 * @author Drahos
 */
public class Bat extends Entity {
    
    private boolean rightSide = false;
    
    /**
     *
     * @param game
     * @param x
     * @param y
     * @param width
     * @param height
     * @param xvel
     * @param yvel
     * @param color
     */
    public Bat(Game game, double x, double y, double width, double height, double xvel, double yvel, Color color) {
        super(game, x, y, width, height, xvel, yvel, color);
        this.color = color;
    }
    
    /**
     *
     */
    @Override
    public void update() {
        move();
    }
    
    /**
     *
     * @param g
     */
    @Override
    public void render(Graphics g) {
        g.setColor(color);
        
        if(isRightSide()) {
            g.fillRect((int)(game.getWIDTH()-(x+width)), (int)y, (int)width, (int)height);
        } else {
            g.fillRect((int)x, (int)y, (int)width, (int)height);
        }
    }
    
    private void move() {
        double fps = game.getFPS();
        KeyboardManager keyboard = game.getKeyboard();
        
        if(isRightSide()) {
            if(keyboard.UP) {
                y -= yvel/fps; 
            }
            if(keyboard.DOWN) {
                y += yvel/fps;
            }
        } else {
            if(keyboard.W) {
                y -= yvel/fps;
            }
            if(keyboard.S) {
                y += yvel/fps;
            }
        }
        
    }
    
    /**
     *
     * @param rightSide
     */
    public void setRightSide(boolean rightSide) {
        this.rightSide = rightSide;
    }
    
    /**
     * will set the positions, incrementing from the right side of the screen
     * expect bugs
     * 
     * @return <code>rightSide</code> 
     */
    public boolean isRightSide() {
        return rightSide;
    }
    
}