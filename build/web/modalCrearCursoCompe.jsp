<%-- 
    Document   : modalCrearCurso
    Created on : 06-jun-2022, 19:24:59
    Author     : Jose
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Entidad.*,java.util.*"%>
<%
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
%>
<!DOCTYPE html>
<div class="modal fade" id="myModalCrear" tabindex="-1"  aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" >
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Registrar una competencia para el curso</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form action="Administracion" method="post">
                    <input type="hidden" name="metodo" value="AgregarCursoCompetencia">
                    <div class="form-group">
                        <label  class="col-form-label">Curso </label>
                        <select class="form-control" name="curso">
                            <option selected>Choose...</option>
                            <%for (int i = 0; i < listacurso.size(); i++) {
                                    Curso be = (Curso) listacurso.get(i);

                            %>
                            <option value="<%=be.getIdCurso()%>"><%=be.getNomCurso()%></option>
                            <%}%>
                        </select>
                    </div>
                    <div class="form-group">
                        <label  class="col-form-label">Competencia: </label>
                        <input type="text" class="form-control" name="competencia">
                    </div>
                    <div class="form-group">
                        <label  class="col-form-label">Detalle Competencia: </label>
                        <input type="text" class="form-control" name="descripcion_competencia">
                    </div>
                    <div class="form-group">
                        <label  class="col-form-label">Ciclo: </label>
                        <select class="form-control" name="ciclo">
                            <option selected>Choose...</option>
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
                            <option selected>Choose...</option>
                            <%for (int i = 0; i < listagrado.size(); i++) {
                                    Grado be = (Grado) listagrado.get(i);

                            %>
                            <option value="<%=be.getIdGrado()%>"><%=be.getGrado()%></option>
                            <%}%>
                        </select>
                    </div>                  
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                <input type="submit" class="btn btn-primary" value="Enviar">
            </div>
            </form>

        </div>
    </div>
</div>