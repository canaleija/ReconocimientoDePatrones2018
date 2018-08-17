/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificadoresSupervisados;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.util.ArrayList;
import objetos.Patron;
import objetos.PatronRepresentativo;

/**
 *
 * @author Roberto Cruz Leija
 */
public class MinimaDistancia implements ClasificadorSupervisado{

    private ArrayList<PatronRepresentativo> representativos;

    public MinimaDistancia() {
        this.representativos = new ArrayList<>();
    }
    
    
    @Override
    public void entrena(ArrayList<Patron> instancias) {
    // agregamos el primer representativo
    this.representativos.add(new PatronRepresentativo(
            instancias.get(0).getCaracteristicas(),
            instancias.get(0).getClaseOriginal()));
    // recorrer la coleccion de patrones 
    for (int i=1; i < instancias.size();i=i+1){
        Patron patron = instancias.get(i);
        // buscar en los presentativos
        buscayAcumula(patron);
    }
    // calcular la media 
    for (PatronRepresentativo pr: this.representativos){
        // recorremos por caracteristicas
        for (int j=0;j<pr.getCaracteristicas().length;j++){
             pr.getCaracteristicas()[j]/=pr.getNumPatrones();
        
        }
    }
        
       
        
    }

    @Override
    public void clasifica(Patron patron) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void buscayAcumula(Patron patron) {
        int m = -1;
        // buscar en la coleccion de represantes
        for (int i=0; i < this.representativos.size();i++){
            //verificamos que exista 
            if (patron.getClaseOriginal().equals(
            this.representativos.get(i).getClaseOriginal())){
            // contamos
            this.representativos.get(i).setNumPatrones(this.representativos.get(i).getNumPatrones()+1);
            // acumulamos
            for(int j=0; j<this.representativos.get(i).getCaracteristicas().length
                    ;j++){
                
            this.representativos.get(i).getCaracteristicas()[j]+=patron.getCaracteristicas()[j];
            }
            m = i;
            break;
            }
            
            }
        
         if (m==-1){
         // agrega 
            this.representativos.add(new PatronRepresentativo(
                    patron.getCaracteristicas(),
                    patron.getClaseOriginal()));
           
         }
    }
}
