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
public class Mapa8 extends MapaT {

    private String mapa = "\\Mapas\\mapa8.tmx";

    private Polygon bordes = new Polygon();
        
    private float borde1[] = new float[]{1504, 448, 1440, 448, 1440, 481, 1470, 481, 1470, 737, 1504, 737, 1504, 800, 32, 800, 32, 529, 72, 529, 72, 557, 149, 557, 149, 530, 198, 530, 198, 555, 276, 555, 276, 531, 287, 531, 287, 515, 320, 515, 320, 373, 287, 373, 287, 335, 196, 335, 196, 350, 150, 350, 150, 333, 62, 333, 62, 351, 21, 351, 21, 321, 0, 321, 0, 0, 30, 0, 32, 160, 255, 160, 255, 145, 284, 145, 284, 120, 257, 120, 257, 2, 639, 2, 639, 337, 615, 337, 615, 350, 568, 350, 568, 335, 480, 335, 480, 370, 448, 370, 448, 512, 480, 512, 480, 528, 487, 528, 487, 551, 565, 551, 565, 528, 623, 528, 623, 554, 690, 554, 690, 530, 744, 530, 744, 553, 812, 553, 812, 544, 864, 544, 864, 0, 1504, 0, 1504, 64, 1472, 64, 1472, 303, 1440, 303, 1440, 353, 1504, 353};
    private float borde2[] = new float[]{1372, 382, 1290, 382, 1290, 368, 1237, 368, 1237, 382, 1154, 382, 1154, 225, 1372, 225};
    private float borde3[] = new float[]{1116, 321, 1033, 321, 1033, 307, 981, 307, 981, 321, 898, 321, 898, 161, 1116, 161};
    private float borde4[] = new float[]{606, 257, 523, 257, 523, 243, 471, 243, 471, 257, 350, 257, 350, 232, 388, 232, 388, 97, 606, 97};
    private float borde5[] = new float[]{1278, 703, 1196, 703, 1196, 689, 1143, 689, 1143, 703, 927, 703, 927, 546, 1060, 546, 1278, 546};
    private float borde6[] = new float[]{895, 387, 895, 512, 1119, 512, 1119, 387};
    private ArrayList<float[]> colisiones_bordes;
    private ArrayList<Polygon> colisiones;

    private float salida1[] = new float[]{1238, 372, 1287, 372, 1287, 373, 1238, 373};
    private float salida2[] = new float[]{258, 3, 1500, 3, 1500, 2, 258, 2};
    private float salida3[] = new float[]{1503, 353, 1503, 445, 1502, 445, 1502, 353};
    private float salida4[] = new float[]{32,798,1501,798,1501,799,32,799};
    private ArrayList<float[]> puntos_salidas;
    private ArrayList<Polygon> colisiones_salidas;

    //casa - carretera arriba - plaza central - carretera abajo
    private float mapas[] = new float[]{1, 8, 0,9};
    private float coord[] = new float[]{825, 640, 0, 720, 0, 0, 0 ,0};
    
    private ArrayList<WanderTipoT> personajes = new ArrayList<>();
    
    
    public Mapa8() {
        super();
        colisiones_bordes = new ArrayList<>();
        colisiones        = new ArrayList<>();

        colisiones_bordes.add(borde1);
        colisiones_bordes.add(borde2);
        colisiones_bordes.add(borde3);
        colisiones_bordes.add(borde4);
        colisiones_bordes.add(borde5);
        colisiones_bordes.add(borde6);

        for (int i = 0; i < colisiones_bordes.size(); i++) {
            bordes = new Polygon(colisiones_bordes.get(i));
            colisiones.add(bordes);
        }

        puntos_salidas     = new ArrayList<>();
        colisiones_salidas = new ArrayList<>();

        puntos_salidas.add(salida1);
        puntos_salidas.add(salida2);
        puntos_salidas.add(salida3);
        puntos_salidas.add(salida4);

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