<%-- 
    Document   : Profesionales
    Created on : Nov 4, 2019, 12:15:18 AM
    Author     : Eugenia Revol <euge.revol@gmail.com>
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Honorarios Profesionales Médicos</title>
        <jsp:include page="links.jsp"></jsp:include>
        </head>
        <body>
        <jsp:include page="Nav.jsp"></jsp:include>
            <div class="container" style="margin-bottom: 100px;">
                <h1 class="mb-5">Honorarios Profesionales Médicos</h1>
                <div class="table-responsive">
                    <table class="table table-hover table-sm">
                        <thead>
                            <tr style="color: white; background-color: black;">
                                <th scope="col">Legajo</th>
                                <th scope="col">Apellido</th>
                                <th scope="col">Nombre</th>
                                <th scope="col">Ordenes</th>
                                <th scope="col">Mes</th>
                                <th scope="col">Año</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${profesionales}" var="p">
                            <tr>
                                <th scope="row">${p.getLegajo()}</th>
                                <th scope="row">${p.getApellido()}</th>
                                <th scope="row">${p.getNombre()}</th>
                                <td>${p.getOrdenes()}</td>
                                <td>${p.getMes()}</td>
                                <td>${p.getAnio()}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <jsp:include page="Footer.jsp"></jsp:include>
        <jsp:include page="scripts.jsp"></jsp:include>
    </body>
</html>
