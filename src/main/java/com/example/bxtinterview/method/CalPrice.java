package com.example.bxtinterview.method;

/**
 * @author Congw
 * 2023/6/8 22:01
 */
public class CalPrice {

    public double getLowestPrice(double pagePrice, String salesInfo) {
        double lowestPrice = pagePrice;

        // 判断是否有促销信息
        if (!salesInfo.equals("无")) {
            // 解析促销信息，提取满减条件和金额
            String[] promotions = salesInfo.split(",");
            for (String promotion : promotions) {
                if (promotion.contains("满")) {
                    String[] promotionDetails = promotion.split("满|减");
                    if (promotionDetails.length == 3) {
                        double threshold = Double.parseDouble(promotionDetails[1].replaceAll("[^0-9]", ""));
                        double discount = Double.parseDouble(promotionDetails[2].replaceAll("[^0-9]", ""));

                        // 判断页面价格是否满足满减条件
                        if (pagePrice >= threshold) {
                            double price = pagePrice - discount;
                            lowestPrice = Math.min(lowestPrice, price);
                        }
                        else { // 多件凑满减情况
                            int i = 2;
                            while (pagePrice * i < threshold) {
                                i++;
                            }
                            double price = (pagePrice * i - discount) / i ;
                            lowestPrice = Math.min(lowestPrice, price);
                        }
                    }
                }
            }
        }

        return lowestPrice;
    }
}
