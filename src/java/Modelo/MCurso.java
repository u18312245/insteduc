/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Entidad.Curso;
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
public class MCurso {
        public int InsertaCurso(Curso obj) {

        int salida = -1;
        try {
            Connection conn;
            PreparedStatement psmt;

            conn = Conexion.getConexion();
            String sql = "insert into curso values (null,?,?)";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, obj.getNomCurso());
            psmt.setString(2, obj.getDescripCurso());

            salida = psmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MCurso.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }
    public List<Curso> listaCurso() {
        List<Curso> data = new ArrayList<>();
        try {

            Connection conn;

            PreparedStatement psmt;

            ResultSet rs;

            conn = Conexion.getConexion();
            String sql = "Select * from curso";
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();

            Curso obj;

            while (rs.next()) {
                obj = new Curso();
                obj.setIdCurso(rs.getInt("idCurso"));
                obj.setNomCurso(rs.getString("nomCurso"));
                obj.setDescripCurso(rs.getString("descripCurso"));
                data.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MCurso.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
 public Curso BuscarCurso(int idCurso) {
     Curso obj = null;
        try {

            Connection conn;

            PreparedStatement psmt;

            ResultSet rs;

            conn = Conexion.getConexion();
            String sql = "Select * from curso where idCurso=?";
            psmt = conn.prepareStatement(sql);
             psmt.setInt(1, idCurso);
            rs = psmt.executeQuery();

            while (rs.next()) {
                obj = new Curso();
                obj.setIdCurso(rs.getInt("idCurso"));
                obj.setNomCurso(rs.getString("nomCurso"));
                obj.setDescripCurso(rs.getString("descripCurso"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MCurso.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }
    public int actualizarCurso(Curso obj) {
        int salida = -1;
        try {

            Connection conn;

            PreparedStatement psmt;

            conn = Conexion.getConexion();
            String sql = "update curso set nomCurso=?, descripCurso=? where idCurso=?";

            psmt = conn.prepareStatement(sql);
            psmt.setString(1, obj.getNomCurso());
            psmt.setString(2, obj.getDescripCurso());
            psmt.setInt(3, obj.getIdCurso());
            salida = psmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(MCurso.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }
    public int eliminarCurso(int idCurso) {
        int salida = -1;
        try {

            Connection conn;

            PreparedStatement psmt;

            conn = Conexion.getConexion();
            String sql = "delete from curso where idCurso=?";
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, idCurso);
            salida = psmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(MCurso.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }
}
