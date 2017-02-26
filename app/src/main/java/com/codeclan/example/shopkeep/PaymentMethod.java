package com.codeclan.example.shopkeep;

/**
 * Created by user on 25/02/2017.
 */

public class PaymentMethod {

    private double balance;
    private String cardName;

    public PaymentMethod(String name, double openingBalance) {
        this.balance = openingBalance;
        this.cardName = name;
    }

    public void chargeToPaymentMethod(double cost) {
        adjustBalance(-cost);
    }

    public void refundToPaymentMethod(double cost) {
        adjustBalance(cost);
    }

    private void adjustBalance(double amount) {
        balance += amount;
    }

    public String getName() {
        return cardName;
    }

    public double getBalance() {
        return balance;
    }

}
