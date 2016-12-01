/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectosemestral;

import java.awt.Desktop;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import javazoom.jl.decoder.JavaLayerException;


/**
 *
 * @author dci
 */
public class GestionActividades {
    String actividad;

    public ArrayList<String> getListaActividades() {
        //Retorna ArrayList listaActividades
        return listaActividades;
    }

    public void setListaActividades(ArrayList<String> listaActividades) {
        //SetArrayList(listaActividades)
        this.listaActividades = listaActividades;
    }
    
    private ArrayList<String> listaActividades=new ArrayList<String>();
    Validaciones val=new Validaciones();
    public double topeTrabajo, topeDescanso;
    public int topeTotal, contadorTope;

    public double getTopeTrabajo() {
        return topeTrabajo;
         //Retorna double topeTrabajo
    }

    public void setTopeTrabajo(double topeTrabajo) {
        //Ingresa double.
        this.topeTrabajo = topeTrabajo;
        
    }

    public double getTopeDescanso() {
         //Retorna double topeDescanso
        return topeDescanso;
    }
    public void setActividad(String actividad);
    {
        this.actividad=actividad;
    }
    
    public void setTopeDescanso(double topeDescanso) {
        //Ingresa Double
        this.topeDescanso = topeDescanso;
    }

    public int getTopeTotal() {
        //Retorna Int topeTotal
        return topeTotal;
    }

    public void setTopeTotal(int topeTotal) {
        //Ingresa int
        this.topeTotal = topeTotal;
    }

    public int getContadorTope() {
        //Retorna int getContadorTope
        return contadorTope;
    }

    public void setContadorTope(int contadorTope) {
        //Ingresa int
        this.contadorTope = contadorTope;
    }
    public void seleccionActividades(boolean libro,boolean caminata,boolean bebida,boolean instrumento,boolean musica )
        {
            
        
            //Ingresan 5 booleans, por cada 1 se guarda opcion en arrayList
            //En orden "Leer parrafos de libros","Reproducir musica relajante","Momento de descanso, con un cigarro y un cafe","Una caminata por su sector","Interpretar canciones para distraerse"
        
           
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

            
            
        }
    public String actividades(int numeroActividades)
    {
        //Ingresa int numeroActividades
        //Retorna String de ArrayList listaActividades al azar.
        int i=(int)(Math.random()*(numeroActividades-1)+1 );

              
                if(val.buscaLinea(listaActividades.get(i-1),".*parrafos.*"))
                {
                    actividad="Se abrira un parrafo de un libro aleatorio, para que ud disfrute de una distraccion sutil.";
                    return actividad;
                   
                }
                else if(val.buscaLinea(listaActividades.get(i-1),".*musica.*"))
                {
                    actividad="a continuacion sonara musica relajante, mientras aparecen un par de imagenes para ayudar a la distraccion.";
                     return actividad;
                     
                }
                else if(val.buscaLinea(listaActividades.get(i-1),".*cafe.*"))
                {
                    actividad="Disfrutar de una bebida caliente, acompañada con lo que usted prefiera.";
                    return actividad;
                }
                else if(val.buscaLinea(listaActividades.get(i-1),".*caminata.*"))
                {
                    actividad="Momento de una caminata, de una vuelta por su calle, tome aire y disfrute de la vista.";
                    return actividad;
                }
                else if(val.buscaLinea(listaActividades.get(i-1),".*canciones.*"))
                {
                    
                    actividad="Disfrute de interpretar sus canciones favoritas en su instrumento deseado.";
                    return actividad;
                }
                else
                {
                    return "Bonus, este tiempo será liberado, puede hacer lo que ud prefiera.";
                }
        
    }
    public void abrirLibro()
    {
        // Abre ventana Textos
        LeeFichero l=new LeeFichero();
                    
                   Textos t=new Textos();
                    for (int i = 0; i < 20; i++) {
                        l.devolverLibro();
                        String str=l.devolverLinea(i);
                        t.sumarParrafo(str,i);
                        t.setVisible(true);
                    }
    }
    public void abrirActividad() throws JavaLayerException, FileNotFoundException{
        //Abre alguna actividad elegida anteriormente
        
         if(val.buscaLinea(actividad,".*parrafos.*"))
                {
                    
                   abrirLibro();
                   
                }
                else if(val.buscaLinea(actividad,".*musica.*"))
                {
                    //VENTANA IMAGENES
                    Reproductor r=new Reproductor();
                    r.reproducir();
                   
                     
                }
                else if(val.buscaLinea(actividad,".*cafe.*"))
                {
                   
                    
                }
                else if(val.buscaLinea(actividad,".*caminata.*"))
                {
                   
                }
                else if(val.buscaLinea(actividad,".*canciones.*"))
                {
                   abrirPaginaWeb();
                    
                }
                else
                {
                   
                }
        
    }

    public void abrirPaginaWeb()
    {
        //Abre pagina con acordes
        String urlString="http://www.lacuerda.net";
    try {
        Desktop.getDesktop().browse(new URL(urlString).toURI());
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
}
