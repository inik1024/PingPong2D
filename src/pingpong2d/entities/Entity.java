/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pingpong2d.entities;

import java.awt.Color;
import java.awt.Graphics;
import pingpong2d.game.Game;

/**
 *  <code>Entity</code> is in this case the elementary thing that exists in the game
 *  the x-velocity's and y-velocity's metric is in pixels per second.
 *  
 * 
 * @author Drahos
 */
public abstract class Entity {
    
    /**
     *
     */
    protected double x, 

    /**
     *
     */
    y, 

    /**
     *
     */
    width, 

    /**
     *
     */
    height, 

    /**
     *
     */
    velocity, angle;//angle aka direction
    
    /**
     *
     */
    protected double xvel,

    /**
     *
     */
    yvel;
    
    /**
     *
     */
    protected Color color;
    
    /**
     *
     */
    protected Game game;
    
    /**
     *
     */
    protected boolean isMoving = false;
    
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
    public Entity(Game game, double x, double y, double width, double height, double xvel, double yvel, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.game = game;
        this.xvel = xvel;
        this.yvel = yvel;
        this.color = color;
    }
    
    public Entity(Game game, double x, double y, double width, double height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.game = game;
        this.xvel = 0;
        this.yvel = 0;
        this.color = color;
    }
    
    /**
     *
     */
    public abstract void update();
    
    /**
     *
     * @param g
     */
    public abstract void render(Graphics g);
  
    /**
     *
     * @param e
     * @return
     */
    public boolean isColEntity(Entity e) {
        
        if(e == null) {
            System.out.println("entity not found: "+e.getClass());
            return false;
        }
        
        double ex = e.getX();
        double ey = e.getY();
        
        double ew = e.getWidth();
        double eh = e.getHeight();
        /*
        System.out.println("ew:"+ew);
        System.out.println("eh:"+eh);
        System.out.println("ex:"+ex);
        System.out.println("ey:"+ey);*/
        
        if((x+width >= ex && x <= ex+ew) && (y+height >= ey && y <= ey+eh)) {
            return true;
        }
        

        
        /*if((x+width <= ex  && x >= ex+ew) && 
           (y+height <= ey && y >= ey+eh)
          ){
            return true;
        }*/
        
        return false;
    }
    
    /**
     *
     * @param e
     * @return
     */
    public boolean willColEntity(Entity e) {
        
        if(e == null) {
            return false;
        }
        
        double ex = e.getX();
        double ey = e.getY();
        double ewidth = e.getWidth();
        double eheight = e.getHeight();
        double exvel = e.getXvel();
        double eyvel = e.getYvel();
        
        
        return false;
    }
    
    /**
     * 
     * @return <code>true</code> if the entity is coliding with the border on any side
    */
    public boolean isColBorder() {
        
        if((x+width) >= game.getWIDTH()) {
            return true;
        }else
        if(x <= 0) {
            return true;
        }else
        if(y+height >= game.getHEIGHT()) {
            return true;
        }else
        if(y <= 0) {
            return true;
        } else {
            return false;
        }
        
    }
    /*
    public boolean willColBorder() {
        
        double vel = velocity/game.getFPS();
        
        if(!isMoving) {
            vel = 0;
        }
        
        if((x+width+vel) >= game.getWIDTH()) {
            return true;
        }else
        if(x-vel <= 0) {
            return true;
        }else
        if(y+height+vel >= game.getHEIGHT()) {
            return true;
        }else
        if(y-vel <= 0) {
            return true;
        } else {
            return false;
        }
        
    }*/
    
    /**
     *
     * @return
     */
    public short getColBorder() {
        
        double vel = velocity/game.getFPS();
        
        if(!isMoving) {
            vel = 0;
        }
        
              //+vel
        if((x+width) >= game.getWIDTH()) {
            return 2;
        }else //-vel
        if(x <= 0) {
            return 4;
        }else //+vel
        if(y+height >= game.getHEIGHT()) {
            return 3;
        }else //-vel
        if(y <= 0) {
            return 1;
        } else {
            return 0;
        }
    }
            
    /**
     *
     * @return
     */
    public double getX() {
        return x;
    }

    /**
     *
     * @param x
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     *
     * @return
     */
    public double getY() {
        return y;
    }

    /**
     *
     * @param y
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     *
     * @return
     */
    public double getWidth() {
        return width;
    }

    /**
     *
     * @param width
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     *
     * @return
     */
    public double getHeight() {
        return height;
    }

    /**
     *
     * @param height
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     *
     * @return
     */
    public double getVelocity() {
        return velocity;
    }

    /**
     *
     * @param velocity
     */
    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    /**
     *
     * @return
     */
    public double getAngle() {
        return angle;
    }

    /**
     *
     * @param angle
     */
    public void setAngle(double angle) {
        this.angle = angle;
    }

    /**
     *
     * @return
     */
    public double getXvel() {
        return xvel;
    }

    /**
     *
     * @param xvel
     */
    public void setXvel(double xvel) {
        this.xvel = xvel;
    }

    /**
     *
     * @return
     */
    public double getYvel() {
        return yvel;
    }

    /**
     *
     * @param yvel
     */
    public void setYvel(double yvel) {
        this.yvel = yvel;
    }
    
    /**
     *
     * @return
     */
    public Game getGame() {
        return game;
    }

    /**
     *
     * @param game
     */
    public void setGame(Game game) {
        this.game = game;
    }

    /**
     *
     * @return
     */
    public Color getColor() {
        return color;
    }

    /**
     *
     * @param color
     */
    public void setColor(Color color) {
        this.color = color;
    }
    
    /**
     *
     * @return
     */
    public boolean isMoving() {
        return this.isMoving;
    }
    
    /**
     *
     * @param isMoving
     */
    public void setMovementStatus(boolean isMoving) {
        this.isMoving = isMoving;
    }
    
    //UNUSED FUNCTIONS... for now
    
    /**
     * @param angle
     * @param value
     * @return <code>double[]</code> array, containing the real and imaginary number
     */
    public double[] getREaIMfromANaVA(double angle, double value) {
        double real = (value*Math.cos(angle));
        double imag = (value*Math.sin(angle));
        
        double[] reim = new double[2];
        reim[0] = real;
        reim[1] = imag;
        
        return reim;
    }
    
    /**
     * @param real
     * @param imag
     * @return <code>double[]</code> array, containing the angle and value number
     */
    public double[] getANaVAfromREaIM(double real, double imag) {
        double angle = Math.atan((imag/real));
        double value = Math.sqrt((Math.pow(real, 2) + Math.pow(imag, 2)));
        
        
        double[] anva = new double[2];
        anva[0] = angle;
        anva[1] = value;
        
        return anva;
    }
    
}
