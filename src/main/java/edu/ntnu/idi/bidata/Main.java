package edu.ntnu.idi.bidata;

import edu.ntnu.idi.bidata.userInteraction.MealPlannerApp;

/**
 * The main starting point of your application. Let this class create the
 * instance of your main-class that starts your application.
 */
public class Main {

  public Main() {
    MealPlannerApp mealPlannerApp = new MealPlannerApp();
    mealPlannerApp.startApplication();
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
