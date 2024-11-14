# 24q4-team2
Project repo for team 2

## numMeCrazy Game Project

### Functions of this program

* A player chooses between "Solo Mode" and "Dual Mode" accompanied by a difficulty select before playing. There is also a back select on Difficulty Select and a Exit Game select on the Mode Select.

* Solo mode consists of having a random number generated for the player to guess. The player takes as many attepmts as they need to guess the right number and will be given hints after every attempt. There will also be a way exit the game if the player does not want to continue. 

* Dual Mode is a mode similar to Solo Mode but instead the player will be guessing against a AI player. player and AI will take turns guessing the number until one guesses correctly.

### End Condition

* Once a player guesses correctly, the player will be prompted with the correct number, number of attempts and a decision to play again or exit the game to mode select.

### CLI Configuration 
* Users who prefer to play numMeCrazy in their terminal by using the following instructions;
* Ensure that you have JDK 17 installed by running java --version 
* Then run the gradle shadowjar command to make sure you have the proper gradle configuration.
* After using gradle shadowjar users should run the following command, java -jar build/libs/guessing-game-1.0-all.jar . This command will generate the numMeCrazy interface, which allows users to enjoy our game from the terminal.

* Alternatively, users can navigate to the GameLauncher.java file and right click. After right clicking on this file select the "Run Java" option and the game will generate that way as well. 


Project Diagram:


<img src="images/Screenshot 2024-11-11 at 10.06.48 AM.png" height=250 width=400/>






