/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificadoresSupervisados;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import herramientas.HerramientasClasificadores;
import java.util.ArrayList;
import objetos.Patron;
import objetos.PatronRepresentativo;

/**
 *
 * @author Roberto Cruz Leija
 */
public class MinimaDistancia implements ClasificadorSupervisado{

    private ArrayList<PatronRepresentativo> representativos;
    private double eficacia;
    
    public MinimaDistancia() {
        this.representativos = new ArrayList<>();
        this.eficacia=0;
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
        // hipotesis
        double distMenor = HerramientasClasificadores.calcularDistEucli(patron, 
                this.representativos.get(0));
       
        patron.setClaseResultante(this.representativos.get(0).getClaseOriginal());
        for(int j=1; j < this.representativos.size();j++){
        double dist = HerramientasClasificadores.calcularDistEucli(patron, 
                this.representativos.get(j));
       
        if (dist<distMenor){
         distMenor = dist;
         patron.setClaseResultante(this.representativos.get(j).getClaseOriginal());
        }
        }
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

    public double getEficacia() {
        return eficacia;
    }
    
    
  
}
