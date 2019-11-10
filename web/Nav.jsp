<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary mb-5 sticky-top">
    <a class="navbar-brand" href="#">CM Deportes</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarColor01">
        <c:choose>
            <c:when test="${!isLogged}">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="profesionales">Nuestros Profesionales</a>
                    </li>
                </ul>
                <span class="navbar-text">
                    <a href="login" class="btn btn-outline-danger">Iniciar Sesión</a>
                </span>
            </c:when>
             <c:otherwise>
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="pacientes">Pacientes</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="profesionales">Profesionales</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="disciplinas">Disciplinas</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="ordenes">Ordenes e Inscripciones</a>
                    </li>
                </ul>
                <form action="logout" method="post">
                    <button type="submit" class="btn btn-outline-danger" style="color: white;">Cerrar Sesión</button>
                </form>
            </c:otherwise>
        </c:choose>
    </div>
</nav>
