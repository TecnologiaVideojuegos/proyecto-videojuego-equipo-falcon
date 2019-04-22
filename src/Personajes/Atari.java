/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personajes;

import Elementos.Alerta;
import Elementos.Bocadillo;
import Mapas.Mapa2;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author lucas
 */
public class Atari extends WanderTipoT {

    float coordenadaX , coordenadaY;
    Image[] light,dark;
    Animation actual,luce, noluce;
    int[] duration = {100, 100};
    Rectangle hitbox;
    Bocadillo bocadillo = new Bocadillo("bocadilloAtari");
    Mapa2 mapa;
    int desplazamiento = 0;
    Alerta alerta = new Alerta();
    int modo=0;

    public Atari(float x, float y, Mapa2 mapa) {
        try {
            this.mapa = mapa;
            sgb=5;
            //Colocacion personaje
            this.coordenadaX = x;
            this.coordenadaY = y;
            
            //Creacion hitbox
            hitbox = new Rectangle(coordenadaX, coordenadaY, 32, 64);
            
            //Animaciones movimiento
            Image[] light = {new Image("Elementos aparte\\atari1.png"),new Image("Elementos aparte\\atari0.png")};
            luce = new Animation(light, duration, false);
            
            //Animaciones parado
            Image[] dark = {new Image("Elementos aparte\\atari0.png"), new Image("Elementos aparte\\atari0.png")};
            noluce = new Animation(dark, duration, false);

            //Animacion inicial
            actual = luce;
        } catch (SlickException e) {
        }
    }

    @Override
    public void setDir(String string) {
       actual=luce;
        
    }

    public Animation getDir() {
        return actual;
    }

    public float getCoordenadaX() {
        return coordenadaX;
    }

    public float getCoordenadaY() {
        return coordenadaY;
    }

    @Override
    public void move() {
        
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    @Override
    public void talk() {
        bocadillo.dentro();
    }

    public Bocadillo getTalk() {
        
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

}
