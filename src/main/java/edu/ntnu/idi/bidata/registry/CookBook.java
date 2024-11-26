package edu.ntnu.idi.bidata.registry;

import edu.ntnu.idi.bidata.entity.Recipe;
import edu.ntnu.idi.bidata.userInterface.MealPlannerApp;
import edu.ntnu.idi.bidata.util.PrintHandler;

import java.util.HashMap;
import java.util.Scanner;

public class CookBook {

  private HashMap<String, Recipe> recipeRegister = new HashMap<>();

  static Scanner inputScanner = new Scanner(System.in);

  public CookBook() {
  }

  public HashMap<String, Recipe> getRecipeRegister() {
    return recipeRegister;
  }

  public void addRecipe() {

    HashMap <String, Integer> numberOfIngredientsMap = new HashMap<>();

    System.out.println(("Enter recipe name: "));
    String recipeName = inputScanner.nextLine();

    System.out.println("Enter recipe description: ");
    String recipeDescription = inputScanner.nextLine();

    System.out.println("How many ingredients does the recipe have?");
    int numberOfIngredients = inputScanner.nextInt();
    inputScanner.nextLine();

    for (int i = 0; i < numberOfIngredients; i++) {
      System.out.println("Enter ingredient name: ");
      String ingredientName = inputScanner.nextLine();
      System.out.println("Enter ingredient amount: ");
      Integer ingredientAmount = inputScanner.nextInt();
      inputScanner.nextLine();

      numberOfIngredientsMap.put(ingredientName, ingredientAmount);
    }

    System.out.println("Enter recipe instructions: ");
    String recipeInstructions = inputScanner.nextLine();

    Recipe recipe = new Recipe(recipeName, recipeDescription, numberOfIngredientsMap, recipeInstructions);

    recipeRegister.put(recipeName, recipe);
  }

  public void removeRecipe(String recipeName) {
    recipeRegister.remove(recipeName);
  }

  public void searchRecipe(String recipeName) {
    for (Recipe recipe : recipeRegister.values()) {
      if (recipe.getRecipeName().equalsIgnoreCase(recipeName)) {
        PrintHandler.printRecipe(recipe);
      }
    }
  }

  public void showAllRecipes() {
    for (Recipe recipeRegister : recipeRegister.values()) {
      PrintHandler.printRecipe(recipeRegister);
    }
  }
}