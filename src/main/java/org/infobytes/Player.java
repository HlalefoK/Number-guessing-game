package org.infobytes;

import java.io.InputStream;
import java.util.Scanner;

public class Player {
    private final Scanner inputScanner;
    private int numGuesses;

    public Player() {

        this.inputScanner = new Scanner(System.in);
        this.numGuesses = 12;
    }

    public Player(InputStream inputStream) {
        this.inputScanner = new Scanner(inputStream);
        this.numGuesses = 12;
    }

    /**
     * Gets a guess from user via text console.
     * This must prompt the user to re-enter a guess until a valid 4-digit string is
     * entered, or until the user enters `exit` or `quit`.
     *
     * @return the value entered by the user
     */
    public String getGuess() {
        // Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Input 3 digit code:");
            String input = this.inputScanner.nextLine();
            if (input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("quit")) {
                System.exit(0);
            } else if (input.length() != 3 || !isValidCode(input)) {
                System.out.println("Please enter exactly 3 digits (each from 1 to 9).");
            } else {
                return input;
            }
        }
    }

    public void lose() {
        numGuesses--;
    }

    public int getNumGuesses() {
        return numGuesses;
    }

    /**
     * In this method is to check if the string contains exactly four characters,
     * and each of those four characters is a digit between 1 and 9.
     * [1-9] matches any number between 1 and 9.
     * {3} matches the above characters but four of them.
     */
    private boolean isValidCode(String code) {
        return code.matches("[1-9]{3}");
    }
}
