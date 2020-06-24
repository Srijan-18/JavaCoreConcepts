package com.bridgelabz.javacore;

import com.opencsv.bean.CsvBindByName;

public class Users {
    @CsvBindByName(column = "NAME",required = true)
    private String name;
    @CsvBindByName(column = "EMAIL", required = true)
    private String email;
    @CsvBindByName(column = "PHONE",required = true)
    private String phoneNo;

    public Users(String name, String email, String phoneNo) {
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNum(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    @Override
    public String toString() {

        return name + "," + email + "," + phoneNo;
    }
}