<%-- 
    Document   : listNotes
    Author     : paule
--%>

<%@page import="Modelo.Usuario"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
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
    <body class="container">
        <a class="btn btn-warning mt-4" href="Controlador?accion=logout">Cerrar Sesión</a>
        <div class="container">
            <div class="container">
                <h2 class="text-center">!Bienvenido, ${sessionScope.user.usuario}!</h2>
                <h5 class="text-center">!Estas son tus Noticias!</h5>
            </div>
          <c:if test="${sessionScope.user.tipoUsuario == 'Personal'}">
              <a class="btn btn-success" href="Controlador?accion=addNote">Crear Nota</a>
          </c:if>
              <table class="table table-bordered mt-2 table-hover table-striped">
              <thead>
                  <tr>
                      <th class="text-center">id Nota</th>
                      <th class="text-center">id Usuario</th>
                      <th class="text-center">Nota</th>
                      <th class="text-center">fecha Nota</th>
                      <th class="text-center">Acciones</th>
                  </tr>
              </thead>
              <%
                 NotasDAO dao = new NotasDAO();
                 List<Notas> list = dao.listar();
                 Iterator<Notas> i = list.iterator();
                 Notas nota = null;
                 while (i.hasNext()) {
                       nota = i.next();
               %>
              <tbody>
                  <tr>
                      <td class="text-center"><%= nota.getIdNota()%></td>
                        <td class="text-center"><%= nota.getIdUsuario()%></td>
                        <td class="text-center"><%= nota.getNota()%></td>
                        <td class="text-center"><%= nota.getFechaNota()%></td>
                        <td class="text-center">
                            <a class="btn btn-primary" href="Controlador?accion=listNote&id=<%= nota.getIdNota() %>">Ver comentarios</a>
                            <a class="btn btn-warning" href="Controlador?accion=editar&id=<%= nota.getIdNota() %>">Editar</a>
                            <a  class="btn btn-danger" href="Controlador?accion=deleteNote&id=<%= nota.getIdNota() %>">Eliminar</a>
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
