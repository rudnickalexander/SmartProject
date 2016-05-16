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
    <title>Repository</title>
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <ul class="nav navbar-nav">
            <li>
                <p class="navbar-btn">
                    <a href="/main" class="btn bnt-default btn-lg">Главная</a>
                </p>
            <li>
                <p class="navbar-btn">
                    <a href="/calculator" class="btn bnt-default btn-lg">Оценка проекта</a>
                </p>
            </li>
            <li>
                <p class="navbar-btn">
                    <a href="/repository" class="active btn bnt-default btn-lg">База проектов</a>
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
<div class="container-fluid">
    <div class="col-sm-3">
        <div id="param">
            <div class="h3">Параметры поиска</div>
            <div class="search-param">
                <div class="h4">Простой период окупаемости</div>
                <label for="sPPInputFrom" class="line">От</label>
                <input id="sPPInputFrom" class="line" type="text"/>
                <label for="sPPInputTo" class="line">До</label>
                <input id="sPPInputTo" type="text" class="line"/>
            </div>
            <div class="search-param">
                <div class="h4">Динамический период окупаемости</div>
                <label for="dPPInputFrom">От</label>
                <input id="dPPInputFrom" type="text"/>
                <label for="dPPInputTo">До</label>
                <input id="dPPInputTo" type="text" />
            </div>
            <div class="search-param">
                <div class="h4">Индекс окупаемости</div>
                <label for="pIInputFrom">От</label>
                <input id="pIInputFrom" type="text"/>
                <label for="pIInputTo">До</label>
                <input id="pIInputTo" type="text" />
            </div>
            <input id="searchButton" type="button" class="btn btn-success col-sm-offset-5" value="Поиск"/>
        </div>
    </div>
    <div class="col-sm-9">
        <div id="projectList">
            <div class="projectLine">
                <div class="h5">Perekladina.by</div>
                <div class="text-right">Владислав</div>
                <div>ЛОТ: кап. строение (здание корпуса 22 (бытовая часть)) инв. № 240/С-40051, общ. площ. 6012,0 м.кв., по адресу: Витебская область</div>
            </div>

            <div class="projectLine">
                <div class="h5">Имущество ОАО "Технолит Полоцк"</div>
                <div class="text-right">Владимир</div>
                <div>Лот 1: кап. строение (блок вспомогательных помещений), инв. № 255/С-11526, площ. 291.0 м.кв., по адресу: Витебская обл., Браслав, ул. Промышленная, д. 13, </div>
            </div>
            <div class="projectLine">
                <div class="h5">Имущество ОАО "Завод "Легмаш"</div>
                <div class="text-right">Вероника</div>
                <div>ЛОТ: кап. строение (здание корпуса 22 (бытовая часть)) инв. № 240/С-40051, общ. площ. 6012,0 м.кв., по адресу: Витебская область, г. Орша</div>
            </div>
            <div class="projectLine">
                <div class="h5">Имущество ОАО "Завод "Эвистор"</div>
                <div class="text-right">Юрий</div>
                <div>капитальное строение (здание автоматизированной компрессорной) инв. № 200/С-73289, пл. 1295,4 кв.м., по адресу: Витебск, пр-т Фрунзе, 81/25; капитальное </div>
            </div>
            <div class="projectLine">
                <div class="h5">Имущество ООО "Гобром"</div>
                <div class="text-right">Владислав</div>
                <div>Лот 3: сооружение (СПГ № 2), площ. 4214,0 м.кв., по адресу: Витебская обл., Орша, ул. Ленина, 160Б/10, начальная цена продажи* 2975580000 руб. Характеристик</div>
            </div>
            <div class="projectLine">
                <div class="h5">Имущество ЗАО "Вечелье"</div>
                <div class="text-right">Александр</div>
                <div>Лот: незавершенные законсервированные кап. строения: инв. № 234/U-8048, площ. 797,3 кв.м; инв. № 234/U-8047, площ. 846,9 кв.м; инв. № 234/U-8046, площ. 46,3 кв.м; инв</div>
            </div>
            <%--<div class="projectLine">--%>
                <%--<div class="h5">Имя1</div>--%>
                <%--<div class="text-right">Михаил</div>--%>
                <%--<div>Описание</div>--%>
            <%--</div>--%>
        </div>
    </div>
    <div class="modal fade" id="projectModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Закрыть">
                        <span aria-hidden="true">×</span>
                    </button>
                    <h4 class="modal-title" id="myModalLabel">Имущество ЗАО "Вечелье"</h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-sm-12 search-param">
                            Лот: незавершенные законсервированные кап. строения: инв. № 234/U-8048, площ. 797,3 кв.м; инв. № 234/U-8047, площ. 846,9 кв.м; инв. № 234/U-8046, площ. 46,3 кв.м; инв. № 234/U-8045, площ. 134,9 кв.м; инв. № 234/U-8044, площ. 446,8 кв.м; инв. № 234/U-8043, площ. 659,2 кв.м; инв. № 234/U-8042, площ. 742,2 кв.м; инв. № 234/U-8041, площ. 483,1 кв.м; инв. № 234/U-8049, площ. 1795,0 кв.м; инв. № 234/U-8050, площ. 75,9 кв.м. (Здания гаражей и мастерских, котельной, трансформаторной подстанции, коттеджей А, Б, В, Г, 24-х квартирного жилого дома, канализационной насосной станции, неустановленного назначения, разрушенное здание блока обслуживания (лечебный блок)). Начальная цена лота 1 021 680 000 рублей без учета НДС. Объекты недвижимости расположены по адресу: Витебская область, Ушачский район, Жарский с/с, №№ 10/1, 10/2, 10/3, 10/4, 10/6, 10/9, 10/10, 10/11, 10/12, 10/13. Для обслуживания вышеуказанных объектов недвижимости выделен зем. участок кад. № 224955100001001133 площ. 41,5 га. Официальное извещение опубликовано в газете «Республика» 21.03.2014 № 52.
                            1.
                        </div>
                        <div class="container-fluid">
                            <div class="row">
                                <div class="col-sm-6 container-fluid search-param">
                                    <div class="search-param">
                                        <p>Срок окупаемости капиталовложений- 5 лет</p>
                                        <p>Срок окупаемости капиталовложений с учетом нормы дохода (DPB) - 7 лет</p>
                                        <p>Внутренняя норма дохода (IRR)	10%</p>
                                        <p>Чистая нынешняя стоимость (NPV) - 1037 млн. BYR</p>
                                    </div>
                                    <%--<div class="col-sm-12 search-param">--%>
                                        <%--bla bla--%>
                                    <%--</div>--%>
                                </div>
                                <div class="container-fluid col-sm-6 search-param">
                                    Александр, моб телефон 80333100172
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
                    <%--<button type="button" class="btn btn-primary">Сохранить изменения</button>--%>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
