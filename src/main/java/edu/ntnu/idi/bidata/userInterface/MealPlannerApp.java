package edu.ntnu.idi.bidata.userInterface;

import edu.ntnu.idi.bidata.FoodStorage;
import edu.ntnu.idi.bidata.entity.Ingredient;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public class MealPlannerApp {
  /**
   * Should have fields like HashMap(key = ingredient, value = amount) used for recipes.
   * other fields like
   * <p></p>
   * take userInput here? add food and such. yes
   */

  public static void startApplication() {
    Scanner inputScanner = new Scanner(System.in);
    FoodStorage foodStorage = new FoodStorage();
    boolean running = true;

    while (running) {

      System.out.println("What do you want to do?");
      System.out.println("1 = Modify ingredient");
      System.out.println("2 = Modify recipe");
      System.out.println("3 = exit the program");

      int inputChoice = inputScanner.nextInt();
      inputScanner.nextLine();

      switch (inputChoice) {
        case 1:
          System.out.println("1 = Add ingredient");
          System.out.println("2 = Remove ingredient");
          System.out.println("3 = Search ingredient");
          int ingredientChoice = inputScanner.nextInt();
          inputScanner.nextLine();
          switch (ingredientChoice) {
            case 1:
              foodStorage.addIngredient();

              break;
            case 2:
              System.out.println("What is the name of the ingredient you want to remove?");
              String ingredientName = inputScanner.nextLine();

              System.out.println("How much/many do you want to remove?");
              int amountToRemove = inputScanner.nextInt();
              inputScanner.nextLine();

              foodStorage.removeIngredient(ingredientName, amountToRemove);

              break;
            case 3:
              System.out.println("What is the name of the ingredient you want to search for?");
              ingredientName = inputScanner.nextLine();

              foodStorage.searchIngredient(ingredientName);
              break;
          }
          break;

        case 2:

          System.out.println("1 = Add recipe");
          System.out.println("2 = remove recipe");
          System.out.println("3 = search recipe");
          System.out.println("What do you want to do with recipies?");
          int recipeChoice = inputScanner.nextInt();
          switch (recipeChoice) {
            case 1:
              //addRecipe();
              break;
            case 2:
              //removeRecipe();
              break;
            case 3:
              //searchRecipe();
              break;
          }
          break;
        case 3:
          running = false;
          System.out.println("Exiting the program");
          System.out.println("Have a nice day!");
          break;
        default:
          System.out.println("Invalid input");
      }
    }
  }
}