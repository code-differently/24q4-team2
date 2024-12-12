package com.codedifferently.q4.team2.model;

import lombok.Data;

@Data
public class InputData {
  private String text;
  private String gameId;

  // Getter and Setter for text
  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
