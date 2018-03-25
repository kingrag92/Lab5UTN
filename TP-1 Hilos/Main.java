/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luciano
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // creo la cerveceria
       Cerveceria cerveceria=new Cerveceria("Cheverry"," Constitucion 4852");
       
       //creo las cervezas
       Cerveza beer1=new Cerveza("Red IPA");
       Cerveza beer2=new Cerveza("APA");
       
       //creo productor y asigno cerveza y lugar
       Productor productor1=new Productor("Luis","Ventura", 49);
       productor1.setCerveza(beer1);
       productor1.setCerveceria(cerveceria);
       
       Productor productor2=new Productor("Diego","Maradona",59);
       productor2.setCerveza(beer2);
       productor2.setCerveceria(cerveceria);
       
       Productor productor3=new Productor("Franco","Armani", 30);
       productor3.setCerveza(beer1);
       productor3.setCerveceria(cerveceria);
       
       Productor productor4=new Productor("Guillermo","Barros Schelotto", 55);
       productor4.setCerveza(beer2);
       productor4.setCerveceria(cerveceria);
       
       
       // creo clientes para consumir cerveza
      Consumidor con1=new Consumidor("Luciano","Perello",25);
      con1.setFavorita(beer1);
      con1.setLugar(cerveceria);
      
      Consumidor con2=new Consumidor("Facundo","Vega",28);
      con2.setFavorita(beer2);
      con2.setLugar(cerveceria);
      
      
      
      //creo los hilos y le doy start
      Thread t5 = new Thread(con1);
      Thread t6 = new Thread(con2);
      Thread t1 = new Thread(productor1);
      Thread t2 = new Thread(productor2);
      Thread t3 = new Thread(productor3);
      Thread t4 = new Thread(productor4);

      t5.start();
      t6.start();
      t1.start();
      t2.start();
      t3.start();
      t4.start();
      

      
       
    }
    
}
