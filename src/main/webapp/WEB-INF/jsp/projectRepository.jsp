<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=cp1251" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="<c:url value="/static/styles/bootstrap-theme.min.css" />" rel="stylesheet">
    <link href="<c:url value="/static/styles/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/static/styles/style.css" />" rel="stylesheet">
    <script src="<c:url value="/static/scripts/libs/jquery-1.12.1.min.js" />"></script>
    <script src="<c:url value="/static/scripts/libs/bootstrap.min.js" />"></script>
    <script src="<c:url value="/static/scripts/smartProject.js" />"></script>
    <title>Repository</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container-fluid">
    <div class="col-sm-3">
        <div id="param">
            <div class="h3">Параметры поиска</div>
            <div class="search-param">
                <div class="h4">Простой период окупаемости</div>
                <label for="sPPInputFrom" class="line">От</label>
                <input id="sPPInputFrom" class="line request-param" type="text"/>
                <label for="sPPInputTo" class="line">До</label>
                <input id="sPPInputTo" type="text" class="line request-param"/>
                <label style="font-size: 14px">мес</label>
            </div>
            <div class="search-param">
                <div class="h4">Динамический период окупаемости</div>
                <label for="dPPInputFrom">От</label>
                <input id="dPPInputFrom" class="line request-param" type="text"/>
                <label for="dPPInputTo">До</label>
                <input id="dPPInputTo" class="line request-param" type="text" />
                <label style="font-size: 14px">мес</label>
            </div>
            <div class="search-param">
                <div class="h4">Чистый дисконтированный доход</div>
                <label for="pIInputFrom">От</label>
                <input id="pIInputFrom" class="line request-param" type="text"/>
                <label for="pIInputTo">До</label>
                <input id="pIInputTo" class="line request-param" type="text" />
                <label style="font-size: 14px">руб</label>
            </div>
            <input id="searchButton" type="button" class="btn btn-success col-sm-offset-5" value="Поиск"/>
        </div>
    </div>
    <div class="col-sm-9">
        <div id="projectList">
            <c:forEach items="${requestScope.projects}" var="project">
                <div class="one-project">
                    <div class="col-sm-1">
                        <input type="checkbox" class="ch" style="margin-top: 35px">
                    </div>
                    <div class="col-sm-11">
                        <div class="projectLine" projectId="${project.id}" style="margin-left: -40px">
                            <div class="h5">${project.name}</div>
                            <div class="text-right">${project.user.firstName}</div>
                            <div>${project.description}</div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

    <div class="comparator" style="display: inline-block"></div>

    <jsp:include page="modalProjectPage.jsp"/>
    <jsp:include page="compareProjectsPage.jsp"/>

</div>
</body>
</html>
