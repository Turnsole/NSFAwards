package com.lastminutedevice.nsfawards.models;

/**
 * Represents an individual award.
 *
 * Designed for Gson deserialization.
 */
public class Award {
    private String agency;
    private String awardeeCity;
    private String awardeeName;
    private String awardeeStateCode;
    private Double fundsObligatedAmt;
    private String id;
    private String piFirstName;
    private String piLastName;
    private String date;
    private String title;

    public Award() {}

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getAwardeeCity() {
        return awardeeCity;
    }

    public void setAwardeeCity(String awardeeCity) {
        this.awardeeCity = awardeeCity;
    }

    public String getAwardeeName() {
        return awardeeName;
    }

    public void setAwardeeName(String awardeeName) {
        this.awardeeName = awardeeName;
    }

    public String getAwardeeStateCode() {
        return awardeeStateCode;
    }

    public void setAwardeeStateCode(String awardeeStateCode) {
        this.awardeeStateCode = awardeeStateCode;
    }

    public Double getFundsObligatedAmt() {
        return fundsObligatedAmt;
    }

    public void setFundsObligatedAmt(Double fundsObligatedAmt) {
        this.fundsObligatedAmt = fundsObligatedAmt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPiFirstName() {
        return piFirstName;
    }

    public void setPiFirstName(String piFirstName) {
        this.piFirstName = piFirstName;
    }

    public String getPiLastName() {
        return piLastName;
    }

    public void setPiLastName(String piLastName) {
        this.piLastName = piLastName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
