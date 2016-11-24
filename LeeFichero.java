/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectosemestral;


import java.io.*;
import java.util.ArrayList;

class LeeFichero {
       private ArrayList<String>Libro=new ArrayList<String>();
       private File archivo = new File("datos.txt");
       private FileReader fr = null;
       public BufferedReader br = null;
       private ArrayList <String> aux=new ArrayList<String>();
       
       private ArrayList<String> numeros=new ArrayList<String> ();
    
   public boolean lee()
   {

      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
        
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         // Lectura del fichero
         String linea;
         if((linea=br.readLine())!=null)
            return true;
         else
         {
             return false;
         }
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
      return false;
       
   }
   public void pasarArray()
   {
        try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
    
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         // Lectura del fichero
         String linea;
         while((linea=br.readLine())!=null)
             aux.add(linea);
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
   }
   
}
   public String devolverString(int pos)
   {
       return aux.get(pos);
   }
   public int devolverTamaño()
   {
       return aux.size();
   }
   public void ArrayNumeros()
   {
       
   
        try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
    
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         // Lectura del fichero
         String linea;
         while((linea=br.readLine())!=null)
            numeros.add(linea);
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
       
   }
}

    public ArrayList<String> getAux() {
        return aux;
    }

    public void setAux(ArrayList<String> aux) {
        this.aux = aux;
    }

    public ArrayList<String> getNumeros() {
        return numeros;
    }

    public void setNumeros(ArrayList<String> numeros) {
        this.numeros = numeros;
    }
    public String devolverNumero(int pos)
    {
        ArrayNumeros();
        return this.numeros.get(pos);
    }
    public String devolverLinea(int pos)
    {
        return Libro.get(pos);
    }
    public void devolverLibro()
    {
        //int i=(int) (Math.random() * 14 + 1);
       
        File arch=new File("text"+0+".txt");
          try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
    
         fr = new FileReader (arch);
         br = new BufferedReader(fr);

         // Lectura del fichero
         String linea;
         while((linea=br.readLine())!=null)
            Libro.add(linea);
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
       
   }
        
    }
}