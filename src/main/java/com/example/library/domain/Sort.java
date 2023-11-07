package com.example.library.domain;

public class Sort {
    private Integer tid;
    private String s_name;

    @Override
    public String toString() {
        return "Sort{" +
                "tid=" + tid +
                ", s_name='" + s_name + '\'' +
                '}';
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }
}
