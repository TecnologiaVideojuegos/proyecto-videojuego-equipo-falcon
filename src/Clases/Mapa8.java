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
 * @mapa carretera central
 * 
 */
public class Mapa8 extends MapaT{
    
    private String  mapa = "mapa8.tmx";
    
    private float   puntos1 []  = new float[]{1504,448,1440,448,1440,481,1470,481,1470,737,1504,737,1504,800,0,800,0,547,23,547,23,529,72,529,72,557,149,557,149,530,198,530,198,555,276,555,276,531,287,531,287,515,320,515,320,373,287,373,287,335,196,335,196,350,150,350,150,333,62,333,62,351,21,351,21,321,0,321,0,0,30,0,32,160,255,160,255,145,284,145,284,120,257,120,257,2,639,2,639,337,615,337,615,350,568,350,568,335,480,335,480,370,448,370,448,512,480,512,480,528,487,528,487,551,565,551,565,528,623,528,623,554,690,554,690,530,744,530,744,553,812,553,812,544,864,544,864,0,1504,0,1504,64,1472,64,1472,303,1440,303,1440,353,1504,353};
    private float   puntos2 []  = new float[]{1372,382,1290,382,1290,368,1237,368,1237,382,1154,382,1154,225,1372,225};
    private float   puntos3 []  = new float[]{1116,321,1033,321,1033,307,981,307,981,321,898,321,898,164,1116,164};
    private float   puntos4 []  = new float[]{606,257,523,257,523,243,471,243,471,257,350,257,350,232,388,232,388,100,606,100};
    private float   puntos5 []  = new float[]{1278,703,1196,703,1196,689,1143,689,1143,703,927,703,927,546,1060,546,1278,546};
    private float   puntos6 []  = new float[]{895,387,895,512,1119,512,1119,387};
    private float   puntos7 []  = new float[]{0,0,0,0,0,0,0,0};
    private float   puntos8 []  = new float[]{0,0,0,0,0,0,0,0};
    private float   puntos9 []  = new float[]{0,0,0,0,0,0,0,0};
    
    private Polygon bordes [] = new Polygon[20];
    
    private float   puntos21[] = new float[]{390,800,474,800,474,798,390,798};
    private float   puntos22[] = new float[]{0,204,0,729,2,792,2,204};
    private float   puntos23[] = new float[]{0,0,0,0,0,0,0,0};
    private float   puntos24[] = new float[]{0,0,0,0,0,0,0,0};
    
    private Polygon salidas[] = new Polygon[4];
    //plaza central 
    private float   mapas[] = new float[]{0,1,2,3};
    private float   coord[] = new float[]{0,0,64,0,0,0,0,0,0,0};

    public Mapa8() {
        super();
        /*for(int i=0;i<puntos2.length;i++)
        {
            if(i%2==0)
            {
                puntos5[i]=puntos2[i]-94;
            }
            else
                puntos5[i]=puntos2[i]+(321);
            System.out.println((int)puntos5[i]+",");
        }*/
        bordes[0]  = new Polygon(puntos1);
        bordes[1]  = new Polygon(puntos2);
        bordes[2]  = new Polygon(puntos3);
        bordes[3]  = new Polygon(puntos4);
        bordes[4]  = new Polygon(puntos5);
        bordes[5]  = new Polygon(puntos6);
        bordes[6]  = new Polygon(puntos7);
        bordes[7]  = new Polygon(puntos8);
        bordes[8]  = new Polygon(puntos9);
        
        salidas[0] = new Polygon(puntos21);
        salidas[1] = new Polygon(puntos22);
        salidas[2] = new Polygon(puntos23);
        salidas[3] = new Polygon(puntos24);
    }
    
      public void setCoordX(int x,int y)
    {
        coord[2*x]=y;
    }
    
    public void setCoordY(int x,int y)
    {
        coord[(2*x)+1]=y;
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

    public float[] getCoord() {
        return coord;
    }

    
}
