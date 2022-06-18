<%-- 
    Document   : modulo_cursos
    Created on : 06-jun-2022, 9:31:21
    Author     : Jose
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Entidad.*,java.util.*"%>
<%
    ArrayList listarcompetencia = (ArrayList) session.getAttribute("ListarCursoCompetencia");
    if (listarcompetencia == null) {
        listarcompetencia = new ArrayList();
    }
    String mensaje = (String) request.getAttribute("Mensaje");
    if (mensaje == null) {
        mensaje = "";
    }
%>
<!DOCTYPE html>
<div class="container-fluid">
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h1 class="h3 mb-4 text-gray-800">Gestionar Competencia de Cursos</h1>
        <div class="btn-toolbar mb-2 mb-md-0">
            <div class="btn-group mr-2">
                <button type="button" class="btn btn-sm btn-outline-secondary" data-toggle="modal" data-target="#myModalCrear">Crear</button>
                <button type="button" class="btn btn-sm btn-outline-secondary" onclick="java:ModificarCursoCompetenica()">Modificar</button>
                <button type="button" class="btn btn-sm btn-outline-secondary" onclick="java:DeleteCursoCompetencia()">Eliminar</button>
            </div>
        </div>
    </div>
    <div class="table-responsive">
        <form name="lista" id="lista" method="get" >
            <table class="table table-striped table-sm">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>ID</th>
                        <th>Curso</th>
                        <th>Competencia</th>
                        <th>Detalle</th>
                        <th>Ciclo</th>
                        <th>Grado</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <%for (int i = 0; i < listarcompetencia.size(); i++) {
                                Curso_Competencia be = (Curso_Competencia) listarcompetencia.get(i);

                        %>
                        <td><input class="form-check-input" type="radio" name="idcompetencia" id="idcompetencia" value="<%=be.getIdCursocompe()%>"></td>
                        <td><%=be.getIdCursocompe()%></td>
                        <td><%=be.getNomCurso()%></td>
                        <td><%=be.getCompetencia()%></td>
                        <td><%=be.getDetalle_competencia()%></td>
                        <td><%=be.getCiclo()%></td>
                        <td><%=be.getGrado()%></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </form>
        <%= mensaje%>
    </div>
</div>

