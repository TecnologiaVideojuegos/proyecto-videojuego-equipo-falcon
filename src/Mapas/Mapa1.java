/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapas;

import Personajes.PersonajeUpDown;
import Personajes.PersonajeCirculoR;
import Personajes.PersonajeCirculoL;
import Personajes.PersonajeEstatico;
import Personajes.PersonajeEstaticoA;
import Personajes.PersonajeGeneral;
import java.util.ArrayList;
import org.newdawn.slick.geom.Polygon;

/**
 *
 * @author lucas
 * @mapa plaza central
 */
public class Mapa1 extends MapaT {

    private final String mapa = "\\Mapas\\mapa1.tmx";

    private Polygon bordes = new Polygon();

    private final float borde1[] = new float[]{0, 800, 383, 800, 383, 769, 383, 737, 319, 737, 255, 737, 255, 705, 223, 705, 191, 705, 191, 673, 159, 673, 159, 641, 127, 641, 127, 609, 127, 577, 95, 577, 95, 545, 95, 513, 95, 449, 63, 449, 31, 449, 0, 449, 0, 351, 31, 351, 63, 351, 95, 351, 95, 289, 95, 225, 127, 225, 127, 193, 127, 161, 159, 161, 159, 129, 191, 129, 191, 97, 223, 97, 255, 97, 255, 65, 287, 65, 319, 65, 351, 65, 383, 65, 383, 0, 0, 0};
    private final float borde2[] = new float[]{479, 0, 479, 64, 607, 64, 607, 96, 671, 96, 671, 128, 703, 128, 703, 160, 735, 160, 735, 224, 767, 224, 767, 352, 799, 352, 799, 320, 863, 320, 863, 160, 1151, 160, 1183, 192, 1247, 192, 1247, 160, 1407, 160, 1407, 256, 1247, 256, 1247, 352, 1119, 352, 1119, 448, 1247, 448, 1247, 544, 1407, 544, 1407, 640, 1247, 640, 1247, 800, 768, 800, 768, 768, 768, 736, 800, 736, 800, 704, 832, 704, 832, 639, 864, 639, 864, 478, 800, 478, 800, 447, 768, 447, 768, 575, 736, 575, 736, 639, 704, 639, 704, 671, 672, 671, 672, 703, 608, 703, 608, 735, 480, 735, 480, 800, 1504, 800, 1504, 0};
    private final float borde3[] = new float[]{400,415,400,370,460,370,460,415};
    private final ArrayList<float[]> puntos_bordes;
    private final ArrayList<Polygon> colisiones_bordes;

    private final float salida1[] = new float[]{390, 0, 474, 0, 474, 2, 390, 2};
    private final float salida2[] = new float[]{390, 800, 474, 800, 474, 798, 390, 798};
    private final float salida3[] = new float[]{0, 353, 0, 445, 2, 445, 2, 353};
    private final float salida4[] = new float[]{776, 798, 1241, 798, 1241, 800, 776, 800};
    private final ArrayList<float[]> puntos_salidas;
    private final ArrayList<Polygon> colisiones_salidas;

    //plaza arriba - plaza abajo - plaza izquierda - plaza abajo
    private final float mapas[] = new float[]{3, 4, 7, 4};
    private final float coordenadas_aparicion[] = new float[]{0, 720, 0, 0, 1438, 0, 0, 0};

    private final ArrayList<PersonajeGeneral> personajes = new ArrayList<>();
    PersonajeUpDown marinero1 = new PersonajeUpDown(1160, 480,"M1","Marinero");
    PersonajeEstaticoA marinero2 = new PersonajeEstaticoA("left", 920, 150,"T0","Tendero3");
    PersonajeEstaticoA marinero3 = new PersonajeEstaticoA("right", 880, 150,"T3","Tendero4");
    PersonajeEstatico marinero4 = new PersonajeEstatico("up", 1050, 130,"M3","Marinero");
    PersonajeCirculoR anciano1 = new PersonajeCirculoR(580, 350,"V0","Anciano2");
    PersonajeCirculoL anciano2 = new PersonajeCirculoL(200, 300,"V1","Anciano1");
    
    

    public Mapa1() {
        super();

        personajes.add(marinero1);
        personajes.add(marinero2);
        personajes.add(marinero3);
        personajes.add(marinero4);
        personajes.add(anciano1);
        personajes.add(anciano2);
        
        puntos_bordes     = new ArrayList<>();
        colisiones_bordes = new ArrayList<>();

        puntos_bordes.add(borde1);
        puntos_bordes.add(borde2);
        puntos_bordes.add(borde3);

        for (int i = 0; i < puntos_bordes.size(); i++) {
            bordes = new Polygon(puntos_bordes.get(i));
            colisiones_bordes.add(bordes);
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
