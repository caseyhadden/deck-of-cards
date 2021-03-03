package com.appian.cards;

/**
 * Thrown when invalid operations are performed on an empty deck.
 */
public class EmptyDeckException extends RuntimeException {
    public static final long serialVersionUID = 1L;

    public EmptyDeckException(String message) {
        super(message);
    }
}
