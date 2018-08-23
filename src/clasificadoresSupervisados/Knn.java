/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificadoresSupervisados;

import java.util.ArrayList;
import objetos.Patron;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Knn implements ClasificadorSupervisado{

    private ArrayList<Patron> instancias;
    @Override
    public void entrena(ArrayList<Patron> instancias) {
        this.instancias = instancias;
    }

    @Override
    public void clasifica(Patron patron) {
        // TODO: IMPLEMENTAR EL KNN
        
    }
    
}
