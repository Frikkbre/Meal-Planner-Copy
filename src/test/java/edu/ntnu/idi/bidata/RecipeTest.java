package edu.ntnu.idi.bidata;

import edu.ntnu.idi.bidata.entity.Recipe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class RecipeTest {

  private Recipe recipe;

  @BeforeEach
  void setUp(){
    String recipeName = "Pancakes";
    String recipeDescription = "Delicious pancakes";
    String recipeIngredients = "Flour" + "milk" + "eggs";
    String recipeInstructions = "Mix all ingredients together and fry in a pan";
    recipe = new Recipe(recipeName, recipeDescription, recipeIngredients, recipeInstructions);
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
    String recipeIngredients = "Flour" + "milk" + "eggs";
    recipe.setRecipeIngredients(recipeIngredients);
    assertEquals(recipeIngredients, recipe.getRecipeIngredients());
  }

  @Test
  void setRecipeIngredientsTestForNegativeValues() {
    assertThrows(IllegalArgumentException.class, () -> recipe.setRecipeIngredients(null));
    assertThrows(IllegalArgumentException.class, () -> recipe.setRecipeIngredients(""));
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


}
