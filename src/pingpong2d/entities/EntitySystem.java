/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pingpong2d.entities;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 *  this class is responsible for all entities updating and rendering
 * 
 * @author Drahos
 */
public class EntitySystem extends ArrayList {
    
    /**
     * updates variables
     */
    public void update() {
        for(Entity e : (ArrayList<Entity>)this) {
            if(e != null) {
                e.update();
            }
        }
    }
    /**
     * uses updated variables and draws the content to the screen
     * @param g
     */
    public void render(Graphics g) {
        for(Entity e : (ArrayList<Entity>)this) {
            if(e != null) {
                e.render(g);
            }
        }
    }
}
