package com.nyl.enrollee.common;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

public class Dependent {
    private int id;
    private String name;
    @JsonFormat(pattern = "MM/dd/yyyy", shape = JsonFormat.Shape.STRING, timezone = "America/New_York")
    private Date dob;
    private int groupid;

    public Dependent() {

    }

    public Dependent(int id, @NotBlank String name, @NotBlank Date dob, int groupid) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.groupid = groupid;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getGroupid() {
        return groupid;
    }

    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }

    @Override
    public String toString() {
        return "Dependent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                '}';
    }
}