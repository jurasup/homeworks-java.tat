/**
 * Defines an entry point
 * @author Yury Suponev
 */
public class CommandLineParams {
  /**
   * Displays command line parameters in reverse order
   * @param args Command line parameters
   */
  public static void main(String[] args) {
    for (int i = args.length - 1; i >= 0; i--) {
      System.out.println("Parameter " + (args.length - i) + " = " + args[i]);
    }
  }
}