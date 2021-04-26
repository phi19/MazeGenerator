package xyz.drena.algorithm;

import xyz.drena.view.Constants;

import java.util.Random;

public class PseudoRandomizer {

    private final Random random;

    public PseudoRandomizer() {
        if (Constants.RANDOMIZER_USE_DEFAULT_SEED) {
            random = new Random(Constants.RANDOMIZER_DEFAULT_SEED);
        } else {
            random = new Random(generateRandomSeed());
        }
    }

    private long generateRandomSeed() {
        return (long) (Math.random()*Constants.RANDOMIZER_TOTAL_SEEDS);
    }

    public int random(int total) {
        return (int) Math.floor(random.nextDouble() * total);
    }

}
