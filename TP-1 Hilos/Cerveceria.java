
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luciano
 */
public class Cerveceria {
    private String nombre;
    private String direccion;
    private ArrayList<Cerveza> stock;
    private Boolean disponible;
    private Boolean stockMax;
    
    public Cerveceria(){
        this.nombre="";
        this.direccion="";
        this.stock=new ArrayList<Cerveza>();
        this.disponible=true;
        this.stockMax=false;
    }
    public Cerveceria(String nombre, String direccion){
        this.nombre=nombre;
        this.direccion=direccion;
        this.stock=new ArrayList<Cerveza>();
        this.disponible=true;
        this.stockMax=false;
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

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the stock
     */
    public ArrayList<Cerveza> getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(ArrayList<Cerveza> stock) {
        this.stock = stock;
    }

    /**
     * @return the disponible
     */
    public Boolean getDisponible() {
        return disponible;
    }

    /**
     * @param disponible the disponible to set
     */
    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    /**
     * @return the stockMax
     */
    public Boolean getStockMax() {
        return stockMax;
    }

    /**
     * @param stockMax the stockMax to set
     */
    public void setStockMax(Boolean stockMax) {
        this.stockMax = stockMax;
    }
    public boolean conStock() {
        if (this.stock.size() == 0 || this.stock == null) {
            return true;
	} else {
            return false;
	}
    }
    
    public synchronized void vender(Object person) throws InterruptedException {
		if (person.getClass().equals(Productor.class)) {
			if (this.stock == null) {
				this.stock = new ArrayList<Cerveza>();
			}
			if (!this.getDisponible()) {
				wait();
			} else {
				this.setDisponible(false);
				reponer((Productor) person);
				this.setDisponible(true);
				notifyAll();
			}
		} else {
			if (stock != null) {
				if (stock.size() <= 0) {
					System.out.println(((Consumidor) person).getNombre() + " se encuentra que " + "no tiene stock de cerveza");
				} else {
					try {
						while (this.getDisponible().equals(false)) {
							wait();
						}
						this.setDisponible(false);
						vender((Consumidor) person);
						this.setDisponible(true);
						notifyAll();

					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			}
		}

	}
    
    
    private synchronized void reponer(Productor productor) throws InterruptedException {
		if (this.getStockMax().equals(false)) {
			stock.add(productor.crearCerveza());
			System.out.println("El productor " + productor.getNombre()+ " produce cerveza: ");
			System.out.println("El stock es de " + this.stock.size() + "\n");
			if (stock.size() == 100) {
				this.setStockMax(true);
			}
		} else {
			System.out.println("El productor " + productor.getNombre() + " ve que el bar tiene stock completo \n ");
		}

	}
    
    
    private synchronized void vender(Consumidor consumidor) throws InterruptedException {
		int flag = 0;
		for (Cerveza beer : stock) {
			if (beer.getNombre().equals(consumidor.getFavorita().getNombre())) {
				stock.remove(beer);
				System.out.println("Quedan "+ this.stock.size() + " cervezas en el bar\n");
				flag = 1;
				break;
			}

		}
		if (flag == 0) {
			Cerveza elegida = stock.remove(0);
			System.out.println(consumidor.getNombre() + " toma una " + elegida.getNombre()
					+ ". \n Quedan " + this.stock.size() + " cervezas en el bar\n");
		}

	}
    
}
