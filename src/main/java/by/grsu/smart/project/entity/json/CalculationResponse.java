package by.grsu.smart.project.entity.json;

public class CalculationResponse {
    private double cashFlow;
    private double netPresentValue;
    private double discountedCashFlow;
    private double discountedCashFlowAccrualBasis;

    public CalculationResponse() {

    }

    public CalculationResponse(Double cashFlow, Double netPresentValue, Double discountedCashFlow, Double discountedCashFlowAccrualBasis) {
        this.cashFlow = cashFlow;
        this.netPresentValue = netPresentValue;
        this.discountedCashFlow = discountedCashFlow;
        this.discountedCashFlowAccrualBasis = discountedCashFlowAccrualBasis;
    }

    public Double getCashFlow() {
        return cashFlow;
    }

    public void setCashFlow(Double cashFlow) {
        this.cashFlow = cashFlow;
    }

    public Double getNetPresentValue() {
        return netPresentValue;
    }

    public void setNetPresentValue(Double netPresentValue) {
        this.netPresentValue = netPresentValue;
    }

    public Double getDiscountedCashFlow() {
        return discountedCashFlow;
    }

    public void setDiscountedCashFlow(Double discountedCashFlow) {
        this.discountedCashFlow = discountedCashFlow;
    }

    public Double getDiscountedCashFlowAccrualBasis() {
        return discountedCashFlowAccrualBasis;
    }

    public void setDiscountedCashFlowAccrualBasis(Double discountedCashFlowAccrualBasis) {
        this.discountedCashFlowAccrualBasis = discountedCashFlowAccrualBasis;
    }

    @Override
    public String toString() {
        return "CalculationResponse{" +
                "cashFlow=" + cashFlow +
                ", netPresentValue=" + netPresentValue +
                ", discountedCashFlow=" + discountedCashFlow +
                ", discountedCashFlowAccrualBasis=" + discountedCashFlowAccrualBasis +
                '}';
    }
}
