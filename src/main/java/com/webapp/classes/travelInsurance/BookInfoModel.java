package com.webapp.classes.travelInsurance;

public class BookInfoModel {
    public String c_firstName;
    public String c_lastName;
    public String c_ssn;
    public String c_address;
    public String c_city;
    public String c_postalCode;

    public String i_firstName;
    public String i_lastName;
    public String i_ssn;
    public String i_address;
    public String i_city;
    public String i_postalCode;

    public String startDate;

    public BookInfoModel() {

    }

    public BookInfoModel(String c_firstName, String c_lastName, String c_ssn, String c_address, String c_city,
            String c_postalCode, String i_firstName, String i_lastName, String i_ssn, String i_address, String i_city,
            String i_postalCode, String startDate) {
        this.c_firstName = c_firstName;
        this.c_lastName = c_lastName;
        this.c_ssn = c_ssn;
        this.c_address = c_address;
        this.c_city = c_city;
        this.c_postalCode = c_postalCode;
        this.i_firstName = i_firstName;
        this.i_lastName = i_lastName;
        this.i_ssn = i_ssn;
        this.i_address = i_address;
        this.i_city = i_city;
        this.i_postalCode = i_postalCode;
        this.startDate = startDate;
    }

    public String getC_firstName() {
        return c_firstName;
    }

    public void setC_firstName(String c_firstName) {
        this.c_firstName = c_firstName;
    }

    public String getC_lastName() {
        return c_lastName;
    }

    public void setC_lastName(String c_lastName) {
        this.c_lastName = c_lastName;
    }

    public String getC_ssn() {
        return c_ssn;
    }

    public void setC_ssn(String c_ssn) {
        this.c_ssn = c_ssn;
    }

    public String getC_address() {
        return c_address;
    }

    public void setC_address(String c_address) {
        this.c_address = c_address;
    }

    public String getC_city() {
        return c_city;
    }

    public void setC_city(String c_city) {
        this.c_city = c_city;
    }

    public String getC_postalCode() {
        return c_postalCode;
    }

    public void setC_postalCode(String c_postalCode) {
        this.c_postalCode = c_postalCode;
    }

    public String getI_firstName() {
        return i_firstName;
    }

    public void setI_firstName(String i_firstName) {
        this.i_firstName = i_firstName;
    }

    public String getI_lastName() {
        return i_lastName;
    }

    public void setI_lastName(String i_lastName) {
        this.i_lastName = i_lastName;
    }

    public String getI_ssn() {
        return i_ssn;
    }

    public void setI_ssn(String i_ssn) {
        this.i_ssn = i_ssn;
    }

    public String getI_address() {
        return i_address;
    }

    public void setI_address(String i_address) {
        this.i_address = i_address;
    }

    public String getI_city() {
        return i_city;
    }

    public void setI_city(String i_city) {
        this.i_city = i_city;
    }

    public String getI_postalCode() {
        return i_postalCode;
    }

    public void setI_postalCode(String i_postalCode) {
        this.i_postalCode = i_postalCode;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "BookTPLModel [c_address=" + c_address + ", c_city=" + c_city + ", c_firstName=" + c_firstName
                + ", c_lastName=" + c_lastName + ", c_postalCode=" + c_postalCode + ", c_ssn=" + c_ssn + ", i_address="
                + i_address + ", i_city=" + i_city + ", i_firstName=" + i_firstName + ", i_lastName=" + i_lastName
                + ", i_postalCode=" + i_postalCode + ", i_ssn=" + i_ssn + ", startDate=" + startDate + "]";
    }

    
}
