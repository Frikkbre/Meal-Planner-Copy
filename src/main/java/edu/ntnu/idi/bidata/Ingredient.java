package main.edu.ntnu.idi.bidata;

//import java.util.Date;
import java.time.LocalDate;

/**
 *
 * HVA MÅ DOKUMENTERES?
 * Rolle/ansvar
 * • Hvilke informasjon klassen holder på og hvilke datatyper du har valgt for hver info og
 * hvorfor (begrunnelse)
 * • En vurdering av hvilke informasjon skal kun settes ved opprettelse av instans, og
 * hvilken informasjon må kunne endres etter at instansen er opprettet
 * • Hvordan klassen responderer på ugyldige data - hvilken strategi følger klassen (kaster
 * unntak? setter dummy-verdi?)
 */


/**
 * @author Frikk Braendsroe¥d
 * @since 20.10.24
 * @version 0.0.1
 *
 *     The Ingredient class holds information about ingredients added by user and handles mutator and accessor methods.
 *
 *     This class holds the fields:
 *     ingredientName, Type String
 *     ingredientType, Type String because it holds a text description of type.
 *     ingredientPrice, Type float because it holds deciamals for price. Float is used because the prices wont be high enough to need for example double.
 *     ingredientAmout, Type float because the program needs to be flexible when you use for example half the milk.
 *     ingredientUnit, Type String because it holds a text description of unit used for the ingredient.
 *     ingredientExpirationDate, Type LocalDate beacuse it uses the Class LacalDate
 *     ingredientIsExpired, Type boolean because it need to return either true or false.
 */
public class Ingredient {
    private String ingredientName;
    private String ingredientType;
    private float ingredientPrice;
    private float ingredientAmount;
    private String ingredientUnit; //Add to other methods!!   TODO - make Enum.
    /*private int ingredientExpirationDateYear;
    private int ingredientExpirationDateMonth;
    private int ingredientExpirationDateDay;*/
    private LocalDate ingredientExpirationDate;
    private boolean ingredientIsExpired;

    public Ingredient() {

    }


    /**
     *    Sets ingredient name and checks for illegal inputs
     *
     *    @param ingredientName
     */
    public void setIngredientName(String ingredientName) {
        if(ingredientName == null || ingredientName.isBlank() || ingredientName.isEmpty()){
            throw new IllegalArgumentException("Ingredient name cannot be empty");
        }
        this.ingredientName = ingredientName;
    }

    /**
     *    Sets ingredient type and checks for illegal inputs
     *
     *    @param ingredientType
     */

    public void setIngredientType(String ingredientType) {
        if(ingredientType.isBlank() || ingredientType.isEmpty()){
            throw new IllegalArgumentException("Ingredient type cannot be empty");
        }
        this.ingredientType = ingredientType;
    }

    /**
     *    Sets ingredient price and checks for illegal inputs
     *
     *    @param ingredientPrice
     */
    public void setIngredientPrice(float ingredientPrice) {
        if(ingredientPrice < 0){
            throw new IllegalArgumentException("Ingredient price cannot be negative");
        }
        this.ingredientPrice = ingredientPrice;
    }

    /**
     *    Sets ingredient amount and checks for illegal inputs
     *
     *    @param ingredientAmount
     */
    public void setIngredientAmount(float ingredientAmount) {
        if(ingredientAmount < 0){
            throw new IllegalArgumentException("Ingredient amount cannot be negative");
        }
        this.ingredientAmount = ingredientAmount;
    }

    /**
     *    Sets ingredient unit and checks for illegal inputs
     *
     *    @param ingredientUnit
     */
    public void setIngredientUnit(String ingredientUnit) {
        if(ingredientUnit.isBlank() || ingredientUnit.isBlank()){
            throw new IllegalArgumentException("Ingredient unit cannot be empty");
        }
        this.ingredientUnit = ingredientUnit;
    }

    /**
     *    Sets ingredient expiration date with three inputs divided into year month and day and checks for illegal inputs
     *
     *    @param ingredientExpirationDateYear
     *    @param ingredientExpirationDateMonth
     *    @param ingredientExpirationDateDay
     */
    public void setIngredientExpirationDate(int ingredientExpirationDateYear, int ingredientExpirationDateMonth, int ingredientExpirationDateDay) {
        if(ingredientExpirationDateYear < 0 || ingredientExpirationDateYear > 2099 || ingredientExpirationDateMonth < 0 ||ingredientExpirationDateMonth > 12 || ingredientExpirationDateDay < 0 || ingredientExpirationDateDay > 31){
            throw new IllegalArgumentException("Date format did not reach requirements, see documentation");
        }
        this.ingredientExpirationDate = LocalDate.of(ingredientExpirationDateYear, ingredientExpirationDateMonth, ingredientExpirationDateDay);
    }

    /**
     *    Sets ingredient is expired boolean with todays date and input date.
     *
     *    @param ingredientIsExpired
     */
    public void setIngredientIsExpired(boolean ingredientIsExpired) {
        if(ingredientExpirationDate.isBefore(LocalDate.now()))
            this.ingredientIsExpired = true;
        else{
            this.ingredientIsExpired = false;
        }
    }



    /**
     * @return name of ingredient
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
        return ingredientUnit;
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
        return ingredientIsExpired;
    }


    /**
     *
     * @param ingredientType
     * @param ingredientName
     * @param ingredientPrice
     * @param ingredientAmount
     * @param ingredientExpirationDateYear
     * @param ingredientExpirationDateMonth
     * @param ingredientExpirationDateDay
     */
    public Ingredient(String ingredientName, String ingredientType, float ingredientPrice, int ingredientAmount, String ingredientUnit, int ingredientExpirationDateYear, int ingredientExpirationDateMonth, int ingredientExpirationDateDay) {
        setIngredientName(ingredientName);
        setIngredientType(ingredientType);
        setIngredientPrice(ingredientPrice);
        setIngredientAmount(ingredientAmount);
        setIngredientUnit(ingredientUnit);
        setIngredientExpirationDate(ingredientExpirationDateYear, ingredientExpirationDateMonth, ingredientExpirationDateDay);
    }

    /**
     * prints all information stored about the given object.
     */
    public void displayInformation() {
        System.out.println("Name: " + getIngredientName());
        System.out.println("Type: " + getIngredientType());
        System.out.println("Price: " + getIngredientPrice() + "kr");
        System.out.println("Amount: " + getIngredientAmount());
        System.out.println("Unit: " + getIngredientUnit());
        System.out.println("Is Expired: " + getIngredientIsExpired());
    }


public static void main(String[] args) {
    // Create an ingredient
    main.edu.ntnu.idi.bidata.Ingredient bellPepper = new main.edu.ntnu.idi.bidata.Ingredient("Bell Pepper", "Vegetable", 19.90f, 5, "pieces", 2024, 10, 19);

    LocalDate currentDate = LocalDate.now(); //https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/LocalDate.html#now()
    LocalDate expiryDate = LocalDate.of(2024,10,12);
    System.out.println(currentDate);
    System.out.println(bellPepper.ingredientExpirationDate);

    // Display information
    bellPepper.displayInformation();

}
}