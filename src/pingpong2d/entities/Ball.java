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
public class Ball extends Entity {
    
    private double dx, dy;
    
    private double directionLineLength = 100;
    
    private boolean setDirectionLineVisible = false;
    private boolean manualFreeMovement = false;
    
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
    public Ball(Game game, double x, double y, double width, double height, double xvel, double yvel, Color color) {
        super(game, x, y, width, height, xvel, yvel, color);
    }

    /**
     *
     */
    @Override
    public void update() {
        //developement
        //System.out.println("angle:"+angle);
        //DEVELOPEMENT
        /*if(isColBorder()) {
            /*
            if(getColBorder() == 1) {
                    
            }
            if(getColBorder() == 2) {
                
            }
        }*/
        
        move();
        
    }

    /**
     *
     * @param g
     */
    @Override
    public void render(Graphics g) {
        g.setColor(color);
        g.fillOval((int)x, (int)y, (int)width, (int)height);
        
        //drawDirectionLine(g);
    }
    
    private void drawDirectionLine(Graphics g) {
        g.setColor(Color.RED);
        g.drawLine((int)(x+width/2), (int)(y+height/2), (int)(dx+x+width/2), (int)(dy+y+height/2));
        g.drawLine((int)(x+width/2), (int)(y+height/2), (int)(dx+x+width/2), (int)(dy+y+height/2));
    }
    
    /**
     *
     */
    protected void move() {
        if(isManualFreeMovement()) {
            manualControl();
        } else {
            continuousMovement();
        }
    }
    
    private void manualControl() {
        double fps = game.getFPS();
        
        KeyboardManager keyboard = game.getKeyboard();
        double vel = velocity/fps;
        //manual control
        if(keyboard.RIGHT) {
            if(angle+vel > 360.0) {
                angle = 0.0+vel;
            } else {
                angle += vel;
            }
            System.out.println("R angle:"+angle);
        } 
        if(keyboard.LEFT) {
            if(angle+vel < 0.0) {
                angle = 360.0-vel;
            } else {
                angle -= vel;
            }
            System.out.println("L angle:"+angle);
        }
        
        //System.out.println("angle:"+angle);
        
        double[] vels = getREaIMfromANaVA(Math.toRadians(angle), vel);
        
        xvel = vels[0];
        yvel = vels[1];
        
        double tmpxvel = vels[0];
        double tmpyvel = vels[1];
        //System.out.println("xvel:"+xvel+", yvel:"+yvel);
        
        if(keyboard.UP) {
            isMoving = true;
            xvel = tmpxvel;
            yvel = tmpyvel;
            //System.out.println("UP xvel:"+xvel+", yvel:"+yvel);
        }else
        if(keyboard.DOWN) {
            isMoving = true;
            xvel = -tmpxvel;
            yvel = -tmpyvel;
            //System.out.println("DOWN xvel:"+xvel+", yvel:"+yvel);
        } else {
            isMoving = false;
        }
        
        if(!isMoving) {
            xvel = 0.0;
            yvel = 0.0;
        }
        
        
        //System.out.println("xvel:"+xvel+", yvel:"+yvel);
        
        x += xvel;
        y += yvel;
        
        //relative x and y coordinates for the directionLine
        double[] dees = getREaIMfromANaVA(Math.toRadians(angle), directionLineLength);
        dx = dees[0];
        dy = dees[1];
    }
    
    private void continuousMovement() {
        double fps = game.getFPS();
        
        /*double vel = velocity/fps;
        isMoving = true;
        
        if(angle+vel >= 360) {
            angle = 0;
        } else {
            angle += vel;
        }
        if(angle+vel <= 0) {
            angle = 360;
        } else {
            angle -= vel;
        }*/
          
        x += xvel/fps;
        y += yvel/fps;
        
        double[] tmp0 = getANaVAfromREaIM(xvel, yvel);
        angle = Math.toDegrees(tmp0[0]);
        
        
        double[] dees = getREaIMfromANaVA(Math.toRadians(angle), directionLineLength);
        dx = dees[0];
        dy = dees[1];
    }
    
    /**
     *
     * @return
     */
    public double getDirectionLineLength() {
        return directionLineLength;
    }
    
    /**
     *
     * @param directionLineLength
     */
    public void setDirectionLineLength(double directionLineLength) {
        this.directionLineLength = directionLineLength;
    }

    /**
     *
     * @return
     */
    public boolean isManualFreeMovement() {
        return manualFreeMovement;
    }

    /**
     *
     * @param manualFreeMovement
     */
    public void setManualFreeMovement(boolean manualFreeMovement) {
        this.manualFreeMovement = manualFreeMovement;
    }
    
    
}
