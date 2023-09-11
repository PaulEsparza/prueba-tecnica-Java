<%-- 
    Document   : listCommentResponse
    Author     : paule
--%>
<%@page import="Modelo.Usuario"%>
<%@page import="Modelo.NotasCommentResponse"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.NotasCommentResponseDAO"%>
<%@page import="Modelo.NotasComment"%>
<%@page import="ModeloDAO.NotasCommentDAO"%>
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
                NotasCommentDAO dao = new NotasCommentDAO();
                int idComentario = Integer.parseInt((String) request.getAttribute("idCommentResponse"));
                NotasComment nc = (NotasComment) dao.list(idComentario);
            %>
            <div class="container">
                <h5 class="text-center">Comentario seleccionado</h5> 
                <!--<p class="text-center"><%= nc.getIdComentario()%></p>-->
                <!--<p class="text-center"><%= nc.getIdNota() %></p>-->
                <!--<p class="text-center"><%= nc.getIdUsuario()%></p>-->
                <p class="text-center"><%= nc.getComentario()%></p>
                <p class="text-center"><span>Fecha publicación: </span><%= nc.getFechaComentario()%></p>
            </div>
            
            <div class="container">
            <h3 class="text-center">Respuestas</h3>
            <table class="table table-bordered mt-2 table-hover table-striped">
              <thead>
                  <tr>
                      <th class="text-center">id Comentario Respuesta </th>
                      <th class="text-center">id Comentario</th>
                      <th class="text-center">id Usuario</th>
                      <th class="text-center">Respuesta</th>
                      <th class="text-center">fecha Respuesta</th>
                      <th class="text-center">Acciones</th>
                  </tr>
              </thead>
            <%
                 NotasCommentResponseDAO daocr = new NotasCommentResponseDAO();
                 List<NotasCommentResponse> list = daocr.listar(nc.getIdComentario());
                 Iterator<NotasCommentResponse> i = list.iterator();
                 NotasCommentResponse nota = null;
                 while (i.hasNext()) {
                       nota = i.next();
               %>
                      <tbody>
                  <tr>
                      <td class="text-center"><%= nota.getIdComentarioRespuesta()%></td>
                      <td class="text-center"><%= nota.getIdComentario()%></td>
                        <td class="text-center"><%= nota.getIdUsuario()%></td>
                        <td class="text-center"><%= nota.getComentarioRespuesta()%></td>
                        <td class="text-center"><%= nota.getFechaComentarioRespuesta()%></td>
                        <td class="text-center">
                            <!--<a href="ControladorComment?accion=addCommentResponse&id=<= nota.getIdComentarioRespuesta()%>">Responder</a>
                            <a href="ControladorComment?accion=listCommentsResponse&id=<= nota.getIdComentarioRespuesta()%>">Ver respuestas</a>
                            <a href="ControladorComment?accion=editar&id=<= nota.getIdComentarioRespuesta()%>">Editar</a>-->
                            <a class="btn btn-danger" href="ControladorCommentResponse?accion=deleteCommentResponse&id=<%= nota.getIdComentarioRespuesta()%>">Eliminar</a>
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