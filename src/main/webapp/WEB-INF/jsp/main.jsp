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
    <title>Main</title>
</head>
<body>
    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <%--<div class="navbar-header">--%>
                <%--<a class="navbar-brand" href="/">--%>
                    <%--<img alt="Brand" src="<c:url value="/resources/static/img/Issoft-solutions-logo-big22.png"/>" width="147" height="50">--%>
                <%--</a>--%>
            <%--</div>--%>
            <ul class="nav navbar-nav">
                <li>
                    <p class="navbar-btn">
                        <a href="/main" class="active btn bnt-default btn-lg">Главная</a>
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
                <li>
                    <p class="navbar-btn">
                        <button id="logoutBtn" class="btn btn-danger btn-lg" type="button">Logout</button>
                    </p>
                </li>
            </ul>
        </div>
    </nav>
    <div class="container-fluid col-sm-8">
        <div class="row">
            <div class="col-sm-12">
                <div class="col-sm-4">
                    <div class="h4">Конвертер валют</div>
                    <div id="currencyConverter" class="container"></div>
                        <div class="finatica_widget_converter default" view_style="minimal" currencies="usd,eur,rub" position="vertical"></div>
                        <span  class="finatica_link"> <a target="blank" href="http://finatica.by">курсы валют в Беларуси</a></span>
                        <script src="http://widgets.finatica.by/content/widgets/converter/v1.0/js/loader.js" type="text/javascript" async></script>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-6">
                <div class="h4">Курсы валют НБРБ</div>
                <table id="currencyExchange" class="table table-bordered table-hover table-condensed">
                    <thead>
                        <tr>
                            <th>Валюта</th>
                            <th>Значение, руб.</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="item" items="${requestScope.currencyExchange}">
                            <tr>
                                <td>${item.charCode}</td>
                                <td>${item.rate}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col-sm-6">
                <div class="h4">Курсы металлов НБРБ</div>
                <table id="ignotsPrices" class="table table-bordered table-hover table-condensed">
                    <thead>
                        <tr>
                            <th>Наименование</th>
                            <th>Номинал, г</th>
                            <th>Цена, руб.</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="item" items="${requestScope.ingotsPrices}">
                        <tr>
                            <td>${item.metalType.name}</td>
                            <td>${item.nominal}</td>
                            <td>${item.certificateRubles}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="container-fluid col-sm-4">
        <div class="h4">Новости</div>
            <div class="news">
                <a href="http://finatica.by/news/33261-kitayskie-kompanii-postroyat-16-social/">
                    Китайские компании построят 16 социальных домов в Беларуси
                </a>
            </div>
            <div class="news">
                <a href="http://finatica.by/news/33256-11-maya-v-belarusi-nachnutsya-repeticii-par/">
                    11 мая в Беларуси начнутся репетиции парада к 3 июля
                </a>
            </div>
            <div class="news">
                <a href="http://finatica.by/news/33251-opros-deyatelnost-putina-sootvetst/">
                    Опрос: Деятельность Путина соответствует ожиданиям большинства россиян
                </a>
            </div>
            <div class="news">
                <a href="http://finatica.by/news/33168-v-minske-povysheny-stavki-naloga-na-sda/">
                    В Минске повышены ставки налога на сдачу в аренду жилья и гаражей
                </a>
            </div>
            <div class="news">
                <a href="http://finatica.by/news/33165-v-blizhayshee-vremya-mintorgu-smenyat-naz/">
                    В ближайшее время Минторгу сменят название и наделят новыми функциями
                </a>
            </div>
    </div>
</body>
</html>
