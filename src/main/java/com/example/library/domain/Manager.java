package com.example.library.domain;

public class Manager {
    private Integer m_id;
    private String m_name;
    private String m_pw;

    public Integer getM_id() {
        return m_id;
    }

    public void setM_id(Integer m_id) {
        this.m_id = m_id;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public String getM_pw() {
        return m_pw;
    }

    public void setM_pw(String m_pw) {
        this.m_pw = m_pw;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "m_id=" + m_id +
                ", m_name='" + m_name + '\'' +
                ", m_pw='" + m_pw + '\'' +
                '}';
    }
}
