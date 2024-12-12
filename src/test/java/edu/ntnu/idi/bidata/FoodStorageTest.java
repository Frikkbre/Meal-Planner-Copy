package edu.ntnu.idi.bidata;
import edu.ntnu.idi.bidata.entity.Ingredient;
import edu.ntnu.idi.bidata.registry.FoodStorage;

import edu.ntnu.idi.bidata.userInterface.MealPlannerApp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertTrue;

public class FoodStorageTest {

  private FoodStorage foodStorage;

  @BeforeEach
  void setUp(){
    foodStorage = new FoodStorage();
  }


  // Returns true when ingredient exists and has sufficient amount
  @Test
  public void hasSufficientIngredientAmountTest() {
    FoodStorage foodStorage = new FoodStorage();
    Ingredient ingredient = new Ingredient("milk", "dairy", 20.0f, 2.0f, 3, 2024, 12, 31);
    foodStorage.addIngredient(ingredient);

    boolean result = foodStorage.hasIngredient("milk", 1.5f);

    assertTrue(result);
  }

  @Test
  void hasIngredientTest() {
    Ingredient ingredient = new Ingredient("milk", "dairy", 20.0f, 2.0f, 3, 2024, 12, 31);
    foodStorage.addIngredient(ingredient);

    boolean result = foodStorage.hasIngredient("milk", 1.5f);

    assertTrue(result);
  }

  @Test
  void addIngredientTest() {
    Ingredient ingredient = new Ingredient("milk", "dairy", 20.0f, 2.0f, 3, 2024, 12, 31);
    foodStorage.addIngredient(ingredient);

    boolean result = foodStorage.hasIngredient("milk", 1.5f);

    assertTrue(result);
  }

  @Test
  void removeIngredientTest() {
    Ingredient ingredient = new Ingredient("milk", "dairy", 20.0f, 2.0f, 3, 2024, 12, 31);
    foodStorage.addIngredient(ingredient);
    foodStorage.removeIngredient("milk", 1.5f);

    boolean result = foodStorage.hasIngredient("milk", 0.5f); // Check for remaining amount

    assertTrue(result);
  }

  @Test
  void addInitIngredientTest() {
    foodStorage.addInitIngredient();
    boolean result = foodStorage.hasIngredient("rice", 2.0f);
    assertTrue(result);
  }

  @Test
  void showExpiredIngredientsTest() {
    Ingredient ingredient = new Ingredient("milk", "dairy", 20.0f, 2.0f, 3, 2020, 12, 30);
    LocalDate date = LocalDate.of(2021, 12, 31);
    foodStorage.addIngredient(ingredient);
    foodStorage.showExpiredIngredients(date);
    boolean result = foodStorage.hasIngredient("milk", 2.0f);
    assertTrue(result);
  }
}
