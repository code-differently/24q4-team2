package com.codedifferently.q4.team2.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Scanner;

@Service

public class GameService {

    public class Player {
        private boolean isGameOn;
  protected Scanner console;      
  private int playerId;
  private String playerName;
  private LocalDateTime gameStartTime;
  private LocalDateTime gameEndTime;

  public Player(int playerId, String playerName) {
    this.playerId = playerId;
    this.playerName = playerName;
     }

     public void recordGameTime(LocalDateTime gameStartTime, LocalDateTime gameEndTime) {
        this.gameStartTime = gameStartTime;
        this.gameEndTime = gameEndTime;
     }
   }

   public String getPlayerName(String playerName) {
    
    Player player = new Player(0, playerName);
    
  if(player != null) {
  Scanner console = new Scanner(System.in); 
  console = new Scanner(System.in);

  }

    return playerName;
   }

 }
