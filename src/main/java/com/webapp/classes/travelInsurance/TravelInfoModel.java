package com.webapp.classes.travelInsurance;

import com.webapp.classes.enums ;
// enum TypeTravelPolicy {
//     INDIVIDUAL,
//     FAMILY,
//     STUDENT,
//     GROUP,
//     BUSINESS
// }

// enum TypeCover {
//     VISA,
//     CLASSIC,
//     CLASSIC_PLUS
// }

public class TravelInfoModel {
    public enums.TypeTravelPolicy type;
    public enums.TypeCoverTRA cover;
    private int days;
    private String country;
    private int numPeople;
    private boolean isbelow18;
    private boolean isabove65;

    public TravelInfoModel() {
        this.days = 3;
    }

    public TravelInfoModel(enums.TypeTravelPolicy type, enums.TypeCoverTRA cover, int days, String country, int numPeople, boolean isbelow18,
            boolean isabove65) {
        this.type = type;
        this.cover = cover;
        this.days = days;
        this.country = country;
        this.numPeople = numPeople;
        this.isbelow18 = isbelow18;
        this.isabove65 = isabove65;
    }

    public enums.TypeTravelPolicy getType() {
        return type;
    }

    public void setType(enums.TypeTravelPolicy type) {
        this.type = type;
    }

    public enums.TypeCoverTRA getCover() {
        return cover;
    }

    public void setCover(enums.TypeCoverTRA cover) {
        this.cover = cover;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isIsbelow18() {
        return isbelow18;
    }

    public void setIsbelow18(boolean isbelow18) {
        this.isbelow18 = isbelow18;
    }

    public boolean isIsabove65() {
        return isabove65;
    }

    public void setIsabove65(boolean isabove65) {
        this.isabove65 = isabove65;
    }

    public int getNumPeople() {
        return numPeople;
    }

    public void setNumPeople(int numPeople) {
        this.numPeople = numPeople;
    }

}