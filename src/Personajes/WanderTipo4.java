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
public class WanderTipo4 extends WanderTipoT {

    float coordenadaX = 500, coordenadaY = 450;
    Image[] movementUp;
    Image[] movementDown;
    Image[] movementLeft;
    Image[] movementRight;
    Animation actual, up, down, left, right, sleft, sright, sup, sdown;
    int[] duration = {200, 200};
    int[] duration2 = {100, 100, 100, 100, 100, 100, 100, 100};
    Rectangle hitbox;
    Bocadillo bocadillo = new Bocadillo();
    int desplazamiento=0;

    public WanderTipo4(float x, float y) {
        try {
            //Colocacion personaje
            this.coordenadaX=x;
            this.coordenadaY=y;
            
            //Creacion hitbox
            hitbox = new Rectangle(coordenadaX + 17, coordenadaY + 10, 30, 50);

            //Animaciones movimiento
            Image[] movementUp = {new Image("ImagenesSprite\\up1.png"), new Image("ImagenesSprite\\up2.png")};
            Image[] movementDown = {new Image("ImagenesSprite\\down1.png"), new Image("ImagenesSprite\\down2.png")};
            Image[] movementLeft = {new Image("ImagenesSprite\\izq1.png"), new Image("ImagenesSprite\\izq2.png"), new Image("ImagenesSprite\\izq3.png"), new Image("ImagenesSprite\\izq4.png"), new Image("ImagenesSprite\\izq5.png"), new Image("ImagenesSprite\\izq6.png"), new Image("ImagenesSprite\\izq7.png"), new Image("ImagenesSprite\\izq8.png")};
            Image[] movementRight = {new Image("ImagenesSprite\\der1.png"), new Image("ImagenesSprite\\der2.png"), new Image("ImagenesSprite\\der3.png"), new Image("ImagenesSprite\\der4.png"), new Image("ImagenesSprite\\der5.png"), new Image("ImagenesSprite\\der6.png"), new Image("ImagenesSprite\\der7.png"), new Image("ImagenesSprite\\der8.png")};
            up = new Animation(movementUp, duration, false);
            down = new Animation(movementDown, duration, false);
            left = new Animation(movementLeft, duration2, false);
            right = new Animation(movementRight, duration2, false);
            
            //Animaciones parado
            Image[] stanceDown = {new Image("ImagenesSprite\\down0.png"), new Image("ImagenesSprite\\down0.png")};
            Image[] stanceUp = {new Image("ImagenesSprite\\up0.png"), new Image("ImagenesSprite\\up0.png")};
            Image[] stanceLeft = {new Image("ImagenesSprite\\izq0.png"), new Image("ImagenesSprite\\izq0.png")};
            Image[] stanceRight = {new Image("ImagenesSprite\\der0.png"), new Image("ImagenesSprite\\der0.png")};
            sup = new Animation(stanceUp, duration, false);
            sdown = new Animation(stanceDown, duration, false);
            sleft = new Animation(stanceLeft, duration, false);
            sright = new Animation(stanceRight, duration, false);

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

    public Animation getDir() {
        return actual;
    }

    public float getCoordenadaY() {
        return this.coordenadaY;
    }

    public float getCoordenadaX() {
        return this.coordenadaX;
    }

    public void move() {
        if (desplazamiento < 800) {
            coordenadaY = coordenadaY + (float) (0.2);
            desplazamiento ++;
            setDir("down");
        } else if (desplazamiento >= 800 && desplazamiento < 1000) {
            coordenadaX = coordenadaX - (float) (0.2);
            desplazamiento ++;
            setDir("left");
        } else if (desplazamiento >= 1000 && desplazamiento < 1800) {
            desplazamiento ++;
            coordenadaY = coordenadaY - (float) (0.2);
            setDir("up");
        } else if (desplazamiento >= 1800 && desplazamiento < 2000) {
            coordenadaX = coordenadaX + (float) (0.2);
            desplazamiento ++;
            setDir("right");
        } else {
            desplazamiento = 0;
        }
        hitbox.setBounds(coordenadaX + 17, coordenadaY + 10, 30, 50);
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    public void talk() {
        bocadillo.dentro((int) coordenadaX+20, (int) coordenadaY - 20);
    }

    public Bocadillo getTalk(){
        return bocadillo;
    }

    public void noTalk() {
        bocadillo.fuera();
    }
}
