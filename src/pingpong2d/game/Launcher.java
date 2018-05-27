/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pingpong2d.game;

/**
 * PingPong is comming  
 * 
 * @author Drahos
 */
public class Launcher {
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Game g = new Game(800, 600);
        g.start();
    }
}
