## Deck of Cards

This library contains a very basic implementation for a deck of standard
playing cards. This implies:

1. 4 suits - clubs, diamonds, hearts, and spades
2. 13 ranks - ace, 2-10, jack, queen, and king
3. Special cards such as Jokers are not supported

An individual deck may have any number of cards from 0 -> Java's maximum list
size provided you have enough memory to hold it. The library provides a
standardDeck() method to get a normal 52 card playing deck.

Deck instances provide two main operations: shuffle and dealOneCard. shuffle
re-orders the current cards in the deck randomly. dealOneCard returns the top
card from the given Deck.

For more information, check the tests and javadoc.
