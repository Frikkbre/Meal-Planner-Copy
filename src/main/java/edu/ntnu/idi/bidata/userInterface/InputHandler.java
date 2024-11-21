package edu.ntnu.idi.bidata.userInterface;

import edu.ntnu.idi.bidata.FoodStorage;
import edu.ntnu.idi.bidata.entity.Ingredient;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * The {@code InputHandler} class is responsible for handling user input.
 */
public class InputHandler { //TODO - Do i move menu here?

    private Scanner inputScanner = new Scanner(System.in);
    FoodStorage foodStorage = new FoodStorage();


    public void addIngredient() {
        System.out.println("How many different ingredients do you want to add?");
        int howManyIngredients = inputScanner.nextInt();
        inputScanner.nextLine();

        for (int indexOfInput = 0; indexOfInput < howManyIngredients; indexOfInput++) {
            System.out.println("What is the name of the ingredient?");
            String ingredientName = inputScanner.nextLine();

            System.out.println("What type of ingredient is it?");
            String ingredientType = inputScanner.nextLine();

            System.out.println("What does the ingredient cost?");
            float ingredientPrice = inputScanner.nextFloat();
            inputScanner.nextLine();

            System.out.println("How many/much do you have?");
            float ingredientAmount = inputScanner.nextFloat();
            inputScanner.nextLine();

            System.out.println("What unit is it?, 1 = kg, 2 = g, 3 = liter, 4 = pieces");
            int ingredientUnitChoice = inputScanner.nextInt();
            inputScanner.nextLine();

            System.out.println("What year does it expire? (xxxx)");
            int ingredientExpirationYear = inputScanner.nextInt();
            inputScanner.nextLine();

            System.out.println("What month does it expire? (xx)");
            int ingredientExpirationMonth = inputScanner.nextInt();
            inputScanner.nextLine();

            System.out.println("What day does it expire? (xx)");
            int ingredientExpirationDay = inputScanner.nextInt();
            inputScanner.nextLine();

            Ingredient newIngredient = new Ingredient(ingredientName, ingredientType, ingredientPrice,
                ingredientAmount, ingredientUnitChoice, ingredientExpirationYear,
                ingredientExpirationMonth, ingredientExpirationDay);

            foodStorage.addIngredient();

            //newIngredient.displayInformation();

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                System.out.println("Sleep failed: " + e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }

    // Other methods for removing and searching ingredients can be added here
}