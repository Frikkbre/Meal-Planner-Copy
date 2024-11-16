package edu.ntnu.idi.bidata;

import edu.ntnu.idi.bidata.userInteraction.UserInteraction;
import edu.ntnu.idi.bidata.utility.Ingredient;
import java.util.HashMap;

/**
 * The {@code FoodStorage} class is responsible for managing a collection of ingredients.
 * It provides methods to add, remove, and search for ingredients within the storage.
 * <p>
 * This class interacts with {@link UserInteraction} for potential user input handling
 * and uses a HashMap to store ingredients where the key is the ingredient name
 * and the value is the {@link Ingredient} object.
 * </p>
 *
 * @author Frikk Brændsrød
 * @version 1.0
 */
public class FoodStorage {

    private UserInteraction userInteraction = new UserInteraction();
    private HashMap<String, Ingredient> foodStorage = new HashMap<>();

    /**
     * Adds a new ingredient to the food storage.
     *
     * @param newIngredient the {@link Ingredient} to be added to the storage
     */
    public void addIngredient(Ingredient newIngredient){
        foodStorage.put(newIngredient.getIngredientName(), newIngredient);
    }

    /**
     * Removes an ingredient from the food storage based on the ingredient object.
     *
     * @param ingredient the {@link Ingredient} to be removed from the storage
     */
    public void removeIngredient(Ingredient ingredient){
        foodStorage.remove(ingredient.getIngredientName());
    }

    /**
     * Searches for an ingredient in the food storage by name and displays the result.
     *
     * @param ingredientName the name of the ingredient to search for
     */
    public void searchIngredient(String ingredientName){
        if(foodStorage.containsKey(ingredientName)){
            System.out.println("Ingredient found: " + foodStorage.get(ingredientName));
        } else {
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