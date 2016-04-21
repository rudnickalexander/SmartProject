<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <link href="<c:url value="/static/styles/bootstrap-theme.min.css" />" rel="stylesheet">
    <link href="<c:url value="/static/styles/bootstrap.min.css" />" rel="stylesheet">
    <script src="<c:url value="/static/scripts/libs/jquery-1.12.1.min.js" />"></script>
    <script src="<c:url value="/static/scripts/smartProject.js" />"></script>
    <title>Calculator</title>
</head>
<body>
    <%--<div class="form-group">--%>
        <%--<label for="projectName">Название проекта</label>--%>
        <%--<input type="text" class="form-control" id="projectName" required>--%>
    <%--</div>--%>
    <div class="form-group">
        <label for="calculationHorizon">Горизонт расчета</label>
        <input type="text" class="form-control" id="calculationHorizon" required>
    </div>
    <div class="form-group">
        <label for="bettingShopDiscont">Ставка дисконтирования</label>
        <input type="text" class="form-control" id="bettingShopDiscont" required>
    </div>
    <div class="form-group">
        <label for="investedCapital">Первоначальные затраты</label>
        <input type="text" class="form-control" id="investedCapital" required>
    </div>
    <table id="projectParams" class="table table-striped table-bordered table-condensed table-hover">
        <thead>
            <tr>
                <th>Период</th>
                <th>Денежный доход</th>
                <th>Денежный расход</th>
                <th>Денежный поток</th>
                <th>Денежный поток нарастающим итогом</th>
                <th>Дисконтированный денежный поток</th>
                <th>Дисконтированный денежный поток нарастающим итогом</th>
            </tr>
        </thead>
        <tbody>

        </tbody>
    </table>
    <button id="calculateButton" class="btn btn-default btn-lg">Рассчитать</button>
</body>
</html>
