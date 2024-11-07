package com.codedifferently.q4.team2;

import com.codedifferently.q4.team2.service.GameEngine;

public class GameLauncher {
  public static void main(String[] args) {
    GameEngine gameEngine = new GameEngine();
    gameEngine.start();
  }
}
