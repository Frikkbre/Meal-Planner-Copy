package edu.ntnu.idi.bidata.registry;

import edu.ntnu.idi.bidata.entity.Recipe;
import edu.ntnu.idi.bidata.util.InputHandler;
import edu.ntnu.idi.bidata.util.PrintHandler;

import java.util.HashMap;
import java.util.Scanner;

public class CookBook {

  private HashMap<String, Recipe> recipeRegister = new HashMap<>();

  static Scanner inputScanner = new Scanner(System.in);

  public CookBook(InputHandler inputHandler) {
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

    PrintHandler.printString(("Enter recipe name: "));
    String recipeName = InputHandler.stringInput();

    PrintHandler.printString("Enter recipe description: ");
    String recipeDescription = InputHandler.stringInput();

    PrintHandler.printString("How many ingredients does the recipe have?");
    int numberOfIngredients = InputHandler.intInput();
    InputHandler.stringInput();

    for (int i = 0; i < numberOfIngredients; i++) {
      PrintHandler.printString("Enter ingredient name: ");
      String ingredientName = InputHandler.stringInput();
      PrintHandler.printString("Enter ingredient amount: ");
      Integer ingredientAmount = InputHandler.intInput();
      InputHandler.stringInput();

      numberOfIngredientsMap.put(ingredientName, ingredientAmount); //TODO - Ikke send hashmap, lag funksjon
    }

    PrintHandler.printString("Enter recipe instructions: ");
    String recipeInstructions = InputHandler.stringInput();

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