package com.codedifferently.q4.team2.model;

public class Play {
    private Long playTimeElapsed;
    private int playAttempts;
    private int playScore;
     private boolean isGameOn;
     private boolean isGuessCorrect;
     private int UpdatedScore;
     

    public Play(Long playTimeElapsed, int playAttempts, int playScore, boolean isGameOn, boolean isGuessCorrect) {
        this.playTimeElapsed = playTimeElapsed; 
        this.playAttempts = playAttempts;
        this.playScore = playScore;
        this.UpdatedScore = UpdatedScore; 
    }

    public boolean isGameOn() {
        return isGameOn;
    }

    public void isGameOn(boolean isGameOn) {
        this.isGameOn = isGameOn;
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

    public boolean getIsGuessCorrect() {
        return isGuessCorrect;
    }

    public void SetIsGuessCorrect(boolean isGuessCorrect) {
        this.isGuessCorrect = isGuessCorrect;
    }

    public int getUpdatedScore() {
        return UpdatedScore;
    }

    public void setUpdatedScore(int UpdatedScore) {
        this.UpdatedScore = UpdatedScore;
    }





}



