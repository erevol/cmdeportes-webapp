/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controlador.Gestor;
import Modelo.Paciente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Eugenia Revol <euge.revol@gmail.com>
 */
@WebServlet(name = "Pacientes", urlPatterns = {"/pacientes"})
public class Pacientes extends HttpServlet {

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
            Gestor g = new Gestor();
            ArrayList<Paciente> pacientes = g.obtenerPacientes();
            for (Paciente paciente : pacientes) {
                System.out.println(paciente.toString());
            }
            request.setAttribute("pacientes", pacientes);
            getServletContext().getRequestDispatcher("/Pacientes.jsp").forward(request, response);
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
        Paciente p = new Paciente();
        
        p.setNombre(request.getParameter("nombre"));
        p.setApellido(request.getParameter("apellido"));
        p.setFechaNac(request.getParameter("fechaNac"));
        p.setDni(Integer.parseInt(request.getParameter("dni")));
        p.setDireccion(request.getParameter("direccion"));
        p.setObraSocial(request.getParameter("obraSocial"));
        p.setTelefono(request.getParameter("telefono"));
        p.setTelefonoUrg(request.getParameter("telefonoUrg"));
        p.setAltura(Float.parseFloat(request.getParameter("altura")));
        p.setPeso(Float.parseFloat(request.getParameter("peso")));
        
        Gestor g = new Gestor();
        boolean exito = g.agregarPaciente(p);
        
        if (exito) {
            response.sendRedirect("pacientes");
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
