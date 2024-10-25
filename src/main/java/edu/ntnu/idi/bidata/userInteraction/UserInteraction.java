package edu.ntnu.idi.bidata.userInteraction;


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

        System.out.println("How many ingredients do you want to add?");
        int howManyIngredients = inputScanner.nextInt();

        for (int indexOfInput = 0; indexOfInput < howManyIngredients; indexOfInput++){

            System.out.println("What is the name of the ingredient?");
            String ingredientName = inputScanner.nextLine();

            System.out.println("What type of ingredient is it?");
            String ingredientType = inputScanner.nextLine();

            System.out.println("What does the ingredient cost?");
            float ingredientPrice = inputScanner.nextInt();

            System.out.println("How many/much do you have?");
            float ingredientAmount = inputScanner.nextFloat();

            System.out.println("What unit is it?");
            String ingredientUnit = inputScanner.nextLine();

            System.out.println("What year does it expire? (xxxx)");
            int ingredientExpirationYear = inputScanner.nextInt();

            System.out.println("What month does it expire= (xx)");
            int ingredientExpirationMonth = inputScanner.nextInt();

            System.out.println("What day does it expire? (xx)");
            int ingredientExpirationDay = inputScanner.nextInt();

            main.edu.ntnu.idi.bidata.Ingredient ingredient = new main.edu.ntnu.idi.bidata.Ingredient(ingredientName, ingredientType, ingredientPrice, (int) ingredientAmount, ingredientUnit, ingredientExpirationYear, ingredientExpirationMonth, ingredientExpirationDay);
        }
    }
}

