package edu.ntnu.idi.bidata.util;

import edu.ntnu.idi.bidata.entity.Ingredient;

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

  }
}