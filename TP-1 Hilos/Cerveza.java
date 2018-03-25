/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luciano
 */
public class Cerveza {
    private String nombre;
    
    public Cerveza(){
    this.nombre="";
    }
    public Cerveza(String nombre){
    this.nombre=nombre;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String toString(){
        String mensaje="El nombre de la cerveza es: "+this.getNombre();
        return mensaje;
    }
    
    public Cerveza cerveza(String nombre){
        Cerveza nueva=new Cerveza();
        nueva.setNombre(nombre);
        return nueva;
    }
}
