/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reconocimientodepatrones2018;

import clasificadoresSupervisados.Knn;
import clasificadoresSupervisados.MinimaDistancia;
import herramientas.GeneradorInstancias;
import herramientas.HerramientasClasificadores;
import herramientas.Tokenizador;
import java.util.ArrayList;
import javax.swing.text.html.MinimalHTMLWriter;
import objetos.DistanciaKnn;
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

        ArrayList<Patron> aux = GeneradorInstancias.generarInstancias(new byte[]{1,1,1,1});
        Knn knn = new Knn(6);
        knn.entrena(aux);
        knn.clasificaConjunto(aux);
        System.out.println(knn.getEficacia());
//        ArrayList<DistanciaKnn>  aux = new ArrayList<>();
//        aux.add(new DistanciaKnn(10,"10"));
//        aux.add(new DistanciaKnn(9,"9"));
//        aux.add(new DistanciaKnn(8,"8"));
//        aux.add(new DistanciaKnn(7,"7"));
//        aux.add(new DistanciaKnn(6,"6"));
//        HerramientasClasificadores.ordenar(aux);
//       System.out.println();
        
//       MinimaDistancia md = new MinimaDistancia();
//       md.entrena(Tokenizador.instancias);
//       md.clasificaConjunto(Tokenizador.instancias);
    
    }
    
}
