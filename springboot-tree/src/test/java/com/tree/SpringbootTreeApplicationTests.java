package com.tree;

import com.tree.controller.Result;
import com.tree.controller.TreeController;
import com.tree.dao.TreeDao;
import com.tree.domain.Tree;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootTreeApplicationTests {
    @Autowired
    private TreeController treeController;

    @Test
    void findAllTest() {
        Result result = treeController.findAll();
        System.out.println(result);
    }

    @Test
    void deleteTest() {
        Result result = treeController.deleteById(23);
        System.out.println(result);
    }
    @Test
    void updateTest() {
        Tree tree=new Tree();
        tree.setId(14);
        tree.setName("laal");
        tree.setPid(10);
//        Result result = treeController.updateTree(tree);
//        System.out.println(result);
    }
    @Test
    void findByIdTest() {
        Result result = treeController.findById(2);
        System.out.println(result);
    }
    @Test
    void addTest() {
        Tree tree=new Tree();
        tree.setId(20);
        tree.setName("test");
        tree.setPid(4);
//        Result num = treeController.saveTree(tree);
//        System.out.println(num);
    }

}
