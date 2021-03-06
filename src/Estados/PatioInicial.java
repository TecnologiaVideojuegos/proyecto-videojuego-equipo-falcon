/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estados;

import Elementos.Historia;
import Personajes.PersonajeAcosador;
import Personajes.PersonajeEstatico;
import Personajes.PersonajeEstaticoA;
import Personajes.PersonajePrincipal;
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
public class PatioInicial extends BasicGameState {

    @Override
    public int getID() {
        return 17; //To change body of generated methods, choose Tools | Templates.
    }

    private static TiledMap mapa;
    private boolean choqueArriba = false, choqueAbajo = false, choqueIzquierda = false, choqueDerecha = false;
    private PersonajePrincipal personaje;

    private float borde1[] = new float[]{32, 1, 1501, 1, 1501, 128, 1263, 128, 1263, 160, 1501, 160, 1501, 736, 1216, 736, 1216, 707, 1190, 707, 1190, 674, 1156, 674, 1156, 702, 1117, 702, 1117, 738, 549, 738, 549, 609, 669, 609, 669, 572, 788, 572, 788, 544, 552, 544, 552, 159, 1099, 159, 1099, 545, 874, 545, 874, 574, 960, 574, 960, 608, 1054, 608, 1054, 573, 1109, 573, 1109, 159, 1202, 159, 1202, 128, 544, 128, 544, 669, 434, 669, 434, 647, 399, 647, 399, 667, 307, 667, 307, 647, 266, 647, 266, 666, 173, 666, 173, 647, 132, 647, 132, 666, 32, 666};
    private float borde2[] = new float[]{615, 223, 615, 313, 730, 313, 730, 223};
    private float borde3[] = new float[]{773, 315, 888, 315, 888, 223, 773, 223};
    private float borde4[] = new float[]{935, 313, 1048, 313, 1048, 223, 935, 223};
    private float borde5[] = new float[]{672, 703, 764, 703, 764, 675, 672, 675};
    private float borde6[] = new float[]{1249, 578, 1341, 578, 1341, 547, 1249, 547};
    private float borde7[] = new float[]{480, 225, 415, 225, 415, 193, 480, 193};
    private float borde8[] = new float[]{480, 322, 415, 322, 415, 290, 480, 290};
    private float borde9[] = new float[]{480, 419, 415, 419, 415, 387, 480, 387};
    private float borde10[] = new float[]{480, 516, 415, 516, 415, 484, 480, 484};
    private float borde11[] = new float[]{160, 225, 95, 225, 95, 193, 160, 193};
    private float borde12[] = new float[]{160, 322, 95, 322, 95, 290, 160, 290};
    private float borde13[] = new float[]{160, 419, 0, 419, 0, 387, 160, 387};
    private float borde14[] = new float[]{160, 516, 95, 516, 95, 484, 160, 484};
    private float borde15[] = new float[]{373, 515, 373, 485, 363, 485, 363, 515};
    private float borde16[] = new float[]{217, 515, 217, 485, 205, 485, 205, 515};
    private ArrayList<Polygon> colisiones_bordes;

    private float salida1[] = new float[]{32, 2, 1501, 2, 1501, 1, 32, 1};
    private float salida2[] = new float[]{1501, 161, 1501, 736, 1500, 736, 1599, 161};
    private ArrayList<Polygon> colisiones_salidas;

    private ArrayList<PersonajeGeneral> NPCs = new ArrayList<>();
    private ArrayList<Rectangle> colisionNPCs;

    private PersonajeAcosador niño1 = new PersonajeAcosador("up", 20, 400, "N1", "Stalker");
    private PersonajeEstatico niño4 = new PersonajeEstatico("left", 850, 380, "N4", "Niño4");
    private PersonajeEstatico niño5 = new PersonajeEstatico("up", 810, 480, "N14", "Niño5");
    private PersonajeEstatico niño6 = new PersonajeEstatico("up", 770, 480, "N16", "Niño6");
    private PersonajeEstatico niño7 = new PersonajeEstatico("right", 730, 380, "N7", "Niño7");

    private PersonajeEstatico niño8 = new PersonajeEstatico("left", 1110, 140, "N15", "Niño8");
    private PersonajeEstatico niño9 = new PersonajeEstatico("left", 1110, 180, "N15", "Niño9");
    private PersonajeEstatico niño10 = new PersonajeEstatico("up", 1110, 220, "N17", "Niño10");

    private boolean historia = false;
    private int contadorTemporal1 = 0, contadorTemporal2 = 0;
    private Historia b0 = new Historia("Historia40");
    private Historia b1 = new Historia("Historia41");
    private Historia b2 = new Historia("Historia42");
    private Historia b3 = new Historia("Historia43");
    private Historia b4 = new Historia("Historia44");
    private Historia b5 = new Historia("Historia45");
    private Historia b6 = new Historia("Historia46");

    public PatioInicial() {
        colisiones_bordes = new ArrayList<>();
        colisiones_bordes.add(new Polygon(borde1));
        colisiones_bordes.add(new Polygon(borde2));
        colisiones_bordes.add(new Polygon(borde3));
        colisiones_bordes.add(new Polygon(borde4));
        colisiones_bordes.add(new Polygon(borde5));
        colisiones_bordes.add(new Polygon(borde6));
        colisiones_bordes.add(new Polygon(borde7));
        colisiones_bordes.add(new Polygon(borde8));
        colisiones_bordes.add(new Polygon(borde9));
        colisiones_bordes.add(new Polygon(borde10));
        colisiones_bordes.add(new Polygon(borde11));
        colisiones_bordes.add(new Polygon(borde12));
        colisiones_bordes.add(new Polygon(borde13));
        colisiones_bordes.add(new Polygon(borde14));
        colisiones_bordes.add(new Polygon(borde15));
        colisiones_bordes.add(new Polygon(borde16));

        colisiones_salidas = new ArrayList<>();
        colisiones_salidas.add(new Polygon(salida1));
        colisiones_salidas.add(new Polygon(salida2));

        NPCs.add(niño1);
        NPCs.add(niño4);
        NPCs.add(niño5);
        NPCs.add(niño6);
        NPCs.add(niño7);
        NPCs.add(niño8);
        NPCs.add(niño9);
        NPCs.add(niño10);

    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        mapa = new TiledMap("\\Mapas\\mapa10.tmx", "\\Construccion Mapas\\");
        personaje = new PersonajePrincipal();
        personaje.setCoordenadaX(1440);
        personaje.setCoordenadaY(470);
        personaje.setDir("left");

    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {

        if (historia) {
            contadorTemporal1++;
            personaje.getDir().update(i);
        } else {
            if (contadorTemporal1 == 0 && personaje.getCoordenadaY() < 100 && historia == false) {
                historia = true;
            } else if (contadorTemporal1 != 0 && personaje.getCoordenadaY() > 400 && personaje.getCoordenadaX() < 300) {
                contadorTemporal1++;
                historia = true;
            }
            int velocidad = 1;
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
                            //bocadilloSalida.dentro();
                        } else {
                            //bocadilloSalida.fuera();
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
                            sbg.enterState(state);

                        }
                        choqueAbajo = true;
                        break;
                    }
                }
                if (!choqueAbajo || choqueArriba) {
                    personaje.setCoordenadaY(personaje.getCoordenadaY() + i * 0.14f * velocidad);
                    //bocadilloSalida.fuera();
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
                            sbg.enterState(state);

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
                            sbg.enterState(state);

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
                    ;
                    if (input.isKeyDown(Input.KEY_E)) {
                        NPCs.get(j).talk();
                    }
                } else if (colisionNPCs.get(j).intersects(personaje.getH3())) {
                    NPCs.get(j).setDir("sleft");
                    NPCs.get(j).alerta();
                    ;
                    if (input.isKeyDown(Input.KEY_E)) {
                        NPCs.get(j).talk();
                    }
                } else if (colisionNPCs.get(j).intersects(personaje.getH2())) {
                    NPCs.get(j).setDir("sright");
                    NPCs.get(j).alerta();
                    ;
                    if (input.isKeyDown(Input.KEY_E)) {
                        NPCs.get(j).talk();
                    }
                } else if (colisionNPCs.get(j).intersects(personaje.getH1())) {
                    NPCs.get(j).setDir("sdown");
                    NPCs.get(j).alerta();
                    ;
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
            //g.draw(NPCs.get(j).getHitbox());
        }

        personaje.getDir().draw((int) personaje.getCoordenadaX(), (int) personaje.getCoordenadaY());

        mapa.render(0, 0, 2);
        mapa.render(0, 0, 3);
        mapa.render(0, 0, 4);

        /*for (int i = 0; i < colisiones_bordes.size(); i++) {
         g.draw(colisiones_bordes.get(i));
         }*/
        for (int j = 0; j < NPCs.size(); j++) {
            NPCs.get(j).getTalk().getImagen().draw(NPCs.get(j).getTalk().getCoordenadaX(), NPCs.get(j).getTalk().getCoordenadaY());
            NPCs.get(j).getAlerta().getImagen().draw(NPCs.get(j).getAlerta().getCoordenadaX(), NPCs.get(j).getAlerta().getCoordenadaY());
        }

        if (input.isKeyDown(Input.KEY_T)) {
            g.drawImage(new Image("\\Elementos aparte\\mapa3.png"), 550, 200);
        }

        //HISTORIA
        if (contadorTemporal1 > 0 && contadorTemporal1 < 2500) {
            b0.dentro();
            b0.getImagen().draw(b0.getCoordenadaX(), b0.getCoordenadaY());
            personaje.setDir("stance");
        } else if (contadorTemporal1 == 2500) {

            historia = false;
        } else if (contadorTemporal1 > 2500 && contadorTemporal1 < 3500) {
            personaje.setDir("left");
            personaje.setDir("stance");
            if (niño1.getCoordenadaX() + 32 < personaje.getCoordenadaX()) {
                niño1.setDir("right");

                niño1.setCoordenadas(niño1.getCoordenadaX() + (float) 0.5, niño1.getCoordenadaY());
            } else if (niño1.getCoordenadaY() < personaje.getCoordenadaY()) {
                niño1.setDir("down");
                niño1.setCoordenadas(niño1.getCoordenadaX(), niño1.getCoordenadaY() + (float) 0.5);

            } else {
                niño1.setDir("sright");
            }
            niño1.getDir().update(contadorTemporal1 % 7);
        } else if (contadorTemporal1 > 3500 && contadorTemporal1 < 5100) {
            b1.dentro();
            b1.getImagen().draw(b1.getCoordenadaX(), b1.getCoordenadaY());
        } else if (contadorTemporal1 > 5100 && contadorTemporal1 < 6700) {
            b2.dentro();
            b2.getImagen().draw(b2.getCoordenadaX(), b2.getCoordenadaY());
        } else if (contadorTemporal1 > 6700 && contadorTemporal1 < 8300) {
            b3.dentro();
            b3.getImagen().draw(b3.getCoordenadaX(), b3.getCoordenadaY());
        } else if (contadorTemporal1 > 8300 && contadorTemporal1 < 9900) {
            b4.dentro();
            b4.getImagen().draw(b4.getCoordenadaX(), b4.getCoordenadaY());
        } else if (contadorTemporal1 > 9900 && contadorTemporal1 < 11500) {
            b5.dentro();
            b5.getImagen().draw(b5.getCoordenadaX(), b5.getCoordenadaY());
        } else if (contadorTemporal1 > 11500 && contadorTemporal1 < 12900) {
            b6.dentro();
            b6.getImagen().draw(b6.getCoordenadaX(), b6.getCoordenadaY());
        } else if (contadorTemporal1 > 12900) {
            sbg.addState(new PatioFinal(personaje.getCoordenadaX(), personaje.getCoordenadaY()));
            sbg.getState(19).init(gc, sbg);
            sbg.enterState(18);
        }
    }

}
