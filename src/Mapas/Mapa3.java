/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapas;

import Personajes.WanderTipo1;
import java.util.ArrayList;
import org.newdawn.slick.geom.Polygon;

/**
 *
 * @author lucas
 * @mapa buhardilla
 */
public class Mapa3 extends MapaT {

    private String mapa = "\\Mapas\\mapa3.tmx";

    private float puntos1[] = new float[]{705, 192, 838, 192, 838, 220, 865, 220, 865, 255, 935, 255, 935, 277, 963, 277, 963, 321, 991, 321, 991, 377, 961, 377, 961, 446, 931, 446, 931, 471, 957, 471, 957, 480, 989, 480, 989, 512, 902, 512, 902, 564, 867, 564, 867, 572, 512, 572, 512, 289, 540, 289, 540, 250, 700, 250, 700, 388, 737, 388, 737, 413, 767, 413, 767, 388, 799, 388, 799, 366, 771, 366, 771, 257, 768, 257, 768, 381, 705, 381};
    private float puntos2[] = new float[]{862, 482, 898, 482, 898, 449, 862, 449};
    private float puntos3[] = new float[]{605, 322, 578, 322, 578, 290, 605, 290};
    private float puntos4[] = new float[]{870, 353, 891, 353, 891, 320, 870, 320};
    private float puntos5[] = new float[]{740, 544, 802, 544, 802, 510, 740, 510};
    private float puntos6[] = new float[]{606, 450, 642, 450, 642, 415, 606, 415};

    private Polygon bordes = new Polygon();
    private ArrayList<Polygon> colisiones;
    private ArrayList<float[]> puntos;

    private ArrayList<Polygon> salidas;
    private ArrayList<float[]> extremos;
    
    private ArrayList<WanderTipo1> personajes = new ArrayList<>(); 

    private float puntos21[] = new float[]{707, 355, 763, 355, 763, 354, 707, 354};

    private float mapas[] = new float[]{1};
    private float coord[] = new float[]{840, 90};

    public Mapa3() {
        super();
        puntos = new ArrayList<>();
        colisiones = new ArrayList<>();

        puntos.add(puntos1);
        puntos.add(puntos2);
        puntos.add(puntos3);
        puntos.add(puntos4);
        puntos.add(puntos5);
        puntos.add(puntos6);

        for (int i = 0; i < puntos.size(); i++) {
            bordes = new Polygon(puntos.get(i));
            colisiones.add(bordes);
        }

        extremos = new ArrayList<>();
        salidas = new ArrayList<>();

        extremos.add(puntos21);

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

    public ArrayList<WanderTipo1> getPersonajes() {
        return personajes;
    }
    
    public float getMapas(int salida) {
        return mapas[salida];
    }

    public float[] getCoord() {
        return coord;
    }

}
