package edu.ntnu.idi.bidata.registry;

import edu.ntnu.idi.bidata.userInterface.MealPlannerApp;
import edu.ntnu.idi.bidata.entity.Ingredient;
import edu.ntnu.idi.bidata.util.PrintHandler;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.TimeUnit;

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

    private final HashMap<String, Ingredient> foodRegister = new HashMap<>();

    static Map<String, Integer> sortedMap = new HashMap<>();

    Scanner inputScanner = new Scanner(System.in);

    public FoodStorage() {

    }


    /**
     * Adds initial ingredients to the food storage.
     * Is ran from the initializeApplication method in the MealPlannerApp class.
     */
    public void addInitIngredient() {
        Ingredient rice = new Ingredient("Rice", "Rice", 19.90f, 3f, 3, 2024, 12, 24);
        Ingredient onion = new Ingredient("Onion", "Vegetable", 9.90f, 3.0f, 3, 2024, 12, 30);
        Ingredient eggs = new Ingredient("Eggs", "Eggs", 14.90f, 12.0f, 4, 2024, 12, 31);

        foodRegister.put("rice", rice);
        foodRegister.put("onion", onion);
        foodRegister.put("eggs", eggs);
    }

    /**
     * Checks if the food storage has the specified ingredient in the required amount.
     *
     * @param ingredientName the name of the ingredient
     * @param requiredAmount the required amount of the ingredient
     * @return true if the ingredient is available in the required amount, false otherwise
     */
    public boolean hasIngredient(String ingredientName, Float requiredAmount) {
        Ingredient ingredient = foodRegister.get(ingredientName.toLowerCase());
        return ingredient != null && ingredient.getIngredientAmount() >= requiredAmount;
    }

    /**
     * Adds a new ingredient to the food storage.
     * If the ingredient already exists in the storage, the amount is increased.
     */
    public void addIngredient(Ingredient newIngredient) {
            String lowerCaseIngredientName = newIngredient.getIngredientName().toLowerCase();

            if (foodRegister.containsKey(lowerCaseIngredientName)) {
                Ingredient existingIngredient = foodRegister.get(lowerCaseIngredientName);
                existingIngredient.setIngredientAmount(existingIngredient.getIngredientAmount() + newIngredient.getIngredientAmount());
            } else {
                foodRegister.put(lowerCaseIngredientName, newIngredient);
            }
        }

    /**
     * Removes an ingredient from the food storage based on the ingredient object.
     *
     * @param ingredientName the {@link Ingredient} to be removed from the storage
     * @param amountToRemove the amount of the ingredient to remove
     */
    public void removeIngredient(String ingredientName, float amountToRemove) {
        String lowerCaseIngredientName = ingredientName.toLowerCase();

        if (foodRegister.containsKey(lowerCaseIngredientName)) {
            Ingredient existingIngredient = foodRegister.get(lowerCaseIngredientName);

            if (amountToRemove <= 0) {
                PrintHandler.printString("Invalid amount to remove. Please enter a positive value.");
                return;
            }

            if (amountToRemove >= existingIngredient.getIngredientAmount()) {
                foodRegister.remove(lowerCaseIngredientName);
                PrintHandler.printString(lowerCaseIngredientName + " has been removed completely.");
            } else {
                existingIngredient.setIngredientAmount(
                    existingIngredient.getIngredientAmount() - amountToRemove
                );
                PrintHandler.printString(amountToRemove + " units of " + lowerCaseIngredientName + " have been removed.");
            }
        } else {
            PrintHandler.printString("Ingredient not found: " + lowerCaseIngredientName);
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
        for (Ingredient ingredientIterated : foodRegister.values()) {
            if (ingredientIterated.getIngredientName().equalsIgnoreCase(ingredientName)) {
                PrintHandler.searchIngredientPrint(ingredientIterated);
                found = true;
                break;
            }
        }
        if (!found) {
            PrintHandler.printString("Ingredient not found");
        }
    }


    /**
     * Displays all ingredients in the food storage.
     */
    public void showSortedIngredients() {
        float ingredientsValue = 0f;
        List<String> sortedKeys = new ArrayList<>(foodRegister.keySet());
        Collections.sort(sortedKeys);

        for (String key : sortedKeys) {
            Ingredient ingredient = foodRegister.get(key);
            PrintHandler.printIngredient(ingredient);
            ingredientsValue += (ingredient.getIngredientAmount() * ingredient.getIngredientPrice());
        }
        if(ingredientsValue >= 0){
            PrintHandler.printString("value of ingredients: " + ingredientsValue);
        }else PrintHandler.printString("No ingredients found");
    }

    /**
     * Displays all ingredients in the food storage that have expired before a given date.
     *
     * @param searchDate the date to compare against the expiration date
     */
    public void showExpiredIngredients(LocalDate searchDate) {
        float expiredIngredientsValue = 0f;
        for (Ingredient ingredient : foodRegister.values()) {
            if (ingredient.getIngredientExpirationDate().isBefore(searchDate)) {
                expiredIngredientsValue += (ingredient.getIngredientAmount() * ingredient.getIngredientPrice());
                PrintHandler.printIngredient(ingredient);

            }
        }
        if(expiredIngredientsValue >= 0){
            PrintHandler.printString("value of expired ingredients: " + expiredIngredientsValue);
        }else PrintHandler.printString("No expired ingredients found");
    }
}