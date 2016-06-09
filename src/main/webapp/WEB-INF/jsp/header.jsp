<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <ul class="nav navbar-nav">
            <li>
                <p class="navbar-btn">
                    <a href="/main" class="btn bnt-default btn-lg">Главная</a>
                </p>
            <li>
                <p class="navbar-btn">
                    <a href="/calculator" class="btn bnt-default btn-lg">Оценка проекта</a>
                </p>
            </li>
            <li>
                <p class="navbar-btn">
                    <a href="/repository" class="btn bnt-default btn-lg">База проектов</a>
                </p>
            </li>
            <li>
                <p class="navbar-btn">
                    <a href="/theory" class="btn bnt-default btn-lg">Теория</a>
                </p>
            </li>
            <li>
                <p class="navbar-btn">
                    <a href="/law" class="btn bnt-default btn-lg">Законодательство</a>
                </p>
            </li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <c:choose>
                <c:when test="${not empty sessionScope.user}">
                    <li>
                        <p class="navbar-btn">
                            <button id="logoutBtn" class="btn btn-danger btn-lg" type="button">Выйти</button>
                        </p>
                    </li>
                </c:when>
                <c:otherwise>
                    <li>
                        <p class="navbar-btn">
                            <button id="signInButton" class="btn btn-default btn-lg" type="button">Войти</button>
                        </p>
                    </li>
                    <li>
                        <p class="navbar-btn">
                            <button id="signUpButton" class="btn btn-success btn-lg" type="button">Регистрация</button>
                        </p>
                    </li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</nav>