package com.webapp.classes;

enum TypeTravelPolicy {
    INDIVIDUAL,
    FAMILY,
    STUDENT,
    GROUP,
    BUSINESS
}

enum TypeCover {
    VISA,
    CLASSIC,
    CLASSIC_PLUS
}

public class TravelInfo {
    private TypeTravelPolicy type;
    private TypeCover cover;
    private int days;
    private String country;
    
    public TravelInfo() {
    }

    public TravelInfo(TypeTravelPolicy type, TypeCover cover, int days, String country) {
        this.type = type;
        this.cover = cover;
        this.days = days;
        this.country = country;
    }

    public TypeTravelPolicy getType() {
        return type;
    }

    public void setType(TypeTravelPolicy type) {
        this.type = type;
    }

    public TypeCover getCover() {
        return cover;
    }

    public void setCover(TypeCover cover) {
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


}