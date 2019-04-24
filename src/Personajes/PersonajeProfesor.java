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

/**
 *
 * @author lucas
 */
public class PersonajeProfesor extends PersonajeGeneral{

    int[] duration = {1500, 100, 100, 100, 100, 1100};
    public PersonajeProfesor() {
        try {
            
            sgb=-1;
            coordenadaX=900;
            coordenadaY=20;
            hitbox.setBounds(coordenadaX, coordenadaY, 85, 70);
            Image[] lanzaPelotas = {new Image("SpriteBoss1\\1.png"), new Image("SpriteBoss1\\2.png"), new Image("SpriteBoss1\\3.png"), new Image("SpriteBoss1\\4.png"), new Image("SpriteBoss1\\5.png"), new Image("SpriteBoss1\\6.png")};
            actual = new Animation(lanzaPelotas, duration, false);

        } catch (SlickException e) {
        }
    }

    public void noLanza(){
        try {
            Image[] lanzaPelotas = {new Image("SpriteBoss1\\1.png"), new Image("SpriteBoss1\\1.png")};
            actual = new Animation(lanzaPelotas, new int[]{duration[0],duration[1]}, false);
        } catch (SlickException ex) {
        }
    }
    
    public void lanza(){
        try {
            Image[] lanzaPelotas = {new Image("SpriteBoss1\\1.png"), new Image("SpriteBoss1\\2.png"), new Image("SpriteBoss1\\3.png"), new Image("SpriteBoss1\\4.png"), new Image("SpriteBoss1\\5.png"), new Image("SpriteBoss1\\6.png")};
            actual = new Animation(lanzaPelotas, duration, false);
        } catch (SlickException ex) {
            Logger.getLogger(PersonajeProfesor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void setDir(String string){
    }
    
    public void setCoord(int x, int y) {
        coordenadaX=x;
        coordenadaY=y;
        hitbox.setBounds(x, y, 85, 70);
    }
    
    public void setSGB()
    {
        sgb=20;
    }
    
    @Override
    public void move() {
        hitbox.setBounds(coordenadaX, coordenadaY+15, 90, 75);
    }
    
}
