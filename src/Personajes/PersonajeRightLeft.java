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
public class PersonajeRightLeft extends PersonajeGeneral {

    public PersonajeRightLeft(float x, float y) {
        try {
            
            //Colocacion personaje
            this.coordenadaX = x;
            this.coordenadaY = y;
            
            //Creacion hitbox
            hitbox = new Rectangle(coordenadaX + 17, coordenadaY + 10, 30, 50);
            
            //Animaciones movimiento
            Image[] movementLeft = {new Image("ImagenesSprite\\Madre\\izq1.png"), new Image("ImagenesSprite\\Madre\\izq2.png"), new Image("ImagenesSprite\\Madre\\izq3.png"), new Image("ImagenesSprite\\Madre\\izq4.png"), new Image("ImagenesSprite\\Madre\\izq5.png"), new Image("ImagenesSprite\\Madre\\izq6.png"), new Image("ImagenesSprite\\Madre\\izq7.png"), new Image("ImagenesSprite\\Madre\\izq8.png")};
            Image[] movementRight = {new Image("ImagenesSprite\\Madre\\der1.png"), new Image("ImagenesSprite\\Madre\\der2.png"), new Image("ImagenesSprite\\Madre\\der3.png"), new Image("ImagenesSprite\\Madre\\der4.png"), new Image("ImagenesSprite\\Madre\\der5.png"), new Image("ImagenesSprite\\Madre\\der6.png"), new Image("ImagenesSprite\\Madre\\der7.png"), new Image("ImagenesSprite\\Madre\\der8.png")};
            left = new Animation(movementLeft, duration2, false);
            right = new Animation(movementRight, duration2, false);
            
            //Animaciones parado
            Image[] stanceDown = {new Image("ImagenesSprite\\Madre\\down0.png"), new Image("ImagenesSprite\\Madre\\down0.png")};
            Image[] stanceUp = {new Image("ImagenesSprite\\Madre\\up0.png"), new Image("ImagenesSprite\\Madre\\up0.png")};
            Image[] stanceLeft = {new Image("ImagenesSprite\\Madre\\izq0.png"), new Image("ImagenesSprite\\Madre\\izq0.png")};
            Image[] stanceRight = {new Image("ImagenesSprite\\Madre\\der0.png"), new Image("ImagenesSprite\\Madre\\der0.png")};
            sup = new Animation(stanceUp, duration, false);
            sdown = new Animation(stanceDown, duration, false);
            sleft = new Animation(stanceLeft, duration, false);
            sright = new Animation(stanceRight, duration, false);

            //Animacion inicial
            actual = right;
            
            //Bocadillo
            bocadillo = new Bocadillo("bocadilloMadre");
            
            //No enterSBG
            sgb=-1;
        } catch (SlickException e) {
        }
    }


    @Override
    public void setDir(String string) {
        switch (string) {
            case "sup":
                actual = sup;
                break;
            case "sdown":
                actual = sdown;
                break;
            case "right":
                actual = right;
                break;
            case "left":
                actual = left;
                break;
            case "sright":
                actual = sright;
                break;
            case "sleft":
                actual = sleft;
                break;
        }
    }

    @Override
    public void move() {
        if (desplazamiento < 200) {
            coordenadaX = coordenadaX + (float) (0.5);
            desplazamiento ++;
            setDir("right");
        } else if (desplazamiento >= 200 && desplazamiento < 1200) {
            desplazamiento ++;
            setDir("sup");
        } else if (desplazamiento >= 1200 && desplazamiento < 1400) {
            desplazamiento ++;
            coordenadaX = coordenadaX - (float) (0.5);
            setDir("left");
        } else if (desplazamiento >= 1400 && desplazamiento < 2400) {
            desplazamiento ++;
            setDir("sup");
        } else {
            desplazamiento = 0;
        }
        hitbox.setBounds(coordenadaX + 17, coordenadaY + 10, 30, 50);
    }
}