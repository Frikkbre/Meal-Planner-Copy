
package edu.ntnu.idi.bidata;

import edu.ntnu.idi.bidata.userInterface.MealPlannerApp;

/**
 * The main starting point of your application. Let this class create the
 * instance of your main-class that starts your application.
 */
public class Main {

  private Main() {
    //MealPlannerApp mealPlannerApp = new MealPlannerApp();
    try{
      MealPlannerApp mealPlannerApp = new MealPlannerApp();
    } catch (Exception e) {
      System.out.println("An error occurred: " + e.getMessage());
    }
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