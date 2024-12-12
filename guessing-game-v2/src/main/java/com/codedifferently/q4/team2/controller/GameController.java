package com.codedifferently.q4.team2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codedifferently.q4.team2.model.Difficulty;
import com.codedifferently.q4.team2.model.InputData;
import com.codedifferently.q4.team2.service.GameEngine;

@RestController
@CrossOrigin(origins = "http//localhost:5173")
public class GameController {
  private GameEngine gameEngine = new GameEngine();


  public String helloWorld() {
    return "Hello World";
  }

  @GetMapping("/")
  public String Home() {
    return "Welcome to numMeCrazy";
  }

  @PostMapping("/guess")
  public String handleGuess(@RequestBody InputData inputData) {
    String gameId = inputData.getGameId();
    String receivedText = inputData.getText();
    String message = gameEngine.makeGuess(gameId, receivedText);
    System.out.println("Received entry: NILE " + receivedText);
    return ("""
            **************************************************
            **************                      **************
            ************* Welcome to numMeCrazy! *************
            **************                      **************
            **************************************************
            ****** Please select Game difficulty level: ******
            {1}. \t Easy (1-10)
             """ + receivedText);
  }

  @PostMapping("/games")
  public ResponseEntity<StartGameResponse> startGame() {
    String gameId = gameEngine.startGame();
    return ResponseEntity.ok(StartGameResponse.builder().gameId(gameId).build();
    );
  }
}
