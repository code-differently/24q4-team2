package com.codedifferently.q4.team2.service;

import java.util.Random;

public class DualMode extends GameEngine {

    @Override
    public void start() {
        super.start();
        System.out.println("\n\n          Starting Dual Mode...\n");
        playAgainstCPU();
    }

    void playAgainstCPU() {
        int playerGuess = 0;
        int cpuGuess = 0;
        boolean playerCorrect = false;
        boolean cpuCorrect = false;

        // Player's turn
        while (!isGameOn) {
            // Player guesses
            playerGuess = playerGuess(playerName);
            exitGame(playerGuess);
            playerCorrect = validateGuess(playerGuess);

            // Increment attempts after each guess
            attempts++;

            String message = (secretNumber >= playerGuess) ? "greater" : "less";
            String result =
                    (playerCorrect)
                            ? "<<<Correct>>>\n              Congratulations!\n\n            It took "
                            + attempts
                            + " attempt(s)."
                            : " Incorrect! \n    The expected number is "
                            + message
                            + " than "
                            + playerGuess
                            + "\n                Try Again!\n";
            System.out.println("\n\n\n                   " + playerGuess + " is \n               " + result);

            if (playerGuess == 0) {
                isGameOn = true;
            }

            // CPU's turn (CPU guesses randomly)
            cpuGuess = new Random().nextInt(level.value) + 1;
            System.out.println("\n            CPU guessed: " + cpuGuess);

            cpuCorrect = validateGuess(cpuGuess);
            if (cpuCorrect) {
                System.out.println("              CPU guessed correctly!\n");
            }

            // Determine the winner
            if (playerCorrect && cpuCorrect) {
                System.out.println("         It's a tie! Both you and the CPU guessed correctly!");
                break;
            } else if (playerCorrect) {
                System.out.println("                "+playerName + " wins!");
                break;
            } else if (cpuCorrect) {
                System.out.println("CPU wins!");
                break;
            }

            // Continue if neither player has guessed correctly
            if (!playerCorrect && !cpuCorrect) {
                System.out.println("\nNeither you nor the CPU guessed correctly. Keep trying!");
            }
        }
    }
}