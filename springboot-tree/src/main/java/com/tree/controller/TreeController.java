package com.tree.controller;

import com.tree.domain.Tree;
import com.tree.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/trees")
public class TreeController {
    @Autowired
    private TreeService treeService;

    @PostMapping
    public Result saveTree(@RequestBody TreeChildren treeChildren) {
        Integer pid = treeChildren.getId();
        String name=treeChildren.getLabel();

        Tree tree = new Tree();
        tree.setPid(pid);
        tree.setName(name+"的字节点");

        boolean flag = treeService.saveTree(tree);
        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id) {
        Boolean flag = treeService.deleteById(id);
        return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR,flag);
    }
    @PutMapping
    public Result updateTree(@RequestBody UpdateData updateData) {
        Integer id = updateData.getId();
        String name=updateData.getName();
        Integer pid =updateData.getPid();

        Tree tree = new Tree();
        tree.setId(id);
        tree.setName(name);
        tree.setPid(pid);
        Boolean flag = treeService.updateTree(tree);
        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id) {
        Tree tree = treeService.findById(id);
        Integer code=tree != null ? Code.GET_OK:Code.GET_ERR;
        String msg=tree != null ? "" : "查询失败";
        return new Result(code,tree,msg);
    }
    @GetMapping
    public Result findAll() {
        List<Tree> all = treeService.findAll();
        Integer code=all != null ? Code.GET_OK : Code.GET_ERR;
        String msg=all != null ? "" : "查询失败";
        List<TreeChildren> childrens=new ArrayList<TreeChildren>();
        for(Tree tree : all){

            if(tree.getPid().equals(0)){
                List<TreeChildren> children=new ArrayList<TreeChildren>();
                for(Tree tree1 : all){
                    List<TreeChildren> children1=new ArrayList<TreeChildren>();
                    if(tree1.getPid()==tree.getId()){
                        for(Tree tree2 : all){
                            if(tree2.getPid()==tree1.getId()){
                                TreeChildren treeChildren2= new TreeChildren();
                                treeChildren2.setId(tree2.getId());
                                treeChildren2.setLabel(tree2.getName());
                                children1.add(treeChildren2);
                            }
                        }
                        TreeChildren treeChildren1= new TreeChildren();
                        treeChildren1.setId(tree1.getId());
                        treeChildren1.setLabel(tree1.getName());
                        treeChildren1.setChildren(children1);
                        children.add(treeChildren1);


                    }
                }

                TreeChildren treeChildren= new TreeChildren();
                treeChildren.setId(tree.getId());
                treeChildren.setLabel(tree.getName());
                treeChildren.setChildren(children);
                childrens.add(treeChildren);
            }
        }

        return new Result(code,childrens,msg);
    }

    public void loop(){

    }


}
