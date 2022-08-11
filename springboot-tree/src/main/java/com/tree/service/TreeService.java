package com.tree.service;

import com.tree.domain.Tree;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface TreeService {

    Boolean saveTree(Tree tree);

    Boolean deleteById(Integer id);

    Boolean updateTree(Tree tree);

    Tree findById(Integer id);

    List<Tree> findAll();
}
