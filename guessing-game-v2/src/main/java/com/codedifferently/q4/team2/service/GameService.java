package com.codedifferently.q4.team2.service;

import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class GameService {

  GameService() {}

  public int generateNumberToGuess() {
    return (int) (new Random().nextInt(10) + 1);
  }
}
