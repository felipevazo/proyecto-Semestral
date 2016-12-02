/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectosemestral;

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.Icon;
import javax.swing.ImageIcon;
/**
 *
 * @author dci
 */
public class GaleriaImagenes {
    private int contador=0;
    
    Galeria galeria=new Galeria();   
    /**
     * muestra la ventana de galeria con sus respectivas imágenes
     */
    public void  mostrar()
    {
        
        int velocidad=5; //los segundos que aparece la imagen
        
        Timer timer; //instancia de Timer
        TimerTask tarea; //instancia de TimerTask
        
        int velocidadmili=velocidad*1000; //velocidad en milisegundos
        
        galeria.setVisible(true); //la galería con las imágenes se muestra
        
        tarea = new TimerTask() { //creación objeto tarea de tipo TimerTask
            @Override
            public void run() {
                Icon icono; //instancia de Icono
                
                switch(contador) { //switch case para mostrar las imagenes en el orden y que se repitan desde el principio
                    case 0: 
                        contador=1; //para cambiar la imagen a la segunda
                        icono = new ImageIcon(getClass().getResource("/imagenes/img2.jpg")); //a icono se le asigna un objeto que obtiene la imagen2
                        galeria.jLabel1.setIcon(icono); //al Jlabel se le entrega el icono antes definido
                        break;
                    case 1: 
                        contador=2; //para cambiar la imagena a la tercera
                        icono = new ImageIcon(getClass().getResource("/imagenes/img3.jpg")); //a icono se le asigna un objeto que obtiene la imagen3
                        galeria.jLabel1.setIcon(icono); //al Jlabel se le entrega el icono antes definido
                        break;
                    case 2: 
                        contador=0; //para cambiar la imagen a la primera
                        icono = new ImageIcon(getClass().getResource("/imagenes/img1.jpg")); //a icono se le asigna un objeto que obtiene la imagen1
                        galeria.jLabel1.setIcon(icono); //al Jlabel se le entrega el icono antes definido
                        break; 
                }
            }
        };
        
        timer = new Timer(); //creación objeto timer
        timer.scheduleAtFixedRate(tarea, velocidadmili, velocidadmili); //método que realiza la tarea especificada cada cierto tiempo después del tiempo que se le asigna también
        
    }
    /**
     * cierra la ventana galería
     */
    public void cerrar()
    {
        galeria.setVisible(false); //la galería de imágenes se deja de mostrar
    }
}