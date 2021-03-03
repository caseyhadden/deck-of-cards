package com.appian.cards;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class DeckTest {
    @Test
    public void testStandardDeckIs52Cards() {
        Deck d = Deck.standardDeck();
        assertEquals("A standard deck should contain 52 cards.", 52, d.size());
    }

    @Test
    public void testStandardDeckContents() {
        Deck d = Deck.standardDeck();
        for (Rank r : Rank.values()) {
            for (Suit s : Suit.values()) {
                assertTrue("A standard deck should contains cards of every suit and rank.", 
                    d.cards.contains(new Card(r, s)));
            }
        }
    }

    @Test
    public void testEmptyDeckIs0Cards() {
        Deck d = new Deck(new ArrayList<Card>());
        assertEquals("An empty deck should have 0 cards.", 0, d.size());
    }

    @Test
    public void testNullCardListCreatesEmptyDeck() {
        Deck d = new Deck(null);
        assertNotNull("Null card input should be transformed to empty object.", d.cards);
        assertEquals("Null card input should give a 0 size deck.", 0, d.size());
    }

    @Test(expected=EmptyDeckException.class)
    public void testEmptyDeckThrowsRuntimeExceptionOnDeal() {
        Deck d = new Deck(new ArrayList<Card>());
        d.dealOneCard();
    }

    @Test
    public void testDeckDealsTopCard() {
        Deck d = Deck.standardDeck();
        Card top = d.cards.get(0);
        Card dealt = d.dealOneCard();
        assertEquals("Dealt card should match top rank.", top.rank, dealt.rank);
        assertEquals("Dealt card should match top suit.", top.suit, dealt.suit);
    }

    @Test
    public void testDealRemovesCard() {
        Deck d = Deck.standardDeck();
        int deckSize = d.size();
        Card dealt = d.dealOneCard();
        assertEquals("Deck size should reduce by one after dealing.", deckSize-1, d.size());
        assertFalse("Deck should no longer contain dealt card.", d.cards.contains(dealt));
    }

    @Test
    public void testStandardDeckDeals52Cards() {
        Deck d = Deck.standardDeck();
        int cardsDealt = 0;
        while (d.size() > 0) {
            d.dealOneCard();
            cardsDealt++;
        }
        assertEquals("A standard deck should deal out 52 cards.", 52, cardsDealt);
    }

    @Test
    public void testShuffleDoesntChangeDeckContents() {
        // standard decks are always the same
        Deck d1 = Deck.standardDeck();
        Deck d2 = Deck.standardDeck();
        int deckSize = d1.size();
        d2.shuffle();
        assertEquals("Shuffle should not change deck size.", deckSize, d2.size());
        for (int i = 0; i < deckSize; i++) {
            Card c1 = d1.cards.get(i);
            assertTrue("Shuffle should not change deck contents.", d2.cards.contains(c1));
        }
    }

    @Test
    public void testShuffleSwap() {
        Deck ctl = Deck.standardDeck(); // our control deck
        Deck d = Deck.standardDeck();
        d.rand = new NotRandom();
        d.shuffle();

        assertNotEquals("Shuffle should result in different deck.", ctl.cards, d.cards);
        List<Card> shuffledCards = new ArrayList<Card>(d.cards);
        Collections.reverse(shuffledCards);
        assertEquals("Non-random shuffle should result in reversed deck.", ctl.cards, shuffledCards);
    }

    // NotRandom returns max-min for the first half, min otherwise
    // This allows us to know that our deck will be exactly reversed.
    class NotRandom implements RandomInterface {
        @Override
        public int random(int min, int max) {
            if (min*2 < max) {
                return max-min;
            }
            return min;
        }
    }
}
