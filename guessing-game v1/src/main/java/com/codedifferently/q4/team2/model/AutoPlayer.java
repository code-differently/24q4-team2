package com.codedifferently.q4.team2.model;

public class AutoPlayer extends Player {
  AutoPlayer(int playerId, String playerName) {
    super(playerId, playerName);
  }

  public static int autoPlayerGuess() {
    return (int) (Math.random() * Difficulty.MEDIUM.value);
  }
}
