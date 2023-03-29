/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import entities.Fabricante;
import java.sql.*;
import java.util.*;
import static persistence.Conexion.*;

/**
 *
 * @author Usuario
 */
public class FabricanteDAO {

    private static final String SQL_INSERT = "INSERT INTO fabricante(nombre) VALUES(?)";
    private static final String SQL_READ = "SELECT * FROM fabricante";
    private static final String SQL_READ_BY_ID = "SELECT * FROM fabricante WHERE codigo= ?";
    private static final String SQL_UPDATE = "UPDATE fabricante SET nombre = ? WHERE codigo = ?";
    private static final String SQL_DELETE = "DELETE FROM fabricante WHERE codigo = ?";

    public List<Fabricante> findAll() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Fabricante fab;
        List<Fabricante> fabricantes = new ArrayList();

        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_READ);
            rs = stmt.executeQuery();
            while (rs.next()) {

                int codigo = rs.getInt(1);
                String nombre = rs.getString(2);

                fab = new Fabricante(codigo, nombre);

                fabricantes.add(fab);
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

        return fabricantes;
    }

    public Fabricante findById(int codigo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Fabricante fab = null;

        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_READ_BY_ID);
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();

            while (rs.next()) {

                int cod = rs.getInt(1);
                String nombre = rs.getString(2);

                fab = new Fabricante(cod, nombre);
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
        return fab;
    }

    public int insert(Fabricante fab) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setString(1, fab.getNombre());

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

    public int update(Fabricante fab) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, fab.getNombre());
            stmt.setInt(2, fab.getCodigo());

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
}
