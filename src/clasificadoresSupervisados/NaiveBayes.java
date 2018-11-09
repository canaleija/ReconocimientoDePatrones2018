/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificadoresSupervisados;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import objetos.ClaseBayes;
import objetos.Patron;

/**
 *
 * @author Roberto Cruz Leija
 */
public class NaiveBayes implements ClasificadorSupervisado{

    private ArrayList<Patron> instancias;
    private double[][] matrizMedias;
    private double[][] matrizVarianzas;
    private double[][] matrizDistribuciones;
    private double[] probPriori;
    private double[] probPosteriori;
    private Map<String,ClaseBayes> clases;
    

    public NaiveBayes() {
        this.clases = new HashMap<String,ClaseBayes>();
    }
    
    
    
    @Override
    public void entrena(ArrayList<Patron> instancias) {
        this.instancias = instancias;
        // calcular la probabildiad a priori por cada clase
        this.clases.put(this.instancias.get(0).getClaseOriginal(),new ClaseBayes(this.instancias.get(0).getClaseOriginal()));
        
        // recorrer las instancias 
        for(Patron patron: instancias){
            // verifiar si existe una ClaseBayes con el nombre de la clase del patron
            if(!this.clases.containsKey(patron.getClaseOriginal())){
               // si lo contiene lo acumula 
               this.clases.put(patron.getClaseOriginal(),new ClaseBayes(patron.getClaseOriginal()));
                          }
             this.clases.get(patron.getClaseOriginal()).acumularAMedia(patron.getCaracteristicas());
        }
       
        for(Entry<String,ClaseBayes> aux: this.clases.entrySet()){
            aux.getValue().calcularMedia();
            // aprovechando el ciclo for calculamos el apriori
            aux.getValue().calcularApriori(instancias.size());
        }
        // calculamos las varianzas
        for(Patron patron: instancias){
            // verifiar si existe una ClaseBayes con el nombre de la clase del patron
            String clase = patron.getClaseOriginal();
            this.clases.get(clase).calcularVarianza(patron.getCaracteristicas());
            
        }
               
    }

    @Override
    public void clasifica(Patron patron) {
       // recibir el patron a clasificar 
       double[][] distribucion = 
          new double[this.clases.size()][patron.getCaracteristicas().length];
       // calcular una matriz de distribuciones normales parametrizadas
       int r = 0;
       for(Entry<String,ClaseBayes> aux: this.clases.entrySet()){
           Patron media = aux.getValue().getMedia();
           Patron varianza = aux.getValue().getVarianza();
           for(int c=0;c<patron.getCaracteristicas().length;c++){
           distribucion[r][c]= calcularDN(patron.getCaracteristicas()[c],media.getCaracteristicas()[c],varianza.getCaracteristicas()[c]);
           }
           r++;
       }
       System.out.println();
       // evidencia
       // calculan las probabilidades a posteriori
       // el argumento maximo de las a posteriori define la clase resultante 
       
    }

    private double calcularDN(double c, double m, double v) {
        double aux = -1.0*(Math.pow(c-m,2)/2.0*v);
        double res = (1.0/Math.sqrt(2*Math.PI*v))*Math.exp(aux);
         
        return res;
     
    }
    
}
