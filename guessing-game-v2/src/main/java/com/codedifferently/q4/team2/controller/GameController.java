package com.codedifferently.q4.team2.controller;

import com.codedifferently.q4.team2.service.GameService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class GameController {

  GameService gameService;

  GameController(GameService gameService) {
    this.gameService = gameService;
  }

  @GetMapping("/hello")
  public String helloWorld() {
    return "Hello World";
  }

  @GetMapping("/")
  public String Home() {
    return "Welcome to numMeCrazy";
  }

  //   @GetMapping("/generate")
  //   public int generateNumberToGuess() {
  //     return (int) (new Random().nextInt(10) + 1);
  //   }

  @GetMapping("/generate")
  public int generateNumberToGuess() {
    return gameService.generateNumberToGuess();
  }

  @PostMapping("/easy")
  public String handleButton1(@RequestBody String option) {
    System.out.println("Easy Button clicked with value: " + option);
    return "Received value from Easy Button : " + option;
  }

  @PostMapping("/medium")
  public String handleButton2(@RequestBody String option) {
    System.out.println("Medium Button clicked with value: " + option);
    return "Received value from Medium Button : " + option;
  }

  @PostMapping("/hard")
  public String handleButton3(@RequestBody String option) {
    System.out.println("Hard Button clicked with value: " + option);
    return "Received value from Hard Button : " + option;
  }
}
