//hola estoy pobando esto porque no me lo quiero hechar, holaaaaa
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.semestral;
import java.util.Scanner;

/**
 *
 * @author Rodrigo
 */
public class ProyectoSemestral {
static Scanner entrada=new Scanner(System.in); 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public static void menu() throws InterruptedException
    {
        int trabajo=120;
        int descanso=30;
        //El valor de actividades en el futuro correspondera al tamaño de una matriz (.length)
        int actividades=123123;
        //Aqui irá selección de actividades favoritas de usuario según una lista que ira consultando el programa.
        //Es decir, el programa le lanzara opciones, el usuario responderá si o no, y guardará las preferencias.
        //Con el fin de otorgar luego una de sus preferencias como actividad a realizar de descanso cada 2 horas.
        //Evaluando nueva forma de entregar mensajes en forma de metodo mas ordenada, mientras tanto.
        System.out.println("Ahora el programa comenzará a contar hasta que pasen 2 horas.");
        System.out.println("Una vez esto ocurra, comenzará a contar otra vez, para medir su descanso entre periodos de trabajo.");
        contador(trabajo);
        actividades(actividades);
        tiempo_usuario();
        comienzo_actividad()
        contador(descanso);
    // AGREGAR COMENTARIO diferente segun situacion.
        
    }
    
    //¿¿¿este contador es el mismo del que esta en menu? el de contador(trabajo)?????
    private static void contador(int tope) throws InterruptedException
    {
        int horas=0;
        int minutos=0;
        int segundos=0;
        int dias=0;
        boolean ciclo =true;
        while(ciclo)
        {
            Thread.sleep(1000);
            segundos+=1;
            if(segundos>59)
            {
                segundos=0;
                minutos+=1;
            }
            if (minutos==tope)
            {
                ciclo=false;
            }
        
    }
     //Una vez transcurridas 2 horas, el sistema lanzará una ventana emergente
        System.out.println("Has pasado 2 horas sentado en el computador trabajando, toma un descanso.");
        System.out.println("El sistema te entregará una actividad entre tus elegidas para realizar.");
        
    }
    private static void actividades(int numeroactividades)
    {
        //¿¿¿¿que es el trato????
        //Basicamente, el azar decidirá la actividad para el agotado usuario.
        int trato=(int)(Math.random()*(numeroactividades-1) +1);
        switch(trato)
        {
            case 1:
                //Se desplegara ventana con mensaje
                System.out.println("Para distraerse, realizará la actividad 1-> aqui irá el nombre de actividad, en vez de 1 obviamente");
                break;
            case 2:
                System.out.println("Similar a arriba caso 2");
            case 3:
                System.out.println("Similar a arriba caso 3");
                break;
            default:
                System.out.println("Caso final");
                break;
        }
        //Avanzando, esto debería tomar mas opciones, desplegar en la misma pantalla actividades a realizar.
        //O directamente un cafe con un cigarro, a gusto del usuario(dentro de las opciones que el mismo programa barajará).
        
        private static void actividades();
        {
            System.out.println("Imaginese que tiene un día libre, ¿Cuál de las siguientes actividades haría?");
            System.out.println("(Para seleccionar haga click sobre la imagen)");
            //aquí hay que colocar imagenes en una ventana, creo que queda mejor así que ir preguntando uno por uno y que el usuario
            //decida si o no. Supuestamente lo veremos mas adelante, asi que se puede hacer
        }
        
        private static double tiempo_usuario()
        {
        //la idea es que el usuario defina cada cuanto tiempo quiere un descanso dependiendo de la actividad que realiza
        //obviamente con un mínimo para que descanse al menos 2 veces al día
        
            System.out.println("¿Cada cuántas horas puede tomarse un descanso?");
            System.out.println(("Debe ingresar un máximo de 4 horas, si no es preciso puede ingresar un decimal"))
            System.out.println("por ejemplo: si son 2 horas y media ingrese 2.5")
            tiempo_usu=leer.nextDouble();
            //validar el ingreso
            return tiempo_usu;
        }
        
        private static double comienzo_actividad()
        {
        // se debe preguntar a que hora comienza su actividad laboral o lo que realice para que sea acorde a sus tiempos
            System.out.println("¿A que hora comienza su actividad (laboral o doméstica)?")
            System.out.println("Debe ingresar en formato de 24 hrs, si no es preciso puede ingresar un decimal ")
            System.out.println("por ejemplo: si son 2 horas y media ingrese 2.5")
            comienzo_act=leer.nextDouble();
            //validar el ingreso
            return comienzo_act
        }
        
        
        
        
    }
    
    
}
