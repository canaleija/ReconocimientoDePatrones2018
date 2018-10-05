/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reconocimientodepatrones2018;

import clasificacionnosupervisada.CMeans;
import clasificadoresSupervisados.Knn;
import herramientas.GeneradorInstancias;
import herramientas.Grafica;
import herramientas.IOImage;
import herramientas.Punto;
import herramientas.Tokenizador;
import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
import objetos.Patron;
import practicaimagenes.ClusterImagenes;
import practicaimagenes.JFrameImagen;
import practicaimagenes.PatronPixel;

/**
 *
 * @author Roberto Cruz Leija
 */
public class ReconocimientoDePatrones2018 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Image imagenOriginal = IOImage.abrirImagen();
        JFrameImagen fo = new JFrameImagen(imagenOriginal);
        fo.setVisible(true);
        ClusterImagenes ci = new ClusterImagenes();
        Image imagenRes = ci.calcularClusters(imagenOriginal, 3);
        JFrameImagen fr = new JFrameImagen(imagenRes);
        fr.setVisible(true);
        System.out.println();
    }
    
}
