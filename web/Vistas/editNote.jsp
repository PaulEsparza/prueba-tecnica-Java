<%-- 
    Document   : editNote
    Author     : paule
--%>
<%@page import="Modelo.Usuario"%>
<%@page import="Modelo.Notas"%>
<%@page import="ModeloDAO.NotasDAO"%>
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
            <%
                NotasDAO dao = new NotasDAO();
                int idNota = Integer.parseInt((String) request.getAttribute("idnota"));
                Notas n = (Notas) dao.list(idNota);
            %>
            <div class="container mt-4 col-lg-3">
                <h2 class="text-center">Editar noticia</h2>
                <form action="Controlador">
                <input class="form-control" type="hidden" placeholder="idNota..." name="idNota" value="<%= n.getIdNota()%>" />
                <input class="form-control" type="hidden" placeholder="idUsuario..." name="idUsuario" value="<%= n.getIdUsuario()%>" />
                <label>Ingresa la descripción de la noticia</label>
                <input class="form-control" type="text" placeholder="Descripción..." name="nota" value="<%= n.getNota() %>" />
                <input class="form-control" type="hidden" placeholder="fecha nota..." name="fechaNota" value="<%= n.getFechaNota()%>" />
                <input class="btn btn-success mt-4" type="submit" name="accion" value="actualizar" />
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