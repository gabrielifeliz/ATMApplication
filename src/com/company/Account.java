package com.company;

import java.util.HashMap;

public class Account {

    private String accountNumber;
    private String pin;
    private String userName;
    private double balance = 0.00;
    private HashMap<String, String> accNumAndPIN = new HashMap<>();

    public Account() {
        setAccountInfo();
    }

    public void setAccountInfo() {
        accNumAndPIN.put("6011111111111117", "1345");
        accNumAndPIN.put("5555555555554444", "2371");
        accNumAndPIN.put("4111111111111111", "9234");
    }

    public boolean verifyAccountNumber(String accountNumber) {
        boolean isAccountNumberValid = false;

        for (int i = 0; i < accNumAndPIN.size(); i++) {
            isAccountNumberValid = accNumAndPIN.containsKey(accountNumber);
            this.accountNumber = (isAccountNumberValid) ? accountNumber : null;
        }
        return isAccountNumberValid;
    }

    public boolean verifyPIN(String accountNumber, String pin) {
        boolean isPINValid = false;

        for (int i = 0; i < accNumAndPIN.size(); i++) {
            isPINValid = accNumAndPIN.get(accountNumber).equalsIgnoreCase(pin);
            this.pin = (isPINValid) ? pin : null;
        }
        return isPINValid;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName() {
        switch (accountNumber) {
            case "6011111111111117":
                userName = (pin.equalsIgnoreCase("1345"))
                        ? "Joel Fernandez" : null;
                break;
            case "5555555555554444":
                userName = (pin.equalsIgnoreCase("2371"))
                        ? "Stuart Gregory" : null;
                break;
            case "4111111111111111":
                userName = (pin.equalsIgnoreCase("9234"))
                        ? "Kani Sharma": null;
                break;
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance() {
        switch (accountNumber) {
            case "6011111111111117":
                balance = (pin.equalsIgnoreCase("1345"))
                        ? 6738.22 : 0;
                break;
            case "5555555555554444":
                balance = (pin.equalsIgnoreCase("2371"))
                        ? 2648.34 : 0;
                break;
            case "4111111111111111":
                balance = (pin.equalsIgnoreCase("9234"))
                        ? 8573.24 : 0;
                break;
        }
    }

    public String deposit(double amount) {
        balance += amount;
        return "Deposit successfully completed."
                + "\nYour new balance is $" + String.format("%.02f", balance);
    }

    public String withdraw(double amount) {
        if (balance - amount >= 0) {
            balance -= amount;
            return "Withdrawn successfully completed."
                    + "\nYour new balance is $" + String.format("%.02f", balance);
        } else {
            return "Error: Balance will be less than zero";
        }
    }

    public String checkBalance() {
        return "Your current balance is $" + String.format("%.02f", balance);
    }
}
