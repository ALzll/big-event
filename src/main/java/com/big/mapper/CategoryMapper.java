package com.big.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.big.pojo.Category;
import com.big.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryMapper  extends BaseMapper<Category> {

//    //文章分类（增）
//    @Insert("INSERT INTO category (category_name,category_alias,create_user,create_time,update_time) VALUES(#{categoryName},#{categoryAlias},#{createUser},NOW(),NOW());")
//    void inserCategory(Category category);
//
//    //文章分类（删）
//    @Delete("DELETE FROM category WHERE id=#{id}")
//    void deleteCategoryByCategoryId(Integer id);
//
//    //文章分类（改）
//    @Update("UPDATE category set category_name = #{categoryName},category_alias = #{categoryAlias},update_time=now() WHERE id = #{id};")
//    void updateCategory(Category category);
//
//    //文章分类（查）
//    @Select("select * from category where category_name=#{categoryName}")
//    Category selectCategoryByCategoryName(String categoryName);

}
