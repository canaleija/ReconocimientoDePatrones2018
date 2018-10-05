/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificacionnosupervisada;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import objetos.Patron;

/**
 *
 * @author Roberto Cruz Leija
 */
public class CMeans {
    // conjunto de instancias
    private ArrayList<Patron> instancias;
    // numero de clusters
    private int c;
    // centroidesIniciales 
    private ArrayList<Patron[]> centroides;
    int[] contadores;  
    public CMeans(ArrayList<Patron> instancias, int c) {
        this.instancias = instancias;
        this.centroides = new ArrayList<>();
        this.c = c;
    }
    
    public void clasifica(){
     // generar mis centroidesIniciales iniciales aleatorios 
     Random ran = new Random();
     Patron[] centroidesIniciales = new Patron[c];
     for (int x=0; x < this.c;x++){
       int pos = ran.nextInt(this.instancias.size());
       centroidesIniciales[x] = new Patron(this.instancias.get(pos).getCaracteristicas().clone(),"Centroide"+x);
     }
     // agregamos a la coleccion de centroidesIniciales los centroidesIniciales iniciales
     this.getCentroides().add(centroidesIniciales);
     calcularClusters();
    }
       
    
    public void clasifica(Patron[] centroidesIniciales){
     this.getCentroides().add(centroidesIniciales);
     calcularClusters();
    }
       
   
    private void calcularClusters (){
    
     // etiquetar por primera ocasiÃ³n (clasificar por primera ocasiÃ³n)
     etiquetar(this.centroides.get(0));
     // generar un proceso iterativo 
     // que modifique o ajuste los centroidesIniciales
     int contador = 0;
     
     do {
        // recalcular centroidesIniciales
        // necesitamos donde acumular 
        Patron[] centroidesNuevos = new Patron[c];
        contadores = new int[c];
        inicializarNuevosCentroides(centroidesNuevos);
        // acumulamos(recorrer todas las instancias) 
        for (Patron instancia: this.instancias){
            String nombreCluster = instancia.getClaseOriginal();
            forCentroides: for (int x=0; x < centroidesNuevos.length;x++){
             if (centroidesNuevos[x].getClaseOriginal().equals(nombreCluster)){
               centroidesNuevos[x].setCaracteristicas(sumaVectores(centroidesNuevos[x].getCaracteristicas(),instancia.getCaracteristicas()));
               contadores[x]++;
               break forCentroides;
             }
            }
        }
        // agregar los centroidesIniciales a la coleccion
        this.getCentroides().add(centroidesNuevos);
        // dividimos 
        dividirUltimosCentroides(contadores);
                
        // re etiquetar 
       etiquetar(this.getCentroides().get(this.getCentroides().size()-1));
       System.out.println(contador++);
      
     }while (!verificaCentroides()&&contador<500);
        
    
    }
    
    private void etiquetar (Patron[] centroides){
    // recorrer las instancias y etiquetar 
    // cada una de ellas en base a distancias
    for (Patron patron: this.instancias){
       double menor = herramientas.HerramientasClasificadores.calcularDistEucli(patron,centroides[0]);
       patron.setClaseOriginal(centroides[0].getClaseOriginal());
       for (int x=1; x < this.c; x++){
       // calculamos distancias
       double dist = herramientas.HerramientasClasificadores.calcularDistEucli(patron,centroides[x]);
       if (dist< menor){
       menor = dist;
       patron.setClaseOriginal(centroides[x].getClaseOriginal());
       }
       }
      
    }
  
    }

    private boolean verificaCentroides() {
        // verificar si los centroidesIniciales nuevos
        // son iguales a los anteriores
       int numCentroides = this.getCentroides().size();
       Patron[] ultimo = this.getCentroides().get(numCentroides-1);
       Patron[] penultimo = this.getCentroides().get(numCentroides-2);
       for (int x=0; x < ultimo.length;x++){
           if (!ultimo[x].equals(penultimo[x]))
               return false;
       }
       System.out.println("Convergen los centroides!");
       return true;
    }

    
    private void inicializarNuevosCentroides(Patron[] centroidesNuevos) {
      // recorro el arreglo 
      for (int x=0; x < centroidesNuevos.length;x++){
        centroidesNuevos[x] = new Patron(new double[this.instancias.get(0).getCaracteristicas().length],this.getCentroides().get(this.getCentroides().size()-1)[x].getClaseOriginal());
      }
    }

    private double[] sumaVectores(double[] vector, double[] vector0) {
       double aux[] = new double[vector.length];
       for (int x=0; x < aux.length;x++)
           aux[x] = vector[x]+vector0[x];
       
       return aux;
    }

    private void dividirUltimosCentroides(int[] contadores) {
        Patron[] aux = this.getCentroides().get(this.getCentroides().size()-1);
        
        for (int x=0; x < aux.length;x++){
         double[] vector = aux[x].getCaracteristicas();
          for (int y=0;y<vector.length;y++){
           vector[y]/=contadores[x];
          }
        }
          
    }

    /**
     * @return the centroidesIniciales
     */
    public ArrayList<Patron[]> getCentroides() {
        return centroides;
    }
    
    
    
    
}
