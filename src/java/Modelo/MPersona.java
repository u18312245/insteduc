/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Jose
 */
import Entidad.Persona;
import Util.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MPersona {

    public int InsertaCursoCompetencia(Persona obj) {

        int salida = -1;
        try {
            Connection conn;
            PreparedStatement psmt;

            conn = Conexion.getConexion();
            String sql = "insert into curso_competencia values (null,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, obj.getNombres());
            psmt.setString(2, obj.getApePaterno());
            psmt.setString(3, obj.getApePaterno());
            psmt.setDate(4, (Date) obj.getFecha());
            psmt.setString(5, obj.getCelular());
            psmt.setString(6, obj.getCorreo());
            psmt.setString(7, obj.getDireccion());
            psmt.setString(8, obj.getSexo());
            psmt.setString(9, obj.getDepartamento());
            psmt.setString(10, obj.getDistrito());
            psmt.setString(11, obj.getClave());
            psmt.setString(12, obj.getUsuario());
            psmt.setInt(13, obj.getIdCargo());
            psmt.setInt(14, obj.getIdperfil());

            salida = psmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MCurso_Competencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }

    public List<Persona> listaPersona_short() {
        List<Persona> data = new ArrayList<>();
        try {

            Connection conn;

            PreparedStatement psmt;

            ResultSet rs;

            conn = Conexion.getConexion();
            String sql = "SELECT p.idpersona, CONCAT(p.nombres,' ',p.ApePaterno,' ',p.ApeMaterno) AS FullName, p.FechaNac, p.Celular, p.Correo, p.Sexo, c.nombreCargo, pe.nomperfil FROM insteduc.personas p inner join insteduc.cargo c on c.idCargo = p.idCargo inner join insteduc.perfil pe on p.idPerfil = pe.idPerfil;";
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();

            Persona obj;

            while (rs.next()) {
                obj = new Persona();
                obj.setIdpersona(rs.getInt("idpersona"));
                obj.setFullName(rs.getString("FullName"));
                obj.setFecha(rs.getDate("FechaNac"));
                obj.setCelular(rs.getString("Celular"));
                obj.setCorreo(rs.getString("Correo"));
                obj.setSexo(rs.getString("Sexo"));
                obj.setCargo(rs.getString("nombreCargo"));
                obj.setPerfil(rs.getString("nomperfil"));
                data.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public List<Persona> listaPersona_large() {
        List<Persona> data = new ArrayList<>();
        try {

            Connection conn;

            PreparedStatement psmt;

            ResultSet rs;

            conn = Conexion.getConexion();
            String sql = "SELECT p.idpersona, p.nombres,p.ApePaterno,p.ApeMaterno, p.FechaNac, p.Celular, p.Correo, p.Direccion, p.Sexo, p.Departamento, p.Distrito, p.clave, p.usuario, c.idCargo, pe.idperfil, c.nombreCargo, pe.nomperfil FROM insteduc.personas p inner join insteduc.cargo c on c.idCargo = p.idCargo inner join insteduc.perfil pe on p.idPerfil = pe.idPerfil;";
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();

            Persona obj;

            while (rs.next()) {
                obj = new Persona();
                obj.setIdpersona(rs.getInt("idpersona"));
                obj.setNombres(rs.getString("nombres"));
                obj.setFecha(rs.getDate("FechaNac"));
                obj.setCelular(rs.getString("Celular"));
                obj.setCorreo(rs.getString("Correo"));
                obj.setSexo(rs.getString("Sexo"));
                obj.setCargo(rs.getString("nombreCargo"));
                obj.setPerfil(rs.getString("nomperfil"));
                data.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MPersona.class.getName()).log(Level.SEVERE, null, ex);
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

    public boolean login_user(String usuario, String pass) {
        Entidad.Persona obj = null;
        boolean a = true;
        try {
            Connection conn;

            PreparedStatement psmt;

            ResultSet rs;

            conn = Conexion.getConexion();
            String sql = "Select usuario,clave,idperfil from insteduc.personas  where usuario=? and clave=?";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, usuario);
            psmt.setString(2, pass);
            rs = psmt.executeQuery();

            if (!rs.next()) {
                a = false;
            } else {

                do {

                } while (rs.next());
            }

        } catch (SQLException e) {
        }
        return a;
    }

    public Persona BuscarPersona_Perfil(String usuario) {
        Entidad.Persona obj = null;
        try {

            Connection conn;

            PreparedStatement psmt;

            ResultSet rs;

            conn = Conexion.getConexion();
            String sql = "Select idperfil from insteduc.personas where usuario=? ";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, usuario);
            rs = psmt.executeQuery();

            while (rs.next()) {
                obj = new Entidad.Persona();
                obj.setIdperfil(rs.getInt("idperfil"));

            }
        } catch (SQLException ex) {
            System.out.println("" + ex.getMessage());
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }
}
