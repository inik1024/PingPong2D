/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pingpong2d.states;

import java.awt.Graphics;
import pingpong2d.game.Game;

/**
 *
 * @author Drahos
 */
public abstract class State {
    private static State currentState;
    
    /**
     *
     * @param state
     */
    public static void setState(State state) {
        currentState = state;
    }
    
    /**
     *
     * @return
     */
    public static State getState() {
        return currentState;
    }
    
    /**
     *
     */
    protected Game game;
    
    /**
     *
     * @param game
     */
    public State(Game game) {
        this.game = game;
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
}
