/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Notas;
import Modelo.Usuario;
import ModeloDAO.NotasDAO;
import ModeloDAO.UsuarioDAO;
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
public class Controlador extends HttpServlet {
    String listNotes = "Vistas/listNotes.jsp";
    String listNote = "Vistas/listNote.jsp";
    String addNote = "Vistas/addNote.jsp";
    String editNote = "Vistas/editNote.jsp";
    String acceso = "";
    Notas n = new Notas();
    NotasDAO dao = new NotasDAO();
    int id;
    UsuarioDAO udao = new UsuarioDAO();
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
            out.println("<title>Servlet Controlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
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
        String accion = request.getParameter("accion");
        if(accion.equalsIgnoreCase("listNotes")){
            acceso = listNotes;
        } 
        else if(accion.equalsIgnoreCase("addNote")){
            acceso = addNote;
        } else if(accion.equalsIgnoreCase("agregar")){
            String nota = request.getParameter("nota");
            HttpSession session = request.getSession();
            Usuario user = (Usuario) session.getAttribute("user");
            n.setIdUsuario(user.getIdUsuario());
            n.setNota(nota);
            dao.crear(n);
            acceso = listNotes;
        } else if(accion.equalsIgnoreCase("editar")){
            request.setAttribute("idnota", request.getParameter("id"));
            acceso = editNote;
        } else if(accion.equalsIgnoreCase("actualizar")){
            int idNota = Integer.parseInt(request.getParameter("idNota"));
            String nota = request.getParameter("nota");
            HttpSession session = request.getSession();
            Usuario user = (Usuario) session.getAttribute("user");
            n.setIdNota(idNota);
            n.setIdUsuario(user.getIdUsuario());
            n.setNota(nota);
            dao.editar(n);
            acceso = listNotes;
        } else if(accion.equalsIgnoreCase("deleteNote")){
            id = Integer.parseInt(request.getParameter("id"));
            n.setIdNota(id);
            dao.eliminar(id);
            acceso = listNotes;
        } else if(accion.equalsIgnoreCase("listNote")){
            request.setAttribute("idNotaComment", request.getParameter("id"));
            acceso = listNote;
        } else if(accion.equalsIgnoreCase("logout")){
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
                acceso = "index.jsp";
            }
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
        //processRequest(request, response);
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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        System.err.println(username + " " + password);
        Usuario user = getUserData(username, password);
        
        if (user == null) {
            request.setAttribute("error", "Los datos no son correctos");
            //request.getRequestDispatcher("index.jsp").forward(request, response);
            RequestDispatcher vista = request.getRequestDispatcher("index.jsp");
            vista.forward(request, response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            RequestDispatcher vista = request.getRequestDispatcher(listNotes);
            vista.forward(request, response);
        }
    }
    
    private Usuario getUserData(String username, String password) {
        Usuario u = udao.list(username, password);
        //System.err.println("USEEER " + u);
        return u;
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
