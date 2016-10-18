import java.util.ArrayList;
import java.util.Collection;

/**
 * Allows to control communication quality
 * @author Yury Suponev
 */
public class CommunicationQualitySupervisor {
  /**
   * Provides getting the highest ping among the list
   * @param pings list of pings
   * @return highest ping
   */
  public Integer findHighestPing(Collection<Integer> pings) {
    ArrayList<Integer> pingList = new ArrayList<>();
    pingList.addAll(pings);
    Integer highestPing = pingList.get(0);
    for (Integer ping : pingList) {
      if (ping.intValue() > highestPing.intValue()) {
        highestPing = ping;
      }
    }
    return highestPing;
  }
}
