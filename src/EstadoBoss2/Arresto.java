/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstadoBoss2;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;

/**
 *
 * @author lucas
 */
public class Arresto {

    private float coordenadaX = -100, coordenadaY = -100;
    private Image arrestoImg; 
    private Circle h1;
    private int estado=0;

    public Arresto() {
        try {
            arrestoImg = new Image("\\SpriteBoss2\\arresto.png");
            h1 = new Circle(coordenadaX + 32, coordenadaY + 32, 10);
        } catch (SlickException ex) {}
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
        h1.setCenterX(coordenadaX+32);
        h1.setCenterY(coordenadaY+32);
    }

    public Circle getH1() {
        return h1;
    }
}
