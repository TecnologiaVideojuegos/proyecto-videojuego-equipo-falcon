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
public class WanderTipo3 extends WanderTipoT {

    float coordenadaX = 500, coordenadaY = 450;
    Image[] stanceUp;
    Image[] stanceDown;
    Image[] stanceLeft;
    Image[] stanceRight;
    Animation actual, sleft, sright, sup, sdown;
    int[] duration = {200, 200};
    Rectangle hitbox;
    String dir;
    int desplazamiento = 0;
    Bocadillo bocadillo = new Bocadillo();

    public WanderTipo3(String dir, float x, float y) {
        try {
            //Colocacion personaje
            this.coordenadaX = x;
            this.coordenadaY = y;
            this.dir = dir;

            //Creacion hitbox
            hitbox = new Rectangle(coordenadaX + 17, coordenadaY + 10, 30, 50);

            //Animaciones parado
            Image[] stanceDown = {new Image("ImagenesSprite\\down0.png"), new Image("ImagenesSprite\\down0.png")};
            Image[] stanceUp = {new Image("ImagenesSprite\\up0.png"), new Image("ImagenesSprite\\up0.png")};
            Image[] stanceLeft = {new Image("ImagenesSprite\\izq0.png"), new Image("ImagenesSprite\\izq0.png")};
            Image[] stanceRight = {new Image("ImagenesSprite\\der0.png"), new Image("ImagenesSprite\\der0.png")};
            sup = new Animation(stanceUp, duration, false);
            sdown = new Animation(stanceDown, duration, false);
            sleft = new Animation(stanceLeft, duration, false);
            sright = new Animation(stanceRight, duration, false);

            if (dir.equals("left")) {
                actual = sleft;
            } else {
                actual = sright;
            }
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
        if ((dir).equals("left")) {
            setDir("sleft");
        } else if ((dir).equals("right")) {
            setDir("sright");
        }
    }

    public Rectangle getHitbox() {
        return hitbox;
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
