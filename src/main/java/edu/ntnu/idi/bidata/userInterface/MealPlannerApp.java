package edu.ntnu.idi.bidata.userInterface;

import edu.ntnu.idi.bidata.entity.Ingredient;
import edu.ntnu.idi.bidata.registry.CookBook;
import edu.ntnu.idi.bidata.registry.FoodStorage;
import edu.ntnu.idi.bidata.util.InputHandler;
import edu.ntnu.idi.bidata.util.PrintHandler;

import java.time.LocalDate;
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
    LocalDate formattedDate = LocalDate.of(year, month, day);
    return formattedDate;
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

              Ingredient newIngredient = new Ingredient(ingredientNameInput, ingredientType, ingredientPrice,
                  ingredientAmount, ingredientUnitChoice, ingredientExpirationYear,
                  ingredientExpirationMonth, ingredientExpirationDay);

              foodStorage.addIngredient(newIngredient);

              break;
            case 2:
              PrintHandler.printString("What is the name of the ingredient you want to remove?");
              String ingredientName = InputHandler.stringInput();

              PrintHandler.printString("How much/many do you want to remove?");
              int amountToRemove = InputHandler.intInput();

              foodStorage.removeIngredient(ingredientName, amountToRemove);

              break;
            case 3:
              PrintHandler.printString("What is the name of the ingredient you want to search for?");
              ingredientName = InputHandler.stringInput();

              foodStorage.searchIngredient(ingredientName);
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

              foodStorage.showExpiredIngredients(date);
              break;
          }
          break;

        case 2:

        PrintHandler.printMenuRecipeOption();
          int recipeChoice = InputHandler.intInput();
          switch (recipeChoice) {
            case 1:
              cookBook.addRecipe();
              break;
            case 2:
              //removeRecipe();
              break;
            case 3:
              PrintHandler.printString("What is the name of the recipe you want to search for?");
              String recipeName = InputHandler.stringInput();
              cookBook.searchRecipe(recipeName);
              break;
            case 4:
              cookBook.showAllRecipes();
              break;
          }
          break;

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