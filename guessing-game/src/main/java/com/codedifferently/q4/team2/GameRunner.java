package com.codedifferently.q4.team2;

import java.util.Scanner;

import com.codedifferently.q4.team2.service.DualMode;
import com.codedifferently.q4.team2.service.GameEngine;
import com.codedifferently.q4.team2.service.SoloMode;

public class GameRunner {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("\n\n\n\n\n\n\n\n\n         Select Game Mode: \n");
        System.out.println("          {1}. Solo Mode\n");
        System.out.println("          {2}. Dual Mode\n\n\n\n\n");

        int choice = console.nextInt();

        GameEngine game;
        if (choice == 1) {
            game = new SoloMode(); // Start solo mode
        } else if (choice == 2) {
            game = new DualMode(); // Start dual mode
        } else {
            System.out.println("Invalid choice. Exiting game.");
            return;
        }

        game.start(); // Start the selected game mode
    }
}
