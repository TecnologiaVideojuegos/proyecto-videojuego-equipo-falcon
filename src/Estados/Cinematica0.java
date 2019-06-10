/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estados;

import Elementos.Historia;
import Personajes.PersonajePrincipal;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

/**
 *
 * @author lucas
 */
public class Cinematica0 extends BasicGameState {

    @Override
    public int getID() {
        return 5;
    }

    private String mapa1 = "Mapas\\MOVIE.tmx";
    private TiledMap mapa;

    private float bordes1[] = new float[]{512, 410, 512, 555, 965, 555, 965, 410};
    private Polygon borde;

    private float bordes2[] = new float[]{896, 110, 896, 700, 898, 700, 898, 110};
    private Polygon salida;

    private int contadorParpadeo = 20;
    private int contadorTemporal = 0;

    private Historia bocadilloB1 = new Historia("Historia01");
    private Historia bocadilloB2 = new Historia("Historia02");
    private Historia bocadilloB3 = new Historia("Historia03");
    private Historia bocadilloB4 = new Historia("Historia04");
    private Historia bocadilloN1 = new Historia("Historia05");
    private Historia bocadilloN2 = new Historia("Historia06");
    private Historia bocadilloN3 = new Historia("Historia07");
    private Historia bocadilloN4 = new Historia("Historia08");

    private Boolean choqueIzquierda = false, choqueDerecha = false;
    private Music song;
    private PersonajePrincipal personaje = new PersonajePrincipal();

    public Cinematica0() {
        borde = new Polygon(bordes1);
        salida = new Polygon(bordes2);
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

        song = new Music("\\Elementos Aparte\\MusicaDefinitiva\\Boss0.wav");
        mapa = new TiledMap(mapa1, "\\Construccion Mapas\\");
        personaje.setCoordenadaX(700);
        personaje.setCoordenadaY(470);
        personaje.setDir("up");
        personaje.setDir("stance");

    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        mapa.render(0, 0, 0);
        mapa.render(0, 0, 1);
        personaje.getDir().draw(personaje.getCoordenadaX(), personaje.getCoordenadaY());

        mapa.render(0, 0, 2);
        mapa.render(0, 0, 3);
        mapa.render(0, 0, 4);
        if (contadorTemporal > 1000) {

            if (contadorTemporal < 2600) {
                bocadilloB1.dentroXY(100, 0);
                bocadilloB1.getImagen().draw(bocadilloB1.getCoordenadaX(), bocadilloB1.getCoordenadaY());
            } else if (contadorTemporal < 4200) {
                bocadilloN1.dentro();
                bocadilloN1.getImagen().draw(bocadilloN1.getCoordenadaX(), bocadilloN1.getCoordenadaY());
            } else if (contadorTemporal < 6900) {
                bocadilloB2.dentroXY(100, 0);
                bocadilloB2.getImagen().draw(bocadilloB2.getCoordenadaX(), bocadilloB2.getCoordenadaY());
            } else if (contadorTemporal < 9500) {
                bocadilloN2.dentro();
                bocadilloN2.getImagen().draw(bocadilloN2.getCoordenadaX(), bocadilloN2.getCoordenadaY());
            } else if (contadorTemporal < 12500) {
                bocadilloB3.dentroXY(100, 0);
                bocadilloB3.getImagen().draw(bocadilloB3.getCoordenadaX(), bocadilloB3.getCoordenadaY());
            } else if (contadorTemporal < 15200) {
                bocadilloN3.dentro();
                bocadilloN3.getImagen().draw(bocadilloN3.getCoordenadaX(), bocadilloN3.getCoordenadaY());
            } else if (contadorTemporal < 16800) {
                bocadilloB4.dentroXY(100, 0);
                bocadilloB4.getImagen().draw(bocadilloB4.getCoordenadaX(), bocadilloB4.getCoordenadaY());
            } else if (contadorTemporal < 18400) {
                bocadilloN4.dentro();
                bocadilloN4.getImagen().draw(bocadilloN4.getCoordenadaX(), bocadilloN4.getCoordenadaY());
            } else {
                mapa = new TiledMap("Mapas\\MOVIE0.tmx", "\\Construccion Mapas\\");
            }

        }
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {

        if (!song.playing()) {
            song.setPosition((float) 12.55);
            song.play();
            song.setVolume((float) 0.2);
        }

        int velocidad = 1;
        Input input = gc.getInput();
        if (contadorParpadeo > 0) {
            if (contadorParpadeo % 2 == 0) {
                mapa = new TiledMap("Mapas\\mapa3.tmx", "\\Construccion Mapas\\");
            } else {
                mapa = new TiledMap("Mapas\\boss0.tmx", "\\Construccion Mapas\\");
            }
            contadorParpadeo--;
        } else {
            if (contadorTemporal < 18400) {
                contadorTemporal++;
            } else {
                if (input.isKeyDown(Input.KEY_A)) {
                    personaje.setDir("left");
                    personaje.getDir().update(i);
                    if (personaje.getH2().intersects(borde)) {
                        choqueIzquierda = true;
                    } else {
                        choqueIzquierda = false;
                    }

                    if (personaje.getCoordenadaX()>500) {
                        personaje.setCoordenadaX(personaje.getCoordenadaX() - i * 0.16f * velocidad);
                    }
                } else if (input.isKeyDown(Input.KEY_D)) {
                    personaje.setDir("right");
                    personaje.getDir().update(i);
                    if (personaje.getCoordenadaX()<860) {
                        personaje.setCoordenadaX(personaje.getCoordenadaX() + i * 0.16f * velocidad);
                    } else {
                        sbg.enterState(14);// --> MUNDO
                    }

                    choqueIzquierda = false;
                } else {
                    personaje.setDir("stance");
                    personaje.getDir().update(i);
                }
            }
        }
    }
}
