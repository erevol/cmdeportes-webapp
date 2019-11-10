<%-- 
    Document   : Pacientes
    Created on : Nov 2, 2019, 1:49:09 AM
    Author     : Eugenia Revol <euge.revol@gmail.com>
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Pacientes Inscriptos en ${disciplina.getNombre()}</title>
        <jsp:include page="links.jsp"></jsp:include>
        </head>
        <body>
        <jsp:include page="Nav.jsp"></jsp:include>
        <div class="container" style="margin-bottom: 100px;">
            <h1 class="mb-5">Listado de Pacientes Inscriptos en ${disciplina.getNombre()}</h1>
            <c:choose>
                <c:when test="${empty pacientes}">
                    <div class="row">
                        <div class="col-md-1">
                            <div class="mb-3">
                                <img class="img-fluid" src="img/error.png" alt="error">
                            </div>
                        </div>
                        <div class="col-md-6" style="padding-top: 10px;">
                            <div class="alert alert-dismissible alert-danger">
                                <button type="button" class="close" data-dismiss="alert">&times;</button>
                                <strong>${disciplina.getNombre()} </strong> no tiene pacientes inscriptos todavía...
                            </div>
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="table-responsive">
                        <table class="table table-hover table-sm">
                            <thead>
                                <tr style="color: white; background-color: black;">
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Apellido</th>
                                    <th scope="col">Fecha Nac.</th>
                                    <th scope="col">DNI</th>
                                    <th scope="col">Direccion</th>
                                    <th scope="col">Obra Social</th>
                                    <th scope="col">Telefono</th>
                                    <th scope="col">Telefono Urg.</th>
                                    <th scope="col">Altura</th>
                                    <th scope="col">Peso</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${pacientes}" var="p">
                                <tr>
                                    <th scope="row">${p.getNombre()}</th>
                                    <th scope="row">${p.getApellido()}</th>
                                    <td>${p.getFechaNac()}</td>
                                    <td>${p.getDni()}</td>
                                    <td>${p.getDireccion()}</td>
                                    <td>${p.getObraSocial()}</td>
                                    <td>${p.getTelefono()}</td>
                                    <td>${p.getTelefonoUrg()}</td>
                                    <td>${p.getAltura()}</td>
                                    <td>${p.getPeso()}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </c:otherwise>
        </c:choose>
        </div>
        <jsp:include page="Footer.jsp"></jsp:include>
        <jsp:include page="scripts.jsp"></jsp:include>
    </body>
</html>
