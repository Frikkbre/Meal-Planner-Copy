package edu.ntnu.idi.bidata;

import edu.ntnu.idi.bidata.entity.Ingredient;

import java.util.HashMap;

public class PrintHandler {
  public static void printAllIngredients(Ingredient ingredient) {
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
