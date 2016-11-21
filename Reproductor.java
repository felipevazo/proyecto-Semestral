/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectosemestral;

/**
 *
 * @author Hilda
 */
import java.io.File;

import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;
/**
//REQUIERE INSTALACION DE PAQUETES JAVAZOOM Y BASICPLAYER :3 
 *
 * @author Rodrigo
 */
        
public class Reproductor {
  public BasicPlayer player=new BasicPlayer();
    
public void reproducir()
{   
     try {
           // BasicPlayer player= new BasicPlayer(); // Llamo la clase de la libreria Basic Player, que reproduce
            player.open(new File("animals038.mp3"));
            player.play();// Llama al método Reproducir también existen los métodos  stop,resume.           
        } catch (BasicPlayerException ex) {
            System.out.print("-------Error-----"+ex.getMessage());
        }// Fin try
    
}
    
}