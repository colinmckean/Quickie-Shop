package com.codeclan.example.shopkeep;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 25/02/2017.
 */

public class ItemTest {

    private Item item;

    @Before
    public void before() {
        item = new Item("Any Item Name", 3.99);
    }

    @Test
    public void testCanGetItemName() {
        assertEquals("Any Item Name", item.getItemName());
    }

    @Test
    public void testCanGetItemCost() {
        assertEquals(3.99, item.getItemCost(), 0.01);
    }
}
