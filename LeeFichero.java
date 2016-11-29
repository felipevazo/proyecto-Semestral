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
          //Traspasa la informacion del TXT a un ArrayList llamado aux
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
          //Variable ingreso: posicion del array aux
          //Retorna: el String que corresponda a esa posición
       return aux.get(pos);
   }
   public int devolverTamaño()
   {
          //Devuelve Tamaño del array aux
       return aux.size();
   }
   public void ArrayNumeros()
   {
          //Traspasa solo los numeros del txt a un array aparte llamado numeros
       
   
        try {
    
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         String linea;
         while((linea=br.readLine())!=null)
            numeros.add(linea);
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
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
           //retorna ArrayList aux
    }

    public void setAux(ArrayList<String> aux) {
        this.aux = aux;
           //setArrayList(aux)
    }

    public ArrayList<String> getNumeros() {
        return numeros;
           //Retorna ArrayList numeros
    }

    public void setNumeros(ArrayList<String> numeros) {
        this.numeros = numeros;
           //SetArrayList(aux)
    }
    public String devolverNumero(int pos)
    {// Variable entrada: posicion en ArrayList numeros
        ArrayNumeros();
        return this.numeros.get(pos);
           //retorna: numero en esa posicion.
           
    }
    public String devolverLinea(int pos)
    {
           //Devuelve lineas del ArrayList Libro
        return Libro.get(pos);
    }
    public void devolverLibro()
    {
           //Toma un Libro al azar de la carpeta Libros y lo pasa al ArrayList Libro
        int i=(int) (Math.random() * 14 + 1);
       
        File arch=new File("text"+i+".txt");
          try {
    
         fr = new FileReader (arch);
         br = new BufferedReader(fr);

         String linea;
         while((linea=br.readLine())!=null)
            Libro.add(linea);
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
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
