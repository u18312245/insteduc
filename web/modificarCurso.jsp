<%-- 
    Document   : modificarCurso
    Created on : 06-jun-2022, 21:03:05
    Author     : Jose
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Entidad.*,java.util.*"%>
<% Curso cursobuscado = (Curso) session.getAttribute("Cursobuscado");

    if (cursobuscado == null) {
        cursobuscado = new Curso();
    }
    String mensaje = (String) request.getAttribute("Mensaje");
    if (mensaje == null) {
        mensaje = "";
    }
%>
<!DOCTYPE html>
<jsp:include page="header.jsp"></jsp:include>
    <form name="defecto" id="defecto" method="post">
        <input type="hidden" name="metodo" id="metodo" >
        <input type="hidden" name="idmod" id="idmod" >
    </form>
    
<div class="container-fluid">
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h1 class="h2">Actualizar Informacion del Curso</h1>
    </div>
    <div class="container">
        <form action="Administracion" method="POST">

            <input type="hidden" name="metodo" id="metodo" value="ActualizarCurso">
            <input type="hidden" name="id" value="<%=cursobuscado.getIdCurso()%>">
            <div class="form-group">
                <label class="col-form-label">Curso: </label>
                <input type="text" class="form-control" name="name" value="<%=cursobuscado.getNomCurso()%>">
            </div>
            <div class="form-group">
                <label  class="col-form-label">Descripcion:</label>
                <input type="text" class="form-control" name="descripcion" value="<%=cursobuscado.getDescripCurso()%>">
            </div>


            <input type="submit" class="btn btn-primary" value="Actualizar">
            <p></p>
    </div>
</form>
</div>
         </div>
<jsp:include page="footer.jsp"></jsp:include>
<jsp:include page="Logout.jsp"></jsp:include>