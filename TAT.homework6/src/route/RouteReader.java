package route;

import java.util.List;

/**
 * Allows to read checkpoints.
 * @author Yury Suponev
 */
public abstract class RouteReader {
  /**
   * Reads checkpoints coordinates.
   * @return List of checkpoints
   */
  public abstract List<Checkpoint> readRoute() throws Exception;
}
