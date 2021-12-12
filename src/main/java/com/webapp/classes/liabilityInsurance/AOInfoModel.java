package com.webapp.classes.liabilityInsurance;

public class AOInfoModel {
    private String regNum;
    private String chassis;
    private boolean isNew;
    private int KW;
    // outside
    private String ssn;

    public AOInfoModel() {

    }

    public AOInfoModel(String regNum, String chassis, boolean isNew, int KW, String ssn) {
        this.regNum = regNum;
        this.chassis = chassis;
        this.isNew = isNew;
        this.KW = KW;
        this.ssn = ssn;
    }

    public String getRegNum() {
        return regNum;
    }

    public void setRegNum(String regNum) {
        this.regNum = regNum;
    }

    public String getChassis() {
        return chassis;
    }

    public void setChassis(String chassis) {
        this.chassis = chassis;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean isNew) {
        this.isNew = isNew;
    }

    public int getKW() {
        return KW;
    }

    public void setKW(int kW) {
        KW = kW;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    
}
