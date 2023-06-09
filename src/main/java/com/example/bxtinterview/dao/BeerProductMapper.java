package com.example.bxtinterview.dao;

import com.example.bxtinterview.entity.BeerInfo;
import com.example.bxtinterview.entity.BeerProduct;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author Congw
 * 2023/6/8 20:30
 */
@Mapper
public interface BeerProductMapper {

    @Select({
            "select * from beer_product where brand = #{brand}"
    })
    List<BeerProduct> selectListProduct(String brand);
    @Select({
            "select * from beer_product where series = \"\""
    })
    List<BeerProduct> selectWithoutSeries();

    @Select({
            "select * from beer_info where brand = #{brand}"
    })
    BeerInfo selectProductInfo(String brand);


    @Update({
            "update beer_product set series=#{series} where id=#{id} and brand=#{brand}"
    })
    int updateSeries(int id, String brand, String series);

}
