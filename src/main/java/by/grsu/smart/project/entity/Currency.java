package by.grsu.smart.project.entity;

public class Currency {
    private Long id;
    private String numCode;
    private String charCode;
    private Integer scale;
    private String name;
    private Double rate;

    public Currency() {

    }

    public Currency(Long id, String numCode, String charCode, Integer scale, String name, Double rate) {
        this.id = id;
        this.numCode = numCode;
        this.charCode = charCode;
        this.scale = scale;
        this.name = name;
        this.rate = rate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCharCode() {
        return charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getNumCode() {
        return numCode;
    }

    public void setNumCode(String numCode) {
        this.numCode = numCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Currency currency = (Currency) o;

        if (id != null ? !id.equals(currency.id) : currency.id != null) return false;
        if (numCode != null ? !numCode.equals(currency.numCode) : currency.numCode != null) return false;
        if (charCode != null ? !charCode.equals(currency.charCode) : currency.charCode != null) return false;
        if (scale != null ? !scale.equals(currency.scale) : currency.scale != null) return false;
        if (name != null ? !name.equals(currency.name) : currency.name != null) return false;
        return rate != null ? rate.equals(currency.rate) : currency.rate == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (numCode != null ? numCode.hashCode() : 0);
        result = 31 * result + (charCode != null ? charCode.hashCode() : 0);
        result = 31 * result + (scale != null ? scale.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (rate != null ? rate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "id=" + id +
                ", numCode='" + numCode + '\'' +
                ", charCode='" + charCode + '\'' +
                ", scale=" + scale +
                ", name='" + name + '\'' +
                ", rate=" + rate +
                '}';
    }
}
