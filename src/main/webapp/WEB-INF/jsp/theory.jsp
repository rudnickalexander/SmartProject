<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <link href="<c:url value="/static/styles/bootstrap-theme.min.css" />" rel="stylesheet">
    <link href="<c:url value="/static/styles/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/static/styles/style.css" />" rel="stylesheet">
    <script src="<c:url value="/static/scripts/libs/jquery-1.12.1.min.js" />"></script>
    <script src="<c:url value="/static/scripts/smartProject.js" />"></script>
    <title>Theory</title>
</head>
<body>
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
                    <a href="/theory" class="active btn bnt-default btn-lg">Теория</a>
                </p>
            </li>
            <li>
                <p class="navbar-btn">
                    <a href="/law" class="btn bnt-default btn-lg">Законодательство</a>
                </p>
            </li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li>
                <p class="navbar-btn">
                    <button id="logoutBtn" class="btn btn-danger btn-lg" type="button">Logout</button>
                </p>
            </li>
        </ul>
    </div>
</nav>
</body>
</html>
