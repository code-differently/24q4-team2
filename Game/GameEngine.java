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
  // Getter for isStarted
  public boolean isStarted() {
    return isStarted; 
  }

  // Getter for isGenerator
  public int getNumGenerator() {
    return numGenerator;
  }
}