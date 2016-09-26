import java.io.*;
import javax.swing.*;

public class Hilos{
        
    static boolean proseguir = true;
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    static int maxThreads;
    static objetito[] objetos;
    static int cantThreads = 0;
    static int threadSeleccionado = -1;
    
    
    
   public static void main(String[] args)throws java.io.IOException{
       boolean cantThreadsValido = true;
       do{
           cantThreadsValido = true;
           try{
                out.println("Digite la cantidad de Threads que desea crear");
                maxThreads = Integer.parseInt(in.readLine());
                if(maxThreads < 0){
                    out.println("Digite un numero positivo");
                    cantThreadsValido = false;
                }
           }catch(Exception e){
               out.println("ingrese un valor valido por favor");
               cantThreadsValido = false;
           }
       }while(!cantThreadsValido);
       objetos = new objetito[maxThreads];
       for(int i = 0; i < maxThreads; i++){
           crearThread(i);
       }
       int accion = -1;
       do{
       out.println("Listo para ejecutar.");
       out.println("");
       out.println("Digite 1 para seleccionar un thread");
       out.println("Digite 2 para arrancar el thread");
       out.println("Digite 3 para detener el thread");
       out.println("Digite 4 para detener todo");
       out.println("Digite 5 para iniciar todo");
       out.println("Digite 6 para Conocer el estado de un thread");
       out.println("Digite 7 para terminar el programa y ver el resultado");       
            accion = Integer.parseInt(in.readLine());
            switch(accion){
                case 1:
                    seleccionarThread();
                    break;
                case 2:
                    ejecutarThread(threadSeleccionado);
                    break;
                case 3:
                    detenerThread(threadSeleccionado);
                    break;
                case 4:
                    detenerTodo();
                    break;
                case 5:
                    iniciarTodo();
                    break;
                case 6:
                    conocerStatusThread();
                    break;
                case 7:
                    detenerTodo();
                    obtenerResultado();
                    desplegarDespedida();
                    break;
            }
       }while(accion != 7);
   }
   
   public static void crearThread(int pindice){
       objetos[cantThreads] = new objetito("Cuack");
       out.println("Thread " + pindice + " creado.");
       cantThreads++;
   }
   
   public static void detenerTodo(){
       for(int i = 0; i < cantThreads; i++){
           detenerThread(i);
       }
   }
   
   public static void iniciarTodo(){
       for(int i = 0; i < cantThreads; i++){
           ejecutarThread(i);
           out.println("Thread " + i + "iniciado");
       }
   }
   
   public static void seleccionarThread()throws java.io.IOException{
        out.println("Digite el numero de thread que desea seleccionar");
        int i = 0;
        while(i < cantThreads){
            out.println("Digite " + i + " para seleccionar el thread " + i);
            i++;
        }
        
        int select = -1;
        do{
            select = Integer.parseInt(in.readLine());
            if(select < 0 || select > i){
                out.println("Digite un thread válido");
            }
        }while(select < 0 || select > maxThreads);
        threadSeleccionado = select;
   }
   
   public static void ejecutarThread(int pthread){
       objetos[pthread].iniciar();   
       out.println("El thread " + pthread + " se ha iniciado");
   }
   
   public static void verEstadoThread(){
       boolean estado = objetos[threadSeleccionado].isAlive();
       if(estado){
           out.println("El thread " + threadSeleccionado + " está corriendo");
       }else{
           out.println("El thread " + threadSeleccionado + " no se está ejecutando");
       }
   }
   
   public static void detenerThread(int pThread){
       objetos[pThread].detener();
       
   }
   
   public static void desplegarDespedida(){
       out.println("Gracias. Hasta pronto");
   }
   
   public static void obtenerResultado(){
       int max = objetito.getMayor();
       out.println("El mayor generado fue " + max);
   }
   
   public static void conocerStatusThread()throws java.io.IOException{
       out.println("Digite el thread del cual quiere ver el status.");
       out.println(maxThreads -1 + " maximo");
       int indice = Integer.parseInt(in.readLine());
       boolean status = objetos[indice].isAlive();
       String estado;
       if(status){
           estado = "corriendo";
       }else{
           estado = "apagado";
       }
       out.println();
       out.println("El thread " + indice + " esta " + estado);
       
   }
   
}