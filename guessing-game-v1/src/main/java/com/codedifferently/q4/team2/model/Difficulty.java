package com.codedifferently.q4.team2.model;

public enum Difficulty {
  EASY(10),
  MEDIUM(20),
  HARD(50);

  public final int value;

  private Difficulty(int value) {
      this.value = value;
  }
}