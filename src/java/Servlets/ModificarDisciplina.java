/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;
import Controlador.Gestor;
import Modelo.Disciplina;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Eugenia Revol <euge.revol@gmail.com>
 */
@WebServlet(name = "ModificarDisciplina", urlPatterns = {"/ModificarDisciplina"})
public class ModificarDisciplina extends HttpServlet {

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
        HttpSession session = request.getSession();
        if(session.getAttribute("isLogged") != null && (boolean) session.getAttribute("isLogged") == true){
            int idDisciplina = Integer.parseInt(request.getParameter("idDisciplina"));
            System.out.println("ID:" + idDisciplina);
            Gestor g = new Gestor();
            Disciplina d = g.obtenerDisciplinaPorId(idDisciplina);
            System.out.println(d.toString());
            request.setAttribute("disciplina", d);

            getServletContext().getRequestDispatcher("/ModificarDisciplina.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
            request.getSession().invalidate();
        }
        processRequest(request, response);
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
        Disciplina d = new Disciplina();
        d.setIdDisciplina(Integer.parseInt(request.getParameter("idDisciplina")));
        d.setNombre(request.getParameter("nombre"));
        
        Gestor g = new Gestor();
        boolean exito = g.modificarDisciplina(d);
        
        if (exito) {
            response.sendRedirect("disciplinas");
        } else {
            getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
        }
        
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
