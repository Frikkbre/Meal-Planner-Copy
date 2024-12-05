package edu.ntnu.idi.bidata;
import edu.ntnu.idi.bidata.entity.Recipe;
import edu.ntnu.idi.bidata.registry.CookBook;

import edu.ntnu.idi.bidata.util.InputHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class CookBookTest {

  @Test
  void testAddRecipe() {
    CookBook cookBook = new CookBook(new InputHandler(new Scanner(System.in)));
    String recipeName = "Pancakes";
    String recipeDescription = "Delicious pancakes";
    HashMap<String, Float> recipeIngredients = new HashMap<>();
    recipeIngredients.put("Flour", 200f);
    recipeIngredients.put("Milk", 300f);
    recipeIngredients.put("Eggs", 2f);
    String recipeInstructions = "Mix all ingredients together and fry in a pan";
    int intendedForAmountOfPeople = 4;
    cookBook.addRecipe(recipeName, recipeDescription, recipeIngredients, recipeInstructions, intendedForAmountOfPeople);
    assertEquals(1, cookBook.getRecipeRegistry().size());
  }

  @Test
  void testRemoveRecipe() {
    CookBook cookBook = new CookBook(new InputHandler(new Scanner(System.in)));
    String recipeName = "Pancakes";
    String recipeDescription = "Delicious pancakes";
    HashMap<String, Float> recipeIngredients = new HashMap<>();
    recipeIngredients.put("Flour", 200f);
    recipeIngredients.put("Milk", 300f);
    recipeIngredients.put("Eggs", 2f);
    String recipeInstructions = "Mix all ingredients together and fry in a pan";
    int intendedForAmountOfPeople = 4;
    cookBook.addRecipe(recipeName, recipeDescription, recipeIngredients, recipeInstructions, intendedForAmountOfPeople);
    assertEquals(1, cookBook.getRecipeRegistry().size());
    cookBook.removeRecipe(recipeName);
    assertEquals(0, cookBook.getRecipeRegistry().size());
  }

  @Test
  void testSearchRecipe() {
    CookBook cookBook = new CookBook(new InputHandler(new Scanner(System.in)));
    String recipeName = "Pancakes";
    String recipeDescription = "Delicious pancakes";
    HashMap<String, Float> recipeIngredients = new HashMap<>();
    recipeIngredients.put("Flour", 200f);
    recipeIngredients.put("Milk", 300f);
    recipeIngredients.put("Eggs", 2f);
    String recipeInstructions = "Mix all ingredients together and fry in a pan";
    int intendedForAmountOfPeople = 4;
    cookBook.addRecipe(recipeName, recipeDescription, recipeIngredients, recipeInstructions, intendedForAmountOfPeople);
    Recipe recipe = cookBook.searchRecipe(recipeName);
    assertEquals(recipeName, recipe.getRecipeName()); //This method doesnt return anything just uses printHandler.
  }

}
