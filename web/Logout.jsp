<%-- 
    Document   : Logout
    Created on : 05-jun-2022, 23:50:00
    Author     : Jose
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Seguro que desea Salir?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">Selecciona "Confirmar" si estas seguro que quieres finalizar la sesion actual.</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-primary" onclick="java:Logout()" >Confirmar</button>
            </div>
        </div>
    </div>
</div>