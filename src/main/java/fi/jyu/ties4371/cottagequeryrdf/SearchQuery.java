package fi.jyu.ties4371.cottagequeryrdf;

import java.util.Date;

public class SearchQuery {

    private int numberOfPeople;

    private int numberOfBedRooms;

    private float distanceToLake;

    private float distanceToNearestCity;

    private String cityName;

    private String dateOfArrival;

    private int durationOfStay;

    private int shift;

    private boolean availability;

    public SearchQuery() {
        this.availability = true;
    }


    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public SearchQuery setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
        return this;
    }

    public int getNumberOfBedRooms() {
        return numberOfBedRooms;
    }

    public SearchQuery setNumberOfBedRooms(int numberOfBedRooms) {
        this.numberOfBedRooms = numberOfBedRooms;

        return this;
    }

    public float getDistanceToLake() {
        return distanceToLake;
    }

    public SearchQuery setDistanceToLake(float distanceToLake) {
        this.distanceToLake = distanceToLake;
        return this;
    }

    public float getDistanceToNearestCity() {
        return distanceToNearestCity;
    }

    public SearchQuery setDistanceToNearestCity(float distanceToNearestCity) {
        this.distanceToNearestCity = distanceToNearestCity;
        return this;
    }

    public String getCityName() {
        return cityName;
    }

    public SearchQuery setCityName(String cityName) {
        this.cityName = cityName;

        return this;
    }

    public String getDateOfArrival() {
        return dateOfArrival;
    }

    public SearchQuery setDateOfArrival(String dateOfArrival) {
        this.dateOfArrival = dateOfArrival;
        return this;
    }

    public int getDurationOfStay() {
        return durationOfStay;
    }

    public SearchQuery setDurationOfStay(int durationOfStay) {
        this.durationOfStay = durationOfStay;

        return this;
    }

    public int getShift() {
        return shift;
    }

    public SearchQuery setShift(int shift) {
        this.shift = shift;

        return this;
    }

    public boolean isAvailability() {
        return availability;
    }

    public SearchQuery setAvailability(boolean availability) {
        this.availability = availability;
        return this;
    }

    public boolean getAvailability() {
        return  this.availability;
    }
}
