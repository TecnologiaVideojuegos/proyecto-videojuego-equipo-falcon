/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstadoBoss3;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author lucas
 */
public class Ball {

    private float coordenadaX, coordenadaY;
    private Animation mover;
    private int[] duration = {100, 100};
    private Rectangle h1, h2, h3, h4;
    private float  movx = 0, movy = 1;

    public Ball() {
        try {

            h1 = new Rectangle(coordenadaX + 1, coordenadaY - 1, 14, 1);
            h2 = new Rectangle(coordenadaX, coordenadaY, 1, 16);
            h3 = new Rectangle(coordenadaX + 1, coordenadaY + 17, 14, 1);
            h4 = new Rectangle(coordenadaX + 16, coordenadaY, 1, 16);

            Image[] movimiento = {new Image("SpriteBoss3\\b.png"), new Image("SpriteBoss3\\b.png")};
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
        h1.setBounds(coordenadaX + 56, coordenadaY + 56, 14, 1);
        h2.setBounds(coordenadaX + 55, coordenadaY + 57, 1, 16);
        h3.setBounds(coordenadaX + 56, coordenadaY + 74, 14, 1);
        h4.setBounds(coordenadaX + 71, coordenadaY + 57, 1, 16);
    }

    public float getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(float coordenadaY) {

        this.coordenadaY = coordenadaY;
        h1.setBounds(coordenadaX + 56, coordenadaY + 56, 14, 1);
        h2.setBounds(coordenadaX + 55, coordenadaY + 57, 1, 16);
        h3.setBounds(coordenadaX + 56, coordenadaY + 74, 14, 1);
        h4.setBounds(coordenadaX + 71, coordenadaY + 57, 1, 16);

    }

    public void pared() {
        movx = -movx;
    }

    public void techo() {
        movy = -movy;
    }

    public void setDest(float x, float y) {
        movx = x;
        movy = y;
    }

    public void move() {
        coordenadaX = coordenadaX + (float) 1.1 * movx;
        coordenadaY = coordenadaY + (float) 1.1 * movy;
        h1.setBounds(coordenadaX + 56, coordenadaY + 56, 14, 1);
        h2.setBounds(coordenadaX + 55, coordenadaY + 57, 1, 16);
        h3.setBounds(coordenadaX + 56, coordenadaY + 74, 14, 1);
        h4.setBounds(coordenadaX + 71, coordenadaY + 57, 1, 16);

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
