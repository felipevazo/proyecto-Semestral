/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectosemestral;

import java.util.ArrayList;


/**
 *
 * @author dci
 */
public class GestionActividades {

    public ArrayList<String> getListaActividades() {
        return listaActividades;
    }

    public void setListaActividades(ArrayList<String> listaActividades) {
        this.listaActividades = listaActividades;
    }
    
    private ArrayList<String> listaActividades=new ArrayList<String>();
    Validaciones val=new Validaciones();
    public double topeTrabajo, topeDescanso;
    public int topeTotal, contadorTope;

    public double getTopeTrabajo() {
        return topeTrabajo;
    }

    public void setTopeTrabajo(double topeTrabajo) {
        this.topeTrabajo = topeTrabajo;
    }

    public double getTopeDescanso() {
        return topeDescanso;
    }

    public void setTopeDescanso(double topeDescanso) {
        this.topeDescanso = topeDescanso;
    }

    public int getTopeTotal() {
        return topeTotal;
    }

    public void setTopeTotal(int topeTotal) {
        this.topeTotal = topeTotal;
    }

    public int getContadorTope() {
        return contadorTope;
    }

    public void setContadorTope(int contadorTope) {
        this.contadorTope = contadorTope;
    }
    public void seleccionActividades(boolean libro,boolean caminata,boolean bebida,boolean instrumento,boolean musica )
        {
            //Se crea una variable resp por mientras que aprendemos a interactuar con ventanas.
            
            //Actividades tentativas
           
           
            if(libro==true)
            {
                listaActividades.add("Leer parrafos de libros.");
            }
            if(musica==true)
            {
                listaActividades.add("Reproducir musica relajante, acompañada de imagenes");
                
                
            }
            if(bebida==true)
            {
                listaActividades.add("Un momento de descanso, con un cigarro y un cafe, alejado del computador.");
            }
            if(caminata==true)
            {
                listaActividades.add("Una caminata por su sector");
            }
            if(instrumento==true)
            {
                listaActividades.add("Interpretar canciones para distraerse.");
            }
            
            //aquí hay que colocar imagenes en una ventana, creo que queda mejor así que ir preguntando uno por uno y que el usuario
            //decida si o no. Supuestamente lo veremos mas adelante, asi que se puede hacer
            
            //la imagen podria guardar datos en el arraylist que instancie arriba, para que sea mas facil obtener los topes luego(usando el arraylist.size y todo eso)
        }
    public String actividades(int numeroActividades)
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
              
                if(val.buscaLinea(listaActividades.get(i-1),".*parrafos.*"))
                {
                    return "Se abrira un parrafo de un libro aleatorio, para que ud disfrute de una distraccion sutil.";
                    //Aqui se abre el archivo de texto estatico 
                }
                else if(val.buscaLinea(listaActividades.get(i-1),".*musica.*"))
                {
                     return "a continuacion sonara musica relajante, mientras aparecen un par de imagenes para ayudar a la distraccion.";
                     
                }
                else if(val.buscaLinea(listaActividades.get(i-1),".*cafe.*"))
                {
                    return "Preparese un cafe con calma, prenda su cigarro(o solamente el cafe, o un té, una leche por ultimo, como ud prefiera) y tome su tiempo para degustarlo.";
                }
                else if(val.buscaLinea(listaActividades.get(i-1),".*caminata.*"))
                {
                    return "Momento de una caminata, de una vuelta por su calle, tome aire y disfrute de la vista.";
                }
                else if(val.buscaLinea(listaActividades.get(i-1),".*canciones.*"))
                {
                    return "Disfrute de interpretar sus canciones favoritas en su instrumento deseado.";
                    //Se podria añadir una pagina web con acordes, para ayudar a pensar cosas que tocar.
                }
                else
                {
                    return "Momento de hacer literalmente.. nada, apague la pantalla unos minutos, mire a la nada y piense, disfrute de este momento de su vida haciendo absolutamente nada.";
                }
        
        //Avanzando, esto debería tomar mas opciones, desplegar en la misma pantalla actividades a realizar.
        //O directamente un cafe con un cigarro, a gusto del usuario(dentro de las opciones que el mismo programa barajará).
    } 
    
}
