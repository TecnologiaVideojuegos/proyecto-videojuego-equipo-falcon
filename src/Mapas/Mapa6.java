/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapas;

import Personajes.PersonajeEstatico;
import Personajes.PersonajeProfesor;
import Personajes.PersonajeGeneral;
import java.util.ArrayList;
import org.newdawn.slick.geom.Polygon;

/**
 *
 * @author lucas
 * @mapa zona boss 1
 */
public class Mapa6 extends MapaT {

    private String mapa = "\\Mapas\\mapa6.tmx";
    
    private Polygon bordes = new Polygon();
    
    private float borde1[] = new float[]{63, 0, 256, 0, 256, 33, 985, 33, 985, 65, 1027, 65, 1027, 36, 1180, 36, 1180, 68, 1218, 68, 1218, 141, 1242, 164, 1242, 200, 1282, 200, 1282, 186, 1402, 186, 1433, 223, 1469, 223, 1469, 778, 1091, 778, 1091, 741, 1184, 738, 1184, 671, 1153, 671, 1153, 700, 1058, 700, 1058, 733, 1020, 733, 1020, 785, 35, 785, 35, 32, 65, 32};
    private ArrayList<float[]> colisiones_bordes;
    private ArrayList<Polygon> colisiones;

    private float salida1[] = new float[]{66, 2, 252, 2, 252, 0, 66, 0};
    private ArrayList<float[]> puntos_salidas;
    private ArrayList<Polygon> colisiones_salidas;
    
    PersonajeProfesor profesor = new PersonajeProfesor();

    //plaza abajo
    private float mapas[] = new float[]{4};
    private float coord[] = new float[]{0, 720};
    
    private ArrayList<PersonajeGeneral> personajes = new ArrayList<>();
   
    PersonajeEstatico niño1  = new PersonajeEstatico("up"   , 970, 680, "N1","Niño1");
    PersonajeEstatico niño2  = new PersonajeEstatico("up"   , 930, 680, "N2","Niño2");
    PersonajeEstatico niño3  = new PersonajeEstatico("up"   , 890, 680, "N3","Niño3");
    PersonajeEstatico niño4  = new PersonajeEstatico("left" , 850, 680, "N4","Niño4");
    PersonajeEstatico niño5  = new PersonajeEstatico("left" , 810, 680, "N5","Niño5");
    PersonajeEstatico niño6  = new PersonajeEstatico("up"   , 770, 680, "N6","Niño6");
    PersonajeEstatico niño7  = new PersonajeEstatico("right", 730, 680, "N7","Niño7");
    PersonajeEstatico niño8  = new PersonajeEstatico("left" , 690, 680, "N8","Niño8");
    PersonajeEstatico niño9  = new PersonajeEstatico("left" , 650, 680, "N9","Niño9");
    PersonajeEstatico niño10 = new PersonajeEstatico("up"   , 610, 680, "N10","Niño10");
    PersonajeEstatico niño11 = new PersonajeEstatico("right", 570, 680, "N11","Niño11");
    PersonajeEstatico niño12 = new PersonajeEstatico("left" , 530, 680, "N12","Niño4");
    PersonajeEstatico niño13 = new PersonajeEstatico("right", 490, 680, "N13","Niño1");
    PersonajeEstatico niño14 = new PersonajeEstatico("left" , 450, 680, "N2","Niño8");
    
    
    public Mapa6() {
        super();
        colisiones_bordes = new ArrayList<>();
        colisiones        = new ArrayList<>();

        colisiones_bordes.add(borde1);

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
        profesor.noLanza();
        personajes.add(profesor);
        personajes.add(niño1);
        personajes.add(niño2);
        personajes.add(niño3);
        personajes.add(niño4);
        personajes.add(niño5);
        personajes.add(niño6);
        personajes.add(niño7);
        personajes.add(niño8);
        personajes.add(niño9);
        personajes.add(niño10);
        personajes.add(niño11);
        personajes.add(niño12);
        personajes.add(niño13);
        personajes.add(niño14);
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
