/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pingpong2d.userinput;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import pingpong2d.game.Game;

/**
 * Simply manages the users keyboard input
 * 
 * @author Drahos
 */
public class KeyboardManager implements KeyListener{
    
    private Game game;
    
    private boolean key[];
    
    /**
     *
     */
    public boolean  UP     = false,
 
    /**
     *
     */
    RIGHT  = false, 
 
    /**
     *
     */
    DOWN   = false, 

    /**
     *
     */
    LEFT   = false,

    /**
     *
     */
    W = false,

    /**
     *
     */
    S = false,

    /**
     *
     */
    ESC    = false;
    
    /**
     *
     * @param game
     */
    public KeyboardManager(Game game) {
        key = new boolean[256];
    }
    
    /**
     *
     */
    public void update() {
        UP      = key[KeyEvent.VK_UP];
        RIGHT   = key[KeyEvent.VK_RIGHT];
        DOWN    = key[KeyEvent.VK_DOWN];
        LEFT    = key[KeyEvent.VK_LEFT];
        W       = key[KeyEvent.VK_W];
        S       = key[KeyEvent.VK_S];
        ESC     = key[KeyEvent.VK_ESCAPE];
        
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {
        key[ke.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        key[ke.getKeyCode()] = false;
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
    
    
    
}
