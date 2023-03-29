package services;

import java.util.Scanner;
import entities.Fabricante;
import entities.Producto;
import services.FabricanteService;
import services.ProductoService;

public class Menu {

    Scanner sc = new Scanner(System.in).useDelimiter("\n");

    public void menu() throws Exception {

        ProductoService ps = new ProductoService();
        FabricanteService fs = new FabricanteService();

        System.out.println("---------------------- M E N U ----------------------");
        System.out.println("Ingresa una opcion:\n1- Listar el nombre de todos los productos.\n2- Listar los nombres y los precios de todos los productos.\n3- Listar productos según precio (desde-hasta).\n4-Listar todos los Portátiles.\n5- Ingresar un nuevo producto.\n6- Ingresar un nuevo fabricante.\n7- Editar un producto.\n8- Eliminar un producto.\n9-Mostrar los fabricantes.\n10- Eliminar un fabricante. \n11- Mostrar productos y fabricantes\n12- Salir");
        String opc = sc.next();

        switch (opc) {
            case "1" -> {
                ps.mostrarNombres();
                menu();
            }
            case "2" -> {
                ps.mostrarNombreyPrecio();
                menu();
            }
            case "3" -> {
                try {
                    System.out.println("Ingrese el numero menor");
                    int num1 = sc.nextInt();
                    System.out.println("Ingrese el numero mayor");
                    int num2 = sc.nextInt();
                    ps.mostrarPrecioEntre(num1, num2);
                } catch (Exception e) {
                    e.printStackTrace(System.out);
                }
                menu();
            }
            case "4" -> {
                ps.mostrarPortatiles();
                menu();
            }

            case "5" -> {
                ps.insertProducto();
                System.out.println("Producto agregado con exito!");
                menu();
            }
            case "6" -> {
                fs.insertFabricante();
                menu();
            }
            case "7" -> {
                ps.UpdateProducto();
                menu();
            }
            case "8" -> {
                ps.deleteProducto();
                menu();
            }
            case "9" -> {
                fs.mostrarFabricantes();
                menu();
            }
            case "10" -> {
                fs.deleteFabricante();
                menu();
                System.out.println("Fabricante eliminado con exito");
            }
            case "11" ->{
               ps.mostrarNombresyFabricantes();
               menu();
        }
            case "12" ->{
                System.out.println("Gracias por utilizar el programa");
            }
            default -> {
                System.out.println("Opcion incorrecta Intente de nuevo");
                menu();
            }
        }

    }

}
