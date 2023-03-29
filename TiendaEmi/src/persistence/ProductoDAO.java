/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import entities.Producto;
import java.sql.*;
import java.util.*;
import static persistence.Conexion.*;

public class ProductoDAO {

    private static final String SQL_INSERT = "INSERT INTO producto(nombre,precio,codigo_fabricante) VALUES(?, ?, ?)";
    private static final String SQL_READ = "SELECT * FROM producto";
    private static final String SQL_READ_JOIN = "SELECT p.nombre,f.nombre FROM producto p INNER JOIN fabricante f on p.codigo_fabricante = f.codigo;";
    private static final String SQL_READ_BY_ID = "SELECT * FROM producto WHERE codigo= ?";
    private static final String SQL_UPDATE = "UPDATE producto SET nombre = ?, precio = ?, codigo_fabricante = ? WHERE codigo = ?";
    private static final String SQL_DELETE = "DELETE FROM producto WHERE codigo = ?";
    private static final String SQL_FIND_LIKE = "SELECT * FROM producto WHERE nombre LIKE '%portatil%'";

    public List<Producto> findAll() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Producto prod;
        List<Producto> productos = new ArrayList();

        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_READ);
            rs = stmt.executeQuery();
            while (rs.next()) {

                int cod = rs.getInt(1);
                String nombre = rs.getString(2);
                double precio = rs.getDouble(3);
                int codigoFabricante = rs.getInt(4);

                prod = new Producto(cod, nombre, precio, codigoFabricante);

                productos.add(prod);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return productos;
    }

    public List<String> findAllJoin() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<String> productos = new ArrayList();

        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_READ_JOIN);
            rs = stmt.executeQuery();
            while (rs.next()) {

                String nombre = rs.getString(1);
                String fabricante = rs.getString(2);

                String prod = nombre + " Fabricante: " + fabricante;

                productos.add(prod);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return productos;
    }

    public Producto findById(int codigo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Producto prod = null;

        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_READ_BY_ID);
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();

            while (rs.next()) {

                int cod = rs.getInt(1);
                String nombre = rs.getString(2);
                double precio = rs.getDouble(3);
                int codigoFabricante = rs.getInt(4);

                prod = new Producto(cod, nombre, precio, codigoFabricante);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return prod;
    }

    public int insert(Producto prod) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setString(1, prod.getNombre());
            stmt.setDouble(2, prod.getPrecio());
            stmt.setInt(3, prod.getCodigoFabricante());

            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int deleteById(int codigo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, codigo);
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int update(Producto prod, int codigo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, prod.getNombre());
            stmt.setDouble(2, prod.getPrecio());
            stmt.setInt(3, prod.getCodigoFabricante());
            stmt.setInt(4, codigo);

            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public List<Producto> findAllPortatiles() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Producto prod;
        List<Producto> productos = new ArrayList();

        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_FIND_LIKE);
            rs = stmt.executeQuery();
            while (rs.next()) {

                int cod = rs.getInt(1);
                String nombre = rs.getString(2);
                double precio = rs.getDouble(3);
                int codigoFabricante = rs.getInt(4);

                prod = new Producto(cod, nombre, precio, codigoFabricante);

                productos.add(prod);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return productos;
    }
}
