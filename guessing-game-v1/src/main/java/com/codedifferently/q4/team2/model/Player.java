package com.codedifferently.q4.team2.model;

import java.time.LocalDateTime;
import java.time.Duration;

public class Player {
  private int playerId;
  private String playerName;
  private LocalDateTime gameStartTime;
  private LocalDateTime gameEndTime;

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

  public LocalDateTime getStartGame() {
    return gameStartTime;
  }


  public void setStartGame() {
    this.gameStartTime = LocalDateTime.now();
  }

  public LocalDateTime getEndGame() {
    return gameEndTime;
  }

  public void setEndGame() {
    this.gameEndTime = LocalDateTime.now();
  }

}
