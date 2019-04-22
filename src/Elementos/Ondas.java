/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author lucas
 */
public class Ondas {

    float coordenadaX = -1000, coordenadaY = -1000;
    Image[] foto;
    Animation mover;

    public Ondas(String nombre) {
        try {
            foto = new Image[]{new Image("\\Elementos Aparte\\talk5.png"),new Image("\\Elementos Aparte\\talk7.png"),new Image("\\Elementos Aparte\\talk8.png"),new Image("\\Elementos Aparte\\talk9.png")};
            mover = new Animation(foto,new int[]{100,100,100,100},false);
        } catch (SlickException ex) {
        }
    }

    public void dentro() {
        coordenadaX = 580;
        coordenadaY = 200;
    }

    public void dentroXY(float x, float y) {
        coordenadaX = x;
        coordenadaY = y;
    }
    
    public void fuera() {
        coordenadaX = -1000;
        coordenadaY = -1000;
    }

    public float getCoordenadaX(){
        return coordenadaX;
    }
    public float getCoordenadaY(){
        return coordenadaY;
    }
    public Animation getImagen() {
        return mover;
    }
}
