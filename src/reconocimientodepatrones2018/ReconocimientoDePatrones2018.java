/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reconocimientodepatrones2018;

import clasificadoresSupervisados.MinimaDistancia;
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
        ArrayList<Patron> aux = Tokenizador.instancias;
       double res = HerramientasClasificadores.calcularDistEucli(Tokenizador.instancias.get(0),
                               Tokenizador.instancias.get(1));
        MinimaDistancia md = new MinimaDistancia();
       md.entrena(Tokenizador.instancias);
       Patron a = new Patron(new double[]{4.9,3.0,1.4,0.2},"desconocida");
        md.clasifica(a);
       System.out.println(res);
    }
    
}
