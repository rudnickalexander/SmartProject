package by.grsu.smart.project.entity;

public class Project {
    private Long id;
    private String name;
    private Integer calculationHorizont; //горизонт расчета
    private Integer bettingShopDiscont; //ставка дисконтирования
    private Long investedCapital;
    private Integer simplePaybackPeriod; //простой срок окупаемости
    private Integer dynamicPaybackPeriod; //динамический срок окупаемости

    //table values
    private Long netPresentValue; //чистый дисконтированный доход
    private Long internalRateOfReturn; //внутренняя норма прибыли
    private Long profitabilityIndex; //индекс прибыльности инвестиций

}
