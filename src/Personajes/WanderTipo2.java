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
public class WanderTipo2 extends WanderTipoT {

    float coordenadaX = 500, coordenadaY = 450;
    Image[] movementUp;
    Image[] movementDown;
    Image[] movementLeft;
    Image[] movementRight;
    Animation actual, up, down, sleft, sright, sup, sdown;
    int[] duration = {200, 200};
    Rectangle h1;
    Bocadillo bocadillo = new Bocadillo();
    int desplazamiento = 0;
    
    public WanderTipo2(float x, float y) {
        try {
            //Colocacion personaje
            this.coordenadaX = x;
            this.coordenadaY = y;

            //Creacion hitbox
            h1 = new Rectangle(coordenadaX + 17, coordenadaY + 10, 30, 50);

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

    public Animation getDir() {
        return actual;
    }

    public float getCoordenadaX() {
        return this.coordenadaX;
    }

    public float getCoordenadaY() {
        return this.coordenadaY;
    }

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
        h1.setBounds(coordenadaX + 17, coordenadaY + 10, 30, 50);
    }

    public Rectangle getHitbox() {
        return h1;
    }
    
    public void talk() {
        bocadillo.dentro((int) coordenadaX + 20, (int) coordenadaY - 20);
    }

    public Bocadillo getTalk() {
        return bocadillo;
    }

    public void noTalk() {
        bocadillo.fuera();
    }
}
