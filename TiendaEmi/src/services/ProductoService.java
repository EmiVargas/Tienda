/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Producto;
import java.util.List;
import java.util.Scanner;
import persistence.ProductoDAO;

/**
 *
 * @author Usuario
 */
public class ProductoService {

    ProductoDAO pd = new ProductoDAO();

    public void mostrarNombres() {
        List<Producto> productos = pd.findAll();

        for (Producto producto : productos) {
            System.out.println(producto.getNombre());
        }

    }

    public void mostrarNombreyPrecio() {
        List<Producto> productos = pd.findAll();

        for (Producto producto : productos) {
            System.out.println(producto.getCodigo());
            System.out.println(producto.getNombre());
        }
    }

    public void mostrarPrecioEntre(int num1, int num2) {
        List<Producto> productos = pd.findAll();

        for (Producto producto : productos) {
            if (producto.getPrecio() > num1 && producto.getPrecio() < num2) {
                System.out.println(producto);
            }
        }
    }

    public void mostrarPortatiles() {
        List<Producto> productos = pd.findAllPortatiles();

        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }

    public void insertProducto() {
        Producto p = new Producto();
        Scanner sc = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Ingrese el nombre del producto");
        p.setNombre(sc.next());
        System.out.println("Ingrese el precio del producto");
        p.setPrecio(Double.valueOf(sc.next()));
        System.out.println("Ingrese el codigo de fabricante");
        p.setCodigoFabricante(sc.nextInt());
        pd.insert(p);
    }

    public void mostrarCodigoyNombre() {
        List<Producto> productos = pd.findAll();
        for (Producto producto : productos) {
            System.out.println(producto.getNombre() + ", Código: " + producto.getCodigo());
        }
    }

    public void UpdateProducto() {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Elija el producto que quiere modificar:\n");
        mostrarCodigoyNombre();
        System.out.println("Ingrese el codigo del producto a modificar");
        int p = sc.nextInt();
        System.out.println("ingrese el nuevo nombre");
        String nomb = sc.next();
        System.out.println("Ingrese el nuevo precio");
        Double pre = sc.nextDouble();
        System.out.println("Ingrese el nuevo codigo de fabricante");
        Integer cod = Integer.valueOf(sc.next());
        Producto prod = new Producto(nomb, pre, cod);
        pd.update(prod, p);
    }

    public void deleteProducto() {
        mostrarCodigoyNombre();
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese el codigo del producto a eliminar");
        int codigo = sc.nextInt();
        pd.deleteById(codigo);
    }

    public void mostrarNombresyFabricantes(){
        List<String> productos = pd.findAllJoin();
        
        for (String producto : productos) {
            System.out.println(producto);
        }
    }
}
