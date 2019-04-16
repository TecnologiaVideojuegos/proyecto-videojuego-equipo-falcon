/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estados;

import Mapas.Mapa1;
import Mapas.Mapa2;
import Mapas.Mapa3;
import Mapas.Mapa4;
import Mapas.Mapa5;
import Mapas.Mapa6;
import Mapas.Mapa8;
import Mapas.Mapa7;
import Mapas.Mapa9;
import Mapas.MapaT;
import Personajes.MainChar;
import java.util.ArrayList;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.*;

/**
 *
 * @author lucas
 */
public class Mundo extends BasicGameState {

    ArrayList<MapaT> mapas;
    private static TiledMap mapa;
    int a = 0, b = 0, c = 0, d = 0;
    Mapa1 mapa1 = new Mapa1();
    Mapa2 mapa2 = new Mapa2();
    Mapa3 mapa3 = new Mapa3();
    Mapa4 mapa4 = new Mapa4();
    Mapa5 mapa5 = new Mapa5();
    Mapa6 mapa6 = new Mapa6();
    Mapa7 mapa7 = new Mapa7();
    Mapa8 mapa8 = new Mapa8();
    Mapa9 mapa9 = new Mapa9();
    MapaT mapa_actual = new MapaT();
    MainChar personaje;
    ArrayList<Rectangle> colPers;

    public Mundo(int num) {

        colPers = new ArrayList<>();
        mapas = new ArrayList<>();
        mapas.add(mapa1);
        mapas.add(mapa2);
        mapas.add(mapa3);
        mapas.add(mapa4);
        mapas.add(mapa5);
        mapas.add(mapa6);
        mapas.add(mapa7);
        mapas.add(mapa8);
        mapas.add(mapa9);

        mapa_actual = mapas.get(num);
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        mapa = new TiledMap(mapa_actual.getMapa(), "\\Construccion Mapas\\");
        personaje = new MainChar();
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        int x = 1;
        float nuevo_mapa = 0;
        Input input = gc.getInput();
        ArrayList<Polygon> salidas = mapa_actual.getSalidas();
        for (int j = 0; j < mapa_actual.getPersonajes().size(); j++) {
            colPers.add(mapa_actual.getPersonajes().get(j).getH1());
        }
        if (input.isKeyDown(Input.KEY_ENTER)) {
            gc.exit();
        }

        if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
            System.out.println(input.getMouseX() + "," + input.getMouseY() + ",");
        }
        if (input.isKeyDown(Input.KEY_W)) {
            personaje.setDir("up");
            personaje.getDir().update(i);
            for (int n = 0; n < mapa_actual.getBordes().size(); n++) {
                if (personaje.getH1().intersects(mapa_actual.getBordes().get(n))) {
                    a = 1;
                    break;
                } else {
                    a = 0;
                }
            }
            for (int j = 0; j < mapa_actual.getPersonajes().size(); j++) {
                if (colPers.get(j).intersects(personaje.getH1())) {
                    a = 1;
                    break;
                }
            }
            if (a == 0 || b == 1) {
                personaje.setCoordenadaY(personaje.getCoordenadaY() - i * 0.14f * x);
                for (int n = 0; n < salidas.size(); n++) {
                    if (personaje.getH1().intersects(salidas.get(n))) {
                        nuevo_mapa = mapa_actual.getMapas(n);
                        mapa_actual.setCoordX(n, (int) personaje.getCoordenadaX());
                        personaje.setCoordenadaX(mapa_actual.getCoord()[n * 2]);
                        personaje.setCoordenadaY(mapa_actual.getCoord()[n * 2 + 1]);
                        mapa_actual = mapas.get((int) nuevo_mapa);
                        mapa = new TiledMap(mapa_actual.getMapa(), "\\Construccion Mapas\\");
                    }
                }
                b = 0;
            }

        } else if (input.isKeyDown(Input.KEY_S)) {
            personaje.setDir("down");
            personaje.getDir().update(i);
            for (int n = 0; n < mapa_actual.getBordes().size(); n++) {
                if (personaje.getH4().intersects(mapa_actual.getBordes().get(n))) {
                    b = 1;
                    break;
                } else {
                    b = 0;
                }
            }
            for (int j = 0; j < mapa_actual.getPersonajes().size(); j++) {
                if (colPers.get(j).intersects(personaje.getH4())) {
                    b = 1;
                    break;
                }
            }
            if (b == 0 || a == 1) {
                personaje.setCoordenadaY(personaje.getCoordenadaY() + i * 0.14f * x);
                for (int n = 0; n < salidas.size(); n++) {
                    if (personaje.getH4().intersects(salidas.get(n))) {
                        nuevo_mapa = mapa_actual.getMapas(n);
                        mapa_actual.setCoordX(n, (int) personaje.getCoordenadaX());
                        personaje.setCoordenadaX(mapa_actual.getCoord()[n * 2]);
                        personaje.setCoordenadaY(mapa_actual.getCoord()[n * 2 + 1]);
                        mapa_actual = mapas.get((int) nuevo_mapa);
                        mapa = new TiledMap(mapa_actual.getMapa(), "\\Construccion Mapas\\");
                        if (nuevo_mapa == 5) {
                            System.out.println("3");
                            sbg.enterState(1);
                        }
                    }
                }
                a = 0;
            }

        } else if (input.isKeyDown(Input.KEY_A)) {
            personaje.setDir("left");
            personaje.getDir().update(i);
            for (int n = 0; n < mapa_actual.getBordes().size(); n++) {

                if (personaje.getH2().intersects(mapa_actual.getBordes().get(n))) {
                    c = 1;
                    break;
                } else {
                    c = 0;
                }
            }
            for (int j = 0; j < mapa_actual.getPersonajes().size(); j++) {
                if (colPers.get(j).intersects(personaje.getH2())) {
                    c = 1;
                    break;
                }
            }
            if (c == 0 || d == 1) {
                personaje.setCoordenadaX(personaje.getCoordenadaX() - i * 0.16f * x);
                for (int n = 0; n < salidas.size(); n++) {
                    if (personaje.getH2().intersects(salidas.get(n))) {

                        nuevo_mapa = mapa_actual.getMapas(n);
                        mapa_actual.setCoordY(n, (int) personaje.getCoordenadaY());
                        personaje.setCoordenadaX(mapa_actual.getCoord()[n * 2]);
                        personaje.setCoordenadaY(mapa_actual.getCoord()[n * 2 + 1]);
                        mapa_actual = mapas.get((int) nuevo_mapa);
                        mapa = new TiledMap(mapa_actual.getMapa(), "\\Construccion Mapas\\");
                    }
                }
                d = 0;
            }

        } else if (input.isKeyDown(Input.KEY_D)) {
            personaje.setDir("right");
            personaje.getDir().update(i);
            for (int n = 0; n < mapa_actual.getBordes().size(); n++) {
                if (personaje.getH3().intersects(mapa_actual.getBordes().get(n))) {
                    d = 1;
                    break;
                } else {
                    d = 0;
                }
            }
            for (int j = 0; j < mapa_actual.getPersonajes().size(); j++) {
                if (colPers.get(j).intersects(personaje.getH3())) {
                    d = 1;
                    break;
                }
            }
            if (d == 0 || c == 1) {
                personaje.setCoordenadaX(personaje.getCoordenadaX() + i * 0.16f * x);
                for (int n = 0; n < salidas.size(); n++) {
                    if (personaje.getH3().intersects(salidas.get(n))) {
                        nuevo_mapa = mapa_actual.getMapas(n);
                        mapa_actual.setCoordY(n, (int) personaje.getCoordenadaY());
                        personaje.setCoordenadaX(mapa_actual.getCoord()[n * 2]);
                        personaje.setCoordenadaY(mapa_actual.getCoord()[n * 2 + 1]);
                        mapa_actual = mapas.get((int) nuevo_mapa);
                        mapa = new TiledMap(mapa_actual.getMapa(), "\\Construccion Mapas\\");

                    }
                }
                c = 0;

            }

        } else {
            personaje.setDir("stance");
            personaje.getDir().update(i);
        }

        for (int j = 0; j < mapa_actual.getPersonajes().size(); j++) {
            if (colPers.get(j).intersects(personaje.getH4())) {
                mapa_actual.getPersonajes().get(j).setDir("sup");
                personaje.setDir("stance");
            } else if (colPers.get(j).intersects(personaje.getH3())) {
                mapa_actual.getPersonajes().get(j).setDir("sleft");
                personaje.setDir("stance");
            } else if (colPers.get(j).intersects(personaje.getH2())) {
                mapa_actual.getPersonajes().get(j).setDir("sright");
                personaje.setDir("stance");
            } else if (colPers.get(j).intersects(personaje.getH1())) {
                mapa_actual.getPersonajes().get(j).setDir("sdown");
                personaje.setDir("stance");
            } else {
                mapa_actual.getPersonajes().get(j).move();
                mapa_actual.getPersonajes().get(j).getDir().update(i);
            }
        }

    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {

        Graphics g = new Graphics();
        mapa.render(0, 0, 0);
        mapa.render(0, 0, 1);
        for (int j = 0; j < mapa_actual.getPersonajes().size(); j++) {
            mapa_actual.getPersonajes().get(j).getDir().draw(mapa_actual.getPersonajes().get(j).getCoordenadaX(), mapa_actual.getPersonajes().get(j).getCoordenadaY());
            g.draw(mapa_actual.getPersonajes().get(j).getH1());
        }
        personaje.getDir().draw((int) personaje.getCoordenadaX(), (int) personaje.getCoordenadaY());
        mapa.render(0, 0, 2);
        mapa.render(0, 0, 3);
        mapa.render(0, 0, 4);

        g.draw(personaje.getH1());
        g.draw(personaje.getH2());
        g.draw(personaje.getH3());
        g.draw(personaje.getH4());

        for (int i = 0; i < mapa_actual.getBordes().size(); i++) {
            g.draw(mapa_actual.getBordes().get(i));
        }

    }

    @Override
    public int getID() {
        return 0; //To change body of generated methods, choose Tools | Templates.
    }
}
