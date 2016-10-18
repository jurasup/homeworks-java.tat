import java.util.ArrayList;
import java.util.HashMap;

/**
 * Allows to get response delays for list of servers
 * @author Yury Suponev
 */
public class AvailabilityChecker {
  /**
   * Allows to get ping for each server from IP-list
   * @param ipList
   * @return list of servers with relevant pings
   */
  public HashMap<String, Integer> getDelays(ArrayList<String> ipList) {
    HashMap<String, Integer> serversWithResponses = new HashMap<>();
    PingRequester pingRequester = new PingRequester();
    for (String ip : ipList) {
      serversWithResponses.put(ip, Integer.valueOf(pingRequester.request()));
    }
    return serversWithResponses;
  }
}
