package by.grsu.smart.project.service.metal;

import by.grsu.smart.project.entity.Metal;
import by.grsu.smart.project.entity.MetalType;

import java.util.List;

public interface MetalService {

    List<Metal> getMetalCost();

    List<MetalType> getMetalType();
}
