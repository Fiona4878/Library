package com.example.library.domain;

import java.util.List;

public class Book {
    private Integer b_id;
    private String b_name;
    private String b_auther;
    private String b_other;
    private Integer b_exit;
    private Integer t_id;

//从表实体应该包含一个主表实体的对象引用
    private Sort sort;

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "Book{" +
                "b_id=" + b_id +
                ", b_name='" + b_name + '\'' +
                ", b_auther='" + b_auther + '\'' +
                ", b_other='" + b_other + '\'' +
                ", b_exit=" + b_exit +
                ", t_id=" + t_id +
                '}';
    }

    public Integer getB_id() {
        return b_id;
    }

    public void setB_id(Integer b_id) {
        this.b_id = b_id;
    }

    public String getB_name() {
        return b_name;
    }

    public void setB_name(String b_name) {
        this.b_name = b_name;
    }

    public String getB_auther() {
        return b_auther;
    }

    public void setB_auther(String b_auther) {
        this.b_auther = b_auther;
    }

    public String getB_other() {
        return b_other;
    }

    public void setB_other(String b_other) {
        this.b_other = b_other;
    }

    public Integer getB_exit() {
        return b_exit;
    }

    public void setB_exit(Integer b_exit) {
        this.b_exit = b_exit;
    }

    public Integer getT_id() {
        return t_id;
    }

    public void setT_id(Integer t_id) {
        this.t_id = t_id;
    }
}
