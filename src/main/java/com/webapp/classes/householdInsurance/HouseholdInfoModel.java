package com.webapp.classes.householdInsurance;

import com.webapp.classes.enums;
// enum TypeObject {
//     RESIDENCE,
//     BUSINESS,
//     PORTABLE
// }

// enum TypeHouseholdCover {
//     STANDARD,
//     COMFORT,
//     MEGA
// }

public class HouseholdInfoModel {
    public enums.TypeObject typeObject;                   // house, apartment 
    public float areaOfObject;                      // kvadratura na objektot
    public String dateOfObject;                     // datum na izgradba na objektot
    public enums.TypeCoverHH typeHouseholdCover;   // tip na pokritieto
    public String contractLenght;                      // vremetraenje na dogovorot 1, 3 ili 5

    public HouseholdInfoModel() {
        areaOfObject = 30;
        contractLenght = "1";
    }

    public HouseholdInfoModel(enums.TypeObject typeObject, float areaOfObject, String dateOfObject, enums.TypeCoverHH typeHouseholdCover, String contractLenght) {
        this.typeObject = typeObject;
        this.areaOfObject = areaOfObject;
        this.dateOfObject = dateOfObject;
        this.typeHouseholdCover = typeHouseholdCover;
        this.contractLenght = contractLenght;
    }

    public enums.TypeObject getTypeObject() {
        return typeObject;
    }

    public void setTypeObject(enums.TypeObject typeObject) {
        this.typeObject = typeObject;
    }

    public float getAreaOfObject() {
        return areaOfObject;
    }

    public void setAreaOfObject(float areaOfObject) {
        this.areaOfObject = areaOfObject;
    }

    public String getDateOfObject() {
        return dateOfObject;
    }

    public void setDateOfObject(String dateOfObject) {
        this.dateOfObject = dateOfObject;
    }

    public enums.TypeCoverHH getTypeHouseholdCover() {
        return typeHouseholdCover;
    }

    public void setTypeHouseholdCover(enums.TypeCoverHH typeHouseholdCover) {
        this.typeHouseholdCover = typeHouseholdCover;
    }

    public String getContractLenght() {
        return contractLenght;
    }

    public void setContractLenght(String contractLenght) {
        this.contractLenght = contractLenght;
    }

    @Override
    public String toString() {
        return "HouseholdInfoModel [areaOfObject=" + areaOfObject + ", contractLenght=" + contractLenght
                + ", dateOfObject=" + dateOfObject + ", typeHouseholdCover=" + typeHouseholdCover + ", typeObject="
                + typeObject + "]";
    }

    
}
