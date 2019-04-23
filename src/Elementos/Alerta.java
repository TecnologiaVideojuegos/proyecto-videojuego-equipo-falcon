/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author lucas
 */
public class Alerta {

    float coordenadaX = -1000, coordenadaY = -1000;
    Image foto;

    public Alerta() {
        try {
            foto = new Image("\\Elementos Aparte\\alerta.png");
        } catch (SlickException ex) {
        }
    }

    public void dentro(int cordX, int cordY) {
        coordenadaX = cordX;
        coordenadaY = cordY;
    }

    public void fuera() {
        coordenadaX = -1000;
        coordenadaY = -1000;
    }

    public float getCoordenadaX(){
        return coordenadaX;
    }
    public float getCoordenadaY(){
        return coordenadaY;
    }
    public Image getImagen() {
        return foto;
    }
}
