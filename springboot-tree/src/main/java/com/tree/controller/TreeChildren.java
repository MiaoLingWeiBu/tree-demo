package com.tree.controller;

import com.tree.domain.Tree;

import java.util.List;

public class TreeChildren {
    private Integer id;
    private String label;


    private List<TreeChildren> Children;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<TreeChildren> getChildren() {
        return Children;
    }

    public void setChildren(List<TreeChildren> children) {
        Children = children;
    }

    @Override
    public String toString() {
        return "TreeChildren{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", Children=" + Children +
                '}';
    }
}
