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

    /**
     * retorna topeTrabajo
     * @return 
     */
    public double getTopeTrabajo() {
        return topeTrabajo;
        
    }

    /**
     * retorna listaActividades
     * @return 
     */
    public ArrayList<String> getListaActividades() {
        return listaActividades;
    }

    /**
     * ingresa arraylist listaActividades
     * @param listaActividades 
     */
    public void setListaActividades(ArrayList<String> listaActividades) {
        this.listaActividades = listaActividades;
    }

    /**
     * ingresa double topeTrabajo
     * @param topeTrabajo 
     */
    public void setTopeTrabajo(double topeTrabajo) {
        this.topeTrabajo = topeTrabajo;
    }

    /**
     * retorna topeDescanso
     * @return 
     */
    public double getTopeDescanso() {
        return topeDescanso;
    }

    /**
     * ingresa double topeDescanse
     * @param topeDescanso 
     */
    public void setTopeDescanso(double topeDescanso) {
        this.topeDescanso = topeDescanso;
    }

    /**
     * retorna topeTotal
     * @return 
     */
    public int getTopeTotal() {
        return topeTotal;
    }

    /**
     * ingresa int topeTotal
     * @param topeTotal 
     */
    public void setTopeTotal(int topeTotal) {
        this.topeTotal = topeTotal;
    }

    /**
     * retorna contadorTotal
     * @return 
     */
    public int getContadorTotal() {
        return contadorTotal;
    }

    /**
     * ingresa int cotadorTotal
     * @param contadorTotal 
     */
    public void setContadorTotal(int contadorTotal) {
        this.contadorTotal = contadorTotal;
    }
    
    /**
     * crea objeto ventana y la muestra
     */
    public void ventana2() {
        Ventana2 v=new Ventana2();
        v.setVisible(true);
        
    }
    
    /**
     * Llama a metodo escribeNumeros en clase EscribeFichero
     * Pasa a siguiente ventana
     */
    public void siguienteVentana() {
        //Llama a metodo escribeNumeros en clase EscribeFichero
        //Pasa a siguiente ventana
        EscribeFichero escribe=new EscribeFichero();
        escribe.escribeNumeros(topeTrabajo, topeDescanso, topeTotal);
        Ventana3 v2=new Ventana3();
        
        v2.setVisible(true);
    }
    
    /**
     * Variable ingreso: boolean,boolean,boolean,boolean,boolean
     * Llama metodo escribeTodo en clase EscribeFichero
     * LLama metodo seleccion de actividades en clase GestionActividades
     * Llama metodo 
     * @param libro
     * @param caminata
     * @param bebida
     * @param instrumento
     * @param musica 
     */
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
    
    /**
     * instancia ventana4
     */
    public void ventana4() {
        //Instancia Ventana4
          Ventana4 v=new Ventana4();
        v.setVisible(true);
    }
    
    /**
     * instancia ventantaConfirmacion
     */
    public void ventanaConfirmacion() {
        //Instancia VentanaConfirmacion
        VentanaConf v=new VentanaConf();
        v.setVisible(true);
    }
  
    /**
     * Llama metodo ArrayAlumnos en clase LeeFichero
     * LLama contador en clase GestionContador
     * LLama metodo elegirActividad y ventanaActividad en misma clase
     * @throws InterruptedException 
     */
    public void contadorTrabajo() throws InterruptedException {
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
    
    /**
     * llama metodo pasarArray en LeeFichero
     */
    private void elegirActividad() {
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
    
    /**
     * instancia ventana5
     */
    private void ventanaActividad() {
        //Instancia ventana5
        Ventana5 v=new Ventana5();
        v.evento(this.actividad);
        v.setVisible(true);   
    }
    
    /**
     * llama metodo contador
     * @throws InterruptedException 
     */
    public void contadorDescanso() throws InterruptedException {
        //Llama metodo contador
        GestionContador g=new GestionContador();
        this.contadorTotal=g.contador(topeDescanso, contadorTotal, topeTotal);  
    }
    
    /**
     * llama metodo lineaVacia en clase validador
     * @return 
     */
    boolean buscaLineaVacia() {
        //Llama metodo lineaVacia en clase Validador
        return val.lineaVacia();
    }  
}