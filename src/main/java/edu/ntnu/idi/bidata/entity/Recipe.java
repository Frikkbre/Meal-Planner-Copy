package edu.ntnu.idi.bidata.entity;

public class Recipe { //TODO - Should this be hardcoded or should it be user input?
  private String recipeName;
  private String recipeDescription;
  private String recipeIngredients;
  private String recipeInstructions;


  public String getRecipeName() {
    return recipeName;
  }

  public void setRecipeName(String recipeName) {
    if (recipeName == null || recipeName.isEmpty()) {
      throw new IllegalArgumentException("Recipe name cannot be null or empty");
    } else{
      this.recipeName = recipeName;
    }
  }

  public String getRecipeDescription() {
    return recipeDescription;
  }

  public void setRecipeDescription(String recipeDescription) {
    if(recipeDescription == null || recipeDescription.isEmpty()){
      throw new IllegalArgumentException("Recipe description cannot be null or empty");
    } else {
      this.recipeDescription = recipeDescription;
    }
  }

  public String getRecipeIngredients() {
    return recipeIngredients;
  }

  public void setRecipeIngredients(String recipeIngredients) {
    if(recipeIngredients == null || recipeIngredients.isEmpty()){
      throw new IllegalArgumentException("Recipe ingredients cannot be null or empty");
    } else {
      this.recipeIngredients = recipeIngredients;
    }
  }

  public String getRecipeInstructions() {
    return recipeInstructions;
  }

  public void setRecipeInstructions(String recipeInstructions) {
    if(recipeInstructions == null || recipeInstructions.isEmpty()){
      throw new IllegalArgumentException("Recipe instructions cannot be null or empty");
    } else {
      this.recipeInstructions = recipeInstructions;
    }
  }

  public Recipe(String recipeName, String recipeDescription, String recipeIngredients, String recipeInstructions,
                String recipeCategory, String recipeDifficulty, String recipeTime) {
    this.recipeName = recipeName;
    this.recipeDescription = recipeDescription;
    this.recipeIngredients = recipeIngredients;
    this.recipeInstructions = recipeInstructions;
  }
}
