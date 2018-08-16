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
public interface ClasificadorSupervisado {
    
    public void entrena(ArrayList<Patron> instancias);
    public void clasifica(Patron patron);
    
}
