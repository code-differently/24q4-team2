package com.codedifferently.q4.team2.model;

public class LeaderboardEntry {
  private String playerName;
  private int attempts;

  public LeaderboardEntry(String playerName, int attempts) {
    this.playerName = playerName;
    this.attempts = attempts;
  }

  public String getPlayerName() {
    return playerName;
  }

  public int getAttempts() {
    return attempts;
  }

  @Override
  public String toString() {
    return playerName + " - " + attempts + " attempt(s)";
  }
}
