
package com.codedifferently.q4.team2.controller;

import com.codedifferently.q4.team2.model.Difficulty;
import com.codedifferently.q4.team2.service.GameEngine;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8081") 
public class GameController {

    private final GameEngine gameEngine;

    public GameController(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    @PostMapping("/start")
    public ResponseEntity<String> startGame(
        @RequestParam(defaultValue = "EASY") Difficulty difficulty,
        @RequestParam(defaultValue = "Anonymous") String playerName
    ) {
        String gameId = gameEngine.startGame(playerName, difficulty);
        return ResponseEntity.ok(gameId);
    }

    @PostMapping("/guess")
    public ResponseEntity<String> makeGuess(
        @RequestBody GuessRequest guessRequest
    ) {
        
        GameEngine.GameSession session = gameEngine.getActiveSession(guessRequest.getGameId());
        
        if (session == null) {
            return ResponseEntity.badRequest().body("Invalid game session");
        }

        int guess = Integer.parseInt(guessRequest.getText());
        
        
        boolean isCorrect = gameEngine.validateGuess(guess);
        
        
        String message = prepareGuessResponse(guess, isCorrect, session);
        
        return ResponseEntity.ok(message);
    }

    
    private String prepareGuessResponse(int guess, boolean isCorrect, GameEngine.GameSession session) {
        if (isCorrect) {
            return String.format("Congratulations %s! You guessed the correct number %d in %d attempts!", 
                session.playerName, guess, session.attempts + 1);
        } else {
            String hint = (guess < session.secretNumber) ? "higher" : "lower";
            return String.format("Incorrect! Try a %s number. Attempt %d", hint, session.attempts + 1);
        }
    }

    
    public static class GuessRequest {
        private String text;
        private String gameId;

        
        public String getText() { return text; }
        public void setText(String text) { this.text = text; }
        public String getGameId() { return gameId; }
        public void setGameId(String gameId) { this.gameId = gameId; }
    }
}