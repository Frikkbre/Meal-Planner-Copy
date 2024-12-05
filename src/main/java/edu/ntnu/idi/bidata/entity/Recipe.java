package edu.ntnu.idi.bidata.entity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * The {@code Recipe} class is responsible for creating recipe.
 * It provides methods to set and get recipe name, description, ingredients and instructions.
 * <p>
 *  This class can pass recipes to CookBook where the recipes are stored.
 *
 * @version 0.0.2
 * @since 29.11.2024
 * @author Frikk Brændsrød
 */
public class Recipe {
  private String recipeName;
  private String recipeDescription;
  private HashMap <String, Float> recipeIngredients = new HashMap<>();
  private String recipeInstructions;
  private int intendedForAmountOfPeople;

  /**
   * returns the name of the recipe
   *
   * @return the name of the recipe
   */
  public String getRecipeName() {
    return recipeName;
  }

  /**
   * sets the name of the recipe and checks for illegal arguments
   * Illegal arguments are null or empty strings
   *
   * @param recipeName
   */
  public void setRecipeName(String recipeName) {
    if (recipeName == null || recipeName.isEmpty()) {
      throw new IllegalArgumentException("Recipe name cannot be null or empty");
    } else{
      this.recipeName = recipeName;
    }
  }

  /**
   * returns the description of the recipe
   * @return the description of the recipe
   */
  public String getRecipeDescription() {
    return recipeDescription;
  }

  /**
   * sets the description of the recipe and checks for illegal arguments
   * Illegal arguments are null or empty strings
   *
   * @param recipeDescription
   */
  public void setRecipeDescription(String recipeDescription) {
    if(recipeDescription == null || recipeDescription.isEmpty()){
      throw new IllegalArgumentException("Recipe description cannot be null or empty");
    } else {
      this.recipeDescription = recipeDescription;
    }
  }

  /**
   * returns the ingredients of the recipe
   * @return the ingredients of the recipe
   */
  public Map<String, Float> getRecipeIngredients() {
    return Collections.unmodifiableMap(recipeIngredients);
  }

  /**
   * sets the ingredients of the recipe and checks for illegal arguments
   * Illegal arguments are null or empty strings
   *<p>
   *   is ran through a loop to check if the amount of the ingredient is negative
   *   if it is, it throws an IllegalArgumentException
   *</p>
   *
   * @param recipeIngredients
   */
  public void setRecipeIngredients(HashMap<String, Float> recipeIngredients) {
    if (recipeIngredients == null || recipeIngredients.isEmpty() ||
        recipeIngredients.containsKey(null) || recipeIngredients.containsValue(null)) {
      throw new IllegalArgumentException("Recipe ingredients cannot be null or empty");
    }

    for (Float amount : recipeIngredients.values()) {
      if (amount < 0) {
        throw new IllegalArgumentException("Ingredient amount cannot be negative");
      }
    }

    this.recipeIngredients = recipeIngredients;
  }

  /**
   * returns the instructions of the recipe
   * @return the instructions of the recipe
   */
  public String getRecipeInstructions() {
    return recipeInstructions;
  }

  /**
   * sets the instructions of the recipe and checks for illegal arguments
   * Illegal arguments are null or empty strings
   *
   * @param recipeInstructions
   */
  public void setRecipeInstructions(String recipeInstructions) {
    if(recipeInstructions == null || recipeInstructions.isEmpty()){
      throw new IllegalArgumentException("Recipe instructions cannot be null or empty");
    } else {
      this.recipeInstructions = recipeInstructions;
    }
  }

  public int getIntendedForAmountOfPeople() {
    return intendedForAmountOfPeople;
  }

  public void setIntendedForAmountOfPeople(int intendedForAmountOfPeople) {
    if (intendedForAmountOfPeople <= 0) {
      throw new IllegalArgumentException("Intended for amount of people cannot be less than or equal to 0");
    }
    this.intendedForAmountOfPeople = intendedForAmountOfPeople;
  }

  /**
   * Constructor for the Recipe class
   * Used to create a new recipe
   *
   * @param recipeName
   * @param recipeDescription
   * @param recipeIngredients
   * @param recipeInstructions
   */
  public Recipe(String recipeName, String recipeDescription, HashMap recipeIngredients, String recipeInstructions, int intendedForAmountOfPeople) {
    this.recipeName = recipeName;
    this.recipeDescription = recipeDescription;
    this.recipeIngredients = recipeIngredients;
    this.recipeInstructions = recipeInstructions;
    this.intendedForAmountOfPeople = intendedForAmountOfPeople;
  }
}
