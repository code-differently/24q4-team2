package com.codedifferently.q4.team2;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

public class ExitGameTest {

  private int exitCode;

  public void exitGame() {
    if (exitCode == 0) {
      System.out.println("\n\n\n");
      System.out.println("Exiting the game .......");
      System.out.println("Thank you for playing - numMeCrazy");
    }
  }

  @Test
  public void testExitCodeOutput() {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream originalSystemOut = System.out;
    System.setOut(new PrintStream(outputStream));

    ExitGameTest instance = new ExitGameTest();

    instance.exitCode = 0;

    instance.exitGame();

    String output = outputStream.toString();

    assertTrue(output.contains("Exiting the game ......."));
    assertTrue(output.contains("Thank you for playing - numMeCrazy"));

    System.setOut(originalSystemOut);
  }
}
