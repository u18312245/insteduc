/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Entidad.Perfil;
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
public class MPerfil {

    public int InsertaPerfil(Perfil obj) {

        int salida = -1;
        try {
            Connection conn;
            PreparedStatement psmt;

            conn = Conexion.getConexion();
            String sql = "insert into perfil values (null,?,?)";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, obj.getNomPerfil());
            psmt.setString(2, obj.getDescPerfil());

            salida = psmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MPerfil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }

    public List<Perfil> listaPerfil() {
        List<Perfil> data = new ArrayList<>();
        try {

            Connection conn;

            PreparedStatement psmt;

            ResultSet rs;

            conn = Conexion.getConexion();
            String sql = "Select * from perfil";
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();

            Perfil obj;

            while (rs.next()) {
                obj = new Perfil();
                obj.setIdPerfil(rs.getInt("idperfil"));
                obj.setNomPerfil(rs.getString("nomperfil"));
                obj.setDescPerfil(rs.getString("descripcionperfil"));
                data.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MPerfil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public Perfil BuscarPerfil(int idPerfil) {
        Perfil obj = null;
        try {

            Connection conn;

            PreparedStatement psmt;

            ResultSet rs;

            conn = Conexion.getConexion();
            String sql = "Select * from perfil where idperfil=?";
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, idPerfil);
            rs = psmt.executeQuery();

            while (rs.next()) {
                obj = new Perfil();
                obj.setIdPerfil(rs.getInt("idperfil"));
                obj.setNomPerfil(rs.getString("nomperfil"));
                obj.setDescPerfil(rs.getString("descripcionperfil"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MPerfil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    public int actualizarPerfil(Perfil obj) {
        int salida = -1;
        try {

            Connection conn;

            PreparedStatement psmt;

            conn = Conexion.getConexion();
            String sql = "update grado set nomperfil=?, descripcionperfil=? where idperfil=?";

            psmt = conn.prepareStatement(sql);
            psmt.setString(1, obj.getNomPerfil());
            psmt.setString(2, obj.getDescPerfil());
            psmt.setInt(3, obj.getIdPerfil());
            salida = psmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(MPerfil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }

    public int eliminarPerfil(int idPerfil) {
        int salida = -1;
        try {

            Connection conn;

            PreparedStatement psmt;

            conn = Conexion.getConexion();
            String sql = "delete from perfil where idperfil=?";
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, idPerfil);
            salida = psmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(MPerfil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }
}
