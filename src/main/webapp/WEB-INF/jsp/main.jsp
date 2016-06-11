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
    <jsp:include page="header.jsp"/>
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
                <a href="http://news.tut.by/economics/500013.html">
                    Ставки вниз: Нацбанк снижает ставку рефинансирования еще на 2 пункта
                </a>
            </div>
            <div class="news">
                <a href="http://news.tut.by/economics/500050.html">
                    Экс-директора Могилевского вагонзавода обвиняют в получении взятки в 759 тысяч долларов
                </a>
            </div>
            <div class="news">
                <a href="http://finance.tut.by/news500023.html">
                    С начала года цены в Беларуси выросли на 7%
                </a>
            </div>
            <div class="news">
                <a href="http://news.tut.by/economics/499895.html">
                    Виновна, но свободна. Шарейко освобождена в зале суда
                </a>
            </div>
    </div>
</body>
</html>
