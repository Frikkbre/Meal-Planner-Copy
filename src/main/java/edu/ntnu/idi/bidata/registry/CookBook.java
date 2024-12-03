package edu.ntnu.idi.bidata.registry;

import edu.ntnu.idi.bidata.entity.Ingredient;
import edu.ntnu.idi.bidata.entity.Recipe;
import edu.ntnu.idi.bidata.util.InputHandler;
import edu.ntnu.idi.bidata.util.PrintHandler;

import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

/**
 * The {@code CookBook} class is responsible for managing a collection of recipes.
 * It provides methods to add, remove, and search for recipes within the cookbook.
 * <p>
 * This class interacts with {@link InputHandler} for potential user input handling
 * and uses a HashMap to store recipes where the key is the recipe name
 * and the value is the {@link Recipe} object.
 * </p>
 *
 * @version 1.0
 * @since 02.11.2024
 * @author Frikk Brændsrød
 */
public class CookBook {

  private HashMap<String, Recipe> recipeRegister = new HashMap<>();

  static Scanner inputScanner = new Scanner(System.in);

  public CookBook(InputHandler inputHandler) {
  }

  /**
   * Adds initial recipes to the cookbook.
   * Is ran from the initializeApplication method in the MealPlannerApp class.
   */
  public void addInitRecipe() {
    HashMap<String, Integer> recipeIngredients = new HashMap<>(); //BOTH RECIPES USE THIS HASHMAP!!!
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

  /**
   * Returns the recipe register.
   *
   * @return the recipe register
   */
  public HashMap<String, Recipe> getRecipeRegister() {
    return recipeRegister;
  }

  /**
   * Adds a new recipe to the cookbook.
   * The user is prompted to enter the recipe name, description, ingredients, and instructions.
   * The recipe is then added to the recipe register.
   */
  public void addRecipe(String recipeName, String recipeDescription, HashMap<String, Integer> ingredients, String recipeInstructions) {
    for (Recipe recipe : recipeRegister.values()) {
      if (recipe.getRecipeName().equalsIgnoreCase(recipeName)) {
        PrintHandler.printString("Recipe already exists");
        return;
      }
    }

    // Create the Recipe object with the provided ingredients
    Recipe recipe = new Recipe(recipeName, recipeDescription, ingredients, recipeInstructions); //TODO - Make it use map.copyOf() to avoid reference issues and move to MealPlannerApp
    recipeRegister.put(recipeName, recipe);
    PrintHandler.printString("Recipe added successfully: " + recipeName);
  }


  /**
   * Removes a recipe from the cookbook based on the recipe name.
   *
   * @param recipeName the name of the recipe to be removed
   */
  public void removeRecipe(String recipeName) {
    //recipeName = recipeName.toLowerCase(); TODO - Make it not case sensitive
    if (recipeRegister.containsKey(recipeName)) {
      recipeRegister.remove(recipeName);
      PrintHandler.printString(recipeName + " was removed");
    } else {
      PrintHandler.printString("recipe not found");
    }
  }

  /**
   * Searches for a recipe in the cookbook by name and displays the result.
   *
   * @param recipeName the name of the recipe to search for
   */
  public void searchRecipe(String recipeName) {
    for (Recipe recipe : recipeRegister.values()) {
      if (recipe.getRecipeName().equalsIgnoreCase(recipeName)) {
        PrintHandler.printRecipe(recipe);
      }
    }
  }

  /**
   * Displays all recipes in the cookbook.
   * Iterates over the recipe register and prints each recipe.
   */
  public void showAllRecipes() {
    for (Recipe recipeRegister : recipeRegister.values()) {
      PrintHandler.printRecipe(recipeRegister);
    }
  }

  public void cookRecipe(String recipeName, FoodStorage foodStorage) {
    for (Recipe recipe : recipeRegister.values()) {
      if (recipe.getRecipeName().equalsIgnoreCase(recipeName)) {
        PrintHandler.printString("Cooking " + recipeName);
        PrintHandler.printString(recipe.getRecipeInstructions());

        for (String ingredientName : recipe.getRecipeIngredients().keySet()) {
          foodStorage.removeIngredient(ingredientName, recipe.getRecipeIngredients().get(ingredientName)); //TODO - make it illegal to remove more than you have
        }
        break;
      }
    }
  }

}
