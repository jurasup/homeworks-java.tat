package route;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Allows to read checkpoints from defined file.
 * @author Yury Suponev
 */
public class RouteReader {
  private final String INVALID_COORDINATES = "Error: Invalid checkpoint coordinates!";
  private final String EMPTY_FILE = "Error: File is empty!";
  private final String CLOSED_ROUTE = "Error: Can't move around closed route.";

  /**
   * Reads checkpoints coordinates from file
   * @param fileToRead file to read from
   * @return List of checkpoints
   * @see Checkpoint
   * @throws FileNotFoundException if file doesn't exist
   * @throws NumberFormatException
   * @throws Exception if coordinates format is invalid or route is closed curve
   */
  public ArrayList<Checkpoint> readRoute(String fileToRead) throws FileNotFoundException,
                                                                   NumberFormatException,
                                                                   Exception {
    Scanner scanner = new Scanner(new FileReader(new File(fileToRead)));
    CheckpointValidator validator = new CheckpointValidator();
    ArrayList<Checkpoint> route = new ArrayList<>();
    while (scanner.hasNext()) {
      String line = scanner.nextLine();
      String[] coordinates = line.split(" ");
      if (!validator.validate(line)) {
        throw new Exception(INVALID_COORDINATES);
      }
      Checkpoint checkpoint = new Checkpoint(Double.parseDouble(coordinates[0]),
                                             Double.parseDouble(coordinates[1]));
      route.add(checkpoint);
    }
    if (route.isEmpty()) {
      throw new Exception(EMPTY_FILE);
    } else if (route.get(0).equals(route.get(route.size() - 1))) {
      throw new Exception(CLOSED_ROUTE);
    }
    return route;
  }
}
