package com.ayushtyagi.coronameter;

public class CountryModel {
    private String flag, country, cases, deaths, todaydeaths, todaycases, recovered, active, critical;



    public CountryModel(String flag, String country, String cases, String deaths, String todaydeaths, String todaycases, String recovered, String active, String critical) {
        this.flag = flag;
        this.country = country;
        this.cases = cases;
        this.deaths = deaths;
        this.todaydeaths = todaydeaths;
        this.todaycases = todaycases;
        this.recovered = recovered;
        this.active = active;
        this.critical = critical;
    }

    public String getFlag() {
        return flag;
    }

    public String getCountry() {
        return country;
    }

    public String getCases() {
        return cases;
    }

    public String getDeaths() {
        return deaths;
    }

    public String getTodaydeaths() {
        return todaydeaths;
    }

    public String getTodaycases() {
        return todaycases;
    }

    public String getRecovered() {
        return recovered;
    }

    public String getActive() {
        return active;
    }

    public String getCritical() {
        return critical;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public void setTodaydeaths(String todaydeaths) {
        this.todaydeaths = todaydeaths;
    }

    public void setTodaycases(String todaycases) {
        this.todaycases = todaycases;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public void setCritical(String critical) {
        this.critical = critical;
    }
}
