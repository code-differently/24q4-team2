package com.codedifferently.q4.team2;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.codedifferently.q4.team2.service.GameEngine;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameEngineTest {

  private GameEngine gameEngine;
  private ByteArrayOutputStream outputStream;
  private PrintStream originalSystemOut;
  private PrintStream mockPrintStream;

  @BeforeEach
  public void setUp() {

    gameEngine = new GameEngine();

    outputStream = new ByteArrayOutputStream();
    originalSystemOut = System.out;
    mockPrintStream = new PrintStream(outputStream);
    System.setOut(mockPrintStream);
  }

  @Test
  public void testExitGameWithExitCodeZero() {

    try {
      System.exit(0);
    } catch (SecurityException e) {

    }

    gameEngine.exitGame(0);

    String result = outputStream.toString();
    assertTrue(result.contains("Thank you for playing"));
    assertTrue(result.contains("numMeCrazy!"));
    assertTrue(result.contains("Created by:"));
    assertTrue(result.contains("Exiting the game ...."));
  }

  @Test
  public void testExitGameWithNonZeroExitCode() {

    gameEngine.exitGame(1);

    String result = outputStream.toString();
    assertTrue(result.isEmpty());
  }

  @AfterEach
  public void tearDown() {

    System.setOut(originalSystemOut);
  }
}
