package com.company;

import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        String accNum, pin, answer;
        int accNumOrPINTries = 1;

        System.out.println("Enter account number:");
        accNum = keyboard.nextLine();

        Account account = new Account();

        while (!account.verifyAccountNumber(accNum)) {
            accNumOrPINTries++;
            System.out.println("Enter account number again:");
            accNum = keyboard.nextLine();

            if (accNumOrPINTries == 3 && !account.verifyAccountNumber(accNum)) {
                System.out.println("\nFailed to enter valid account number\nTry again...");
                System.exit(0);
            }
        }

        accNumOrPINTries = 1;
        System.out.println("Enter PIN:");
        pin = keyboard.nextLine();

        while (!account.verifyPIN(accNum, pin)) {
            accNumOrPINTries++;
            System.out.println("Enter PIN again:");
            pin = keyboard.nextLine();
            if (accNumOrPINTries == 3 && !account.verifyPIN(accNum, pin)) {
                System.out.println("\nFailed to enter valid PIN\nTry again...");
                System.exit(0);
            }
        }

        System.out.println("What would you like to do today with your current balance?" +
                "\n(\"deposit\", \"withdraw\", or \"check\")");
        answer = keyboard.nextLine();

        while (!answer.equalsIgnoreCase("exit")) {
            switch (answer) {
                case "deposit":
                    break;
                case "withdraw":
                    break;
                case "check":
                    break;
            }
        }

        System.out.println("Thank you for using this ATM. Good-bye!");
        // "6011111111111117", "1345"
        keyboard.close();
    }
}