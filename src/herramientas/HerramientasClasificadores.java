/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramientas;

import objetos.Patron;

/**
 *
 * @author Roberto Cruz Leija
 */
public class HerramientasClasificadores {
    
    public static double calcularDistEucli(Patron p, Patron q){
        double res = 0;
        for (int j = 0; j<p.getCaracteristicas().length;j++){
            res+=Math.pow(p.getCaracteristicas()[j]-q.getCaracteristicas()[j],2);
        }
        
        return Math.sqrt(res);
    }
    
}
