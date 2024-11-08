package com.codedifferently.q4.team2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DifficultyTest {

  private Difficulty level;

  public enum Difficulty {
    EASY(10),
    MEDIUM(20),
    HARD(50);

    public final int value;

    private Difficulty(int value) {
      this.value = value;
    }
  }

  @BeforeEach
  public void setup() {
    level = Difficulty.EASY;
  }

  @Test
  public void testDifficultyLevel() {
    // Arrange
    int difficultyInput = 1;

    switch (difficultyInput) {
      case 1:
        level = Difficulty.EASY;
        break;
      case 2:
        level = Difficulty.MEDIUM;
        break;
      case 3:
        level = Difficulty.HARD;
        break;
      default:
        level = null; // Here for handling invalid input
        break;
    }

    assertEquals(Difficulty.EASY, level, "Difficulty should be EASY when input is 1");

    difficultyInput = 2;
    switch (difficultyInput) {
      case 1:
        level = Difficulty.EASY;
        break;
      case 2:
        level = Difficulty.MEDIUM;
        break;
      case 3:
        level = Difficulty.HARD;
        break;
      default:
        level = null;
        break;
    }

    assertEquals(Difficulty.MEDIUM, level, "Difficulty should be MEDIUM when input is 2");

    difficultyInput = 3;
    switch (difficultyInput) {
      case 1:
        level = Difficulty.EASY;
        break;
      case 2:
        level = Difficulty.MEDIUM;
        break;
      case 3:
        level = Difficulty.HARD;
        break;
      default:
        level = null;
        break;
    }
    assertEquals(Difficulty.HARD, level, "Difficulty should be HARD when input is 3");
  }
}
