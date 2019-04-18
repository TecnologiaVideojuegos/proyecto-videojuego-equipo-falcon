/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;

import static java.lang.Math.random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;

/**
 *
 * @author lucas
 */
public class Corazones {

    float coordenadaX = -100, coordenadaY = -100;
    float coordenadaXi = 1010, coordenadaYi = 273;
    Animation actual, avanza, explota;
    int[] duration2 = {500, 500};
    int[] duration = {20, 20, 20, 20};
    Circle h1;
    private float estado=0;

    public Corazones() {
        try {

            h1 = new Circle(coordenadaX + 5, coordenadaY + 5, 26);

            Image[] movement = {new Image("SpriteBoss2\\move1.png"), new Image("SpriteBoss2\\move1.png")};
            Image[] poum = {new Image("SpriteBoss2\\move1.png"), new Image("SpriteBoss2\\move2.png"), new Image("SpriteBoss2\\move3.png"), new Image("SpriteBoss2\\move4.png")};

            avanza = new Animation(movement, duration2, false);
            explota = new Animation(poum, duration, false);

            actual = avanza;
        } catch (SlickException e) {
        }
    }


    public void init() {
        try {
            actual = avanza;
            Image[] poum = {new Image("SpriteBoss2\\move1.png"), new Image("SpriteBoss2\\move2.png"), new Image("SpriteBoss2\\move3.png"), new Image("SpriteBoss2\\move4.png")};
            explota = new Animation(poum, duration, false);
            coordenadaX = 1504;
            coordenadaY = (int)(random()*600)+100;
            estado=1;
            
        } catch (SlickException ex) {
            Logger.getLogger(Corazones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void salir()
    {
        coordenadaX = 1504;
        h1.setLocation(coordenadaX + 5, coordenadaY + 5);
        coordenadaY = (int)(random()*600)+100;
    }
    
    public void explota()
    {
        actual = explota;
        estado=0;
    }

    public Animation getDir() {
        return actual;
    }

    public float getEstado(){
        return estado;
    }

    public float getCoordenadaX() {
        return coordenadaX;
    }

    public float getCoordenadaY() {
        return coordenadaY;
    }

    public void move() {
        coordenadaX = coordenadaX - (float)0.5;
        h1.setCenterX(coordenadaX);
        h1.setCenterY(coordenadaY);
        
    }

    public Circle getH1() {
        return h1;
    }

}
