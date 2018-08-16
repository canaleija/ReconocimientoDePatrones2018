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
public class PatronRepresentativo extends Patron{
    // el numero de patrones que representa el objeto
    private int numPatrones;
    public PatronRepresentativo(int dim) {
        super(dim);
        this.numPatrones = 1;
    }
    public PatronRepresentativo(double[] caracteristicas, String clase) {
        super(caracteristicas,clase);
         this.numPatrones = 1;
    }

    /**
     * @return the numPatrones
     */
    public int getNumPatrones() {
        return numPatrones;
    }

    /**
     * @param numPatrones the numPatrones to set
     */
    public void setNumPatrones(int numPatrones) {
        this.numPatrones = numPatrones;
    }
    
    
}
