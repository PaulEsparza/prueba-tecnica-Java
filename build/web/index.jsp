<%-- 
    Document   : index
    Author     : paule
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    </head>
    <body>
        <!--<div>
            <a href="Controlador?accion=listNotes">Listar Notas</a>
        </div>-->
        <div class="container">
            <div class="container mt-4 col-lg-3">
                <h2 class="text-center">Iniciar sesión</h2>
                <div class='text-danger text-center'>${error}</div>
                <form action="Controlador" method="post">
                    <label for="username">Usuario</label>
                    <input class="form-control" type="text" id="username" name="username" required><br>

                    <label for="password">Contraseña</label>
                    <input class="form-control" type="password" id="password" name="password" required><br>

                    <input class="btn btn-success" type="submit" name="accion" value="iniciar Sesión">
                </form>
            </div>
        </div>
    </body>
</html>
