package edu.ntnu.idi.bidata.entity;

//import java.util.Date;

import java.time.LocalDate;


/**
 * @author Frikk Brændsrød TODO - try cathc
 * @version 0.0.1
 * <p>
 * The Ingredient class holds information about
 * ingredients added by user and handles mutator and accessor methods.
 * <p>
 * This class holds the fields:
 * <p>
 * ingredientName, Type String
 * <p>
 * ingredientType, Type String because it holds a text description of type.
 * <p>
 * ingredientPrice, Type float because it holds deciamals for price.
 * Float is used because the prices wont be high enough to need for example double.
 * <p>
 * ingredientAmout, Type float because the program needs
 * to be flexible when you use for example half the milk.
 *
 *
 * <p>
 * ingredientUnit, Type enum because it should once have a number of predetermined choices..
 * <p>
 * ingredientExpirationDate, Type LocalDate beacuse it uses
 * the Class LacalDate to format dates and use LocalDate.now()
 *
 * <p>
 * ingredientIsExpired, Type boolean because it need to return either true or false.
 * @since 20.10.24 TODO - bare for metoder?
 * @version 0.0.2
 */
public class Ingredient {
  private String ingredientName; //TODO - make this final?
  private String ingredientType;
  private float ingredientPrice;
  private float ingredientAmount;

  private enum ingredientUnit { kg, g, liter, pieces }

  ; //TODO - make it add s if > 1
  private String ingredientUnitChosen;
  private int ingredientUnitChoice;
  private LocalDate ingredientExpirationDate;
  private boolean ingredientIsExpired;

  /**
   * Default constructor for Ingredient class.
   */
  public Ingredient() {

  }


  /**
   * Sets ingredient name and checks for illegal inputs.
   *
   * @param ingredientName the name of the ingredient
   */
  public void setIngredientName(String ingredientName) {
    if (ingredientName == null || ingredientName.isBlank() || ingredientName.isEmpty()) {
      throw new IllegalArgumentException("Ingredient name cannot be empty");
    }
    this.ingredientName = ingredientName;
  }

  /**
   * Sets ingredient type and checks for illegal inputs.
   *
   * @param ingredientType the type of the ingredient
   */

  public void setIngredientType(String ingredientType) {
    if (ingredientType.isBlank() || ingredientType.isEmpty()) {
      throw new IllegalArgumentException("Ingredient type cannot be empty");
    }
    this.ingredientType = ingredientType;
  }

  /**
   * Sets ingredient price and checks for illegal inputs.
   *
   * @param ingredientPrice the price of the ingredient
   */
  public void setIngredientPrice(float ingredientPrice) {
    if (ingredientPrice < 0) {
      throw new IllegalArgumentException("Ingredient price cannot be negative or 0");
    }
    this.ingredientPrice = ingredientPrice;
  }

  /**
   * Sets ingredient amount and checks for illegal inputs.
   *
   * @param ingredientAmount the amount of the ingredient
   */
  public void setIngredientAmount(float ingredientAmount) {
    if (ingredientAmount < 0) {
      throw new IllegalArgumentException("Ingredient amount cannot be negative or 0");
    }
    this.ingredientAmount = ingredientAmount;
  }

  /**
   * Sets ingredient unit and checks for illegal inputs.
   *
   * @param ingredientUnitchoice the unit of the ingredient
   */
  public void setIngredientUnit(int ingredientUnitchoice) {
    if (ingredientUnitchoice >= 1 && ingredientUnitchoice <= 4) {
      switch (ingredientUnitchoice) { //TODO - refactor to hashmap and write refactoring in report
        case 1:
          this.ingredientUnitChosen = ingredientUnit.kg.toString();
          break;
        case 2:
          this.ingredientUnitChosen = ingredientUnit.g.toString();
          break;
        case 3:
          this.ingredientUnitChosen = ingredientUnit.liter.toString();
          break;
        case 4:
          this.ingredientUnitChosen = ingredientUnit.pieces.toString();
          break;
      }
    } else {
      throw new IllegalArgumentException("Ingredient unit choice must be between 1 and 4");
    }
  }


  /**
   * Sets ingredient expiration date with three inputs
   * divided into year month and day and checks for illegal inputs.
   *
   * @param ingredientExpirationDateYear year of expiration date
   * @param ingredientExpirationDateMonth month of expiration date
   * @param ingredientExpirationDateDay day of expiration date
   */
  public void setIngredientExpirationDate(int ingredientExpirationDateYear, int ingredientExpirationDateMonth, int ingredientExpirationDateDay) {
    if (ingredientExpirationDateYear < 0 || ingredientExpirationDateYear > 2099 || ingredientExpirationDateMonth < 0 || ingredientExpirationDateMonth > 12 || ingredientExpirationDateDay < 0 || ingredientExpirationDateDay > 32) {
      throw new IllegalArgumentException("Date format did not reach requirements, see documentation");
    }
    this.ingredientExpirationDate = LocalDate.of(ingredientExpirationDateYear, ingredientExpirationDateMonth, ingredientExpirationDateDay);
  }

  /**
   * Sets ingredient is expired boolean with todays date and input date.
   *
   * @param ingredientIsExpired boolean value of if ingredient is expired
   */
  public void setIngredientIsExpired(boolean ingredientIsExpired, LocalDate ingredientExpirationDate) { //TODO - make this method work. Is never called?
    if (ingredientExpirationDate.isBefore(LocalDate.now())) {        //TODO - move this to setIngredientExpirationDate?
      this.ingredientIsExpired = true;
    }
    else if (ingredientExpirationDate.isAfter(LocalDate.now())) {
      this.ingredientIsExpired = false;
    }
  }


//TODO - Getters not showing up in javadoc

  /**
   * returns name of ingredient
   *
   * @return ingredient name
   */
  public String getIngredientName() {
    return ingredientName;
  }

  /**
   * @return the type of ingredient
   */
  public String getIngredientType() {
    return ingredientType;
  }

  /**
   * @return the ingredient price
   */
  public float getIngredientPrice() {
    return ingredientPrice;
  }

  /**
   * @return the ingredient amount
   */
  public float getIngredientAmount() {
    return ingredientAmount;
  }

  /**
   * @return the ingredient unit
   */
  public String getIngredientUnit() {
    return ingredientUnitChosen;
  }

  /**
   * @return the ingredient expiration date
   */
  public LocalDate getIngredientExpirationDate() {
    return ingredientExpirationDate;
  }

  /**
   * @return true or false based on expirqtion date
   */
  public boolean getIngredientIsExpired() {
    this.setIngredientIsExpired(false, ingredientExpirationDate);
    return ingredientIsExpired;
  }


  /**
   * Constructor for Ingredient class.
   * calls the set methods for the fields.
   * used to create an object of the class in the main method.
   *
   * @param ingredientType the type of ingredient
   * @param ingredientName the name of the ingredient
   * @param ingredientPrice the price of the ingredient
   * @param ingredientAmount the amount of the ingredient
   * @param ingredientExpirationDateYear the year of expiration date
   * @param ingredientExpirationDateMonth the month of expiration date
   * @param ingredientExpirationDateDay the day of expiration date
   */
  public Ingredient(String ingredientName, String ingredientType, float ingredientPrice, float ingredientAmount, int ingredientUnitChoice, int ingredientExpirationDateYear, int ingredientExpirationDateMonth, int ingredientExpirationDateDay) {
    setIngredientName(ingredientName);
    setIngredientType(ingredientType); //TODO - this.???
    setIngredientPrice(ingredientPrice);
    setIngredientAmount(ingredientAmount);
    setIngredientUnit(ingredientUnitChoice);
    setIngredientExpirationDate(ingredientExpirationDateYear, ingredientExpirationDateMonth, ingredientExpirationDateDay);
  }
}