<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<div class="modal fade" id="projectModalPage" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Закрыть">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="myModalLabel"></h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-sm-12 search-param" id="modalDescription"></div>
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-sm-6 container-fluid search-param">
                                <div class="search-param" style="padding-left: 30px;">
                                    <div class="row">
                                        <label>Горизон расчета</label>
                                        <div id="calcHorizonModal" class="modal-row text-right"></div>
                                    </div>
                                    <div class="row">
                                        <label>Простой срок окупаемости, мес</label>
                                        <div id="simplePaybackPeriodModal" class="modal-row text-right"></div>
                                    </div>
                                    <div class="row">
                                        <label>Динамический срок окупаемости, мес</label>
                                        <div id="dynPaybackPeriodModal" class="modal-row text-right"></div>
                                    </div>
                                    <div class="row">
                                        <label>Индекс прибыльности</label>
                                        <div id="profitabilityIndexModal" class="modal-row text-right"></div>
                                    </div>
                                    <div class="row">
                                        <label>Внутренняя норма прибыли, %</label>
                                        <div id="internalRateOfReturnModal" class="modal-row text-right"></div>
                                    </div>
                                </div>
                            </div>
                            <div class="container-fluid col-sm-6 search-param" id="modalContact"></div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
            </div>
        </div>
    </div>
</div>
