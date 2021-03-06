package transport;

import route.Checkpoint;

import java.util.ArrayList;

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
   */
  void moveTo(Checkpoint next);

  /**
   * Provides getting statistics (total cost and time).
   * @return statistics
   */
  ArrayList<Double> getStatistics();

  /**
   * Provides getting name of the transport making tour.
   * @return name
   */
  String getName();
}
