package com.demo.kaedin.transactionalitydemo.model;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;


public class User {
    public User(String name, String dept, long salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    private String name;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }

    public long getSalary() {
        return salary;
    }

    private String dept;
    private long salary;
}
