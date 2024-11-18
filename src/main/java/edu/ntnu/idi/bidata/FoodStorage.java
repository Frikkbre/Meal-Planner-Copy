package edu.ntnu.idi.bidata;

import edu.ntnu.idi.bidata.userInterface.MealPlannerApp;
import edu.ntnu.idi.bidata.entity.Ingredient;
import java.util.HashMap;

/**
 * The {@code FoodStorage} class is responsible for managing a collection of ingredients.
 * It provides methods to add, remove, and search for ingredients within the storage.
 * <p>
 * This class interacts with {@link MealPlannerApp} for potential user input handling
 * and uses a HashMap to store ingredients where the key is the ingredient name
 * and the value is the {@link Ingredient} object.
 * </p>
 *
 * @author Frikk Brændsrød
 * @version 1.0
 */
public class FoodStorage {

    private MealPlannerApp mealPlannerApp = new MealPlannerApp();
    private HashMap<String, Ingredient> foodStorage = new HashMap<>();

    /**
     * Adds a new ingredient to the food storage.
     *
     * @param newIngredient the {@link Ingredient} to be added to the storage
     */
    public void addIngredient(Ingredient newIngredient) {
        String lowerCaseIngredientName = newIngredient.getIngredientName().toLowerCase();

        if (foodStorage.containsKey(lowerCaseIngredientName)) {
            Ingredient existingIngredient = foodStorage.get(lowerCaseIngredientName);
            existingIngredient.setIngredientAmount(existingIngredient.getIngredientAmount() + newIngredient.getIngredientAmount());
        } else {
            foodStorage.put(lowerCaseIngredientName, newIngredient);
        }
    }

    /**
     * Removes an ingredient from the food storage based on the ingredient object.
     *
     * @param ingredientName the {@link Ingredient} to be removed from the storage
     *
     * @param amountToRemove the amount of the ingredient to remove
     */
    public void removeIngredient(String ingredientName, int amountToRemove) {
        String lowerCaseIngredientName = ingredientName.toLowerCase();

        if (foodStorage.containsKey(lowerCaseIngredientName)) {
            Ingredient existingIngredient = foodStorage.get(lowerCaseIngredientName);

            if (amountToRemove <= 0) {
                System.out.println("Invalid amount to remove. Please enter a positive value.");
                return;
            }

            if (amountToRemove >= existingIngredient.getIngredientAmount()) {
                foodStorage.remove(lowerCaseIngredientName);
                System.out.println(lowerCaseIngredientName + " has been removed completely.");
            } else {
                existingIngredient.setIngredientAmount(
                    existingIngredient.getIngredientAmount() - amountToRemove
                );
                System.out.println(amountToRemove + " units of " + lowerCaseIngredientName + " have been removed.");
            }
        } else {
            System.out.println("Ingredient not found: " + lowerCaseIngredientName);
        }
    }

    /**
     * Searches for an ingredient in the food storage by name and displays the result.
     *
     * @param ingredientName the name of the ingredient to search for
     */
    public void searchIngredient(String ingredientName) {
        boolean found = false;

        // Iterate over the map's values (Ingredient objects)
        for (Ingredient ingredientIterated : foodStorage.values()) {
            if (ingredientIterated.getIngredientName().equalsIgnoreCase(ingredientName)) {
                System.out.println("Ingredient found: " + ingredientIterated);
                found = true;
                break; // Exit the loop once a match is found
            }
        }

        if (!found) {
            System.out.println("Ingredient not found");
        }
    }

    /**
     * Removes an ingredient from the food storage based on its name.
     *
     * @param ingredientName the name of the ingredient to be removed
     */
    public void removeIngredient(String ingredientName){
        if(foodStorage.containsKey(ingredientName)){
            foodStorage.remove(ingredientName);
            System.out.println("Ingredient removed");
        } else {
            System.out.println("Ingredient not found");
        }
    }

     /**
     /* Searches for recipes based on the available ingredients in the storage.
     /* <p>
     /* This method is yet to be implemented.
     /* </p>
     /*/
    // public void searchRecipe() {
    //     // TODO - Finish this method
    // }
}