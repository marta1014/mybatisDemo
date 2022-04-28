package com.jopo;

public class Brand {
    private int id;
    private String companyName;
    private String brandName;
    private String description;
    private int ordered;
    private int statu;

    public Brand() {
    }

    public Brand(int id, String companyName, String brandName, String description, int ordered, int statu) {
        this.id = id;
        this.companyName = companyName;
        this.brandName = brandName;
        this.description = description;
        this.ordered = ordered;
        this.statu = statu;
    }

    public int getId() {
        return id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", brandName='" + brandName + '\'' +
                ", description='" + description + '\'' +
                ", ordered=" + ordered +
                ", statu=" + statu +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOrdered() {
        return ordered;
    }

    public void setOrdered(int ordered) {
        this.ordered = ordered;
    }

    public int getStatu() {
        return statu;
    }

    public void setStatu(int statu) {
        this.statu = statu;
    }

}
