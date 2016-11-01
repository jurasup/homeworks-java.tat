import route.Checkpoint;
import route.FileRouteReader;
import transport.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Defines an entry point for the application providing tracking tour for the
 * different ways of moving.
 * @author Yury Suponev
 */
public class Main {
  private static final String FILE_TO_READ = "checkpoints.txt";

  /**
   * Creates a list of moving ways.
   * @return moving ways
   */
  private ArrayList<Tour> setMovingWays() throws Exception {
    ArrayList<Tour> movingWays = new ArrayList<>();
    movingWays.add(new Car());
    movingWays.add(new Bus());
    movingWays.add(new Bicycle());
    movingWays.add(new OnFoot());
    return movingWays;
  }

  /**
   * Provides getting a tour by all moving ways.
   * @param movingWays
   * @param checkpoints route for tour
   */
  private void tour(ArrayList<Tour> movingWays, ArrayList<Checkpoint> checkpoints) {
    for (Checkpoint checkpoint : checkpoints) {
      for (Tour way : movingWays) {
        try {
          way.moveTo(checkpoint);
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
      }
    }
  }

  /**
   * Provides printing statistics of tour.
   * @param movingWays
   */
  private void printStatistics(ArrayList<Tour> movingWays) {
    System.out.println("Statistics:");
    for (Tour way : movingWays) {
      System.out.println("for " + way.getName() + ":");
      System.out.println("Total cost: " + way.cost() + "  Total time: " + way.time());
    }
  }

  /**
   * Passes the route by all moving ways.
   * @param args command line parameters
   */
  public static void main(String[] args) {
    Main launcher = new Main();
    ArrayList<Checkpoint> checkpoints = new ArrayList<>();
    FileRouteReader reader = new FileRouteReader(FILE_TO_READ);
    try {
      ArrayList<Tour> movingWays = launcher.setMovingWays();
      checkpoints.addAll(reader.readRoute());
      launcher.tour(movingWays, checkpoints);
      launcher.printStatistics(movingWays);
    } catch (NumberFormatException e) {
      System.out.println("Error: incorrect format of the coordinates!");
    } catch (FileNotFoundException e) {
      System.out.println("Error: file is not found!");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
