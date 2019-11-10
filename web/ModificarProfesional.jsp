<%-- 
    Document   : ModificarProfesional
    Created on : Nov 6, 2019, 1:50:05 AM
    Author     : Eugenia Revol <euge.revol@gmail.com>
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Profesional</title>
        <jsp:include page="links.jsp"></jsp:include>
    </head>
    <body>
        <jsp:include page="Nav.jsp"></jsp:include>
        <div class="container">
            <div class="row justify-content-between">
                <div class="form-group col-md-5">
                    <h1 class="mb-5">Ingrese Profesional</h1>
                </div>
                <div class="form-group col-md-5">
                    <a class="btn btn-sm btn-outline-primary" href="#">Honorarios Instructores</a>
                    <a class="btn btn-sm btn-outline-primary" href="#">Honorarios Médicos</a>
                </div>
            </div>
            <div class="row">
                <form action="ModificarProfesional" method="POST" class="needs-validation" novalidate>
                    <div class="form-row">
                        <div class="form-group col-md-2">
                            <label for="nombre">Legajo</label>
                            <input type="hidden" name="idProfesional" value="${profesional.getIdProfesional()}">
                            <input required class="form-control" class="form-control" type="number"  min="10000" name="legajo" id="legajo" placeholder="Legajo" value="${profesional.getLegajo()}">
                            <div class="invalid-feedback">Legajo invalido.</div><div class="valid-feedback">Ok!</div>
                        </div>
                        <div class="form-group col-md-2">
                            <label for="nombre">Nombre</label>
                            <input required class="form-control" class="form-control" type="text"  name="nombre" id="nombre" placeholder="Nombre" value="${profesional.getNombre()}">
                            <div class="invalid-feedback">Nombre invalido.</div><div class="valid-feedback">Ok!</div>
                        </div>
                        <div class="form-group col-md-2">
                            <label for="apellido">Apellido</label>
                            <input required class="form-control" type="text"  name="apellido" id="apellido" placeholder="Apellido" value="${profesional.getApellido()}">
                            <div class="invalid-feedback">Apellido invalido.</div><div class="valid-feedback">Ok!</div>
                        </div>
                        <div class="form-group col-md-2">
                            <label for="fechaNac">Fecha de Nacimiento</label>
                            <input required class="form-control" type="text"  name="fechaNac" id="fechaNac" placeholder="dd/mm/aaaa" value="${profesional.getFechaNac()}">
                            <div class="invalid-feedback">Fecha invalido.</div><div class="valid-feedback">Ok!</div>
                        </div>
                        <div class="form-group col-md-2">
                            <label for="dni">Dni</label>
                            <input required class="form-control" type="number"  name="dni" id="dni" placeholder="DNI" value="${profesional.getDni()}">
                            <div class="invalid-feedback">DNI invalido.</div><div class="valid-feedback">Ok!</div>
                        </div>
                        <div class="form-group col-md-2">
                            <label for="direccion">Direccion</label>
                            <input required class="form-control" type="text"  name="direccion" id="direccion" placeholder="Dirección" value="${profesional.getDireccion()}">
                            <div class="invalid-feedback">Dirección invalida.</div><div class="valid-feedback">Ok!</div>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-2">
                            <label for="telefono">Telefono</label>
                            <input required class="form-control" type="number"  name="telefono" id="telefono" placeholder="Telefono" value="${profesional.getTelefono()}">
                            <div class="invalid-feedback">Telefono invalido.</div><div class="valid-feedback">Ok!</div>
                        </div>
                        <div class="form-group col-md-2">
                            <label for="matricula">Matricula</label>
                            <input required class="form-control" type="text"  name="matricula" id="matricula" placeholder="Matricula" value="${profesional.getMatricula()}">
                            <div class="invalid-feedback">Matricula invalido.</div><div class="valid-feedback">Ok!</div>
                        </div>
                        <div class="form-group col-md-6">
                            <div class="custom-file" style="margin-top: 29px;">
                                <input type="hidden" id="urlFoto" name="urlFoto" value="${profesional.getUrlFoto()}">
                                <input type="file" class="custom-file-input" id="url" name="urlFoto" id="url">
                                <label class="custom-file-label" for="url">Elegir imagen de perfil...</label>
                            </div>
                        </div>
                        <div class="form-group col-md-2" style="margin-top: 29px;">
                            <div class="form-check custom-control custom-radio">
                                <input type="hidden" name="idTipo">
                                <input class="form-check-input custom-control-input" type="radio" name="idTipoI" id="instructor" value="1">
                                <label class="form-check-label custom-control-label" for="instructor">
                                    Instructor
                                </label>
                            </div>
                            <div class="form-check custom-control custom-radio" style="margin-top: 5px;">
                                <input class="form-check-input custom-control-input" type="radio" name="idTipoP" id="profesional" value="2">
                                <label class="form-check-label custom-control-label" for="profesional">
                                    Profesional Médico
                                </label>
                            </div>
                        </div>
                    </div>
                    <button class="btn btn-success mt-3 col-md-3" type="submit">Modificar</button>
                </form>
            </div>
        </div>
        <jsp:include page="Footer.jsp"></jsp:include>
        <jsp:include page="scripts.jsp"></jsp:include>
        <script>
            $(document).ready(function () {
                <c:choose>
                    <c:when test="${profesional.getIdTipo() == 1}">
                        $("#profesional").prop("checked", false);
                        $( "#instructor" ).prop( "checked", true );
                        $('input[name="idTipo"]').val(1);
                        
                    </c:when>
                    <c:otherwise>
                        $("#profesional").prop("checked", true);
                        $( "#instructor" ).prop( "checked", false );
                        $('input[name="idTipo"]').val(2);
                    </c:otherwise>
                </c:choose>
                $("#instructor").click(function () { 
                    $("#instructor").prop("checked", true);
                    $("#profesional").prop("checked", false);
                    $('input[name="idTipo"]').val(1);
                });
                $("#profesional").click(function () { 
                    $("#profesional").prop("checked", true);
                    $( "#instructor" ).prop( "checked", false );
                    $('input[name="idTipo"]').val(2);
                });
            })
        </script>
    </body>
</html>
