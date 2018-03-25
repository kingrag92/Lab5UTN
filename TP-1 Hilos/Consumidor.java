/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luciano
 */
public class Consumidor extends Persona implements Runnable {

    private Cerveza favorita;
    private Cerveceria lugar;
    private Boolean satisfecho;
    
    public Consumidor(){
    super();
    this.favorita=null;
    this.lugar=null;
    this.satisfecho=false;
    }
    
    public Consumidor(String nombre, String apellido, Integer edad){
    super(nombre,apellido,edad);
    this.favorita=null;
    this.lugar=null;
    this.satisfecho=false;
    }
    
    
    @Override
    public void run() {  
        try{
        while (this.getSatisfecho() == false) {
                getLugar().vender(this);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
		e.printStackTrace();
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @return the favorita
     */
    public Cerveza getFavorita() {
        return favorita;
    }

    /**
     * @param favorita the favorita to set
     */
    public void setFavorita(Cerveza favorita) {
        this.favorita = favorita;
    }

    /**
     * @return the lugar
     */
    public Cerveceria getLugar() {
        return lugar;
    }

    /**
     * @param lugar the lugar to set
     */
    public void setLugar(Cerveceria lugar) {
        this.lugar = lugar;
    }

    /**
     * @return the satisfecho
     */
    public Boolean getSatisfecho() {
        return satisfecho;
    }

    /**
     * @param satisfecho the satisfecho to set
     */
    public void setSatisfecho(Boolean satisfecho) {
        this.satisfecho = satisfecho;
    }
       
}
