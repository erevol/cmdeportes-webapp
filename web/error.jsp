<%-- 
    Document   : error
    Created on : Nov 7, 2019, 5:11:01 PM
    Author     : Eugenia Revol <euge.revol@gmail.com>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
        <jsp:include page="links.jsp"></jsp:include>
        </head>
        <body>
        <jsp:include page="Nav.jsp"></jsp:include>
        <div class="container" style="margin-top: 50px; margin-bottom: 100px;">
            <div class="row">
                <div class="col-md-1">
                    <div class="mb-3">
                        <img class="img-fluid" src="img/error.png" alt="error">
                    </div>
                </div>
                <div class="col-md-6" style="padding-top: 10px;">
                    <div class="alert alert-dismissible alert-danger">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        <strong>Oh rayos!</strong> A ocurrido un error...<a href="index" class="alert-link">Volver al inicio.</a>
                    </div>
                </div>
            </div>
        </div>
    <jsp:include page="Footer.jsp"></jsp:include>
    <jsp:include page="scripts.jsp"></jsp:include>
</body>
</html>
