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
     Scanner console = null;
     try {
        if (playerName == null || playerName.trim().isEmpty()) {
            console = new Scanner(System.in);

            System.out.println("Please enter a valid player name:");
            playerName = console.nextLine();

            if (playerName == null || playerName.trim().isEmpty()) {
                throw new IllegalArgumentException("Player name cannot be empty");
            }
        }

        Player player = new Player(0, playerName);

        return player.playerName;
     } catch (IllegalArgumentException e) {

        System.out.println("Invalid input: " + e.getMessage());
        return null;
  } catch (Exception e) {
    System.out.println("An unexpected error occurred: " + e.getMessage());
    return null;
  } finally {
    if (console != null) {
        try {
            console.close();
        } catch (Exception e) {
            System.out.println("Error closing scanner: " + e.getMessage());
        }
    }
  }

    }

    public class AutoPlayer extends Player {
        AutoPlayer(int playerId, String playerName) {
          super(playerId, playerName);
        }
      
      public int getAutoPlayerId(int autoPlayerId) {
          autoPlayerId = (int)Math.random();
        return autoPlayerId;
      }

  }
}


  
