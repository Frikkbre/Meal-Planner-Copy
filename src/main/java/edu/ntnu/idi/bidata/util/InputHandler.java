package edu.ntnu.idi.bidata.util;

import java.util.Scanner;

public class InputHandler {
  private static Scanner inputScanner;

  /**
   * Constructor for the InputHandler class.
   * @param inputScanner
   */
  public InputHandler(Scanner inputScanner) {
    this.inputScanner = inputScanner;
  }

  /**
   * Method for handling integer input.
   * @return
   */
  public static int intInput() {
    String input = inputScanner.nextLine();
    if (input.matches(".*[a-zA-Z].*")) {
      throw new IllegalArgumentException("Input contains letters");
    }
    return Integer.parseInt(input);
  }

  /**
   * Method for handling string input.
   * @return
   */
  public static String stringInput(){ //TODO - Add exception handling
    String input = inputScanner.nextLine();
    if (input.matches(".*\\d.*")) {
      throw new IllegalArgumentException("Input contains numbers");
    }
    return input;

  }

  /**
   * Method for handling float input.
   * @return
   */
  public static Float floatInput() {
    String input = inputScanner.nextLine();
    if (input.matches(".*[a-zA-Z].*")) {
      throw new IllegalArgumentException("Input contains letters");
    }
    return Float.parseFloat(input);
  }
}