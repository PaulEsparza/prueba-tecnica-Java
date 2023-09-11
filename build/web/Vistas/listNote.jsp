<%-- 
    Document   : listNote
    Author     : paule
--%>
<%@page import="Modelo.Usuario"%>
<%@page import="ModeloDAO.NotasDAO"%>
<%@page import="Modelo.NotasComment"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="ModeloDAO.NotasCommentDAO"%>
<%@page import="Modelo.Notas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    </head>
    <body>
        <%
Usuario usuario = (Usuario) session.getAttribute("user");
if(usuario!=null)
{

%>
        <%
                NotasDAO dao = new NotasDAO();
                int idNota = Integer.parseInt((String) request.getAttribute("idNotaComment"));
                Notas n = (Notas) dao.list(idNota);
            %>
            <div class="container">
                <h5 class="text-center mt-4">Noticia seleccionada</h5> 
                <!--<p class="text-center"><%= n.getIdNota() %></p>-->
                <!--<p class="text-center"><%= n.getIdUsuario()%></p>-->
                <p class="text-center"><%= n.getNota()%></p>
                <p class="text-center"><span>fecha publicación: </span><%= n.getFechaNota() %></p>
            </div>
            
            <div class="container">
                <h3 class="text-center">Comentarios</h3>  
          <a class="btn btn-success" href="ControladorComment?accion=addComment&id=<%= n.getIdNota()%>">Agregar Comentario</a>
          <table class="table table-bordered mt-2 table-hover table-striped">
              <thead>
                  <tr>
                      <th class="text-center">id Comentario</th>
                      <th class="text-center">id Nota</th>
                      <th class="text-center">id Usuario</th>
                      <th class="text-center">Comentario</th>
                      <th class="text-center">fecha Comentario</th>
                      <th class="text-center">Acciones</th>
                  </tr>
              </thead>
            <%
                 NotasCommentDAO daoc = new NotasCommentDAO();
                 List<NotasComment> list = daoc.listar(n.getIdNota());
                 Iterator<NotasComment> i = list.iterator();
                 NotasComment nota = null;
                 while (i.hasNext()) {
                       nota = i.next();
               %>
                      <tbody>
                  <tr>
                      <td class="text-center"><%= nota.getIdComentario()%></td>
                      <td class="text-center"><%= nota.getIdNota()%></td>
                        <td class="text-center"><%= nota.getIdUsuario()%></td>
                        <td class="text-center"><%= nota.getComentario()%></td>
                        <td class="text-center"><%= nota.getFechaComentario()%></td>
                        <td class="text-center">
                            <a class="btn btn-primary" href="ControladorComment?accion=addCommentResponse&id=<%= nota.getIdComentario()%>">Responder</a>
                            <a class="btn btn-warning" href="ControladorComment?accion=listCommentsResponse&id=<%= nota.getIdComentario()%>">Ver respuestas</a>
                            <!--<a href="ControladorComment?accion=editar&id=<= nota.getIdComentario()%>">Editar</a>-->
                            <a class="btn btn-danger" href="ControladorComment?accion=deleteComment&id=<%= nota.getIdComentario()%>">Eliminar</a>
                        </td>
                  </tr>
                  <%}%>
              </tbody>
          </table>

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