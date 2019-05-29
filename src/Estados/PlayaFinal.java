/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estados;

import Elementos.Historia;
import Personajes.PersonajePrincipal;
import Personajes.PersonajeProfesor;
import java.util.ArrayList;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.*;

/**
 *
 * @author lucas
 */
public class PlayaFinal extends BasicGameState {
    @Override
    public int getID() {
        return 12; //To change body of generated methods, choose Tools | Templates.
    }

    private static TiledMap mapa;
    boolean choqueArriba = false, choqueAbajo = false, choqueIzquierda = false, choqueDerecha = false;
    PersonajePrincipal personaje;

    private float borde1[] = new float[]{63, 0, 256, 0, 256, 33, 985, 33, 985, 65, 1027, 65, 1027, 36, 1180, 36, 1180, 68, 1218, 68, 1218, 141, 1242, 164, 1242, 200, 1282, 200, 1282, 186, 1402, 186, 1433, 223, 1469, 223, 1469, 778, 1091, 778, 1091, 741, 1184, 738, 1184, 671, 1153, 671, 1153, 700, 1058, 700, 1058, 733, 1020, 733, 1020, 785, 35, 785, 35, 32, 65, 32};
    private ArrayList<Polygon> colisiones_bordes;

    private float salida1[] = new float[]{66, 2, 252, 2, 252, 0, 66, 0};
    private ArrayList<Polygon> colisiones_salidas;

    private PersonajeProfesor profesor;

    int contadorTemporal = 0; Music song;
    Historia bocadillo10 = new Historia("Historia30");
    Historia bocadillo11 = new Historia("Historia31");
    Historia bocadillo12 = new Historia("Historia32");
    Historia bocadillo13 = new Historia("Historia33");
    Historia bocadillo14 = new Historia("Historia34");

    public PlayaFinal() {
        colisiones_bordes = new ArrayList<>();
        colisiones_bordes.add(new Polygon(borde1));

        colisiones_salidas = new ArrayList<>();
        colisiones_salidas.add(new Polygon(salida1));

        profesor = new PersonajeProfesor();
        profesor.noLanza();
        profesor.setCoord(1005, 595);
        
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        song = new Music("\\Elementos Aparte\\MusicaDefinitiva\\fondo1.wav");
        mapa = new TiledMap("\\Mapas\\mapa6.tmx", "\\Construccion Mapas\\");
        personaje = new PersonajePrincipal();
        personaje.setCoordenadaX(1007);
        personaje.setCoordenadaY(665);
        personaje.getUp();
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
       
        if (!song.playing()) {
            song.setPosition((float) 12.55);
            song.play();
            song.setVolume((float) 0.2);
        }
        
        if (contadorTemporal<8200) {
            contadorTemporal++;
        } else {

            int velocidad = 1;
            Input input = gc.getInput();
            

            if (input.isKeyDown(Input.KEY_W)) {
                personaje.setDir("up");
                personaje.getDir().update(i);
                for (int n = 0; n < colisiones_bordes.size(); n++) {
                    if (personaje.getH1().intersects(colisiones_bordes.get(n))) {
                        choqueArriba = true;
                        break;
                    } else {
                        choqueArriba = false;
                    }
                }
                if (profesor.getHitbox().intersects(personaje.getH1())) {
                    choqueArriba = true;
                }
                if (!choqueArriba || choqueAbajo) {
                    personaje.setCoordenadaY(personaje.getCoordenadaY() - i * 0.14f * velocidad);
                    for (int n = 0; n < colisiones_salidas.size(); n++) {
                        if (personaje.getH1().intersects(colisiones_salidas.get(n))) {
                            sbg.enterState(15); // --> MUNDO
                        }
                    }
                    choqueAbajo = false;
                }

            } else if (input.isKeyDown(Input.KEY_S)) {
                personaje.setDir("down");
                personaje.getDir().update(i);
                for (int n = 0; n < colisiones_bordes.size(); n++) {
                    if (personaje.getH4().intersects(colisiones_bordes.get(n))) {
                        choqueAbajo = true;
                        break;
                    } else {
                        choqueAbajo = false;
                    }
                }
                if (profesor.getHitbox().intersects(personaje.getH4())) {
                    choqueAbajo = true;
                }
                if (!choqueAbajo || choqueArriba) {
                    personaje.setCoordenadaY(personaje.getCoordenadaY() + i * 0.14f * velocidad);
                    choqueArriba = false;
                }

            } else if (input.isKeyDown(Input.KEY_A)) {
                personaje.setDir("left");
                personaje.getDir().update(i);
                for (int n = 0; n < colisiones_bordes.size(); n++) {

                    if (personaje.getH2().intersects(colisiones_bordes.get(n))) {
                        choqueIzquierda = true;
                        break;
                    } else {
                        choqueIzquierda = false;
                    }
                }
                if (profesor.getHitbox().intersects(personaje.getH2())) {
                    choqueIzquierda = true;
                }
                
                if (!choqueIzquierda || choqueDerecha) {
                    personaje.setCoordenadaX(personaje.getCoordenadaX() - i * 0.16f * velocidad);
                    choqueDerecha = false;
                }

            } else if (input.isKeyDown(Input.KEY_D)) {
                personaje.setDir("right");
                personaje.getDir().update(i);
                for (int n = 0; n < colisiones_bordes.size(); n++) {
                    if (personaje.getH3().intersects(colisiones_bordes.get(n))) {
                        choqueDerecha = true;
                        break;
                    } else {
                        choqueDerecha = false;
                    }
                }
                if (profesor.getHitbox().intersects(personaje.getH3())) {
                    choqueDerecha = true;
                }
                if (!choqueDerecha || choqueIzquierda) {
                    personaje.setCoordenadaX(personaje.getCoordenadaX() + i * 0.16f * velocidad);
                    choqueIzquierda = false;
                }
            } else {
                personaje.setDir("stance");
                personaje.getDir().update(i);
            }
            
            
            
            if (profesor.getHitbox().intersects(personaje.getH4())) {
                profesor.setDir("sup");
                profesor.alerta();
                ;
                if (input.isKeyDown(Input.KEY_E)) {
                    profesor.talk();
                }
            } else if (profesor.getHitbox().intersects(personaje.getH3())) {
                profesor.setDir("sleft");
                profesor.alerta();
                ;
                if (input.isKeyDown(Input.KEY_E)) {
                    profesor.talk();
                }
            } else if (profesor.getHitbox().intersects(personaje.getH2())) {
                profesor.setDir("sright");
                profesor.alerta();
                ;
                if (input.isKeyDown(Input.KEY_E)) {
                    profesor.talk();
                }
            } else if (profesor.getHitbox().intersects(personaje.getH1())) {
                profesor.setDir("sdown");
                profesor.alerta();
                ;
                if (input.isKeyDown(Input.KEY_E)) {
                    profesor.talk();
                }
            } else {
                profesor.noAlerta();
                profesor.noTalk();
                profesor.move();
                profesor.getDir().update(i);
            }
        }
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        Input input = gc.getInput();
        
        mapa.render(0, 0, 0);
        mapa.render(0, 0, 1);
        
        profesor.getDir().draw(profesor.getCoordenadaX(),profesor.getCoordenadaY());
        personaje.getDir().draw((int) personaje.getCoordenadaX(), (int) personaje.getCoordenadaY());

        mapa.render(0, 0, 2);
        mapa.render(0, 0, 3);
        mapa.render(0, 0, 4);

        /*for (int i = 0; i < colisiones_bordes.size(); i++) {
            g.draw(colisiones_bordes.get(i));
        }*/
        
        profesor.getTalk().getImagen().draw(profesor.getTalk().getCoordenadaX(), profesor.getTalk().getCoordenadaY());
        profesor.getAlerta().getImagen().draw(profesor.getAlerta().getCoordenadaX(), profesor.getAlerta().getCoordenadaY());

        
        if (input.isKeyDown(Input.KEY_T)) {
            g.drawImage(new Image("\\Elementos aparte\\mapa1.png"), 550, 200);
        }

        if (contadorTemporal > 0) {
        
        if (contadorTemporal < 1550) {
            bocadillo10.dentro();
            bocadillo10.getImagen().draw(bocadillo10.getCoordenadaX(), bocadillo10.getCoordenadaY());
        } 
        else if (contadorTemporal < 3150) {
            bocadillo11.dentro();
            bocadillo11.getImagen().draw(bocadillo11.getCoordenadaX(), bocadillo11.getCoordenadaY());
        } 
        else if (contadorTemporal < 3400) {
            if(personaje.getDir().getFrameCount()!=2)
            {
                personaje.getDir().update(contadorTemporal/500);
                if(personaje.getDir().getFrame()==2)
                {
                    personaje.setDir("up");
                    personaje.setDir("stance");
                }
            }
        } 
        else if (contadorTemporal < 5000) {
            bocadillo12.dentro();
            bocadillo12.getImagen().draw(bocadillo12.getCoordenadaX(), bocadillo12.getCoordenadaY());
        }
        else if (contadorTemporal < 6600) {
            bocadillo13.dentro();
            bocadillo13.getImagen().draw(bocadillo13.getCoordenadaX(), bocadillo13.getCoordenadaY());
        } 
        else if (contadorTemporal < 8200) {
            bocadillo14.dentro();
            bocadillo14.getImagen().draw(bocadillo14.getCoordenadaX(), bocadillo14.getCoordenadaY());
        }  
        
        } 
    }
}
