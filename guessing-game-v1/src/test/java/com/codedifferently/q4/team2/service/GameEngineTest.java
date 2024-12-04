package com.codedifferently.q4.team2.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class GameEngineTest {

  private GameEngine gameEngine = new GameEngine();

  @Test
  void testValidateGuessCorrect() {
    gameEngine.secretNumber = 5;
    int correctGuess = 5;
    assertTrue(gameEngine.validateGuess(correctGuess));
  }

  @Test
  void testValidateGuessIncorrect() {
    gameEngine.secretNumber = 5;
    boolean isValid = gameEngine.validateGuess(3);
    assertFalse(isValid, "Guess should be incorrect");
  }
}
