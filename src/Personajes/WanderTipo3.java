/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personajes;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author lucas
 */
public class WanderTipo3
        extends WanderTipoT {

    float coordenadaX = 400, coordenadaY = 440;
    Image[] movementUp;
    Image[] movementDown;
    Image[] movementLeft;
    Image[] movementRight;
    Animation actual, sleft, sright, sup, sdown;
    int[] duration = {200, 200};
    Rectangle h1, h2, h3, h4;
    String dir;
    int movement = 0;

    public WanderTipo3(String dir) {
        try {

            this.dir = dir;
            h1 = new Rectangle(coordenadaX + 17, coordenadaY + 32, 30, 1);
            h2 = new Rectangle(coordenadaX + 16, coordenadaY + 33, 1, 30);
            h3 = new Rectangle(coordenadaX + 48, coordenadaY + 33, 1, 30);
            h4 = new Rectangle(coordenadaX + 17, coordenadaY + 63, 30, 1);

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

    public void setCoordenadaX(float coordenadaX) {
        this.coordenadaX = coordenadaX;
        h1.setBounds(coordenadaX + 17, coordenadaY + 32, 30, 1);
        h2.setBounds(coordenadaX + 16, coordenadaY + 33, 1, 30);
        h3.setBounds(coordenadaX + 48, coordenadaY + 33, 1, 30);
        h4.setBounds(coordenadaX + 17, coordenadaY + 64, 30, 1);
    }

    public void setCoordenadaY(float coordenadaY) {

        this.coordenadaY = coordenadaY;
        h1.setBounds(coordenadaX + 17, coordenadaY + 32, 30, 1);
        h2.setBounds(coordenadaX + 16, coordenadaY + 33, 1, 30);
        h3.setBounds(coordenadaX + 48, coordenadaY + 33, 1, 30);
        h4.setBounds(coordenadaX + 17, coordenadaY + 64, 30, 1);

    }

    public void move() {

        if ((dir).equals("left")) {
            setDir("sleft");
        } else if ((dir).equals("right")) {
            setDir("sright");
        }
    }

    public Rectangle getH1() {
        return h1;
    }

    public Rectangle getH2() {
        return h2;
    }

    public Rectangle getH3() {
        return h3;
    }

    public Rectangle getH4() {
        return h4;
    }

}
