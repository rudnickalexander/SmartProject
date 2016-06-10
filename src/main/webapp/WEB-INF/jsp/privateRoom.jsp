<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Private room</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container-fluid">
    <form id="registryForm" class="form-horizontal" action="privateRoom" method="post">
        <div class="h4">Личный кабинет</div>
        <div class="form-group">
            <label for="emailInput" class="col-sm-4 control-label">Email</label>
            <div class="col-sm-4">
                <input id="emailInput" type="email" class="form-control" name="emailInput" value="${userDetails.email}" readonly />
            </div>
            <div class="col-sm-4"></div>
        </div>
        <div class="form-group">
            <label for="surnameUnput" class="col-sm-4 control-label">Фамилия</label>
            <div class="col-sm-4">
                <input id="surnameUnput" type="text" class="form-control" name="surnameInput" value="${userDetails.surname}" />
            </div>
            <div class="col-sm-4"></div>
        </div>
        <div class="form-group">
            <label for="firstNameInput" class="col-sm-4 control-label">Имя</label>
            <div class="col-sm-4">
                <input id="firstNameInput" type="text" class="form-control" name="firstNameInput" value="${userDetails.firstName}" />
            </div>
            <div class="col-sm-4"></div>
        </div>
        <div class="form-group">
            <label for="phoneInput" class="col-sm-4 control-label">Телефон</label>
            <div class="col-sm-4">
                <input id="phoneInput" type="text" class="form-control" name="phoneInput" value="${userDetails.phoneNumber}"/>
            </div>
            <div class="col-sm-4"></div>
        </div>
        <%--<div class="form-group">--%>
            <%--<label for="cityInput" class="col-sm-4 control-label">Email</label>--%>
            <%--<div class="col-sm-4">--%>
                <%--<input id="cityInput" type="text" class="form-control" name="passwordRepeatInput" />--%>
            <%--</div>--%>
            <%--<div class="col-sm-4"></div>--%>
        <%--</div>--%>


        <div class="form-group">
            <%--<div class="col-sm-1 col-sm-offset-4">--%>
                <%--<input type="reset" class="btn btn-danger btn-lg" value="Изменить пароль" />--%>
            <%--</div>--%>
            <div class="col-sm-1 col-sm-offset-4">
                <input type="submit" value="Изменить данные" class="btn btn-success btn-lg"/>
            </div>
        </div>
    </form>
</div>

</body>
</html>
