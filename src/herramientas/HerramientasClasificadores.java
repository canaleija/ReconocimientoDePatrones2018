/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramientas;

import java.util.ArrayList;
import objetos.DistanciaKnn;
import objetos.Patron;

/**
 *
 * @author Roberto Cruz Leija
 */
public class HerramientasClasificadores {
    
    
    public static double calcularDistEucli(Patron p, Patron q){
        double res = 0;
        for (int j = 0; j<p.getCaracteristicas().length;j++){
            res+=Math.pow(p.getCaracteristicas()[j]-q.getCaracteristicas()[j],2);
        }
        
        return Math.sqrt(res);
    }
    
    public static void ordenar(ArrayList<DistanciaKnn> distancias){
        DistanciaKnn temp = null;
        for (int i=1; i< distancias.size(); i++){
             for(int j=0; j<distancias.size()- i; j++) {
                 if (distancias.get(j).getDistancia()
                         >distancias.get(j+1).getDistancia()){
                 // se genera un intercambio
                  temp = new DistanciaKnn(distancias.get(j).getDistancia()
                         ,distancias.get(j).getClaseVecino());
                 //lista[j] = lista[j+1];
                  distancias.get(j).setDistancia(distancias.get(j+1).getDistancia());
                  distancias.get(j).setClaseVecino(distancias.get(j+1).getClaseVecino());
                 //  lista[j+1] = temp;
                  distancias.get(j+1).setDistancia(temp.getDistancia());
                  distancias.get(j+1).setClaseVecino(temp.getClaseVecino());
                  
             
                 }
                
          }

        }
      //System.out.println("Termina Ordenamiento "+c++);
    }
}
