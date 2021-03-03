package com.appian.cards;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SuitTest {
    @Test
    public void test4SuitsExist() {
        assertEquals("There are 4 common card suits.", 4, Suit.values().length);
    }
}
