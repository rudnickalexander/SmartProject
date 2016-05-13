package by.grsu.smart.project.entity;

import java.io.Serializable;

public class Metal implements Serializable {
    private Long id;
    private Long nominal;
    private Integer noCertificateRubles;
    private Integer certificateRubles;
    private Integer banksDollars;
    private Integer banksRubles;
    private Integer entitiesDollars;
    private Integer entitiesRubles;
    private MetalType metalType;

    public Metal() {

    }

    public Metal(Long id, Long nominal, Integer noCertificateRubles, Integer certificateRubles, Integer banksDollars,
                 Integer banksRubles, Integer entitiesDollars, Integer entitiesRubles) {
        this.id = id;
        this.nominal = nominal;
        this.noCertificateRubles = noCertificateRubles;
        this.certificateRubles = certificateRubles;
        this.banksDollars = banksDollars;
        this.banksRubles = banksRubles;
        this.entitiesDollars = entitiesDollars;
        this.entitiesRubles = entitiesRubles;
    }

    public Metal(Long id, Long nominal, Integer noCertificateRubles, Integer certificateRubles, Integer banksDollars,
                 Integer banksRubles, Integer entitiesDollars, Integer entitiesRubles, MetalType metalType) {
        this.id = id;
        this.nominal = nominal;
        this.noCertificateRubles = noCertificateRubles;
        this.certificateRubles = certificateRubles;
        this.banksDollars = banksDollars;
        this.banksRubles = banksRubles;
        this.entitiesDollars = entitiesDollars;
        this.entitiesRubles = entitiesRubles;
        this.metalType = metalType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNominal() {
        return nominal;
    }

    public void setNominal(Long nominal) {
        this.nominal = nominal;
    }

    public Integer getNoCertificateRubles() {
        return noCertificateRubles;
    }

    public void setNoCertificateRubles(Integer noCertificateRubles) {
        this.noCertificateRubles = noCertificateRubles;
    }

    public Integer getCertificateRubles() {
        return certificateRubles;
    }

    public void setCertificateRubles(Integer certificateRubles) {
        this.certificateRubles = certificateRubles;
    }

    public Integer getBanksDollars() {
        return banksDollars;
    }

    public void setBanksDollars(Integer banksDollars) {
        this.banksDollars = banksDollars;
    }

    public Integer getBanksRubles() {
        return banksRubles;
    }

    public void setBanksRubles(Integer banksRubles) {
        this.banksRubles = banksRubles;
    }

    public Integer getEntitiesDollars() {
        return entitiesDollars;
    }

    public void setEntitiesDollars(Integer entitiesDollars) {
        this.entitiesDollars = entitiesDollars;
    }

    public Integer getEntitiesRubles() {
        return entitiesRubles;
    }

    public void setEntitiesRubles(Integer entitiesRubles) {
        this.entitiesRubles = entitiesRubles;
    }

    public MetalType getMetalType() {
        return metalType;
    }

    public void setMetalType(MetalType metalType) {
        this.metalType = metalType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Metal metal = (Metal) o;

        if (id != null ? !id.equals(metal.id) : metal.id != null) return false;
        if (nominal != null ? !nominal.equals(metal.nominal) : metal.nominal != null) return false;
        if (noCertificateRubles != null ? !noCertificateRubles.equals(metal.noCertificateRubles) : metal.noCertificateRubles != null)
            return false;
        if (certificateRubles != null ? !certificateRubles.equals(metal.certificateRubles) : metal.certificateRubles != null)
            return false;
        if (banksDollars != null ? !banksDollars.equals(metal.banksDollars) : metal.banksDollars != null) return false;
        if (banksRubles != null ? !banksRubles.equals(metal.banksRubles) : metal.banksRubles != null) return false;
        if (entitiesDollars != null ? !entitiesDollars.equals(metal.entitiesDollars) : metal.entitiesDollars != null)
            return false;
        if (entitiesRubles != null ? !entitiesRubles.equals(metal.entitiesRubles) : metal.entitiesRubles != null)
            return false;
        return metalType != null ? metalType.equals(metal.metalType) : metal.metalType == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nominal != null ? nominal.hashCode() : 0);
        result = 31 * result + (noCertificateRubles != null ? noCertificateRubles.hashCode() : 0);
        result = 31 * result + (certificateRubles != null ? certificateRubles.hashCode() : 0);
        result = 31 * result + (banksDollars != null ? banksDollars.hashCode() : 0);
        result = 31 * result + (banksRubles != null ? banksRubles.hashCode() : 0);
        result = 31 * result + (entitiesDollars != null ? entitiesDollars.hashCode() : 0);
        result = 31 * result + (entitiesRubles != null ? entitiesRubles.hashCode() : 0);
        result = 31 * result + (metalType != null ? metalType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Metal{" +
                "id=" + id +
                ", nominal=" + nominal +
                ", noCertificateRubles=" + noCertificateRubles +
                ", certificateRubles=" + certificateRubles +
                ", banksDollars=" + banksDollars +
                ", banksRubles=" + banksRubles +
                ", entitiesDollars=" + entitiesDollars +
                ", entitiesRubles=" + entitiesRubles +
                ", metalType=" + metalType +
                '}';
    }
}
