package com.easy.pg.model;

public class LoginInfo {

    private String mobile;
    private String pwd;

    public LoginInfo() {
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "LoginInfo{" +
                "mobile='" + mobile + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
