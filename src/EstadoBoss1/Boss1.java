/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstadoBoss1;

import EstadoBoss1.Pelota;
import Personajes.MainChar;
import Personajes.ProfEd;
import static java.lang.Math.random;
import java.util.ArrayList;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

/**
 *
 * @author lucas
 */
public class Boss1 extends BasicGameState {

    private String mapa1 = "Mapas\\boss1.tmx";
    private float puntos1[] = new float[]{1120, 716, 127, 716, 127, 683, 223, 683, 223, 589, 127, 589, 127, 556, 830, 556, 830, 462, 127, 462, 127, 429, 575, 429, 575, 333, 127, 333, 127, 300, 255, 300, 255, 204, 127, 204, 127, 171, 1120, 171, 1120, 204, 300, 204, 300, 300, 864, 300, 864, 333, 618, 333, 618, 429, 1120, 429, 1120, 462, 875, 462, 875, 556, 1120, 556, 1120, 589, 267, 589, 267, 683, 1120, 683};
    private Polygon bordes;
    private int contador_parpadeo = 10;
    private boolean choqueArriba = false, choqueAbajo = false, choqueIzquierda = false, choqueDerecha = false;
    private TiledMap mapa;
    private MainChar personaje;
    private ProfEd boss1;
    private ArrayList<Pelota> pelotas = new ArrayList<>();
    private Pelota ball;
    private int contadorPelotas = 0;

    public Boss1() {
        bordes = new Polygon(puntos1);
    }

    @Override
    public int getID() {
        return 1;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        mapa      = new TiledMap(mapa1, "\\Construccion Mapas\\");
        personaje = new MainChar();
        boss1     = new ProfEd();
        pelotas   = new ArrayList<>();

        personaje.setCoordenadaX(703);
        personaje.setCoordenadaY(651);

        for (int i = 0; i < 10; i++) {
            ball = new Pelota();
            pelotas.add(ball);
        }

    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        mapa.render(0, 0, 0);
        mapa.render(0, 0, 1);

        personaje.getDir().draw((int) personaje.getCoordenadaX(), (int) personaje.getCoordenadaY());
        boss1.getDir().draw(954, 270);

        for (int i = 0; i < pelotas.size(); i++) {
            pelotas.get(i).getDir().draw(pelotas.get(i).getCoordenadaX(), pelotas.get(i).getCoordenadaY());
            g.draw(pelotas.get(i).getH1());
        }

        mapa.render(0, 0, 2);
        mapa.render(0, 0, 3);
        mapa.render(0, 0, 4);

        g.draw(personaje.getH1());
        g.draw(personaje.getH2());
        g.draw(personaje.getH3());
        g.draw(personaje.getH4());

        for (int i = 0; i < 20; i++) {
            g.draw(bordes);
        }

    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {

        Input input = gc.getInput();

        if (contador_parpadeo > 0) {
            if (contador_parpadeo % 2 == 0) {
                mapa = new TiledMap("Mapas\\mapa6.tmx", "\\Construccion Mapas\\");
            } else {
                mapa = new TiledMap("Mapas\\boss1.tmx", "\\Construccion Mapas\\");
            }
            contador_parpadeo--;

        } else {

            boss1.getDir().update(i);

            if (boss1.getDir().getFrame() == 5) {
                pelotas.get(contadorPelotas).init();
                pelotas.get(contadorPelotas).getDir().update(i);
            }

            for (int x = 0; x < pelotas.size(); x++) {

                if (pelotas.get(x).getDir().getFrame() == 2 && pelotas.get(x).getDir().getFrameCount() == 3 && boss1.getDir().getFrame() == 0) {
                    contadorPelotas++;
                    if (contadorPelotas >= pelotas.size()) {
                        contadorPelotas = 0;
                    }
                    pelotas.get(x).setDestinoN(personaje.getCoordenadaX(), personaje.getCoordenadaY());

                    pelotas.get(x).setDir("gira");
                    pelotas.get(x).restart();
                }
            }
            for (int x = 0; x < pelotas.size(); x++) {
                if (pelotas.get(x).getDir().getFrameCount() == 4) {
                    pelotas.get(x).move();
                    pelotas.get(x).getDir().update(i);
                }
            }

            for (int x = 0; x < pelotas.size(); x++) {
                if (pelotas.get(x).getH1().intersects(personaje.getH1()) || pelotas.get(x).getH1().intersects(personaje.getH2())
                        || pelotas.get(x).getH1().intersects(personaje.getH3()) || pelotas.get(x).getH1().intersects(personaje.getH4())) {

                    personaje.setCoordenadaX(1003);
                    personaje.setCoordenadaY(651);
                }
            }

            if (input.isKeyDown(Input.KEY_W)) {
                personaje.setDir("up");
                personaje.getDir().update(i);
                for (int n = 0; n < 20; n++) {
                    if (personaje.getH1().intersects(bordes)) {
                        choqueArriba = true;
                        break;
                    } else {
                        choqueArriba = false;
                    }
                }
                if (!choqueArriba || choqueAbajo) {
                    personaje.setCoordenadaY(personaje.getCoordenadaY() - i * 0.14f);
                    choqueAbajo = false;
                }

            } else if (input.isKeyDown(Input.KEY_S)) {
                personaje.setDir("up");
                personaje.getDir().update(i);
                for (int n = 0; n < 20; n++) {
                    if (personaje.getH4().intersects(bordes)) {
                        choqueAbajo = true;
                        break;
                    } else {
                        choqueAbajo = false;
                    }
                }
                if (!choqueAbajo || choqueArriba) {
                    personaje.setCoordenadaY(personaje.getCoordenadaY() + i * 0.14f);
                    choqueArriba = false;
                }

            } else if (input.isKeyDown(Input.KEY_A)) {
                personaje.setDir("left");
                personaje.getDir().update(i);
                for (int n = 0; n < 20; n++) {
                    if (personaje.getH2().intersects(bordes)) {
                        choqueIzquierda = true;
                        break;
                    } else {
                        choqueIzquierda = false;
                    }
                }
                if (!choqueIzquierda || choqueDerecha) {
                    personaje.setCoordenadaX(personaje.getCoordenadaX() - i * 0.16f);
                    choqueDerecha = false;
                }
            } else if (input.isKeyDown(Input.KEY_D)) {
                personaje.setDir("right");
                personaje.getDir().update(i);
                for (int n = 0; n < 20; n++) {
                    if (personaje.getH3().intersects(bordes)) {
                        choqueDerecha = true;
                        break;
                    } else {
                        choqueDerecha = false;
                    }
                }
                if (!choqueDerecha || choqueIzquierda) {
                    personaje.setCoordenadaX(personaje.getCoordenadaX() + i * 0.16f);
                    choqueIzquierda = false;
                }
            } else {
                personaje.setDir("stance");
                personaje.getDir().update(i);
            }
        }
    }
}
