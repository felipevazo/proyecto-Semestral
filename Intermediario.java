/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectosemestral;

import java.util.ArrayList;


/**
 *
 * @author Felipe
 */

//Clase que hace de todo, pero no sabe nada.
public class Intermediario {
    private double topeTrabajo,topeDescanso;
    private int topeTotal;
    private int contadorTotal=0;
    private String actividad;
    private ArrayList<String> listaActividades=new ArrayList<String>();
    private Validaciones val =new Validaciones();

    public double getTopeTrabajo() {
        return topeTrabajo;
        
    }

    public ArrayList<String> getListaActividades() {
        return listaActividades;
    }

    public void setListaActividades(ArrayList<String> listaActividades) {
        this.listaActividades = listaActividades;
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

    public int getContadorTotal() {
        return contadorTotal;
    }

    public void setContadorTotal(int contadorTotal) {
        this.contadorTotal = contadorTotal;
    }
    public void ventana2()
    {
        Ventana2 v=new Ventana2();
        v.setVisible(true);
        
    }
    public void siguienteVentana()
    {
        //Llama a metodo escribeNumeros en clase EscribeFichero
        //Pasa a siguiente ventana
        EscribeFichero escribe=new EscribeFichero();
        escribe.escribeNumeros(topeTrabajo, topeDescanso, topeTotal);
        Ventana3 v2=new Ventana3();
        
        v2.setVisible(true);
    }
    public  void guardar(boolean libro,boolean caminata,boolean bebida,boolean instrumento,boolean musica) {
        //Variable ingreso: boolean,boolean,boolean,boolean,boolean
        //Llama metodo escribeTodo en clase EscribeFichero
        //LLama metodo seleccion de actividades en clase GestionActividades
        //Llama metodo 
        EscribeFichero escribe=new EscribeFichero();
        GestionActividades g=new GestionActividades();
        g.seleccionActividades(libro, caminata, bebida, instrumento, musica);
        setListaActividades(g.getListaActividades());
        escribe.escribeTodo(listaActividades);
      
    }
    public void ventana4()
    {
        //Instancia Ventana4
          Ventana4 v=new Ventana4();
        v.setVisible(true);
    }
    public void ventanaConfirmacion()
    {
        //Instancia VentanaConfirmacion
        VentanaConf v=new VentanaConf();
        v.setVisible(true);
    }
  
    public void contadorTrabajo() throws InterruptedException
    {
        //Llama metodo ArrayAlumnos en clase LeeFichero
        //LLama contador en clase GestionContador
        //LLama metodo elegirActividad y ventanaActividad en misma clase
        
       LeeFichero l=new LeeFichero();
       l.ArrayNumeros();
       topeTrabajo=val.stringDouble(l.devolverNumero(0));
       topeDescanso=val.stringDouble(l.devolverNumero(1));
       topeTotal=(int)val.stringDouble(l.devolverNumero(2));
        GestionContador g=new GestionContador();
        g.contador(topeTrabajo, contadorTotal, topeTotal*60);
        elegirActividad();
        ventanaActividad();
    }
    private void elegirActividad()
    {
        //Llama metodo pasarArray en LeeFichero
        
        GestionActividades g=new GestionActividades();
        LeeFichero l=new LeeFichero();
        l.pasarArray();
        
        ArrayList<String> aux=new ArrayList<String>();
        //En ciclo llama metodo devolverString en LeeFichero
        
        for (int i = 3; i <l.devolverTamaño() ; i++) {
            aux.add(l.devolverString(i));
            
        }
        //variable actividad toma valor de metodo actividades en clase GestionActividades
        g.setListaActividades(aux);

        this.actividad=g.actividades(aux.size());
        
    }
    private void ventanaActividad()
    {
        //Instancia ventana5
        Ventana5 v=new Ventana5();
        v.evento(this.actividad);
        v.setVisible(true);
        
    }
    public void contadorDescanso() throws InterruptedException
    {
        //Llama metodo contador
        GestionContador g=new GestionContador();
        this.contadorTotal=g.contador(topeDescanso, contadorTotal, topeTotal);
        
    }

    boolean buscaLineaVacia() {
        //Llama metodo lineaVacia en clase Validador
        return val.lineaVacia();
    }
    
}
