package io.codewithrkc.trackercovid19v1.models;

public class CovidDataLocationWise {

    private String state;
    private String country;
    private int currentTotalCase;
    private int diffFromPrevDay;

    public int getDiffFromPrevDay() {
        return diffFromPrevDay;
    }

    public void setDiffFromPrevDay(int diffFromPrevDay) {
        this.diffFromPrevDay = diffFromPrevDay;
    }



    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getCurrentTotalCase() {
        return currentTotalCase;
    }

    public void setCurrentTotalCase(int currentTotalCase) {
        this.currentTotalCase = currentTotalCase;
    }



    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "CovidDataLocationWise{" +
                "state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", currentTotalCase=" + currentTotalCase +
                ", diffFromPrevDay=" + diffFromPrevDay +
                '}';
    }



}
