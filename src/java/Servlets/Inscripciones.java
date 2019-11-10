/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controlador.Gestor;
import DTO.ListadoOrdenes;
import Modelo.Inscripcion;
import Modelo.Orden;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "Inscripciones", urlPatterns = {"/Inscripciones"})
public class Inscripciones extends HttpServlet {

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
            try {
                int idOrden = Integer.parseInt(request.getParameter("idOrden"));
                System.out.println("ID a inscribir " + idOrden);
                Gestor g = new Gestor();
                boolean exito = g.agregarInscripcion(idOrden, (String) request.getSession().getAttribute("usuarioLogeado"));

                if (exito) {
                    response.sendRedirect("ordenes");
                } else {
                    response.sendRedirect("/error.jsp");
                }
            } catch (Exception e) {
                response.sendRedirect("/error.jsp");
            }
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
