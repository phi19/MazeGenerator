package xyz.drena.maze;

import xyz.drena.view.tools.Constants;
import java.util.Random;

public class PseudoRandomizer {

    private Random seed;

    public void generateRandomSeed() {
        seed = new Random((long) (Math.random()*Constants.RANDOMIZER_TOTAL_SEEDS));
    }

    public void setSeed(long seed) {
        this.seed = new Random(seed);
    }

    public Double random(double total) {
        return Math.floor(seed.nextDouble() * total);
    }

}
