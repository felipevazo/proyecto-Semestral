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
    public void escribeNumeros(double topeTrabajo,double topeDescanso,int topeTotal)
    {
        //Variables ingreso: double,double,int
        //Guarda estos datos en archivo de datos.txt
       
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("datos.txt");
            pw = new PrintWriter(fichero);
            pw.println(topeTrabajo);
            pw.println(topeDescanso);
            pw.println(topeTotal);
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    
    }
    public void escribeTodo(ArrayList<String> listaActividades)
    {
        //Variable entrada: ArrayList de String
        //Escribe los String bajo los datos numericos en datos.txt
        
        LeeFichero lee=new LeeFichero();
        lee.ArrayNumeros();
        ArrayList<String> numeros=new ArrayList<String>();
        
        for (int i = 0; i < 3; i++) {
            numeros.add(lee.devolverNumero(i));
        }
         FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("datos.txt");
            pw = new PrintWriter(fichero);
            for (int i = 0; i < numeros.size(); i++) {
                System.out.println(numeros.get(i));
                pw.println(numeros.get(i));
                
            }
            for (int i = 0; i < listaActividades.size(); i++) {
                pw.println(listaActividades.get(i));
            }

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
