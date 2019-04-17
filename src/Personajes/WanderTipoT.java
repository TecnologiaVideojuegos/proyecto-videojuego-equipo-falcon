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
public class WanderTipoT {

    float coordenadaX = 500, coordenadaY = 450;
    Image[] movementUp;
    Image[] movementDown;
    Image[] movementLeft;
    Image[] movementRight;
    Animation actual, sup, sdown, left, right, sright, sleft;
    int[] duration = {200, 200};
    int[] duration2 = {100, 100, 100, 100, 100, 100, 100, 100};
    Rectangle hitbox;
    Bocadillo bocadillo = new Bocadillo();
    int desplazamiento = 0;

    public WanderTipoT() {
        try {

            hitbox = new Rectangle(coordenadaX + 17, coordenadaY + 10, 30, 50);

            Image[] movementLeft = {new Image("ImagenesSprite\\izq1.png"), new Image("ImagenesSprite\\izq2.png"), new Image("ImagenesSprite\\izq3.png"), new Image("ImagenesSprite\\izq4.png"), new Image("ImagenesSprite\\izq5.png"), new Image("ImagenesSprite\\izq6.png"), new Image("ImagenesSprite\\izq7.png"), new Image("ImagenesSprite\\izq8.png")};
            Image[] movementRight = {new Image("ImagenesSprite\\der1.png"), new Image("ImagenesSprite\\der2.png"), new Image("ImagenesSprite\\der3.png"), new Image("ImagenesSprite\\der4.png"), new Image("ImagenesSprite\\der5.png"), new Image("ImagenesSprite\\der6.png"), new Image("ImagenesSprite\\der7.png"), new Image("ImagenesSprite\\der8.png")};

            Image[] stanceDown = {new Image("ImagenesSprite\\down0.png"), new Image("ImagenesSprite\\down0.png")};
            Image[] stanceUp = {new Image("ImagenesSprite\\up0.png"), new Image("ImagenesSprite\\up0.png")};
            Image[] stanceLeft = {new Image("ImagenesSprite\\izq0.png"), new Image("ImagenesSprite\\izq0.png")};
            Image[] stanceRight = {new Image("ImagenesSprite\\der0.png"), new Image("ImagenesSprite\\der0.png")};

            left = new Animation(movementLeft, duration2, false);
            right = new Animation(movementRight, duration2, false);
            sup = new Animation(stanceUp, duration, false);
            sdown = new Animation(stanceDown, duration, false);
            sleft = new Animation(stanceLeft, duration, false);
            sright = new Animation(stanceRight, duration, false);

            actual = right;
        } catch (SlickException e) {
        }
    }

    public void setDir(String string) {

        switch (string) {
            case "up":
                actual = sup;
                break;
            case "down":
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
        if (desplazamiento < 200) {
            coordenadaX = coordenadaX + (float) (0.5);
            desplazamiento ++;
            setDir("right");
        } else if (desplazamiento >= 200 && desplazamiento < 1200) {
            desplazamiento ++;
            setDir("up");
        } else if (desplazamiento >= 1200 && desplazamiento < 1500) {
            desplazamiento ++;
            coordenadaX = coordenadaX - (float) (0.5);
            setDir("left");
        } else if (desplazamiento >= 1500 && desplazamiento < 2500) {
            desplazamiento ++;
            setDir("up");
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
