/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import Clases.Mapa1;
import Clases.Mapa2;
import Clases.MapaT;
import Clases.Sprite;
import java.util.ArrayList;
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

    ArrayList<MapaT> mapas;
    private static TiledMap mapa;
    int a = 0, b = 0, c = 0, d = 0;
    Mapa1 mapa1 = new Mapa1();
    Mapa2 mapa2 = new Mapa2();
    MapaT mapa_actual = new MapaT();
    Sprite personaje;

    public BuclePrincipal() {
        super("");
        mapa_actual = mapa1;
        mapas = new ArrayList<>();
        mapas.add(mapa1);
        mapas.add(mapa2);
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
        mapa = new TiledMap(mapa_actual.getMapa());
        personaje = new Sprite();
    }

    @Override
    public void update(GameContainer gc, int i) throws SlickException {
        Polygon salidas[] = mapa_actual.getSalidas();
        float nuevo_mapa = 0;
        Input input = gc.getInput();
        if (input.isKeyDown(Input.KEY_ENTER)) {
            gc.exit();
        }
        System.out.println(input.getMouseX() + "-" + input.getMouseY());
        if (input.isKeyDown(Input.KEY_UP)) {
            personaje.setDir("up");
            personaje.getDir().update(i);
            
            
            if (personaje.getH1().intersects(mapa_actual.getBordes()[0]) || personaje.getH1().intersects(mapa_actual.getBordes()[1])) {
                a = 1;
            } else {
                a = 0;
            }
            if (a == 0 || b == 1) {
                personaje.setCoordenadaY(personaje.getCoordenadaY() - i * 0.16f);
                for(int n=0;n<2;n++)
                {
                    if(personaje.getH1().intersects(salidas[n]))
                    {
                        nuevo_mapa = mapa_actual.getMapas(n);
                        mapa_actual = mapas.get((int)nuevo_mapa);
                        mapa = new TiledMap(mapa_actual.getMapa());
                        personaje.setCoordenadaX(830);
                        personaje.setCoordenadaY(640);
                    }
                }
                b = 0;
            }

        } else if (input.isKeyDown(Input.KEY_DOWN)) {
            personaje.setDir("down");
            personaje.getDir().update(i);
            if (personaje.getH4().intersects(mapa_actual.getBordes()[0]) || personaje.getH4().intersects(mapa_actual.getBordes()[1])) {
                b = 1;
            } else {
                b = 0;
            }
            if (b == 0 || a == 1) {
                personaje.setCoordenadaY(personaje.getCoordenadaY() + i * 0.16f);
                for(int n=0;n<2;n++)
                {
                    if(personaje.getH4().intersects(salidas[n]))
                    {
                        nuevo_mapa = mapa_actual.getMapas(n);
                        mapa_actual = mapas.get((int)nuevo_mapa);
                        mapa = new TiledMap(mapa_actual.getMapa());
                        personaje.setCoordenadaX(830);
                        personaje.setCoordenadaY(640);
                    }
                }
                a = 0;
            }

        } else if (input.isKeyDown(Input.KEY_LEFT)) {
            personaje.setDir("left");
            personaje.getDir().update(i);
            if (personaje.getH2().intersects(mapa_actual.getBordes()[0]) || personaje.getH2().intersects(mapa_actual.getBordes()[1])) {
                c = 1;
            } else {
                c = 0;
            }
            if (c == 0 || d == 1) {
                personaje.setCoordenadaX(personaje.getCoordenadaX() - i * 0.16f);
                for(int n=0;n<2;n++)
                {
                    if(personaje.getH2().intersects(salidas[n]))
                    {
                        nuevo_mapa = mapa_actual.getMapas(n);
                        mapa_actual = mapas.get((int)nuevo_mapa);
                        mapa = new TiledMap(mapa_actual.getMapa());
                        personaje.setCoordenadaX(830);
                        personaje.setCoordenadaY(640);
                    }
                }
                d = 0;
            }

        } else if (input.isKeyDown(Input.KEY_RIGHT)) {
            personaje.setDir("right");
            personaje.getDir().update(i);
            if (personaje.getH3().intersects(mapa_actual.getBordes()[0]) || personaje.getH3().intersects(mapa_actual.getBordes()[1])) {
                d = 1;
            } else {
                d = 0;
            }
            if (d == 0 || c == 1) {
                personaje.setCoordenadaX(personaje.getCoordenadaX() + i * 0.16f);
                for(int n=0;n<2;n++)
                {
                    if(personaje.getH3().intersects(salidas[n]))
                    {
                        nuevo_mapa = mapa_actual.getMapas(n);
                        mapa_actual = mapas.get((int)nuevo_mapa);
                        mapa = new TiledMap(mapa_actual.getMapa());
                        personaje.setCoordenadaX(830);
                        personaje.setCoordenadaY(640);
                    }
                }
                c = 0;

            }

        } else {
            personaje.setDir("stance");
            personaje.getDir().update(i);
        }

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
        
        g.draw(mapa_actual.getSalidas()[0]);
        g.draw(mapa_actual.getSalidas()[1]);
        g.draw(mapa_actual.getBordes()[0]);
        g.draw(mapa_actual.getBordes()[1]);

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
