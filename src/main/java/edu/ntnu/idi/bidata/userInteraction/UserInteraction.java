package edu.ntnu.idi.bidata.userInteraction;

import main.edu.ntnu.idi.bidata.Ingredient;
import java.util.Scanner;

public class UserInteraction {
    /**
     * Should have fields like HashMap(key = ingredient, value = amount) used for recipes.
     * other fields like
     *
     * take userinput here? add food and such. yes
     */




    public static void main(String[]args){

        Scanner inputScanner = new Scanner(System.in);

        System.out.println("How many different ingredients do you want to add?");
        int howManyIngredients = inputScanner.nextInt();
        inputScanner.nextLine();

        for (int indexOfInput = 0; indexOfInput < howManyIngredients; indexOfInput++){

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

            System.out.println("What year does it expire? (xxxx)");
            int ingredientExpirationYear = inputScanner.nextInt();
            inputScanner.nextLine();

            System.out.println("What month does it expire= (xx)");
            int ingredientExpirationMonth = inputScanner.nextInt();
            inputScanner.nextLine();

            System.out.println("What day does it expire? (xx)");
            int ingredientExpirationDay = inputScanner.nextInt();
            inputScanner.nextLine();

            Ingredient ingredient = new Ingredient(ingredientName, ingredientType, ingredientPrice, (int) ingredientAmount, ingredientUnitChoice, ingredientExpirationYear, ingredientExpirationMonth, ingredientExpirationDay);
            ingredient.displayInformation();
        }
    }
}

