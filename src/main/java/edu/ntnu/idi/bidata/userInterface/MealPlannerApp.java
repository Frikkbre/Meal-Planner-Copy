package edu.ntnu.idi.bidata.userInterface;

import edu.ntnu.idi.bidata.entity.Ingredient;
import edu.ntnu.idi.bidata.entity.Recipe;
import edu.ntnu.idi.bidata.registry.CookBook;
import edu.ntnu.idi.bidata.registry.FoodStorage;
import edu.ntnu.idi.bidata.util.InputHandler;
import edu.ntnu.idi.bidata.util.PrintHandler;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

/**
 * The {@code MealPlannerApp} class is responsible for managing the meal planning application.
 * It provides a menu that calls methods from {@link FoodStorage} and {@link CookBook}.
 * <p>
 * This class interacts with {@link InputHandler} for potential user input handling
 * and uses a {@link FoodStorage} object and a {@link CookBook} object to store ingredients and recipes.
 * </p>
 *
 * @version 1.0
 * @since 22.10.2024
 * @author Frikk Brændsrød
 */
public class MealPlannerApp {

  private Scanner inputScanner;
  private FoodStorage foodStorage;
  private CookBook cookBook;
  private InputHandler inputHandler;
  private boolean running;

  /**
   * Constructs a new MealPlannerApp object.
   * Initializes the application by adding initial ingredients and recipes.
   */
  public MealPlannerApp() {
    this.inputScanner = new Scanner(System.in);
    this.foodStorage = new FoodStorage(this);
    this.cookBook = new CookBook(inputHandler);
    this.inputHandler = new InputHandler(inputScanner);
    this.running = true;

    initializeApplication(foodStorage, cookBook, this);
    startApplication(this, inputScanner, foodStorage, cookBook, running);
  }
  /**
   * Initializes the application by adding initial ingredients and recipes.
   *
   * @param foodStorage the food storage object
   * @param cookBook    the cook book object
   * @param mealPlannerApp the meal planner app object
   */
  public static void initializeApplication(FoodStorage foodStorage, CookBook cookBook, MealPlannerApp mealPlannerApp) {
    foodStorage.addInitIngredient();
    cookBook.addInitRecipe();
  }


  /**
   * Formats the date to a LocalDate object.
   * Used in the searchExpiredIngredients method.
   *
   * @param year  the year
   * @param month the month
   * @param day   the day
   * @return the formatted date
   */
  public LocalDate formatDate(int year, int month, int day) {
    if (year < 0 || year > 2099 || month < 0 || month > 12 || day < 0 || day > 32) {
      throw new IllegalArgumentException("Date format did not reach requirements, Year: 0-2099, Month: 0-12, Day: 0-32");
    }
    return LocalDate.of(year, month, day);
  }


  /**
   * Starts the application by providing a menu with options.
   * The user can choose to add, remove, search, or show ingredients and recipes.
   * The user can also check for expired ingredients.
   *
   * @param mealPlannerApp the meal planner app object
   * @param inputScanner   the input scanner
   * @param foodStorage    the food storage object
   * @param cookBook       the cook book object
   * @param running        the running boolean
   */
  public void startApplication(MealPlannerApp mealPlannerApp, Scanner inputScanner, FoodStorage foodStorage, CookBook cookBook, boolean running) {
  //public void startApplication(){

    while (running) {
      PrintHandler.printMainMenuOption();
      int inputChoice = InputHandler.intInput();


      switch (inputChoice) {
        case 1:
          PrintHandler.printMenuIngredientOption();
          int ingredientChoice = InputHandler.intInput();
          switch (ingredientChoice) {
            case 1:
              PrintHandler.printString("What is the name of the ingredient?");
              String ingredientNameInput = InputHandler.stringInput();

              PrintHandler.printString("What type of ingredient is it?");
              String ingredientType = InputHandler.stringInput();

              PrintHandler.printString("What does the ingredient cost?");
              float ingredientPrice = InputHandler.floatInput();

              PrintHandler.printString("How many/much do you have?");
              float ingredientAmount = InputHandler.floatInput();

              PrintHandler.printString("What unit is it?, 1 = kg, 2 = g, 3 = liter, 4 = pieces");
              int ingredientUnitChoice = InputHandler.intInput();

              PrintHandler.printString("What year does it expire? (xxxx)");
              int ingredientExpirationYear = InputHandler.intInput();

              PrintHandler.printString("What month does it expire? (xx)");
              int ingredientExpirationMonth = InputHandler.intInput();

              PrintHandler.printString("What day does it expire? (xx)");
              int ingredientExpirationDay = InputHandler.intInput();

              try {
                Ingredient newIngredient = new Ingredient(ingredientNameInput, ingredientType, ingredientPrice,
                    ingredientAmount, ingredientUnitChoice, ingredientExpirationYear,
                    ingredientExpirationMonth, ingredientExpirationDay);

                foodStorage.addIngredient(newIngredient);
              } catch (IllegalArgumentException e) {
                PrintHandler.printString(e.getMessage());
              }
              break;

            case 2:
              PrintHandler.printString("What is the name of the ingredient you want to remove?");
              String ingredientName = InputHandler.stringInput();

              PrintHandler.printString("How much/many do you want to remove?");
              int amountToRemove = InputHandler.intInput();

              try{
                foodStorage.removeIngredient(ingredientName, amountToRemove);
              } catch (IllegalArgumentException e) {
                PrintHandler.printString(e.getMessage());
              }
              break;

            case 3:
              PrintHandler.printString("What is the name of the ingredient you want to search for?");
              ingredientName = InputHandler.stringInput();

              try{
                foodStorage.searchIngredient(ingredientName);
              } catch (IllegalArgumentException e) {
                PrintHandler.printString(e.getMessage());
              }
              break;

            case 4:
              foodStorage.showSortedIngredients();
              break;

            case 5:
              PrintHandler.printString("What date do you want to check for expired ingredients?");
              PrintHandler.printString("Year:");
              int inputYear = InputHandler.intInput();

              PrintHandler.printString("Month:");
              int inputMonth = InputHandler.intInput();

              PrintHandler.printString("Day:");
              int inputDay = InputHandler.intInput();

              LocalDate date = LocalDate.of(inputYear, inputMonth, inputDay);
              try{
                foodStorage.showExpiredIngredients(date);
              } catch (IllegalArgumentException e) {
                PrintHandler.printString(e.getMessage());
              }
              break;

          }
          break;

        case 2:

        PrintHandler.printMenuRecipeOption();
          int recipeChoice = InputHandler.intInput();
          switch (recipeChoice) {
            case 1:
              PrintHandler.printString("Enter recipe name: ");
              String recipeName = InputHandler.stringInput();

              PrintHandler.printString("Enter recipe description: ");
              String recipeDescription = InputHandler.stringInput();

              PrintHandler.printString("Enter recipe instructions: ");
              String recipeInstructions = InputHandler.stringInput();

              PrintHandler.printString("How many ingredients does the recipe have?");
              int numberOfIngredients = InputHandler.intInput();

              HashMap<String, Integer> recipeIngredients = new HashMap<>();
              for (int i = 0; i < numberOfIngredients; i++) {
                PrintHandler.printString("Enter ingredient name: ");
                String ingredientName = InputHandler.stringInput();

                PrintHandler.printString("Enter ingredient amount: ");
                int ingredientAmount = InputHandler.intInput();

                recipeIngredients.put(ingredientName, ingredientAmount);
              }

              // Pass the collected data to CookBook
              try {
                cookBook.addRecipe(recipeName, recipeDescription, recipeIngredients, recipeInstructions);
              } catch (IllegalArgumentException e) {
                PrintHandler.printString(e.getMessage());
              }
              break;

            case 2:
              PrintHandler.printString("What is the name of the recipe you want to remove?");
              String recipeNameRemove = InputHandler.stringInput();
              try{
                cookBook.removeRecipe(recipeNameRemove);
              } catch (IllegalArgumentException e) {
                PrintHandler.printString(e.getMessage());
              }
              break;

            case 3:
              PrintHandler.printString("What is the name of the recipe you want to search for?");
              String searchRecipeName = InputHandler.stringInput();
              try{
                cookBook.searchRecipe(searchRecipeName);
              } catch (IllegalArgumentException e) {
                PrintHandler.printString(e.getMessage());
              }
              break;

            case 4:
              cookBook.showAllRecipes();
              break;
          }
          break;
          case 3:
            cookBook.showAllRecipes();
            PrintHandler.printString("Which recipe do you want to cook today?");
            String recipeName = InputHandler.stringInput();

            try{
              cookBook.cookRecipe(recipeName, foodStorage);
            } catch (IllegalArgumentException e) {
              PrintHandler.printString(e.getMessage());
            }

        case 0:
          running = false;
          PrintHandler.exitProgram();
          break;
        default:
          PrintHandler.invalidInput();
      }
    }
  }
}