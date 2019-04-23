/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapas;

import Personajes.PersonajeGeneral;
import java.util.ArrayList;
import org.newdawn.slick.geom.Polygon;

/**
 *
 * @author lucas
 * @mapa colegio
 */
public class Mapa7 extends MapaT {

    private String mapa = "\\Mapas\\mapa7.tmx";
    
    private Polygon bordes = new Polygon();
    
    private float borde1[] = new float[]{477, 768, 477, 730, 417, 730, 417, 514, 405, 514, 405, 732, 287, 732, 287, 686, 193, 686, 193, 732, 128, 732, 128, 686, 41, 686, 41, 640, 128, 640, 128, 589, 41, 589, 41, 544, 126, 544, 126, 493, 40, 493, 40, 429, 153, 429, 153, 388, 102, 388, 102,
        353, 192, 353, 192, 363, 288, 363, 288, 353, 349, 353, 349, 373, 408, 373, 408, 448, 417, 448, 417, 352, 478, 352, 478, 321, 417, 321, 417, 225, 357, 225, 357, 288, 319, 288, 319, 225, 259, 225, 259, 288, 223, 288, 223, 226, 163, 226, 161, 288, 127,
        288, 127, 225, 69, 225, 69, 289, 40, 289, 40, 96, 70, 96, 70, 163, 100, 163, 100, 181, 127, 181, 127, 97, 165, 97, 165, 162, 197, 162, 197, 181, 224, 181, 224, 97, 260, 97, 260, 163, 292, 163, 292, 181, 319, 181, 319, 98, 357, 98, 357, 163, 389, 163, 389,
        181, 416, 181, 416, 97, 486, 97, 486, 171, 536, 171, 536, 132, 600, 132, 600, 318, 547, 318, 547, 350, 608, 350, 608, 256, 638, 256, 638, 225, 608, 225, 608, 98, 640, 98, 640, 125, 799, 125, 799, 97, 831, 97, 831, 117, 928, 117, 928, 97, 982, 97, 982,
        226, 706, 226, 706, 255, 992, 255, 992, 223, 1118, 223, 1118, 255, 1183, 255, 1183, 223, 1127, 223, 1127, 98, 1152, 98, 1152, 117, 1247, 117, 1247, 96, 1279, 96, 1279, 126, 1438, 126, 1438, 99, 1463, 99, 1463, 225, 1250, 225, 1250, 257, 1464, 257,
        1464, 449, 1090, 449, 1090, 480, 1146, 480, 1146, 739, 617, 739, 617, 697, 990, 697, 990, 508, 617, 508, 617, 474, 1020, 474, 1020, 449, 607, 449, 607, 733, 547, 733, 547, 768};
    private float borde2[] = new float[]{255,552,255,516,288,516,288,493,191,493,191,640,288,640,288,588,255,588};    
    private ArrayList<float[]> colisiones_bordes;
    private ArrayList<Polygon> colisiones;
    
    private float salida1[] = new float[]{477, 767, 545, 767, 445, 768, 577, 768};
    private ArrayList<float[]> puntos_salidas;
    private ArrayList<Polygon> colisiones_salidas;

    //plaza abajo
    private float mapas[] = new float[]{4};
    private float coord[] = new float[]{418, 605};   
    
    private ArrayList<PersonajeGeneral> personajes = new ArrayList<>(); 
    

    public Mapa7() {
        super();

        colisiones_bordes = new ArrayList<>();
        colisiones        = new ArrayList<>();

        colisiones_bordes.add(borde1);
        colisiones_bordes.add(borde2);

        for (int i = 0; i < colisiones_bordes.size(); i++) {
            bordes = new Polygon(colisiones_bordes.get(i));
            colisiones.add(bordes);
        }

        puntos_salidas     = new ArrayList<>();
        colisiones_salidas = new ArrayList<>();

        puntos_salidas.add(salida1);

        for (int i = 0; i < puntos_salidas.size(); i++) {
            bordes = new Polygon(puntos_salidas.get(i));
            colisiones_salidas.add(bordes);
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

    public float[] getCoord() {
        return coord;
    }
    
    public ArrayList<Polygon> getBordes() {
        return colisiones;
    }
    
    public ArrayList<Polygon> getSalidas() {
        return colisiones_salidas;
    }
    
    public ArrayList<PersonajeGeneral> getPersonajes() {
        return personajes;
    }

    public String getMapa() {
        return mapa;
    }

    public float getMapas(int salida) {
        return mapas[salida];
    }
}
