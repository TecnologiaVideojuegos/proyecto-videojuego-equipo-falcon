/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estados;

import Mapas.Mapa1;
import Mapas.Mapa10;
import Mapas.Mapa2;
import Mapas.Mapa3;
import Mapas.Mapa4;
import Mapas.Mapa5;
import Mapas.Mapa6;
import Mapas.Mapa8;
import Mapas.Mapa7;
import Mapas.Mapa9;
import Mapas.MapaT;
import Personajes.EscalerasCasa;
import Personajes.EscalerasColegio;
import Personajes.LadoColegio;
import Personajes.PasoCompra;
import Personajes.PersonajeEstaticoA;
import Personajes.PersonajePrincipal;
import Personajes.PersonajeGeneral;
import java.util.ArrayList;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
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
    boolean choqueArriba = false, choqueAbajo = false, choqueIzquierda = false, choqueDerecha = false;
    Mapa1 mapa1 = new Mapa1();
    Mapa2 mapa2 = new Mapa2();
    Mapa3 mapa3 = new Mapa3();
    Mapa4 mapa4 = new Mapa4();
    Mapa5 mapa5 = new Mapa5();
    Mapa6 mapa6 = new Mapa6();
    Mapa7 mapa7 = new Mapa7();
    Mapa8 mapa8 = new Mapa8();
    Mapa9 mapa9 = new Mapa9();
    Mapa10 mapa10 = new Mapa10();
    MapaT mapa_actual = new MapaT();
    PersonajePrincipal personaje;
    
    ArrayList<Polygon> colisiones_salidas;
    ArrayList<Polygon> colisiones_bordes;
    ArrayList<Rectangle> colisionNPCs;
    ArrayList<PersonajeGeneral> NPCs;
    
    Music song;
    
    PersonajeEstaticoA tendero1 = new PersonajeEstaticoA("right", 380,150,"MP1","Marinero");
    PersonajeEstaticoA tendero2 = new PersonajeEstaticoA("left", 420,150,"MP0","Marinero");
    
    //Elementos historia
    EscalerasColegio escaleras2 = new EscalerasColegio();
    LadoColegio bordeH = new LadoColegio();
    EscalerasCasa escaleras3 = new EscalerasCasa();
    PasoCompra paso = new PasoCompra();
    
    public void setMundo(int num)
    {
        mapa_actual = mapas.get(num);
    }
    public Mundo(int num) {

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
        mapas.add(mapa10);

        mapa_actual = mapas.get(num);
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        song = new Music("\\Elementos Aparte\\MusicaDefinitiva\\fondo1.wav");
        mapa = new TiledMap(mapa_actual.getMapa(), "\\Construccion Mapas\\");
        personaje = new PersonajePrincipal();
        personaje.setCoordenadaX(461);
        personaje.setCoordenadaY(125);

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
        
        colisiones_salidas = mapa_actual.getSalidas();
        colisiones_bordes = mapa_actual.getBordes();
        NPCs = mapa_actual.getPersonajes();
        
        colisionNPCs = new ArrayList<>();
        for (int j = 0; j < mapa_actual.getPersonajes().size(); j++) {
            colisionNPCs.add(NPCs.get(j).getHitbox());
        }

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
            for (int j = 0; j < NPCs.size(); j++) {
                if (colisionNPCs.get(j).intersects(personaje.getH1())) {
                    if (NPCs.get(j).isSGB()) {
                    int state = NPCs.get(j).getSGB();
                    NPCs.get(j).notSGB();
                    if (state == 13) {
                            mapa_actual.chMod();
                            NPCs.remove(NPCs.get(j));
                            colisionNPCs.remove(colisionNPCs.get(j));
                            NPCs.add(bordeH);
                            NPCs.add(tendero1);
                            NPCs.add(tendero2);
                            colisionNPCs.add(bordeH.getHitbox());
                            colisionNPCs.add(tendero1.getHitbox());
                            colisionNPCs.add(tendero2.getHitbox());
                            personaje.setDir("down");
                    }
                    if(state==22)
                    {
                         personaje.setDir("down");
                         NPCs.remove(0);
                         colisionNPCs.remove(0);
                         PersonajeEstaticoA o1 = new PersonajeEstaticoA("down", 1390,340,"MP0","Marinero");
                         PersonajeEstaticoA o2 = new PersonajeEstaticoA("up",1390,380,"MP1","Marinero");
                         NPCs.add(o1);
                         NPCs.add(o2);
                         colisionNPCs.add(o1.getHitbox());
                         colisionNPCs.add(o2.getHitbox());
                         mapa9.getPersonajes().add(paso);
                    }
                    sbg.enterState(state);
                    }
                    choqueArriba = true;
                    break;
                }
            }
            if (!choqueArriba || choqueAbajo) {
                personaje.setCoordenadaY(personaje.getCoordenadaY() - i * 0.14f * velocidad);
                for (int n = 0; n < colisiones_salidas.size(); n++) {
                    if (personaje.getH1().intersects(colisiones_salidas.get(n))) {
                        mapa_actual.setCoordX(n, (int) personaje.getCoordenadaX());
                        personaje.setCoordenadaX(mapa_actual.getCoord()[n * 2]);
                        personaje.setCoordenadaY(mapa_actual.getCoord()[n * 2 + 1]);
                        mapa_actual = mapas.get((int)mapa_actual.getMapas(n));
                        mapa = new TiledMap(mapa_actual.getMapa(), "\\Construccion Mapas\\");
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
            for (int j = 0; j < NPCs.size(); j++) {
                if (colisionNPCs.get(j).intersects(personaje.getH4())) {
                    if (NPCs.get(j).isSGB()) {
                        int state = NPCs.get(j).getSGB();
                        NPCs.get(j).notSGB();
                        if (state == 10) {
                            
                            NPCs.remove(NPCs.get(j));
                            colisionNPCs.remove(colisionNPCs.get(j));
                            personaje.setCoordenadaX(461);
                            personaje.setCoordenadaY(125);
                            mapa_actual.chMod();
                            NPCs.add(escaleras2);
                            colisionNPCs.add(escaleras2.getHitbox());
                            mapa_actual = mapa2;
                            mapa = new TiledMap(mapa_actual.getMapa(), "\\Construccion Mapas\\");
                            
                        }
                        sbg.enterState(state);
                    }
                    choqueAbajo = true;
                    break;
                }
            }
            if (!choqueAbajo || choqueArriba) {
                personaje.setCoordenadaY(personaje.getCoordenadaY() + i * 0.14f * velocidad);
                for (int n = 0; n < colisiones_salidas.size(); n++) {
                    if (personaje.getH4().intersects(colisiones_salidas.get(n))) {
                        mapa_actual.setCoordX(n, (int) personaje.getCoordenadaX());
                        personaje.setCoordenadaX(mapa_actual.getCoord()[n * 2]);
                        personaje.setCoordenadaY(mapa_actual.getCoord()[n * 2 + 1]);
                        mapa_actual = mapas.get((int)mapa_actual.getMapas(n));
                        mapa = new TiledMap(mapa_actual.getMapa(), "\\Construccion Mapas\\");
                    }
                }
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
            for (int j = 0; j < NPCs.size(); j++) {
                if (colisionNPCs.get(j).intersects(personaje.getH2())) {
                    if (NPCs.get(j).isSGB()) {
                        int state = NPCs.get(j).getSGB();
                        NPCs.get(j).notSGB();
                        if (state == 17) {
                            
                            NPCs.remove(NPCs.get(j));
                            NPCs.remove(NPCs.get(j));
                            NPCs.remove(NPCs.get(j));
                            colisionNPCs.remove(colisionNPCs.get(j));
                            colisionNPCs.remove(colisionNPCs.get(j));
                            colisionNPCs.remove(colisionNPCs.get(j));
                            personaje.setCoordenadaX(300);
                            personaje.setCoordenadaY(690);
                            mapa_actual = mapa8;
                            mapa = new TiledMap(mapa_actual.getMapa(), "\\Construccion Mapas\\");
                            mapa8.getPersonajes().add(escaleras3);
                                    
                        }
                        sbg.enterState(state);
                    }
                    choqueIzquierda = true;
                    break;
                }
            }
            if (!choqueIzquierda || choqueDerecha) {
                personaje.setCoordenadaX(personaje.getCoordenadaX() - i * 0.16f * velocidad);
                for (int n = 0; n < colisiones_salidas.size(); n++) {
                    if (personaje.getH2().intersects(colisiones_salidas.get(n))) {
                        mapa_actual.setCoordY(n, (int) personaje.getCoordenadaY());
                        personaje.setCoordenadaX(mapa_actual.getCoord()[n * 2]);
                        personaje.setCoordenadaY(mapa_actual.getCoord()[n * 2 + 1]);
                        mapa_actual = mapas.get((int)mapa_actual.getMapas(n));
                        mapa = new TiledMap(mapa_actual.getMapa(), "\\Construccion Mapas\\");
                    }
                }
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
            for (int j = 0; j < NPCs.size(); j++) {
                if (colisionNPCs.get(j).intersects(personaje.getH3())) {
                    if (NPCs.get(j).isSGB()) {
                        int state = NPCs.get(j).getSGB();
                        NPCs.get(j).notSGB();
                        if(state==23)
                        {
                            NPCs.remove(0);
                            colisionNPCs.remove(0);
                            mapa8.getPersonajes().remove(0);
                            mapa8.getPersonajes().remove(0);
                        }
                        sbg.enterState(state);
                    }
                    choqueDerecha = true;
                    break;
                }
            }
            if (!choqueDerecha || choqueIzquierda) {
                personaje.setCoordenadaX(personaje.getCoordenadaX() + i * 0.16f * velocidad);
                for (int n = 0; n < colisiones_salidas.size(); n++) {
                    if (personaje.getH3().intersects(colisiones_salidas.get(n))) {
                        mapa_actual.setCoordY(n, (int) personaje.getCoordenadaY());
                        personaje.setCoordenadaX(mapa_actual.getCoord()[n * 2]);
                        personaje.setCoordenadaY(mapa_actual.getCoord()[n * 2 + 1]);
                        mapa_actual = mapas.get((int)mapa_actual.getMapas(n));
                        mapa = new TiledMap(mapa_actual.getMapa(), "\\Construccion Mapas\\");
                    }
                }
                choqueIzquierda = false;
            }
        } else {
            personaje.setDir("stance");
            personaje.getDir().update(i);
        }

        
        for (int j = 0; j < NPCs.size(); j++) {
            if (colisionNPCs.get(j).intersects(personaje.getH4())) {
                NPCs.get(j).setDir("sup");
                NPCs.get(j).alerta();
                if (input.isKeyDown(Input.KEY_E)) {
                    NPCs.get(j).talk();
                }
            } else if (colisionNPCs.get(j).intersects(personaje.getH3())) {
                NPCs.get(j).setDir("sleft");
                NPCs.get(j).alerta();
                if (input.isKeyDown(Input.KEY_E)) {
                    NPCs.get(j).talk();
                }
            } else if (colisionNPCs.get(j).intersects(personaje.getH2())) {
                NPCs.get(j).setDir("sright");
                NPCs.get(j).alerta();
                if (input.isKeyDown(Input.KEY_E)) {
                    NPCs.get(j).talk();
                }
            } else if (colisionNPCs.get(j).intersects(personaje.getH1())) {
                NPCs.get(j).setDir("sdown");
                NPCs.get(j).alerta();
                if (input.isKeyDown(Input.KEY_E)) {
                    NPCs.get(j).talk();
                }
            } else {
                NPCs.get(j).noAlerta();
                NPCs.get(j).noTalk();
                NPCs.get(j).move();
                NPCs.get(j).getDir().update(i);
            }
        }
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        Input input = gc.getInput();
        mapa.render(0, 0, 0);
        mapa.render(0, 0, 1);
        
        for (int j = 0; j < mapa_actual.getPersonajes().size(); j++) {
            PersonajeGeneral npc_actual = mapa_actual.getPersonajes().get(j);
            npc_actual.getDir().draw(npc_actual.getCoordenadaX(),npc_actual.getCoordenadaY());
            //g.draw(npc_actual.getHitbox());
        }
        
        personaje.getDir().draw((int) personaje.getCoordenadaX(), (int) personaje.getCoordenadaY());

        mapa.render(0, 0, 2);
        mapa.render(0, 0, 3);
        mapa.render(0, 0, 4);

        
        /*for (int i = 0; i < mapa_actual.getBordes().size(); i++) {
         g.draw(mapa_actual.getBordes().get(i));
         }*/
        
        for (int j = 0; j < mapa_actual.getPersonajes().size(); j++) {
            PersonajeGeneral npc_actual = mapa_actual.getPersonajes().get(j);
            npc_actual.getTalk().getImagen().draw(npc_actual.getTalk().getCoordenadaX(), npc_actual.getTalk().getCoordenadaY());
            npc_actual.getAlerta().getImagen().draw(npc_actual.getAlerta().getCoordenadaX(), npc_actual.getAlerta().getCoordenadaY());
        }
        if (input.isKeyDown(Input.KEY_T)) {
            g.drawImage(new Image("\\Elementos aparte\\mapa1.png"), 550, 200);
        }
    }

    @Override
    public int getID() {
        return 0; //To change body of generated methods, choose Tools | Templates.
    }
}
