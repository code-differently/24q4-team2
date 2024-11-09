package com.codedifferently.q4.team2;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

public class ExitGameTest {

  private int exitCode;

  public void exitGame() {
    if (exitCode == 0) {
      System.out.println("\n\n\n\n");
      System.out.println("            Thank you for playing");
      System.out.println("            *********************");
      System.out.println("            *    numMeCrazy!    *");
      System.out.println("            *********************\n");
      System.out.println(
          "                 Created by: \n             Oyeyemi Jimoh\n                 James Capparell\n             Hummad Tanweer\n                 Nile Jackson\n\n");
      System.out.println("Exiting the game ....\n\n");
      System.exit(exitCode); // System.exit is called when exitCode is 0
    }
  }

  @Test
  public void testExitCodeZero() {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream originalSystemOut = System.out;
    System.setOut(new PrintStream(outputStream));

    ExitGameTest instance = new ExitGameTest();

    instance.exitCode = 0;

    instance.exitGame();

    String output = outputStream.toString();

    assertTrue(output.contains("Thank you for playing"));
    assertTrue(output.contains("numMeCrazy!"));
    assertTrue(output.contains("Created by:"));
    assertTrue(output.contains("Exiting the game ...."));

    System.setOut(originalSystemOut);
  }

  @Test
  public void testExitCodeNonZero() {

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream originSystemOut = System.out;
    System.setOut(new PrintStream(outputStream));

    ExitGameTest instance = new ExitGameTest();
    instance.exitCode = 1;

    instance.exitGame();

    String output = outputStream.toString();

    assertFalse(output.contains("Thank you for playing"));
    assertFalse(output.contains("numMeCrazy!"));
    assertFalse(output.contains("Created by:"));
    assertFalse(output.contains("Exiting the game ...."));

    System.setOut(originalSystemOut);
  }

  @Test
  public void testSystemExitCalledWithExitCodeZero() {

    ExitGameTest instance = new ExitGameTest();
    SecurityManager securityManager = System.getSecurityManager();
    if (securityManager != null) {
      System.setSecurityManager(new SecurityManager());
    }

    try {

      ExitGameTest spyInstance = spy(instance);
      doNothing().when(spyInstance).exitGame(0);

      spyInstance.exitGame();

      verify(spyInstance).exitGame(0);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
