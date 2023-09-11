/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.NotasCommentResponse;
import Modelo.Usuario;
import ModeloDAO.NotasCommentResponseDAO;
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
public class ControladorCommentResponse extends HttpServlet {
    String listNotes = "Vistas/listNotes.jsp";
    String acceso = "";
    NotasCommentResponse ncr = new NotasCommentResponse();
    NotasCommentResponseDAO dao = new NotasCommentResponseDAO();
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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorCommentResponse</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorCommentResponse at " + request.getContextPath() + "</h1>");
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
        if(accion.equalsIgnoreCase("agregar")){
            int idComentario = Integer.parseInt(request.getParameter("idComentario"));
            String respuesta = request.getParameter("respuesta");
            HttpSession session = request.getSession();
            Usuario user = (Usuario) session.getAttribute("user");
            ncr.setIdComentario(idComentario);
            ncr.setIdUsuario(user.getIdUsuario());
            ncr.setComentarioRespuesta(respuesta);
            dao.crear(ncr);
            acceso = listNotes;
        } 
        else if(accion.equalsIgnoreCase("deleteCommentResponse")){
            id = Integer.parseInt(request.getParameter("id"));
            ncr.setIdComentarioRespuesta(id);
            dao.eliminar(id);
            acceso = listNotes;
        }
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
        processRequest(request, response);
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
