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

  public void addInitRecipe() {
    HashMap<String, Integer> recipeIngredients = new HashMap<>();
    recipeIngredients.put("Rice", 4);
    recipeIngredients.put("Onion", 1);
    recipeIngredients.put("Eggs", 4);
    Recipe friedRice = new Recipe("Fried Rice", "Fried rice with eggs and onion", recipeIngredients, "Cook rice, fry eggs and onion, mix together");
    recipeRegister.put(friedRice.getRecipeName(), friedRice);

    recipeIngredients.put("spaghetti", 200); //Grams
    recipeIngredients.put("meat", 400); //Grams
    recipeIngredients.put("Bolognese sauce", 1); //Bolognese sauce
    Recipe spaghettiBolognese = new Recipe("Spaghetti Bolognese", "Spaghetti with meat and tomato sauce", recipeIngredients, "Cook spaghetti, fry meat, add Bolognese sauce");
    recipeRegister.put(spaghettiBolognese.getRecipeName(), spaghettiBolognese);


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