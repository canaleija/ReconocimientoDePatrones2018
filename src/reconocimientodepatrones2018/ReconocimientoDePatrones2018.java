/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reconocimientodepatrones2018;

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
        ArrayList<Patron> aux = Tokenizador.instancias;
       System.out.println();
    }
    
}
