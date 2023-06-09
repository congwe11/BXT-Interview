package com.example.bxtinterview.service;

import com.example.bxtinterview.dao.BeerProductMapper;
import com.example.bxtinterview.entity.BeerInfo;
import com.example.bxtinterview.entity.BeerProduct;
import com.example.bxtinterview.method.Labeling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Congw
 * 2023/6/8 18:48
 */

@Service
public class ProductService {

    /*
    1. 分批查询商品表
    2. 逐个打标签 映射词典也从表中查询
    3. 批量更新商品表 即对系列字段赋值
    */
    @Autowired
    BeerProductMapper beerProductMapper;

    @Autowired
    Labeling labeling;

    // 1. 分批查询商品表
    public List<BeerProduct> selectProduct(String brand) {
        return beerProductMapper.selectListProduct(brand);
    }
    public List<BeerProduct> selectWithoutSeries() {
        return beerProductMapper.selectWithoutSeries();
    }

    // 2. 逐个打标签 映射词典也从表中查询
    public List<BeerProduct> listLabeling(List<BeerProduct> products) {
        // 映射字典：
        Map<String, String[]> map = new HashMap<>();
        for (BeerProduct product : products) {
            String brand = product.getBrand();

            /*if (brand.equals("其他")) {
                product.setSeries("其他");
                continue;
            }*/
            BeerInfo beerInfo = beerProductMapper.selectProductInfo(brand);

            // 构建字典
            // brand为key
            String key = brand;
            if (map.containsKey(brand)) {
                String seriesLabel = labeling.getSeriesLabel(brand, product.getProductName(), map);
                product.setSeries(seriesLabel);
                continue;
            }
            // 其他关键字为value
            List<String> list = new ArrayList<>();
            list.add(beerInfo.getFirstKeyword());
            list.add(beerInfo.getSecondKeyword());
            list.add(beerInfo.getThirdKeyword());
            list.add(beerInfo.getFourthKeyword());
            list.add(beerInfo.getMapValue());
            String[] strings = list.toArray(new String[0]);
            map.put(brand, strings);

            String seriesLabel = labeling.getSeriesLabel(brand, product.getProductName(), map);
            product.setSeries(seriesLabel);
        }

        return products;
    }

    // 3. 批量更新商品表 即对系列字段赋值
    @Transactional
    public void updateProduct(List<BeerProduct> list) {
        for (BeerProduct product : list) {
            beerProductMapper.updateSeries(product.getId(), product.getBrand(), product.getSeries());
        }
    }
}
