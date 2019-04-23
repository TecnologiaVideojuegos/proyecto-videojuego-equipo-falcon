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
public class PersonajeEstatico extends PersonajeGeneral {

    String dir;

    public PersonajeEstatico(String dir, float x, float y, String texto) {
        try {
            
            //Colocacion personaje
            this.coordenadaX = x;
            this.coordenadaY = y;
            this.dir = dir;

            //Creacion hitbox
            hitbox = new Rectangle(coordenadaX + 17, coordenadaY + 10, 30, 50);

            //Animaciones parado
            Image[] stanceDown = {new Image("ImagenesSprite\\Marinero\\down0.png"), new Image("ImagenesSprite\\Marinero\\down0.png")};
            Image[] stanceUp = {new Image("ImagenesSprite\\Marinero\\up0.png"), new Image("ImagenesSprite\\Marinero\\up0.png")};
            Image[] stanceLeft = {new Image("ImagenesSprite\\Marinero\\izq0.png"), new Image("ImagenesSprite\\Marinero\\izq0.png")};
            Image[] stanceRight = {new Image("ImagenesSprite\\Marinero\\der0.png"), new Image("ImagenesSprite\\Marinero\\der0.png")};
            sup = new Animation(stanceUp, duration, false);
            sdown = new Animation(stanceDown, duration, false);
            sleft = new Animation(stanceLeft, duration, false);
            sright = new Animation(stanceRight, duration, false);

            if (dir.equals("left")) {
                actual = sleft;
            } else if(dir.equals("right")){
                actual = sright;
            } else if(dir.equals("up")){
                actual = sup;
            } else {
                actual = sdown;
            }
            
            //Bocadillo
            bocadillo = new Bocadillo(texto);
            
            //No SBG
            sgb=-1;
        } catch (SlickException e) {
        }
    }

    public void setDir(String string) {
        switch (string) {
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
        if ((dir).equals("left")) {
            setDir("sleft");
        } else if ((dir).equals("right")) {
            setDir("sright");
        }  else if ((dir).equals("up")) {
            setDir("sup");
        } else if ((dir).equals("down")) {
            setDir("sdown");
        }
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
