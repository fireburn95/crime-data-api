package com.example.crimedatarest;

public class Location {

  private double latitude;
  private double longitude;
  private String postcode;

  public Location() {
  }

  public Location(String postcode, double latitude, double longitude) {
    this.postcode = postcode;
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  public String getPostcode() {
    return postcode;
  }

  public void setPostcode(String postcode) {
    this.postcode = postcode;
  }
}
