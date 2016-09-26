
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author arser
 */
public class objetito implements Runnable{
    
    private Thread t;
    private String threadName;
    int i = 0;
    static int mayor = 0;
    static int cantProcesos = 0;
    boolean ejecutando = false;
    
    
    public objetito(String pthreadName){
        threadName = pthreadName;
    }
    
    public void run(){
        this.ejecutando = true;
        while(ejecutando){
            try {
                i = generarNumeroAleatorio();
                compararMayor(i);
                Thread.sleep(3000);
                System.out.println("Esta vez salio " + i);
            } catch (InterruptedException ex) {
                Logger.getLogger(objetito.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean isEjecutando(){
        boolean resul = ejecutando;
        return resul;
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
