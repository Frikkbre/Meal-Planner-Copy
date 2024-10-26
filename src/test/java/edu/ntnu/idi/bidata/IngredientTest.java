package edu.ntnu.idi.bidata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredientTest {

    static main.edu.ntnu.idi.bidata.Ingredient ingredientTest;
    
    @Test
    void setIngredientNameTestForPositiveValues() {
        ingredientTest.setIngredientName("Flour");

            //Assert
        assertEquals("Flour", ingredientTest.getIngredientName());

    }


    void setIngredientNameTestForNegativeValues() {
        ingredientTest.setIngredientName("");

        //Assert
        assertEquals(IllegalArgumentException("Ingredient name cannot be empty"), ingredientTest.getIngredientName());

    }


    @org.junit.jupiter.api.Test
    void setIngredientExpirationDate() {
    }

    @org.junit.jupiter.api.Test
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