package com.example.bxtinterview.entity;

/**
 * @author Congw
 * 2023/6/8 10:56
 */
public class BeerInfo {
    /*品牌	第一关键字（根据商品名称匹配）	第二关键字	第三关键字	第四关键字	映射值*/
    private String brand;
    private String firstKeyword;
    private String secondKeyword;
    private String thirdKeyword;
    private String fourthKeyword;
    private String mapValue;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getFirstKeyword() {
        return firstKeyword;
    }

    public void setFirstKeyword(String firstKeyword) {
        this.firstKeyword = firstKeyword;
    }

    public String getSecondKeyword() {
        return secondKeyword;
    }

    public void setSecondKeyword(String secondKeyword) {
        this.secondKeyword = secondKeyword;
    }

    public String getThirdKeyword() {
        return thirdKeyword;
    }

    public void setThirdKeyword(String thirdKeyword) {
        this.thirdKeyword = thirdKeyword;
    }

    public String getFourthKeyword() {
        return fourthKeyword;
    }

    public void setFourthKeyword(String fourthKeyword) {
        this.fourthKeyword = fourthKeyword;
    }

    public String getMapValue() {
        return mapValue;
    }

    public void setMapValue(String mapValue) {
        this.mapValue = mapValue;
    }
}
