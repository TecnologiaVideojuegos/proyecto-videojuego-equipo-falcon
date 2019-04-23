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
public class PersonajeUpDown extends PersonajeGeneral {

    Animation up, down;
    
    public PersonajeUpDown(float x, float y,String texto) {
        try {
            
            //Colocacion personaje
            this.coordenadaX = x;
            this.coordenadaY = y;

            //Creacion hitbox
            hitbox = new Rectangle(coordenadaX + 17, coordenadaY + 10, 30, 50);

            //Animaciones movimiento
            Image[] movementUp = {new Image("ImagenesSprite\\Marinero\\up1.png"), new Image("ImagenesSprite\\Marinero\\up2.png")};
            Image[] movementDown = {new Image("ImagenesSprite\\Marinero\\down1.png"), new Image("ImagenesSprite\\Marinero\\down2.png")};
            up = new Animation(movementUp, duration, false);
            down = new Animation(movementDown, duration, false);

            //Animaciones parado
            Image[] stanceDown = {new Image("ImagenesSprite\\Marinero\\down0.png"), new Image("ImagenesSprite\\Marinero\\down0.png")};
            Image[] stanceUp = {new Image("ImagenesSprite\\Marinero\\up0.png"), new Image("ImagenesSprite\\Marinero\\up0.png")};
            Image[] stanceLeft = {new Image("ImagenesSprite\\Marinero\\izq0.png"), new Image("ImagenesSprite\\Marinero\\izq0.png")};
            Image[] stanceRight = {new Image("ImagenesSprite\\Marinero\\der0.png"), new Image("ImagenesSprite\\Marinero\\der0.png")};
            sup = new Animation(stanceUp, duration, false);
            sdown = new Animation(stanceDown, duration, false);
            sleft = new Animation(stanceLeft, duration, false);
            sright = new Animation(stanceRight, duration, false);

            //Animacion inicial
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
        if (desplazamiento < 500) {
            coordenadaY = coordenadaY + (float) (0.5);
            desplazamiento ++;
            setDir("down");
        } else if (desplazamiento >= 500 && desplazamiento < 900) {
            desplazamiento ++;
            setDir("sdown");
        } else if (desplazamiento >= 900 && desplazamiento < 1400) {
            desplazamiento ++;
            coordenadaY = coordenadaY - (float) (0.5);
            setDir("up");
        } else if (desplazamiento >= 1400 && desplazamiento < 1800) {
            desplazamiento ++;
            setDir("sup");
        } else {
            desplazamiento = 0;
        }
        hitbox.setBounds(coordenadaX + 17, coordenadaY + 10, 30, 50);
    }
}
