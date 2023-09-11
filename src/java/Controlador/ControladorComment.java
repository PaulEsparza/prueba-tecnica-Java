/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.NotasComment;
import Modelo.Usuario;
import ModeloDAO.NotasCommentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author paule
 */
public class ControladorComment extends HttpServlet {
    String listNotes = "Vistas/listNotes.jsp";
    String listCommentR = "Vistas/listCommentResponse.jsp";
    String listNote = "Vistas/listNote.jsp";
    String addComment = "Vistas/addComment.jsp";
    String addCommentResponse = "Vistas/addCommentResponse.jsp";
    //String editNote = "Vistas/editNote.jsp";
    String acceso = "";
    NotasComment nc = new NotasComment();
    NotasCommentDAO dao = new NotasCommentDAO();
    int id;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorComment</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorComment at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String accion = request.getParameter("accion");
        if(accion.equalsIgnoreCase("listCommentsResponse")){
            request.setAttribute("idCommentResponse", request.getParameter("id"));
            acceso = listCommentR;
        } 
        else if(accion.equalsIgnoreCase("addComment")){
            request.setAttribute("idNotaComment", request.getParameter("id"));
            acceso = addComment;
        } 
        else if(accion.equalsIgnoreCase("agregar")){
            int idNota = Integer.parseInt(request.getParameter("idNota"));
            String comentario = request.getParameter("comentario");
            nc.setIdNota(idNota);
            HttpSession session = request.getSession();
            Usuario user = (Usuario) session.getAttribute("user");
            nc.setIdUsuario(user.getIdUsuario());
            nc.setComentario(comentario);
            dao.crear(nc);
            acceso = listNotes;
        } /*else if(accion.equalsIgnoreCase("editar")){
            request.setAttribute("idnota", request.getParameter("id"));
            acceso = editNote;
        } else if(accion.equalsIgnoreCase("actualizarNota")){
            int idNota = Integer.parseInt(request.getParameter("idNota"));
            String nota = request.getParameter("nota");
            n.setIdNota(idNota);
            n.setIdUsuario(1);
            n.setNota(nota);
            dao.editar(n);
            acceso = listNotes;
        } */
        else if(accion.equalsIgnoreCase("addCommentResponse")){
            request.setAttribute("idComment", request.getParameter("id"));
            acceso = addCommentResponse;
        } 
        else if(accion.equalsIgnoreCase("deleteComment")){
            id = Integer.parseInt(request.getParameter("id"));
            nc.setIdComentario(id);
            dao.eliminar(id);
            acceso = listNotes;
        } 
        /*else if(accion.equalsIgnoreCase("listNote")){
            request.setAttribute("idNotaComment", request.getParameter("id"));
            acceso = listNote;
        }*/
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
