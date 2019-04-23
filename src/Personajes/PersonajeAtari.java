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
public class PersonajeAtari extends PersonajeGeneral {

    Image[] light,dark;
    Animation luce, noluce;
    int[] duration = {100, 100};
    Bocadillo bocadillo = new Bocadillo("bocadilloAtari");
    int modo=0;

    public PersonajeAtari(float x, float y) {
        try {
            
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
            
            //No SBG
            sgb=5;
        } catch (SlickException e) {
        }
    }

    @Override
    public void setDir(String string) {
       actual=luce;
        
    }

    @Override
    public void move() {
        
    }
}
