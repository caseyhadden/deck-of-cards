package com.appian.cards;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CardTest {
    @Test
    public void testCardConstructor() {
        Card c = new Card(Rank.ACE, Suit.SPADES);
        assertEquals("Card rank should be ACE.", c.rank, Rank.ACE);
        assertEquals("Card suit should be SPADES.", c.suit, Suit.SPADES);
    }    

    @Test(expected=IllegalArgumentException.class)
    public void testCardRequiresRank() {
        new Card(null, Suit.SPADES);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testCardRequiresSuit() {
        new Card(Rank.ACE, null);
    }
}
