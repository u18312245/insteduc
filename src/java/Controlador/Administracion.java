/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidad.*;
import Modelo.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jose
 */
@WebServlet(name = "Administracion", urlPatterns = {"/Administracion"})
public class Administracion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);

        String validar = (String) session.getAttribute("usuario");

        String metodo = "";

        if (request.getParameter("metodo") != null) {
            metodo = request.getParameter("metodo");
        } else {
            metodo = "";
        }

        if (validar == null) {

            switch (metodo) {
                case "Login":
                    Login_perfil(request, response);
                    break;
                case "Logout":
                    Logout(request, response);
                    break;
                default:
                    Login(request, response);
                    break;
            }
            System.out.println("Metodo: " + metodo);
            System.out.println("Sesion: " + validar);

        } else {
            if (metodo.equals("")) {
                //si hay sesion pero no hay metodo
                MPersona usu = new MPersona();

                Persona Personas;

                Personas = (Persona) usu.BuscarPersona_Perfil(validar);

                int Perfil = Personas.getIdperfil();

                switch (Perfil) {
                    case 1:
                        pag_adm(request, response);
                        break;
                    case 2:
                        pag_administrativo(request, response);
                        break;
                    default:
                        break;
                }
                System.out.println("Metodo x: " + metodo);
                System.out.println("Sesion x: " + validar);
            } else {
                //si hay sesion y metodo
                switch (metodo) {
                    case "Login":
                        Login_perfil(request, response);
                        break;
                    case "Logout":
                        Logout(request, response);
                        break;
                    case "pag_cursos":
                        pag_cursos(request, response);
                        break;
                    case "pag_grados":
                        pag_grados(request, response);
                        break;
                    case "pag_ciclo":
                        pag_ciclo(request, response);
                        break;
                    case "pag_adm":
                        pag_adm(request, response);
                        break;
                    case "pag_curso_cometencia":
                        pag_curso_cometencia(request, response);
                        break;
                    case "pag_perfil":
                        pag_perfil(request, response);
                        break;
                    case "pag_cargo":
                        pag_cargo(request, response);
                        break;
                    case "AgregarCurso":
                        AgregarCurso(request, response);
                        break;
                    case "EliminarCurso":
                        EliminarCurso(request, response);
                        break;
                    case "pag_actualizarcurso":
                        pag_actualizarcurso(request, response);
                        break;
                    case "ActualizarCurso":
                        ActualizarCurso(request, response);
                        break;
                    case "AgregarGrado":
                        AgregarGrado(request, response);
                        break;
                    case "EliminarGrado":
                        EliminarGrado(request, response);
                        break;
                    case "pag_actualizargrado":
                        pag_actualizargrado(request, response);
                        break;
                    case "ActualizarGrado":
                        ActualizarGrado(request, response);
                        break;
                    case "AgregarCiclo":
                        AgregarCiclo(request, response);
                        break;
                    case "EliminarCiclo":
                        EliminarCiclo(request, response);
                        break;
                    case "pag_actualizarciclo":
                        pag_actualizarciclo(request, response);
                        break;
                    case "ActualizarCiclo":
                        ActualizarCiclo(request, response);
                        break;
                    case "AgregarCursoCompetencia":
                        AgregarCursoCompetencia(request, response);
                        break;
                    case "EliminarCursoCompetencia":
                        EliminarCursoCompetencia(request, response);
                        break;
                    case "pag_actualizarcursocompetencia":
                        pag_actualizarcursocompetencia(request, response);
                        break;
                    case "ActualizarCursoCompetencia":
                        ActualizarCursoCompetencia(request, response);
                        break;
                    case "AgregarPerfil":
                        AgregarPerfil(request, response);
                        break;
                    case "EliminarPerfil":
                        EliminarPerfil(request, response);
                        break;
                    case "pag_actualizarperfil":
                        pag_actualizarperfil(request, response);
                        break;
                    case "Actualizarperfil":
                        Actualizarperfil(request, response);
                        break;
                    case "AgregarCargo":
                        AgregarCargo(request, response);
                        break;
                    case "EliminarCargo":
                        EliminarCargo(request, response);
                        break;
                    case "pag_actualizarcargo":
                        pag_actualizarcargo(request, response);
                        break;
                    case "ActualizarCargo":
                        ActualizarCargo(request, response);
                        break;
                    default:
                        Login(request, response);
                        break;
                }
                System.out.println("Metodo y: " + metodo);
                System.out.println("Sesion : " + validar);
            }

        }

    }

    protected void Login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
    }

    protected void pag_adm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pag_administracion.jsp").forward(request, response);
    }

    protected void pag_cursos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ListarCurso(request, response);
    }

    protected void pag_grados(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ListarGrado(request, response);
    }

    protected void pag_ciclo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ListarCiclo(request, response);
    }

    protected void pag_curso_cometencia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ListarCursoCompetencia(request, response);
    }

    protected void pag_administrativo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pag_administrativo.jsp").forward(request, response);
    }

    protected void pag_perfil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ListarPerfil(request, response);
    }
    protected void pag_cargo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ListarCargo(request, response);
    }

    protected void pag_actualizarcurso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idcurso = request.getParameter("idmod");
        System.out.println("Id Curso: " + idcurso);

        HttpSession session = request.getSession(true);
        MCurso esp = new MCurso();

        try {
            session.setAttribute("Cursobuscado", esp.BuscarCurso(Integer.parseInt(idcurso)));
        } catch (NumberFormatException e) {
            System.out.println("No se ha podido obtener el curso: " + e.getMessage());
        }
        getServletContext().getRequestDispatcher("/modificarCurso.jsp").forward(request, response);
    }

    protected void pag_actualizargrado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idgrado = request.getParameter("idmod");
        System.out.println("Id Grado: " + idgrado);

        HttpSession session = request.getSession(true);
        MGrado esp = new MGrado();

        try {
            session.setAttribute("Gradobuscado", esp.BuscarGrado(Integer.parseInt(idgrado)));
        } catch (NumberFormatException e) {
            System.out.println("No se ha podido obtener el grado: " + e.getMessage());
        }
        getServletContext().getRequestDispatcher("/modificarGrado.jsp").forward(request, response);
    }

    protected void pag_actualizarciclo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idciclo = request.getParameter("idmod");
        System.out.println("Id Ciclo: " + idciclo);

        HttpSession session = request.getSession(true);
        MCiclo esp = new MCiclo();

        try {
            session.setAttribute("Ciclobuscado", esp.BuscarCiclo(Integer.parseInt(idciclo)));
        } catch (NumberFormatException e) {
            System.out.println("No se ha podido obtener el ciclo: " + e.getMessage());
        }
        getServletContext().getRequestDispatcher("/modificarCiclo.jsp").forward(request, response);
    }

    protected void pag_actualizarperfil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idperfil = request.getParameter("idmod");
        System.out.println("Id Perfil: " + idperfil);

        HttpSession session = request.getSession(true);
        MPerfil esp = new MPerfil();

        try {
            session.setAttribute("PerfilBuscado", esp.BuscarPerfil(Integer.parseInt(idperfil)));
        } catch (NumberFormatException e) {
            System.out.println("No se ha podido obtener el Perfil: " + e.getMessage());
        }
        getServletContext().getRequestDispatcher("/modificarPerfil.jsp").forward(request, response);
    }
    protected void pag_actualizarcargo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idcargo = request.getParameter("idmod");
        System.out.println("Id Cargo: " + idcargo);

        HttpSession session = request.getSession(true);
        MCargo esp = new MCargo();

        try {
            session.setAttribute("CargoBuscado", esp.BuscarCargo(Integer.parseInt(idcargo)));
        } catch (NumberFormatException e) {
            System.out.println("No se ha podido obtener el Cargo: " + e.getMessage());
        }
        getServletContext().getRequestDispatcher("/modificarCargo.jsp").forward(request, response);
    }
    protected void pag_actualizarcursocompetencia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idcursocompetencia = request.getParameter("idmod");
        System.out.println("Id Curso Competencia: " + idcursocompetencia);

        HttpSession session = request.getSession(true);
        MCurso_Competencia esp = new MCurso_Competencia();

        try {
            session.setAttribute("CursoCompetenciabuscado", esp.BuscarCursoCompetencia(Integer.parseInt(idcursocompetencia)));
        } catch (NumberFormatException e) {
            System.out.println("No se ha podido obtener la competencia del curso: " + e.getMessage());
        }
        getServletContext().getRequestDispatcher("/modificarCursoCompetencia.jsp").forward(request, response);
    }

    protected void Login_perfil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String usuario = request.getParameter("user");

        String pass = request.getParameter("password");

        String mensaje;

        System.out.println("Usuario y passord enviado: " + usuario + " - " + pass);

        HttpSession session = request.getSession(true);

        String validar = (String) session.getAttribute("usuario");

        if (validar == null) {

            MPersona usu = new MPersona();

            Boolean acceso = false;

            try {
                acceso = usu.login_user(usuario, pass);

            } catch (Exception e) {

                mensaje = e.getMessage();
                System.out.println("Error login, consultar al administrador: " + mensaje);

            }
            System.out.println("Error: " + acceso);

            if (acceso == true) {

                session.setAttribute("usuario", usuario);

                Persona Personas;

                Personas = (Persona) usu.BuscarPersona_Perfil(usuario);

                int Perfil = Personas.getIdperfil();

                switch (Perfil) {
                    case 1:
                        pag_adm(request, response);
                        break;
                    case 2:
                        pag_administrativo(request, response);
                        break;
                    default:
                        break;
                }

            } else {
                request.setAttribute("mensaje_login", "<script>alert('Usuario o clave incorrectos')</script>");
                getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
            }

        } else {

            MPersona usu = new MPersona();

            Persona Personas;

            Personas = (Persona) usu.BuscarPersona_Perfil(usuario);

            int Perfil = Personas.getIdperfil();

            switch (Perfil) {
                case 1:
                    pag_adm(request, response);
                    break;
                case 2:
                    pag_administrativo(request, response);
                    break;
                default:
                    break;
            }

        }

    }

    protected void Logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        session.removeAttribute("usuario");
        session.invalidate();

        System.out.println("Estoy aqui en logout");

        Login(request, response);
    }

    protected void ListarCurso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        MCurso esp = new MCurso();

        try {
            session.setAttribute("ListarCurso", esp.listaCurso());
        } catch (Exception e) {
            System.out.println("No se ha podido obtener a los Cursos: " + e.getMessage());
        }
        getServletContext().getRequestDispatcher("/pag_administracion_cursos.jsp").forward(request, response);

    }

    protected void ListarGrado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        MGrado esp = new MGrado();

        try {
            session.setAttribute("ListarGrado", esp.listaGrado());
        } catch (Exception e) {
            System.out.println("No se ha podido obtener a los Grados: " + e.getMessage());
        }
        getServletContext().getRequestDispatcher("/pag_administracion_grados.jsp").forward(request, response);

    }

    protected void ListarCiclo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        MCiclo esp = new MCiclo();

        try {
            session.setAttribute("ListarCiclo", esp.listaCiclo());
        } catch (Exception e) {
            System.out.println("No se ha podido obtener a los Ciclo: " + e.getMessage());
        }
        getServletContext().getRequestDispatcher("/pag_administracion_ciclos.jsp").forward(request, response);

    }

    protected void ListarPerfil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        MPerfil esp = new MPerfil();

        try {
            session.setAttribute("ListarPerfil", esp.listaPerfil());
        } catch (Exception e) {
            System.out.println("No se ha podido obtener a los Perfiles: " + e.getMessage());
        }
        getServletContext().getRequestDispatcher("/pag_administracion_perfiles.jsp").forward(request, response);

    }
    protected void ListarCargo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        MCargo esp = new MCargo();

        try {
            session.setAttribute("ListarCargo", esp.listaCargo());
        } catch (Exception e) {
            System.out.println("No se ha podido obtener a los Cargos: " + e.getMessage());
        }
        getServletContext().getRequestDispatcher("/pag_administracion_cargos.jsp").forward(request, response);

    }
    protected void ListarCursoCompetencia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        MCurso_Competencia esp = new MCurso_Competencia();
        MCurso mco = new MCurso();
        MGrado mgo = new MGrado();
        MCiclo mcl = new MCiclo();

        try {
            session.setAttribute("ListarCursoCompetencia", esp.listaCursoCompetencia());
            session.setAttribute("ListarCurso", mco.listaCurso());
            session.setAttribute("ListarCiclo", mcl.listaCiclo());
            session.setAttribute("ListarGrado", mgo.listaGrado());
        } catch (Exception e) {
            System.out.println("No se ha podido obtener a las competencias del curso: " + e.getMessage());
        }
        getServletContext().getRequestDispatcher("/pag_administracion_curso_competencia.jsp").forward(request, response);

    }

    protected void AgregarCurso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mensaje = "";

        MCurso ms = new MCurso();
        Curso esp = new Curso();

        String nombre = request.getParameter("name");
        String descripcion = request.getParameter("descripcion");

        esp.setNomCurso(nombre);
        esp.setDescripCurso(descripcion);

        int i = ms.InsertaCurso(esp);

        if (i == -1) {
            mensaje = "<div class=\"col-lg-10\"><div class=\"alert alert-danger\" role=\"alert\"><span class=\"glyphicon glyphicon-info-sign\"></span><button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button><strong>Error!  </strong>Error en el Registro!</div></div>";
        } else {
            mensaje = "<div class=\"col-lg-10\"><div class=\"alert alert-success\" role=\"alert\"><span class=\"glyphicon glyphicon-info-sign\"></span><button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button><strong>Completado!  </strong>Registro Completado!</div></div>";
        }
        request.setAttribute("Mensaje", mensaje);
        ListarCurso(request, response);

    }

    protected void AgregarGrado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mensaje = "";

        MGrado ms = new MGrado();
        Grado esp = new Grado();

        String nombre = request.getParameter("name");
        String descripcion = request.getParameter("descripcion");

        esp.setGrado(nombre);
        esp.setDescripcion(descripcion);

        int i = ms.InsertaCurso(esp);

        if (i == -1) {
            mensaje = "<div class=\"col-lg-10\"><div class=\"alert alert-danger\" role=\"alert\"><span class=\"glyphicon glyphicon-info-sign\"></span><button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button><strong>Error!  </strong>Error en el Registro!</div></div>";
        } else {
            mensaje = "<div class=\"col-lg-10\"><div class=\"alert alert-success\" role=\"alert\"><span class=\"glyphicon glyphicon-info-sign\"></span><button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button><strong>Completado!  </strong>Registro Completado!</div></div>";
        }
        request.setAttribute("Mensaje", mensaje);
        ListarGrado(request, response);

    }

    protected void AgregarCiclo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mensaje = "";

        MCiclo ms = new MCiclo();
        Ciclo esp = new Ciclo();

        String nombre = request.getParameter("name");
        String descripcion = request.getParameter("descripcion");

        esp.setCiclo(nombre);
        esp.setDescripcion(descripcion);

        int i = ms.InsertaCiclo(esp);

        if (i == -1) {
            mensaje = "<div class=\"col-lg-10\"><div class=\"alert alert-danger\" role=\"alert\"><span class=\"glyphicon glyphicon-info-sign\"></span><button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button><strong>Error!  </strong>Error en el Registro!</div></div>";
        } else {
            mensaje = "<div class=\"col-lg-10\"><div class=\"alert alert-success\" role=\"alert\"><span class=\"glyphicon glyphicon-info-sign\"></span><button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button><strong>Completado!  </strong>Registro Completado!</div></div>";
        }
        request.setAttribute("Mensaje", mensaje);
        ListarCiclo(request, response);

    }
    protected void AgregarPerfil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mensaje = "";

        MPerfil ms = new MPerfil();
        Perfil esp = new Perfil();

        String nombre = request.getParameter("name");
        String descripcion = request.getParameter("descripcion");

        esp.setNomPerfil(nombre);
        esp.setDescPerfil(descripcion);

        int i = ms.InsertaPerfil(esp);

        if (i == -1) {
            mensaje = "<div class=\"col-lg-10\"><div class=\"alert alert-danger\" role=\"alert\"><span class=\"glyphicon glyphicon-info-sign\"></span><button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button><strong>Error!  </strong>Error en el Registro!</div></div>";
        } else {
            mensaje = "<div class=\"col-lg-10\"><div class=\"alert alert-success\" role=\"alert\"><span class=\"glyphicon glyphicon-info-sign\"></span><button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button><strong>Completado!  </strong>Registro Completado!</div></div>";
        }
        request.setAttribute("Mensaje", mensaje);
        ListarPerfil(request, response);

    }
    protected void AgregarCargo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mensaje = "";

        MCargo ms = new MCargo();
        Cargo esp = new Cargo();

        String nombre = request.getParameter("name");
        String descripcion = request.getParameter("descripcion");

        esp.setNomCargo(nombre);
        esp.setDescCargo(descripcion);

        int i = ms.InsertaCargo(esp);

        if (i == -1) {
            mensaje = "<div class=\"col-lg-10\"><div class=\"alert alert-danger\" role=\"alert\"><span class=\"glyphicon glyphicon-info-sign\"></span><button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button><strong>Error!  </strong>Error en el Registro!</div></div>";
        } else {
            mensaje = "<div class=\"col-lg-10\"><div class=\"alert alert-success\" role=\"alert\"><span class=\"glyphicon glyphicon-info-sign\"></span><button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button><strong>Completado!  </strong>Registro Completado!</div></div>";
        }
        request.setAttribute("Mensaje", mensaje);
        ListarCargo(request, response);

    }
    protected void AgregarCursoCompetencia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mensaje = "";

        MCurso_Competencia ms = new MCurso_Competencia();
        Curso_Competencia esp = new Curso_Competencia();

        if (!"".equals(request.getParameter("curso"))) {
            String idCurso = request.getParameter("curso");
            esp.setIdCurso(Integer.parseInt(idCurso));
        }
        if (!"".equals(request.getParameter("competencia"))) {
            String competencia = request.getParameter("competencia");
            esp.setCompetencia(competencia);
        }
        if (!"".equals(request.getParameter("descripcion_competencia"))) {
            String detalle_competencia = request.getParameter("descripcion_competencia");
            esp.setDetalle_competencia(detalle_competencia);
        }
        if (!"".equals(request.getParameter("ciclo"))) {
            String idCiclo = request.getParameter("ciclo");
            esp.setIdCiclo(Integer.parseInt(idCiclo));
        }
        if (!"".equals(request.getParameter("grado"))) {
            String idGrado = request.getParameter("grado");
            esp.setIdGrado(Integer.parseInt(idGrado));
        }

        int i = ms.InsertaCursoCompetencia(esp);

        if (i == -1) {
            mensaje = "<div class=\"col-lg-10\"><div class=\"alert alert-danger\" role=\"alert\"><span class=\"glyphicon glyphicon-info-sign\"></span><button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button><strong>Error!  </strong>Error en el Registro!</div></div>";
        } else {
            mensaje = "<div class=\"col-lg-10\"><div class=\"alert alert-success\" role=\"alert\"><span class=\"glyphicon glyphicon-info-sign\"></span><button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button><strong>Completado!  </strong>Registro Completado!</div></div>";
        }
        request.setAttribute("Mensaje", mensaje);
        ListarCursoCompetencia(request, response);

    }

    protected void EliminarCurso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String mensaje = "";
        int i = -1;
        String idcurso = request.getParameter("idmod");
        System.out.println("Id Curso: " + idcurso);

        MCurso esp = new MCurso();

        i = esp.eliminarCurso(Integer.parseInt(idcurso));

        if (i == -1) {
            mensaje = "<div class=\"col-lg-10\"><div class=\"alert alert-danger\" role=\"alert\"><span class=\"glyphicon glyphicon-info-sign\"></span><button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button><strong>Error!  </strong> No se eliminó el registro</div></div>";
        } else {
            mensaje = "<div class=\"col-lg-10\"><div class=\"alert alert-success\" role=\"alert\"><span class=\"glyphicon glyphicon-info-sign\"></span><button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button><strong>Completado!  </strong> Registro eliminado</div></div>";
        }
        request.setAttribute("Mensaje", mensaje);

        ListarCurso(request, response);

    }

    protected void EliminarGrado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String mensaje = "";
        int i = -1;
        String idgrado = request.getParameter("idmod");
        System.out.println("Id Grado: " + idgrado);

        MGrado esp = new MGrado();

        i = esp.eliminarGrado(Integer.parseInt(idgrado));

        if (i == -1) {
            mensaje = "<div class=\"col-lg-10\"><div class=\"alert alert-danger\" role=\"alert\"><span class=\"glyphicon glyphicon-info-sign\"></span><button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button><strong>Error!  </strong> No se eliminó el registro</div></div>";
        } else {
            mensaje = "<div class=\"col-lg-10\"><div class=\"alert alert-success\" role=\"alert\"><span class=\"glyphicon glyphicon-info-sign\"></span><button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button><strong>Completado!  </strong> Registro eliminado</div></div>";
        }
        request.setAttribute("Mensaje", mensaje);

        ListarGrado(request, response);

    }

    protected void EliminarCiclo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String mensaje = "";
        int i = -1;
        String idciclo = request.getParameter("idmod");
        System.out.println("Id Ciclo: " + idciclo);

        MCiclo esp = new MCiclo();

        i = esp.eliminarCiclo(Integer.parseInt(idciclo));

        if (i == -1) {
            mensaje = "<div class=\"col-lg-10\"><div class=\"alert alert-danger\" role=\"alert\"><span class=\"glyphicon glyphicon-info-sign\"></span><button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button><strong>Error!  </strong> No se eliminó el registro</div></div>";
        } else {
            mensaje = "<div class=\"col-lg-10\"><div class=\"alert alert-success\" role=\"alert\"><span class=\"glyphicon glyphicon-info-sign\"></span><button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button><strong>Completado!  </strong> Registro eliminado</div></div>";
        }
        request.setAttribute("Mensaje", mensaje);

        ListarCiclo(request, response);

    }
    
    protected void EliminarPerfil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String mensaje = "";
        int i = -1;
        String idperfil = request.getParameter("idmod");
        System.out.println("Id Perfil: " + idperfil);

        MPerfil esp = new MPerfil();

        i = esp.eliminarPerfil(Integer.parseInt(idperfil));

        if (i == -1) {
            mensaje = "<div class=\"col-lg-10\"><div class=\"alert alert-danger\" role=\"alert\"><span class=\"glyphicon glyphicon-info-sign\"></span><button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button><strong>Error!  </strong> No se eliminó el registro</div></div>";
        } else {
            mensaje = "<div class=\"col-lg-10\"><div class=\"alert alert-success\" role=\"alert\"><span class=\"glyphicon glyphicon-info-sign\"></span><button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button><strong>Completado!  </strong> Registro eliminado</div></div>";
        }
        request.setAttribute("Mensaje", mensaje);

        ListarPerfil(request, response);

    }
    protected void EliminarCargo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String mensaje = "";
        int i = -1;
        String idcargo = request.getParameter("idmod");
        System.out.println("Id Cargo: " + idcargo);

        MCargo esp = new MCargo();

        i = esp.eliminarCargo(Integer.parseInt(idcargo));

        if (i == -1) {
            mensaje = "<div class=\"col-lg-10\"><div class=\"alert alert-danger\" role=\"alert\"><span class=\"glyphicon glyphicon-info-sign\"></span><button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button><strong>Error!  </strong> No se eliminó el registro</div></div>";
        } else {
            mensaje = "<div class=\"col-lg-10\"><div class=\"alert alert-success\" role=\"alert\"><span class=\"glyphicon glyphicon-info-sign\"></span><button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button><strong>Completado!  </strong> Registro eliminado</div></div>";
        }
        request.setAttribute("Mensaje", mensaje);

        ListarCargo(request, response);

    }
    protected void EliminarCursoCompetencia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String mensaje = "";
        int i = -1;
        String idcursocompetencia = request.getParameter("idmod");
        System.out.println("Id Curso Competencia: " + idcursocompetencia);

        MCurso_Competencia esp = new MCurso_Competencia();

        i = esp.eliminaCursoCompetencia(Integer.parseInt(idcursocompetencia));

        if (i == -1) {
            mensaje = "<div class=\"col-lg-10\"><div class=\"alert alert-danger\" role=\"alert\"><span class=\"glyphicon glyphicon-info-sign\"></span><button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button><strong>Error!  </strong> No se eliminó el registro</div></div>";
        } else {
            mensaje = "<div class=\"col-lg-10\"><div class=\"alert alert-success\" role=\"alert\"><span class=\"glyphicon glyphicon-info-sign\"></span><button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button><strong>Completado!  </strong> Registro eliminado</div></div>";
        }
        request.setAttribute("Mensaje", mensaje);

        ListarCursoCompetencia(request, response);

    }

    protected void ActualizarCurso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String mensaje = "";

        MCurso esp = new MCurso();
        Curso be = new Curso();

        String id = request.getParameter("id");
        String nombre = request.getParameter("name");
        String descripcion = request.getParameter("descripcion");

        int i = -1;

        be.setIdCurso(Integer.parseInt(id));
        be.setNomCurso(nombre);
        be.setDescripCurso(descripcion);

        i = esp.actualizarCurso(be);

        if (i == -1) {
            mensaje = "<div class=\"col-lg-10\"><div class=\"alert alert-danger\" role=\"alert\"><span class=\"glyphicon glyphicon-info-sign\"></span><button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button><strong>Error!  </strong> en el Registro!</div></div>";
        } else {
            mensaje = "<div class=\"col-lg-10\"><div class=\"alert alert-success\" role=\"alert\"><span class=\"glyphicon glyphicon-info-sign\"></span><button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button><strong>Completado!  </strong> la actualizacion!</div></div>";
        }
        request.setAttribute("Mensaje", mensaje);

        ListarCurso(request, response);

    }

    protected void ActualizarGrado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String mensaje = "";

        MGrado esp = new MGrado();
        Grado be = new Grado();

        String id = request.getParameter("id");
        String nombre = request.getParameter("name");
        String descripcion = request.getParameter("descripcion");

        int i = -1;

        be.setIdGrado(Integer.parseInt(id));
        be.setGrado(nombre);
        be.setDescripcion(descripcion);

        i = esp.actualizarGrado(be);

        if (i == -1) {
            mensaje = "<div class=\"col-lg-10\"><div class=\"alert alert-danger\" role=\"alert\"><span class=\"glyphicon glyphicon-info-sign\"></span><button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button><strong>Error!  </strong> en el Registro!</div></div>";
        } else {
            mensaje = "<div class=\"col-lg-10\"><div class=\"alert alert-success\" role=\"alert\"><span class=\"glyphicon glyphicon-info-sign\"></span><button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button><strong>Completado!  </strong> la actualizacion!</div></div>";
        }
        request.setAttribute("Mensaje", mensaje);

        ListarGrado(request, response);

    }

    protected void ActualizarCiclo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String mensaje = "";

        MCiclo esp = new MCiclo();
        Ciclo be = new Ciclo();

        String id = request.getParameter("id");
        String nombre = request.getParameter("name");
        String descripcion = request.getParameter("descripcion");

        int i = -1;

        be.setIdCiclo(Integer.parseInt(id));
        be.setCiclo(nombre);
        be.setDescripcion(descripcion);

        i = esp.actualizarCiclo(be);

        if (i == -1) {
            mensaje = "<div class=\"col-lg-10\"><div class=\"alert alert-danger\" role=\"alert\"><span class=\"glyphicon glyphicon-info-sign\"></span><button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button><strong>Error!  </strong> en el Registro!</div></div>";
        } else {
            mensaje = "<div class=\"col-lg-10\"><div class=\"alert alert-success\" role=\"alert\"><span class=\"glyphicon glyphicon-info-sign\"></span><button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button><strong>Completado!  </strong> la actualizacion!</div></div>";
        }
        request.setAttribute("Mensaje", mensaje);

        ListarCiclo(request, response);

    }
    protected void Actualizarperfil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String mensaje = "";

        MPerfil esp = new MPerfil();
        Perfil be = new Perfil();

        String id = request.getParameter("id");
        String nombre = request.getParameter("name");
        String descripcion = request.getParameter("descripcion");

        int i = -1;

        be.setIdPerfil(Integer.parseInt(id));
        be.setNomPerfil(nombre);
        be.setDescPerfil(descripcion);

        i = esp.actualizarPerfil(be);

        if (i == -1) {
            mensaje = "<div class=\"col-lg-10\"><div class=\"alert alert-danger\" role=\"alert\"><span class=\"glyphicon glyphicon-info-sign\"></span><button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button><strong>Error!  </strong> en el Registro!</div></div>";
        } else {
            mensaje = "<div class=\"col-lg-10\"><div class=\"alert alert-success\" role=\"alert\"><span class=\"glyphicon glyphicon-info-sign\"></span><button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button><strong>Completado!  </strong> la actualizacion!</div></div>";
        }
        request.setAttribute("Mensaje", mensaje);

        ListarPerfil(request, response);

    }
    protected void ActualizarCargo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String mensaje = "";

        MCargo esp = new MCargo();
        Cargo be = new Cargo();

        String id = request.getParameter("id");
        String nombre = request.getParameter("name");
        String descripcion = request.getParameter("descripcion");

        int i = -1;

        be.setIdCargo(Integer.parseInt(id));
        be.setNomCargo(nombre);
        be.setDescCargo(descripcion);

        i = esp.actualizarCargo(be);

        if (i == -1) {
            mensaje = "<div class=\"col-lg-10\"><div class=\"alert alert-danger\" role=\"alert\"><span class=\"glyphicon glyphicon-info-sign\"></span><button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button><strong>Error!  </strong> en el Registro!</div></div>";
        } else {
            mensaje = "<div class=\"col-lg-10\"><div class=\"alert alert-success\" role=\"alert\"><span class=\"glyphicon glyphicon-info-sign\"></span><button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button><strong>Completado!  </strong> la actualizacion!</div></div>";
        }
        request.setAttribute("Mensaje", mensaje);

        ListarCargo(request, response);

    }
    protected void ActualizarCursoCompetencia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String mensaje = "";

        MCurso_Competencia esp = new MCurso_Competencia();
        Curso_Competencia be = new Curso_Competencia();
        System.out.println("Operacion de Modificar:...");
        String idCurso = request.getParameter("curso");
        System.out.println("Curso:" + idCurso);
        String competencia = request.getParameter("competencia");
        System.out.println("Competencia:" + competencia);
        String detalle_competencia = request.getParameter("descripcion_competencia");
        System.out.println("Detalle Cometencia:" + detalle_competencia);
        String idCiclo = request.getParameter("ciclo");
        System.out.println("Ciclo:" + idCiclo);
        String idGrado = request.getParameter("grado");
        System.out.println("Grado:" + idGrado);
        String idCursoCompe = request.getParameter("id");
        System.out.println("Id:" + idCursoCompe);

        int i = -1;

        be.setIdCurso(Integer.parseInt(idCurso));
        be.setCompetencia(competencia);
        be.setDetalle_competencia(detalle_competencia);
        be.setIdCiclo(Integer.parseInt(idCiclo));
        be.setIdGrado(Integer.parseInt(idGrado));
        be.setIdCursocompe(Integer.parseInt(idCursoCompe));

        i = esp.actualizaCursoCompetencia(be);

        if (i == -1) {
            mensaje = "<div class=\"col-lg-10\"><div class=\"alert alert-danger\" role=\"alert\"><span class=\"glyphicon glyphicon-info-sign\"></span><button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button><strong>Error!  </strong> en el Registro!</div></div>";
        } else {
            mensaje = "<div class=\"col-lg-10\"><div class=\"alert alert-success\" role=\"alert\"><span class=\"glyphicon glyphicon-info-sign\"></span><button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button><strong>Completado!  </strong> la actualizacion!</div></div>";
        }
        request.setAttribute("Mensaje", mensaje);

        ListarCursoCompetencia(request, response);

    }

}
