
package persistence;


import java.sql.*;

public class Conexion {
    private static final String JDBC_URL="jdbc:mysql://localhost:3306/tienda?useSSL=false&useTimeZone=true&serverTimeZone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USR ="root";
    private static final String JDBC_PASS ="root";
    
    public static Connection getConexion() throws SQLException{
        return DriverManager.getConnection(JDBC_URL,JDBC_USR,JDBC_PASS);
    }
    
    public static void close(ResultSet rs) throws SQLException{
        rs.close();
    }
    
    public static void close(Statement st) throws SQLException{
        st.close();
    }
    
    public static void close(Connection cn) throws SQLException{
        cn.close();
    }
}
