package com.codedifferently.q4.team2.model;

public class AutoPlayer extends Player {
  private int autoPlayerId;
  private String autoPlayerName;
  private int autoPlayerGuess;
  
  AutoPlayer(int autoPlayerId, String autoPlayerName) {
    super(autoPlayerId, autoPlayerName);
  }

  public void AutoPlayerId(int autoPlayerId) {
     this.autoPlayerId = autoPlayerId;
  }

  public void AutoPlayerGuess(int autoPlayerGuess) {
    this.autoPlayerGuess = autoPlayerGuess;
  }


  public static int getautoPlayerGuess() {
    return (int) (Math.random() * Difficulty.MEDIUM.value); //the medium enum is just a place holder
  }

  public void setAutoPlayerGuess() {
 this.autoPlayerGuess = autoPlayerGuess;
  }

  public int getAutoPlayerId() {
    return (int) (Math.random());
  }

  public void setAutoPlayerId() {
    this.autoPlayerId = autoPlayerId;
  }

  public String getAutoPlayerName() {
    return autoPlayerName;
  }

  public void setAutoPlayerName() {
    this.autoPlayerName = autoPlayerName;
  }
}
