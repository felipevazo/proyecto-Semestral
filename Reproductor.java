package proyectosemestral;

/**
 *
 * @author Catalina
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
//REQUIERE INSTALACION DE PAQUETES JAVAZOOM Y BASICPLAYER 1.01
 *
 * @author Rodrigo
 */
        
public class Reproductor {

    /**
     * reproduce archivo prueba.mp3
     * @throws JavaLayerException
     * @throws FileNotFoundException 
     */
public void reproducir() throws JavaLayerException, FileNotFoundException {   
      //Reproduce archivo prueba.mp3
      Player apl = new Player(new FileInputStream("prueba.mp3"));
      apl.play();
    }
}