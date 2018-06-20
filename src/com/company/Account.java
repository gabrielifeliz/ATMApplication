package com.company;

import java.util.HashMap;

public class Account {

    private String userName;
    private double balance;
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
        }
        return isAccountNumberValid;
    }

    public boolean verifyPIN(String accountNumber, String pin) {
        boolean isPINValid = false;

        for (int i = 0; i < accNumAndPIN.size(); i++) {
            isPINValid = accNumAndPIN.get(accountNumber).equalsIgnoreCase(pin);
        }
        return isPINValid;
    }
}
