/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the
 */
// ÚLTIMA ACTUALIZACIÓN EN CONJUNTO PARA PRIMER AVANCE 26/09/2016
package proyectosemestral;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ProyectoSemestral {
private static Scanner entrada=new Scanner(System.in); 
private static double topeTrabajo, topeDescanso;
private static ArrayList<String> listaActividades= new ArrayList<>();
private static int topeTotal;
private static int contadorTope;
private static boolean cierreTope=false;
private static LeeFichero lee=new LeeFichero();
private static EscribeFichero escribe=new EscribeFichero();
private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, IOException {
        menu();
      
        // TODO code application logic here2
        
    }
    public static boolean getCierreTope()
    {
        return cierreTope;
    }

    public static void setCierreTope(boolean cierreTope) {
        ProyectoSemestral.cierreTope = cierreTope;
    }

    public static double getTopeTrabajo() {
        return topeTrabajo;
    }

    public static double getTopeDescanso() {
        return topeDescanso;
    }

    public static ArrayList<String> getListaActividades() {
        return listaActividades;
    }

    public static int getTopeTotal() {
        return topeTotal;
    }

    public static int getContadorTope() {
        return contadorTope;
    }

    public static void setTopeTrabajo(double topeTrabajo) {
        ProyectoSemestral.topeTrabajo = topeTrabajo;
    }

    public static void setTopeDescanso(double topeDescanso) {
        ProyectoSemestral.topeDescanso = topeDescanso;
    }

    public static void setListaActividades(ArrayList<String> listaActividades) {
        ProyectoSemestral.listaActividades = listaActividades;
    }

    public static void setTopeTotal(int topeTotal) {
        ProyectoSemestral.topeTotal = topeTotal;
    }

    public static void setContadorTope(int contadorTope) {
        ProyectoSemestral.contadorTope = contadorTope;
    }
    
    
    public static void menu() throws InterruptedException, IOException
    {
          //El valor de actividades en el futuro correspondera al tamaño de una matriz (.length)
       
        //Aqui irá selección de actividades favoritas de usuario según una lista que ira consultando el programa.
        //Es decir, el programa le lanzara opciones, el usuario responderá si o no, y guardará las preferencias.
        //Con el fin de otorgar luego una de sus preferencias como actividad a realizar de descanso cada 2 horas.
        //Evaluando nueva forma de entregar mensajes en forma de metodo mas ordenada, mientras tanto.
       if(lineaVacia())
       {
           
       
        topeTrabajo=tiempoUsuario();
        
        topeDescanso=(tiempoDescanso(topeTrabajo)/60);
        seleccionActividades();
        comienzoActividad();
        escribe.escribe(topeTrabajo,topeDescanso,topeTotal, listaActividades);
       }
       else
       {
           System.out.println("¿Desea modificar sus datos de ingreso, usados la ultima vez?");
           System.out.println("Referencia a tiempos de trabajo, descanso y actividades a elegir.");
           String resp=entrada.next().toLowerCase();
           
           lee.pasarArray();
           topeTrabajo=Double.parseDouble(lee.devolverString(0));
           topeDescanso=Double.parseDouble(lee.devolverString(1));
           topeTotal=Integer.parseInt(lee.devolverString(2));
           
                       for (int i = 0; i < listaActividades.size(); i++) {
                         listaActividades.remove(i);
                   
                        }
           for (int i = 3; i < lee.devolverTamaño(); i++) {
              listaActividades.add(lee.devolverString(i));
               
               
           }
           if(resp.equals("si"))
           {
               System.out.println("Ingrese la palabra correspondiente a lo que desea modificar.");
               System.out.println("Es decir, trabajo,descanso o actividades.");
               String rsp="no";
               while(!rsp.equals("trabajo")&&!resp.equals("descanso")&&!resp.equals("actividades"))
               {
               rsp=entrada.next().toLowerCase();
               if(!rsp.equals("trabajo")&&!resp.equals("descanso")&&resp.equals("actividades"))
               {
                   System.out.println("Ingrese la palabra correcta por favor."); 
               }
               }
               switch(rsp)
               {
                   case "trabajo":
                       topeTrabajo=tiempoUsuario();
                       //añadir a txt
                       break;
                   case "descanso":
                       topeDescanso=(tiempoDescanso(topeTrabajo)/60);
                       //añadir a txt
                       break;
                   case "actividades":
                       for (int i = 0; i < listaActividades.size(); i++) {
                         listaActividades.remove(i);
                   
                        }
                        seleccionActividades();
                        //añadir a txt
                       break;
                   default:
                       System.out.println("aqui esta el error.");
                       break;
                      
                       
               }
               
               
           escribe.escribe(topeTrabajo, topeDescanso,topeTotal, listaActividades);
           }
       
       }
        
        System.out.println("Ahora el programa comenzará a contar hasta que pasen las horas que usted decidió.");
        System.out.println("Una vez esto ocurra, comenzará a contar otra vez, para medir su descanso entre periodos de trabajo.");
        while(contadorTope<topeTotal)
        {
        contador(topeTrabajo);
        actividades(listaActividades.size());
        contador(topeDescanso); 
        // AGREGAR COMENTARIO diferente segun situacion.
        }
        System.out.println("Tope de horas definidas maximas, muchas gracias por usar el programa y que tenga un buen dia.");
    }
    
    private static void contador(double tope) throws InterruptedException
    {
        double pDecimal=tope - (int)tope;
        int minTotales=(int)tope*60+(int)(pDecimal*60);
        int minutos=0;
        int segundos=0;
        boolean ciclo=true;
        while(minutos<minTotales||cierreTope==false)
        {
            //En resumen, el ciclo cortara cuando se cumplan los minutos decididos por usuario.
            //O cuando se complete la jornada laboral total, tambien definida por usuario.
            Thread.sleep(1000);
            segundos+=1;
            if(segundos>59)
            {
                segundos=0;
                minutos+=1;
                setContadorTope(getContadorTope()+1);
            }
            if(getContadorTope()==topeTotal)
            {
                cierreTope=true;
            }
        }
           //Una vez transcurridas 2 horas, el sistema lanzará una ventana emergente
        System.out.println("Has pasado 2 horas sentado en el computador trabajando, toma un descanso.");
        System.out.println("El sistema te entregará una actividad entre tus elegidas para realizar."); 
    }
    
    private static void actividades(int numeroActividades)
    {
        //Basicamente, el azar decidirá la actividad para el agotado usuario.
        int i=(int)(Math.random()*(numeroActividades-1)+1 );
        switch(i)
        {
            case 1:
                //Se desplegara ventana con mensaje
                System.out.println("es momento de "+listaActividades.get(0));
                break;
            case 2:
                System.out.println("sorpresa, ha tocado"+listaActividades.get(1));
            case 3:
                System.out.println("momento de "+listaActividades.get(2));
                break;
            case 4:
                System.out.println("Ha tocado "+listaActividades.get(3));
            case 5:
                System.out.println("es la hora de "+listaActividades.get(5));
            default:
                System.out.println("Bienvenido al bonus, sientese, mire al techo y piense en su quehacer de la semana durante unos minutos.");
                break;
        }
              
                if(buscaLinea(listaActividades.get(i-1),".*parrafos.*"))
                {
                    System.out.println("Se abrira un parrafo de un libro aleatorio, para que ud disfrute de una distraccion sutil.");
                    //Aqui se abre el archivo de texto estatico 
                }
                else if(buscaLinea(listaActividades.get(i-1),".*musica.*"))
                {
                     System.out.println("a continuacion sonara musica relajante, mientras aparecen un par de imagenes para ayudar a la distraccion.");
                     Reproductor repr=new Reproductor();
                     repr.reproducir();
                }
                else if(buscaLinea(listaActividades.get(i-1),".*cafe.*"))
                {
                    System.out.println("Preparese un cafe con calma, prenda su cigarro(o solamente el cafe, como ud prefiera) y tome su tiempo para degustarlo.");
                }
                else if(buscaLinea(listaActividades.get(i-1),".*caminata.*"))
                {
                    System.out.println("Momento de una caminata, de una vuelta por su calle, tome aire y disfrute de la vista.");
                }
                else if(buscaLinea(listaActividades.get(i-1),".*canciones.*"))
                {
                    System.out.println("Disfrute de interpretar sus canciones favoritas en su instrumento deseado.");
                    //Se podria añadir una pagina web con acordes, para ayudar a pensar cosas que tocar.
                }
                else
                {
                    System.out.println("Momento de hacer literalmente.. nada, apague la pantalla unos minutos, mire a la nada y piense, disfrute de este momento de su vida haciendo absolutamente nada.");
                }
        
        //Avanzando, esto debería tomar mas opciones, desplegar en la misma pantalla actividades a realizar.
        //O directamente un cafe con un cigarro, a gusto del usuario(dentro de las opciones que el mismo programa barajará).
    } 
    private static void seleccionActividades()
        {
            //Se crea una variable resp por mientras que aprendemos a interactuar con ventanas.
            System.out.println("Imaginese que tiene un día libre, ¿Cuál de las siguientes actividades haría?");
            System.out.println("(Para seleccionar haga click sobre la imagen)");
            //Actividades tentativas
            System.out.println("Imagen con parrafos de libro");
            String resp=entrada.next();
            if(resp.equals("si"))
            {
                listaActividades.add("Leer parrafos de libros.");
            }
            System.out.println("Imagen que represente musica relajante");
            resp=entrada.next();
            if(resp.equals("si"))
            {
                listaActividades.add("Reproducir musica relajante, acompañada de imagenes");
                
                
            }
            System.out.println("Imagen representativa de bebida caliente y cigarro");
            //EL CIGARRO ES DAÑINO PARA LA SALUD; PERO RELAJA AL USUARIO EN SI SI ESTE FUMA 
            if(resp.equals("si"))
            {
                listaActividades.add("Un momento de descanso, con un cigarro y un cafe, alejado del computador.");
            }
            System.out.println("Imagen representativa de caminata.");
            if(resp.equals("si"))
            {
                listaActividades.add("Una caminata por su sector");
            }
            System.out.println("Imagen que represente el tocar musica");
            if(resp.equals("si"))
            {
                listaActividades.add("Interpretar canciones para distraerse.");
            }
            
            //aquí hay que colocar imagenes en una ventana, creo que queda mejor así que ir preguntando uno por uno y que el usuario
            //decida si o no. Supuestamente lo veremos mas adelante, asi que se puede hacer
            
            //la imagen podria guardar datos en el arraylist que instancie arriba, para que sea mas facil obtener los topes luego(usando el arraylist.size y todo eso)
        }
        
        private static double tiempoUsuario()
        {
        //la idea es que el usuario defina cada cuanto tiempo quiere un descanso dependiendo de la actividad que realiza
        //obviamente con un mínimo para que descanse al menos 2 veces al día
        
            System.out.println("¿Cada cuántas horas puede tomarse un descanso?");
            System.out.println(("Debe ingresar un máximo de 4 horas, si no es preciso puede ingresar un decimal"));
            System.out.println("por ejemplo: si son 2 horas y media ingrese 2.5");
            System.out.println("Se ruega ingresar un tiempo valido, con un tope de 4 horas, y un minimo de 1");
            double tiempoUsu=0;
            boolean conf=false;
            while(conf==false)
            {
             tiempoUsu=entrada.nextDouble();
             conf=validarDouble(tiempoUsu,1,4);
             if(conf==false)
             {
                 System.out.println("Dato invalido, por favor ingrese numeros entre 1 y 4, se aceptan decimales con punto.");
             }
                 
                   
            }
            return tiempoUsu;
        }

        private static double tiempoDescanso(double topeTrabajo)
        {
            if (topeTrabajo<2.5) 
            {
                System.out.println("Ahora elija el tiempo de descanso luego de su actividad de trabajo");  
                System.out.println("Puede variar entre 10 y 30 minutos.");
                int aux =45676875;
                boolean conf=false;
                while(conf==false)
                {
                    aux =entrada.nextInt();
                    conf=validarInt(aux,10,30);
                    if(conf==false)
                        
                    {
                        System.out.println("Dato invalido, ingrese numeros entre 10 y 30 porfavor, NO se admiten decimales.");
                    }
                }
                return aux;
                }
            else
            {
                return 30;
            }
        }
         private  static void comienzoActividad() throws IOException
        {
        // se debe preguntar a que hora comienza su actividad laboral o lo que realice para que sea acorde a sus tiempos
        // A esto le haria una pequeña adaptacion, mas que preguntar a que hora inicia su actividad(recordar que el reloj no fuunciona con calendar)
        // Preguntaría cuantas horas pretende trabajar como maximo
           /*
            System.out.println("¿A que hora comienza su actividad (laboral o doméstica)?");
            System.out.println("Debe ingresar en formato de 24 hrs, si no es preciso puede ingresar un decimal ");
            System.out.println("por ejemplo: si son 2 horas y media ingrese 2.5");
            double comienzo_act=entrada.nextDouble();
                   */
            //validar el ingreso
            //ALGO ASI
            System.out.println("Por favor ingrese la cantidad de horas de trabajo maximas durante la jornada de hoy");
            System.out.println("Considerando un minimo de 4 y un maximo de 10");
            System.out.println("Se permite ingreso de decimales, como 5.5 horas, 4.25 horas, etc.");
            double totalAct=0;
            boolean conf=false;
            while(conf==false)
            {
               String aux = br.readLine();
               totalAct=Double.parseDouble(aux);
                conf=validarDouble(totalAct,4,10);
                if(conf==false)
                {
                    System.out.println("Dato invalido, Ingrese numeros entre 4 y 10, con decimales aceptados.");
                }
            }
            double pDecimal=totalAct-(int)totalAct;
            setTopeTotal((int)totalAct*60+(int)(pDecimal*60));
        }

        private static boolean validarDouble(double numero,double topeBajo, double topeAlto)
        {
            if(numero<topeBajo&&numero>topeAlto)
            {
                //System.out.println("Dato invalido, por favor intente nuevamente");
                return false;
            }
            else
            {
                return true;
            } 
        }
        
        private static boolean validarInt(int numero,int topeBajo,int topeAlto)
        {
            if(numero<topeBajo&&numero>topeAlto)
            {
                //System.out.println("Dato invalido, intente nuevamente");
                return false;
            }
            else
            {
                
                return true;
            }
            
        }
        
        public static boolean buscaLinea(String cadena,String buscar)
        {
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
        private static boolean lineaVacia()
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
}