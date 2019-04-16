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
 * @mapa plaza arriba
 */
public class Mapa4 extends MapaT {

    private String mapa = "\\Mapas\\mapa4.tmx";

    private float puntos1[] = new float[]{384, 735, 64, 736, 63, 767, 31, 769, 31, 799, 0, 799, 0, 201, 842, 201, 840, 287, 1182, 287, 1183, 158, 1244, 159, 1245, 165, 1403, 165, 1407, 254, 1249, 257, 1247, 350, 1121, 351, 1121, 449, 1246, 450, 1247, 544, 1404, 546, 1408, 639, 1248, 640, 1247, 767, 551, 767, 550, 737, 480, 737, 480, 798, 384, 798, 384, 737};
    private float puntos2[] = new float[]{95, 397, 192, 397, 192, 266, 95, 266};
    private float puntos3[] = new float[]{95, 591, 191, 591, 191, 460, 95, 460};
    private float puntos4[] = new float[]{255, 266, 255, 400, 352, 400, 352, 266};
    private float puntos5[] = new float[]{255, 459, 255, 590, 352, 590, 352, 459};
    private float puntos6[] = new float[]{510, 267, 510, 399, 607, 399, 607, 267};
    private float puntos7[] = new float[]{510, 459, 510, 592, 608, 592, 608, 459};
    private float puntos8[] = new float[]{671, 266, 671, 397, 767, 397, 767, 266};
    private float puntos9[] = new float[]{671, 460, 671, 590, 768, 590, 768, 460};

    private Polygon bordes = new Polygon();
    private ArrayList<Polygon> colisiones;
    private ArrayList<float[]> puntos;

    private ArrayList<Polygon> salidas;
    private ArrayList<float[]> extremos;
    
    private ArrayList<WanderTipoT> personajes = new ArrayList<>(); 

    private float puntos21[] = new float[]{390, 800, 474, 800, 474, 798, 390, 798};
    private float puntos22[] = new float[]{0, 204, 0, 729, 2, 792, 2, 204};

    //plaza central 
    private float mapas[] = new float[]{0, 8};
    private float coord[] = new float[]{0, 0, 1438, 0};

    public Mapa4() {
        super();
        puntos = new ArrayList<>();
        colisiones = new ArrayList<>();

        puntos.add(puntos1);
        puntos.add(puntos2);
        puntos.add(puntos3);
        puntos.add(puntos4);
        puntos.add(puntos5);
        puntos.add(puntos6);
        puntos.add(puntos7);
        puntos.add(puntos8);
        puntos.add(puntos9);

        for (int i = 0; i < puntos.size(); i++) {
            bordes = new Polygon(puntos.get(i));
            colisiones.add(bordes);
        }

        extremos = new ArrayList<>();
        salidas = new ArrayList<>();

        extremos.add(puntos21);
        extremos.add(puntos22);

        for (int i = 0; i < extremos.size(); i++) {
            bordes = new Polygon(extremos.get(i));
            salidas.add(bordes);
        }
    }

    public void setCoordX(int x, int y) {
        coord[2 * x] = y;
    }

    public void setCoordY(int x, int y) {
        coord[(2 * x) + 1] = y;
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
