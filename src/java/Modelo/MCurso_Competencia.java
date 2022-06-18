/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Entidad.Curso_Competencia;
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
public class MCurso_Competencia {

    public int InsertaCursoCompetencia(Curso_Competencia obj) {

        int salida = -1;
        try {
            Connection conn;
            PreparedStatement psmt;

            conn = Conexion.getConexion();
            String sql = "insert into curso_competencia values (null,?,?,?,?,?)";
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, obj.getIdCurso());
            psmt.setString(2, obj.getCompetencia());
            psmt.setString(3, obj.getDetalle_competencia());
            psmt.setInt(4, obj.getIdCiclo());
            psmt.setInt(5, obj.getIdGrado());

            salida = psmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MCurso_Competencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }

    public List<Curso_Competencia> listaCursoCompetencia() {
        List<Curso_Competencia> data = new ArrayList<>();
        try {

            Connection conn;

            PreparedStatement psmt;

            ResultSet rs;

            conn = Conexion.getConexion();
            String sql = "SELECT cc.idCursoCompe, cc.competencia,cc.detalle_competencia,c.nomCurso,cc.idCurso,cc.idGrado,gd.NombreGrado,cc.idCiclo,cl.Ciclo FROM insteduc.curso_competencia cc inner join curso c on c.idCurso=cc.idCurso inner join ciclo cl on cl.idCiclo=cc.idCiclo inner join grado gd on gd.idGrado=cc.idGrado";
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();

            Curso_Competencia obj;

            while (rs.next()) {
                obj = new Curso_Competencia();
                obj.setIdCursocompe(rs.getInt("idCursoCompe"));
                obj.setCompetencia(rs.getString("competencia"));
                obj.setDetalle_competencia(rs.getString("detalle_competencia"));
                obj.setNomCurso(rs.getString("nomCurso"));
                obj.setIdCurso(rs.getInt("idCurso"));
                obj.setIdGrado(rs.getInt("idGrado"));
                obj.setGrado(rs.getString("NombreGrado"));
                obj.setIdCiclo(rs.getInt("idCiclo"));
                obj.setCiclo(rs.getString("Ciclo"));
                data.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MCurso_Competencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public int actualizaCursoCompetencia(Curso_Competencia obj) {
        int salida = -1;
        try {

            Connection conn;

            PreparedStatement psmt;

            conn = Conexion.getConexion();
            String sql = "update curso_competencia set idCurso=?, Competencia=?, detalle_competencia=?, idCiclo=?,idGrado=? where idCursoCompe=?";

            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, obj.getIdCurso());
            psmt.setString(2, obj.getCompetencia());
            psmt.setString(3, obj.getDetalle_competencia());
            psmt.setInt(4, obj.getIdCiclo());
            psmt.setInt(5, obj.getIdGrado());
            psmt.setInt(6, obj.getIdCursocompe());

            salida = psmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(MCurso_Competencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }

    public Curso_Competencia BuscarCursoCompetencia(int idCursoCompetencia) {
        Curso_Competencia obj = null;
        try {

            Connection conn;

            PreparedStatement psmt;

            ResultSet rs;

            conn = Conexion.getConexion();
            String sql = "SELECT cc.idCursoCompe, cc.competencia,cc.detalle_competencia,c.nomCurso,cc.idCurso,cc.idGrado,gd.NombreGrado,cc.idCiclo,cl.Ciclo FROM insteduc.curso_competencia cc inner join curso c on c.idCurso=cc.idCurso inner join ciclo cl on cl.idCiclo=cc.idCiclo inner join grado gd on gd.idGrado=cc.idGrado where idCursoCompe=?";
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, idCursoCompetencia);
            rs = psmt.executeQuery();

            while (rs.next()) {
                obj = new Curso_Competencia();
                obj.setIdCursocompe(rs.getInt("idCursoCompe"));
                obj.setCompetencia(rs.getString("competencia"));
                obj.setDetalle_competencia(rs.getString("detalle_competencia"));
                obj.setNomCurso(rs.getString("nomCurso"));
                obj.setIdCurso(rs.getInt("idCurso"));
                obj.setIdGrado(rs.getInt("idGrado"));
                obj.setGrado(rs.getString("NombreGrado"));
                obj.setIdCiclo(rs.getInt("idCiclo"));
                obj.setCiclo(rs.getString("Ciclo"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MCurso_Competencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    public int eliminaCursoCompetencia(int idCursoCompetencia) {
        int salida = -1;
        try {

            Connection conn;

            PreparedStatement psmt;

            conn = Conexion.getConexion();
            String sql = "delete from curso_competencia where idCursoCompe=?";
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, idCursoCompetencia);
            salida = psmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(MCurso_Competencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }
}
