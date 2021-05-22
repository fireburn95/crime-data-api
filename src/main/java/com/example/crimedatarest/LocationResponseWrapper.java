package com.example.crimedatarest;

public class LocationResponseWrapper {
  private Integer status;
  private Location location;

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Location getResult() {
    return location;
  }

  public void setResult(Location location) {
    this.location = location;
  }
}
