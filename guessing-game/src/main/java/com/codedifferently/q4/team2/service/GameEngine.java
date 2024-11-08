package com.codedifferently.q4.team2.service;

import com.codedifferently.q4.team2.model.Difficulty;
import java.util.Random;
import java.util.Scanner;

public class GameEngine {

  private Scanner console;
  private int secretNumber;
  boolean isGameOn;
  String playerName;

  public GameEngine() {
    this.console = new Scanner(System.in);
    this.secretNumber = -1;
    this.isGameOn = false;
    this.playerName = "";
  }

  public int generateNumberToGuess() {
    return (int) (new Random().nextInt(Difficulty.EASY.value) + 1);
  }

  public void start() {
    System.out.println("\n\n\n\n\n\n\n");
    System.out.println("*************************************************");
    System.out.println("********                                 ********");
    System.out.println("        Welcome to Guess Game - numMeCrazy");
    System.out.println("********                                 ********");
    System.out.println("*************************************************");
    System.out.println("***** Please select Game difficulty level: ******");
    System.out.println("{1}. \t Easy (1-10)");
    System.out.println("{2}. \t Medium (1-20)");
    System.out.println("{3}. \t Hard (1-50)");
    System.out.println("{0}. \t To exit");
    console = new Scanner(System.in);
    System.out.print("Enter 1, 2, 3 , or [ 0 to exit ]: \n");
    int difficulty = console.nextInt();
    System.out.println("*************************************************");
    exitGame(difficulty);
    Difficulty level = Difficulty.EASY;
    switch (difficulty) {
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
        break;
    }
    secretNumber = generateNumberToGuess();
    System.out.println("    You Selected " + level.name() + " difficulty level ");
    System.out.println("    Your Number GUESS must be Between 1 and " + level.value);
    System.out.println("*************************************************");
    System.out.print("Please enter your name : ");
    console = new Scanner(System.in);
    playerName = console.nextLine();
    System.out.println("Hi, " + playerName + "!");
    play();
  }

  void play() {
    int guessedNumber = 0;
    boolean isCorrect = false;
    while (!isGameOn) {
      guessedNumber = playerGuess(playerName);
      exitGame(guessedNumber);
      isCorrect = validateGuess(guessedNumber);
      String result = (isCorrect) ? "Correct, congratulations !" : "Incorrect";
      System.out.println("Your Guess is " + result);
      String message = (secretNumber >= guessedNumber) ? "greater" : "less";
      System.out.println("The expected number is  " + message + " than " + guessedNumber);
      if (guessedNumber == 0) {
        isGameOn = true;
      } else {
        isGameOn = false;
      }
      if (isCorrect) {
        System.out.println("\nNew secret number generated ");
        secretNumber = generateNumberToGuess();
      }
    }
  }

  private int playerGuess(String playerName) {
    System.out.print(playerName + ", Please enter your guess : or [ 0 to exit] ");
    int response = console.nextInt();
    return response;
  }

  boolean validateGuess(int guess) {
    return guess == secretNumber;
  }

  void exitGame(int exitCode) {
    if (exitCode == 0) {
      System.out.println("\n\n\n");
      System.out.println("Exiting the game .......");
      System.out.println("Thank you for playing - numMeCrazy");
      System.exit(exitCode);
    }
  }
}
