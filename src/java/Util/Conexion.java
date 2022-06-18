package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion 
{
    public static Connection getConexion() throws SQLException{
        Connection conn;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/insteduc?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false","root","root");
        return conn;
    }		
} 