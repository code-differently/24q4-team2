package com.codedifferently.q4.team2.exception;

public class IllegalArgumentException extends RuntimeException {
    public IllegalArgumentException(String message) {
        super(message);
}
}

// Will throw IllegalArgumentException 
//if the player selects a difficulty level that is not in the range of valid options (1, 2, or 3).

// if (difficultyChoice < 1 || difficultyChoice > 3) {
//  throw new IllegalArgumentException("Invalid difficulty level selected. Please select 1, 2, or 3."); }

