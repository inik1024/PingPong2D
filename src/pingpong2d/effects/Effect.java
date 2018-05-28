/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pingpong2d.effects;

import java.awt.Color;
import java.awt.Graphics;
import pingpong2d.entities.Entity;
import pingpong2d.game.Game;

/**
 *
 * @author Drahos
 */
public class Effect extends Entity {
    
    /**
     * milliseconds
     */
    protected double duration;
    
    private int frame = 0;
    
    private boolean continuous = false;
    
    public Effect(Game game, double x, double y, double width, double height, Color color, double duration) {
        super(game, x, y, width, height, color);
        this.duration = duration;
    }
    
    @Override
    public void update() {
        //double fps = game.getFPS();
        
        
    }
    
    @Override
    public void render(Graphics g) {
        double fps = game.getFPS();
        if(frame <= duration*(fps/1000.0)) {
            System.out.println("frame:"+frame);
            g.setColor(color);
            g.fillRect((int)x, (int)y, (int)width, (int)height);
            frame++;
            
        } else
        if(continuous) {
            frame = 0;
        }
        
    }

    public int getFrame() {
        return frame;
    }

    public void setFrame(int frame) {
        this.frame = frame;
    }
    
    /**
     * milliseconds
     * 
     * @return <code>duration</code> in milliseconds
     */
    public double getDuration() {
        return duration;
    }
    
    /**
     * set the effect's duration in milliseconds
     * @param duration
     */
    public void setDuration(double duration) {
        this.duration = duration;
    }

    public boolean isContinuous() {
        return continuous;
    }

    public void setContinuous(boolean continuous) {
        this.continuous = continuous;
    } 
}
