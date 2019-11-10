<%-- 
    Document   : ConsultaPaciente
    Created on : Nov 7, 2019, 5:56:54 PM
    Author     : Eugenia Revol <euge.revol@gmail.com>
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta Paciente ${paciente.getNombre()} ${paciente.getApellido()}</title>
        <jsp:include page="links.jsp"></jsp:include>
        </head>
        <body>
        <jsp:include page="Nav.jsp"></jsp:include>
            <div class="container" style="margin-bottom: 100px;">
                <h1 class="mb-5">Consulta Paciente ${paciente.getNombre()} ${paciente.getApellido()}</h1>
                <c:choose>
                    <c:when test="${empty lista}">
                        <div class="row">
                            <div class="col-md-1">
                                <div class="mb-3">
                                    <img class="img-fluid" src="img/error.png" alt="error">
                                </div>
                            </div>
                            <div class="col-md-6" style="padding-top: 10px;">
                                <div class="alert alert-dismissible alert-danger">
                                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                                    El paciente <strong>${paciente.getNombre()} ${paciente.getApellido()} </strong> no tiene asistencias... <a href="index" class="alert-link">Volver al inicio.</a>
                                </div>
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                    <div class="table-responsive">
                        <table class="table table-hover table-sm">
                            <thead>
                                <tr style="color: white; background-color: black;">
                                    <th scope="col">Orden</th>
                                    <th scope="col">Inscripcion</th>
                                    <th scope="col">Apellido</th>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Min. Mensuales</th>
                                    <th scope="col">Min. Restantes</th>
                                    <th scope="col">Practicas Restantes</th>
                                    <th scope="col">Finalizado</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${lista}" var="item">
                                <tr>
                                    <th scope="row">${item.getIdOrden()}</th>
                                    <th scope="row">${item.getIdInscripcion()}</th>
                                    <th scope="row">${item.getApellido()}</th>
                                    <th scope="row">${item.getNombre()}</th>
                                    <td>${item.getMinMensuales()}</td>
                                    <td>${item.getMinRestantes()}</td>
                                    <td>${item.getPracticasRestantes()}</td>
                                    <td>${item.getFinalizado()}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
        <jsp:include page="Footer.jsp"></jsp:include>
        <jsp:include page="scripts.jsp"></jsp:include>
    </body>
</html>
