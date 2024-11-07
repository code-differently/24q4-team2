package com.codedifferently.q4.team2;
import java.util.Random;
import java.util.Scanner;

public class NumMeCrazy {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        // Game Difficulty selection
        System.out.println("Welcome to the NumMeCrazy!");
        System.out.println("Choose a difficulty level:");
        System.out.println("1. Easy (1-10)");
        System.out.println("2. Medium (1-20)");
        System.out.println("3. Hard (1-50)");
        System.out.print("Enter 1, 2, or 3 to select difficulty level, or 0 to exit: ");
        
        int difficulty = scanner.nextInt();
        
        // Exit if user selects 0
        if (difficulty == 0) {
            System.out.println("Exiting the game.");
            return;
        }
    }
}