package route;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Allows to read checkpoints from defined file.
 * @author Yury Suponev
 */
public class FileRouteReader {
  private final String EMPTY_FILE = "Error: File is empty!";
  private final String CLOSED_ROUTE = "Error: Can't move around closed route.";
  private final String FILE_TO_READ;

  /**
   * Creates reader with defined file to read from.
   * @param fileToRead
   */
  public FileRouteReader(final String fileToRead) {
    FILE_TO_READ = fileToRead;
  }

  /**
   * Reads checkpoints coordinates from file
   * @return List of checkpoints
   * @see Checkpoint
   * @throws Exception if coordinates format is invalid or route is closed curve
   */
  public List<Checkpoint> readRoute() throws FileNotFoundException,
                                             NumberFormatException,
                                             Exception {
    Scanner scanner = new Scanner(new FileReader(new File(FILE_TO_READ)));
    CheckpointValidator validator = new CheckpointValidator();
    ArrayList<Checkpoint> route = new ArrayList<>();
    while (scanner.hasNext()) {
      String line = scanner.nextLine();
      String[] coordinates = line.split(" ");
      if (validator.validate(line)) {
        validator.validate(line);
        Checkpoint checkpoint = new Checkpoint(Double.parseDouble(coordinates[0]),
                Double.parseDouble(coordinates[1]));
        route.add(checkpoint);
      }
    }
    if (route.isEmpty()) {
      throw new Exception(EMPTY_FILE);
    } else if (route.get(0).equals(route.get(route.size() - 1))) {
      throw new Exception(CLOSED_ROUTE);
    }
    return route;
  }
}
