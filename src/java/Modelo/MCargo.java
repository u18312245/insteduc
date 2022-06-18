/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Entidad.Cargo;
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
public class MCargo {

    public int InsertaCargo(Cargo obj) {

        int salida = -1;
        try {
            Connection conn;
            PreparedStatement psmt;

            conn = Conexion.getConexion();
            String sql = "insert into cargo values (null,?,?)";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, obj.getNomCargo());
            psmt.setString(2, obj.getDescCargo());

            salida = psmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MCargo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }

    public List<Cargo> listaCargo() {
        List<Cargo> data = new ArrayList<>();
        try {

            Connection conn;

            PreparedStatement psmt;

            ResultSet rs;

            conn = Conexion.getConexion();
            String sql = "Select * from cargo";
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();

            Cargo obj;

            while (rs.next()) {
                obj = new Cargo();
                obj.setIdCargo(rs.getInt("idCargo"));
                obj.setNomCargo(rs.getString("nombreCargo"));
                obj.setDescCargo(rs.getString("descripcion"));
                data.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MCargo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public Cargo BuscarCargo(int idCargo) {
        Cargo obj = null;
        try {

            Connection conn;

            PreparedStatement psmt;

            ResultSet rs;

            conn = Conexion.getConexion();
            String sql = "Select * from cargo where idCargo=?";
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, idCargo);
            rs = psmt.executeQuery();

            while (rs.next()) {
                obj = new Cargo();
                obj.setIdCargo(rs.getInt("idCargo"));
                obj.setNomCargo(rs.getString("nombreCargo"));
                obj.setDescCargo(rs.getString("descripcion"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MCargo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    public int actualizarCargo(Cargo obj) {
        int salida = -1;
        try {

            Connection conn;

            PreparedStatement psmt;

            conn = Conexion.getConexion();
            String sql = "update cargo set nombreCargo=?, descripcion=? where idCargo=?";

            psmt = conn.prepareStatement(sql);
            psmt.setString(1, obj.getNomCargo());
            psmt.setString(2, obj.getDescCargo());
            psmt.setInt(3, obj.getIdCargo());
            salida = psmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(MCargo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }

    public int eliminarCargo(int idCargo) {
        int salida = -1;
        try {

            Connection conn;

            PreparedStatement psmt;

            conn = Conexion.getConexion();
            String sql = "delete from cargo where idCargo=?";
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, idCargo);
            salida = psmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(MCargo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }
}
