package com.codedifferently.q4.team2.controller;

import com.codedifferently.q4.team2.model.InputData;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class GameController {

  @GetMapping("/hello")
  public String helloWorld() {
    return "Hello World";
  }

  @GetMapping("/")
  public String Home() {
    return "Welcome to numMeCrazy";
  }

  @PostMapping("/guess")
  public String handleGuess(@RequestBody InputData inputData) {
    String receivedText = inputData.getText();
    System.out.println("Answer Submitted: " + receivedText);
    return ("Answer Submitted: " + receivedText);
  }
}
