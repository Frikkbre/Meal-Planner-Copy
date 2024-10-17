package main.edu.ntnu.idi.bidata;
//import java.util.Date;
import java.time.LocalDate;




public class Ingredients {
    private String ingredientName;
    private String ingredientType;
    private int ingredientPrice;
    private int ingredientAmount;
    private String ingredientExpirationDate;    //Date? check javaDocs
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

    public void setIngredientPrice(int ingredientPrice) {
        this.ingredientPrice = ingredientPrice;
    }

    public void setIngredientAmount(int ingredientAmount) {
        this.ingredientAmount = ingredientAmount;
    }

    public void setIngredientExpirationDate(String ingredientExpirationDate) {
        this.ingredientExpirationDate = ingredientExpirationDate;
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

    public int getIngredientPrice() {
        return ingredientPrice;
    }

    public int getIngredientAmount() {
        return ingredientAmount;
    }

    public String getIngredientExpirationDate() {
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
     * @param ingredientExpirationDate
     * @param ingredientIsExpiredIsExpired
     */
    public Ingredients(String ingredientName, String ingredientType, int ingredientPrice, int ingredientAmount, String ingredientExpirationDate, boolean ingredientIsExpiredIsExpired) {
        setIngredientName(ingredientName);
        setIngredientType(ingredientType);
        setIngredientPrice(ingredientPrice);
        setIngredientAmount(ingredientAmount);
        setIngredientExpirationDate(ingredientExpirationDate);
        setIngredientIsExpired(ingredientIsExpired);
    }

    public void displayInformation() {
        System.out.println("Name: " + getIngredientName());
        System.out.println("Type: " + getIngredientType());
        System.out.println("Price: " + getIngredientPrice() + "kr");
        System.out.println("Amount: " + getIngredientAmount());
        System.out.println("Expiration Date in: " + getIngredientExpirationDate() + " days");
        System.out.println("Is Expired: " + getIngredientIsExpired());
    }


public static void main(String[] args) {
    // Create an ingredient
    Ingredients bellPepper = new Ingredients("Bell Pepper", "Vegetable", 19, 5, "12", false);

    LocalDate currentDate = LocalDate.now(); //https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/LocalDate.html#now()
    LocalDate expiryDate = LocalDate.of(2024,10,12);
    System.out.println(currentDate);
    System.out.println(expiryDate);

    if(expiryDate.equals(currentDate)){
        System.out.println("The ingredient is expiring today.");
        bellPepper.setIngredientIsExpired(true);
    }
    else if(expiryDate.isBefore(currentDate)){
        System.out.println("The ingredient is expired.");
    }

    // Display information
    bellPepper.displayInformation();
}
}
