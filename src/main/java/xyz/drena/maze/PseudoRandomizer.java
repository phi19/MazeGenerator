package xyz.drena.maze;

import xyz.drena.view.tools.Constants;
import java.util.Random;

public class PseudoRandomizer {

    private static final long SEED = Constants.RANDOMIZER_USE_DEFAULT_SEED ? Constants.RANDOMIZER_DEFAULT_SEED : generateRandomSeed();
    private static final Random SEED_GENERATION = new Random(SEED);

    private static long generateRandomSeed() {
        return (long) (Math.random()*Constants.RANDOMIZER_TOTAL_SEEDS);
    }

    public static double random(double total) {
        return Math.floor(SEED_GENERATION.nextDouble() * total);
    }

}
