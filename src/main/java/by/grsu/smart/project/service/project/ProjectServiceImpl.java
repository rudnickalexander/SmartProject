package by.grsu.smart.project.service.project;

import by.grsu.smart.project.dao.project.ProjectDAO;
import by.grsu.smart.project.entity.Project;
import by.grsu.smart.project.entity.json.CalculationResponse;
import by.grsu.smart.project.entity.json.CalculatorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDAO projectDAO;

    @Override
    public List<CalculationResponse> calculateProjectParams(int calculationHorizon, double bettingShopDiscount, double investedCapital, List<CalculatorRequest> requests) {
        List<CalculationResponse> responses = new ArrayList<>(requests.size());

        for (int i = 0; i < requests.size(); ++ i) {
            CalculatorRequest request = requests.get(i);

            if (i == 0) {
                responses.add(new CalculationResponse(investedCapital * -1, 0d, 0d, 0d));
                continue;
            }

            Double cashFlow = request.getInput() - request.getOutput();
            Double discountedCashFlow = calculateDCF(cashFlow, bettingShopDiscount, request.getIndex());
            Double netPresentValue;
            Double d;

            if (i == 1) {
                netPresentValue = cashFlow;
                d = discountedCashFlow;
            } else {
                netPresentValue = responses.get(i - 1).getNetPresentValue() + cashFlow;
                d = responses.get(i - 1).getDiscountedCashFlow() + discountedCashFlow;
            }

            responses.add(new CalculationResponse(cashFlow, netPresentValue, discountedCashFlow, d));

        }

        return responses;
    }

    @Override
    public Project calculateProject(int calculationHorizon, double bettingShopDiscount, double investedCapital, List<CalculationResponse> params) {
        double netPresentValueSum = 0;
        int simplePaybackPeriod = 0;
        int dynamicPaybackPeriod = 0;

        for (int i = 0; i < params.size(); i++) {
            CalculationResponse response = params.get(i);
            netPresentValueSum += response.getDiscountedCashFlow();

            if (response.getNetPresentValue() > investedCapital && simplePaybackPeriod == 0) {
                simplePaybackPeriod = i;
            }

            if (response.getDiscountedCashFlowAccrualBasis() > investedCapital && dynamicPaybackPeriod == 0) {
                dynamicPaybackPeriod = i;
            }
        }

        double netPresentValue = netPresentValueSum - investedCapital;
        double profitabilityIndex = netPresentValue / investedCapital;

        return new Project(calculationHorizon, bettingShopDiscount, investedCapital, simplePaybackPeriod, dynamicPaybackPeriod, netPresentValue, 16d, profitabilityIndex);
    }

    @Override
    public void saveProject(Project project) {
        projectDAO.save(project);
    }

    @Override
    public List<Project> getLatestProjects() {
        return projectDAO.getLatest();
    }

    private Double calculateDCF(double cashFlow, double bettingShopDiscount, int year) {
        return cashFlow / Math.pow((1 + 0.01 * bettingShopDiscount), year);
    }
}
