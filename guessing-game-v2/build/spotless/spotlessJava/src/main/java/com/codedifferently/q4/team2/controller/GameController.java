package com.codedifferently.q4.team2.controller;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class GameController {

  @GetMapping("/hello")
  public String helloWorld() {
    return "Hello World";
  }
}
