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
    <jsp:include page="header.jsp"/>
    <div id="container">
        <form id="calculationForm" class="form-horizontal" role="form">
            <div class="form-group">
                <label for="projectName" class="col-sm-5 control-label">Название проекта</label>
                <div class="col-sm-2">
                    <input type="text" class="form-control" id="projectName" required>
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
                <label for="investedCapitalMonth" class="col-sm-5 control-label">Месяц первых инвестиционных вложений</label>
                <div class="col-sm-2">
                    <input type="text" class="form-control" id="investedCapitalMonth" required>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-4 col-sm-1">
                    <input id="calculateButton" class="btn btn-submit btn-lg" type="button" value="Рассчитать">
                </div>
                <c:if test="${sessionScope.user != null}">
                    <div class="col-sm-offset-1 col-sm-1">
                        <input id="saveButton" class="btn btn-submit btn-lg" type="button" value="Сохранить">
                    </div>
                </c:if>
            </div>

            <table id="projectParams" class="table table-striped table-bordered table-condensed table-hover">
                <thead>
                    <tr>
                        <th>Период</th>
                        <th class="info">Денежный доход</th>
                        <th class="info">Денежный расход</th>
                        <th>Денежный поток</th>
                        <th>Денежный поток нарастающим итогом</th>
                        <th>Приведение будующей стоимости денег к их текущей стоимости</th>
                        <th>Дисконтированный денежный доход</th>
                        <th>Дисконтированный денежный расход</th>
                        <th>Дисконтированный денежный поток</th>
                        <th>Дисконтированный денежный поток нарастающим методом</th>
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
                            <td class="success" contenteditable="true"></td>
                        </tr>
                        <tr>
                            <td class="warning">Внутренняя норма прибыли, %</td>
                            <td class="success" contenteditable="true"></td>
                        </tr>
                        <tr>
                            <td class="warning">Индекс прибыльности</td>
                            <td class="success" contenteditable="true"></td>
                        </tr>
                        <tr>
                            <td class="warning">Простой срок окупаемости, мес</td>
                            <td class="success" contenteditable="true"></td>
                        </tr>
                        <tr>
                            <td class="warning">Динамический срок окуппаемости, мес</td>
                            <td class="success" contenteditable="true"></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </form>
    </div>
</body>
</html>
