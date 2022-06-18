/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Entidad.Grado;
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
public class MGrado {

    public int InsertaCurso(Grado obj) {

        int salida = -1;
        try {
            Connection conn;
            PreparedStatement psmt;

            conn = Conexion.getConexion();
            String sql = "insert into grado values (null,?,?)";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, obj.getGrado());
            psmt.setString(2, obj.getDescripcion());

            salida = psmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MGrado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }

    public List<Grado> listaGrado() {
        List<Grado> data = new ArrayList<>();
        try {

            Connection conn;

            PreparedStatement psmt;

            ResultSet rs;

            conn = Conexion.getConexion();
            String sql = "Select * from grado";
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();

            Grado obj;

            while (rs.next()) {
                obj = new Grado();
                obj.setIdGrado(rs.getInt("idGrado"));
                obj.setGrado(rs.getString("NombreGrado"));
                obj.setDescripcion(rs.getString("DescrpGrado"));
                data.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MGrado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public Grado BuscarGrado(int idGrado) {
        Grado obj = null;
        try {

            Connection conn;

            PreparedStatement psmt;

            ResultSet rs;

            conn = Conexion.getConexion();
            String sql = "Select * from grado where idGrado=?";
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, idGrado);
            rs = psmt.executeQuery();

            while (rs.next()) {
                obj = new Grado();
                obj.setIdGrado(rs.getInt("idGrado"));
                obj.setGrado(rs.getString("NombreGrado"));
                obj.setDescripcion(rs.getString("DescrpGrado"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MGrado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    public int actualizarGrado(Grado obj) {
        int salida = -1;
        try {

            Connection conn;

            PreparedStatement psmt;

            conn = Conexion.getConexion();
            String sql = "update grado set NombreGrado=?, DescrpGrado=? where idGrado=?";

            psmt = conn.prepareStatement(sql);
            psmt.setString(1, obj.getGrado());
            psmt.setString(2, obj.getDescripcion());
            psmt.setInt(3, obj.getIdGrado());
            salida = psmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(MGrado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }

    public int eliminarGrado(int idGrado) {
        int salida = -1;
        try {

            Connection conn;

            PreparedStatement psmt;

            conn = Conexion.getConexion();
            String sql = "delete from grado where idGrado=?";
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, idGrado);
            salida = psmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(MGrado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }
}
