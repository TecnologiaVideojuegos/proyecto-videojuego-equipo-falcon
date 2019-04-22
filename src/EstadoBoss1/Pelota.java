/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstadoBoss1;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author lucas
 */
public class Pelota {

    float coordenadaX = -100, coordenadaY = -100;
    float coordenadaXi = 1010, coordenadaYi = 273;
    Image[] aparecer;
    Image[] giro;
    Animation actual, aparece, gira;
    int[] duration2 = {500, 500, 110};
    int[] duration = {100, 100, 100, 100};
    Circle h1;
    private float velocidadX, velocidadY;

    public Pelota() {
        try {

            h1 = new Circle(coordenadaX + 5, coordenadaY + 5, 26);

            Image[] movementUp = {new Image("SpriteBoss1\\crec1.png"), new Image("SpriteBoss1\\crec2.png"), new Image("SpriteBoss1\\crec3.png")};
            Image[] movementDown = {new Image("SpriteBoss1\\balones3.png"), new Image("SpriteBoss1\\balones4.png"), new Image("SpriteBoss1\\balones1.png"), new Image("SpriteBoss1\\balones2.png")};

            aparece = new Animation(movementUp, duration2, false);
            gira = new Animation(movementDown, duration, false);

            actual = aparece;
        } catch (SlickException e) {
        }
    }

    public void restart() {
        try {
            Image[] movementUp = {new Image("SpriteBoss1\\crec1.png"), new Image("SpriteBoss1\\crec2.png"), new Image("SpriteBoss1\\crec3.png")};
            aparece = new Animation(movementUp, duration2, false);
        } catch (SlickException ex) {
            Logger.getLogger(Pelota.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void init() {
        actual = aparece;

        coordenadaX = coordenadaXi;
        coordenadaY = coordenadaYi;
    }

    public void setDir(String string) {
        switch (string) {
            case "aparece":
                actual = aparece;
                break;
            case "gira":
                actual = gira;
                break;
        }
    }

    public Animation getDir() {
        return actual;
    }

    public void setDestinoN(float destinoX, float destinoY) {

        velocidadX = (coordenadaX - destinoX) / 320;
        velocidadY = (coordenadaY - destinoY) / 320;

    }

    public float getCoordenadaX() {
        return coordenadaX;
    }

    public float getCoordenadaY() {
        return coordenadaY;
    }

    public void move() {
        coordenadaX = coordenadaX - velocidadX;
        coordenadaY = coordenadaY - velocidadY;

        h1.setLocation(coordenadaX + 5, coordenadaY + 5);
    }

    public Circle getH1() {
        return h1;
    }

}
