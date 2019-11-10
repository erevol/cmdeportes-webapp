<%-- 
    Document   : Login
    Created on : Oct 28, 2019, 11:57:51 PM
    Author     : Eugenia Revol <euge.revol@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio de Sesión</title>
        <jsp:include page="links.jsp"></jsp:include>
    </head>
    <body>
        <jsp:include page="Nav.jsp"></jsp:include>
        <div class="container">
            <h1>Inicio de Sesión</h1>
            <form action="login" method="POST" class="col-4 needs-validation" novalidate>
                <div class="form-group">
                    <label for="txtUsuario">Usuario</label>
                    <input type="text" required class="form-control" id="txtUsuario" placeholder="Usuario" name="txtUsuario">
                    <div class="invalid-feedback">Usuario requerido.</div><div class="valid-feedback">Ok!</div>
                </div>
                <div class="form-group">
                    <label for="txtPass" id="txtPass">Contraseña</label>
                    <input type="password" required class="form-control" id="txtPass" placeholder="Contraseña" name="txtPass">
                    <div class="invalid-feedback">Contraseña requerida.</div><div class="valid-feedback">Ok!</div>
                </div>
                <button type="submit" class="btn btn-primary">Ingresar</button>
            </form>
        </div>
        <jsp:include page="Footer.jsp"></jsp:include>
        <jsp:include page="scripts.jsp"></jsp:include>
    </body>
</html>
