package com.codedifferently.q4.team2.model;

public class Player {
  private int playerId;
  private String playerName;

  Player(int playerId, String playerName) {
    this.playerId = playerId;
    this.playerName = playerName;
  }

  public String getPlayerName() {
    return playerName;
  }

  public void setPlayerName(String playerName) {
    this.playerName = playerName;
  }

  public int getPlayerId() {
    return playerId;
  }

  public void setPlayerId(int playerId) {
    this.playerId = playerId;
  }
}
