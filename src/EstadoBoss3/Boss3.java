/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstadoBoss3;

import EstadoBoss1.Boss1;
import static java.lang.Math.pow;
import static java.lang.Math.random;
import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.tiled.TiledMap;

/**
 *
 * @author lucas
 */
public class Boss3 extends BasicGameState {

    private String mapa1 = "Mapas\\boss2.tmx";
    private float puntos1[] = new float[]{425, 2, 1080, 2, 1080, 730, 425, 730};
    private Polygon bordes;
    int mapaMov = 0;
    int a = 0, b = 0, c = 0, d = 0;
    Music musica;
    TiledMap mapa;
    Defensa personaje;
    ArrayList<BbyMaton> red, blue, yellow, orange, all;
    Ball ball;
    int toque = 1, num = 0;
    Image[] mundoImg;
    int puntos = 0;
    boolean game = true;

    public Boss3() {
        bordes = new Polygon(puntos1);

    }

    @Override
    public int getID() {
        return 20;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        
        musica = new Music("\\Elementos Aparte\\MusicaDefinitiva\\Boss1.wav");
        ball = new Ball();
        ball.setCoordenadaX(750);
        ball.setCoordenadaY(200);
        toque = 1;
        mapa = new TiledMap(mapa1, "\\Construccion Mapas\\");
        personaje = new Defensa();
        personaje.setCoordenadaX(750);
        personaje.setCoordenadaY(635);
        red = new ArrayList<>();
        yellow = new ArrayList<>();
        blue = new ArrayList<>();
        orange = new ArrayList<>();
        all = new ArrayList<>();
        for (int i = 0; i < 60; i++) {
            BbyMaton rojo = new BbyMaton(0);
            red.add(rojo);
        }
        for (int i = 0; i < 60; i++) {
            BbyMaton azul = new BbyMaton(1);
            blue.add(azul);
        }
        for (int i = 0; i < 60; i++) {
            BbyMaton naranja = new BbyMaton(2);
            orange.add(naranja);
        }
        for (int i = 0; i < 60; i++) {
            BbyMaton amarillo = new BbyMaton(3);
            yellow.add(amarillo);
        }

    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        Graphics g = new Graphics();
        mapa.render(0, 0, 0);
        mapa.render(0, 0, 1);
        ball.getDir().draw(ball.getCoordenadaX(), ball.getCoordenadaY());
        g.draw(personaje.getH1());
        g.draw(personaje.getH2());
        g.draw(personaje.getH3());
        g.draw(personaje.getH4());
        g.draw(personaje.getH5());

        g.draw(ball.getH1());
        g.draw(ball.getH2());
        g.draw(ball.getH3());
        g.draw(ball.getH4());

        personaje.getDir().draw((int) personaje.getCoordenadaX(), (int) personaje.getCoordenadaY());
        for (int i = 0; i < all.size(); i++) {
            System.out.println(all.get(i).getH1().getLocation());

            all.get(i).getDir().draw(all.get(i).getCoordenadaX(), all.get(i).getCoordenadaY());
            g.draw(all.get(i).getH1());
        }
        g.draw(bordes);

    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        if (!musica.playing()) {
            musica.setPosition(15);
            musica.play();
        }
        musica.setVolume((float) 0.1);
        if (game) {
            Input input = gc.getInput();
            if ((toque % 7 == 0 && ball.getCoordenadaY() > 600 && ball.getCoordenadaY() < 700) || toque == 1) {
                toque++;
                for (int s = 0; s < all.size(); s++) {
                    all.get(s).move();
                    if (all.get(s).getCoordenadaY() > 600) {
                        try {
                            sbg.enterState(21, FadeOutTransition.class.newInstance(), FadeInTransition.class.newInstance());
                        } catch (InstantiationException ex) {
                            Logger.getLogger(Boss1.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IllegalAccessException ex) {
                            Logger.getLogger(Boss1.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                num++;
                num = num % 4;
                System.out.println(num);
                if (num == 0) {
                    int crdx = 433;
                    for (int j = 0; j < 5; j++) {
                        System.out.println("red");
                        BbyMaton x = red.get(0);
                        all.add(x);
                        x.setCoordenadas(crdx, 0);
                        crdx = crdx + 128;
                        red.remove(x);
                    }
                } else if (num == 1) {
                    int crdx = 433;
                    for (int j = 0; j < 5; j++) {
                        System.out.println("blue");
                        BbyMaton x = blue.get(0);
                        all.add(x);
                        x.setCoordenadas(crdx, 0);
                        crdx = crdx + 128;
                        blue.remove(x);
                    }
                } else if (num == 2) {
                    int crdx = 433;
                    for (int j = 0; j < 5; j++) {
                        System.out.println("orange");
                        BbyMaton x = orange.get(0);
                        all.add(x);
                        x.setCoordenadas(crdx, 0);
                        crdx = crdx + 128;
                        orange.remove(x);
                    }
                } else if (num == 3) {
                    int crdx = 433;
                    for (int j = 0; j < 5; j++) {
                        System.out.println("yellow");
                        BbyMaton x = yellow.get(0);
                        all.add(x);
                        x.setCoordenadas(crdx, 0);
                        crdx = crdx + 128;
                        yellow.remove(x);
                    }
                }
            }

            if (input.isKeyDown(Input.KEY_ENTER)) {
                gc.exit();
            }

            if (input.isKeyDown(Input.KEY_A)) {
                personaje.getDir().update(i);
                for (int n = 0; n < 20; n++) {
                    if (personaje.getH1().intersects(bordes)) {
                        a = 1;
                        break;
                    } else {
                        a = 0;
                    }
                }
                if (a == 0 || b == 1) {
                    personaje.setCoordenadaX(personaje.getCoordenadaX() - i * 0.34f);
                    b = 0;
                }

            } else if (input.isKeyDown(Input.KEY_D)) {
                personaje.getDir().update(i);
                for (int n = 0; n < 20; n++) {
                    if (personaje.getH2().intersects(bordes)) {
                        b = 1;
                        break;
                    } else {
                        b = 0;
                    }
                }
                if (b == 0 || a == 1) {
                    personaje.setCoordenadaX(personaje.getCoordenadaX() + i * 0.34f);
                    a = 0;
                }

            } else {
                personaje.getDir().update(i);
            }

            Rectangle uno = ball.getH1();
            Rectangle dos = ball.getH2();
            Rectangle tres = ball.getH3();
            Rectangle cuatro = ball.getH4();

            if (tres.intersects(personaje.getH3())) {
                toque++;
                double num = (random() * 0.366 + 0.5);
                float num2 = (float) sqrt(1 - pow(num, 2));
                ball.setDest(-(float) num, -num2);
            } else if (tres.intersects(personaje.getH4())) {
                toque++;
                double num = (random() * 1 - 0.5);
                float num2 = (float) sqrt(1 - pow(num, 2));
                ball.setDest((float) num, -num2);
            } else if (tres.intersects(personaje.getH5())) {
                toque++;
                double num = (random() * 0.366 + 0.5);
                float num2 = (float) sqrt(1 - pow(num, 2));
                ball.setDest((float) num, -num2);
            } else if (cuatro.intersects(bordes) || dos.intersects(bordes)) {
                ball.pared();
            } else if (uno.intersects(bordes)) {
                ball.techo();
            } else if (tres.intersects(bordes)) {
                try {
                    sbg.enterState(21, FadeOutTransition.class.newInstance(), FadeInTransition.class.newInstance());
                } catch (InstantiationException ex) {
                    Logger.getLogger(Boss1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Boss1.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                for (int q = 0; q < all.size(); q++) {
                    BbyMaton a = all.get(q);
                    int atipo = a.getTipo();
                    Rectangle hitbox = a.getH1();
                    if (hitbox.intersects(uno) || hitbox.intersects(tres)) {
                        if (atipo == 0) {
                            red.add(a);
                            all.remove(a);
                            a.init();
                        } else if (atipo == 1) {
                            blue.add(a);
                            all.remove(a);
                            a.init();
                        } else if (atipo == 2) {
                            orange.add(a);
                            all.remove(a);
                            a.init();
                        } else {
                            yellow.add(a);
                            all.remove(a);
                            a.init();
                        }
                        if (all.isEmpty()) {
                            try {
                                sbg.enterState(26, FadeOutTransition.class.newInstance(), FadeInTransition.class.newInstance());
                            } catch (InstantiationException ex) {
                                Logger.getLogger(Boss1.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IllegalAccessException ex) {
                                Logger.getLogger(Boss1.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        ball.techo();
                        break;
                    } else if (hitbox.intersects(dos) || hitbox.intersects(cuatro)) {

                        if (atipo == 0) {
                            red.add(a);
                            all.remove(a);
                            a.init();
                        } else if (atipo == 1) {
                            blue.add(a);
                            all.remove(a);
                            a.init();
                        } else if (atipo == 2) {
                            orange.add(a);
                            all.remove(a);
                            a.init();
                        } else {
                            yellow.add(a);
                            all.remove(a);
                            a.init();
                        }
                        if (all.isEmpty()) {
                            try {
                                sbg.enterState(26, FadeOutTransition.class.newInstance(), FadeInTransition.class.newInstance());
                            } catch (InstantiationException ex) {
                                Logger.getLogger(Boss1.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IllegalAccessException ex) {
                                Logger.getLogger(Boss1.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        ball.pared();
                        break;
                    }
                }
            }
            ball.move();

        }
    }
}
