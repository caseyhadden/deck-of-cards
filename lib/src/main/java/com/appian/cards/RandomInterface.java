package com.appian.cards;

/**
 * RandomInterface allows us to substitute non-random outcomes into our tests
 * where there would normally be unpredictability from RNG.
 */
public interface RandomInterface {
    /**
     * Return a random number within the range
     * @param min the minimum we can return, inclusive
     * @param max the maximum we can return, inclusive
     * @return a random value between the bounds
     * @throws IllegalArgumentException if max < min
     */
    public int random(int min, int max);
}
