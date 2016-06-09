<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <link href="<c:url value="/static/styles/bootstrap-theme.min.css" />" rel="stylesheet">
    <link href="<c:url value="/static/styles/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/static/styles/style.css" />" rel="stylesheet">
    <script src="<c:url value="/static/scripts/libs/jquery-1.12.1.min.js" />"></script>
    <script src="<c:url value="/static/scripts/libs/bootstrap.min.js" />"></script>
    <script src="<c:url value="/static/scripts/smartProject.js" />"></script>
    <title>Registry</title>
</head>
<body>
<div class="container-fluid">
    <form id="registryForm" class="form-horizontal" action="registryNewUser" method="post">
        <div class="h4">Регистрация</div>
        <div class="form-group">
            <label for="emailInput" class="col-sm-4 control-label">Введите электронную почту</label>
            <div class="col-sm-4">
                <input id="emailInput" type="email" class="form-control" name="emailInput" value="" />
            </div>
            <div class="col-sm-4"></div>
        </div>
        <div class="form-group">
            <label for="passwordInput" class="col-sm-4 control-label">Введите пароль</label>
            <div class="col-sm-4">
                <input id="passwordInput" type="password" class="form-control" name="passwordInput" value="" />
            </div>
            <div class="col-sm-4"></div>
        </div>
        <div class="form-group">
            <label for="passwordRepeatInput" class="col-sm-4 control-label">Повторите пароль</label>
            <div class="col-sm-4">
                <input id="passwordRepeatInput" type="password" class="form-control" name="passwordRepeatInput" />
            </div>
            <div class="col-sm-4"></div>
        </div>
        <div class="form-group">
            <div class="col-sm-1 col-sm-offset-4">
                <input type="reset" class="btn btn-danger btn-lg" value="Отмена" />
            </div>
            <div class="col-sm-1 col-sm-offset-1">
                <input type="submit" value="Подтвердить" class="btn btn-success btn-lg"/>
            </div>
        </div>
    </form>
</div>

</body>
</html>
