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
    public void  galeria()
    
    {
        
        int velocidad=5; //los segundos que aparece la imagen
        
        Timer timer; //instancia de Timer
        TimerTask tarea; //instancia de TimerTask
        
        int velocidadmili=velocidad*1000; //velocidad en milisegundos
        
        galeria.setVisible(true);
        
        tarea = new TimerTask() {
            @Override
            public void run() {
                Icon icono;
                
                switch(contador) {
                    case 0: 
                        contador=1;
                        icono = new ImageIcon(getClass().getResource("/imagenes/img2.jpg"));
                        galeria.jLabel1.setIcon(icono);
                        break;
                    case 1: 
                        contador=2;
                        icono = new ImageIcon(getClass().getResource("/imagenes/img3.jpg"));
                        galeria.jLabel1.setIcon(icono);
                        break;
                    case 2: 
                        contador=0;
                        icono = new ImageIcon(getClass().getResource("/imagenes/img1.jpg"));
                        galeria.jLabel1.setIcon(icono);
                        break; 
                }
            }
        };
        
        timer = new Timer();
        timer.scheduleAtFixedRate(tarea, velocidadmili, velocidadmili);
        
    }
    public void cerrar()
    {
        dispose();
    }
}
