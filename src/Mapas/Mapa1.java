/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapas;

import Personajes.WanderTipo2;
import Personajes.WanderTipo3;
import Personajes.WanderTipo4;
import Personajes.WanderTipo5;
import Personajes.WanderTipoT;
import java.util.ArrayList;
import org.newdawn.slick.geom.Polygon;

/**
 *
 * @author lucas
 * @mapa plaza central
 */
public class Mapa1 extends MapaT {

    private String mapa = "\\Mapas\\mapa1.tmx";

    private Polygon bordes = new Polygon();

    private float borde1[] = new float[]{0, 800, 383, 800, 383, 769, 383, 737, 319, 737, 255, 737, 255, 705, 223, 705, 191, 705, 191, 673, 159, 673, 159, 641, 127, 641, 127, 609, 127, 577, 95, 577, 95, 545, 95, 513, 95, 449, 63, 449, 31, 449, 0, 449, 0, 351, 31, 351, 63, 351, 95, 351, 95, 289, 95, 225, 127, 225, 127, 193, 127, 161, 159, 161, 159, 129, 191, 129, 191, 97, 223, 97, 255, 97, 255, 65, 287, 65, 319, 65, 351, 65, 383, 65, 383, 0, 0, 0};
    private float borde2[] = new float[]{479, 0, 479, 64, 607, 64, 607, 96, 671, 96, 671, 128, 703, 128, 703, 160, 735, 160, 735, 224, 767, 224, 767, 352, 799, 352, 799, 320, 863, 320, 863, 160, 1151, 160, 1183, 192, 1247, 192, 1247, 160, 1407, 160, 1407, 256, 1247, 256, 1247, 352, 1119, 352, 1119, 448, 1247, 448, 1247, 544, 1407, 544, 1407, 640, 1247, 640, 1247, 800, 768, 800, 768, 768, 768, 736, 800, 736, 800, 704, 832, 704, 832, 639, 864, 639, 864, 478, 800, 478, 800, 447, 768, 447, 768, 575, 736, 575, 736, 639, 704, 639, 704, 671, 672, 671, 672, 703, 608, 703, 608, 735, 480, 735, 480, 800, 1504, 800, 1504, 0};
    private ArrayList<float[]> puntos_bordes;
    private ArrayList<Polygon> colisiones_bordes;

    private float salida1[] = new float[]{390, 0, 474, 0, 474, 2, 390, 2};
    private float salida2[] = new float[]{390, 800, 474, 800, 474, 798, 390, 798};
    private float salida3[] = new float[]{0, 353, 0, 445, 2, 445, 2, 353};
    private float salida4[] = new float[]{776, 798, 1241, 798, 1241, 800, 776, 800};
    private ArrayList<float[]> puntos_salidas;
    private ArrayList<Polygon> colisiones_salidas;
    private ArrayList<Polygon> salidas_modo2;

    private int modo = 0;

    //plaza arriba - plaza abajo - plaza izquierda - plaza abajo
    private float mapas[] = new float[]{3, 4, 7, 4};
    private float coordenadas_aparicion[] = new float[]{0, 720, 0, 0, 1438, 0, 0, 0};

    private ArrayList<WanderTipoT> personajes = new ArrayList<>();
    WanderTipo2 viejo1 = new WanderTipo2(1160, 480);
    WanderTipo3 viejo2 = new WanderTipo3("left", 920, 150);
    WanderTipo3 viejo3 = new WanderTipo3("right", 880, 150);
    WanderTipo4 viejo4 = new WanderTipo4(580, 350);
    WanderTipo5 viejo5 = new WanderTipo5(200, 300);

    public Mapa1() {
        super();

        personajes.add(viejo1);
        personajes.add(viejo2);
        personajes.add(viejo3);
        personajes.add(viejo4);
        personajes.add(viejo5);
        
        puntos_bordes     = new ArrayList<>();
        colisiones_bordes = new ArrayList<>();

        puntos_bordes.add(borde1);
        puntos_bordes.add(borde2);

        for (int i = 0; i < puntos_bordes.size(); i++) {
            bordes = new Polygon(puntos_bordes.get(i));
            colisiones_bordes.add(bordes);
        }

        puntos_salidas     = new ArrayList<>();
        colisiones_salidas = new ArrayList<>();
        salidas_modo2      = new ArrayList<>();

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
        coordenadas_aparicion[2 * x] = y;
    }

    public void setCoordY(int x, int y) {
        coordenadas_aparicion[(2 * x) + 1] = y;
    }

    public float[] getCoord() {
        return coordenadas_aparicion;
    }
    
    public ArrayList<Polygon> getBordes() {
        return colisiones_bordes;
    }

    public ArrayList<Polygon> getSalidas() {
        if (modo == 1) {
            return salidas_modo2;
        } else {
            return colisiones_salidas;
        }
    }
    
    public ArrayList<WanderTipoT> getPersonajes() {
        return personajes;
    }

    public void cMode() {
        modo = 2;
    }

    public String getMapa() {
        return mapa;
    }

    public float getMapas(int salida) {
        return mapas[salida];
    }
}
