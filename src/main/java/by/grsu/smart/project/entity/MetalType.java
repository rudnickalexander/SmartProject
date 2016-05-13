package by.grsu.smart.project.entity;

import java.io.Serializable;

public class MetalType implements Serializable {
    private Long id;
    private String name;
    private String nameEng;
    private String nameBel;

    public MetalType() {

    }

    public MetalType(Long id, String name, String nameEng, String nameBel) {
        this.id = id;
        this.name = name;
        this.nameEng = nameEng;
        this.nameBel = nameBel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameEng() {
        return nameEng;
    }

    public void setNameEng(String nameEng) {
        this.nameEng = nameEng;
    }

    public String getNameBel() {
        return nameBel;
    }

    public void setNameBel(String nameBel) {
        this.nameBel = nameBel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetalType metalType = (MetalType) o;

        if (id != null ? !id.equals(metalType.id) : metalType.id != null) return false;
        if (name != null ? !name.equals(metalType.name) : metalType.name != null) return false;
        if (nameEng != null ? !nameEng.equals(metalType.nameEng) : metalType.nameEng != null) return false;
        return nameBel != null ? nameBel.equals(metalType.nameBel) : metalType.nameBel == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (nameEng != null ? nameEng.hashCode() : 0);
        result = 31 * result + (nameBel != null ? nameBel.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MetalType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nameEng='" + nameEng + '\'' +
                ", nameBel='" + nameBel + '\'' +
                '}';
    }
}
