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
   *<p></p>
   * take userInput here? add food and such. yes
   */

  public static void startApplication(){
    Scanner inputScanner = new Scanner(System.in);
    FoodStorage foodStorage = new FoodStorage();
    boolean running = true;

    while(running) {

      System.out.println("What do you want to do?");
      System.out.println("1 = Add ingredient");
      System.out.println("2 = remove ingredient");
      System.out.println("3 = search ingredient");
      System.out.println("4 = find a recipe");
      System.out.println("5 = exit the program");

      int inputChoice = inputScanner.nextInt();
      inputScanner.nextLine();

      switch (inputChoice) {
        case 1:
          System.out.println("How many different ingredients do you want to add?");
          int howManyIngredients = inputScanner.nextInt();
          inputScanner.nextLine();

          for (int indexOfInput = 0; indexOfInput < howManyIngredients; indexOfInput++) {
            System.out.println("What is the name of the ingredient?");
            String ingredientName = inputScanner.nextLine();

            System.out.println("What type of ingredient is it?");
            String ingredientType = inputScanner.nextLine();

            System.out.println("What does the ingredient cost?");
            float ingredientPrice = inputScanner.nextFloat();
            inputScanner.nextLine();

            System.out.println("How many/much do you have?");
            float ingredientAmount = inputScanner.nextFloat();
            inputScanner.nextLine();

            System.out.println("What unit is it?, 1 = kg, 2 = g, 3 = liter, 4 = pieces");
            int ingredientUnitChoice = inputScanner.nextInt();

            System.out.println("What year does it expire? (xxxx)");
            int ingredientExpirationYear = inputScanner.nextInt();
            inputScanner.nextLine();

            System.out.println("What month does it expire? (xx)");
            int ingredientExpirationMonth = inputScanner.nextInt();
            inputScanner.nextLine();

            System.out.println("What day does it expire? (xx)");
            int ingredientExpirationDay = inputScanner.nextInt();
            inputScanner.nextLine();

            Ingredient ingredient = new Ingredient(ingredientName, ingredientType, ingredientPrice,
                ingredientAmount, ingredientUnitChoice, ingredientExpirationYear,
                ingredientExpirationMonth, ingredientExpirationDay);

            foodStorage.addIngredient(ingredient); // Add ingredient to food storage

            ingredient.displayInformation();

            try { //TODO - Write AI declaration
              TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
              System.out.println("Sleep failed: " + e.getMessage());
              Thread.currentThread().interrupt(); // Reset the interrupt flag
            }
          }
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
        case 4:
          //findRecipe();
          break;
        case 5:
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