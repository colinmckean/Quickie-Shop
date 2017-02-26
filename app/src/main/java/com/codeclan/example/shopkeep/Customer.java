package com.codeclan.example.shopkeep;

import java.util.HashMap;

/**
 * Created by user on 24/02/2017.
 */

public class Customer {

    private HashMap<String, PaymentMethod> paymentMethods;
    private String customerName;

    public Customer(String customerName, PaymentMethod paymentMethod) {
        paymentMethods = new HashMap<>();
        this.customerName = customerName;
        addPaymentMethod(paymentMethod);
    }

    public void takeFundsFromPaymentMethod(double price, String paymentMethod) {
        paymentMethods.get(paymentMethod).chargeToPaymentMethod(price);
    }

    public void refundFundToPaymentMethod(double price, String paymentMethod) {
        paymentMethods.get(paymentMethod).refundToPaymentMethod(price);
    }

    public void addPaymentMethod(PaymentMethod paymentCard) {
        paymentMethods.put(paymentCard.getName(), paymentCard);
    }

    public HashMap<String, PaymentMethod> getPaymentMethods() {
        return new HashMap<>(paymentMethods);
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getBalance(String nameOfCard) {
        return paymentMethods.get(nameOfCard).getBalance();
    }

    public double getBalanceOfNewPaymentMethods(String nameOfCard) {
        return paymentMethods.get(nameOfCard).getBalance();
    }
}
