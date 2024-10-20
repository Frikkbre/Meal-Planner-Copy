package main.edu.ntnu.idi.bidata;
//import java.util.Date;
import java.time.LocalDate;

/**
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
 * @author Frikk Braendsrod
 * @since 20.10.24
 *
 * The Ingredient class holds information about ingredients added by user and handles mutator and accessor methods.
 *
 * This class holds the fields:
 * ingredientName, Type String
 * ingredientType, Type String because it holds a text description of type.
 * ingredientPrice, Type float because it holds deciamals for price. Float is used because the prices wont be high enough to need for example double.
 * ingredientAmout, Type float because the program needs to be flexible when you use for example half the milk.
 * ingredientUnit, Type String because it holds a text description of unit used for the ingredient.
 * ingredientExpirationDate, Type LocalDate beacuse it uses the Class LacalDate
 * ingredientIsExpired, Type boolean because it need to return either true or false.
 */
public class Ingredient {
    private String ingredientName;
    private String ingredientType;
    private float ingredientPrice;
    private int ingredientAmount;
    private String ingredientUnit; //Add to other methods!!
    private int ingredientExpirationDateYear;    //Date? check javaDocs
    private int ingredientExpirationDateMonth;
    private int ingredientExpirationDateDay;
    private LocalDate ingredientExpirationDate;
    private boolean ingredientIsExpired;


    /**
     * Takes input from user or constructor and gives it to field
     * @param ingredientName
     */
    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public void setIngredientType(String ingredientType) {
        this.ingredientType = ingredientType;
    }

    public void setIngredientPrice(float ingredientPrice) {
        this.ingredientPrice = ingredientPrice;
    }

    public void setIngredientAmount(int ingredientAmount) {
        this.ingredientAmount = ingredientAmount;
    }

    public void setIngredientExpirationDate(int ingredientExpirationDateYear, int ingredientExpirationDateMonth, int ingredientExpirationDateDay) {
        this.ingredientExpirationDate = LocalDate.of(ingredientExpirationDateYear, ingredientExpirationDateMonth, ingredientExpirationDateDay);
    }

    public void setIngredientIsExpired(boolean ingredientIsExpired) {
        this.ingredientIsExpired = ingredientIsExpired;
    }


    /**
     * Getters
     * @return
     */
    public String getIngredientName() {
        return ingredientName;
    }

    public String getIngredientType() {
        return ingredientType;
    }

    public boolean isIngredientIsExpired() {
        return ingredientIsExpired;
    }

    public float getIngredientPrice() {
        return ingredientPrice;
    }

    public int getIngredientAmount() {
        return ingredientAmount;
    }

    public LocalDate getIngredientExpirationDate() {
        return ingredientExpirationDate;
    }

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
    public Ingredient(String ingredientName, String ingredientType, float ingredientPrice, int ingredientAmount, int ingredientExpirationDateYear, int ingredientExpirationDateMonth, int ingredientExpirationDateDay) {
        setIngredientName(ingredientName);
        setIngredientType(ingredientType);
        setIngredientPrice(ingredientPrice);
        setIngredientAmount(ingredientAmount);
        setIngredientExpirationDate(ingredientExpirationDateYear, ingredientExpirationDateMonth, ingredientExpirationDateDay);
    }

    public void displayInformation() {
        System.out.println("Name: " + getIngredientName());
        System.out.println("Type: " + getIngredientType());
        System.out.println("Price: " + getIngredientPrice() + "kr");
        System.out.println("Amount: " + getIngredientAmount());
        //System.out.println("Expiration Date in: " + (getIngredientExpirationDate()-LocalDate.now())); Add "how many days until expiry?"
        System.out.println("Is Expired: " + getIngredientIsExpired());
    }


public static void main(String[] args) {
    // Create an ingredient
    main.edu.ntnu.idi.bidata.Ingredient bellPepper = new main.edu.ntnu.idi.bidata.Ingredient("Bell Pepper", "Vegetable", 19.90f, 5, 2024, 10, 19);

    LocalDate currentDate = LocalDate.now(); //https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/LocalDate.html#now()
    LocalDate expiryDate = LocalDate.of(2024,10,12);
    System.out.println(currentDate);
    System.out.println(bellPepper.ingredientExpirationDate);

    if(bellPepper.ingredientExpirationDate.equals(currentDate)){
        System.out.println("The ingredient is expiring today.");
        bellPepper.setIngredientIsExpired(false);
    }
    else if(bellPepper.ingredientExpirationDate.isBefore(currentDate)){
        System.out.println("The ingredient is expired.");
        bellPepper.setIngredientIsExpired(true);
    }
    else if(bellPepper.ingredientExpirationDate.isAfter(currentDate)){
        bellPepper.setIngredientIsExpired(false);
    }

    // Display information
    bellPepper.displayInformation();

}
}
