/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estados;

import EstadoBoss1.Boss1;
import Personajes.Boton;
import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.tiled.TiledMap;

/**
 *
 * @author lucas
 */
public class Boss4 extends BasicGameState {

    @Override
    public int getID() {
        return 31;
    }

    private String mapa1 = "Mapas\\Boss3.tmx";

    Boton b0;
    Boton b1;
    Boton b2;
    Boton b3;
    Boton b4;
    Boton b5;
    Boton b6;
    Boton b7;
    Boton b8;
    Boton b9;
    Boton b10;
    Boton b11;
    Boton b12;
    Boton b13;
    Boton b14;
    Boton b15;
    Boton b16;
    Boton b17;
    Boton b18;
    Boton b19;
    Boton b20;
    Boton b21;
    Boton b22;
    Boton b23;
    Boton b24;
    Boton b25;
    Boton b26;
    Boton b27;
    Boton b28;
    Boton b29;
    Boton b30;
    Boton b31;
    Boton b32;
    Boton b33;
    Boton b34;
    Boton b35;
    Boton b36;
    Boton b37;
    Boton b38;
    Boton b39;
    Boton b40;
    Boton b41;
    Boton b42;
    Boton b43;
    Boton b44;
    Boton b45;
    Boton b46;
    Boton b47;
    Boton b48;
    Boton b49;
    Boton b50;
    Boton b51;
    Boton b52;
    Boton b53;
    Boton b54;
    Boton b55;
    Boton b56;
    Boton b57;
    Boton b58;
    Boton b59;
    Boton b60;
    Boton b61;
    Boton b62;
    Boton b63;
    Boton b64;
    Boton b65;
    Boton b66;
    Boton b67;
    Boton b68;
    Boton b69;
    Boton b70;
    Boton b71;
    Boton b72;
    Boton b73;
    Boton b74;
    Boton b75;
    Boton b76;
    Boton b77;
    Boton b78;
    Boton b79;
    Boton b80;
    Boton b81;
    Boton b82;
    Boton b83;
    Boton b84;
    Boton b85;
    Boton b86;
    Boton b87;
    Boton b88;
    Boton b89;
    Boton b90;
    Boton b91;
    Boton b92;
    Boton b93;
    Boton b94;
    Boton b95;
    Boton b96;
    Boton b97;
    Boton b98;
    Boton b99;
    Boton b100;
    Boton b101;
    Boton b102;
    Boton b103;
    Boton b104;
    Boton b105;
    Boton b106;
    Boton b107;
    Boton b108;
    Boton b109;
    Boton b110;
    Boton b111;
    Boton b112;
    Boton b113;
    Boton b114;
    Boton b115;
    Boton b116;
    Boton b117;
    Boton b118;
    Boton b119;
    int total = 0;
    ArrayList<Boton> listaBotones;
    TiledMap mapa;
    private Music song;
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        song = new Music("\\Elementos Aparte\\MusicaDefinitiva\\Boss1.wav");
        total = 0;
        
        listaBotones = new ArrayList<>();
        mapa = new TiledMap(mapa1, "\\Construccion Mapas\\");

        int[][] matriz = new int[10][12];
        for (int i = 0; i < 120; i++) {
            matriz[i % 10][i / 10] = 0;
        }

        for (int i = 0; i < 18; i++) {
            int minax = (int) (random() * 10);
            int minay = (int) (random() * 12);
            while (matriz[minax][minay] != 0) {
                minax = (int) (random() * 10);
                minay = (int) (random() * 12);
            }
            matriz[minax][minay] = -1;
        }

        for (int i = 0; i < 120; i++) {
            int x1 = i % 10;
            int y = i / 10;

            if (matriz[x1][y] != -1) {
                try {
                    if (matriz[x1 - 1][y - 1] == -1) {
                        matriz[x1][y]++;
                    }
                } catch (Exception e) {
                }
                try {
                    if (matriz[x1 + 1][y + 1] == -1) {
                        matriz[x1][y]++;
                    }
                } catch (Exception e) {
                }
                try {
                    if (matriz[x1 + 1][y - 1] == -1) {
                        matriz[x1][y]++;
                    }
                } catch (Exception e) {
                }
                try {
                    if (matriz[x1 - 1][y + 1] == -1) {
                        matriz[x1][y]++;
                    }
                } catch (Exception e) {
                }
                try {
                    if (matriz[x1][y - 1] == -1) {
                        matriz[x1][y]++;
                    }
                } catch (Exception e) {
                }
                try {
                    if (matriz[x1 - 1][y] == -1) {
                        matriz[x1][y]++;
                    }
                } catch (Exception e) {
                }
                try {
                    if (matriz[x1 + 1][y] == -1) {
                        matriz[x1][y]++;
                    }
                } catch (Exception e) {
                }
                try {
                    if (matriz[x1][y + 1] == -1) {
                        matriz[x1][y]++;
                    }
                } catch (Exception e) {
                }
            }
        }
        b0 = new Boton(matriz[0][0]);
        b1 = new Boton(matriz[1][0]);
        b2 = new Boton(matriz[2][0]);
        b3 = new Boton(matriz[3][0]);
        b4 = new Boton(matriz[4][0]);
        b5 = new Boton(matriz[5][0]);
        b6 = new Boton(matriz[6][0]);
        b7 = new Boton(matriz[7][0]);
        b8 = new Boton(matriz[8][0]);
        b9 = new Boton(matriz[9][0]);
        b10 = new Boton(matriz[0][1]);
        b11 = new Boton(matriz[1][1]);
        b12 = new Boton(matriz[2][1]);
        b13 = new Boton(matriz[3][1]);
        b14 = new Boton(matriz[4][1]);
        b15 = new Boton(matriz[5][1]);
        b16 = new Boton(matriz[6][1]);
        b17 = new Boton(matriz[7][1]);
        b18 = new Boton(matriz[8][1]);
        b19 = new Boton(matriz[9][1]);
        b20 = new Boton(matriz[0][2]);
        b21 = new Boton(matriz[1][2]);
        b22 = new Boton(matriz[2][2]);
        b23 = new Boton(matriz[3][2]);
        b24 = new Boton(matriz[4][2]);
        b25 = new Boton(matriz[5][2]);
        b26 = new Boton(matriz[6][2]);
        b27 = new Boton(matriz[7][2]);
        b28 = new Boton(matriz[8][2]);
        b29 = new Boton(matriz[9][2]);
        b30 = new Boton(matriz[0][3]);
        b31 = new Boton(matriz[1][3]);
        b32 = new Boton(matriz[2][3]);
        b33 = new Boton(matriz[3][3]);
        b34 = new Boton(matriz[4][3]);
        b35 = new Boton(matriz[5][3]);
        b36 = new Boton(matriz[6][3]);
        b37 = new Boton(matriz[7][3]);
        b38 = new Boton(matriz[8][3]);
        b39 = new Boton(matriz[9][3]);
        b40 = new Boton(matriz[0][4]);
        b41 = new Boton(matriz[1][4]);
        b42 = new Boton(matriz[2][4]);
        b43 = new Boton(matriz[3][4]);
        b44 = new Boton(matriz[4][4]);
        b45 = new Boton(matriz[5][4]);
        b46 = new Boton(matriz[6][4]);
        b47 = new Boton(matriz[7][4]);
        b48 = new Boton(matriz[8][4]);
        b49 = new Boton(matriz[9][4]);
        b50 = new Boton(matriz[0][5]);
        b51 = new Boton(matriz[1][5]);
        b52 = new Boton(matriz[2][5]);
        b53 = new Boton(matriz[3][5]);
        b54 = new Boton(matriz[4][5]);
        b55 = new Boton(matriz[5][5]);
        b56 = new Boton(matriz[6][5]);
        b57 = new Boton(matriz[7][5]);
        b58 = new Boton(matriz[8][5]);
        b59 = new Boton(matriz[9][5]);
        b60 = new Boton(matriz[0][6]);
        b61 = new Boton(matriz[1][6]);
        b62 = new Boton(matriz[2][6]);
        b63 = new Boton(matriz[3][6]);
        b64 = new Boton(matriz[4][6]);
        b65 = new Boton(matriz[5][6]);
        b66 = new Boton(matriz[6][6]);
        b67 = new Boton(matriz[7][6]);
        b68 = new Boton(matriz[8][6]);
        b69 = new Boton(matriz[9][6]);
        b70 = new Boton(matriz[0][7]);
        b71 = new Boton(matriz[1][7]);
        b72 = new Boton(matriz[2][7]);
        b73 = new Boton(matriz[3][7]);
        b74 = new Boton(matriz[4][7]);
        b75 = new Boton(matriz[5][7]);
        b76 = new Boton(matriz[6][7]);
        b77 = new Boton(matriz[7][7]);
        b78 = new Boton(matriz[8][7]);
        b79 = new Boton(matriz[9][7]);
        b80 = new Boton(matriz[0][8]);
        b81 = new Boton(matriz[1][8]);
        b82 = new Boton(matriz[2][8]);
        b83 = new Boton(matriz[3][8]);
        b84 = new Boton(matriz[4][8]);
        b85 = new Boton(matriz[5][8]);
        b86 = new Boton(matriz[6][8]);
        b87 = new Boton(matriz[7][8]);
        b88 = new Boton(matriz[8][8]);
        b89 = new Boton(matriz[9][8]);
        b90 = new Boton(matriz[0][9]);
        b91 = new Boton(matriz[1][9]);
        b92 = new Boton(matriz[2][9]);
        b93 = new Boton(matriz[3][9]);
        b94 = new Boton(matriz[4][9]);
        b95 = new Boton(matriz[5][9]);
        b96 = new Boton(matriz[6][9]);
        b97 = new Boton(matriz[7][9]);
        b98 = new Boton(matriz[8][9]);
        b99 = new Boton(matriz[9][9]);
        b100 = new Boton(matriz[0][10]);
        b101 = new Boton(matriz[1][10]);
        b102 = new Boton(matriz[2][10]);
        b103 = new Boton(matriz[3][10]);
        b104 = new Boton(matriz[4][10]);
        b105 = new Boton(matriz[5][10]);
        b106 = new Boton(matriz[6][10]);
        b107 = new Boton(matriz[7][10]);
        b108 = new Boton(matriz[8][10]);
        b109 = new Boton(matriz[9][10]);
        b110 = new Boton(matriz[0][11]);
        b111 = new Boton(matriz[1][11]);
        b112 = new Boton(matriz[2][11]);
        b113 = new Boton(matriz[3][11]);
        b114 = new Boton(matriz[4][11]);
        b115 = new Boton(matriz[5][11]);
        b116 = new Boton(matriz[6][11]);
        b117 = new Boton(matriz[7][11]);
        b118 = new Boton(matriz[8][11]);
        b119 = new Boton(matriz[9][11]);

        listaBotones.add(b0);
        listaBotones.add(b1);
        listaBotones.add(b2);
        listaBotones.add(b3);
        listaBotones.add(b4);
        listaBotones.add(b5);
        listaBotones.add(b6);
        listaBotones.add(b7);
        listaBotones.add(b8);
        listaBotones.add(b9);
        listaBotones.add(b10);
        listaBotones.add(b11);
        listaBotones.add(b12);
        listaBotones.add(b13);
        listaBotones.add(b14);
        listaBotones.add(b15);
        listaBotones.add(b16);
        listaBotones.add(b17);
        listaBotones.add(b18);
        listaBotones.add(b19);
        listaBotones.add(b20);
        listaBotones.add(b21);
        listaBotones.add(b22);
        listaBotones.add(b23);
        listaBotones.add(b24);
        listaBotones.add(b25);
        listaBotones.add(b26);
        listaBotones.add(b27);
        listaBotones.add(b28);
        listaBotones.add(b29);
        listaBotones.add(b30);
        listaBotones.add(b31);
        listaBotones.add(b32);
        listaBotones.add(b33);
        listaBotones.add(b34);
        listaBotones.add(b35);
        listaBotones.add(b36);
        listaBotones.add(b37);
        listaBotones.add(b38);
        listaBotones.add(b39);
        listaBotones.add(b40);
        listaBotones.add(b41);
        listaBotones.add(b42);
        listaBotones.add(b43);
        listaBotones.add(b44);
        listaBotones.add(b45);
        listaBotones.add(b46);
        listaBotones.add(b47);
        listaBotones.add(b48);
        listaBotones.add(b49);
        listaBotones.add(b50);
        listaBotones.add(b51);
        listaBotones.add(b52);
        listaBotones.add(b53);
        listaBotones.add(b54);
        listaBotones.add(b55);
        listaBotones.add(b56);
        listaBotones.add(b57);
        listaBotones.add(b58);
        listaBotones.add(b59);
        listaBotones.add(b60);
        listaBotones.add(b61);
        listaBotones.add(b62);
        listaBotones.add(b63);
        listaBotones.add(b64);
        listaBotones.add(b65);
        listaBotones.add(b66);
        listaBotones.add(b67);
        listaBotones.add(b68);
        listaBotones.add(b69);
        listaBotones.add(b70);
        listaBotones.add(b71);
        listaBotones.add(b72);
        listaBotones.add(b73);
        listaBotones.add(b74);
        listaBotones.add(b75);
        listaBotones.add(b76);
        listaBotones.add(b77);
        listaBotones.add(b78);
        listaBotones.add(b79);
        listaBotones.add(b80);
        listaBotones.add(b81);
        listaBotones.add(b82);
        listaBotones.add(b83);
        listaBotones.add(b84);
        listaBotones.add(b85);
        listaBotones.add(b86);
        listaBotones.add(b87);
        listaBotones.add(b88);
        listaBotones.add(b89);
        listaBotones.add(b90);
        listaBotones.add(b91);
        listaBotones.add(b92);
        listaBotones.add(b93);
        listaBotones.add(b94);
        listaBotones.add(b95);
        listaBotones.add(b96);
        listaBotones.add(b97);
        listaBotones.add(b98);
        listaBotones.add(b99);
        listaBotones.add(b100);
        listaBotones.add(b101);
        listaBotones.add(b102);
        listaBotones.add(b103);
        listaBotones.add(b104);
        listaBotones.add(b105);
        listaBotones.add(b106);
        listaBotones.add(b107);
        listaBotones.add(b108);
        listaBotones.add(b109);
        listaBotones.add(b110);
        listaBotones.add(b111);
        listaBotones.add(b112);
        listaBotones.add(b113);
        listaBotones.add(b114);
        listaBotones.add(b115);
        listaBotones.add(b116);
        listaBotones.add(b117);
        listaBotones.add(b118);
        listaBotones.add(b119);

        b0.setCoordenadas(375, 80);
        b10.setCoordenadas(440, 80);
        b20.setCoordenadas(505, 80);
        b30.setCoordenadas(570, 80);
        b40.setCoordenadas(635, 80);
        b50.setCoordenadas(700, 80);
        b60.setCoordenadas(765, 80);
        b70.setCoordenadas(830, 80);
        b80.setCoordenadas(895, 80);
        b90.setCoordenadas(960, 80);
        b100.setCoordenadas(1025, 80);
        b110.setCoordenadas(1090, 80);
        b1.setCoordenadas(375, 145);
        b11.setCoordenadas(440, 145);
        b21.setCoordenadas(505, 145);
        b31.setCoordenadas(570, 145);
        b41.setCoordenadas(635, 145);
        b51.setCoordenadas(700, 145);
        b61.setCoordenadas(765, 145);
        b71.setCoordenadas(830, 145);
        b81.setCoordenadas(895, 145);
        b91.setCoordenadas(960, 145);
        b101.setCoordenadas(1025, 145);
        b111.setCoordenadas(1090, 145);
        b2.setCoordenadas(375, 210);
        b12.setCoordenadas(440, 210);
        b22.setCoordenadas(505, 210);
        b32.setCoordenadas(570, 210);
        b42.setCoordenadas(635, 210);
        b52.setCoordenadas(700, 210);
        b62.setCoordenadas(765, 210);
        b72.setCoordenadas(830, 210);
        b82.setCoordenadas(895, 210);
        b92.setCoordenadas(960, 210);
        b102.setCoordenadas(1025, 210);
        b112.setCoordenadas(1090, 210);
        b3.setCoordenadas(375, 275);
        b13.setCoordenadas(440, 275);
        b23.setCoordenadas(505, 275);
        b33.setCoordenadas(570, 275);
        b43.setCoordenadas(635, 275);
        b53.setCoordenadas(700, 275);
        b63.setCoordenadas(765, 275);
        b73.setCoordenadas(830, 275);
        b83.setCoordenadas(895, 275);
        b93.setCoordenadas(960, 275);
        b103.setCoordenadas(1025, 275);
        b113.setCoordenadas(1090, 275);
        b4.setCoordenadas(375, 340);
        b14.setCoordenadas(440, 340);
        b24.setCoordenadas(505, 340);
        b34.setCoordenadas(570, 340);
        b44.setCoordenadas(635, 340);
        b54.setCoordenadas(700, 340);
        b64.setCoordenadas(765, 340);
        b74.setCoordenadas(830, 340);
        b84.setCoordenadas(895, 340);
        b94.setCoordenadas(960, 340);
        b104.setCoordenadas(1025, 340);
        b114.setCoordenadas(1090, 340);
        b5.setCoordenadas(375, 405);
        b15.setCoordenadas(440, 405);
        b25.setCoordenadas(505, 405);
        b35.setCoordenadas(570, 405);
        b45.setCoordenadas(635, 405);
        b55.setCoordenadas(700, 405);
        b65.setCoordenadas(765, 405);
        b75.setCoordenadas(830, 405);
        b85.setCoordenadas(895, 405);
        b95.setCoordenadas(960, 405);
        b105.setCoordenadas(1025, 405);
        b115.setCoordenadas(1090, 405);
        b6.setCoordenadas(375, 470);
        b16.setCoordenadas(440, 470);
        b26.setCoordenadas(505, 470);
        b36.setCoordenadas(570, 470);
        b46.setCoordenadas(635, 470);
        b56.setCoordenadas(700, 470);
        b66.setCoordenadas(765, 470);
        b76.setCoordenadas(830, 470);
        b86.setCoordenadas(895, 470);
        b96.setCoordenadas(960, 470);
        b106.setCoordenadas(1025, 470);
        b116.setCoordenadas(1090, 470);
        b7.setCoordenadas(375, 535);
        b17.setCoordenadas(440, 535);
        b27.setCoordenadas(505, 535);
        b37.setCoordenadas(570, 535);
        b47.setCoordenadas(635, 535);
        b57.setCoordenadas(700, 535);
        b67.setCoordenadas(765, 535);
        b77.setCoordenadas(830, 535);
        b87.setCoordenadas(895, 535);
        b97.setCoordenadas(960, 535);
        b107.setCoordenadas(1025, 535);
        b117.setCoordenadas(1090, 535);
        b8.setCoordenadas(375, 600);
        b18.setCoordenadas(440, 600);
        b28.setCoordenadas(505, 600);
        b38.setCoordenadas(570, 600);
        b48.setCoordenadas(635, 600);
        b58.setCoordenadas(700, 600);
        b68.setCoordenadas(765, 600);
        b78.setCoordenadas(830, 600);
        b88.setCoordenadas(895, 600);
        b98.setCoordenadas(960, 600);
        b108.setCoordenadas(1025, 600);
        b118.setCoordenadas(1090, 600);
        b9.setCoordenadas(375, 665);
        b19.setCoordenadas(440, 665);
        b29.setCoordenadas(505, 665);
        b39.setCoordenadas(570, 665);
        b49.setCoordenadas(635, 665);
        b59.setCoordenadas(700, 665);
        b69.setCoordenadas(765, 665);
        b79.setCoordenadas(830, 665);
        b89.setCoordenadas(895, 665);
        b99.setCoordenadas(960, 665);
        b109.setCoordenadas(1025, 665);
        b119.setCoordenadas(1090, 665);

    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        mapa.render(0, 0);
        mapa.render(1, 0);

        b0.getDir().draw(375, 80);
        b10.getDir().draw(440, 80);
        b20.getDir().draw(505, 80);
        b30.getDir().draw(570, 80);
        b40.getDir().draw(635, 80);
        b50.getDir().draw(700, 80);
        b60.getDir().draw(765, 80);
        b70.getDir().draw(830, 80);
        b80.getDir().draw(895, 80);
        b90.getDir().draw(960, 80);
        b100.getDir().draw(1025, 80);
        b110.getDir().draw(1090, 80);
        b1.getDir().draw(375, 145);
        b11.getDir().draw(440, 145);
        b21.getDir().draw(505, 145);
        b31.getDir().draw(570, 145);
        b41.getDir().draw(635, 145);
        b51.getDir().draw(700, 145);
        b61.getDir().draw(765, 145);
        b71.getDir().draw(830, 145);
        b81.getDir().draw(895, 145);
        b91.getDir().draw(960, 145);
        b101.getDir().draw(1025, 145);
        b111.getDir().draw(1090, 145);
        b2.getDir().draw(375, 210);
        b12.getDir().draw(440, 210);
        b22.getDir().draw(505, 210);
        b32.getDir().draw(570, 210);
        b42.getDir().draw(635, 210);
        b52.getDir().draw(700, 210);
        b62.getDir().draw(765, 210);
        b72.getDir().draw(830, 210);
        b82.getDir().draw(895, 210);
        b92.getDir().draw(960, 210);
        b102.getDir().draw(1025, 210);
        b112.getDir().draw(1090, 210);
        b3.getDir().draw(375, 275);
        b13.getDir().draw(440, 275);
        b23.getDir().draw(505, 275);
        b33.getDir().draw(570, 275);
        b43.getDir().draw(635, 275);
        b53.getDir().draw(700, 275);
        b63.getDir().draw(765, 275);
        b73.getDir().draw(830, 275);
        b83.getDir().draw(895, 275);
        b93.getDir().draw(960, 275);
        b103.getDir().draw(1025, 275);
        b113.getDir().draw(1090, 275);
        b4.getDir().draw(375, 340);
        b14.getDir().draw(440, 340);
        b24.getDir().draw(505, 340);
        b34.getDir().draw(570, 340);
        b44.getDir().draw(635, 340);
        b54.getDir().draw(700, 340);
        b64.getDir().draw(765, 340);
        b74.getDir().draw(830, 340);
        b84.getDir().draw(895, 340);
        b94.getDir().draw(960, 340);
        b104.getDir().draw(1025, 340);
        b114.getDir().draw(1090, 340);
        b5.getDir().draw(375, 405);
        b15.getDir().draw(440, 405);
        b25.getDir().draw(505, 405);
        b35.getDir().draw(570, 405);
        b45.getDir().draw(635, 405);
        b55.getDir().draw(700, 405);
        b65.getDir().draw(765, 405);
        b75.getDir().draw(830, 405);
        b85.getDir().draw(895, 405);
        b95.getDir().draw(960, 405);
        b105.getDir().draw(1025, 405);
        b115.getDir().draw(1090, 405);
        b6.getDir().draw(375, 470);
        b16.getDir().draw(440, 470);
        b26.getDir().draw(505, 470);
        b36.getDir().draw(570, 470);
        b46.getDir().draw(635, 470);
        b56.getDir().draw(700, 470);
        b66.getDir().draw(765, 470);
        b76.getDir().draw(830, 470);
        b86.getDir().draw(895, 470);
        b96.getDir().draw(960, 470);
        b106.getDir().draw(1025, 470);
        b116.getDir().draw(1090, 470);
        b7.getDir().draw(375, 535);
        b17.getDir().draw(440, 535);
        b27.getDir().draw(505, 535);
        b37.getDir().draw(570, 535);
        b47.getDir().draw(635, 535);
        b57.getDir().draw(700, 535);
        b67.getDir().draw(765, 535);
        b77.getDir().draw(830, 535);
        b87.getDir().draw(895, 535);
        b97.getDir().draw(960, 535);
        b107.getDir().draw(1025, 535);
        b117.getDir().draw(1090, 535);
        b8.getDir().draw(375, 600);
        b18.getDir().draw(440, 600);
        b28.getDir().draw(505, 600);
        b38.getDir().draw(570, 600);
        b48.getDir().draw(635, 600);
        b58.getDir().draw(700, 600);
        b68.getDir().draw(765, 600);
        b78.getDir().draw(830, 600);
        b88.getDir().draw(895, 600);
        b98.getDir().draw(960, 600);
        b108.getDir().draw(1025, 600);
        b118.getDir().draw(1090, 600);
        b9.getDir().draw(375, 665);
        b19.getDir().draw(440, 665);
        b29.getDir().draw(505, 665);
        b39.getDir().draw(570, 665);
        b49.getDir().draw(635, 665);
        b59.getDir().draw(700, 665);
        b69.getDir().draw(765, 665);
        b79.getDir().draw(830, 665);
        b89.getDir().draw(895, 665);
        b99.getDir().draw(960, 665);
        b109.getDir().draw(1025, 665);
        b119.getDir().draw(1090, 665);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        
        if (!song.playing()) {
            song.setPosition((float) 12.55);
            song.play();
            song.setVolume((float) 0.2);
        }
        
        Input input = gc.getInput();
        input.disableKeyRepeat();
        if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
            int x = input.getMouseX();
            int y = input.getMouseY();
            for (int j = 0; j < listaBotones.size(); j++) {
                if (listaBotones.get(j).check(x, y)) {
                    total++;
                    if (listaBotones.get(j).getNum() == -1) {

                        try {
                            sbg.enterState(32, FadeOutTransition.class.newInstance(), FadeInTransition.class.newInstance());
                        } catch (InstantiationException ex) {
                            Logger.getLogger(Boss1.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IllegalAccessException ex) {
                            Logger.getLogger(Boss1.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                }
            }
        }
        if (total == 102) {
            try {
                sbg.enterState(30, FadeOutTransition.class.newInstance(), FadeInTransition.class.newInstance());
            } catch (InstantiationException ex) {
                Logger.getLogger(Boss1.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Boss1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
