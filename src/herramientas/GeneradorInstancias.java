/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramientas;

import java.util.ArrayList;
import objetos.Patron;

/**
 *
 * @author Roberto Cruz Leija
 */
public class GeneradorInstancias {
    
    public static ArrayList<Patron> generarInstancias(byte[]carateristicas){
        ArrayList<Patron> aux = new ArrayList<>();
        int unos = 0;
        for (int x=0;x<carateristicas.length;x++)
         if (carateristicas[x]==1)unos++;
        // recorremos las instancias
        for(Patron pOriginal: Tokenizador.instancias){
            // asegurar la creacion de un patron 
            Patron pNuevo;
            String clase = pOriginal.getClaseOriginal();
            double vectorN [] = new double[unos];
            int j = 0;
            for (int i=0;i<carateristicas.length;i++){
              if(carateristicas[i]==1){
                vectorN [j] = pOriginal.getCaracteristicas()[i];
                j++;
              }
            }
            pNuevo = new Patron(vectorN, clase);
            aux.add(pNuevo);
        }
         return aux;  
    }
    
}
