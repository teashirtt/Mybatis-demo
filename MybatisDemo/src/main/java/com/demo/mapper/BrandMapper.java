package com.demo.mapper;

import com.demo.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandMapper {
    // 查询所有
    List<Brand> selectAll();

    // 查看详情
    Brand selectById(int id);

    /*
        条件查询(多条件)
        1. 散装参数 使用@Param
        2. 对象参数
        3. Map集合参数
    */
    List<Brand> selectByCondition(@Param("status") int status,@Param("companyName") String companyName
            ,@Param("brand") String  brand);
}
