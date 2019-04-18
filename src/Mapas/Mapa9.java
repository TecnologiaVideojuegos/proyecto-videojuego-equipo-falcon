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
 * @mapa carretera central
 *
 */
public class Mapa9 extends MapaT {

    private String mapa = "\\Mapas\\mapa9.tmx";

    private Polygon bordes = new Polygon();
        
    private float borde1[] = new float[]{1504, 36, 1504, 800, 865, 800, 865, 94, 1056, 94, 1056, 36};
    private float borde2[] = new float[]{640, 800, 257, 800, 257, 763, 30, 763, 30, 451, 98, 451, 98, 480, 126, 480, 126, 448, 192, 448, 192, 480, 222, 480, 222, 448,        335, 448, 335, 382, 415, 382, 415, 354, 451, 354, 451, 318, 416, 318, 416, 286, 559, 286, 559, 35, 640, 35};
    private float borde3[] = new float[]{1342, 640, 993, 640, 993, 352, 1342, 352};
    private ArrayList<float[]> colisiones_bordes;
    private ArrayList<Polygon> colisiones;

    private float salida1[] = new float[]{258, 797, 1500, 797, 1500, 798, 258, 798};
    private float salida2[] = new float[]{1503, 204, 1503, 800, 1502, 800, 1502, 204};
    private ArrayList<float[]> puntos_salidas;
    private ArrayList<Polygon> colisiones_salidas;

    //carretera central - plaza arriba
    private float mapas[] = new float[]{7, 3};
    private float coord[] = new float[]{0, 0, 0, 0};
    
    private ArrayList<WanderTipoT> personajes = new ArrayList<>(); 
    
    public Mapa9() {
        super();
        colisiones_bordes = new ArrayList<>();
        colisiones        = new ArrayList<>();

        colisiones_bordes.add(borde1);
        colisiones_bordes.add(borde2);
        colisiones_bordes.add(borde3);

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
