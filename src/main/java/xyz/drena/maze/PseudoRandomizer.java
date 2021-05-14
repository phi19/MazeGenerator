package xyz.drena.maze;

import xyz.drena.view.tools.Constants;
import java.util.Random;

public class PseudoRandomizer {

    private Random seed;

    public static long generateRandomSeed() {
        return (long) (Math.random()*Constants.RANDOMIZER_TOTAL_SEEDS);
    }

    public void setSeed(long seed) {
        this.seed = new Random(seed);
    }

    public Double random(double total) {
        return Math.floor(seed.nextDouble() * total);
    }

}
