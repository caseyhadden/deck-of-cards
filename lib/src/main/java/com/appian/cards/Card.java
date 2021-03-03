package com.appian.cards;

/**
 * Card represents a standard individual playing card it has a rank and suit
 */
public class Card {
    Suit suit;
    Rank rank;

    /**
     * Standard constructor for a Card
     * 
     * @param r the card's rank
     * @param s the card's suit
     * @throws IllegalArgumentException if either is null
     */
    public Card(Rank r, Suit s) {
        if (r == null) {
            throw new IllegalArgumentException("Rank must not be null.");
        }
        if (s == null) {
            throw new IllegalArgumentException("Suit must not be null.");
        }
        this.rank = r;
        this.suit = s;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((rank == null) ? 0 : rank.hashCode());
        result = prime * result + ((suit == null) ? 0 : suit.hashCode());
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
        Card other = (Card) obj;
        if (rank != other.rank)
            return false;
        if (suit != other.suit)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Card [rank=" + rank + ", suit=" + suit + "]";
    }
    
}
