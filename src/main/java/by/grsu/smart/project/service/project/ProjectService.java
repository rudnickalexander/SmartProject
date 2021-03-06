package by.grsu.smart.project.service.project;

import by.grsu.smart.project.entity.Project;
import by.grsu.smart.project.entity.json.CalculationResponse;
import by.grsu.smart.project.entity.json.CalculatorRequest;

import java.util.List;

public interface ProjectService {

    Project getProject(Long id);

    List<CalculationResponse> calculateProjectParams(int calculationHorizon, double bettingShopDiscount, double investedCapital, List<CalculatorRequest> requests);

    Project calculateProject(int calculationHorizon, double bettingShopDiscount, double investedCapital, int investedCapitalMonth,
                             List<CalculationResponse> params);

    void saveProject(Project project);

    List<Project> getLatestProjects();

    List<Project> findProject(List<Double> params);

}
