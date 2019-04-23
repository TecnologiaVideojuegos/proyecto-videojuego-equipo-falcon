/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estados;

import Elementos.Bocadillo;
import EstadoBoss1.Pelota;
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
public class PlayaFinal extends BasicGameState {

    private static TiledMap mapa;
    boolean choqueArriba = false, choqueAbajo = false, choqueIzquierda = false, choqueDerecha = false;
    PersonajePrincipal personaje;

    private float borde1[] = new float[]{63, 0, 256, 0, 256, 33, 985, 33, 985, 65, 1027, 65, 1027, 36, 1180, 36, 1180, 68, 1218, 68, 1218, 141, 1242, 164, 1242, 200, 1282, 200, 1282, 186, 1402, 186, 1433, 223, 1469, 223, 1469, 778, 1091, 778, 1091, 741, 1184, 738, 1184, 671, 1153, 671, 1153, 700, 1058, 700, 1058, 733, 1020, 733, 1020, 785, 35, 785, 35, 32, 65, 32};
    private ArrayList<Polygon> colisiones_bordes;

    private float salida1[] = new float[]{66, 2, 252, 2, 252, 0, 66, 0};
    private ArrayList<Polygon> colisiones_salidas;

    private ArrayList<PersonajeGeneral> NPCs = new ArrayList<>();
    ArrayList<Rectangle> colisionNPCs = new ArrayList<>();
    private PersonajeProfesor profesor;
    Pelota ball = new Pelota();

    int fase = 0, fase2 = 0;
    Bocadillo bocadillo10 = new Bocadillo("Historia30");
    Bocadillo bocadillo11 = new Bocadillo("Historia31");
    Bocadillo bocadillo12 = new Bocadillo("Historia32");
    Bocadillo bocadillo13 = new Bocadillo("Historia33");
    Bocadillo bocadillo14 = new Bocadillo("Historia34");

    public PlayaFinal() {
        colisiones_bordes = new ArrayList<>();
        colisiones_bordes.add(new Polygon(borde1));

        colisiones_salidas = new ArrayList<>();
        colisiones_salidas.add(new Polygon(salida1));

        profesor = new PersonajeProfesor();
        profesor.noLanza();
        profesor.setCoord(1005, 595);
        
        NPCs.add(profesor);
        
            for (int j = 0; j < NPCs.size(); j++) {
                colisionNPCs.add(NPCs.get(j).getHitbox());
            }
        

    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        mapa = new TiledMap("\\Mapas\\mapa6.tmx", "\\Construccion Mapas\\");
        personaje = new PersonajePrincipal();
        personaje.setCoordenadaX(1007);
        personaje.setCoordenadaY(665);
        personaje.getUp();
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        if (fase2<5700+1500) {
            fase2++;
        } else {

            fase++;
            int velocidad = 2;
            Input input = gc.getInput();
            if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                System.out.println(input.getMouseX() + "," + input.getMouseY() + ",");
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
                            if (state == 20) {
                                
                                NPCs.get(j).notSGB();
                            } else {
                                NPCs.get(j).notSGB();
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
                            sbg.enterState(0);
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
                            if (state == 20) {
                                
                                NPCs.get(j).notSGB();
                            } else {
                                NPCs.get(j).notSGB();
                                sbg.enterState(state);
                            }
                        }
                        choqueAbajo = true;
                        break;
                    }
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
                for (int j = 0; j < NPCs.size(); j++) {
                    if (colisionNPCs.get(j).intersects(personaje.getH2())) {
                        if (NPCs.get(j).isSGB()) {
                            int state = NPCs.get(j).getSGB();
                            if (state == 20) {
                                
                                NPCs.get(j).notSGB();
                            } else {
                                NPCs.get(j).notSGB();
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
                            if (state == 20) {
                                
                                NPCs.get(j).notSGB();
                            } else {
                                NPCs.get(j).notSGB();
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
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        Input input = gc.getInput();
        Graphics g = new Graphics();
        mapa.render(0, 0, 0);
        mapa.render(0, 0, 1);
        
        profesor.getDir().draw(1000,600);
        personaje.getDir().draw((int) personaje.getCoordenadaX(), (int) personaje.getCoordenadaY());

        mapa.render(0, 0, 2);
        mapa.render(0, 0, 3);
        mapa.render(0, 0, 4);

        /*g.draw(personaje.getH1());
         g.draw(personaje.getH2());
         g.draw(personaje.getH3());
         g.draw(personaje.getH4());
         */
        for (int i = 0; i < colisiones_bordes.size(); i++) {
            g.draw(colisiones_bordes.get(i));
        }
        System.out.println(profesor.getHitbox().toString());
        for (int j = 0; j < NPCs.size(); j++) {

            NPCs.get(j).getTalk().getImagen().draw(NPCs.get(j).getTalk().getCoordenadaX(), NPCs.get(j).getTalk().getCoordenadaY());
            NPCs.get(j).getAlerta().getImagen().draw(NPCs.get(j).getAlerta().getCoordenadaX(), NPCs.get(j).getAlerta().getCoordenadaY());

        }
        if (input.isKeyDown(Input.KEY_T)) {
            g.drawImage(new Image("\\Elementos aparte\\mapa1.png"), 550, 200);
        }

        else if (fase2 > 50 && fase2 < 1550) {
            bocadillo10.dentro();
            bocadillo10.getImagen().draw(bocadillo10.getCoordenadaX(), bocadillo10.getCoordenadaY());
        } 
        else if (fase2 > 50+1500 && fase2 < 1800+1500) {
            bocadillo11.dentro();
            bocadillo11.getImagen().draw(bocadillo11.getCoordenadaX(), bocadillo11.getCoordenadaY());
        } else if (fase2 > 1800+1500 && fase2 < 2100+1500) {
            if(personaje.getDir().getFrameCount()!=2)
            {
                personaje.getDir().update(fase2/500);
                if(personaje.getDir().getFrame()==2)
                {
                    personaje.setDir("up");
                    personaje.setDir("stance");
                }
            }
        } else if (fase2 > 2100+1500 && fase2 < 3300+1500) {
            
            bocadillo12.dentro();
            bocadillo12.getImagen().draw(bocadillo12.getCoordenadaX(), bocadillo12.getCoordenadaY());
        } else if (fase2 > 3300+1500 && fase2 < 4500+1500) {
            bocadillo13.dentro();
            bocadillo13.getImagen().draw(bocadillo13.getCoordenadaX(), bocadillo13.getCoordenadaY());

        } else if (fase2 > 4500+1500 && fase2 < 5700+1500) {
            bocadillo14.dentro();
            bocadillo14.getImagen().draw(bocadillo14.getCoordenadaX(), bocadillo14.getCoordenadaY());

        }
        
    }

    @Override
    public int getID() {
        return 12; //To change body of generated methods, choose Tools | Templates.
    }
}
