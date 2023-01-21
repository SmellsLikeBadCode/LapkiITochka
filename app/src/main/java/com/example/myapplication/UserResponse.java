package com.example.myapplication;

public class UserResponse {

    private int id;
    private String address;
    private String animalType;
    private String date;
    private String gender;
    private String name;
    private String description;
    private boolean isLost;
    private String filename;
    private float geoLat;
    private float geoLon;
    private boolean lost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isLost() {
        return isLost;
    }

    public void setLost(boolean lost) {
        isLost = lost;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public float getGeoLat() {
        return geoLat;
    }

    public void setGeoLat(float geoLat) {
        this.geoLat = geoLat;
    }

    public float getGeoLon() {
        return geoLon;
    }

    public void setGeoLon(float geoLon) {
        this.geoLon = geoLon;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", animalType='" + animalType + '\'' +
                ", date='" + date + '\'' +
                ", gender='" + gender + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", isLost=" + isLost +
                ", filename='" + filename + '\'' +
                ", geoLat=" + geoLat +
                ", geoLon=" + geoLon +
                ", lost=" + lost +
                '}';
    }
}
