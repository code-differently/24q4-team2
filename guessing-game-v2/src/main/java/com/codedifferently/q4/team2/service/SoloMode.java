package com.codedifferently.q4.team2.service;

public class SoloMode extends GameEngine {

  @Override
  public void start() {
    super.start();
    System.out.println("\n\n          Starting Solo Mode...\n");
    play();
  }
}
