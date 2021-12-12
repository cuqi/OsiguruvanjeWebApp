package com.webapp.classes.cascoInsurance;

import com.webapp.classes.enums;

public class CascoInfoModel {
    
    private enums.TypeCascoPolicy typeCascoPolicy;
    private enums.TypeValue typeValue;
    private boolean windows;
    private int vehiclePrice;
    private int franchise;

    public CascoInfoModel() {

    }

    public CascoInfoModel(enums.TypeCascoPolicy typeCascoPolicy, enums.TypeValue typeValue, boolean windows, int vehiclePrice, int franchise) {
        this.typeCascoPolicy = typeCascoPolicy;
        this.typeValue = typeValue;
        this.windows = windows;
        this.vehiclePrice = vehiclePrice;
        this.franchise = franchise;
    }

    public enums.TypeCascoPolicy getTypeCascoPolicy() {
        return typeCascoPolicy;
    }

    public void setTypeCascoPolicy(enums.TypeCascoPolicy typeCascoPolicy) {
        this.typeCascoPolicy = typeCascoPolicy;
    }

    public enums.TypeValue getTypeValue() {
        return typeValue;
    }

    public void setTypeValue(enums.TypeValue typeValue) {
        this.typeValue = typeValue;
    }

    public boolean isWindows() {
        return windows;
    }

    public void setWindows(boolean windows) {
        this.windows = windows;
    }

    public int getVehiclePrice() {
        return vehiclePrice;
    }

    public void setVehiclePrice(int vehiclePrice) {
        this.vehiclePrice = vehiclePrice;
    }

    public int getFranchise() {
        return franchise;
    }

    public void setFranchise(int franchise) {
        this.franchise = franchise;
    }

    

}
