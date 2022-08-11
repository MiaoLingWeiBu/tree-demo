package com.tree.service.impl;

import com.tree.dao.TreeDao;
import com.tree.domain.Tree;
import com.tree.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreeServiceImpl implements TreeService {
    @Autowired
    private TreeDao treeDao;

    @Override
    public Boolean saveTree(Tree tree) {
        int num = treeDao.save(tree);
        return num>0;
    }

    @Override
    public Boolean deleteById(Integer id) {
        int num = treeDao.deleteById(id);
        return num>0;
    }

    @Override
    public Boolean updateTree(Tree tree) {
        int num = treeDao.updateTree(tree);
        return num>0;
    }

    @Override
    public Tree findById(Integer id) {
        Tree tree = treeDao.findById(id);
        return tree;
    }

    @Override
    public List<Tree> findAll() {
        List<Tree> all = treeDao.findAll();
        return all;
    }
}
