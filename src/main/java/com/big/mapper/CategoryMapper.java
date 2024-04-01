package com.big.mapper;

import com.big.pojo.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CategoryMapper {
    @Select("select * from category where category_name=#{categoryName}")
    Category selectCategoryByCategoryName(String categoryName);

    @Delete("DELETE FROM category WHERE id=#{id}")
    void deleteCategoryByCategoryId(Integer id);
}
