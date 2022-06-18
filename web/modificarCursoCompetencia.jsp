<%-- 
    Document   : modificarCurso
    Created on : 06-jun-2022, 21:03:05
    Author     : Jose
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Entidad.*,java.util.*"%>
<% Curso_Competencia compebuscado = (Curso_Competencia) session.getAttribute("CursoCompetenciabuscado");

    if (compebuscado == null) {
        compebuscado = new Curso_Competencia();
    }
    ArrayList listacurso = (ArrayList) session.getAttribute("ListarCurso");
    if (listacurso == null) {
        listacurso = new ArrayList();
    }
    ArrayList listaciclo = (ArrayList) session.getAttribute("ListarCiclo");
    if (listaciclo == null) {
        listaciclo = new ArrayList();
    }
    ArrayList listagrado = (ArrayList) session.getAttribute("ListarGrado");
    if (listagrado == null) {
        listagrado = new ArrayList();
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
        <h1 class="h2">Actualizar Informacion del Curso Competencia</h1>
    </div>
    <div class="container">
        <form action="Administracion" method="POST">

            <input type="hidden" name="metodo" id="metodo" value="ActualizarCursoCompetencia">
            <input type="hidden" name="id" value="<%=compebuscado.getIdCursocompe()%>">
                    <div class="form-group">
                        <label  class="col-form-label">Curso </label>
                        <select class="form-control" name="curso">
                            <option value="<%=compebuscado.getIdCurso()%>"><%=compebuscado.getNomCurso()%></option>
                            <option value="">--------------------------</option>
                            <%for (int i = 0; i < listacurso.size(); i++) {
                                    Curso be = (Curso) listacurso.get(i);

                            %>
                            <option value="<%=be.getIdCurso()%>"><%=be.getNomCurso()%></option>
                            <%}%>
                        </select>
                    </div>
                    <div class="form-group">
                        <label  class="col-form-label">Competencia: </label>
                        <input type="text" class="form-control" name="competencia" value="<%=compebuscado.getCompetencia()%>">
                    </div>
                    <div class="form-group">
                        <label  class="col-form-label">Detalle Competencia: </label>
                        <input type="text" class="form-control" name="descripcion_competencia" value="<%=compebuscado.getDetalle_competencia()%>">
                    </div>
                    <div class="form-group">
                        <label  class="col-form-label">Ciclo: </label>
                        <select class="form-control" name="ciclo">
                            <option value="<%=compebuscado.getIdCiclo()%>"><%=compebuscado.getCiclo()%></option>
                            <option value="">--------------------------</option>
                            <%for (int i = 0; i < listaciclo.size(); i++) {
                                    Ciclo be = (Ciclo) listaciclo.get(i);

                            %>
                            <option value="<%=be.getIdCiclo()%>"><%=be.getCiclo()%></option>
                            <%}%>
                        </select>
                    </div>
                    <div class="form-group">
                        <label  class="col-form-label">Grado: </label>
                        <select class="form-control" name="grado">
                            <option value="<%=compebuscado.getIdGrado()%>"><%=compebuscado.getGrado()%></option>
                            <option value="">--------------------------</option>
                            <%for (int i = 0; i < listagrado.size(); i++) {
                                    Grado be = (Grado) listagrado.get(i);

                            %>
                            <option value="<%=be.getIdGrado()%>"><%=be.getGrado()%></option>
                            <%}%>
                        </select>
                    </div>  
            <input type="submit" class="btn btn-primary" value="Actualizar">
            <p></p>
    </div>
</form>
</div>
         </div>
<jsp:include page="footer.jsp"></jsp:include>
<jsp:include page="Logout.jsp"></jsp:include>