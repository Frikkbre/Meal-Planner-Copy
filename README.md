[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/RyiBKJgD)
# Portfolio project IDATA1003

[//]: # (TODO: Fill inn your name and student ID)

STUDENT NAME = Frikk Brændsrød  
STUDENT ID = 134149

## Project description

[//]
This project is a meal planning application. The user can add recipes to the application, and add their available ingredients. \
The application will then suggest recipes based on the ingredients the user has. The user can edit the recipes, add new recipes.\
The application will delete used ingredients from the user's inventory when a recipe is used.\
The user remains in controll of tjhe inventory, and can add and remove ingredients as they please.

## Project structure

[//]: # (TODO: Describe the structure of your project here. How have you used packages in your structure. Where are all sourcefiles stored. Where are all JUnit-test classes stored. etc.)

The project is structured in the following way:
- The main class is `main.java`
- The startApplication method is in `MealPlanner.java`
- The source files are stored in the `src/java/edu/ntnu/idi/bidata/` directory
- From here they are stored in different packages
  - `Main.java` is in `bidata/`
  - `entity` contains the classes `Recipe.java` and `Ingredient.java`
  - `registr` contains the classes `CookBook.java` and `FoodStorage.java`
  - `userinterface` contains the class `MealPlannerApp.java`
  - `util` contains the classes `InputHandler.java` and `PrintHandler.java`

- The JUnit-test classes are stored in the `src/java/edu/ntnu/idi/bidata/` directory



## Link to repository

[//]: # (TODO: Is this the correct link?)
https://github.com/NTNU-BIDATA-IDATG1003-2024/meal-planning-Frikkbre.git

## Link to report repository

https://github.com/Frikkbre/Mealplanner-rapport.git

## How to run the project

[//]: # (TODO: Describe how to run your project here. What is the main class? What is the main method?
What is the input and output of the program? What is the expected behaviour of the program?)

To run the program, either download the project and run it in your IDE, or clone the repository and run it in your IDE.

## How to run the tests

[//]: # (TODO: Describe how to run the tests here.)

## References

[//]: # (TODO: Include references here, if any. For example, if you have used code from the course book, include a reference to the chapter.
Or if you have used code from a website or other source, include a link to the source.)
