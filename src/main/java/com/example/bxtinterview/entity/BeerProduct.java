package com.example.bxtinterview.entity;

/**
 * @author Congw
 * 2023/6/8 10:53
 */
public class BeerProduct {
    /*品牌	商品名称		系列	*/
    private int id;
    private String brand;
    private String productName;
    private String series;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }
}
