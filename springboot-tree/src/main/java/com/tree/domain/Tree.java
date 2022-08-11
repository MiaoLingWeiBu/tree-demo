package com.tree.domain;

import com.tree.controller.TreeChildren;

import java.util.List;

public class Tree {
    private Integer id;
    private String name;
    private Integer pid;
    private Integer weight;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pid=" + pid +
                ", weight=" + weight +
                '}';
    }
}
