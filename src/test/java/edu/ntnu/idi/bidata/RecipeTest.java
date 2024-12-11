package edu.ntnu.idi.bidata;

import edu.ntnu.idi.bidata.entity.Recipe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class RecipeTest {

  private Recipe recipe;

  @BeforeEach
  void setUp(){
    String recipeName = "Pancakes";
    String recipeDescription = "Delicious pancakes";
    HashMap<String, Float> recipeIngredients = new HashMap<>();
    recipeIngredients.put("Flour", 200f);
    recipeIngredients.put("Milk", 300f);
    recipeIngredients.put("Eggs", 2f);
    String recipeInstructions = "Mix all ingredients together and fry in a pan";
    int intendedForAmountOfPeople = 4;
    recipe = new Recipe(recipeName, recipeDescription, recipeIngredients, recipeInstructions, intendedForAmountOfPeople);
  }

  @Test
  void setRecipeNameTestForPositiveValues() {
    String recipeName = "Pancakes";
    recipe.setRecipeName(recipeName);
    assertEquals(recipeName, recipe.getRecipeName());

  }

  @Test
  void setRecipeNameTestForNegativeValues() {
    assertThrows(IllegalArgumentException.class, () -> recipe.setRecipeName(null));
    assertThrows(IllegalArgumentException.class, () -> recipe.setRecipeName(""));

  }

  @Test
  void setRecipeDescriptionTestForPositiveValues() {
    String recipeDescription = "Delicious pancakes";
    recipe.setRecipeDescription(recipeDescription);
    assertEquals(recipeDescription, recipe.getRecipeDescription());
  }

  @Test
  void setRecipeDescriptionTestForNegativeValues() {
    assertThrows(IllegalArgumentException.class, () -> recipe.setRecipeDescription(null));
    assertThrows(IllegalArgumentException.class, () -> recipe.setRecipeDescription(""));
  }

  @Test
  void setRecipeIngredientsTestForPositiveValues() {
    HashMap<String, Float> recipeIngredients = new HashMap<>();
    recipeIngredients.put("Flour", 200.0f);
    recipeIngredients.put("Milk", 300.0f);
    recipeIngredients.put("Eggs", 2.0f);
    recipe.setRecipeIngredients(recipeIngredients);
    assertEquals(recipeIngredients, recipe.getRecipeIngredients());
  }

  @Test
  void setRecipeIngredientsTestForNegativeValues() {
    HashMap<String, Float> recipeIngredients = new HashMap<>();
    recipeIngredients.put("", 200f);
    recipeIngredients.put("Milk", null);
    recipeIngredients.put(null, 2f);
    recipeIngredients.put("Eggs", -1f);

    assertThrows(IllegalArgumentException.class, () -> recipe.setRecipeIngredients(recipeIngredients));
    assertThrows(IllegalArgumentException.class, () -> recipe.setRecipeIngredients(recipeIngredients));
  }

  @Test
  void setRecipeInstructionsTestForPositiveValues() {
    String recipeInstructions = "Mix all ingredients together and fry in a pan";
    recipe.setRecipeInstructions(recipeInstructions);
    assertEquals(recipeInstructions, recipe.getRecipeInstructions());
  }

  @Test
  void setRecipeInstructionsTestForNegativeValues() {
    assertThrows(IllegalArgumentException.class, () -> recipe.setRecipeInstructions(null));
    assertThrows(IllegalArgumentException.class, () -> recipe.setRecipeInstructions(""));
  }

  @Test
  void setIntendedForAmountOfPeopleTestForPositiveValues() {
    int intendedForAmountOfPeople = 4;
    recipe.setIntendedForAmountOfPeople(intendedForAmountOfPeople);
    assertEquals(intendedForAmountOfPeople, recipe.getIntendedForAmountOfPeople());
  }

  @Test
  void setIntendedForAmountOfPeopleTestForNegativeValues() {
    assertThrows(IllegalArgumentException.class, () -> recipe.setIntendedForAmountOfPeople(0));
    assertThrows(IllegalArgumentException.class, () -> recipe.setIntendedForAmountOfPeople(-1));
  }


}
