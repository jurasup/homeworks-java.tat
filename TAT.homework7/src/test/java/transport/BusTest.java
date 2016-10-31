package transport;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import route.Checkpoint;

import static junit.framework.Assert.assertTrue;

/**
 * Tests for Bus.
 * @see Bus
 */
public class BusTest {

  @Before
  public void setUp() throws Exception {

  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void positiveTimePasses() throws Exception {
    Bus bus = new Bus();
    Checkpoint initialCheckpoint = new Checkpoint(0.0, 0.0);
    bus.moveTo(initialCheckpoint);
    Checkpoint nextCheckpoint = new Checkpoint(10.0, 10.0);
    bus.moveTo(nextCheckpoint);
    assertTrue(bus.time() > 0);
  }

  @Test
  public void positiveCostIncreases() throws Exception {
    Bus bus = new Bus();
    Checkpoint initialCheckpoint = new Checkpoint(0.0, 0.0);
    bus.moveTo(initialCheckpoint);
    Checkpoint nextCheckpoint = new Checkpoint(10.0, 10.0);
    bus.moveTo(nextCheckpoint);
    assertTrue(bus.cost() > 0);
  }

  @Test
  public void positiveNameBus() throws Exception {
    Bus bus = new Bus();
    assertTrue(bus.getName().equals("Bus"));
  }

  @Test(expected = Exception.class)
  public void negativeBusZeroFuelConsumption() throws Exception {
    Bus bus = new Bus(0.0, 1.0, 1.0, 10);
  }

  @Test(expected = Exception.class)
  public void negativeBusZeroAverageSpeed() throws Exception {
    Bus bus = new Bus(1.0, 0.0, 1.0, 10);
  }

  @Test(expected = Exception.class)
  public void negativeBusZeroPassengersNumber() throws Exception {
    Bus bus = new Bus(1.0, 0.0, 1.0, 0);
  }

  @Test(expected = Exception.class)
  public void negativeBusNegativeFuelCost() throws Exception {
    Bus bus = new Bus(1.0, 1.0, -1.0, 10);
  }

  @Test(expected = Exception.class)
  public void negativeBusNegativeFuelConsumption() throws Exception {
    Bus bus = new Bus(-1.0, 1.0, 1.0, 10);
  }

  @Test(expected = Exception.class)
  public void negativeBusNegativeAverageSpeed() throws Exception {
    Bus bus = new Bus(1.0, -1.0, 1.0, 10);
  }

  @Test(expected = Exception.class)
  public void negativeBusNegativePassengersNumber() throws Exception {
    Bus bus = new Bus(1.0, 1.0, 1.0, -1);
  }

  @Test(expected = Exception.class)
  public void negativeBusInfiniteFuelConsumption() throws Exception {
    Bus bus = new Bus(Double.POSITIVE_INFINITY, 1.0, 1.0, 10);
  }

  @Test(expected = Exception.class)
  public void negativeBusInfiniteAverageSpeed() throws Exception {
    Bus bus = new Bus(1.0, Double.POSITIVE_INFINITY, 1.0, 10);
  }

  @Test(expected = Exception.class)
  public void negativeBusInfiniteFuelCost() throws Exception {
    Bus bus = new Bus(1.0, 1.0, Double.POSITIVE_INFINITY, 10);
  }

  @Test(expected = Exception.class)
  public void negativeBusInfiniteParameters() throws Exception {
    Bus bus = new Bus(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 10);
  }

  @Test(expected = Exception.class)
  public void negativeBusNanFuelConsumption() throws Exception {
    Bus bus = new Bus(Double.NaN, 1.0, 1.0, 10);
  }

  @Test(expected = Exception.class)
  public void negativeBusNanAverageSpeed() throws Exception {
    Bus bus = new Bus(1.0, Double.NaN, 1.0, 10);
  }

  @Test(expected = Exception.class)
  public void negativeBusNanFuelCost() throws Exception {
    Bus bus = new Bus(1.0, 1.0, Double.NaN, 10);
  }

  @Test(expected = Exception.class)
  public void negativeBusNanParameters() throws Exception {
    Bus bus = new Bus(Double.NaN, Double.NaN, Double.NaN, 10);
  }
}