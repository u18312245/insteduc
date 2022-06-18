<%-- 
    Document   : Login
    Created on : 04-jun-2022, 22:07:35
    Author     : Jose
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String mensaje = (String) request.getAttribute("mensaje_login");
    if (mensaje == null) {
        mensaje = "";
    }
    String validar = (String) session.getAttribute("usuario");

%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>RCAN SYSTEM - Login</title>

        <!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="css/sb-admin-2.min.css" rel="stylesheet">

    </head>

    <body class="bg-gradient-primary">

        <div class="container">

            <!-- Outer Row -->
            <div class="row justify-content-center">

                <div class="col-xl-10 col-lg-12 col-md-9">

                    <div class="card o-hidden border-0 shadow-lg my-5">
                        <div class="card-body p-0">
                            <!-- Nested Row within Card Body -->
                            <div class="row">
                                <div class="col-lg-6 d-none d-lg-block bg-login-image">
                                    
                                </div>
                                <div class="col-lg-6">
                                    <div class="p-5">
                                        <div class="text-center">
                                            <h1 class="h4 text-gray-900 mb-4">RCAN - REGISTRO CENTRALIZADO DE NOTAS</h1>
                                        </div>
                                        <form name="defecto" method="post">
                                            <input type="hidden" name="metodo">
                                        </form>
                                        <form class="user" method="post" action="Administracion">
                                             <input type="hidden" name="metodo" value="Login">
                                            <div class="form-group">
                                                <input type="text" class="form-control form-control-user"
                                                       id="exampleInputEmail" aria-describedby="emailHelp"
                                                       placeholder="Enter User..." name="user">
                                            </div>
                                            <div class="form-group">
                                                <input type="password" class="form-control form-control-user"
                                                       id="exampleInputPassword" placeholder="Password" name="password">
                                            </div>
                                             <button class="btn btn-primary btn-user btn-block" type="submit">Iniciar Sesion</button>
                                        </form>
                                        <%=mensaje%>
                                        <hr>
                                        <div class="text-center">
                                            <a class="small" href="">Olvidaste la contraseña</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>

            </div>

        </div>

        <!-- Bootstrap core JavaScript-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="js/sb-admin-2.min.js"></script>

    </body>

</html>