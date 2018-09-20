/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reconocimientodepatrones2018;

import clasificacionnosupervisada.CMeans;
import clasificadoresSupervisados.Knn;
import herramientas.GeneradorInstancias;
import herramientas.Grafica;
import herramientas.Punto;
import herramientas.Tokenizador;
import java.util.ArrayList;
import objetos.Patron;

/**
 *
 * @author Roberto Cruz Leija
 */
public class ReconocimientoDePatrones2018 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Tokenizador.leerDatos();
        CMeans cmeans = new CMeans(Tokenizador.instancias, 3);
        cmeans.clasifica();
        Grafica grafica = new Grafica("clasificacion","x1","x2");
        grafica.agregarSerie("Centroide0");
        grafica.agregarSerie("Centroide1");
        grafica.agregarSerie("Centroide2");
        
        for(Patron patron: Tokenizador.instancias){
          Punto p = new Punto(patron.getCaracteristicas()[0],
                     patron.getCaracteristicas()[1]);
          grafica.agregarPunto(patron.getClaseOriginal(), p);
        }
        
        grafica.crearGraficaPuntos();
        
      
    }
    
}
