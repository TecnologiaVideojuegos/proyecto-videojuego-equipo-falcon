/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estados;

import EstadoBoss2.*;
import Personajes.MainChar;
import Personajes.Nave;
import java.util.ArrayList;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

/**
 *
 * @author lucas
 */
public class Boss0 extends BasicGameState {

    private String mapa1 = "Mapas\\boss0.tmx";
    private float puntos1[] = new float[]{510, 223, 510, 545, 960, 545, 960, 223};
    private Polygon borde;
    private float puntos2[] = new float[]{895, 524, 949, 524, 949, 469, 923, 449, 895, 469};
    private Polygon salida;
    int first = 20;
    private boolean choqueArriba = false, choqueAbajo = false, choqueIzquierda = false, choqueDerecha = false;
    TiledMap mapa;
    int fase = 0, num = 0;
    Image[] mundoImg;
    int contadorMundo = 0;
    MainChar personaje;

    public Boss0() {
        borde = new Polygon(puntos1);
        salida = new Polygon(puntos2);

    }

    @Override
    public int getID() {
        return 3;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

        mapa = new TiledMap(mapa1, "\\Construccion Mapas\\");
        personaje = new MainChar();
        personaje.setCoordenadaX(628);
        personaje.setCoordenadaY(374);
        personaje.setDir("left");

    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        Graphics g = new Graphics();
        mapa.render(0, 0, 0);
        mapa.render(0, 0, 1);
        personaje.getDir().draw((int) personaje.getCoordenadaX(), (int) personaje.getCoordenadaY());
        mapa.render(0, 0, 2);
        mapa.render(0, 0, 3);
        mapa.render(0, 0, 4);

        /*g.draw(personaje.getH1());
         g.draw(personaje.getH2());
         g.draw(personaje.getH3());
         g.draw(personaje.getH4());

         g.draw(bordes);*/
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        int velocidad = 2;
        Input input = gc.getInput();
        if (first > 0) {
            if (first % 2 == 0) {
                mapa = new TiledMap("Mapas\\mapa3.tmx", "\\Construccion Mapas\\");
            } else {
                mapa = new TiledMap("Mapas\\boss0.tmx", "\\Construccion Mapas\\");
            }
            first--;

        } else {

            if (input.isKeyDown(Input.KEY_ENTER)) {
                gc.exit();
            }

            if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                System.out.println(input.getMouseX() + "," + input.getMouseY() + ",");
            }
            if (input.isKeyDown(Input.KEY_W)) {
                personaje.setDir("up");
                personaje.getDir().update(i);

                if (personaje.getH1().intersects(borde)) {
                    choqueArriba = true;

                } else {
                    choqueArriba = false;
                }

                if (!choqueArriba || choqueAbajo) {
                    personaje.setCoordenadaY(personaje.getCoordenadaY() - i * 0.14f * velocidad);

                    if (personaje.getH1().intersects(salida)) {
                        sbg.enterState(0);
                    }

                    choqueAbajo = false;
                }

            } else if (input.isKeyDown(Input.KEY_S)) {
                personaje.setDir("down");
                personaje.getDir().update(i);

                if (personaje.getH4().intersects(borde)) {
                    choqueAbajo = true;

                } else {
                    choqueAbajo = false;
                }

                if (!choqueAbajo || choqueArriba) {
                    personaje.setCoordenadaY(personaje.getCoordenadaY() + i * 0.14f * velocidad);

                    if (personaje.getH4().intersects(salida)) {
                        sbg.enterState(0);
                    }

                    choqueArriba = false;
                }

            } else if (input.isKeyDown(Input.KEY_A)) {
                personaje.setDir("left");
                personaje.getDir().update(i);

                if (personaje.getH2().intersects(borde)) {
                    choqueIzquierda = true;

                } else {
                    choqueIzquierda = false;
                }

                if (!choqueIzquierda || choqueDerecha) {
                    personaje.setCoordenadaX(personaje.getCoordenadaX() - i * 0.16f * velocidad);

                    if (personaje.getH2().intersects(salida)) {
                        sbg.enterState(0);
                    }

                    choqueDerecha = false;
                }

            } else if (input.isKeyDown(Input.KEY_D)) {
                personaje.setDir("right");
                personaje.getDir().update(i);

                if (personaje.getH3().intersects(borde)) {
                    choqueDerecha = true;

                } else {
                    choqueDerecha = false;
                }

                if (!choqueDerecha || choqueIzquierda) {
                    personaje.setCoordenadaX(personaje.getCoordenadaX() + i * 0.16f * velocidad);

                    if (personaje.getH3().intersects(salida)) {
                        sbg.enterState(0);
                    }

                    choqueIzquierda = false;

                }

            } else {
                personaje.setDir("stance");
                personaje.getDir().update(i);
            }

        }
    }
}
