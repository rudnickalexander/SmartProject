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
                console.log(data);
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
                //$('#projectTable').find('tbody tr').each(function() {
                //    console.log(this);
                //    $(this).find('td:eq(1)').text(project.netPresentValue);
                //    $(this).find('td:eq(1)').text(project.internalRateOfReturn);
                //    $(this).find('td:eq(1)').text(project.profitabilityIndex);
                //    $(this).find('td:eq(1)').text(project.simplePaybackPeriod);
                //    $(this).find('td:eq(1)').text(project.dynamicPaybackPeriod);
                //});

                $('#projectTable').find('tbody tr:eq(0)').find('td:eq(1)').text(project.netPresentValue);
                $('#projectTable').find('tbody tr:eq(1)').find('td:eq(1)').text(project.internalRateOfReturn);
                $('#projectTable').find('tbody tr:eq(2)').find('td:eq(1)').text(project.profitabilityIndex);
                $('#projectTable').find('tbody tr:eq(3)').find('td:eq(1)').text(project.simplePaybackPeriod);
                $('#projectTable').find('tbody tr:eq(4)').find('td:eq(1)').text(project.dynamicPaybackPeriod);
            },
            error: function (data) {
                data.preventDefault();
            }
        });
    });

});

function getTableRow(index) {
    return '<tr><td>' + index + '</td>' + '<td contenteditable=\'true\'></td>' + '<td contenteditable=\'true\'></td>' +
        '<td></td>' + '<td></td>' + '<td></td>' + '<td></td>';
}