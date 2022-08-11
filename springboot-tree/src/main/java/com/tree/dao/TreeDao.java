package com.tree.dao;

import com.tree.domain.Tree;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TreeDao {

    @Insert("insert into tbl_tree values(null,#{name},#{pid},#{weight} )")
    int save(Tree tree);

    @Delete("delete from tbl_tree where id=#{id}")
    int deleteById(Integer id);

    @Update("update tbl_tree set pid=#{pid},name=#{name} where id=#{id} ")
    int updateTree(Tree tree);

    @Select("select * from tbl_tree where id=#{id}")
    Tree findById(Integer id);

    @Select("select * from tbl_tree")
    List<Tree> findAll();
}
