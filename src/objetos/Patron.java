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
public class Patron {
    
    // los elementos que tiene un patron en el contexto de clasificación supervisada 
    private double[] caracteristicas;
    private String claseOriginal;
    private String claseResultante;
    
    // inicializacion por defecto
    public Patron (int dim){
        this.caracteristicas = new double[dim];
        this.claseOriginal = "desconocida";
        this.claseResultante = "desconocida";
    }

    public Patron(double[] caracteristicas, String clase) {
        this.caracteristicas = caracteristicas;
        this.claseOriginal = clase;
        this.claseResultante = "desconocida";
    }

    /**
     * @return the caracteristicas
     */
    public double[] getCaracteristicas() {
        return caracteristicas;
    }

    /**
     * @return the claseOriginal
     */
    public String getClaseOriginal() {
        return claseOriginal;
    }

    /**
     * @param clase the claseOriginal to set
     */
    public void setClaseOriginal(String clase) {
        this.claseOriginal = clase;
    }

    /**
     * @return the claseResultante
     */
    public String getClaseResultante() {
        return claseResultante;
    }

    /**
     * @param claseResultante the claseResultante to set
     */
    public void setClaseResultante(String claseResultante) {
        this.claseResultante = claseResultante;
    }

    /**
     * @param caracteristicas the caracteristicas to set
     */
    public void setCaracteristicas(double[] caracteristicas) {
        this.caracteristicas = caracteristicas;
    }
    
    
}
