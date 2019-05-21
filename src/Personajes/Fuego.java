/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personajes;

import Elementos.Alerta;
import Elementos.Bocadillo;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author lucas
 */
public class Fuego extends PersonajeGeneral {

    String dir;
    Animation up,down;
    
    
    public Fuego(String dir, float x, float y, String texto) {
        try {
            
            //Colocacion personaje
            this.coordenadaX = x;
            this.coordenadaY = y;
            this.dir = dir;
            int []duration = {200,200,200,200};
            //Creacion hitbox
            hitbox = new Rectangle(coordenadaX + 17, coordenadaY + 10, 30, 50);

            //Animaciones parado
             Image[] movementUp = {new Image("ImagenesSprite\\BossFinal\\"+texto+"0.png"), new Image("ImagenesSprite\\BossFinal\\"+texto+"1.png"), new Image("ImagenesSprite\\BossFinal\\"+texto+"2.png"), new Image("ImagenesSprite\\BossFinal\\"+texto+"3.png")};
           
            actual = new Animation(movementUp, duration, false);

            
            
            //No SBG
            sgb=-1;
        } catch (SlickException e) {
        }
    }

    public void setDir(String string) {
        switch (string) {
            case "up":
                actual = up;
                break;
            case "down":
                actual = down;
                break;
            case "right":
                actual = right;
                break;
            case "left":
                actual = left;
                break;
            case "sup":
                actual = sup;
                break;
            case "sdown":
                actual = sdown;
                break;
            case "sright":
                actual = sright;
                break;
            case "sleft":
                actual = sleft;
                break;
        }
    }

    public void move() {
    }
    
    public void setCoordenadas(float x,float y)
    {
        this.coordenadaX=x;
        this.coordenadaY=y;
    }
    
    public float getCoordenadaX()
    {
        return this.coordenadaX;
    }
    
    public float getCoordenadaY()
    {
        return this.coordenadaY;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    public void talk() {
        bocadillo.dentro();
    }

    public Bocadillo getTalk() {
        return bocadillo;
    }

    public void noTalk() {
        bocadillo.fuera();
    }
    
    public Alerta getAlerta(){
        return alerta;
    }
    
    public void alerta() {
        alerta.dentro((int) coordenadaX+20, (int) coordenadaY - 20);
    }
    
    public void noAlerta() {
        alerta.fuera();
    }

}
