<%-- 
    Document   : Disciplinas
    Created on : Nov 4, 2019, 3:01:31 AM
    Author     : Eugenia Revol <euge.revol@gmail.com>
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Disciplinas</title>
        <jsp:include page="links.jsp"></jsp:include>
    </head>
    <body>
        <jsp:include page="Nav.jsp"></jsp:include>
        <div class="container" style="margin-bottom: 100px;">
            <div class="row mb-3">
                <div class="col-4">
                    <h1>Disciplinas</h1>
                </div>
            </div>
            <div class="row mb-3">
                <div class="col-8">
                    <div class="table-responsive">
                        <table class="table table-hover table-sm">
                            <tbody>
                            <c:forEach items="${disciplinas}" var="d">
                                <tr>
                                    <th scope="row">${d.getNombre()}</th>
                                    <td>
                                        <a class="btn btn-sm btn-outline-primary" href="PacientesInscriptos?idDisciplina=${d.getIdDisciplina()}">Pacientes inscriptos</a>
                                        <a class="btn btn-sm btn-outline-primary" href="ModificarDisciplina?idDisciplina=${d.getIdDisciplina()}">Modificar</a>
                                        <a class="btn btn-sm btn-outline-danger" href="EliminarDisciplina?idDisciplina=${d.getIdDisciplina()}">Eliminar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="col-4">
                    <div class="row mb-3">
                        <div class="col-4">
                            <h3>Alta Disciplinas</h3>
                        </div>
                    </div>
                    <form action="disciplinas" method="post" class="needs-validation" novalidate>
                        <div class="form-group">
                            <label class="col-form-label col-form-label-lg" for="nombre">Nombre</label>
                            <input required class="form-control form-control-lg" type="text" placeholder="Nueva disciplina..." name="nombre" id="nombre" value="${nombre}">
                            <div class="invalid-feedback">
                                Nombre invalido.
                            </div>
                            <div class="valid-feedback">
                                Ok!
                            </div>
                        </div>
                        <button type="submit" class="btn btn-success">Cargar</button>
                    </form>
                </div>
            </div>
        </div>
        <jsp:include page="Footer.jsp"></jsp:include>
        <jsp:include page="scripts.jsp"></jsp:include>
    </body>
</html>
