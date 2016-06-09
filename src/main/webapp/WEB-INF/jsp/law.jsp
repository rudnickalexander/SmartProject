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
    <title>Laws</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container-fluid">
    <div class="col-sm-offset-2">
        <div style="margin-top: 5px">
            <button class="btn">Аренда земельного участка</button>
        </div>
        <div style="margin-top: 5px">
            <button class="btn">Государственная поддержка инвест проектов</button>
        </div>
        <div style="margin-top: 5px">
            <button class="btn">Инвестиции в ценные бумаги</button>
        </div>
        <div style="margin-top: 5px">
            <button class="btn">Инвестиционные споры</button>
        </div>
        <div style="margin-top: 5px">
            <button class="btn">Инвестиционный агенет</button>
        </div>
        <div style="margin-top: 5px">
            <button class="btn">Инвестиционный бизнес-план</button>
        </div>
        <div style="margin-top: 5px">
            <button class="btn">Инвестиционный договор</button>
        </div>
        <div style="margin-top: 5px">
            <button class="btn">Инвестор</button>
        </div>
        <div style="margin-top: 5px">
            <button class="btn">Налог на прибыль</button>
        </div>

    </div>
</div>
</body>
</html>
