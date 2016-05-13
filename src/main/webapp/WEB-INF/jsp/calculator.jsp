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
    <title>Calculator</title>
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
                        <a href="/main" class="btn bnt-default btn-lg">Главная</a>
                    </p>
                <li>
                    <p class="navbar-btn">
                        <a href="/calculator" class="active btn bnt-default btn-lg">Калькулятор проекта</a>
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
                        <a href="/document" class="btn bnt-default btn-lg">Документация</a>
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
    <div id="container">
        <form id="calculationForm" class="form-horizontal" role="form">
            <div class="form-group">
                <label for="projectName" class="col-sm-5 control-label">Название проекта</label>
                <div class="col-sm-2">
                    <input type="text" class="form-control" id="projectName">
                </div>
            </div>
            <div class="form-group">
                <label for="calculationHorizon" class="col-sm-5 control-label">Горизонт расчета, г</label>
                <div class="col-sm-2">
                    <input type="text" class="form-control" id="calculationHorizon" required pattern="^[0-9]+$">
                </div>
            </div>
            <div class="form-group">
                <label for="bettingShopDiscount" class="col-sm-5 control-label">Ставка дисконтирования, %</label>
                <div class="col-sm-2">
                    <input type="text" class="form-control" id="bettingShopDiscount" required pattern="\d+(\.\d{2})?">
                </div>
            </div>
            <div class="form-group">
                <label for="investedCapital" class="col-sm-5 control-label">Первоначальные затраты, руб.</label>
                <div class="col-sm-2">
                    <input type="text" class="form-control" id="investedCapital" required pattern="\d+(\.\d{2})?">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-4 col-sm-1">
                    <input id="calculateButton" class="btn btn-submit btn-lg" type="button" value="Рассчитать">
                </div>
                <div class="col-sm-1">
                    <input id="saveButton" class="btn btn-submit btn-lg" type="button" value="Сохранить">
                </div>
            </div>

            <table id="projectParams" class="table table-striped table-bordered table-condensed table-hover">
                <thead>
                    <tr>
                        <th>Период</th>
                        <th class="info">Денежный доход</th>
                        <th class="info">Денежный расход</th>
                        <th>Денежный поток</th>
                        <th>Денежный поток нарастающим итогом</th>
                        <th>Дисконтированный денежный поток</th>
                        <th>Дисконтированный денежный поток нарастающим итогом</th>
                    </tr>
                </thead>
                <tbody>
                </tbody>
            </table>

            <div class="col-sm-4">
                <table id="projectTable" class="table table-hover">
                    <tbody>
                        <tr>
                            <td class="warning">ЧДД, руб.</td>
                            <td class="success"></td>
                        </tr>
                        <tr>
                            <td class="warning">Внутренняя норма прибыли, %</td>
                            <td class="success"></td>
                        </tr>
                        <tr>
                            <td class="warning">Индекс прибыльности, %</td>
                            <td class="success"></td>
                        </tr>
                        <tr>
                            <td class="warning">Простой срок окупаемости, лет</td>
                            <td class="success"></td>
                        </tr>
                        <tr>
                            <td class="warning">Динамический срок окуппаемости, лет</td>
                            <td class="success"></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </form>
    </div>
</body>
</html>
