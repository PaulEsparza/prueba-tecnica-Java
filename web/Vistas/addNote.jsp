<%-- 
    Document   : addNote
    Author     : paule
--%>
<%@page import="Modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    </head>
    <%
Usuario usuario = (Usuario) session.getAttribute("user");
if(usuario!=null)
{

%>
    <body>
        <div class="container">
            <div class="container mt-4 col-lg-4">
                <h2 class="text-center">Agregar noticia</h2>
                <form action="Controlador">
                    <label>Ingresa la descirpción de la noticia</label>
                    <input class="form-control" type="text" placeholder="Descripción..." name="nota" />
                    <input class="btn btn-success mt-4" type="submit" name="accion" value="agregar" />
                    <div>
                        <a class="btn btn-warning mt-4" href="Controlador?accion=listNotes">Regresar</a>
                    </div>
                </form>
            </div>
        </div>
    </body>
<% } else {
%>
<div class="container">
    <div class="container mt-4 col-lg-4">
      <p>Su sesión ha expirado</p>
       <a class="btn btn-link mt-4" href="Controlador?accion=logout">Regresar</a>  
    </div>
</div>
<% }
%>
</html>

