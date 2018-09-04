/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificadoresSupervisados;

import herramientas.HerramientasClasificadores;
import java.util.ArrayList;
import objetos.DistanciaKnn;
import objetos.Patron;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Knn implements ClasificadorSupervisado{

    private ArrayList<Patron> instancias;
    private ArrayList<String> clases;
    private ArrayList<DistanciaKnn> vecinos;
    private int k;
    private double eficacia;

    public Knn(int k) {
        this.k = k;
        this.clases = new ArrayList<>();
        this.vecinos = new ArrayList<>();
                
    }
    
    
    
    @Override
    public void entrena(ArrayList<Patron> instancias) {
        this.instancias = instancias;
        // verificar las clases involucradas
        
        for(Patron aux: this.instancias){
        if(!this.clases.contains(aux.getClaseOriginal())){
            this.clases.add(aux.getClaseOriginal());
        }
       
        } 
       
        
    }

    @Override
    public void clasifica(Patron patron) {
   this.vecinos = new ArrayList<>();
//calcular las distancias 
      for(Patron aux: this.instancias){
      String clase = aux.getClaseOriginal();
      double dist = 
              herramientas.HerramientasClasificadores
             .calcularDistEucli(patron, aux);
      if(dist!=0)
      this.vecinos.add(new DistanciaKnn(dist, clase));
      }
      //ordenar las distancias 
      HerramientasClasificadores.ordenar(this.vecinos);
      
      String resultado = verificarKvecinos();
      patron.setClaseResultante(resultado);
    }
    
    public void clasificaConjunto(ArrayList<Patron> instancias){
    // recorremos la coleccion a clasificar
        int total = instancias.size();
        // contador de clasificacion correctas
        int aux = 0;
        for (Patron patron: instancias){
            clasifica(patron);
            if(patron.getClaseResultante().equals(patron.getClaseOriginal()))aux++;
        }
       this.eficacia = aux*100/total;
    }

    private String verificarKvecinos() {
       int contadores[] = new int[this.clases.size()];
       int i = 0;
       for (DistanciaKnn aux: this.vecinos){
           String clase = aux.getClaseVecino();
           i = this.clases.indexOf(clase);
           contadores[i]++;
           // verificamos
           if(contadores[i]==this.k)
           return this.clases.get(i);   
       }
//       if(contadores[i]==this.k){
//        return this.clases.get(i);
//       }else{
//       // para este caso se retorna la clase con mayor
//       // numero de vecinos más cercanos
//       int max = 0;
//       for(int ii=1;ii<contadores.length;ii++){
//           if(contadores[ii]>contadores[max])
//               max = ii;
//       }
//        return this.clases.get(max);
//       }
    return "Desconocida";
    }

    /**
     * @return the eficacia
     */
    public double getEficacia() {
        return eficacia;
    }
    
}
