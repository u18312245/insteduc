<%-- 
    Document   : pag_administracion
    Created on : 04-jun-2022, 23:08:57
    Author     : Jose
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<jsp:include page="header.jsp"></jsp:include>
    <form name="defecto" id="defecto" method="post">
        <input type="hidden" name="metodo" id="metodo" >
        <input type="hidden" name="idmod" id="idmod" >
    </form>
    <!-- Page Heading -->
<jsp:include page="modulo_cursos.jsp"></jsp:include>

    <!-- /.container-fluid -->

</div>
<!-- End of Main Content -->
<jsp:include page="modalCrearCurso.jsp"></jsp:include>
<jsp:include page="footer.jsp"></jsp:include>
<jsp:include page="Logout.jsp"></jsp:include>
