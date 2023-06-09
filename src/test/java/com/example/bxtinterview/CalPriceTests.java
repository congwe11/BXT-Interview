package com.example.bxtinterview;

import com.example.bxtinterview.method.CalPrice;
import org.junit.jupiter.api.Test;

/**
 * @author Congw
 * 2023/6/9 9:45
 */
public class CalPriceTests {

    CalPrice calPrice = new CalPrice();

    @Test
    public void getLowestPriceTests() {
        double pagePrice = 2069.00;
        String Info = "购买至少1件时可享受优惠,满2149元减130元";
        double pagePrice2 = 1899;
        String Info2 = "满4999减150,满3999减120,满2999减90,满1999减60,满999减30";

        double lowestPrice = calPrice.getLowestPrice(pagePrice2, Info2);
        System.out.println("lowestPrice = " + lowestPrice);


    }
}
