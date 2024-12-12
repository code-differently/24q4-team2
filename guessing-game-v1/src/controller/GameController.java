package com.codedifferently.q4.team2.controller;

import com.codedifferently.q4.team2.model.Difficulty;
import com.codedifferently.q4.team2.service.GameEngine;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/game")
@CrossOrigin(origins = "http://localhost:8081")  
public class GameController {

    private GameEngine gameEngine;

    
    public GameController() {
        this.gameEngine = new GameEngine();
    }

    
    @PostMapping("/start")
    public ResponseEntity<Map<String, Object>> startGame(@RequestBody Map<String, String> payload) {
        
        String difficultyStr = payload.get("difficulty");
        String playerName = payload.get("playerName");

   

       
        Difficulty difficulty = Difficulty.valueOf(difficultyStr.toUpperCase());
        
        
        gameEngine.level = difficulty;
        gameEngine.playerName = playerName;
        gameEngine.secretNumber = gameEngine.generateNumberToGuess(difficulty);
        gameEngine.attempts = 0;

        
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Game started for " + playerName + " at " + difficulty + " level");
        response.put("maxRange", difficulty.value);

        return ResponseEntity.ok(response);
    }

    
    @PostMapping("/guess")
    public ResponseEntity<Map<String, Object>> processGuess(@RequestBody Map<String, String> payload) {
        int guessedNumber = Integer.parseInt(payload.get("text"));
        
        
        boolean isCorrect = gameEngine.validateGuess(guessedNumber);
        
        
        Map<String, Object> response = new HashMap<>();
        response.put("correct", isCorrect);
        response.put("attempts", gameEngine.attempts + 1);  
        
        String message;
        if (isCorrect) {
            message = "Congratulations! You guessed the number in " + (gameEngine.attempts + 1) + " attempts.";
            
            gameEngine.secretNumber = gameEngine.generateNumberToGuess(gameEngine.level);
            gameEngine.attempts = 0;
        } else {
            String hint = (gameEngine.secretNumber > guessedNumber) ? "higher" : "lower";
            message = "Incorrect! Try a " + hint + " number.";
            gameEngine.attempts++;
        }
        
        response.put("message", message);
        
        return ResponseEntity.ok(response);
    }

    @GetMapping("/leaderboard")
    public ResponseEntity<Map<String, Object>> getLeaderboard(@RequestParam("difficulty") String difficultyStr) {
        Difficulty difficulty = Difficulty.valueOf(difficultyStr.toUpperCase());
        
        
        Map<String, Object> response = new HashMap<>();
        response.put("difficulty", difficulty);
       
        
        return ResponseEntity.ok(response);

    }
}
