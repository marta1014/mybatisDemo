package com.Mapper;

import com.jopo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    // 查询所有
     List<Brand> selectAll();

     // 查询详情 byId
    Brand selectByIdBrand(int id);

    // 条件查询
    // 1 散装参数 @Param()
    // List<Brand> selectByCondition(@Param("statu") int statu,@Param("companyName") String companyName,@Param("brandName") String brandName);
    // 2 对象
    // List<Brand> selectByCondition(Brand brand);
    // 3 Map
    List<Brand> selectByCondition(Map map);

    //单条件动态查询
    List<Brand> selectByConditionSingle(Brand brand);


    // 添加
    void add(Brand brand);

    int update(Brand brand);

    int deleteById(int id);

    // void deleteByIds(int[] idArr); 默认 此时就是array 名称...
    void deleteByIds(@Param("ids") int[] idArr);

}
