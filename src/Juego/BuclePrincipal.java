/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import Clases.Sprite;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.tiled.TiledMap;

/**
 *
 * @author lucas
 */
public class BuclePrincipal extends BasicGame {

    private static TiledMap mapa;
    float puntos1 [] = new float[]{351,1,351,33,319,33,319,65,287,65,255,65,255,97,223,97,191,97,191,129,159,129,159,161,127,161,127,193,127,225,95,225,95,289,63,289,63,321,31,321,0,321,0,0};
    Polygon p1 = new Polygon(puntos1);
    Sprite personaje;
    public BuclePrincipal() {
        super("");

    }

    @Override
    public void init(GameContainer gc) throws SlickException {
        mapa = new TiledMap("C:\\Users\\lucas\\Documents\\NetBeansProjects\\VideoGame\\mapa1.tmx");
        
        personaje = new Sprite();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    @Override
    public void update(GameContainer gc, int i) throws SlickException {
        Input input = gc.getInput();
        System.out.println(input.getMouseX()+"-"+input.getMouseY());
        if (input.isKeyDown(Input.KEY_UP)) {
            personaje.setDir("up");
            personaje.getDir().update(i);
            float coordY = personaje.getCoordenadaY() - i * 0.15f;
            if(personaje.getH2().intersects(p1)){
                personaje.setCoordenadaY(personaje.getCoordenadaY() + i * 1.2f);
            }
            else
                personaje.setCoordenadaY(personaje.getCoordenadaY() - i * 0.15f);
        } else if (input.isKeyDown(Input.KEY_DOWN)) {
            personaje.setDir("down");
            personaje.getDir().update(i);
            float coordY = personaje.getCoordenadaY() + i * 0.15f;
            if(personaje.getH3().intersects(p1)){
                personaje.setCoordenadaY(personaje.getCoordenadaY() - i * 1.2f);
            }
            else
                personaje.setCoordenadaY(personaje.getCoordenadaY() + i * 0.15f);
        } else if (input.isKeyDown(Input.KEY_LEFT)) {
            personaje.setDir("left");
            personaje.getDir().update(i);
            float coordX = personaje.getCoordenadaX() - i * 0.15f;
            if(personaje.getH1().intersects(p1)){
                personaje.setCoordenadaX(personaje.getCoordenadaX() + i * 1.2f);
            }
            else
                personaje.setCoordenadaX(personaje.getCoordenadaX() - i * 0.15f);
        } else if (input.isKeyDown(Input.KEY_RIGHT)) {
            personaje.setDir("right");
            personaje.getDir().update(i);
            float coordX = personaje.getCoordenadaX() + i * 0.15f;
            if(personaje.getH4().intersects(p1)){
                personaje.setCoordenadaX(personaje.getCoordenadaX() - i * 1.2f);
            }
            else
                personaje.setCoordenadaX(personaje.getCoordenadaX() + i * 0.15f);
        } else {
            personaje.setDir("stance");
            personaje.getDir().update(i);
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void render(GameContainer gc, Graphics grphcs) throws SlickException {
        
        Graphics g = new Graphics();
        
        
        mapa.render(0, 0, 0);
        mapa.render(0, 0, 1);
        personaje.getDir().draw((int) personaje.getCoordenadaX(), (int) personaje.getCoordenadaY());
        mapa.render(0, 0, 2);
        g.draw(p1);
        g.draw(personaje.getH1());
        g.draw(personaje.getH2());
        g.draw(personaje.getH3());
        g.draw(personaje.getH4());
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] string) {
        try {
            AppGameContainer app = new AppGameContainer(new BuclePrincipal());
            app.setDisplayMode(1504, 800, false);

            app.start();
        } catch (SlickException e) {
        }
    }

}
