package com.example.bxtinterview.method;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Congw
 * 2023/6/8 0:28
 */
@Component
public class Labeling {

    /**
     * 打系列标签
     */
    public String getSeriesLabel(String brand, String productName, Map<String, String[]> map) {

        String series = "";

        // 规则一：先识别品牌，如果品牌值是其他，那么系列就是其他
        if (brand.equals("其他")) {
            return "其他";
        }

        // 规则2: 匹配第一关键字
        String[] words = map.get(brand);
        if (productName.contains(words[0])) {
            series += words[words.length - 1];
            return series;
        }
        // 规则3: 要求匹配第二、第三、第四关键字（可根据需要扩展）
        // 下标 1, 2, 3
        boolean allKeywordsMatched = true;
        for (int i = 1; i <= words.length-2; i++) {
            if (words[i] == null) continue;
            if (!productName.contains(words[i])) {
                allKeywordsMatched = false;
                break;
            }
        }
        if (allKeywordsMatched) {
            series += words[words.length - 1];
            return series;
        }

        // 规则4: 如果最终品牌有值，系列没打上标签，系列值就等于品牌+其他
        return brand + "其他";
    }


    /* (\d+(?:\.\d+)?)\s*(L|ML|毫升|mL|ml|升) */
    private static final String regex = "(\\d+(?:\\.\\d+)?)\\s*(L|l|升|ML|mL|Ml|ml|毫升)";

    /**
     * 获取单量
     * @param productName String
     * @return 返回匹配结果int，未匹配返回 0
     */
    public int getSingleNumber(String productName) {
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(productName);

        int res = 0;
        // 查找匹配的数量并提取
        if (matcher.find()) {
            // 数字部分
            String prefix = matcher.group(1);
            double numberDouble = Double.parseDouble(prefix);  // valueOf返回包装类型，parse..返回基本类型

            // 单位部分
            String unit = matcher.group(2);

            if (unit.equalsIgnoreCase("L") || unit.equals("升")) {
                res = (int) (numberDouble * 1000);
            } else if (unit.equalsIgnoreCase("ML") || unit.equals("毫升")) {
                res = (int) numberDouble;
            }
        }

        return res;

    }
}
