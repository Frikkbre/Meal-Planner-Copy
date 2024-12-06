package edu.ntnu.idi.bidata;
import edu.ntnu.idi.bidata.entity.Ingredient;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class IngredientTest {

    private Ingredient ingredient;
    
    @BeforeEach
    void setUp(){
        String Name = "Flour";
        String Type = "Baking";
        float Price = 10.0f;
        float Amount = 5.0f;
        int Unit = 1;
        int ExpirationYear = 2024;
        int ExpirationMonth = 10;
        int ExpirationDay = 19;
        LocalDate ExpirationDate = LocalDate.of(ExpirationYear, ExpirationMonth, ExpirationDay);
        boolean IsExpired = true;
        ingredient = new Ingredient(Name, Type, Price, (int) Amount, Unit, ExpirationYear, ExpirationMonth, ExpirationDay);  //TODO - check required (int) before amount.
    }
    
    
    @Test
    void setIngredientNameTestForPositiveValues() {
        String ingredientName = "egg";
        ingredient.setIngredientName(ingredientName);
        assertEquals(ingredientName, ingredient.getIngredientName());

    }

    @Test
    void setIngredientNameTestForNegativeValues() {
        //Assert
        //assertThrows(IllegalArgumentException.class, () -> ingredient.setIngredientName(null));
        //assertThrows(IllegalArgumentException.class, () -> ingredient.setIngredientName(""));
        String ingredientName = "egg";
        ingredient.setIngredientName(ingredientName);
        assertNotEquals("Flour",ingredient.getIngredientName());

    }



    @Test
    void SetIngredientNameTestForPositiveValues() {
        String ingredientName = "Flour"; //TODO - Isnt this defined in setup??
        ingredient.setIngredientName(ingredientName);
        assertEquals(ingredientName, ingredient.getIngredientName());
    }

    @Test
    void SetIngredientNameTestForNegativeValues() {
        assertThrows(IllegalArgumentException.class, () -> ingredient.setIngredientName(""));
        assertThrows(IllegalArgumentException.class, () -> ingredient.setIngredientName(null));
    }



    @Test
    void setIngredientTypeTestForPositiveValues() {
        String ingredientType = "Baking";
        ingredient.setIngredientType(ingredientType);
        assertEquals(ingredientType, ingredient.getIngredientType());
    }

    @Test
    void setIngredientTypeTestForNegativeValues() {
        assertThrows(IllegalArgumentException.class, () -> ingredient.setIngredientType(""));
    }

    @Test
    void setIngredientPriceTestForPositiveValues() {
        int ingredientPrice = 10;
        ingredient.setIngredientPrice(ingredientPrice);
        assertEquals(ingredientPrice, ingredient.getIngredientPrice());
    }

    @Test
    void setIngredientPriceTestForNegativeValues() {
        assertThrows(IllegalArgumentException.class, () -> ingredient.setIngredientPrice(-10));
    }



    @Test
    void setIngredientAmountTestForPositiveValues() {
        int ingredientAmount = 5;
        ingredient.setIngredientAmount(ingredientAmount);
        assertEquals(ingredientAmount, ingredient.getIngredientAmount());
    }

    @Test
    void setIngredientAmountTestForNegativeValues() {
        assertThrows(IllegalArgumentException.class, () -> ingredient.setIngredientAmount(-5));
        assertThrows(IllegalArgumentException.class, () -> ingredient.setIngredientAmount(0));
    }



    @Test
    void setIngredientUnitTestForPositiveValues() {
        int ingredientUnit = 1;
        ingredient.setIngredientUnit(ingredientUnit);
        assertEquals("kg", ingredient.getIngredientUnit());
    }

    @Test
    void setIngredientUnitTestForNegativeValues() {
        assertThrows(IllegalArgumentException.class, () -> ingredient.setIngredientUnit(0));
        assertThrows(IllegalArgumentException.class, () -> ingredient.setIngredientUnit(10));
        assertThrows(IllegalArgumentException.class, () -> ingredient.setIngredientUnit(-10));
    }



    @Test
    void SetIngredientExpirationDate() { //TODO - do.
    }



    @Test
    void SetIngredientIsExpired() { //TODO - sjekk om denne trenger testmetode.
    }



    @Test
    void displayInformation() { //TODO - sjekk om denne trenger testmetode.
    }
}