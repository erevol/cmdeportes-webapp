<%-- 
    Document   : ModificarPaciente
    Created on : Nov 1, 2019, 11:41:45 PM
    Author     : Eugenia Revol <euge.revol@gmail.com>
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Paciente</title>
        <jsp:include page="links.jsp"></jsp:include>
    </head>
    <body>
        <jsp:include page="Nav.jsp"></jsp:include>
        <div class="container">
            <h1 class="mb-5">Modificar Paciente</h1>
            <div class="row mb-5">
                <form action="ModificarPaciente" method="POST" class="needs-validation" novalidate>
                    <div class="form-row">
                        <div class="form-group col-md-2">
                            <label for="nombre">Nombre</label>
                            <input type="hidden" name="idPaciente" value="${paciente.getIdPaciente()}">
                            <input required class="form-control" class="form-control" type="text"  name="nombre" id="nombre" placeholder="Nombre" value="${paciente.getNombre()}">
                            <div class="invalid-feedback">Nombre invalido.</div><div class="valid-feedback">Ok!</div>
                        </div>
                        <div class="form-group col-md-2">
                            <label for="apellido">Apellido</label>
                            <input required class="form-control" type="text"  name="apellido" id="apellido" placeholder="Apellido" value="${paciente.getApellido()}">
                            <div class="invalid-feedback">Apellido invalido.</div><div class="valid-feedback">Ok!</div>
                        </div>
                        <div class="form-group col-md-2">
                            <label for="fechaNac">Fecha de Nacimiento</label>
                            <input required class="form-control" type="text"  name="fechaNac" id="fechaNac" placeholder="dd/mm/aaaa" value="${paciente.getFechaNac()}">
                            <div class="invalid-feedback">Fecha invalido.</div><div class="valid-feedback">Ok!</div>
                        </div>
                        <div class="form-group col-md-2">
                            <label for="dni">Dni</label>
                            <input required class="form-control" type="number"  name="dni" id="dni" placeholder="DNI" value="${paciente.getDni()}">
                            <div class="invalid-feedback">DNI invalido.</div><div class="valid-feedback">Ok!</div>
                        </div>
                        <div class="form-group col-md-2">
                            <label for="direccion">Direccion</label>
                            <input required class="form-control" type="text"  name="direccion" id="direccion" placeholder="Dirección" value="${paciente.getDireccion()}">
                            <div class="invalid-feedback">Dirección invalida.</div><div class="valid-feedback">Ok!</div>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-2">
                            <label for="obraSocial">Obra Social</label>
                            <input required class="form-control" type="text"  name="obraSocial" id="obraSocial" placeholder="Obra Social" value="${paciente.getObraSocial()}">
                            <div class="invalid-feedback">Obra Social invalido.</div><div class="valid-feedback">Ok!</div>
                        </div>
                        <div class="form-group col-md-2">
                            <label for="telefono">Telefono</label>
                            <input required class="form-control" type="number"  name="telefono" id="telefono" placeholder="Telefono" value="${paciente.getTelefono()}">
                            <div class="invalid-feedback">Telefono invalido.</div><div class="valid-feedback">Ok!</div>
                        </div>
                        <div class="form-group col-md-2">
                            <label for="telefonoUrg">Telefono de Urgencia</label>
                            <input required class="form-control" type="number"  name="telefonoUrg" id="telefonoUrg" placeholder="Telefono" value="${paciente.getTelefonoUrg()}">
                            <div class="invalid-feedback">Telefono invalido.</div><div class="valid-feedback">Ok!</div>
                        </div>
                        <div class="form-group col-md-2">
                            <label for="altura">Altura</label>
                            <input required class="form-control" type="number"  name="altura" min="0" step=".01" id="altura" placeholder="Altura" value="${paciente.getAltura()}">
                            <div class="invalid-feedback">Altura invalido.</div><div class="valid-feedback">Ok!</div>
                        </div>
                        <div class="form-group col-md-2">
                            <label for="peso">Peso</label>
                            <input required class="form-control" type="number"  name="peso" min="0" step=".01" id="peso" placeholder="Peso" value="${paciente.getPeso()}">
                            <div class="invalid-feedback">Peso invalido.</div><div class="valid-feedback">Ok!</div>
                        </div>
                    </div>
                    <button class="btn btn-success mt-3" type="submit">Modificar</button>
                </form>
            </div>
            <div class="row mb-3">
                <div class="col-4">
                    <h1>Pacientes</h1>
                </div>
            </div>
        </div>
        <jsp:include page="Footer.jsp"></jsp:include>
        <jsp:include page="scripts.jsp"></jsp:include>
    </body>
</html>
