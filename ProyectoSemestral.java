//hola estoy pobando esto porque no me lo quiero hechar, holaaaaa

package proyecto.semestral;
import java.util.*;

public class ProyectoSemestral {
static Scanner entrada=new Scanner(System.in); 
static double topeTrabajo, topeDescanso;
static ArrayList<String> listaActividades= new ArrayList<>();
static int topeTotal;
static int contadorTope;
static boolean cierreTope=false;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        // TODO code application logic here
    }
    public static boolean getCierreTope()
    {
        return cierreTope;
    }
    public static void setCierreTope(boolean cierreTope)
    {
        this.cierreTope=cierreTope;
        
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
    
    
    public static void menu() throws InterruptedException
    {
        //El valor de actividades en el futuro correspondera al tamaño de una matriz (.length)
       
        //Aqui irá selección de actividades favoritas de usuario según una lista que ira consultando el programa.
        //Es decir, el programa le lanzara opciones, el usuario responderá si o no, y guardará las preferencias.
        //Con el fin de otorgar luego una de sus preferencias como actividad a realizar de descanso cada 2 horas.
        //Evaluando nueva forma de entregar mensajes en forma de metodo mas ordenada, mientras tanto.
        topeTrabajo=tiempo_usuario();
        
        topeDescanso=(tiempo_descanso(topeTrabajo)/60);
        comienzo_actividad(); 
        System.out.println("Ahora el programa comenzará a contar hasta que pasen las horas que usted decidió.");
        System.out.println("Una vez esto ocurra, comenzará a contar otra vez, para medir su descanso entre periodos de trabajo.");
        while(contadorTope<topeTotal)
        {
        contador(topeTrabajo);
        actividades();
        contador(topeDescanso); 
    // AGREGAR COMENTARIO diferente segun situacion.
        }
        System.out.println("Tope de horas definidas maximas, muchas gracias por usar el programa y que tenga un buen dia.");
    }
    
    //¿¿¿este contador es el mismo del que esta en menu? el de contador(trabajo)?????
    //R: si, se puede usar en ambos contextos
    private static void contador(double tope) throws InterruptedException
    {
        double pDecimal=tope - (int)tope;
        int minTotales=(int)tope*60+(int)(pDecimal*60);
        int minutos=0;
        int segundos=0;
        boolean ciclo =true;
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
                cierreTope==true;
            }
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
    } 
        private static void actividades()
        {
            //Se crea una variable resp por mientras que aprendemos a interactuar con ventanas.
            System.out.println("Imaginese que tiene un día libre, ¿Cuál de las siguientes actividades haría?");
            System.out.println("(Para seleccionar haga click sobre la imagen)");
            //Actividades tentativas
            System.out.println("Imagen con parrafos de libro")
            resp=entrada.next();
            if(resp=="si")
            {
                listaActividades.add("Leer parrafos de libros.");
            }
            System.out.println("Imagen que represente musica relajante")
            resp=entrada.next();
            if(resp=="si")
            {
                listaActividades.add("Reproducir musica relajante, acompañada de imagenes");
                
            }
            System.out.println("Imagen representativa de bebida caliente y cigarro");
            //EL CIGARRO ES DAÑINO PARA LA SALUD; PERO RELAJA AL USUARIO EN SI SI ESTE FUMA 
            if(resp=="si")
            {
                listaActividades.add("Un momento de descanso, con un cigarro y un cafe, alejado del computador.");
            }
            System.out.println("Imagen representativa de caminata.");
            if(resp=="si")
            {
                listaActividades.add("Una caminata por su sector");
            }
            System.out.println("Imagen que represente el tocar musica")
            if(resp=="si")
            {
                listaActividades.add("Interpretar canciones para distraerse.")
            }
            
            //aquí hay que colocar imagenes en una ventana, creo que queda mejor así que ir preguntando uno por uno y que el usuario
            //decida si o no. Supuestamente lo veremos mas adelante, asi que se puede hacer
            
            
            
            //La imagen podria guardar datos en el arraylist que instancie arriba, para que sea mas facil obtener los topes luego(usando el arraylist.size y todo eso)
        }
        
        private static double tiempo_usuario()
        {
        //la idea es que el usuario defina cada cuanto tiempo quiere un descanso dependiendo de la actividad que realiza
        //obviamente con un mínimo para que descanse al menos 2 veces al día
        
            System.out.println("¿Cada cuántas horas puede tomarse un descanso?");
            System.out.println(("Debe ingresar un máximo de 4 horas, si no es preciso puede ingresar un decimal"));
            System.out.println("por ejemplo: si son 2 horas y media ingrese 2.5");
            System.out.println("Se ruega ingresar un tiempo valido, con un tope de 4 horas, y un minimo de 1");
            double tiempo_usu=0;
            while(validarDouble(tiempo_usu,1,4))
            {
             tiempo_usu=entrada.nextDouble();
            }//validar el ingreso
            return tiempo_usu;
        }
        private static double tiempo_descanso(double topeTrabajo)
        {
            if (topeTrabajo<2.5) {
                
            System.out.println("Ahora elija el tiempo de descanso luego de su actividad de trabajo");  
                System.out.println("Puede variar entre 10 y 30 minutos.");
                int aux =45676875;
                while(validarInt(aux,10,30))
                {
                    aux =entrada.nextInt();
                }
                return aux;
            }
            else
            {
                return 30;
            }
        }
        
        private  static void comienzo_actividad()
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
            double total_act=0;
            while(validarDouble(total_act,4,10))
            {
                total_act=entrada.nextDouble();
            }
            double pDecimal=total_act-(int)total_act;
            setTopeTotal((int)total_act*60+(int)(pDecimal*60));
        }
        private static boolean validarDouble(double numero,double topeBajo, double topeAlto)
        {
            if(numero<topeBajo&&numero>topeAlto)
            {
                System.out.println("Dato invalido, por favor intente nuevamente");
                return true;
            }
            else
            {
                return false;
            } 
                
            
            
        }
        
        private static boolean validarInt(int numero,int topeBajo,int topeAlto)
        {
            if(numero<topeBajo&&numero>topeAlto)
            {
                System.out.println("Dato invalido, intente nuevamente");
                return true;
            }
            else
            {
                
                return false;
            }
            
        }
        
        
    }
