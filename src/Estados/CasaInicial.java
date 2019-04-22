/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estados;

import Mapas.Mapa2;
import Personajes.Madre;
import Personajes.MainChar;
import Personajes.WanderTipoT;
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
public class CasaInicial extends BasicGameState {

    private static TiledMap mapa;
    boolean choqueArriba = false, choqueAbajo = false, choqueIzquierda = false, choqueDerecha = false;
    MainChar personaje;
    
    private final float   borde1 []  = new float[]{830,701,712,701,712,674,665,674,665,647,618,647,618,625,607,625,607,701,392,701,392,675,547,675,547,571,394,571,394,483,540,483,540,486,606,486,606,547,620,547,618,472,639,472,639,451,697,451,697,415,392,415,392,322,471,322,471,286,392,286,392,196,449,196,449,110,606,110,606,216,517,216,517,265,522,265,522,322,616,322,616,290,695,290,695,255,616,255,616,121,766,121,766,125,831,125,831,254,744,254,744,290,840,290,840,82,895,82,895,290,959,290,959,320,967,320,967,255,930,255,930,100,1021,100,1021,160,1088,160,1088,100,1119,100,1119,200,1088,200,1088,415,968,415,968,367,958,367,958,415,744,415,744,451,763,451,763,548,797,548,797,595,929,595,929,548,961,548,961,460,1118,460,1118,701,895,701,895,737,830,737};
    private final float   borde2 []  = new float[]{1008,609,1008,536,1075,536,1075,609};
    private final ArrayList<Polygon> colisiones_bordes;
    
    private final float   salida1[] = new float[]{842,94,892,94,892,92,842,92};
    private ArrayList<Polygon> colisiones_salidas;
    private ArrayList<Polygon> colisiones_salidas2;
    private ArrayList<WanderTipoT> NPCs = new ArrayList<>(); 
    private Madre madre;
    
    
    public CasaInicial() {
        colisiones_bordes=new ArrayList<>();
        colisiones_bordes.add(new Polygon(borde1));
        colisiones_bordes.add(new Polygon(borde2));
        
        colisiones_salidas=new ArrayList<>();
        colisiones_salidas2=new ArrayList<>();
        colisiones_salidas2.add(new Polygon(salida1));
        
        madre = new Madre(400,450);
        
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        mapa = new TiledMap("\\Mapas\\mapa2.tmx", "\\Construccion Mapas\\");
        personaje = new MainChar();
        personaje.setCoordenadaX(461);
        personaje.setCoordenadaY(125);
        madre.setTalk();
        NPCs.add(madre);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
      
        
        
        int velocidad = 2;
        Input input = gc.getInput();
        ArrayList<Rectangle> colisionNPCs = new ArrayList<>();    
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
                    choqueArriba = true;
                    break;
                }
            }
            if (!choqueArriba  || choqueAbajo ) {
                personaje.setCoordenadaY(personaje.getCoordenadaY() - i * 0.14f * velocidad);
                for (int n = 0; n < colisiones_salidas.size(); n++) {
                    if (personaje.getH1().intersects(colisiones_salidas.get(n))) {
                        sbg.enterState(9);
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
                    choqueAbajo = true;
                    break;
                }
            }
            if (!choqueAbajo  || choqueArriba ) {
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
                    choqueIzquierda = true;
                    break;
                }
            }
            if (!choqueIzquierda  || choqueDerecha ) {
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
                    choqueDerecha = true;
                    break;
                }
            }
            if (!choqueDerecha   || choqueIzquierda ) {
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
                    colisiones_salidas=colisiones_salidas2;
                    NPCs.get(j).talk();
                }
            } else if (colisionNPCs.get(j).intersects(personaje.getH3())) {
                NPCs.get(j).setDir("sleft");
                NPCs.get(j).alerta();
                personaje.setDir("stance");
                if (input.isKeyDown(Input.KEY_E)) {
                    colisiones_salidas=colisiones_salidas2;
                    NPCs.get(j).talk();
                }
            } else if (colisionNPCs.get(j).intersects(personaje.getH2())) {
                NPCs.get(j).setDir("sright");
                NPCs.get(j).alerta();
                personaje.setDir("stance");
                if (input.isKeyDown(Input.KEY_E)) {
                    colisiones_salidas=colisiones_salidas2;
                    NPCs.get(j).talk();
                }
            } else if (colisionNPCs.get(j).intersects(personaje.getH1())) {
                NPCs.get(j).setDir("sdown");
                NPCs.get(j).alerta();
                personaje.setDir("stance");
                if (input.isKeyDown(Input.KEY_E)) {
                    colisiones_salidas=colisiones_salidas2;
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
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        Input input = gc.getInput();
        Graphics g = new Graphics();
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

        /*g.draw(personaje.getH1());
        g.draw(personaje.getH2());
        g.draw(personaje.getH3());
        g.draw(personaje.getH4());

        for (int i = 0; i < mapa_actual.getBordes().size(); i++) {
            g.draw(mapa_actual.getBordes().get(i));
        }*/
        for (int j = 0; j < NPCs.size(); j++) {
            
            NPCs.get(j).getTalk().getImagen().draw(NPCs.get(j).getTalk().getCoordenadaX(), NPCs.get(j).getTalk().getCoordenadaY());
            NPCs.get(j).getAlerta().getImagen().draw(NPCs.get(j).getAlerta().getCoordenadaX(),NPCs.get(j).getAlerta().getCoordenadaY());

        }
        if(input.isKeyDown(Input.KEY_T))
        {
            g.drawImage(new Image("\\Elementos aparte\\mapa1.png"), 550, 200);
        }
    }

    @Override
    public int getID() {
        return 8; //To change body of generated methods, choose Tools | Templates.
    }
}
