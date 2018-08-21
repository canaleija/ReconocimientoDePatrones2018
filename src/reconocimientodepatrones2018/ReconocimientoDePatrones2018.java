/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reconocimientodepatrones2018;

import clasificadoresSupervisados.MinimaDistancia;
import herramientas.GeneradorInstancias;
import herramientas.HerramientasClasificadores;
import herramientas.Tokenizador;
import java.util.ArrayList;
import javax.swing.text.html.MinimalHTMLWriter;
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

       ArrayList<Patron> aux = GeneradorInstancias.generarInstancias(new byte[]{0,0,1,1});
//       MinimaDistancia md = new MinimaDistancia();
//       md.entrena(Tokenizador.instancias);
//       md.clasificaConjunto(Tokenizador.instancias);
    
    }
    
}
