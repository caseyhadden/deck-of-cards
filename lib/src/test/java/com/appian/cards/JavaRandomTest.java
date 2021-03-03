package com.appian.cards;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class JavaRandomTest {
    JavaRandom fixture = new JavaRandom();

    @Test(expected=IllegalArgumentException.class)
    public void testMaxLessThanMinThrows() {
        fixture.random(1, 0);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testNoRangeThrows() {
        int val = fixture.random(0, 0);
        assertEquals("Min == Max should return value.", 0, val);
    }    

    @Test
    public void testReturnsWithinRange() {
        int val = fixture.random(0, 10);
        assertTrue("Value should be >= min.", val >= 0);
        assertTrue("Value should be <= max.", val <= 10);
    }

    @Test
    public void testDistribution() {
        int[] results = new int[10];
        for (int i = 0; i < 10000; i++) {
            int val = fixture.random(0, 9);
            results[val] = ++results[val];
        }
        for (int i = 0; i < 10; i++) {
            // this is a really loose distribution, but enough to show the point of our test
            assertTrue("Distribution should be within 500", results[i] > 500);
            assertTrue("Distribution should be within 500", results[i] < 1500);
        }
    }
}
