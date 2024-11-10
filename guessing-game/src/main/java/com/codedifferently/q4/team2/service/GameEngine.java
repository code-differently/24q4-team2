package com.codedifferently.q4.team2.service;

import com.codedifferently.q4.team2.model.Difficulty;
import com.codedifferently.q4.team2.model.LeaderboardEntry;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class GameEngine {

  private Scanner console;
  protected int secretNumber;
  boolean isGameOn;
  String playerName;
  private int attempts;
  Difficulty level = Difficulty.EASY;

  private Map<Difficulty, List<LeaderboardEntry>> leaderboard;

  public GameEngine() {
    this.console = new Scanner(System.in);
    this.secretNumber = -1;
    this.isGameOn = false;
    this.playerName = "";
    this.attempts = 0;

    // Initialize leaderboard for each difficulty
    leaderboard = new HashMap<>();
    leaderboard.put(Difficulty.EASY, new ArrayList<>());
    leaderboard.put(Difficulty.MEDIUM, new ArrayList<>());
    leaderboard.put(Difficulty.HARD, new ArrayList<>());
  }

  public int generateNumberToGuess() {
    return (int) (new Random().nextInt(Difficulty.EASY.value) + 1);
  }

  public void start() {
    System.out.println("\n\n\n\n\n\n\n");
    System.out.println("**************************************************");
    System.out.println("**************                      **************");
    System.out.println("              Welcome to numMeCrazy!");
    System.out.println("**************                      **************");
    System.out.println("**************************************************\n");
    System.out.println("****** Please select Game difficulty level: ******\n");
    System.out.println("{1}. \t Easy (1-10)");
    System.out.println("{2}. \t Medium (1-20)");
    System.out.println("{3}. \t Hard (1-50)");
    System.out.println("{0}. \t To exit");
    console = new Scanner(System.in);
    System.out.print("\nEnter 1, 2, 3\n   or\n0 to exit: \n");
    int difficulty = console.nextInt();
    System.out.println("\n\n\n\n\n\n\n");
    System.out.println("*************************************************");
    exitGame(difficulty);
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
    System.out.println("\n     You Selected " + level.name() + " difficulty level \n");
    System.out.println("*************************************************\n\n\n\n\n");
    System.out.print("Please enter your name :\n");
    console = new Scanner(System.in);
    playerName = console.nextLine();
    System.out.println("\n\n");
    System.out.println(
        "\n                 Hi, " + playerName + "!\n             Let's get Started!\n\n\n\n\n");
    System.out.println("  Your Number GUESS must be Between 1 and " + level.value + "\n");
    play();
  }

  void play() {
    int guessedNumber = 0;
    boolean isCorrect = false;
    while (!isGameOn) {
      guessedNumber = playerGuess(playerName);
      exitGame(guessedNumber);
      isCorrect = validateGuess(guessedNumber);

      // Increment attempts after each guess
      attempts++;

      String message = (secretNumber >= guessedNumber) ? "greater" : "less";
      String result =
          (isCorrect)
              ? "<<<Correct>>>\n              Congratulations!\n\n            It took "
                  + attempts
                  + " attempt(s)."

              : " Incorrect! \n    The expected number is "
                  + message
                  + " than "
                  + guessedNumber
                  + "\n                Try Again!\n";
      System.out.println(
          "\n\n\n                   " + guessedNumber + " is \n               " + result);
      if (guessedNumber == 0) {
        isGameOn = true;
      } else {
        isGameOn = false;
      }
      if (isCorrect) {
        // Update leaderboard if the attempt is a top score
        updateLeaderboard(level);
        System.out.println("\n         New secret number generated \n");
        secretNumber = generateNumberToGuess();
        attempts = 0;
      }
    }
  }

  private int playerGuess(String playerName) {
    System.out.print(
        "        "
            + playerName
            + ", Please enter your guess\n                    or\n                0 to exit: \n");
    int response = console.nextInt();
    return response;
  }

  boolean validateGuess(int guess) {
    return guess == secretNumber;
  }

  void exitGame(int exitCode) {
    if (exitCode == 0) {
      System.out.println("\n\n\n\n");
      System.out.println("            Thank you for playing");
      System.out.println("            *********************");
      System.out.println("            *    numMeCrazy!    *");
      System.out.println("            *********************\n");
      System.out.println(
          "                 Created by: \n             Oyeyemi Jimoh\n                 James Capparell\n             Hummad Tanweer\n                 Nile Jackson\n\n");
      ;
      System.out.println("Exiting the game ....\n\n");
      System.exit(exitCode);
    }
  }

  // Update the leaderboard for the given difficulty level
  private void updateLeaderboard(Difficulty level) {
    List<LeaderboardEntry> scores = leaderboard.get(level);

    // Add the current player's result to the leaderboard
    LeaderboardEntry newEntry = new LeaderboardEntry(playerName, attempts);
    scores.add(newEntry);

    // Sort the list based on the number of attempts (fewest first)
    scores.sort(Comparator.comparingInt(LeaderboardEntry::getAttempts));

    // Keep only the top 10 scores
    if (scores.size() > 5) {
      scores.remove(scores.size() - 1); // Remove the last (worst) score
    }

    displayLeaderboard(level);
  }

  // Display the leaderboard for a given difficulty level
  private void displayLeaderboard(Difficulty level) {
    List<LeaderboardEntry> scores = leaderboard.get(level);
    System.out.println("\n       Top 5 Attempts (" + level.name() + " Difficulty):");
    for (int i = 0; i < scores.size(); i++) {
      System.out.println("           " + (i + 1) + ". " + scores.get(i));
    }
  }
}
