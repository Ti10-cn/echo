package com.hezhangqi.echo.pojo.dto;

public class Redhat002 {
    private long id;
    private String name;
    private String age;

    public Redhat002(long id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Redhat002() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
