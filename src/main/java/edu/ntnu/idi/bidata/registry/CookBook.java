package edu.ntnu.idi.bidata.registry;

import edu.ntnu.idi.bidata.entity.Recipe;
import edu.ntnu.idi.bidata.util.InputHandler;
import edu.ntnu.idi.bidata.util.PrintHandler;

import java.util.*;

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
 */
public class CookBook {

  private HashMap<String, Recipe> recipeRegister = new HashMap<>();

  static Scanner inputScanner = new Scanner(System.in);

  public CookBook(InputHandler inputHandler) {
  }

  public Map<String, Recipe> getRecipeRegistry() {
    return Collections.unmodifiableMap(recipeRegister);
  }

  /**
   * Adds initial recipes to the cookbook.
   * Is ran from the initializeApplication method in the MealPlannerApp class.
   */
  public void addInitRecipe() {
    HashMap<String, Float> recipeIngredientsFriedRice = new HashMap<>();
    recipeIngredientsFriedRice.put("Rice", 1f);
    recipeIngredientsFriedRice.put("Onion", 1.0f);
    recipeIngredientsFriedRice.put("Eggs", 4.0f);
    Recipe friedRice = new Recipe("Fried Rice", "Fried rice with eggs and onion", recipeIngredientsFriedRice, "Cook rice, fry eggs and onion, mix together", 4);
    recipeRegister.put(friedRice.getRecipeName(), friedRice);

    HashMap<String, Float> recipeIngredientsSpaghettiBolognese = new HashMap<>();
    recipeIngredientsSpaghettiBolognese.put("spaghetti", 200.0f);
    recipeIngredientsSpaghettiBolognese.put("meat", 400.0f);
    recipeIngredientsSpaghettiBolognese.put("Bolognese sauce", 1.0f);
    Recipe spaghettiBolognese = new Recipe("Spaghetti Bolognese", "Spaghetti with meat and tomato sauce", recipeIngredientsSpaghettiBolognese, "Cook spaghetti, fry meat, add Bolognese sauce", 4);
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
  public void addRecipe(String recipeName, String recipeDescription, HashMap<String, Float> ingredients, String recipeInstructions, int intendedForAmountOfPeople) {
    for (Recipe recipe : recipeRegister.values()) {
      if (recipe.getRecipeName().equalsIgnoreCase(recipeName)) {
        PrintHandler.printString("Recipe already exists");
        return;
      }
    }

    Recipe recipe = new Recipe(recipeName, recipeDescription, ingredients, recipeInstructions, intendedForAmountOfPeople);
    recipeRegister.put(recipeName, recipe);
    PrintHandler.printString("Recipe added successfully: " + recipeName);
  }

  /**
   * Removes a recipe from the cookbook based on the recipe name.
   *
   * @param recipeName the name of the recipe to be removed
   */
  public void removeRecipe(String recipeName) {
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
  public Recipe searchRecipe(String recipeName) {
    for (Recipe recipe : recipeRegister.values()) {
      if (recipe.getRecipeName().equalsIgnoreCase(recipeName)) {
        PrintHandler.printRecipe(recipe);
        return recipe;
      }
    }
    return null;
  }

  /**
   * Displays all recipes in the cookbook.
   * Iterates over the recipe register and prints each recipe.
   */
  public int showAllRecipes() {
    int counter = 0;
    for (Recipe recipeRegister : recipeRegister.values()) {
      PrintHandler.printRecipe(recipeRegister);
      counter++;
    }
    return counter;
  }

  /**
   * Displays only the recipes the user has the ingredients for.
   * Iterates over the recipe register and checks if the user has all the ingredients for each recipe.
   * If the user has all the ingredients for the recipe, it is printed.
   */
  public int showAvailableRecipes(FoodStorage foodStorage) {
    int counter = 0;
    for (Recipe recipe : recipeRegister.values()) {
      boolean hasAllIngredients = true;
      for (String ingredientName : recipe.getRecipeIngredients().keySet()) {
        if (!foodStorage.hasIngredient(ingredientName, recipe.getRecipeIngredients().get(ingredientName))) {
          hasAllIngredients = false;
          break;
        }
      }
      if (hasAllIngredients) {
        PrintHandler.printRecipe(recipe);
        counter++;
      }
    }
    return counter;
  }

  /**
   * Cooks a recipe by removing the ingredients from the food storage.
   * The user is prompted to enter the recipe name.
   * The recipe is then cooked by removing the ingredients from the food storage.
   *
   * @param recipeName  the name of the recipe to be cooked
   * @param foodStorage the food storage to remove the ingredients from
   * @return
   */
  public boolean cookRecipe(String recipeName, FoodStorage foodStorage) {
    for (Recipe recipe : recipeRegister.values()) {
      if (recipe.getRecipeName().equalsIgnoreCase(recipeName)) {
        PrintHandler.printString("Cooking " + recipeName);
        PrintHandler.printString(recipe.getRecipeInstructions());

        for (String ingredientName : recipe.getRecipeIngredients().keySet()) {
          foodStorage.removeIngredient(ingredientName, (int) recipe.getRecipeIngredients().get(ingredientName).floatValue());
        }
        break;
      }
    }
    return false;
  }
}