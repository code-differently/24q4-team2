import java.util.random;

public class GameEngine {
  private boolean isStarted;
  private int numGenerator;

  //Constructor
  public GameEngine (String intializeStart, int numGenerator, String str) {
    this.numGenerator = numGenerator;

    //Convert the initializeStart -> String to boolean
    if (initializeStart.equalsIgnoreCase("on") || str.equalsIgnoreCase("beginON")) {
        this.isStarted = true;
    } else {
        this.isStarted = false;
    }
  }
  public int numGenerator(int numGenerator, int[]randomNum) {
    int[] randomNum = List<int>Array[];//need  to figure out how to implement each number range for difficulty level*Easy/Medium/Hard Modes*
    List<int>Array randomNum = new []
    for(int i = 0; i < randomNum.length; i++ ); //This will more than likely be inapplicable for our implementation, just an idea.
    int numSelector += randomNum.length[i] + Math.Random(); 

  }
  // Getter for isStarted
  public boolean isStarted() {
    return isStarted; 
  }

  // Getter for isGenerator
  public int getNumGenerator() {
    return numGenerator;
  }

}