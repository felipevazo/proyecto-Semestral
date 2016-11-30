/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectosemestral;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author dci
 */
public class Validaciones {
    
    LeeFichero lee=new LeeFichero();
    
     public boolean confirmarDoubles(double topeTrabajo,int topeTotal, double topeDescanso) {
         //Ingresan double,int,double
         //Retorna boolean si se cumple:
         //primer doble entre 1 y 4
         //int entre 4 y 10
         //segundo double entre 10 y 30
        boolean a=(topeTrabajo<=4&&topeTrabajo>=1);
        
        boolean b=(topeTotal<=10&&topeTotal>=4);
        boolean c=(topeDescanso<=30&&topeDescanso>=4);
        if(a==b&&b==c&&a==true)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
      public  boolean buscaLinea(String cadena,String buscar)
        {
          //Variable ingreso: String,String
          //Revisa si el segundo String esta dentro del primero
          //Retorna boolean
              Pattern pat = Pattern.compile(buscar);
              Matcher mat = pat.matcher(cadena);
              if (mat.matches()) 
                {
                     return true;
                } 
                else 
                {
                   return false;
                }
        }
        public    boolean lineaVacia()
        {
            String linea;
            if(lee.lee())
            {
                return false;
            }
            else
            {
                return true;
            }
            
        }
     public double stringDouble(String str)
        {
         //Recibe String 
         //Si string es numero double, lo retorna como double
         //Si no, retorna 0.0
            boolean a=true;
           
  
            try  
             {  
              double d = Double.parseDouble(str);  
             }  
             catch(NumberFormatException nfe)  
            {   
               a=false;
            }  

            if(a)
            {
                
            return Double.parseDouble(str);
            }
            else
            {
                return 0.0;
            } 
               
        }
     public boolean esNumero(String str)
     {
         //Recibe str
         //Si str es numero retorna true
         //Si no, false
         try  
        {  
          double d = Double.parseDouble(str);  
         }  
         catch(NumberFormatException nfe)  
          {  
            return false;  
        }  
          return true;  

     }
    
}
