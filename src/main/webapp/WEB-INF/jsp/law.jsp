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
    <div class="col-sm-offset-1" style="font-size: 16px">
        <div style="margin-top: 5px">
            <a href="../../static/docs/arenda_zemelnogo_uchastka.zip" download="">Аренда земельного участка</a>
        </div>
        <div style="margin-top: 5px">
            <a href="../../static/docs/buh_ychet_investiciu.zip" download="">Бухучет инвестиций</a>
        </div>
        <div style="margin-top: 5px">
            <a href="../../static/docs/Ввоз%20технологического%20оборудования%20и%20материалов.zip" download="">Ввоз технологического оборудования</a>
        </div>
        <div style="margin-top: 5px">
            <a href="../../static/docs/Государственная%20поддержка%20инвестиционных%20проектов.zip" download="">Государственная поддержка инвестиционных проектов</a>
        </div>
        <div style="margin-top: 5px">
            <a href="../../static/docs/Земельный%20налог.zip" download="">Земельный налог</a>
        </div>
        <div style="margin-top: 5px">
            <a href="../../static/docs/Инвестиции%20в%20ценные%20бумаги.zip" download="">Инвестиции в ценные бумаги</a>
        </div>
        <div style="margin-top: 5px">
            <a href="../../static/docs/Инвестиционные%20споры.zip" download="">Инвестиционные споры</a>
        </div>
    </div>
</div>
</body>
</html>
