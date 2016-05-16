package by.grsu.smart.project.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Project")
public class Project {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "calculationHorizon")
    private Integer calculationHorizon; //горизонт расчета

    @Column(name = "bettingShopDiscount")
    private Double bettingShopDiscount; //ставка дисконтирования

    @Column(name = "investedCapital")
    private Double investedCapital;

    @Column(name = "simplePaybackPeriod")
    private Integer simplePaybackPeriod; //простой срок окупаемости

    @Column(name = "dynamicPaybackPeriod")
    private Integer dynamicPaybackPeriod; //динамический срок окупаемости

    //table values
    @Column(name = "netPresentValue")
    private Double netPresentValue; //чистый дисконтированный доход

    @Column(name = "internalRateOfReturn")
    private Double internalRateOfReturn; //внутренняя норма прибыли

    @Column(name = "profitabilityIndex")
    private Double profitabilityIndex; //индекс прибыльности инвестиций

    @Column(name = "description")
    private String description;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;

    @Column(name = "createdDate")
    private Date createdDate;

    public Project() {

    }

    public Project(Integer calculationHorizon, Double bettingShopDiscount, Double investedCapital, Integer simplePaybackPeriod,
                   Integer dynamicPaybackPeriod, Double netPresentValue, Double internalRateOfReturn, Double profitabilityIndex) {
        this.calculationHorizon = calculationHorizon;
        this.bettingShopDiscount = bettingShopDiscount;
        this.investedCapital = investedCapital;
        this.simplePaybackPeriod = simplePaybackPeriod;
        this.dynamicPaybackPeriod = dynamicPaybackPeriod;
        this.netPresentValue = netPresentValue;
        this.internalRateOfReturn = internalRateOfReturn;
        this.profitabilityIndex = profitabilityIndex;
    }

    public Project(Long id, String name, Integer calculationHorizon, Double bettingShopDiscount, Double investedCapital,
                   Integer simplePaybackPeriod, Integer dynamicPaybackPeriod, Double netPresentValue, Double internalRateOfReturn, Double profitabilityIndex) {
        this.id = id;
        this.name = name;
        this.calculationHorizon = calculationHorizon;
        this.bettingShopDiscount = bettingShopDiscount;
        this.investedCapital = investedCapital;
        this.simplePaybackPeriod = simplePaybackPeriod;
        this.dynamicPaybackPeriod = dynamicPaybackPeriod;
        this.netPresentValue = netPresentValue;
        this.internalRateOfReturn = internalRateOfReturn;
        this.profitabilityIndex = profitabilityIndex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCalculationHorizon() {
        return calculationHorizon;
    }

    public void setCalculationHorizon(Integer calculationHorizon) {
        this.calculationHorizon = calculationHorizon;
    }

    public Double getBettingShopDiscount() {
        return bettingShopDiscount;
    }

    public void setBettingShopDiscount(Double bettingShopDiscount) {
        this.bettingShopDiscount = bettingShopDiscount;
    }

    public Double getInvestedCapital() {
        return investedCapital;
    }

    public void setInvestedCapital(Double investedCapital) {
        this.investedCapital = investedCapital;
    }

    public Integer getSimplePaybackPeriod() {
        return simplePaybackPeriod;
    }

    public void setSimplePaybackPeriod(Integer simplePaybackPeriod) {
        this.simplePaybackPeriod = simplePaybackPeriod;
    }

    public Integer getDynamicPaybackPeriod() {
        return dynamicPaybackPeriod;
    }

    public void setDynamicPaybackPeriod(Integer dynamicPaybackPeriod) {
        this.dynamicPaybackPeriod = dynamicPaybackPeriod;
    }

    public Double getNetPresentValue() {
        return netPresentValue;
    }

    public void setNetPresentValue(Double netPresentValue) {
        this.netPresentValue = netPresentValue;
    }

    public Double getInternalRateOfReturn() {
        return internalRateOfReturn;
    }

    public void setInternalRateOfReturn(Double internalRateOfReturn) {
        this.internalRateOfReturn = internalRateOfReturn;
    }

    public Double getProfitabilityIndex() {
        return profitabilityIndex;
    }

    public void setProfitabilityIndex(Double profitabilityIndex) {
        this.profitabilityIndex = profitabilityIndex;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", calculationHorizon=" + calculationHorizon +
                ", bettingShopDiscount=" + bettingShopDiscount +
                ", investedCapital=" + investedCapital +
                ", simplePaybackPeriod=" + simplePaybackPeriod +
                ", dynamicPaybackPeriod=" + dynamicPaybackPeriod +
                ", netPresentValue=" + netPresentValue +
                ", internalRateOfReturn=" + internalRateOfReturn +
                ", profitabilityIndex=" + profitabilityIndex +
                '}';
    }
}
