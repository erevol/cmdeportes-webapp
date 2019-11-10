<%-- 
    Document   : Ordenes
    Created on : Nov 4, 2019, 1:56:55 PM
    Author     : Eugenia Revol <euge.revol@gmail.com>
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ordenes</title>
        <jsp:include page="links.jsp"></jsp:include>
    </head>
    <body>
        <jsp:include page="Nav.jsp"></jsp:include>
        <div class="container">
        <h1 class="mb-5">Ingrese Orden</h1>
        <form action="ordenes" method="POST" class="needs-validation" novalidate>
            <div class="form-row">
                <div class="form-group col-md-3">
                    <label for="idPaciente">Paciente</label>
                    <select class="form-control" name="idPaciente" id="idPaciente">
                        <c:forEach var="pac" items="${pacientes}">
                            <option value="${pac.getIdPaciente()}">${pac.getNombre()} ${pac.getApellido()}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group col-md-3">
                    <label for="idProfesional">Profesional</label>
                    <select class="form-control" name="idProfesional" id="idProfesional">
                        <c:forEach var="p" items="${profesionales}">
                            <option value="${p.getIdProfesional()}">${p.getNombre()} ${p.getApellido()}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group col-md-2">
                    <label for="idDisciplina">Disciplina</label>
                    <select class="form-control" name="idDisciplina" id="idDisciplina">
                        <c:forEach var="d" items="${disciplinas}">
                            <option value="${d.getIdDisciplina()}">${d.getNombre()}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-2">
                    <label for="fecha">Cantidad de Prácticas</label>
                    <input required class="form-control" type="number"  min="1" name="cantPracticas" id="fecha" placeholder="mínimo 1" value="${cantPracticas}">
                    <div class="invalid-feedback">Invalido.</div><div class="valid-feedback">Ok!</div>
                </div>
                <div class="form-group col-md-2">
                    <label for="fecha">Minutos mensuales</label>
                    <input required class="form-control" type="number"  min="15" name="minMensuales" id="fecha" placeholder="mínimo 15" value="${minMensuales}">
                    <div class="invalid-feedback">Invalido.</div><div class="valid-feedback">Ok!</div>
                </div>
            </div>
            <button class="btn btn-success mt-3 col-md-2" type="submit">Cargar</button>
        </form>
        <div class="row mt-5">
            <div class="col-4">
                <h1>Ordenes</h1>
            </div>
        </div>
        </div>
        <div class="container-fluid mt-5" style="margin-bottom: 100px;">
            <div class="table-responsive">
                <table class="table table-hover table-sm">
                    <thead>
                        <tr style="color: white; background-color: black;">
                            <th scope="col">Orden</th>
                            <th scope="col">Paciente</th>
                            <th scope="col">Profesional</th>
                            <th scope="col">Disciplina</th>
                            <th scope="col">Cantidad de Prácticas</th>
                            <th scope="col">Minutos mensuales</th>
                            <th scope="col">Fecha</th>
                            <th scope="col">Inscripciones</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${ordenes}" var="o">
                        <tr>
                            <th scope="row">${o.getIdOrden()}</th>
                            <th>${o.getIdPaciente()}</th>
                            <td>${o.getIdProfesional()}</td>
                            <td>${o.getIdDisciplina()}</td>
                            <td>${o.getCantPracticas()}</td>
                            <td>${o.getMinMensuales()}</td>
                            <td>${o.getFecha()}</td>
                            <c:if test="${o.getInscripto() == 'No'}">
                            <td>
                                <a class="btn btn-sm btn-outline-success" href="Inscripciones?idOrden=${o.getIdOrden()}">Inscribir</a>
                            </td>
                            </c:if>
                            
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
