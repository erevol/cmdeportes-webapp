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
        <title>Listado de Pacientes</title>
        <jsp:include page="links.jsp"></jsp:include>
        </head>
        <body>
        <jsp:include page="Nav.jsp"></jsp:include>
        <div class="container">
            <h1 class="mb-5">Ingrese Paciente</h1>
            <div class="row mb-5">
                <form action="pacientes" method="POST" class="needs-validation" novalidate>
                    <div class="form-row">
                        <div class="form-group col-md-2">
                            <label for="nombre">Nombre</label>
                            <input required class="form-control" class="form-control" type="text"  name="nombre" id="nombre" placeholder="Nombre" value="${nombre}">
                            <div class="invalid-feedback">Nombre invalido.</div><div class="valid-feedback">Ok!</div>
                        </div>
                        <div class="form-group col-md-2">
                            <label for="apellido">Apellido</label>
                            <input required class="form-control" type="text"  name="apellido" id="apellido" placeholder="Apellido" value="${apellido}">
                            <div class="invalid-feedback">Apellido invalido.</div><div class="valid-feedback">Ok!</div>
                        </div>
                        <div class="form-group col-md-2">
                            <label for="fechaNac">Fecha de Nacimiento</label>
                            <input required class="form-control" type="text"  name="fechaNac" id="fechaNac" placeholder="dd/mm/aaaa" value="${fechaNac}">
                            <div class="invalid-feedback">Fecha invalido.</div><div class="valid-feedback">Ok!</div>
                        </div>
                        <div class="form-group col-md-2">
                            <label for="dni">Dni</label>
                            <input required class="form-control" type="number"  name="dni" id="dni" placeholder="DNI" value="${dni}">
                            <div class="invalid-feedback">DNI invalido.</div><div class="valid-feedback">Ok!</div>
                        </div>
                        <div class="form-group col-md-2">
                            <label for="direccion">Direccion</label>
                            <input required class="form-control" type="text"  name="direccion" id="direccion" placeholder="Dirección" value="${direccion}">
                            <div class="invalid-feedback">Dirección invalida.</div><div class="valid-feedback">Ok!</div>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-2">
                            <label for="obraSocial">Obra Social</label>
                            <input required class="form-control" type="text"  name="obraSocial" id="obraSocial" placeholder="Obra Social" value="${obraSocial}">
                            <div class="invalid-feedback">Obra Social invalido.</div><div class="valid-feedback">Ok!</div>
                        </div>
                        <div class="form-group col-md-2">
                            <label for="telefono">Telefono</label>
                            <input required class="form-control" type="number"  name="telefono" id="telefono" placeholder="Telefono" value="${telefono}">
                            <div class="invalid-feedback">Telefono invalido.</div><div class="valid-feedback">Ok!</div>
                        </div>
                        <div class="form-group col-md-2">
                            <label for="telefonoUrg">Telefono de Urgencia</label>
                            <input required class="form-control" type="number"  name="telefonoUrg" id="telefonoUrg" placeholder="Telefono" value="${telefonoUrg}">
                            <div class="invalid-feedback">Telefono invalido.</div><div class="valid-feedback">Ok!</div>
                        </div>
                        <div class="form-group col-md-2">
                            <label for="altura">Altura</label>
                            <input required class="form-control" type="number"  min="0" step=".01" name="altura" id="altura" placeholder="Altura" value="${altura}">
                            <div class="invalid-feedback">Altura invalido.</div><div class="valid-feedback">Ok!</div>
                        </div>
                        <div class="form-group col-md-2">
                            <label for="peso">Peso</label>
                            <input required class="form-control" type="number"  min="0" step=".01" name="peso" id="peso" placeholder="Peso" value="${peso}">
                            <div class="invalid-feedback">Peso invalido.</div><div class="valid-feedback">Ok!</div>
                        </div>
                    </div>
                    <button class="btn btn-success mt-3" type="submit">Cargar</button>
                </form>
            </div>
            <div class="row mb-3">
                <div class="col-4">
                    <h1>Pacientes</h1>
                </div>
            </div>
        </div>
        <div class="container-fluid" style="margin-bottom: 100px;">
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
                            <th scope="col" colspan="3"></th>
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
                            <td><a class="btn btn-sm btn-outline-primary" href="ConsultaPaciente?idPaciente=${p.getIdPaciente()}">Reporte</a></td>
                            <td><a class="btn btn-sm btn-outline-primary" href="ModificarPaciente?idPaciente=${p.getIdPaciente()}">Modificar</a></td>
                            <td><a class="btn btn-sm btn-outline-danger" href="EliminarPaciente?idPaciente=${p.getIdPaciente()}">Eliminar</a></td>
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
