/**
 * Defines an entry point
 * @author Yury Suponev
 */
public class Hello {
  /**
   * Displays "Hello, NAME" where NAME is command line parameter or displays
   * "Hello, World" if there is no parameter. Prints out a warning message
   * if parameters count is more than 1. 
   * @param args Command line parameters
   */
  public static void main(String[] args) {
    if (args.length > 1) {
	  System.out.println("You should use only one word or use quotes. Example: \"John Johnson\"");
	}
	else if (args.length == 0) {
	  System.out.println("Hello, World");
	}
	else {
	  System.out.println("Hello, " + args[0]);
	}	
  }
}