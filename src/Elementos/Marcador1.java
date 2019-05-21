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
public class Marcador1 {
    int a=0;
    int max=0;
    public Marcador1(int max) {
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
