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

    private HashMap<String, Ingredient> foodRegister = new HashMap<>();

    static Map<String, Integer> sortedMap = new HashMap<>();

    Scanner inputScanner = new Scanner(System.in);

    public FoodStorage(MealPlannerApp mealPlannerApp) {

    }


    /**
     * Adds initial ingredients to the food storage.
     * Is ran from the initializeApplication method in the MealPlannerApp class.
     */
    public void addInitIngredient() {
        Ingredient bellPepper = new Ingredient("Bell Pepper", "Vegetable", 19.90f, 5, 4, 2024, 12, 24);
        Ingredient tomato = new Ingredient("Tomato", "Vegetable", 14.90f, 5, 4, 2024, 12, 31);
        Ingredient onion = new Ingredient("Onion", "Vegetable", 9.90f, 5, 4, 2024, 12, 30);
        Ingredient garlic = new Ingredient("Garlic", "Vegetable", 9.90f, 5, 4, 2024, 10, 11);
        Ingredient milk = new Ingredient("Milk", "Dairy", 14.90f, 5, 3, 2024, 11, 22);

        foodRegister.put("bell pepper", bellPepper);
        foodRegister.put("tomato", tomato);
        foodRegister.put("onion", onion);
        foodRegister.put("garlic", garlic);
        foodRegister.put("milk", milk);
    }

    /**
     * Adds a new ingredient to the food storage.
     * If the ingredient already exists in the storage, the amount is increased.
     */
    public void addIngredient(Ingredient newIngredient) { // newIngredient) {
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
    public void removeIngredient(String ingredientName, int amountToRemove) {
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
                PrintHandler.printString(amountToRemove + " units of " + lowerCaseIngredientName + " have been removed."); //TODO - Make units dynamic.
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
                break; // TODO - is this nessesary?
            }
        }
        //If the ingredient is not found, print a message
        if (!found) {
            PrintHandler.printString("Ingredient not found");
        }
    }

    /**
     * Removes an ingredient from the food storage based on its name.
     *
     * @param ingredientName the name of the ingredient to be removed
     */
    public void removeIngredient(String ingredientName) {
        if (foodRegister.containsKey(ingredientName)) {
            foodRegister.remove(ingredientName);
            PrintHandler.printString("Ingredient removed");
        } else {
            PrintHandler.printString("Ingredient not found");
        }
    }

    /**
     * Displays all ingredients in the food storage.
     */
    public void showSortedIngredients() { //TODO - use stream instead?
        List<String> sortedKeys = new ArrayList<>(foodRegister.keySet());
        Collections.sort(sortedKeys);

        for (String key : sortedKeys) {
            Ingredient ingredient = foodRegister.get(key);
            PrintHandler.printIngredient(ingredient);
        }
    }

    /**
     * Displays all ingredients in the food storage that have expired before a given date.
     *
     * @param searchDate the date to compare against the expiration date
     */
    public void showExpiredIngredients(LocalDate searchDate) {
        for (Ingredient ingredient : foodRegister.values()) {
            if (ingredient.getIngredientExpirationDate().isBefore(searchDate)) {
                PrintHandler.printIngredient(ingredient);
            }
        }
    }
}