package edu.ntnu.idi.bidata.util;

import edu.ntnu.idi.bidata.entity.Ingredient;
import edu.ntnu.idi.bidata.entity.Recipe;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class PrintHandler {
  public static void printIngredient(Ingredient ingredient) {
    //System.out.println("All ingredients:");
    //for (Ingredient ingredient : foodRegister.values()) {
    System.out.println("Name: " + ingredient.getIngredientName());
    System.out.println("Type: " + ingredient.getIngredientType());
    System.out.println("Price: " + ingredient.getIngredientPrice() + "kr");
    System.out.println("Amount: " + ingredient.getIngredientAmount() + " " + ingredient.getIngredientUnit());
    System.out.println("Is Expired: " + ingredient.getIngredientIsExpired());
    System.out.println();

    /*try { //TODO - Write AI declaration
      TimeUnit.SECONDS.sleep(5);
    } catch (InterruptedException e) {
      System.out.println("Sleep failed: " + e.getMessage());
      Thread.currentThread().interrupt(); // Reset the interrupt flag
    }*/

  }

  public static void printRecipe(Recipe recipe) {

     System.out.println("Name: " + recipe.getRecipeName());
     System.out.println("Description: " + recipe.getRecipeDescription());
     System.out.println("Ingredients: ");
    for (String ingredient : recipe.getRecipeIngredients().keySet()) {
      System.out.println(ingredient + ": " + recipe.getRecipeIngredients().get(ingredient));
    }
    System.out.println("Instructions: " + recipe.getRecipeInstructions());
    System.out.println();
  }

  /**
   * Prints menu 1 options for user, this includes:
   * 1. modify recipe
   * 2. modify recipe
   * 3. exit program
   */
  public static void printMainMenuOption() {
    System.out.println("What do you want to do?");
    System.out.println("1 = Modify ingredient");
    System.out.println("2 = Modify recipe");
    System.out.println("0 = exit the program");
  }

  public static void printMenuIngredientOption() {
    System.out.println("1 = Add ingredient");
    System.out.println("2 = Remove ingredient");
    System.out.println("3 = Search ingredient");
    System.out.println("4 = Show ingredients");
    System.out.println("5 = Show expired ingredients");
  }

  public static void printMenuRecipeOption() {
    System.out.println("1 = Add recipe");
    System.out.println("2 = remove recipe");
    System.out.println("3 = search recipe");
  }
}