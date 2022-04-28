package com.jopo;

public class User {
    private int id;
    private String name;
    private String pwd;
    private String addr;

    public User() {
    }

    public User(int id, String name, String pwd, String addr) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.addr = addr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }
}
