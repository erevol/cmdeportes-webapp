<%-- 
    Document   : ModificarDisciplina
    Created on : Nov 6, 2019, 1:50:20 AM
    Author     : Eugenia Revol <euge.revol@gmail.com>
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
                <div class="col-4">
                    <form action="ModificarDisciplina" method="post" class="needs-validation" novalidate>
                        <div class="form-group">
                            <label class="col-form-label col-form-label-lg" for="nombre">Nombre</label>
                            <input type="hidden" name="idDisciplina" value="${disciplina.getIdDisciplina()}">
                            <input required class="form-control form-control-lg" type="text" placeholder="Modificar disciplina..." name="nombre" id="nombre" value="${disciplina.getNombre()}">
                            <div class="invalid-feedback">
                                Nombre invalido.
                            </div>
                            <div class="valid-feedback">
                                Ok!
                            </div>
                        </div>
                        <button type="submit" class="btn btn-success">Modificar</button>
                    </form>
                </div>
            </div>
        </div>
        <jsp:include page="Footer.jsp"></jsp:include>
        <jsp:include page="scripts.jsp"></jsp:include>
    </body>
</html>
