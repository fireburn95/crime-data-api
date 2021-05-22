package com.example.crimedatarest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Crime {

  private String category;
  private Location location;
  private String context;
  private OutcomeStatus outcomeStatus;
  private String month;

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  public String getContext() {
    return context;
  }

  public void setContext(String context) {
    this.context = context;
  }

  public OutcomeStatus getOutcomeStatus() {
    return outcomeStatus;
  }

  @JsonProperty("outcome_status")
  public void setOutcomeStatus(OutcomeStatus outcomeStatus) {
    this.outcomeStatus = outcomeStatus;
  }

  public String getMonth() {
    return month;
  }

  public void setMonth(String month) {
    this.month = month;
  }
}
