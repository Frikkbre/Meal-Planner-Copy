
package edu.ntnu.idi.bidata;

import edu.ntnu.idi.bidata.userInterface.MealPlannerApp;

/**
 * The main starting point of your application. Let this class create the
 * instance of your main-class that starts your application.
 *
 * @version 1.0
 * @since 12.12.2024
 * @author Frikk Brændsrød
 */
public class Main {

  private Main() {
    MealPlannerApp mealPlannerApp = new MealPlannerApp();
  }

  /**
   * The main method of the application.
   *
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Main application = new Main();
  }
}