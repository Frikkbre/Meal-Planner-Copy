package edu.ntnu.idi.bidata.utility;

public class Recipe { //TODO - Should this be hardcoded or should it be user input?
    private String recipeName;
    private String recipeDescription;
    private String recipeIngredients;
    private String recipeInstructions;
    private String recipeCategory;
    private String recipeDifficulty;
    private String recipeTime;


  public String getRecipeName() {
    return recipeName;
  }

  public void setRecipeName(String recipeName) {
    this.recipeName = recipeName;
  }

  public String getRecipeDescription() {
    return recipeDescription;
  }

  public void setRecipeDescription(String recipeDescription) {
    this.recipeDescription = recipeDescription;
  }

  public String getRecipeIngredients() {
    return recipeIngredients;
  }

  public void setRecipeIngredients(String recipeIngredients) {
    this.recipeIngredients = recipeIngredients;
  }

  public String getRecipeTime() {
    return recipeTime;
  }

  public void setRecipeTime(String recipeTime) {
    this.recipeTime = recipeTime;
  }

  public String getRecipeDifficulty() {
    return recipeDifficulty;
  }

  public void setRecipeDifficulty(String recipeDifficulty) {
    this.recipeDifficulty = recipeDifficulty;
  }

  public String getRecipeCategory() {
    return recipeCategory;
  }

  public void setRecipeCategory(String recipeCategory) {
    this.recipeCategory = recipeCategory;
  }

  public String getRecipeInstructions() {
    return recipeInstructions;
  }

  public void setRecipeInstructions(String recipeInstructions) {
    this.recipeInstructions = recipeInstructions;
  }

  public Recipe(String recipeName, String recipeDescription, String recipeIngredients, String recipeInstructions, String recipeCategory, String recipeDifficulty, String recipeTime) {
        this.recipeName = recipeName;
        this.recipeDescription = recipeDescription;
        this.recipeIngredients = recipeIngredients;
        this.recipeInstructions = recipeInstructions;
        this.recipeCategory = recipeCategory;
        this.recipeDifficulty = recipeDifficulty;
        this.recipeTime = recipeTime;
    }
}
