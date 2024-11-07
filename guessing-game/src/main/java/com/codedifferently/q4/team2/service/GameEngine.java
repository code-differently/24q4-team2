package com.codedifferently.q4.team2.service;

import java.util.Scanner;

public class GameEngine {

  private Scanner console;

  public GameEngine() {
    this.console = new Scanner(System.in);
  }

  public void start() {

    System.out.println("Welcome to the NumMeCrazy!");
        System.out.println("Choose a difficulty level:");
        System.out.println("1. Easy (1-10)");
        System.out.println("2. Medium (1-20)");
        System.out.println("3. Hard (1-50)");
        System.out.print("Enter 1, 2, or 3 to select difficulty level, or 0 to exit: ");
  }
}
