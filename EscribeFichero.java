/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectosemestral;

/**
 *
 * @author dci
 */
import java.io.*;
import java.util.ArrayList;

public class EscribeFichero
{
    public static void main(String[] args)
    {
        
    }
    public void escribe(double topeTrabajo,double topeDescanso,int topeTotal,ArrayList<String> asd)
    {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("datos.txt");
            pw = new PrintWriter(fichero);
            pw.println(topeTrabajo);
            pw.println(topeDescanso);
            pw.println(topeTotal);
            for (int i = 0; i < asd.size(); i++)
                pw.println(asd.get(i));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
}
