/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;

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
public class Bocadillo {

    float coordenadaX = -100, coordenadaY = -100;
    Image foto;

    public Bocadillo() {
        try {
            foto = new Image("\\Elementos Aparte\\Bocadillo.png");
        } catch (SlickException ex) {
        }
    }

    public void dentro(int cordX, int cordY) {
        coordenadaX = cordX;
        coordenadaY = cordY;
    }

    public void fuera(int cordX, int cordY) {
        coordenadaX = cordX;
        coordenadaY = cordY;
    }

    public Image getImagen() {
        return foto;
    }
}
