package com.appian.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A deck of standard playing cards.
 */
public class Deck {
    // our randomness generator
    RandomInterface rand = new JavaRandom();
    List<Card> cards;

    /**
     * Creates a standard 52 card deck with all suits and ranks
     * @return standard 52 card playing deck
     */
    public static Deck standardDeck() {
        List<Card> cards = new ArrayList<Card>();
        for (Suit s: Suit.values()) {
            for (Rank r: Rank.values()) {
                cards.add(new Card(r, s));
            }
        }
        return new Deck(cards);
    }

    /**
     * Constructor to create a deck from a given set of cards
     * @param c the list of cards, a null value will result in an empty deck
     */
    public Deck(List<Card> c) {
        // turn null list into empty deck
        if (c == null) {
            this.cards = new ArrayList<Card>();
        } else {
            this.cards = c;
        }
    }

    /**
     * Takes the current set of cards and changes their order randomly in place
     */
    public void shuffle() {
        // Fisher-Yates type shuffle
        int deckSize = cards.size();
        for (int i = 0; i < deckSize-1; i++) {
            // find an index between current position and the end
            int j = rand.random(i, deckSize-1); 
            // switch current card with that position
            Collections.swap(cards, i, j);
        }
    } 
    
    /**
     * Returns one card off the top
     * @return Card from the top of the deck
     * @throws EmptyDeckException if deck is empty, check the size
     */
    public Card dealOneCard() {
        if (cards.isEmpty()) {
            // wars have been fought over less than whether to use checked vs. unchecked exceptions
            throw new EmptyDeckException("Can't deal from empty deck.");
        }
        // just one from the top will be sufficient - Maverick
        return cards.remove(0);
    }

    /**
     * @return the current deck size
     */
    public int size() {
        return cards.size();
    }

    @Override
    public String toString() {
        return "Deck [cards=" + cards + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cards == null) ? 0 : cards.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Deck other = (Deck) obj;
        if (cards == null) {
            if (other.cards != null)
                return false;
        } else if (!cards.equals(other.cards))
            return false;
        return true;
    }

    
}
