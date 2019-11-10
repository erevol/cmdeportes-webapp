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
        <title>Profesionales</title>
        <jsp:include page="links.jsp"></jsp:include>
    </head>
    <body>
        <jsp:include page="Nav.jsp"></jsp:include>
        
            <c:choose>
                <c:when test="${isLogged}">
                <div class="container">
                <div class="row justify-content-between">
                    <div class="form-group col-md-5">
                        <h1 class="mb-5">Ingrese Profesional</h1>
                    </div>
                    <div class="form-group col-md-7">
                        <a class="btn btn-sm btn-outline-primary" href="HonorariosInstructores">Honorarios Instructores</a>
                        <a class="btn btn-sm btn-outline-primary" href="HonorariosProfesionalesMedicos">Honorarios Profesionales Médicos</a>
                    </div>
                </div>
                <div class="row">
                    <form action="profesionales" method="POST" enctype="multipart/form-data" class="needs-validation" novalidate>
                        <div class="form-row">
                            <div class="form-group col-md-2">
                                <label for="nombre">Legajo</label>
                                <input required class="form-control" class="form-control" type="number"  min="10000"  name="legajo" id="legajo" placeholder="Legajo" value="${legajo}">
                                <div class="invalid-feedback">Legajo invalido.</div><div class="valid-feedback">Ok!</div>
                            </div>
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
                                <label for="telefono">Telefono</label>
                                <input required class="form-control" type="number"  name="telefono" id="telefono" placeholder="Telefono" value="${telefono}">
                                <div class="invalid-feedback">Telefono invalido.</div><div class="valid-feedback">Ok!</div>
                            </div>
                            <div class="form-group col-md-2">
                                <label for="matricula">Matricula</label>
                                <input required class="form-control" type="text"  name="matricula" id="matricula" placeholder="Matricula" value="${matricula}">
                                <div class="invalid-feedback">Matricula invalido.</div><div class="valid-feedback">Ok!</div>
                            </div>
                            <div class="form-group col-md-6">
                                <div class="custom-file" style="margin-top: 29px;">
                                    <input type="hidden" id="urlFoto" name="urlFoto" value="${urlFoto}">
                                    <input type="file" class="custom-file-input" id="url" name="urlFoto" id="url">
                                    <label class="custom-file-label" for="url">Elegir imagen de perfil...</label>
                                </div>
                            </div>
                            <div class="form-group col-md-2" style="margin-top: 29px;">
                                <div class="form-check custom-control custom-radio">
                                    <input class="form-check-input custom-control-input" type="radio" name="idTipo" id="instructor" value="1" checked>
                                    <label class="form-check-label custom-control-label" for="instructor">
                                        Instructor
                                    </label>
                                </div>
                                <div class="form-check custom-control custom-radio" style="margin-top: 5px;">
                                    <input class="form-check-input custom-control-input" type="radio" name="idTipo" id="profesional" value="2">
                                    <label class="form-check-label custom-control-label" for="profesional">
                                        Profesional Médico
                                    </label>
                                </div>
                            </div>
                        </div>
                        <button class="btn btn-success mt-3 col-md-3" type="submit">Cargar</button>
                    </form>
                    <div class="row mt-5">
                        <div class="col-4">
                            <h1>Profesionales</h1>
                        </div>
                    </div>
                </div>
                </div>
                <div class="container-fluid mt-5" style="margin-bottom: 100px;">
                    <div class="table-responsive">
                        <table class="table table-hover table-sm">
                            <thead>
                                <tr style="color: white; background-color: black;">
                                    <th scope="col">Posicion</th>
                                    <th scope="col">Legajo</th>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Apellido</th>
                                    <th scope="col">Fecha Nac.</th>
                                    <th scope="col">DNI</th>
                                    <th scope="col">Direccion</th>
                                    <th scope="col">Telefono</th>
                                    <th scope="col">Matricula</th>
                                    <th scope="col">Foto</th>
                                    <th scope="col"></th>
                                    <th scope="col"></th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${profesionales}" var="p">
                                <tr>
                                    <th scope="row">${p.getPosicion()}</th>
                                    <th scope="row">${p.getLegajo()}</th>
                                    <th scope="row">${p.getNombre()}</th>
                                    <th scope="row">${p.getApellido()}</th>
                                    <td>${p.getFechaNac()}</td>
                                    <td>${p.getDni()}</td>
                                    <td>${p.getDireccion()}</td>
                                    <td>${p.getTelefono()}</td>
                                    <td>${p.getMatricula()}</td>
                                    <td>${p.getUrlFoto()}</td>
                                    <td><a class="btn btn-sm btn-outline-primary" href="ModificarProfesional?idProfesional=${p.getIdProfesional()}">Modificar</a></td>
                                    <td><a class="btn btn-sm btn-outline-danger" href="EliminarProfesional?idProfesional=${p.getIdProfesional()}">Eliminar</a></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                </c:when>
                <c:otherwise>
                <div class="container" style="margin-bottom: 100px;">
                    <div class="row mb-3 mt-5">
                        <div class="col-4">
                            <h1>Profesionales</h1>
                        </div>
                    </div>
                    <div class="row">
                    <c:forEach items="${profesionales}" var="p">
                        <div class="col-md-4">
                            <div class="card border-secondary mb-3" style="width: 18rem;">
                                <div class="card-header">${p.getNombre()} ${p.getApellido()}</div>
                                <img class="card-img-top" style="padding: 10px;"
                                    src="img/${p.getUrlFoto()}"
                                    alt="${p.getNombre()} ${p.getApellido()}">
                                <div class="card-body">
                                    <h5 class="card-title">${p.getPosicion()}</h5>
                                    <p class="card-text">Some quick example text to build on the card title</p>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    </div>
                </div>
                </c:otherwise>
            </c:choose>
        <jsp:include page="Footer.jsp"></jsp:include>
        <jsp:include page="scripts.jsp"></jsp:include>
    </body>
</html>
