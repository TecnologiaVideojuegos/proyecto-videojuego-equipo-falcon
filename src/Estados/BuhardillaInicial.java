/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estados;

import Elementos.Bocadillo;
import Personajes.PersonajeAtari;
import Personajes.PersonajePrincipal;
import java.util.ArrayList;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.*;

/**
 *
 * @author lucas
 */
public class BuhardillaInicial extends BasicGameState {

    @Override
    public int getID() {
        return 9; //To change body of generated methods, choose Tools | Templates.
    }
    
    private static TiledMap mapa;
    
    boolean choqueArriba = false, choqueAbajo = false, choqueIzquierda = false, choqueDerecha = false;
    
    PersonajePrincipal personaje;
    
    private float borde1[] = new float[]{705, 192, 838, 192, 838, 220, 865, 220, 865, 255, 935, 255, 935, 277, 963, 277, 963, 321, 991, 321, 991, 377, 961, 377, 961, 446, 931, 446, 931, 471, 957, 471, 957, 480, 989, 480, 989, 512, 902, 512, 902, 564, 867, 564, 867, 572, 512, 572, 512, 289, 540, 289, 540, 250, 700, 250, 700, 388, 737, 388, 737, 413, 767, 413, 767, 388, 799, 388, 799, 366, 771, 366, 771, 257, 768, 257, 768, 381, 705, 381};
    private float borde2[] = new float[]{862, 482, 898, 482, 898, 449, 862, 449};
    private float borde3[] = new float[]{605, 322, 578, 322, 578, 290, 605, 290};
    private float borde4[] = new float[]{870, 353, 891, 353, 891, 320, 870, 320};
    private float borde5[] = new float[]{740, 544, 802, 544, 802, 510, 740, 510};
    private ArrayList<Polygon> colisiones_bordes;

    private float salida1[] = new float[]{707, 355, 763, 355, 763, 354, 707, 354};
    private ArrayList<Polygon> colisiones_salidas;

    private PersonajeAtari atari;

    int contadorTemporal=0;
    
    Bocadillo bocadillo = new Bocadillo("Historia00");
    
    public BuhardillaInicial() {
        
        colisiones_bordes = new ArrayList<>();
        colisiones_bordes.add(new Polygon(borde1));
        colisiones_bordes.add(new Polygon(borde2));
        colisiones_bordes.add(new Polygon(borde3));
        colisiones_bordes.add(new Polygon(borde4));
        colisiones_bordes.add(new Polygon(borde5));
        
        colisiones_salidas = new ArrayList<>();
        colisiones_salidas.add(new Polygon(salida1));
        
        atari = new PersonajeAtari(608,384);

    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        mapa = new TiledMap("\\Mapas\\mapa3.tmx", "\\Construccion Mapas\\");
        personaje = new PersonajePrincipal();
        personaje.setCoordenadaX(710);
        personaje.setCoordenadaY(192);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        int velocidad = 2;
        Input input = gc.getInput();
        
        if(contadorTemporal<1800)
            contadorTemporal++;
        
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
            if (atari.getHitbox().intersects(personaje.getH1())) {
                sbg.enterState(atari.getSGB());
            }
            if (!choqueArriba || choqueAbajo) {
                personaje.setCoordenadaY(personaje.getCoordenadaY() - i * 0.14f * velocidad);
                for (int n = 0; n < colisiones_salidas.size(); n++) {
                    if (personaje.getH1().intersects(colisiones_salidas.get(n))) {
                        sbg.enterState(7);
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
            if (atari.getHitbox().intersects(personaje.getH4())) {
                sbg.enterState(atari.getSGB());
            }
            if (!choqueAbajo || choqueArriba) {
                personaje.setCoordenadaY(personaje.getCoordenadaY() + i * 0.14f * velocidad);
                for (int n = 0; n < colisiones_salidas.size(); n++) {
                    if (personaje.getH4().intersects(colisiones_salidas.get(n))) {
                        sbg.enterState(8); // --> CASAINICIAL
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
            if (atari.getHitbox().intersects(personaje.getH2())) {
                sbg.enterState(atari.getSGB());
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
            if (atari.getHitbox().intersects(personaje.getH3())) {
                sbg.enterState(atari.getSGB());
            }
            if (!choqueDerecha || choqueIzquierda) {
                personaje.setCoordenadaX(personaje.getCoordenadaX() + i * 0.16f * velocidad);
                choqueIzquierda = false;
            }
        } else {
            personaje.setDir("stance");
            personaje.getDir().update(i);
        }


        if (atari.getHitbox().intersects(personaje.getH4())) {
            atari.setDir("sup");
            atari.alerta();
            personaje.setDir("stance");
            if (input.isKeyDown(Input.KEY_E)) {
                atari.talk();
            }
        } else if (atari.getHitbox().intersects(personaje.getH3())) {
            atari.setDir("sleft");
            atari.alerta();
            personaje.setDir("stance");
            if (input.isKeyDown(Input.KEY_E)) {
                atari.talk();
            }
        } else if (atari.getHitbox().intersects(personaje.getH2())) {
            atari.setDir("sright");
            atari.alerta();
            personaje.setDir("stance");
            if (input.isKeyDown(Input.KEY_E)) {
                atari.talk();
            }
        } else if (atari.getHitbox().intersects(personaje.getH1())) {
            atari.setDir("sdown");
            atari.alerta();
            personaje.setDir("stance");
            if (input.isKeyDown(Input.KEY_E)) {
                atari.talk();
            }
        } else {
            atari.noAlerta();
            atari.noTalk();
            atari.move();
            atari.getDir().update(i);
        }
      
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        Input input = gc.getInput();
        
        mapa.render(0, 0, 0);
        mapa.render(0, 0, 1);
        
        atari.getDir().draw(atari.getCoordenadaX(), atari.getCoordenadaY());
        g.draw(atari.getHitbox());
        
        personaje.getDir().draw((int) personaje.getCoordenadaX(), (int) personaje.getCoordenadaY());

        mapa.render(0, 0, 2);
        mapa.render(0, 0, 3);
        mapa.render(0, 0, 4);

        /*
         for (int i = 0; i < colisiones_bordes.size(); i++) {
         g.draw(colisiones_bordes.get(i));
         }*/
         
        atari.getTalk().getImagen().draw(atari.getTalk().getCoordenadaX(), atari.getTalk().getCoordenadaY());
        atari.getAlerta().getImagen().draw(atari.getAlerta().getCoordenadaX(), atari.getAlerta().getCoordenadaY());

        if (input.isKeyDown(Input.KEY_T)) {
            g.drawImage(new Image("\\Elementos aparte\\mapa1.png"), 550, 200);
        }
        
        if(contadorTemporal>200 && contadorTemporal<1500)
        {
            bocadillo.dentro();
            bocadillo.getImagen().draw(bocadillo.getCoordenadaX(), bocadillo.getCoordenadaY());
        }
    }
}
