package com.mpi.mpiseba;

public class HelperClass {

    String name, phone, roll, password, semister, department, shift;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSemister() {
        return semister;
    }

    public void setSemister(String semister) {
        this.semister = semister;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String Department) {
        this.department = department;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String Shift) {
        this.shift = shift;
    }

    public HelperClass(String name, String phone, String roll, String password, String semister, String department, String shift) {
        this.name = name;
        this.phone = phone;
        this.roll = roll;
        this.password = password;
        this.semister = semister;
        this.department = department;
        this.shift = shift;
    }

    public HelperClass() {
    }
}