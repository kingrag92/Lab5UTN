/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luciano
 */
public class Productor extends Persona implements Runnable {
    private Cerveceria cerveceria;
    private Cerveza cerveza;
    
    public Productor(){
        super();
        this.cerveceria=null;
        this.cerveza=null;
    }
    
    public Productor(String nombre, String apellido, Integer edad){
        super(nombre,apellido,edad);
        this.cerveceria=null;
        this.cerveza=null;
    }

    public Cerveza crearCerveza() {
		return new Cerveza(getNombre());
    }
    
    @Override
    public void run() {
       try {
            while (cerveceria.getDisponible()==true) {
                cerveceria.vender(this);
		try {
                    Thread.sleep(1000);
		} catch (InterruptedException ex) {
                    ex.printStackTrace();
		}
			}
		} catch (Exception e) {
                    e.printStackTrace();
		}
    }

    /**
     * @return the cerveceria
     */
    public Cerveceria getCerveceria() {
        return cerveceria;
    }

    /**
     * @param cerveceria the cerveceria to set
     */
    public void setCerveceria(Cerveceria cerveceria) {
        this.cerveceria = cerveceria;
    }

    /**
     * @return the cerveza
     */
    public Cerveza getCerveza() {
        return cerveza;
    }

    /**
     * @param cerveza the cerveza to set
     */
    public void setCerveza(Cerveza cerveza) {
        this.cerveza = cerveza;
    }
    
}
