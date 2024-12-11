package com.codedifferently.q4.team2.service;

import org.springframework.core.task.TaskTimeoutException;

import org.springframework.stereotype.Service;

import com.codedifferently.q4.team2.model.Difficulty;

import org.springframework.util.StopWatch;

import java.time.LocalDateTime;

import java.util.Scanner;
import java.util.concurrent.TimeoutException;

import java.util.Random;

import java.time.Duration;


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
           
        public enum Difficulty {
            EASY, MEDIUM, HARD
        }

        private Difficulty level;
        private LocalDateTime gameStartTime;
        private LocalDateTime gameEndTime;
        private boolean isGameOn;
        private boolean isGuessCorrect;
        private long playTimeElapsed;
        private int playAttempts;
        private int playeScore;

        private static final long MAX_GUESS_TIME = 3000;

        public Play(Difficulty level) {
            this.level = level;
            this.isGameOn = false;
        }

        public void startGame() {
            this.gameStartTime = LocalDateTime.now();
            this.isGameOn = true;
            this.playAttempts = 0; 
        }

        private long calculatePlayTime(){
            if(gameStartTime != null && gameEndTime != null) {
               return Duration.between(gameStartTime, gameEndTime).toMillis(); 
            }
                        return 0;
        }
         
        public void endGame() {
            if (isGameOn) {
                this.gameEndTime = LocalDateTime.now();
                this.playTimeElapsed = calculatePlayTime();
                this.isGameOn = false;
                            }
                        }
           public void recordAttempt(long guessTime) throws TimeoutException {
            if (!isGameOn) {
                throw new IllegalStateException("Game is not in progress");
            }

             playAttempts++;

             if (guessTime > MAX_GUESS_TIME) {
                throw new TimeoutException("Guess took too long. Time limit exceeded.");
             }
           }

           public void updateScore(int points) {
            this.playeScore += points;
           }

          public int getPlayScore(int basePoints, int playAttempts) {
                int playScore = basePoints;
               int attemptPenalty = calculatePlayAttemptPenalty(playAttempts);
               playScore -= attemptPenalty;
               
               playScore = Math.max(0,playScore); //Added Math.max to avoid scores with negative integers
               
               return playScore;
               }
           }

           public int calculatePlayAttemptPenalty(int playAttempts) {
            switch (playAttempts) {
                case 1:
                case 2:
                case 3:
                  return 0;
                case 4:
                case 5:
                 return 20;
                default:
                 return 30;
            }
        }

    }
}
         
   
   





  
