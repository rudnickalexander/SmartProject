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
    public Project getProject(Long id) {
        return projectDAO.getProject(id);
    }

    @Override
    public List<CalculationResponse> calculateProjectParams(int calculationHorizon, double bettingShopDiscount, double investedCapital, List<CalculatorRequest> requests) {
        List<CalculationResponse> responses = new ArrayList<>(requests.size());

        for (int i = 0; i < requests.size(); ++ i) {
            CalculatorRequest request = requests.get(i);

            if (i == 0) {
                responses.add(new CalculationResponse(0, 0, 1, 0, 0, 0, 0));
                continue;
            }

            Double a = request.getInput() - request.getOutput();
            double b = responses.get(i - 1).getB() + a;

            double c;
            if (i == 1) {
                c = 1;
            } else {
                c = 1 / Math.pow((1 + bettingShopDiscount / 100), i - 1);
            }

            double d = request.getInput() * c;
            double e = request.getOutput() * c;
            double f = d - e;
            double g = responses.get(i - 1).getG() + f;

            responses.add(new CalculationResponse(a, b, c, d, e, f, g));

        }

        return responses;
    }

    @Override
    public Project calculateProject(int calculationHorizon, double bettingShopDiscount, double investedCapital, int investedCapitalMonth,
                                    List<CalculationResponse> params) {
        int dynamicPeriod = 0;

        final int month = 13 - (investedCapitalMonth % 12);
        int simplePaybackPeriod = 0;
        int dynamicPaybackPeriod = 0;

        for (int i = 0; i < params.size(); i++) {
            CalculationResponse response = params.get(i);

            if (response.getB() > 0 && simplePaybackPeriod == 0) {
                simplePaybackPeriod = (i - 2) * 12;
                int leaves = (int) (11 - params.get(i - 1).getB() / (response.getA() / 12)) - 12;
                simplePaybackPeriod += leaves;
                simplePaybackPeriod += month;
            }

            if (response.getG() > 0 && dynamicPaybackPeriod == 0) {
                dynamicPaybackPeriod = (i - 2) * 12;
                int leaves = (int) (11 - params.get(i - 1).getG() / (response.getF() / 12)) - 12;
                dynamicPaybackPeriod += leaves;
                dynamicPaybackPeriod += month;

                dynamicPeriod = i;
            }
        }

        double npv = params.get(params.size() - 1).getG();
//        double irr = irr(params.get(0).getA(), params.get(dynamicPeriod).getA());
        double pi = pi(params, dynamicPeriod, npv);

        double[] values = new double[dynamicPeriod + 1];
        for (int i = 0; i <= dynamicPeriod; i++) {
            values[i] = params.get(i).getA();
        }
        double irr = getIRR(values);

        return new Project(calculationHorizon, bettingShopDiscount, investedCapital, simplePaybackPeriod, dynamicPaybackPeriod, npv, irr, pi);
    }

    @Override
    public void saveProject(Project project) {
        projectDAO.save(project);
    }

    @Override
    public List<Project> getLatestProjects() {
        return projectDAO.getLatest();
    }

    @Override
    public List<Project> findProject(List<Double> params) {
        return projectDAO.findProject(params);
    }

    private double irr(double a, double b) {
        return 17.71586930594;
    }

    private double pi(List<CalculationResponse> params, int dynamicPeriod, double npv) {
        double sum = 0;

        for (int i = 0; i <= dynamicPeriod; i++) {
            sum += params.get(i).getE();
        }

        return (sum + npv) / sum;
    }

    public static double getIRR(final double[] cashFlows)
    {
        final int MAX_ITER = 20;
        double EXCEL_EPSILON = 0.0000001;

        double x = 0.1;
        int iter = 0;
        while (iter++ < MAX_ITER) {

            final double x1 = 1.0 + x;
            double fx = 0.0;
            double dfx = 0.0;
            for (int i = 0; i < cashFlows.length; i++) {
                final double v = cashFlows[ i ];
                final double x1_i = Math.pow( x1, i );
                fx += v / x1_i;
                final double x1_i1 = x1_i * x1;
                dfx += -i * v / x1_i1;
            }
            final double new_x = x - fx / dfx;
            final double epsilon = Math.abs( new_x - x );

            if (epsilon <= EXCEL_EPSILON) {
                if (x == 0.0 && Math.abs( new_x ) <= EXCEL_EPSILON) {
                    return 0.0; // OpenOffice calc does this
                }
                else {
                    return new_x*100;
                }
            }
            x = new_x;
        }
        return x;
    }
}
