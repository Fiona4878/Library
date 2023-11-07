package com.example.library.domain;

public class Reader {
    private Integer r_id;
    private String r_name;
    private String r_sex;
    private String r_phone;
    private String r_pw;

    @Override
    public String toString() {
        return "Reader{" +
                "r_id=" + r_id +
                ", r_name='" + r_name + '\'' +
                ", r_sex='" + r_sex + '\'' +
                ", r_phone='" + r_phone + '\'' +
                ", r_pw='" + r_pw + '\'' +
                '}';
    }

    public Integer getR_id() {
        return r_id;
    }

    public void setR_id(Integer r_id) {
        this.r_id = r_id;
    }

    public String getR_name() {
        return r_name;
    }

    public void setR_name(String r_name) {
        this.r_name = r_name;
    }

    public String getR_sex() {
        return r_sex;
    }

    public void setR_sex(String r_sex) {
        this.r_sex = r_sex;
    }

    public String getR_phone() {
        return r_phone;
    }

    public void setR_phone(String r_phone) {
        this.r_phone = r_phone;
    }

    public String getR_pw() {
        return r_pw;
    }

    public void setR_pw(String r_pw) {
        this.r_pw = r_pw;
    }
}
