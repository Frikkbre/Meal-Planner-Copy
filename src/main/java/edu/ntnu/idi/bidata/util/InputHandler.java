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
  public static int intInput() { //TODO - Add exception handling
    int input = inputScanner.nextInt();
    inputScanner.nextLine();

    return input;
  }

  /**
   * Method for handling string input.
   * @return
   */
  public static String stringInput(){ //TODO - Add exception handling
    return inputScanner.nextLine();
  }

  /**
   * Method for handling float input.
   * @return
   */
  public static Float floatInput(){
    float input = inputScanner.nextFloat();
    inputScanner.nextLine();

    return input;
  }
}