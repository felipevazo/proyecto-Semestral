/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cambiarimagen;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author catalinaaguayo
 */
public class CambiarImagen {

    /**
     * @param args the command line arguments
     */
    
    static int contador=0;
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        int velocidad=5; //los segundos que aparece la imagen
        
        Timer timer; //instancia de Timer
        TimerTask tarea; //instancia de TimerTask
        
        int velocidadmili=velocidad*1000; //velocidad en milisegundos
        
        Galeria galeria=new Galeria();
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
    
}