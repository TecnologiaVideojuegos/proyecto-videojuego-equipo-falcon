/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;

import Personajes.*;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author lucas
 */
public class Pelota {
    float coordenadaX = 300 ,coordenadaY= 300;
    float destinoX, destinoY;
    Image[] aparecer;
    Image[] giro;
    Animation actual, aparece, gira;
    int[] duration2 = {200, 200,200};
    int[] duration = {100, 100, 100,100};
    Rectangle h1,h2,h3,h4;
    
    public Pelota() {
        try {
            
            h1 = new Rectangle(coordenadaX+17, coordenadaY+32, 30, 1);
            h2 = new Rectangle(coordenadaX+16, coordenadaY+33, 1, 30);
            h3 = new Rectangle(coordenadaX+48, coordenadaY+33, 1, 30);
            h4 = new Rectangle(coordenadaX+17, coordenadaY+63, 30, 1);
            
            Image[] movementUp = {new Image("SpriteBoss1\\crec1.png"), new Image("SpriteBoss1\\crec2.png"), new Image("SpriteBoss1\\crec3.png")};
            Image[] movementDown = {new Image("SpriteBoss1\\balones3.png"), new Image("SpriteBoss1\\balones4.png"), new Image("SpriteBoss1\\balones1.png"), new Image("SpriteBoss1\\balones2.png")};
             
           
            aparece = new Animation(movementUp, duration2, false);
            gira = new Animation(movementDown, duration, false);
            
            actual = aparece;
        } catch (SlickException e) {
        }
    }
    
    public void setDir(String string)
    {
        
        switch (string) {
            case "aparece":
                actual = aparece;
                break;
            case "gira":
                actual = gira;
                break;   
        }
    }
    
    public Animation getDir()
    {
        return actual;
    }

    public void setDestino(float destinoX, float destinoY)
    {
        this.destinoX=destinoX;
        this.destinoY=destinoY;
    }
    public float getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(float coordenadaX) {
        this.coordenadaX = coordenadaX;
        h1.setBounds(coordenadaX+17, coordenadaY+32, 30, 1);
        h2.setBounds(coordenadaX+16, coordenadaY+33, 1, 30);
        h3.setBounds(coordenadaX+48, coordenadaY+33, 1,30);
        h4.setBounds(coordenadaX+17, coordenadaY+64, 30, 1);
    }

    public float getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(float coordenadaY) {
       
        this.coordenadaY = coordenadaY;
        h1.setBounds(coordenadaX+17, coordenadaY+32, 30, 1);
        h2.setBounds(coordenadaX+16, coordenadaY+33, 1, 30);
        h3.setBounds(coordenadaX+48, coordenadaY+33, 1, 30);
        h4.setBounds(coordenadaX+17, coordenadaY+64, 30, 1);
        
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
