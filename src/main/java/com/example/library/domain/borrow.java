package com.example.library.domain;

public class borrow {
    private Integer id;
    private Integer b_id;
    private Integer r_id;

    @Override
    public String toString() {
        return "borrow{" +
                "id=" + id +
                ", b_id=" + b_id +
                ", r_id=" + r_id +
                '}';
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getB_id() {
        return b_id;
    }

    public void setB_id(Integer b_id) {
        this.b_id = b_id;
    }

    public Integer getR_id() {
        return r_id;
    }

    public void setR_id(Integer r_id) {
        this.r_id = r_id;
    }
}
