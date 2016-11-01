package route;

/**
 * Represents checkpoint containing two coordinates.
 * @author Yury Suponev
 */
public class Checkpoint {
  private Double firstCoordinate;
  private Double secondCoordinate;

  /**
   * Creates checkpoint with two coordinates from parameters.
   * @param firstCoordinate
   * @param secondCoordinate
   */
  public Checkpoint(Double firstCoordinate, Double secondCoordinate) throws Exception {
    if (firstCoordinate == null || firstCoordinate.isNaN() || firstCoordinate.isInfinite() ||
            secondCoordinate == null || secondCoordinate.isNaN() || secondCoordinate.isInfinite()) {
      throw new Exception("Error: Invalid checkpoint coordinates!");
    }
    this.firstCoordinate = firstCoordinate;
    this.secondCoordinate = secondCoordinate;
  }

  /**
   * Allows to get first coordinate value.
   * @return first coordinate
   */
  public Double getFirstCoordinate() {
    return firstCoordinate;
  }

  /**
   * Allows to get second coordinate value.
   * @return second coordinate
   */
  public Double getSecondCoordinate() {
    return secondCoordinate;
  }

  /**
   * Checks equivalency of two checkpoints.
   * @param other checkpoint to compare to
   * @return true if checkpoints are equal, otherwise return false
   */
  @Override
  public boolean equals(Object other) {
    if (other == null) {
      return false;
    } else if (other == this) {
      return true;
    }
    if (other instanceof Checkpoint) {
      Checkpoint otherCheckpoint = (Checkpoint)other;
      return firstCoordinate.equals(otherCheckpoint.getFirstCoordinate()) &&
              secondCoordinate.equals(otherCheckpoint.getSecondCoordinate());
    } else {
      return false;
    }
  }
}
