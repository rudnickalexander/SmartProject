var selectedProjectCount = 0;

$(document).ready(function () {

    $('#calculationHorizon').keyup(function () {
        var $projectParams = $('#projectParams');
        $projectParams.find('tbody').html('');

        var rows = Number($('#calculationHorizon').val());
        
        if (rows !== 0) {
            for (var i = 0; i <= rows; i++) {
                $projectParams.find('tbody').append(getTableRow(i));
            }
        }
    });

    $('#calculateButton').click(function () {
        var firstColumn = undefined;
        var secondColumn = undefined;
        var thirdColumn = undefined;
        var params = [];

        $('#projectParams').find('tbody tr').each(function(){
            firstColumn = $(this).find('td:eq(0)');
            secondColumn = $(this).find('td:eq(1)');
            thirdColumn = $(this).find('td:eq(2)');

            params[params.length] = {
                index: firstColumn.text(),
                input: secondColumn.text(),
                output: thirdColumn.text()
            };
        });

        $.ajax({
            type: 'GET',
            url: 'calculateProject.json',
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            cache: false,
            async: false,
            data: {
                params: JSON.stringify(params),
                calculationHorizon: Number($('#calculationHorizon').val()),
                bettingShopDiscount: Number($('#bettingShopDiscount').val()),
                investedCapital: $('#investedCapital').val()

            },
            beforeSend: function (xhr) {
                if ($('#calculationForm')[0].checkValidity() === false) {
                    alert('Check the right data in inputs');
                    xhr.abort();
                }
            },
            success: function (data) {
                var attribute = data.attribute;
                var index = 0;

                var fourthColumn = undefined;
                var fifthColumn = undefined;
                var sixthColumn = undefined;
                var seventhColumn = undefined;

                $('#projectParams').find('tbody tr').each(function(){
                    fourthColumn = $(this).find('td:eq(3)');
                    fifthColumn = $(this).find('td:eq(4)');
                    sixthColumn = $(this).find('td:eq(5)');
                    seventhColumn = $(this).find('td:eq(6)');

                    fourthColumn.text(attribute[index].cashFlow);
                    fifthColumn.text(attribute[index].netPresentValue);
                    sixthColumn.text(attribute[index].discountedCashFlow);
                    seventhColumn.text(attribute[index].discountedCashFlowAccrualBasis);

                    index++;
                });

                var project = data.project;

                var $projectTable = $('#projectTable');

                $projectTable.find('tbody tr:eq(0)').find('td:eq(1)').text(project.netPresentValue);
                $projectTable.find('tbody tr:eq(1)').find('td:eq(1)').text(project.internalRateOfReturn);
                $projectTable.find('tbody tr:eq(2)').find('td:eq(1)').text(project.profitabilityIndex);
                $projectTable.find('tbody tr:eq(3)').find('td:eq(1)').text(project.simplePaybackPeriod);
                $projectTable.find('tbody tr:eq(4)').find('td:eq(1)').text(project.dynamicPaybackPeriod);
            },
            error: function (data) {
                data.preventDefault();
            }
        });
    });

    $('.projectLine').click(function () {
        var projectId = $(this).attr('projectId');

        $.ajax({
            type: 'GET',
            url: 'project/' + projectId + '.json',
            dataType: 'json',
            cache: false,
            async: false,
            success: function (data) {
                $('#projectModalPage').modal('show');
                $('#myModalLabel').html(data.name);
                $('#modalDescription').html(data.description);
                $('#modalContact').html(data.user.firstName);
                $('#modalContact').append(', ' + data.user.phoneNumber);
                $('#calcHorizonModal').html(data.calculationHorizon);
                $('#simplePaybackPeriodModal').html(data.simplePaybackPeriod);
                $('#dynPaybackPeriodModal').html(data.dynamicPaybackPeriod);
                $('#internalRateOfReturnModal').html(data.internalRateOfReturn);
                $('#profitabilityIndexModal').html(data.profitabilityIndex);
            },
            error: function (data) {
                data.preventDefault();
            }
        });
    });

    $('#searchButton').click(function () {
        var paramArray = [];
        $('.request-param').each(function (item, value) {
            paramArray[item] = $(value).val();
        });

        $.ajax({
            type: 'GET',
            url: 'searching.json',
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            cache: false,
            async: false,
            data: {
                params: JSON.stringify(paramArray)
            },
            success: function (data) {
                console.log(data);
                data.each(function (item, value) {
                    
                })
            },
            error: function (data) {
                data.preventDefault();
            }
        });
    });
    
    $('#signInButton').click(function () {
        location = '/login'
    });

    $('.ch').click(function () {
        selectedProjectCount++;

        if (selectedProjectCount === 2) {
            selectedProjectCount = 0;
            $('#projectList').find(':checked').each(function (index, item) {
                $(item).prop('checked', false);
                var projectId = $(item).parent('.col-sm-1').parent('.one-project').find('.col-sm-11').find('.projectLine').attr('projectId');

                $.ajax({
                    type: 'GET',
                    url: 'project/' + projectId + '.json',
                    dataType: 'json',
                    cache: false,
                    async: false,
                    success: function (data) {
                        var i = index + 1;
                        $('#myModalLabel' + i).html(data.name);
                        $('#modalDescription' + i).html(data.description);
                        $('#modalContact' + i).html(data.user.firstName);
                        $('#modalContact' + i).append(', ' + data.user.phoneNumber);
                        $('#calcHorizonModal' + i).html(data.calculationHorizon);
                        $('#simplePaybackPeriodModal' + i).html(data.simplePaybackPeriod);
                        $('#dynPaybackPeriodModal' + i).html(data.dynamicPaybackPeriod);
                        $('#internalRateOfReturnModal' + i).html(data.internalRateOfReturn);
                        $('#profitabilityIndexModal' + i).html(data.profitabilityIndex);
                    },
                    error: function (data) {
                        data.preventDefault();
                    }
                });


            });

            $('#compareProjects').modal('show');
        }
    });

    $('#signUpButton').click(function () {
        location = '/registry';
    })

});

function getTableRow(index) {
    return '<tr><td>' + index + '</td>' + '<td contenteditable=\'true\'></td>' + '<td contenteditable=\'true\'></td>'
        + '<td contenteditable=\'true\'></td>' + '<td contenteditable=\'true\'></td>' + '<td contenteditable=\'true\'></td>'
        + '<td contenteditable=\'true\'></td>' + '<td contenteditable=\'true\'></td>' + '<td contenteditable=\'true\'></td>'
        + '<td contenteditable=\'true\'></td>';
}