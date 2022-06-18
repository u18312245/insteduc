<%-- 
    Document   : modalCrearCurso
    Created on : 06-jun-2022, 19:24:59
    Author     : Jose
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="modal fade" id="myModalCrear" tabindex="-1"  aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" >
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Registrar un nuevo Cargo</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form action="Administracion" method="post">
                    <input type="hidden" name="metodo" value="AgregarCargo">
                    <div class="form-group">
                        <label class="col-form-label">Nombre Cargo </label>
                        <input type="text" class="form-control" name="name">
                    </div>
                    <div class="form-group">
                        <label  class="col-form-label">Descripcion Cargo: </label>
                        <input type="text" class="form-control" name="descripcion">
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