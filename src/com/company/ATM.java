package com.company;

import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        String accNum, pin, answer;

        System.out.println("Enter account number:");
        accNum = keyboard.nextLine();

        Account account = new Account();

        accNum = accountNumberValidation(keyboard, accNum, account);

        System.out.println("Enter PIN:");
        pin = keyboard.nextLine();

        pinVerification(keyboard, accNum, pin, account);

        account.setUserName();
        account.setBalance();

        System.out.println("\nWelcome, " + account.getUserName()
                + "!\nWhat would you like to do today with your current balance?"
                + "\n(\"deposit\", \"withdraw\", \"check\" or \"exit\")");
        answer = keyboard.nextLine();

        atmActions(keyboard, answer, account);

        System.out.println("\n\nThank you for using this ATM. Good-bye!");
        keyboard.close();
    }

    private static void pinVerification(Scanner keyboard, String accNum, String pin, Account account) {
        while (!account.verifyPIN(accNum, pin)) {
            int numOfAttempts = 1;
            numOfAttempts++;
            System.out.println("Enter PIN again:");
            pin = keyboard.nextLine();
            if (numOfAttempts == 3 && !account.verifyPIN(accNum, pin)) {
                System.out.println("\nFailed to enter valid PIN\nTry again...");
                System.exit(0);
            }
        }
    }

    private static String accountNumberValidation(Scanner keyboard, String accNum, Account account) {
        while (!account.verifyAccountNumber(accNum)) {
            int numOfAttempts = 1;
            numOfAttempts++;
            System.out.println("Enter account number again:");
            accNum = keyboard.nextLine();

            if (numOfAttempts == 3 && !account.verifyAccountNumber(accNum)) {
                System.out.println("\nFailed to enter valid account number\nTry again...");
                System.exit(0);
            }
        }
        return accNum;
    }

    private static void atmActions(Scanner keyboard, String answer, Account account) {
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
    }
}