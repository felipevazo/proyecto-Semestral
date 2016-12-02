package proyectosemestral;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;
import javazoom.jl.decoder.JavaLayerException;


public class ProyectoSemestral {

private static Validaciones val=new Validaciones();

private static boolean a;
private static boolean cierreTope=false;
    /**
     * @param args the command line arguments
     */

     /**
      * se visualiza la primera ventana del programa
      * @param args
      * @throws JavaLayerException
      * @throws FileNotFoundException 
      */
    public static  void main(String[] args) throws JavaLayerException, FileNotFoundException  {
        
          Ventana1 v=new Ventana1(); //crea objeto de tipo ventana 1
          v.setVisible(true); //se hace visible la ventana 1
    }
}