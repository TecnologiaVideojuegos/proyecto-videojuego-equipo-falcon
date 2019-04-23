/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personajes;

import Elementos.Alerta;
import Elementos.Bocadillo;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author lucas
 */
public class PersonajeGeneral {

    float coordenadaX = 500, coordenadaY = 450;
    Animation actual, sup, sdown, left, right, sright, sleft;
    int[] duration = {200, 200};
    int[] duration2 = {100, 100, 100, 100, 100, 100, 100, 100};
    Rectangle hitbox;
    Bocadillo bocadillo = new Bocadillo("bocadilloAnciano");
    int desplazamiento = 0;
    Alerta alerta = new Alerta();
    int sgb;
    public PersonajeGeneral() {
        try {

            hitbox = new Rectangle(coordenadaX + 17, coordenadaY + 10, 30, 50);

            Image[] movementLeft = {new Image("ImagenesSprite\\Niña\\izq1.png"), new Image("ImagenesSprite\\Niña\\izq2.png"), new Image("ImagenesSprite\\Niña\\izq3.png"), new Image("ImagenesSprite\\Niña\\izq4.png"), new Image("ImagenesSprite\\Niña\\izq5.png"), new Image("ImagenesSprite\\Niña\\izq6.png"), new Image("ImagenesSprite\\Niña\\izq7.png"), new Image("ImagenesSprite\\Niña\\izq8.png")};
            Image[] movementRight = {new Image("ImagenesSprite\\Niña\\der1.png"), new Image("ImagenesSprite\\Niña\\der2.png"), new Image("ImagenesSprite\\Niña\\der3.png"), new Image("ImagenesSprite\\Niña\\der4.png"), new Image("ImagenesSprite\\Niña\\der5.png"), new Image("ImagenesSprite\\Niña\\der6.png"), new Image("ImagenesSprite\\Niña\\der7.png"), new Image("ImagenesSprite\\Niña\\der8.png")};

            Image[] stanceDown = {new Image("ImagenesSprite\\Niña\\down0.png"), new Image("ImagenesSprite\\Niña\\down0.png")};
            Image[] stanceUp = {new Image("ImagenesSprite\\Niña\\up0.png"), new Image("ImagenesSprite\\Niña\\up0.png")};
            Image[] stanceLeft = {new Image("ImagenesSprite\\Niña\\izq0.png"), new Image("ImagenesSprite\\Niña\\izq0.png")};
            Image[] stanceRight = {new Image("ImagenesSprite\\Niña\\der0.png"), new Image("ImagenesSprite\\Niña\\der0.png")};

            left = new Animation(movementLeft, duration2, false);
            right = new Animation(movementRight, duration2, false);
            sup = new Animation(stanceUp, duration, false);
            sdown = new Animation(stanceDown, duration, false);
            sleft = new Animation(stanceLeft, duration, false);
            sright = new Animation(stanceRight, duration, false);

            actual = right;
            
            //No SBG
            sgb=-1;
        } catch (SlickException e) {
        }
    }

    public void setDir(String string) {

        switch (string) {
            case "up":
                actual = sup;
                break;
            case "down":
                actual = sdown;
                break;
            case "right":
                actual = right;
                break;
            case "left":
                actual = left;
                break;
            case "sright":
                actual = sright;
                break;
            case "sleft":
                actual = sleft;
                break;

        }
    }

    public Animation getDir() {
        return actual;
    }

    public float getCoordenadaX() {
        return this.coordenadaX;
    }

    public float getCoordenadaY() {
        return this.coordenadaY;
    }

    public void move() {
        
        hitbox.setBounds(coordenadaX + 17, coordenadaY + 10, 30, 50);
    }


    public Rectangle getHitbox() {
        return hitbox;
    }

    public void talk() {
        bocadillo.dentro();
    }

    public Bocadillo getTalk(){
        return bocadillo;
    }
    
    public void noTalk() {
        bocadillo.fuera();
    }
    
    public Alerta getAlerta(){
        return alerta;
    }
    
    public void alerta() {
        alerta.dentro((int) coordenadaX+20, (int) coordenadaY - 20);
    }
    
    public void noAlerta() {
        alerta.fuera();
    }
    
    public boolean isSGB()
    {
        return sgb!=-1;
    }
    
    public int getSGB()
    {
        return sgb;
    }
    
    public void notSGB()
    {
        sgb=-1;
    }
    
    public void hide()
    {
        hitbox.setBounds(0, 0, 0, 0);
    }
}
