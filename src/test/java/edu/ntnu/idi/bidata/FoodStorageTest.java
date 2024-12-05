package edu.ntnu.idi.bidata;
import edu.ntnu.idi.bidata.registry.FoodStorage;

import edu.ntnu.idi.bidata.userInterface.MealPlannerApp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class FoodStorageTest {

  private FoodStorage foodStorage;

  @BeforeEach
  void setUp(){
    foodStorage = new FoodStorage(new MealPlannerApp());
  }

}
