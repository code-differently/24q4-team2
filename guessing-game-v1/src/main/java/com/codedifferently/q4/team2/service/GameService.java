package com.codedifferently.q4.team2.service;

import org.springframework.stereotype.Service;

import com.codedifferently.q4.team2.model.Difficulty;

import org.springframework.util.StopWatch;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.Random;


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
        private Random random;

        AutoPlayer(int playerId, String playerName) {
          super(playerId, playerName);
          this.random = new Random();
        }
      
      public int getAutoPlayerId() {
          return random.nextInt(1000);
      }

      public int getAutoPlayerGuess(int maxRange) {

        return random.nextInt(maxRange + 1);
      }
    }


    public Player generatePlayer(String playerName) {
        if(playerName == null || playerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Player name cannot be empty");
        
        }
        int PlayerId = new Random().nextInt(10000);
        return new Player(new Random().nextInt(10000), playerName);
    }

    public AutoPlayer generateAutoPlayer() {
        int autoPlayerId = new Random().nextInt(1000);
        return new AutoPlayer(new Random().nextInt(1000), null);
    }

    public class Play {
        Difficulty level = Difficulty.EASY;
        private LocalDateTime gameStartTime;
        private LocalDateTime gameEndTime;
        private boolean isGameOn;
        private Long playTimeElapsed;
        private int playAttempts;
        private int playScore;

        public void recordGameTime(LocalDateTime gameStartTime, LocalDateTime gameEndTime) {
            this.gameStartTime = gameStartTime;
            this.gameEndTime = gameEndTime;
        }


    public Play(Long playTimeElapsed, int playAttempts, int playScore) {
        this.playTimeElapsed = playTimeElapsed; 
        this.playAttempts = playAttempts;
        this.playScore = playScore;
    }

    public void getPlayTimeElapsed() {
        StopWatch gameTimer = new StopWatch();

        try {
            gameTimer.start("Guess Attempt");

            
        }

     
    }



            
        
    }


}


  
