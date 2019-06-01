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
public class PersonajeEstaticoA extends PersonajeGeneral {

    private String dir;

    public PersonajeEstaticoA(String dir, float x, float y, String texto, String personaje) {
        try {

            //Colocacion personaje
            this.coordenadaX = x;
            this.coordenadaY = y;
            this.dir = dir;

            //Creacion hitbox
            hitbox = new Rectangle(coordenadaX + 17, coordenadaY + 10, 30, 50);

            //Animaciones parado
            Image[] stanceRight = {new Image("ImagenesSprite\\" + personaje + "\\der0.png"), new Image("ImagenesSprite\\" + personaje + "\\der0.png")};
            Image[] stanceDown = {new Image("ImagenesSprite\\" + personaje + "\\down0.png"), new Image("ImagenesSprite\\" + personaje + "\\down0.png")};
            Image[] stanceLeft = {new Image("ImagenesSprite\\" + personaje + "\\izq0.png"), new Image("ImagenesSprite\\" + personaje + "\\izq0.png")};

            sdown = new Animation(stanceDown, duration, false);
            sright = new Animation(stanceRight, duration, false);
            sleft = new Animation(stanceLeft, duration, false);

            if (dir.equals("left")) {
                actual = sleft;
            } else if (dir.equals("right")) {
                actual = sright;
            } else {
                actual = sdown;
            }

            //Bocadillo
            bocadillo = new Bocadillo(texto);

            //No SBG
            sgb = -1;
        } catch (SlickException e) {
        }
    }

    public void setDir(String string) {
        switch (string) {
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
        } else if ((dir).equals("up")) {
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
