package by.grsu.smart.project.entity.json;

import java.io.Serializable;

public class CalculatorRequest implements Serializable {
    private Integer index;
    private Double input;
    private Double output;

    public CalculatorRequest() {}

    public CalculatorRequest(Integer index, Double input, Double output) {
        this.index = index;
        this.input = input;
        this.output = output;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Double getInput() {
        return input;
    }

    public void setInput(Double input) {
        this.input = input;
    }

    public Double getOutput() {
        return output;
    }

    public void setOutput(Double output) {
        this.output = output;
    }

}
