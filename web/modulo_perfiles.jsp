<%-- 
    Document   : modulo_cursos
    Created on : 06-jun-2022, 9:31:21
    Author     : Jose
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Entidad.*,java.util.*"%>
<%
    ArrayList listarPerfil = (ArrayList) session.getAttribute("ListarPerfil");
    if (listarPerfil == null) {
        listarPerfil = new ArrayList();
    }
    String mensaje = (String) request.getAttribute("Mensaje");
    if (mensaje == null) {
        mensaje = "";
    }
%>
<!DOCTYPE html>
<div class="container-fluid">
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h1 class="h3 mb-4 text-gray-800">Gestionar Perfiles</h1>
        <div class="btn-toolbar mb-2 mb-md-0">
            <div class="btn-group mr-2">
                <button type="button" class="btn btn-sm btn-outline-secondary" data-toggle="modal" data-target="#myModalCrear">Crear</button>
                <button type="button" class="btn btn-sm btn-outline-secondary" onclick="java:ModificarPerfil()">Modificar</button>
                <button type="button" class="btn btn-sm btn-outline-secondary" onclick="java:DeletePerfil()">Eliminar</button>
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
                        <th>Perfil</th>
                        <th>Descripcion</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <%for (int i = 0; i < listarPerfil.size(); i++) {
                                Perfil be = (Perfil) listarPerfil.get(i);

                        %>
                        <td><input class="form-check-input" type="radio" name="idperfil" id="idperfil" value="<%=be.getIdPerfil()%>"></td>
                        <td><%=be.getIdPerfil()%></td>
                        <td><%=be.getNomPerfil()%></td>
                        <td><%=be.getDescPerfil()%></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </form>
        <%= mensaje%>
    </div>
</div>

