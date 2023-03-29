/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Fabricante;
import java.util.List;
import java.util.Scanner;
import persistence.FabricanteDAO;

/**
 *
 * @author Usuario
 */
public class FabricanteService {

    FabricanteDAO fd = new FabricanteDAO();
    
    public void mostrarFabricantes(){
        System.out.println("Fabricantes: ");
        List<Fabricante> fabricantes = fd.findAll();
        for (Fabricante fabricante : fabricantes) {
            System.out.println(fabricante);
        }
    }
    
    public void insertFabricante() {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
       Fabricante f = new Fabricante();
       System.out.println("Ingrese el nombre del fabricante");
        f.setNombre(sc.next());
        fd.insert(f);
    }

    void deleteFabricante() {
        mostrarFabricantes();
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese el codigo del producto a eliminar");
        int codigo = sc.nextInt();
        fd.deleteById(codigo);
    }
    
}
