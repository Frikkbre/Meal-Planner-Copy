package edu.ntnu.idi.bidata;
import edu.ntnu.idi.bidata.entity.Ingredient;
import edu.ntnu.idi.bidata.entity.Recipe;
import edu.ntnu.idi.bidata.registry.CookBook;

import edu.ntnu.idi.bidata.registry.FoodStorage;
import edu.ntnu.idi.bidata.userInterface.MealPlannerApp;
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
    assertNotNull(recipe);
    assertEquals(recipeName, recipe.getRecipeName());
  }

  @Test
  void testShowAllRecipes(){
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
    //Intentional bad input
    String recipeName2 = "Pancakes";
    String recipeDescription2 = "";
    HashMap<String, Float> recipeIngredients2 = new HashMap<>();
    recipeIngredients2.put("Flour", 200f);
    recipeIngredients2.put("Milk", 300f);
    recipeIngredients2.put("Eggs", 2f);
    recipeIngredients2.put("Sugar", 100f);
    String recipeInstructions2 = "Mix all ingredients together and fry in a pan";
    int intendedForAmountOfPeople2 = 4;
    cookBook.addRecipe(recipeName2, recipeDescription2, recipeIngredients2, recipeInstructions2, intendedForAmountOfPeople2);
    assertEquals(1, cookBook.showAllRecipes());
  }

  @Test
  void testShowAvailableRecipes() { //TODO - test gets stuck in infinite loop
    CookBook cookBook = new CookBook(new InputHandler(new Scanner(System.in)));
    FoodStorage foodStorage = new FoodStorage(new MealPlannerApp());

    HashMap<String, Float> ingredients = new HashMap<>();
    ingredients.put("rice", 2.0f);
    ingredients.put("eggs", 4.0f);

    cookBook.addRecipe("Fried Rice", "Simple fried rice", ingredients, "Cook rice and eggs", 2);

    foodStorage.addIngredient(new Ingredient("Rice", "Rice", 19.90f, 3.0f, 3, 2024, 12, 24));
    foodStorage.addIngredient(new Ingredient("Eggs", "Eggs", 14.90f, 6.0f, 4, 2024, 12, 31));

    int availableRecipes = cookBook.showAvailableRecipes(foodStorage);
    assertEquals(1, availableRecipes);
    }

    @Test
  void testCookRecipe(){ //TODO - test gets stuck in infinite loop
    CookBook cookBook = new CookBook(new InputHandler(new Scanner(System.in)));
    FoodStorage foodStorage = new FoodStorage(new MealPlannerApp());

    HashMap<String, Float> ingredients = new HashMap<>();
    ingredients.put("rice", 2.0f);
    ingredients.put("eggs", 4.0f);

    cookBook.addRecipe("Fried Rice", "Simple fried rice", ingredients, "Cook rice and eggs", 2);

    foodStorage.addIngredient(new Ingredient("Rice", "Rice", 19.90f, 3.0f, 3, 2024, 12, 24));
    foodStorage.addIngredient(new Ingredient("Eggs", "Eggs", 14.90f, 6.0f, 4, 2024, 12, 31));

    int availableRecipes = cookBook.showAvailableRecipes(foodStorage);
    assertEquals(1, availableRecipes);

    Recipe recipe = cookBook.searchRecipe("Fried Rice");
    assertNotNull(recipe);
    assertTrue(cookBook.cookRecipe(recipe.getRecipeName(), foodStorage));
  }

}