/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectosemestral;

import javax.swing.JOptionPane;

/**
 *
 * @author dci
 */
public class GestionContador {
    
     public  int contador(double tope, int contadorTotal, int topeTotal) throws InterruptedException
    {
        
        int minTotales=(int)tope*60;
        int minutos=0;
        int segundos=0;
        boolean cierreTope=false;
        while(minutos<minTotales&&cierreTope==false)
        {
            //En resumen, el ciclo cortara cuando se cumplan los minutos decididos por usuario.
            //O cuando se complete la jornada laboral total, tambien definida por usuario.
            Thread.sleep(1000);
            segundos+=1;
            if(segundos>59)
                
            {
                segundos=0;
                minutos+=1;
                contadorTotal+=1;
                System.out.println(minutos);
           
            }
            if(contadorTotal==topeTotal)
            {
                cierreTope=true;
            }
        }
        return contadorTotal;
    }

    
}
