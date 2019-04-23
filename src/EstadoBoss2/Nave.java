/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstadoBoss2;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author lucas
 */
public class Nave {

    float coordenadaX, coordenadaY;
    Animation mover;
    int[] duration = {100, 100, 100, 100};
    Rectangle h1, h2, h3, h4;

    public Nave() {
        try {

            h1 = new Rectangle(coordenadaX + 17, coordenadaY + 32, 30, 1);
            h2 = new Rectangle(coordenadaX + 16, coordenadaY + 33, 1, 30);
            h3 = new Rectangle(coordenadaX + 48, coordenadaY + 33, 1, 30);
            h4 = new Rectangle(coordenadaX + 17, coordenadaY + 63, 30, 1);

            Image[] movimiento = {new Image("SpriteBoss2\\nave0.png"), new Image("SpriteBoss2\\nave1.png"), new Image("SpriteBoss2\\nave2.png"), new Image("SpriteBoss2\\nave1.png")};
            mover = new Animation(movimiento, duration, false);

        } catch (SlickException e) {
        }
    }

    public Animation getDir() {
        return mover;
    }

    public float getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(float coordenadaX) {
        this.coordenadaX = coordenadaX;
        h1.setBounds(coordenadaX + 17, coordenadaY + 32, 30, 1);
        h2.setBounds(coordenadaX + 16, coordenadaY + 33, 1, 30);
        h3.setBounds(coordenadaX + 48, coordenadaY + 33, 1, 30);
        h4.setBounds(coordenadaX + 17, coordenadaY + 64, 30, 1);
    }

    public float getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(float coordenadaY) {

        this.coordenadaY = coordenadaY;
        h1.setBounds(coordenadaX + 17, coordenadaY + 32, 30, 1);
        h2.setBounds(coordenadaX + 16, coordenadaY + 33, 1, 30);
        h3.setBounds(coordenadaX + 48, coordenadaY + 33, 1, 30);
        h4.setBounds(coordenadaX + 17, coordenadaY + 64, 30, 1);

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
