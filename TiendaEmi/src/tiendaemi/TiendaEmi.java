/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tiendaemi;

import java.util.logging.Level;
import java.util.logging.Logger;
import services.Menu;

/**
 *
 * @author Usuario
 */
public class TiendaEmi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Menu m = new Menu();
        try {
            m.menu();
        } catch (Exception ex) {
           ex.printStackTrace(System.out);
        }
    }
    
}
