package com.example.hotelsearch2h.models;

public class Room {
    private int id;
    private String hotelName;
    private String city;
    private String postalCode;
    private String country;
    private int numberOfSingleBeds;
    private int numberOfDoubleBeds;
    private boolean hasWifi;
    private boolean hasRoomService;
    private boolean bigBathroom;

    private int costPerNight;

    public Room() {

    }


    public Room(int id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isHasWifi() {
        return hasWifi;
    }

    public void setHasWifi(boolean hasWifi) {
        this.hasWifi = hasWifi;
    }

    public boolean isHasRoomService() {
        return hasRoomService;
    }

    public void setHasRoomService(boolean hasRoomService) {
        this.hasRoomService = hasRoomService;
    }

    public boolean isbigBathroom() {
        return bigBathroom;
    }


    public int getNumberOfSingleBeds() {
        return numberOfSingleBeds;
    }

    public void setNumberOfSingleBeds(int numberOfSingleBeds) {
        this.numberOfSingleBeds = numberOfSingleBeds;
    }

    public int getNumberOfDoubleBeds() {
        return numberOfDoubleBeds;
    }

    public void setNumberOfDoubleBeds(int numberOfDoubleBeds) {
        this.numberOfDoubleBeds = numberOfDoubleBeds;
    }

    public boolean getbigBathroom() {
        return bigBathroom;
    }

    public void setbigBathroom(boolean bigBathroom) {
        this.bigBathroom = bigBathroom;
    }


    public int getCostPerNight() {
        return costPerNight;
    }

    public void setCostPerNight(int costPerNight) {
        this.costPerNight = costPerNight;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        String data = "Hotel: " + getHotelName() + " - Location:" + getCity() + ", " + getCountry() + " - Single Beds: " + getNumberOfSingleBeds() + " - Double Beds: " + getNumberOfDoubleBeds();

        return data;
    }

}

