/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estados;

import Elementos.Historia;
import EstadoBoss1.Boss1;
import Personajes.PersonajePrincipal;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.tiled.TiledMap;

/**
 *
 * @author lucas
 */
public class Cinematica5 extends BasicGameState {

    @Override
    public int getID() {
        return 32;
    }

    private String mapa1 = "Mapas\\MOVIE.tmx";
    private TiledMap mapa;

    private float bordes1[] = new float[]{512, 410, 512, 700, 510, 700, 510, 410};
    private Polygon borde;

    private float bordes2[] = new float[]{896, 110, 896, 700, 898, 700, 898, 110};
    private Polygon salida;

    private int contadorParpadeo = 20;
    private int contadorTemporal = 0;

    private Historia bocadilloB1 = new Historia("Historia130");
    private Historia bocadilloB2 = new Historia("Historia131");

    private Music song;
    private Boolean choqueIzquierda = false, choqueDerecha = false;
    private PersonajePrincipal personaje = new PersonajePrincipal();

    public Cinematica5() {
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
        Input input = gc.getInput();

        mapa.render(0, 0, 0);
        mapa.render(0, 0, 1);

        personaje.getDir().draw(personaje.getCoordenadaX(), personaje.getCoordenadaY());

        mapa.render(0, 0, 2);
        mapa.render(0, 0, 3);
        mapa.render(0, 0, 4);

        if (contadorTemporal > 1000) {

            if (contadorTemporal < 3100) {
                bocadilloB1.dentroXY(100, -18);
                bocadilloB1.getImagen().draw(bocadilloB1.getCoordenadaX(), bocadilloB1.getCoordenadaY());
            } else if (contadorTemporal < 5800) {
                bocadilloB2.dentroXY(100, -10);
                bocadilloB2.getImagen().draw(bocadilloB2.getCoordenadaX(), bocadilloB2.getCoordenadaY());
            } else {
                mapa = new TiledMap("Mapas\\MOVIE.tmx", "\\Construccion Mapas\\");
                if (input.isKeyDown(Input.KEY_T)) {
                    g.drawImage(new Image("\\Elementos aparte\\Instrucciones\\4.png"), 150, 130);
                }
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
                mapa = new TiledMap("Mapas\\mapa9Noche.tmx", "\\Construccion Mapas\\");
            } else {
                mapa = new TiledMap("Mapas\\boss0.tmx", "\\Construccion Mapas\\");
            }
            contadorParpadeo--;
        } else {
            if (contadorTemporal < 5800) {
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
                    choqueDerecha = false;
                } else if (input.isKeyDown(Input.KEY_D)) {
                    personaje.setDir("right");
                    personaje.getDir().update(i);
                    if (personaje.getCoordenadaX()<850) {
                        personaje.setCoordenadaX(personaje.getCoordenadaX() + i * 0.16f * velocidad);
                    } else {
                        personaje.setCoordenadaX(700);
                        personaje.setCoordenadaY(470);
                        personaje.setDir("up");
                        personaje.setDir("stance");
                        sbg.getState(31).init(gc, sbg);
                        try {
                            sbg.enterState(31, FadeOutTransition.class.newInstance(), FadeInTransition.class.newInstance());
                        } catch (InstantiationException ex) {
                            Logger.getLogger(Boss1.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IllegalAccessException ex) {
                            Logger.getLogger(Boss1.class.getName()).log(Level.SEVERE, null, ex);
                        }// --> BOSS3
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
