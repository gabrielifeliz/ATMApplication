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

        account.setUserName();
        account.setBalance();

        System.out.println("\nWelcome, " + account.getUserName()
                + "!\nWhat would you like to do today with your current balance?"
                + "\n(\"deposit\", \"withdraw\", or \"check\")");
        answer = keyboard.nextLine();

        while (!answer.equalsIgnoreCase("exit")) {
            switch (answer) {
                case "deposit":
                    System.out.println("How much do you want to deposit? ");
                    answer = keyboard.nextLine();
                    System.out.println(account.deposit(Double.parseDouble(answer)));
                    System.out.println("What else would you like to do?");
                    answer = keyboard.nextLine();
                    break;
                case "withdraw":
                    System.out.println("How much do you want to withdraw? ");
                    answer = keyboard.nextLine();
                    System.out.println(account.withdraw(Double.parseDouble(answer)));
                    System.out.println("What else would you like to do?");
                    answer = keyboard.nextLine();
                    break;
                case "check":
                    System.out.println(account.checkBalance());
                    System.out.println("What else would you like to do?");
                    answer = keyboard.nextLine();
                    break;
            }
        }

        System.out.println("\n\nThank you for using this ATM. Good-bye!");
        // "5555555555554444", "2371"
        keyboard.close();
    }
}