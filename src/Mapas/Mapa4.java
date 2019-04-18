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
    
    private Polygon bordes = new Polygon();
    
    private float borde1[] = new float[]{384, 735, 64, 736, 63, 767, 31, 769, 31, 799, 0, 799, 0, 201, 842, 201, 840, 287, 1182, 287, 1183, 158, 1244, 159, 1245, 165, 1403, 165, 1407, 254, 1249, 257, 1247, 350, 1121, 351, 1121, 449, 1246, 450, 1247, 544, 1404, 546, 1408, 639, 1248, 640, 1247, 767, 551, 767, 550, 737, 480, 737, 480, 798, 384, 798, 384, 737};
    private float borde2[] = new float[]{95, 397, 192, 397, 192, 266, 95, 266};
    private float borde3[] = new float[]{95, 591, 191, 591, 191, 460, 95, 460};
    private float borde4[] = new float[]{255, 266, 255, 400, 352, 400, 352, 266};
    private float borde5[] = new float[]{255, 459, 255, 590, 352, 590, 352, 459};
    private float borde6[] = new float[]{510, 267, 510, 399, 607, 399, 607, 267};
    private float borde7[] = new float[]{510, 459, 510, 592, 608, 592, 608, 459};
    private float borde8[] = new float[]{671, 266, 671, 397, 767, 397, 767, 266};
    private float borde9[] = new float[]{671, 460, 671, 590, 768, 590, 768, 460};
    private ArrayList<float[]> colisiones_bordes;
    private ArrayList<Polygon> colisiones;

    private float salida1[] = new float[]{390, 800, 474, 800, 474, 798, 390, 798};
    private float salida2[] = new float[]{0, 204, 0, 729, 2, 792, 2, 204};
    private ArrayList<Polygon> colisiones_salidas;
    private ArrayList<float[]> puntos_salidas;
    
    //plaza central 
    private float mapas[] = new float[]{0, 8};
    private float coord[] = new float[]{0, 0, 1438, 0};
    
    private ArrayList<WanderTipoT> personajes = new ArrayList<>(); 
    
    public Mapa4() {
        super();
        
        colisiones_bordes = new ArrayList<>();
        colisiones        = new ArrayList<>();

        colisiones_bordes.add(borde1);
        colisiones_bordes.add(borde2);
        colisiones_bordes.add(borde3);
        colisiones_bordes.add(borde4);
        colisiones_bordes.add(borde5);
        colisiones_bordes.add(borde6);
        colisiones_bordes.add(borde7);
        colisiones_bordes.add(borde8);
        colisiones_bordes.add(borde9);

        for (int i = 0; i < colisiones_bordes.size(); i++) {
            bordes = new Polygon(colisiones_bordes.get(i));
            colisiones.add(bordes);
        }

        puntos_salidas     = new ArrayList<>();
        colisiones_salidas = new ArrayList<>();

        puntos_salidas.add(salida1);
        puntos_salidas.add(salida2);

        for (int i = 0; i < puntos_salidas.size(); i++) {
            bordes = new Polygon(puntos_salidas.get(i));
            colisiones_salidas.add(bordes);
        }
    }

    public void setCoordX(int x, int y) {
        coord[2 * x] = y;
    }

    public void setCoordY(int x, int y) {
        coord[(2 * x) + 1] = y;
    }

    public float[] getCoord() {
        return coord;
    }
    
    public ArrayList<Polygon> getBordes() {
        return colisiones;
    }

    public ArrayList<Polygon> getSalidas() {
        return colisiones_salidas;
    }
    
    public ArrayList<WanderTipoT> getPersonajes() {
        return personajes;
    }
    
    public String getMapa() {
        return mapa;
    }

    public float getMapas(int salida) {
        return mapas[salida];
    }
}
