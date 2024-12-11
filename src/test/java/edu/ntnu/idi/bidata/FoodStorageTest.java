package edu.ntnu.idi.bidata;
import edu.ntnu.idi.bidata.entity.Ingredient;
import edu.ntnu.idi.bidata.registry.FoodStorage;

import edu.ntnu.idi.bidata.userInterface.MealPlannerApp;
import org.junit.jupiter.api.BeforeEach;

public class FoodStorageTest {

  private FoodStorage foodStorage;

  @BeforeEach
  void setUp(){
    foodStorage = new FoodStorage(new MealPlannerApp());
  }


  // Returns true when ingredient exists and has sufficient amount
  /*@Test
  public void test_has_sufficient_ingredient_amount() {
    FoodStorage foodStorage = new FoodStorage(new MealPlannerApp());
    Ingredient ingredient = new Ingredient("milk", "dairy", 20.0f, 2.0f, 3, 2024, 12, 31);
    foodStorage.addIngredient(ingredient);

    boolean result = foodStorage.hasIngredient("milk", 1.5f);

    assertTrue(result);
  }*/
}
