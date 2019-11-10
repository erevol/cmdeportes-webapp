/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controlador.Gestor;
import Modelo.Profesional;
import DTO.ListadoProfesionales;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Eugenia Revol <euge.revol@gmail.com>
 */
@WebServlet(name = "Profesionales", urlPatterns = {"/profesionales"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5,
        location = "C:\\Users\\revol\\Documents\\NetBeansProjects\\CentroMedico\\web\\img")
public class Profesionales extends HttpServlet {

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
        // Esta ruta no esta protegida, ya que puede ser accedida sin login
        Gestor g = new Gestor();
        ArrayList<ListadoProfesionales> profesionales = g.obtenerProfesionales();
        for (ListadoProfesionales profesional : profesionales) {
            System.out.println(profesional.toString());
        }
        request.setAttribute("profesionales", profesionales);
        getServletContext().getRequestDispatcher("/Profesionales.jsp")
                    .forward(request, response);
       
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
        Profesional p = new Profesional();
        p.setIdTipo(Integer.parseInt(request.getParameter("idTipo")));
        p.setLegajo(Integer.parseInt(request.getParameter("legajo")));
        p.setNombre(request.getParameter("nombre"));
        p.setApellido(request.getParameter("apellido"));
        p.setFechaNac(request.getParameter("fechaNac"));
        p.setDni(Integer.parseInt(request.getParameter("dni")));
        p.setDireccion(request.getParameter("direccion"));
        p.setTelefono(request.getParameter("telefono"));
        p.setMatricula(request.getParameter("matricula"));
        
        String fileName = "avatar.png";
        // Subida de foto
        for (Part part : request.getParts()) {
            fileName = getFileName(part);
            System.out.println(fileName);
            if (!fileName.isEmpty()) {
                part.write(fileName);
                p.setUrlFoto(fileName);
                break;
            }   
        }
        
        Gestor g = new Gestor();
        boolean exito = g.agregarProfesional(p);
        
        if (exito) {
            response.sendRedirect("profesionales");
        } else {
            getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
        }
        processRequest(request, response);
    }
    
    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
            }
        }
        return "";
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
