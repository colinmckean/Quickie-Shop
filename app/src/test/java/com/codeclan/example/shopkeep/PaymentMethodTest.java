package com.codeclan.example.shopkeep;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 26/02/2017.
 */

public class PaymentMethodTest {

    PaymentMethod card;

    @Before
    public void before(){
        card = new PaymentMethod("Credit Card", 500);
    }

    @Test
    public void testCanGetPaymentMethodName(){
        assertEquals("Credit Card", card.getName());
    }

    @Test
    public void testCanGetBalance(){
        assertEquals(500, card.getBalance(), 0.01);
    }

    @Test
    public void testChargeToPaymentMethod(){
        card.chargeToPaymentMethod(250);
        assertEquals(250, card.getBalance(), 0.01);
    }

    @Test
    public void testRefundToPaymentMethod(){
        card.refundToPaymentMethod(250);
        assertEquals(750, card.getBalance(), 0.01);
    }
}
