/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author arser
 */
public class objetito extends Thread{
    
    int i = 0;
    static int mayor = 0;
    static int cantProcesos = 0;
    boolean ejecutando = true;
    
    
    
    public void run(){
        iniciar();
    }
    
    public void iniciar(){
        boolean eject = true;
        while(eject){
            i = generarNumeroAleatorio();
            compararMayor(i);
        }
    }
    
    public void detener(){
        ejecutando = false;
    }
    
    public void incrementar(){
        boolean continuar = true;
        while(continuar){
            i++;
        }
    }
    
    static public int getMayor(){
        int resul = mayor;
        return resul;
    }
    
    public int getI(){
        int resul = i;
        return resul;
    }
    
    public boolean getEjecutando(){
        boolean resul = ejecutando;
        return resul;
    }
    
    static void compararMayor(int pi){
        if(pi > mayor){
            mayor = pi;
        }
    }
    
     static int generarNumeroAleatorio(){
        int rnd = (int) (Math.random() * 1000000000);
        return rnd;
    }
    
    
    
    
    
}
