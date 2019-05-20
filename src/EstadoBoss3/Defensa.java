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
public class Defensa {

    float coordenadaX, coordenadaY;
    Animation mover;
    int[] duration = {100, 100};
    Rectangle h1, h2, h3,h4,h5;

    public Defensa() {
        try {

            h1 = new Rectangle(coordenadaX+32, coordenadaY, 1, 60);
            h2 = new Rectangle(coordenadaX+80, coordenadaY, 1, 60);
            h3 = new Rectangle(coordenadaX, coordenadaY, 1, 60);
            h4 = new Rectangle(coordenadaX, coordenadaY, 1, 60);
            h5 = new Rectangle(coordenadaX, coordenadaY, 1, 60);

            Image[] movimiento = {new Image("SpriteBoss3\\p1.png"), new Image("SpriteBoss3\\p2.png")};
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
        h1.setBounds(coordenadaX+20, coordenadaY+45, 1, 10);
        h2.setBounds(coordenadaX+105, coordenadaY+45, 1, 10);
        h3.setBounds(coordenadaX+20,coordenadaY+43,28,1);
        h4.setBounds(coordenadaX+48,coordenadaY+43,29,1);
        h5.setBounds(coordenadaX+77,coordenadaY+43,28,1);
    }

    public float getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(float coordenadaY) {

        this.coordenadaY = coordenadaY;
        h1.setBounds(coordenadaX+20, coordenadaY+45, 1, 10);
        h2.setBounds(coordenadaX+105, coordenadaY+45, 1, 10);
        h3.setBounds(coordenadaX+20,coordenadaY+43,28,1);
        h4.setBounds(coordenadaX+48,coordenadaY+43,29,1);
        h5.setBounds(coordenadaX+77,coordenadaY+43,28,1);

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
    
    public Rectangle getH5() {
        return h5;
    }

 

}
