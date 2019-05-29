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
public class Cinematica2 extends BasicGameState {

    @Override
    public int getID() {
        return 18;
    }

    private String mapa1 = "Mapas\\MOVIE.tmx";
    TiledMap mapa;

    private float bordes1[] = new float[]{512, 410, 512, 700, 510, 700, 510, 410};
    Polygon borde;

    private float bordes2[] = new float[]{896, 110, 896, 700, 898, 700, 898, 110};
    Polygon salida;

    int contadorParpadeo = 20;
    int contadorTemporal = 0;

    Historia bocadilloB1 = new Historia("Historia50");
    Historia bocadilloN1 = new Historia("Historia51");
    Historia bocadilloB2 = new Historia("Historia52");
    Historia bocadilloN2 = new Historia("Historia53");
    Historia bocadilloB3 = new Historia("Historia54");
    Historia bocadilloN3 = new Historia("Historia55");
    Historia bocadilloB4 = new Historia("Historia56");

    Boolean choqueIzquierda = false, choqueDerecha = false;
    PersonajePrincipal personaje = new PersonajePrincipal();
    Music song;
    
    public Cinematica2() {
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

            if (contadorTemporal < 2600) {
                bocadilloB1.dentroXY(100, 0);
                bocadilloB1.getImagen().draw(bocadilloB1.getCoordenadaX(), bocadilloB1.getCoordenadaY());
            } else if (contadorTemporal < 4200) {
                bocadilloN1.dentro();
                bocadilloN1.getImagen().draw(bocadilloN1.getCoordenadaX(), bocadilloN1.getCoordenadaY());
            } else if (contadorTemporal < 5800) {
                bocadilloB2.dentroXY(100, 0);
                bocadilloB2.getImagen().draw(bocadilloB2.getCoordenadaX(), bocadilloB2.getCoordenadaY());
            } else if (contadorTemporal < 7400) {
                bocadilloN2.dentro();
                bocadilloN2.getImagen().draw(bocadilloN2.getCoordenadaX(), bocadilloN2.getCoordenadaY());
            } else if (contadorTemporal < 9000) {
                bocadilloB3.dentroXY(100, 0);
                bocadilloB3.getImagen().draw(bocadilloB3.getCoordenadaX(), bocadilloB3.getCoordenadaY());
            } else if (contadorTemporal < 10600) {
                bocadilloN3.dentro();
                bocadilloN3.getImagen().draw(bocadilloN3.getCoordenadaX(), bocadilloN3.getCoordenadaY());
            } else if (contadorTemporal < 12200) {
                bocadilloB4.dentroXY(100, 0);
                bocadilloB4.getImagen().draw(bocadilloB4.getCoordenadaX(), bocadilloB4.getCoordenadaY());
            } else {
                mapa = new TiledMap("Mapas\\MOVIE.tmx", "\\Construccion Mapas\\");
                if (input.isKeyDown(Input.KEY_T)) {
                    g.drawImage(new Image("\\Elementos aparte\\Instrucciones\\2.png"), 150, 130);
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
                mapa = new TiledMap("Mapas\\mapa10.tmx", "\\Construccion Mapas\\");
            } else {
                mapa = new TiledMap("Mapas\\boss0.tmx", "\\Construccion Mapas\\");
            }
            contadorParpadeo--;
        } else {
            if (contadorTemporal < 12250) {
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
                    if (!choqueIzquierda || choqueDerecha) {
                        personaje.setCoordenadaX(personaje.getCoordenadaX() - i * 0.16f * velocidad);
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
                            personaje.setCoordenadaX(700);
                            personaje.setCoordenadaY(470);
                            personaje.setDir("up");
                            personaje.setDir("stance");
                            sbg.getState(2).init(gc, sbg);
                            try {
                                sbg.enterState(2, FadeOutTransition.class.newInstance(), FadeInTransition.class.newInstance());
                            } catch (InstantiationException ex) {
                                Logger.getLogger(Boss1.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IllegalAccessException ex) {
                                Logger.getLogger(Boss1.class.getName()).log(Level.SEVERE, null, ex);
                            }// --> BOSS2
                        }
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
