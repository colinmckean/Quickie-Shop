package com.codeclan.example.shopkeep;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 24/02/2017.
 */

public class ShopTest {

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
    public void testCanGetShopName() {
        assertEquals("Any Shop Name", shop.getShopName());
    }

    @Test
    public void testSaleMakeFundsGoUp() {
        assertEquals(0, shop.getTotalSales(), 0.01);
        shop.sell(item, customer, "Credit Card");
        assertEquals(50, shop.getTotalSales(), 0.01);
    }

    @Test
    public void testRefundsMakeReFundsGoUp() {
        assertEquals(0, shop.getTotalRefunds(), 0.01);
        shop.sell(item, customer, "Credit Card");
        shop.sell(item, customer, "Credit Card");
        shop.refund(item, customer, "Credit Card");
        assertEquals(50, shop.getTotalRefunds(), 0.01);
    }

    @Test
    public void testGetSalesReport() {
        shop.sell(item, customer, "Credit Card");
        shop.sell(item, customer, "Credit Card");
        shop.refund(item, customer, "Credit Card");
        assertEquals(50, shop.getSalesReport(), 0.01);
    }

    @Test
    public void testGeneralShoppingExperience() {
        customer.addPaymentMethod(debitCard);
        shop.sell(item, customer, "Debit Card");
        shop.sell(item, customer, "Credit Card");
        shop.sell(item, customer, "Credit Card");
        shop.sell(item, customer, "Credit Card");
        shop.refund(item, customer, "Credit Card");
        assertEquals(149.97, shop.getSalesReport(), 0.01);
        assertEquals(199.96, shop.getTotalSales(), 0.01);
        assertEquals(49.99, shop.getTotalRefunds(), 0.01);
        assertEquals(200.01, customer.getBalance("Debit Card"), 0.01);
        assertEquals(400.02, customer.getBalance("Credit Card"), 0.01);
    }

    @Test
    public void testBuyItemWithDefaultPaymentMethod() {
        shop.sell(item, customer);
        assertEquals(450.01, customer.getBalance("Credit Card"), 0.01);
    }

    @Test
    public void testDefaultPaymentMethods() {
        shop.sell(item, customer);
        assertEquals(450.01, customer.getBalanceOfNewPaymentMethods("Credit Card"), 0.01);
    }

}