<%-- 
    Document   : modulo_cursos
    Created on : 06-jun-2022, 9:31:21
    Author     : Jose
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Entidad.*,java.util.*"%>
<%
    ArrayList listarCiclo = (ArrayList) session.getAttribute("ListarCiclo");
    if (listarCiclo == null) {
        listarCiclo = new ArrayList();
    }
    String mensaje = (String) request.getAttribute("Mensaje");
    if (mensaje == null) {
        mensaje = "";
    }
%>
<!DOCTYPE html>
<div class="container-fluid">
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h1 class="h3 mb-4 text-gray-800">Gestionar Ciclos</h1>
        <div class="btn-toolbar mb-2 mb-md-0">
            <div class="btn-group mr-2">
                <button type="button" class="btn btn-sm btn-outline-secondary" data-toggle="modal" data-target="#myModalCrear">Crear</button>
                <button type="button" class="btn btn-sm btn-outline-secondary" onclick="java:ModificarCiclo()">Modificar</button>
                <button type="button" class="btn btn-sm btn-outline-secondary" onclick="java:DeleteCiclo()">Eliminar</button>
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
                        <th>Ciclo</th>
                        <th>Descripcion</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <%for (int i = 0; i < listarCiclo.size(); i++) {
                                Ciclo be = (Ciclo) listarCiclo.get(i);

                        %>
                        <td><input class="form-check-input" type="radio" name="idciclo" id="idciclo" value="<%=be.getIdCiclo()%>"></td>
                        <td><%=be.getIdCiclo()%></td>
                        <td><%=be.getCiclo()%></td>
                        <td><%=be.getDescripcion()%></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </form>
        <%= mensaje%>
    </div>
</div>

