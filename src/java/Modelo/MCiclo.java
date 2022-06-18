/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Entidad.Ciclo;
import Util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jose
 */
public class MCiclo {

    public int InsertaCiclo(Ciclo obj) {

        int salida = -1;
        try {
            Connection conn;
            PreparedStatement psmt;

            conn = Conexion.getConexion();
            String sql = "insert into ciclo values (null,?,?)";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, obj.getCiclo());
            psmt.setString(2, obj.getDescripcion());

            salida = psmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MCiclo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }

    public List<Ciclo> listaCiclo() {
        List<Ciclo> data = new ArrayList<>();
        try {

            Connection conn;

            PreparedStatement psmt;

            ResultSet rs;

            conn = Conexion.getConexion();
            String sql = "Select * from ciclo";
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();

            Ciclo obj;

            while (rs.next()) {
                obj = new Ciclo();
                obj.setIdCiclo(rs.getInt("idCiclo"));
                obj.setCiclo(rs.getString("Ciclo"));
                obj.setDescripcion(rs.getString("Descripcion"));
                data.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MCiclo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public Ciclo BuscarCiclo(int idCiclo) {
        Ciclo obj = null;
        try {

            Connection conn;

            PreparedStatement psmt;

            ResultSet rs;

            conn = Conexion.getConexion();
            String sql = "Select * from ciclo where idCiclo=?";
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, idCiclo);
            rs = psmt.executeQuery();

            while (rs.next()) {
                obj = new Ciclo();
                obj.setIdCiclo(rs.getInt("idCiclo"));
                obj.setCiclo(rs.getString("Ciclo"));
                obj.setDescripcion(rs.getString("Descripcion"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MCiclo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    public int actualizarCiclo(Ciclo obj) {
        int salida = -1;
        try {

            Connection conn;

            PreparedStatement psmt;

            conn = Conexion.getConexion();
            String sql = "update ciclo set Ciclo=?, Descripcion=? where idCiclo=?";

            psmt = conn.prepareStatement(sql);
            psmt.setString(1, obj.getCiclo());
            psmt.setString(2, obj.getDescripcion());
            psmt.setInt(3, obj.getIdCiclo());
            salida = psmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(MCiclo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }

    public int eliminarCiclo(int idCiclo) {
        int salida = -1;
        try {

            Connection conn;

            PreparedStatement psmt;

            conn = Conexion.getConexion();
            String sql = "delete from ciclo where idCiclo=?";
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, idCiclo);
            salida = psmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(MCiclo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }
}
