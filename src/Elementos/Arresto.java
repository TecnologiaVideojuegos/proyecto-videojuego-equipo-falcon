/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;

/**
 *
 * @author lucas
 */
public class Arresto {

    float coordenadaX = -100, coordenadaY = -100;
    float coordenadaXi = 1010, coordenadaYi = 273;
    Image arrestoImg; 
    Circle h1;
    private float velocidadX, velocidadY;
    int estado=0;

    public Arresto() {
        try {
            arrestoImg = new Image("\\SpriteBoss2\\arresto.png");
            h1 = new Circle(coordenadaX + 5, coordenadaY + 5, 26);
        } catch (SlickException ex) {
            Logger.getLogger(Arresto.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }

    public Image getImage()
    {
        return arrestoImg;
    }
    public void init(float x, float y) {
        
            coordenadaX=x;
            coordenadaY=y;
            estado=1;
    }
    public void reset()
    {
        coordenadaX=-100;
        coordenadaY=-100;
    }
    
    public int getEstado()
    {
        return estado;
    }

    public float getCoordenadaX() {
        return coordenadaX;
    }

    public float getCoordenadaY() {
        return coordenadaY;
    }

    public void move() {
        coordenadaX = coordenadaX + (float)1.8;
        h1.setCenterX(coordenadaX+5);
        h1.setCenterY(coordenadaY+5);

        
    }

    public Circle getH1() {
        return h1;
    }

}
