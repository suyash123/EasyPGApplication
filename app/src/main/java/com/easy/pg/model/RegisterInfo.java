package com.easy.pg.model;

public class RegisterInfo {

    private String name;
    private String mobile;
    private String email;
    private String pwd;
    private String cnfPwd;

    public RegisterInfo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getCnfPwd() {
        return cnfPwd;
    }

    public void setCnfPwd(String cnfPwd) {
        this.cnfPwd = cnfPwd;
    }

    @Override
    public String toString() {
        return "RegisterInfo{" +
                "uName='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", pwd='" + pwd + '\'' +
                ", cnfPwd='" + cnfPwd + '\'' +
                '}';
    }
}
