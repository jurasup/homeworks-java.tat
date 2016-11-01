package transport;

import route.Checkpoint;

/**
 * Allows to track a tour:
 * Moving to the next checkpoint;
 * Maintaining general statistics for tour (total cost and time).
 * @author Yury Suponev
 */
public interface Tour {
  /**
   * Provides moving to the next checkpoint.
   * @param next checkpoint
   * @throws Exception while moving to the nonexistent checkpoint
   */
  void moveTo(Checkpoint next) throws Exception;

  /**
   * Provides getting resulting time of the tour.
   * @return time
   */
  double time();

  /**
   * Provides getting resulting cost of the tour.
   * @return cost
   */
  double cost();

  /**
   * Provides getting name of the transport making tour.
   * @return name
   */
  String getName();
}
