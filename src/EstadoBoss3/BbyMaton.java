/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstadoBoss3;

import static java.lang.Math.random;
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
public class BbyMaton {

    float coordenadaX = -100, coordenadaY = -100;
    float coordenadaXi = 1010, coordenadaYi = 273;
    Animation actual;
    int[] duration2 = {500, 500};
    Rectangle h1;
    private float estado = 0;
    int tipo;
    public BbyMaton(int a) {
        try {
            tipo=a;
            h1 = new Rectangle(coordenadaX, coordenadaY, 128, 45);
            if (a == 0) {
                Image[] movement = {new Image("SpriteBoss3\\1.png"), new Image("SpriteBoss3\\1.png")};
                actual = new Animation(movement, duration2, false);
            } else if (a == 1) {
                Image[] movement = {new Image("SpriteBoss3\\2.png"), new Image("SpriteBoss3\\2.png")};
                actual = new Animation(movement, duration2, false);
            } else if (a == 2) {
                Image[] movement = {new Image("SpriteBoss3\\3.png"), new Image("SpriteBoss3\\3.png")};
                actual = new Animation(movement, duration2, false);
            } else {
                Image[] movement = {new Image("SpriteBoss3\\4.png"), new Image("SpriteBoss3\\4.png")};
                actual = new Animation(movement, duration2, false);
            }
            
        } catch (SlickException e) {
        }
    }

    public int getTipo()
    {
        return tipo;
    }
    
    public void init() {

        coordenadaX = -100;
        coordenadaY = -100;
        h1.setLocation(coordenadaX, coordenadaY);
    }

    public void salir() {
        coordenadaX = 1504;
        h1.setLocation(coordenadaX + 5, coordenadaY + 5);
        coordenadaY = (int) (random() * 680) + 50;
    }

    public Animation getDir() {
        return actual;
    }

    public float getCoordenadaX() {
        return coordenadaX;
    }

    public float getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadas(float x, float y) {
        coordenadaX = x;
        coordenadaY = y;
        h1.setLocation(coordenadaX, coordenadaY);
    }

    public void move() {
        coordenadaY = coordenadaY + (float) 45;
        h1.setLocation(coordenadaX, coordenadaY);

    }

    public Rectangle getH1() {
        return h1;
    }

}
