/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;

/**
 *
 * @author lucas
 */
public class Marcador {
    private int a=0;
    private int max=0;
    public Marcador(int max) {
        this.max=max;
    }
    
    public int getMarcador()
    {
        return a;
    }
    
    public void setMarcador(int b)
    {
        a=a+b;
        if(a<0)
        {
            a=0;
        }
        if(a>max)
        {
            a=max;
        }
    }
    
}
