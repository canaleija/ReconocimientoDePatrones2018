/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaimagenes;

import clasificacionnosupervisada.CMeans;
import herramientas.IOImage;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import objetos.Patron;

/**
 *
 * @author Roberto Cruz Leija
 */
public class ClusterImagenes {
    
    private Image imagenOriginal;

    private CMeans clasificador;

    
    
    public Image calcularClusters(Image imagen, int numClusters){
        this.imagenOriginal =imagen;
        // extraer de la imagen la info para generar las instancias
        ArrayList<Patron> instancias = generarInstancias();
        Patron[] centroidesIniciales = calculaPixelesCentroidesIniciales(instancias,numClusters);
        this.clasificador = new CMeans(instancias, numClusters);
        this.clasificador.clasifica(centroidesIniciales);
        // modificamos los colores en base a la clasificacion 
        for(Patron patron: instancias){
        PatronPixel aux = (PatronPixel)patron;
        aux.modificarCaracteristicas();
        }
        return generarImagen(instancias);
    }
        
   

    private ArrayList<Patron> generarInstancias() {
       ArrayList<Patron> instancias = new ArrayList<>();
        // necesitamos leer los pixeles 
        BufferedImage bi = IOImage.toBufferedImage(imagenOriginal);
        // recorrer la imagen por pixel 
        for(int x=0;x<bi.getWidth();x++)
            for(int y=0;y<bi.getHeight();y++){
            Color color = new Color(bi.getRGB(x, y));
            double r = color.getRed();
            double g = color.getGreen();
            double b = color.getBlue();
            double[] c = new double[]{r,g,b};
            PatronPixel px = new PatronPixel(c,"Desconocida",x,y);
            instancias.add(px);
            }
       return instancias;
    }

    private Image generarImagen(ArrayList<Patron> instancias) {
       BufferedImage imagenNueva = new BufferedImage(this.imagenOriginal.getWidth(null),
                                                     this.imagenOriginal.getHeight(null),BufferedImage.TYPE_INT_RGB);
       for(Patron patron: instancias){
       PatronPixel aux = (PatronPixel)patron;
       int rgb = Integer.parseInt(aux.getClaseOriginal());
       imagenNueva.setRGB(aux.getX(),aux.getY(), rgb);
       
       }
       return IOImage.toImage(imagenNueva);
    }

    private Patron[] calculaPixelesCentroidesIniciales(ArrayList<Patron> instancias, int numClusters) {
       // generar mis centroidesIniciales iniciales aleatorios 
     Random ran = new Random();
     Patron[] centroidesIniciales = new Patron[numClusters];
     for (int x=0; x < numClusters;x++){
       int pos = ran.nextInt(instancias.size());
        Color color = new Color((int)instancias.get(pos).getCaracteristicas()[0],
                      (int)instancias.get(pos).getCaracteristicas()[1], 
       (int)instancias.get(pos).getCaracteristicas()[2]);
       String nombre = color.getRGB()+"";
       centroidesIniciales[x] = new Patron(instancias.get(pos).getCaracteristicas().clone(),nombre);
     }
        
       return centroidesIniciales;
    }
    
}
