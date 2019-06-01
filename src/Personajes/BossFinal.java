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
public class BossFinal extends PersonajeGeneral {

    private String dir;
    private Animation up, down;

    public BossFinal(String dir, float x, float y, int a) {
        try {

            //Colocacion personaje
            this.coordenadaX = x;
            this.coordenadaY = y;
            this.dir = dir;

            //Creacion hitbox
            hitbox = new Rectangle(coordenadaX + 17, coordenadaY + 10, 30, 50);
            Image[] movementUp = {new Image("ImagenesSprite\\BossFinal\\b1.png"), new Image("ImagenesSprite\\BossFinal\\b2.png")};
            Image[] movementDown = {new Image("ImagenesSprite\\BossFinal\\0.png"), new Image("ImagenesSprite\\BossFinal\\1.png"), new Image("ImagenesSprite\\BossFinal\\2.png"), new Image("ImagenesSprite\\BossFinal\\3.png"), new Image("ImagenesSprite\\BossFinal\\4.png"), new Image("ImagenesSprite\\BossFinal\\5.png"), new Image("ImagenesSprite\\BossFinal\\6.png"), new Image("ImagenesSprite\\BossFinal\\7.png")};
            Image[] movementOut = {new Image("ImagenesSprite\\BossFinalDerrotado\\0.png"), new Image("ImagenesSprite\\BossFinalDerrotado\\1.png"), new Image("ImagenesSprite\\BossFinalDerrotado\\2.png"), new Image("ImagenesSprite\\BossFinalDerrotado\\3.png"), new Image("ImagenesSprite\\BossFinalDerrotado\\4.png"), new Image("ImagenesSprite\\BossFinalDerrotado\\5.png"), new Image("ImagenesSprite\\BossFinalDerrotado\\6.png"), new Image("ImagenesSprite\\BossFinalDerrotado\\7.png"), new Image("ImagenesSprite\\BossFinalDerrotado\\8.png"), new Image("ImagenesSprite\\BossFinalDerrotado\\9.png"), new Image("ImagenesSprite\\BossFinalDerrotado\\10.png"), new Image("ImagenesSprite\\BossFinalDerrotado\\11.png")};
            //Animaciones parado
            if (a == 0) {
                actual = new Animation(movementUp, duration, false);
            } else if (a == 1) {
                actual = new Animation(movementDown, new int[]{200, 200, 200, 200, 200, 200, 200, 200}, false);
            } else {
                actual = new Animation(movementOut, new int[]{400, 400, 400, 400, 400, 400, 400, 400, 400, 400, 400, 400}, false);
            }

            //No SBG
            sgb = -1;
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

    public void setCoordenadas(float x, float y) {
        this.coordenadaX = x;
        this.coordenadaY = y;
    }

    public float getCoordenadaX() {
        return this.coordenadaX;
    }

    public float getCoordenadaY() {
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

    public Alerta getAlerta() {
        return alerta;
    }

    public void alerta() {
        alerta.dentro((int) coordenadaX + 20, (int) coordenadaY - 20);
    }

    public void noAlerta() {
        alerta.fuera();
    }

}
