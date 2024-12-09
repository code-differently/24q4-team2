package com.codedifferently.q4.team2.model;

public class Play {
    private Long playTimeElapsed;
    private int playAttempts;
    private int playScore;
     private boolean isGameOn;

    public Play(Long playTimeElapsed, int playAttempts, int playScore) {
        this.playTimeElapsed = playTimeElapsed; 
        this.playAttempts = playAttempts;
        this.playScore = playScore;
    }

    public Long getPlayTimeElapsed() {
        return playTimeElapsed;
    }

    public void setPlayTimeElapsed(Long playTimeElapsed) {
        this.playTimeElapsed = playTimeElapsed;
      }

    public int getPlayAttempts() {
        return playAttempts;
    }
    public void setPlayAttempts(int playAttempts) {
        this.playAttempts = playAttempts;
    }

    public int getPlayScore() {
        return playScore;
    }

    public void setPlayScore(int playScore) {
        this.playScore = playScore;
    }
    
}



