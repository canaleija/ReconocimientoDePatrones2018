/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

/**
 *
 * @author Roberto Cruz Leija
 */
public class DistanciaKnn {
    
    private double distancia;
    private String claseVecino;

    public DistanciaKnn() {
        this.distancia = 0;
        this.claseVecino="Desconocida";
    }

    public DistanciaKnn(double distancia, String claseVecino) {
        this.distancia = distancia;
        this.claseVecino = claseVecino;
    }

    /**
     * @return the distancia
     */
    public double getDistancia() {
        return distancia;
    }

    /**
     * @param distancia the distancia to set
     */
    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    /**
     * @return the claseVecino
     */
    public String getClaseVecino() {
        return claseVecino;
    }

    /**
     * @param claseVecino the claseVecino to set
     */
    public void setClaseVecino(String claseVecino) {
        this.claseVecino = claseVecino;
    }
    
    
    
}
