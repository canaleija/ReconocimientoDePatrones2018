/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaimagenes;

import java.awt.Color;
import objetos.Patron;

/**
 *
 * @author Roberto Cruz Leija
 */
public class PatronPixel extends Patron{
    private int x;
    private int y;
    
        // inicializacion por defecto
    public PatronPixel (int dim){
        super(dim);
    }

    public PatronPixel(double[] caracteristicas, String clase,int x, int y) {
        super(caracteristicas,clase);
        this.x = x;
        this.y = y;
    }
    
    public void modificarCaracteristicas(){
        String clase = getClaseOriginal();
        int valorRGB = Integer.parseInt(clase);
        Color color = new Color(valorRGB);
        getCaracteristicas()[0]= color.getRed();
        getCaracteristicas()[1]= color.getGreen();
        getCaracteristicas()[2]= color.getBlue();
    }
    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }
    
    
}
