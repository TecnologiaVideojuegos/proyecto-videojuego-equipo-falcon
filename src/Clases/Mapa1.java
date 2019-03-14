/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import org.newdawn.slick.geom.Polygon;

/**
 *
 * @author lucas
 */
public class Mapa1 {
    
    private String  mapa = "C:\\Users\\lucas\\Documents\\NetBeansProjects\\VideoGame\\mapa1.tmx";
    
    private float   puntos1[] = new float[]{0,800,383,800,383,769,383,737,319,737,255,737,255,705,223,705,191,705,191,673,159,673,159,641,127,641,127,609,127,577,95,577,95,545,95,513,95,449,63,449,31,449,0,449,0,351,31,351,63,351,95,351,95,289,95,225,127,225,127,193,127,161,159,161,159,129,191,129,191,97,223,97,255,97,255,65,287,65,319,65,351,65,383,65,383,0,0,0};
    private float   puntos2[] = new float[]{479,0,479,64,607,64,607,96,671,96,671,128,703,128,703,160,735,160,735,224,767,224,767,352,799,352,799,320,863,320,863,160,1151,160,1183,192,1247,192,1247,160,1407,160,1407,256,1247,256,1247,352,1119,352,1119,448,1247,448,1247,544,1407,544,1407,640,1247,640,1247,800,768,800,768,768,768,736,800,736,800,704,832,704,832,639,864,639,864,478,800,478,800,447,768,447,768,575,736,575,736,639,704,639,704,671,672,671,672,703,608,703,608,735,480,735,480,800,1504,800,1504,0};
    private Polygon bordes [] = new Polygon[20];
    
    private float   puntos3[] = new float[]{390,0,474,0,474,2,390,2};
    private float   puntos4[] = new float[]{390,800,474,800,474,798,390,798};
    private Polygon salidas[] = new Polygon[4];
    
    private float   mapas[] = new float[]{0,1,2,3};
    private float   coord[] = new float[]{0,0,0,0,0,0,0,0,0,0};
    
    public Mapa1() {
        
        bordes [0]= new Polygon(puntos1);
        bordes [1]= new Polygon(puntos2);
        
        salidas[0]= new Polygon(puntos3);
        salidas[1]= new Polygon(puntos4);
    }
    
    public Polygon[] getBordes() {
        return bordes;
    }

    public Polygon[] getSalidas() {
        return salidas;
    }

    public String getMapa() {
        return mapa;
    }

    public float getMapas(int salida) {
        return mapas[salida];
    }

    
}
