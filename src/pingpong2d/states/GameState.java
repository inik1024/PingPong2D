/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pingpong2d.states;

import java.awt.Color;
import java.awt.Graphics;
import pingpong2d.entities.Ball;
import pingpong2d.entities.Bat;
import pingpong2d.entities.EntitySystem;
import pingpong2d.game.Game;
import pingpong2d.userinput.KeyboardManager;

/**
 *
 * @author Drahos
 */
public class GameState extends State {

    private EntitySystem eS;
    
    private Ball ball, ball0;
    private Bat right, left;
    private KeyboardManager keyboard;
            
    private int success = 0;
    
    /**
     *
     * @param game
     */
    public GameState(Game game) {
        super(game);
        eS = new EntitySystem();
        
        ball  = new Ball(game, 700.0, (Math.random()*(game.getHEIGHT()-30.0))+0, 30.0, 30.0, -230.0, 10.0, Color.WHITE);
        /*ball.setManualFreeMovement(false);
        ball.setDirectionLineLength(15);*/
        
        //right = new Bat(game, 30.0, 100.0, 30.0, 100.0, 0.0, 400.0, Color.WHITE);
        //right.setRightSide(true);
        
        System.out.println("press W or S to move the bat UP or DOWN");
        System.err.println("If you may not be able to hit the ball, because it exits the window,\nyou are just unlucky ;)");
        
        
        left = new Bat(game, 30.0, (game.getHEIGHT()-100.0)/2, 30.0, 100.0, 0.0, 400.0, Color.WHITE);
        
        /*
        ball0  = new Ball(game, 300, 100, 30, 30, 25, 0, Color.WHITE);
        ball0.setDirectionLineLength(15);
        ball0.setManualFreeMovement(false);*/
       
        
        eS.add(ball);
        //eS.add(ball0);
        //eS.add(right);
        eS.add(left);

        
        keyboard = game.getKeyboard();
        //System.out.println("eS-S:"+eS.size());
    }

    /**
     *
     */
    @Override
    public void update() {
        keyboard.update();
        eS.update();
        
        if(keyboard.ESC) {
            System.exit(0);
        }
        
        //opBat.isColEntity(batR);
        if(ball != null && success == 0) {
            if(left.isColEntity(ball)) {
                ball.setXvel(-ball.getXvel());
                ball.setYvel((Math.random()*80)-40);
                //System.out.println("yvel:"+ball.getYvel());
                //System.out.println("collision with entity");
                success = 2;
            }
            if(ball.isColBorder()) {
                //System.out.println("collision with border");
               
                success = 1;
                ball = null;
            }
            
            if(success != 0) {
                if(success == 1) {
                    System.out.println("you lost, press escape to exit the game");
                } else 
                if(success == 2) {
                    System.out.println("you won, press escape to exit the game");
                }
            }
            
        }    
    }

    /**
     *
     * @param g
     */
    @Override
    public void render(Graphics g) {
        eS.render(g);
        //System.out.println("eS-D:"+eS.size());
    }
    
}
