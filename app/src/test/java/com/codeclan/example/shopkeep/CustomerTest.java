package com.codeclan.example.shopkeep;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 24/02/2017.
 */

public class CustomerTest {

    private Customer customer;
    private Shop shop;
    private Item item;
    private PaymentMethod creditCard;
    private PaymentMethod debitCard;

    @Before
    public void before() {

        shop = new Shop("Any Shop Name");
        item = new Item("Any Item Name", 49.99);
        creditCard = new PaymentMethod("Credit Card", 500);
        debitCard = new PaymentMethod("Debit Card", 250);
        customer = new Customer("Any Customer Name", creditCard);
    }

    @Test
    public void testGetCustomerName() {
        assertEquals("Any Customer Name", customer.getCustomerName());
    }

    @Test
    public void testCanAddPaymentMethod() {
        customer.addPaymentMethod(debitCard);
        assertEquals(2, customer.getPaymentMethods().size());
    }

    @Test
    public void testBuyingItemLowersCustomerFunds() {
        assertEquals(0, shop.getTotalSales(), 0.01);
        shop.sell(item, customer, "Credit Card");
        assertEquals(450, customer.getBalance("Credit Card"), 0.01);
    }

    @Test
    public void testRefundsIncreaseCustomerFunds() {
        shop.sell(item, customer, "Credit Card");
        assertEquals(450.01, customer.getBalance("Credit Card"), 0.01);
        shop.refund(item, customer, "Credit Card");
        assertEquals(500, customer.getBalance("Credit Card"), 0.01);
    }
}


