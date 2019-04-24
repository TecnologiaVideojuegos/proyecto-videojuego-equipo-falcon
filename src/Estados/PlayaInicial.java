/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estados;

import Elementos.Bocadillo;
import EstadoBoss1.Pelota;
import Personajes.PersonajeEstatico;
import Personajes.PersonajePrincipal;
import Personajes.PersonajeProfesor;
import Personajes.PersonajeGeneral;
import java.util.ArrayList;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
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
public class PlayaInicial extends BasicGameState {

    @Override
    public int getID() {
        return 10; //To change body of generated methods, choose Tools | Templates.
    }
    
    private static TiledMap mapa;
    boolean choqueArriba = false, choqueAbajo = false, choqueIzquierda = false, choqueDerecha = false;
    PersonajePrincipal personaje;

    private float borde1[] = new float[]{63, 0, 256, 0, 256, 33, 985, 33, 985, 65, 1027, 65, 1027, 36, 1180, 36, 1180, 68, 1218, 68, 1218, 141, 1242, 164, 1242, 200, 1282, 200, 1282, 186, 1402, 186, 1433, 223, 1469, 223, 1469, 778, 1091, 778, 1091, 741, 1184, 738, 1184, 671, 1153, 671, 1153, 700, 1058, 700, 1058, 733, 1020, 733, 1020, 785, 35, 785, 35, 32, 65, 32};
    private ArrayList<Polygon> colisiones_bordes;

    private float salida1[] = new float[]{66, 2, 252, 2, 252, 0, 66, 0};
    private ArrayList<Polygon> colisiones_salidas;

    private ArrayList<PersonajeGeneral> NPCs = new ArrayList<>();
    private ArrayList<Rectangle> colisionNPCs;
    PersonajeEstatico niño1  = new PersonajeEstatico("up"   , 970, 680, "bocadilloNiño1");
    PersonajeEstatico niño2  = new PersonajeEstatico("up"   , 930, 680, "bocadilloNiño2");
    PersonajeEstatico niño3  = new PersonajeEstatico("up"   , 890, 680, "bocadilloNiño3");
    PersonajeEstatico niño4  = new PersonajeEstatico("left" , 850, 680, "bocadilloNiño4");
    PersonajeEstatico niño5  = new PersonajeEstatico("left" , 810, 680, "bocadilloNiño5");
    PersonajeEstatico niño6  = new PersonajeEstatico("up"   , 770, 680, "bocadilloNiño6");
    PersonajeEstatico niño7  = new PersonajeEstatico("right", 730, 680, "bocadilloNiño7");
    PersonajeEstatico niño8  = new PersonajeEstatico("left" , 690, 680, "bocadilloNiño8");
    PersonajeEstatico niño9  = new PersonajeEstatico("left" , 650, 680, "bocadilloNiño9");
    PersonajeEstatico niño10 = new PersonajeEstatico("up"   , 610, 680, "bocadilloNiño10");
    PersonajeEstatico niño11 = new PersonajeEstatico("right", 570, 680, "bocadilloNiño11");
    PersonajeEstatico niño12 = new PersonajeEstatico("left" , 530, 680, "bocadilloNiño12");
    PersonajeEstatico niño13 = new PersonajeEstatico("right", 490, 680, "bocadilloNiño13");
    PersonajeEstatico niño14 = new PersonajeEstatico("left" , 450, 680, "bocadilloNiño14");
    
    private PersonajeProfesor profesor;
    
    
    Pelota ball = new Pelota();

    boolean historia = false;
    int contadorTemporal1 = 0, contadorTemporal2 = 0;
    Bocadillo introduccionHistoria = new Bocadillo("Historia10");
    Bocadillo bocadilloProf1 = new Bocadillo("Historia11");
    Bocadillo bocadilloAlex1 = new Bocadillo("Historia12");
    Bocadillo bocadilloProf2 = new Bocadillo("Historia13");
    Bocadillo bocadilloSalida = new Bocadillo("Historia15");

    public PlayaInicial() {
        colisiones_bordes = new ArrayList<>();
        colisiones_bordes.add(new Polygon(borde1));

        colisiones_salidas = new ArrayList<>();
        colisiones_salidas.add(new Polygon(salida1));

        profesor = new PersonajeProfesor();
        profesor.noLanza();
        profesor.setSGB();
        NPCs.add(profesor);
        
        NPCs.add(niño1);
        NPCs.add(niño2);
        NPCs.add(niño3);
        NPCs.add(niño4);
        NPCs.add(niño5);
        NPCs.add(niño6);
        NPCs.add(niño7);
        NPCs.add(niño8);
        NPCs.add(niño9);
        NPCs.add(niño10);
        NPCs.add(niño11);
        NPCs.add(niño12);
        NPCs.add(niño13);
        NPCs.add(niño14);

    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        mapa = new TiledMap("\\Mapas\\mapa6.tmx", "\\Construccion Mapas\\");
        personaje = new PersonajePrincipal();
        personaje.setCoordenadaX(110);
        personaje.setCoordenadaY(30);

    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        if (historia) {
            contadorTemporal2++;
            personaje.getDir().update(i);
        } else {
            
            if(contadorTemporal1<1500)
                contadorTemporal1++;
            
            int velocidad = 2;
            Input input = gc.getInput();
            
            colisionNPCs = new ArrayList<>();
            for (int j = 0; j < NPCs.size(); j++) {
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
                            if (state == 20) {
                                historia = true;
                            } else {
                                sbg.enterState(state);
                            }
                        }
                        choqueArriba = true;
                        break;
                    }
                }
                if (!choqueArriba || choqueAbajo) {
                    personaje.setCoordenadaY(personaje.getCoordenadaY() - i * 0.14f * velocidad);
                    for (int n = 0; n < colisiones_salidas.size(); n++) {
                        if (personaje.getH1().intersects(colisiones_salidas.get(n))) {
                            bocadilloSalida.dentro();
                        } else {
                            bocadilloSalida.fuera();
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
                            if (state == 20) {
                                historia = true;
                            } else {
                                sbg.enterState(state);
                            }
                        }
                        choqueAbajo = true;
                        break;
                    }
                }
                if (!choqueAbajo || choqueArriba) {
                    personaje.setCoordenadaY(personaje.getCoordenadaY() + i * 0.14f * velocidad);
                    bocadilloSalida.fuera();
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
                            if (state == 20) {
                                historia = true;
                            } else {
                                sbg.enterState(state);
                            }
                        }
                        choqueIzquierda = true;
                        break;
                    }
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
                for (int j = 0; j < NPCs.size(); j++) {
                    if (colisionNPCs.get(j).intersects(personaje.getH3())) {
                        if (NPCs.get(j).isSGB()) {
                            int state = NPCs.get(j).getSGB();
                            NPCs.get(j).notSGB();
                            if (state == 20) {
                                historia = true;
                            } else {
                                sbg.enterState(state);
                            }
                        }
                        choqueDerecha = true;
                        break;
                    }
                }
                if (!choqueDerecha || choqueIzquierda) {
                    personaje.setCoordenadaX(personaje.getCoordenadaX() + i * 0.16f * velocidad);
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
                    personaje.setDir("stance");
                    if (input.isKeyDown(Input.KEY_E)) {
                        NPCs.get(j).talk();
                    }
                } else if (colisionNPCs.get(j).intersects(personaje.getH3())) {
                    NPCs.get(j).setDir("sleft");
                    NPCs.get(j).alerta();
                    personaje.setDir("stance");
                    if (input.isKeyDown(Input.KEY_E)) {
                        NPCs.get(j).talk();
                    }
                } else if (colisionNPCs.get(j).intersects(personaje.getH2())) {
                    NPCs.get(j).setDir("sright");
                    NPCs.get(j).alerta();
                    personaje.setDir("stance");
                    if (input.isKeyDown(Input.KEY_E)) {
                        NPCs.get(j).talk();
                    }
                } else if (colisionNPCs.get(j).intersects(personaje.getH1())) {
                    NPCs.get(j).setDir("sdown");
                    NPCs.get(j).alerta();
                    personaje.setDir("stance");
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
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        Input input = gc.getInput();
        
        mapa.render(0, 0, 0);
        mapa.render(0, 0, 1);
        
        for (int j = 0; j < NPCs.size(); j++) {
            NPCs.get(j).getDir().draw(NPCs.get(j).getCoordenadaX(), NPCs.get(j).getCoordenadaY());
            g.draw(NPCs.get(j).getHitbox());
        }
        
        personaje.getDir().draw((int) personaje.getCoordenadaX(), (int) personaje.getCoordenadaY());

        mapa.render(0, 0, 2);
        mapa.render(0, 0, 3);
        mapa.render(0, 0, 4);

        for (int i = 0; i < colisiones_bordes.size(); i++) {
            g.draw(colisiones_bordes.get(i));
        }

        for (int j = 0; j < NPCs.size(); j++) {
            NPCs.get(j).getTalk().getImagen().draw(NPCs.get(j).getTalk().getCoordenadaX(), NPCs.get(j).getTalk().getCoordenadaY());
            NPCs.get(j).getAlerta().getImagen().draw(NPCs.get(j).getAlerta().getCoordenadaX(), NPCs.get(j).getAlerta().getCoordenadaY());
        }
        
        if (input.isKeyDown(Input.KEY_T)) {
            g.drawImage(new Image("\\Elementos aparte\\mapa1.png"), 550, 200);
        }
        
        //HISTORIA
        if (contadorTemporal1 > 100 && contadorTemporal1 < 1500) {
            introduccionHistoria.dentro();
            introduccionHistoria.getImagen().draw(introduccionHistoria.getCoordenadaX(), introduccionHistoria.getCoordenadaY());
        }

        bocadilloSalida.getImagen().draw(bocadilloSalida.getCoordenadaX(), bocadilloSalida.getCoordenadaY());

        if (contadorTemporal2 > 0) {
        
        if (contadorTemporal2 < 1600) {
            bocadilloProf1.dentro();
            bocadilloProf1.getImagen().draw(bocadilloProf1.getCoordenadaX(), bocadilloProf1.getCoordenadaY());
        } else if (contadorTemporal2 < 3200) {
            bocadilloAlex1.dentro();
            bocadilloAlex1.getImagen().draw(bocadilloAlex1.getCoordenadaX(), bocadilloAlex1.getCoordenadaY());
        } else if (contadorTemporal2 < 4400) {
            personaje.setDir("down");
            if (personaje.getCoordenadaY() < 120) {
                personaje.setCoordenadaY(personaje.getCoordenadaY() + 1);
            } else if (personaje.getCoordenadaX() < 1015) {
                personaje.setDir("right");
                personaje.setCoordenadaX(personaje.getCoordenadaX() + 1);
            } else if (personaje.getCoordenadaY() < 673) {
                personaje.setCoordenadaY(personaje.getCoordenadaY() + 1);
            } else {
                personaje.setDir("up");
                personaje.setDir("stance");
            }
        } else if (contadorTemporal2 < 7000) {
            bocadilloProf2.dentro();
            bocadilloProf2.getImagen().draw(bocadilloProf2.getCoordenadaX(), bocadilloProf2.getCoordenadaY());

        } else if (contadorTemporal2 < 7500) {
            if (profesor.getDir().getFrameCount() == 2) {
                profesor.lanza();
            } else {
                if (profesor.getDir().getFrame() != 5) {
                    profesor.getDir().update(contadorTemporal2 / 500);
                } else {
                    ball.setCoordenadas(950, 30);
                    ball.setDestinoN(personaje.getCoordenadaX(), personaje.getCoordenadaY());
                    ball.getDir().draw(ball.getCoordenadaX(), ball.getCoordenadaY());
                }
            }
        } else if (contadorTemporal2 < 7820) {
            profesor.noLanza();
            if (ball.getCoordenadaY() != personaje.getCoordenadaY()) {
                ball.move();
                ball.getDir().draw(ball.getCoordenadaX(), ball.getCoordenadaY());
            } 
        } else{
            sbg.enterState(11); // --> CINEMATICA1
        } 
        
        
        }
    }


}
