package com.appian.cards;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RankTest {
    @Test
    public void test13RanksExist() {
        assertEquals("There are 13 common card ranks.", 13, Rank.values().length);
    }
}
