package com.example.bxtinterview;

import com.example.bxtinterview.dao.BeerProductMapper;
import com.example.bxtinterview.entity.BeerInfo;
import com.example.bxtinterview.entity.BeerProduct;
import com.example.bxtinterview.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author Congw
 * 2023/6/8 21:22
 */
@SpringBootTest
public class ServiceTests {

    @Autowired
    private BeerProductMapper beerProductMapper;

    @Autowired
    private ProductService productService;

    @Test
    public void testSelect() {
        // 1. 分批查询商品表
        List<BeerProduct> list = productService.selectProduct("雪花");
        List<BeerProduct> products = productService.selectWithoutSeries();

        // 2. 逐个打标签 映射词典也从表中查询
        List<BeerProduct> Labeled = productService.listLabeling(products);

        // 3. 批量更新商品表 即对系列字段赋值
        productService.updateProduct(Labeled);

        // 因为文档的数据结构写的不是很清晰，导致在打系列标签是存在几处冗余代码。
        // 最后测试结果与文档要求完全一致。
    }
}
