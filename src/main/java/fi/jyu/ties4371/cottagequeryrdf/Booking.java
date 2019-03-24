package fi.jyu.ties4371.cottagequeryrdf;

import java.util.Date;

public class Booking  {

    private String name;

    private int numberOfPeople;

    private int numberOfBedRooms;

    private float distanceToLake;

    private float distanceToNearestCity;

    private String cityName;

    private Date dateOfArrival;

    private int durationOfStay;

    private int shift;

    private int id;

    private String image;

    private Address address;

    private String addressString;

    public Booking() {
        this.id = (int) (Math.random()* 99999999);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public int getNumberOfBedRooms() {
        return numberOfBedRooms;
    }

    public void setNumberOfBedRooms(int numberOfBedRooms) {
        this.numberOfBedRooms = numberOfBedRooms;
    }

    public float getDistanceToLake() {
        return distanceToLake;
    }

    public void setDistanceToLake(float distanceToLake) {
        this.distanceToLake = distanceToLake;
    }

    public float getDistanceToNearestCity() {
        return distanceToNearestCity;
    }

    public void setDistanceToNearestCity(float distanceToNearestCity) {
        this.distanceToNearestCity = distanceToNearestCity;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getDateOfArrival() {
        return dateOfArrival;
    }

    public void setDateOfArrival(Date dateOfArrival) {
        this.dateOfArrival = dateOfArrival;
    }

    public int getDurationOfStay() {
        return durationOfStay;
    }

    public void setDurationOfStay(int durationOfStay) {
        this.durationOfStay = durationOfStay;
    }

    public int getShift() {
        return shift;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    public String getAddressString() {
        return addressString;
    }

    public void setAddressString(String addressString) {
        this.addressString = addressString;
    }
}
