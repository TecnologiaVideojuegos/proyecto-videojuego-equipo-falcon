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
    float puntos1 [] = new float[]{383,0,383,65,351,65,319,65,287,65,255,65,255,97,223,97,191,97,191,129,159,129,159,161,127,161,127,193,127,225,95,225,95,289,95,351,63,351,31,351,0,351,0,0};
    float puntos2 [] = new float[]{383,800,383,769,383,737,319,737,255,737,255,705,223,705,191,705,191,673,159,673,159,641,127,641,127,609,127,577,95,577,95,545,95,513,95,449,63,449,31,449,0,449,0,800};
    float puntos3 [] = new float[]{351,1,0,321,0,0};
    float puntos4 [] = new float[]{351,1,351,33,319,33,319,65,287,65,255,65,255,97,223,97,191,97,191,129,159,129,159,161,127,161,127,193,127,225,95,225,95,289,63,289,63,321,31,321,0,321,0,0};
    
    int a=0,b=0,c=0,d=0;
    Polygon p1;
    Polygon p2;

    Sprite personaje;
    public BuclePrincipal() {
        super("");

    }

    @Override
    public void init(GameContainer gc) throws SlickException {
        mapa = new TiledMap("C:\\Users\\lucas\\Documents\\NetBeansProjects\\VideoGame\\mapa2.tmx");
        personaje = new Sprite();
        p1 = new Polygon(puntos1);
        p2 = new Polygon(puntos2);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    @Override
    public void update(GameContainer gc, int i) throws SlickException {
        Input input = gc.getInput();
        System.out.println(input.getMouseX()+"-"+input.getMouseY());
        if (input.isKeyDown(Input.KEY_UP)) {
            personaje.setDir("up");
            personaje.getDir().update(i);
            if(personaje.getH1().intersects(p1)||personaje.getH1().intersects(p2)){//(personaje.getH2().intersects(p1)||personaje.getH2().intersects(p2)|| personaje.getH3().intersects(p1)||personaje.getH3().intersects(p2)){
                a=1;
            }
            else
            {
                a=0;
            }
            if(a==0 || b==1)
            {
                personaje.setCoordenadaY(personaje.getCoordenadaY() - i * 0.14f);
                b=0;
            }
                
        } else if (input.isKeyDown(Input.KEY_DOWN)) {
            personaje.setDir("down");
            personaje.getDir().update(i);
            if(personaje.getH4().intersects(p1)||personaje.getH4().intersects(p2)){//(personaje.getH3().intersects(p1)||personaje.getH3().intersects(p2)||personaje.getH2().intersects(p1)||personaje.getH2().intersects(p2)){
                b=1;
            }
            else
            {
                b=0;
            }
            if(b==0 || a==1)
            {
                personaje.setCoordenadaY(personaje.getCoordenadaY() + i * 0.14f);
                a=0;
            }
                
        } else if (input.isKeyDown(Input.KEY_LEFT)) {
            personaje.setDir("left");
            personaje.getDir().update(i);
            if(personaje.getH2().intersects(p1)||personaje.getH2().intersects(p2)){//personaje.getH1().intersects(p1)||personaje.getH1().intersects(p2)||personaje.getH4().intersects(p1)||personaje.getH4().intersects(p2)){
                c=1;
            }
            else
            {
                c=0;
            }
            if(c==0 || d==1)
            {
                 personaje.setCoordenadaX(personaje.getCoordenadaX() - i * 0.14f);
                 d=0;
            }
               
        } else if (input.isKeyDown(Input.KEY_RIGHT)) {
            personaje.setDir("right");
            personaje.getDir().update(i);
            if(personaje.getH3().intersects(p1)||personaje.getH3().intersects(p2)){//||personaje.getH4().intersects(p2)||personaje.getH1().intersects(p1)||personaje.getH1().intersects(p2)){
                //personaje.setCoordenadaX(personaje.getCoordenadaX() - i * 1.25f);
                d=1;
            }
            else
            {
                d=0;
            }
            if(d==0 || c==1)
            {
                personaje.setCoordenadaX(personaje.getCoordenadaX() + i * 0.14f);
                c=0;
            }
                
        } else {
            personaje.setDir("stance");
            personaje.getDir().update(i);
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //System.out.println("a:"+a+" b:"+b+"c:"+c+" d:"+d);
    }

    @Override
    public void render(GameContainer gc, Graphics grphcs) throws SlickException {
        
        Graphics g = new Graphics();
        
        
        mapa.render(0, 0, 0);
        mapa.render(0, 0, 1);
        personaje.getDir().draw((int) personaje.getCoordenadaX(), (int) personaje.getCoordenadaY());
        mapa.render(0, 0, 2);
        mapa.render(0, 0, 3);
        mapa.render(0, 0, 4);
        
        g.draw(p1);
        g.draw(p2);
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
