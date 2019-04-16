/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapas;

import Personajes.WanderTipoT;
import java.util.ArrayList;
import org.newdawn.slick.geom.Polygon;

/**
 *
 * @author lucas
 * @mapa plaza abajo
 */
public class Mapa5 extends MapaT {

    private String mapa = "\\Mapas\\mapa5.tmx";

    private float puntos1[] = new float[]{1403, 165, 1407, 254, 1249, 257, 1247, 350, 1121, 351, 1121, 449, 1246, 450, 1247, 544, 1404, 546, 1408, 639, 1248, 640, 1247, 767, 966, 767, 966, 126, 460, 126, 460, 163, 506, 163, 506, 347, 350, 347, 350, 414, 322, 414, 322, 598, 350, 598, 350, 612, 383, 612, 383, 644, 412, 644, 412, 611, 480, 611, 480, 642, 512, 642, 512, 736, 255, 736, 255, 800, 63, 800, 64, 736, 0, 736, 0, 162, 406, 163, 406, 127, 0, 127, 0, 0, 95, 0, 95, 32, 352, 32, 352, 64, 384, 64, 384, 0, 479, 0, 479, 64, 512, 64, 512, 32, 703, 32, 703, 4, 768, 4, 768, 0, 1245, 0, 1245, 165};
    private float puntos2[] = new float[]{132, 660, 90, 660, 90, 641, 132, 641};

    private Polygon bordes = new Polygon();
    private ArrayList<Polygon> colisiones;
    private ArrayList<float[]> puntos;

    private ArrayList<Polygon> salidas;
    private ArrayList<float[]> extremos;
    private ArrayList<WanderTipoT> personajes = new ArrayList<>(); 

    private float puntos21[] = new float[]{426, 612, 471, 612, 471, 613, 426, 613};
    private float puntos22[] = new float[]{390, 0, 474, 0, 474, 2, 390, 2};
    private float puntos23[] = new float[]{66, 798, 252, 798, 252, 800, 66, 800};
    private float puntos24[] = new float[]{776, 2, 1241, 2, 1241, 0, 776, 0};

    //colegio - plaza central - boss1 - plaza central
    private float mapas[] = new float[]{6, 0, 5, 0};
    private float coord[] = new float[]{482, 703, 0, 720, 0, 0, 0, 720};

    public Mapa5() {
        super();
        puntos = new ArrayList<>();
        colisiones = new ArrayList<>();

        puntos.add(puntos1);
        puntos.add(puntos2);

        for (int i = 0; i < puntos.size(); i++) {
            bordes = new Polygon(puntos.get(i));
            colisiones.add(bordes);
        }

        extremos = new ArrayList<>();
        salidas = new ArrayList<>();

        extremos.add(puntos21);
        extremos.add(puntos22);
        extremos.add(puntos23);
        extremos.add(puntos24);

        for (int i = 0; i < extremos.size(); i++) {
            bordes = new Polygon(extremos.get(i));
            salidas.add(bordes);
        }
    }

    public void setCoordX(int x, int y) {
        if (2 * x != 0) {
            coord[2 * x] = y;
        }
    }

    public void setCoordY(int x, int y) {
        if ((2 * x) + 1 != 1) {
            coord[(2 * x) + 1] = y;
        }
    }

    public ArrayList<Polygon> getBordes() {
        return colisiones;
    }

    public ArrayList<Polygon> getSalidas() {
        return salidas;
    }

    public String getMapa() {
        return mapa;
    }

    public ArrayList<WanderTipoT> getPersonajes() {
        return personajes;
    }
    
    public float getMapas(int salida) {
        return mapas[salida];
    }

    public float[] getCoord() {
        return coord;
    }

}
