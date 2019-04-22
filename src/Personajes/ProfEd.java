/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personajes;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author lucas
 */
public class ProfEd extends WanderTipoT{

    Animation lanzar;
    int[] duration = {1500, 100, 100, 100, 100, 1100};
    int coordenadaX;
    int coordenadaY;
    public ProfEd() {
        try {
            sgb=20;
            coordenadaX=900;
            coordenadaY=20;
            
            Image[] lanzaPelotas = {new Image("SpriteBoss1\\1.png"), new Image("SpriteBoss1\\2.png"), new Image("SpriteBoss1\\3.png"), new Image("SpriteBoss1\\4.png"), new Image("SpriteBoss1\\5.png"), new Image("SpriteBoss1\\6.png")};
            lanzar = new Animation(lanzaPelotas, duration, false);

        } catch (SlickException e) {
        }
    }

    public void noLanza(){
        try {
            Image[] lanzaPelotas = {new Image("SpriteBoss1\\1.png"), new Image("SpriteBoss1\\1.png")};
            lanzar = new Animation(lanzaPelotas, new int[]{duration[0],duration[1]}, false);
        } catch (SlickException ex) {
        }
    }
    
    public void lanza(){
        try {
            Image[] lanzaPelotas = {new Image("SpriteBoss1\\1.png"), new Image("SpriteBoss1\\2.png"), new Image("SpriteBoss1\\3.png"), new Image("SpriteBoss1\\4.png"), new Image("SpriteBoss1\\5.png"), new Image("SpriteBoss1\\6.png")};
            lanzar = new Animation(lanzaPelotas, duration, false);
        } catch (SlickException ex) {
            Logger.getLogger(ProfEd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Animation getDir() {
        return lanzar;
    }
    
    public float getCoordenadaX() {
        return this.coordenadaX;
    }

    public float getCoordenadaY() {
        return this.coordenadaY;
    }

    public Rectangle getHitbox() {
        hitbox.setBounds(905, 40, 85, 70);
        return hitbox;
    }
    
}
