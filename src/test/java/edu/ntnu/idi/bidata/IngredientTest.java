package edu.ntnu.idi.bidata;
import main.edu.ntnu.idi.bidata.Ingredient;

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
        String Unit = "kg";
        int ExpirationYear = 2024;
        int ExpirationMonth = 10;
        int ExpirationDay = 19;
        LocalDate ExpirationDate = LocalDate.of(ExpirationYear, ExpirationMonth, ExpirationDay);
        boolean IsExpired = true;
        ingredient = new Ingredient(Name, Type, Price, (int) Amount, Unit, ExpirationYear, ExpirationMonth, ExpirationDay);  //TODO - check required (int) before amount.
    }
    
    
    @Test
    void setIngredientNameTestForPositiveValues() {
        String ingredientName = "Flour";
        ingredient.setIngredientName(ingredientName);
        assertEquals(ingredientName, ingredient.getIngredientName());

    }

    @Test
    void setIngredientNameTestForNegativeValues() {
        //Assert
        assertThrows(IllegalArgumentException.class, () -> ingredient.setIngredientName(null));
        assertThrows(IllegalArgumentException.class, () -> ingredient.setIngredientName(""));


    }


    @Test
    void setIngredientExpirationDate() {
    }

    @Test
    void setIngredientIsExpired() {
    }

    @Test
    void testSetIngredientName() {
    }

    @Test
    void setIngredientType() {
    }

    @Test
    void setIngredientPrice() {
    }

    @Test
    void setIngredientAmount() {
    }

    @Test
    void setIngredientUnit() {
    }

    @Test
    void testSetIngredientExpirationDate() {
    }

    @Test
    void testSetIngredientIsExpired() {
    }

    @Test
    void displayInformation() { //TODO - sjekk om denne trenger testmetode.
    }
}