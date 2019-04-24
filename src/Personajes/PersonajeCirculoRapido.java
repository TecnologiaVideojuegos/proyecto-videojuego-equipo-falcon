/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personajes;

import Elementos.Bocadillo;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author lucas
 */
public class PersonajeCirculoRapido extends PersonajeGeneral {

    Animation  up, down;

    public PersonajeCirculoRapido(float x, float y, String texto) {
        try {
            
            //Colocacion personaje
            this.coordenadaX=x;
            this.coordenadaY=y;
            
            //Creacion hitbox
            hitbox = new Rectangle(coordenadaX + 17, coordenadaY + 10, 30, 50);

            //Animaciones movimiento
            Image[] movementUp = {new Image("ImagenesSprite\\Niño\\up1.png"), new Image("ImagenesSprite\\Niño\\up2.png")};
            Image[] movementDown = {new Image("ImagenesSprite\\Niño\\down1.png"), new Image("ImagenesSprite\\Niño\\down2.png")};
            Image[] movementLeft = {new Image("ImagenesSprite\\Niño\\izq1.png"), new Image("ImagenesSprite\\Niño\\izq2.png"), new Image("ImagenesSprite\\Niño\\izq3.png"), new Image("ImagenesSprite\\Niño\\izq4.png"), new Image("ImagenesSprite\\Niño\\izq5.png"), new Image("ImagenesSprite\\Niño\\izq6.png"), new Image("ImagenesSprite\\Niño\\izq7.png"), new Image("ImagenesSprite\\Niño\\izq8.png")};
            Image[] movementRight = {new Image("ImagenesSprite\\Niño\\der1.png"), new Image("ImagenesSprite\\Niño\\der2.png"), new Image("ImagenesSprite\\Niño\\der3.png"), new Image("ImagenesSprite\\Niño\\der4.png"), new Image("ImagenesSprite\\Niño\\der5.png"), new Image("ImagenesSprite\\Niño\\der6.png"), new Image("ImagenesSprite\\Niño\\der7.png"), new Image("ImagenesSprite\\Niño\\der8.png")};
            up = new Animation(movementUp, duration, false);
            down = new Animation(movementDown, duration, false);
            left = new Animation(movementLeft, duration2, false);
            right = new Animation(movementRight, duration2, false);
            
            //Animaciones parado
            Image[] stanceDown = {new Image("ImagenesSprite\\Niño\\down0.png"), new Image("ImagenesSprite\\Niño\\down0.png")};
            Image[] stanceUp = {new Image("ImagenesSprite\\Niño\\up0.png"), new Image("ImagenesSprite\\Niño\\up0.png")};
            Image[] stanceLeft = {new Image("ImagenesSprite\\Niño\\izq0.png"), new Image("ImagenesSprite\\Niño\\izq0.png")};
            Image[] stanceRight = {new Image("ImagenesSprite\\Niño\\der0.png"), new Image("ImagenesSprite\\Niño\\der0.png")};
            sup = new Animation(stanceUp, duration, false);
            sdown = new Animation(stanceDown, duration, false);
            sleft = new Animation(stanceLeft, duration, false);
            sright = new Animation(stanceRight, duration, false);

            actual = up;
            
            //Bocadillo
            bocadillo = new Bocadillo(texto);
            //No SBG
            sgb=-1;
        } catch (SlickException e) {
        }
    }

    @Override
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

    @Override
    public void move() {
        if (desplazamiento < 100) {
            coordenadaY = coordenadaY + (float) (0.8);
            desplazamiento ++;
            setDir("down");
        } else if (desplazamiento >= 100 && desplazamiento < 200) {
            coordenadaX = coordenadaX - (float) (0.8);
            desplazamiento ++;
            setDir("left");
        } else if (desplazamiento >= 200 && desplazamiento < 300) {
            desplazamiento ++;
            coordenadaY = coordenadaY - (float) (0.8);
            setDir("up");
        } else if (desplazamiento >= 300 && desplazamiento < 400) {
            coordenadaX = coordenadaX + (float) (0.8);
            desplazamiento ++;
            setDir("right");
        } else {
            desplazamiento = 0;
        }
        hitbox.setBounds(coordenadaX + 17, coordenadaY + 10, 30, 50);
    }  
}
