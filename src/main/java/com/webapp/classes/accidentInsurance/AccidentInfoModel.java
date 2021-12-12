package com.webapp.classes.accidentInsurance;

import java.time.LocalDate;

import javax.xml.datatype.XMLGregorianCalendar;

public class AccidentInfoModel {
    
    private String startDate;
    private boolean student;
    private int pack;

    public AccidentInfoModel(){
        
    }

    public AccidentInfoModel(String startDate, boolean student, int pack) {
        this.startDate = startDate;
        this.student = student;
        this.pack = pack;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getPack() {
        return pack;
    }

    public void setPack(int pack) {
        this.pack = pack;
    }

    public boolean isStudent() {
        return student;
    }

    public void setStudent(boolean student) {
        this.student = student;
    }

    
}
