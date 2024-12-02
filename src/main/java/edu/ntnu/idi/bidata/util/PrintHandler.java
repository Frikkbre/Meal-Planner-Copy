package edu.ntnu.idi.bidata.util;

import edu.ntnu.idi.bidata.entity.Ingredient;
import edu.ntnu.idi.bidata.entity.Recipe;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class PrintHandler {

  /**
   * Prints the string passed in
   * Used for general string printing
   * @param inputString
   */
  public static void printString(String inputString){
    System.out.println(inputString);
  }


  /**
   * Prints menu 1 options for user, this includes:
   * 1. modify recipe
   * 2. modify recipe
   * 3. exit program
   */
  public static void printMainMenuOption() {
    System.out.println("What do you want to do?");
    System.out.println("1 = ingredient menu");
    System.out.println("2 = recipe menu");
    System.out.println("0 = exit the program");
  }

  /**
   * Prints menu 1 options for user, this includes:
   * 1. add ingredient
   * 2. remove ingredient
   * 3. search ingredient
   * 4. show ingredients
   * 5. show expired ingredients
   */
  public static void printMenuIngredientOption() {
    System.out.println("1 = Add ingredient");
    System.out.println("2 = Remove ingredient");
    System.out.println("3 = Search ingredient");
    System.out.println("4 = Show ingredients");
    System.out.println("5 = Show expired ingredients");
  }

  /**
   * Prints menu 2 options for user, this includes:
   * 1. add recipe
   * 2. remove recipe
   * 3. search recipe
   * 4. show recipes
   */
  public static void printMenuRecipeOption() {
    System.out.println("1 = Add recipe");
    System.out.println("2 = remove recipe");
    System.out.println("3 = search recipe");
    System.out.println("4 = Show recipes");
  }


  /**
   * prints ingredient passed in, used to print one or more ingredients.
   * @param ingredient
   */
  public static void printIngredient(Ingredient ingredient) {
    //System.out.println("All ingredients:");
    //for (Ingredient ingredient : foodRegister.values()) {
    System.out.println("Name: " + ingredient.getIngredientName());
    System.out.println("Type: " + ingredient.getIngredientType());
    System.out.println("Price: " + ingredient.getIngredientPrice() + "kr");
    System.out.println("Amount: " + ingredient.getIngredientAmount() + " " + ingredient.getIngredientUnit());
    System.out.println("Is Expired: " + ingredient.getIngredientIsExpired());
    System.out.println("-------------------");
    System.out.println();


    /*try { //TODO - Write AI declaration
      TimeUnit.SECONDS.sleep(5);
    } catch (InterruptedException e) {
      System.out.println("Sleep failed: " + e.getMessage());
      Thread.currentThread().interrupt(); // Reset the interrupt flag
    }*/

  }

  /**
   * prints ingredient passed in, with a message that the ingredient was found
   * @param ingredientIterated
   */
  public static void searchIngredientPrint(Ingredient ingredientIterated) {
    System.out.println("Ingredient found:");
    printIngredient(ingredientIterated);
  }



  //METHODS FOR PRINTING RECIPES

  /**
   * prints recipe passed in, used to print one or more recipes.
   * @param recipe
   */
  public static void printRecipe(Recipe recipe) {
    System.out.println("Name: " + recipe.getRecipeName());
    System.out.println("Description: " + recipe.getRecipeDescription());
    System.out.println("Ingredients: ");
    for (String ingredient : recipe.getRecipeIngredients().keySet()) {
      System.out.println(ingredient + ": " + recipe.getRecipeIngredients().get(ingredient));
    }
    System.out.println("Instructions: " + recipe.getRecipeInstructions());
    System.out.println("-------------------");
    System.out.println();
  }


  //GENERAL METHODS

  /**
   * prints a message that the input was invalid
   */
  public static void invalidInput(){
    System.out.println("Invalid input, please try again");
  }

  /**
   * prints a message that the program is exiting
   */
  public static void exitProgram(){
    System.out.println("Exiting the program");
    System.out.println("Have a nice day!");
  }
}