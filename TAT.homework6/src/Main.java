import route.Checkpoint;
import route.RouteReader;
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
  private static final int BUS_PASSENGERS_NUMBER = 20;

  /**
   * Creates a list of moving ways.
   * @return moving ways
   */
  private static ArrayList<Tour> setMovingWays() {
    ArrayList<Tour> movingWays = new ArrayList<>();
    movingWays.add(new Car());
    movingWays.add(new Bus(BUS_PASSENGERS_NUMBER));
    movingWays.add(new Bicycle());
    movingWays.add(new OnFoot());
    return movingWays;
  }

  /**
   * Reads checkpoints from file.
   * @param checkpoints array to handle checkpoints
   * @return true if successfully read, otherwise false
   */
  private static boolean readCheckpoints(ArrayList<Checkpoint> checkpoints) {
    RouteReader reader = new RouteReader();
    try {
      checkpoints.addAll(reader.readRoute(FILE_TO_READ));
    } catch (FileNotFoundException e) {
      System.out.println("Error: can't find file!");
      return false;
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return false;
    }
    return true;
  }

  /**
   * Passes the route by all moving ways.
   * @param args command line parameters
   */
  public static void main(String[] args) {
    ArrayList<Checkpoint> checkpoints = new ArrayList<>();
    ArrayList<Tour> movingWays = setMovingWays();
    if (readCheckpoints(checkpoints)) {
      for (Checkpoint checkpoint : checkpoints) {
        for (Tour way : movingWays) {
          way.moveTo(checkpoint);
        }
      }
      System.out.println("Statistics:");
      for (Tour way : movingWays) {
        System.out.println("for " + way.getName() + ":");
        System.out.println(way.getStatistics());
      }
    }
  }
}
