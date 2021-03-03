package com.appian.cards;

import java.util.Random;

/**
 * Implements our RandomInterface using the java.util.Random.nextInt() function.
 */
public class JavaRandom implements RandomInterface {
    Random rand = new Random();

    @Override
    public int random(int min, int max) {
        if (max <= min) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        // add one to max to get inclusive property
        return rand.nextInt(max+1-min) + min;
    }
    
}
