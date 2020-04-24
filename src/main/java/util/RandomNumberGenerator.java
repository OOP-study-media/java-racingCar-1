package util;

import java.util.Random;

public class RandomNumberGenerator {
    private static final int MAXIMUM_RANDOM_NUMBER_RANGE = 10;
    private static Random random = new Random();

    private RandomNumberGenerator() {
        throw new AssertionError();
    }

    public static int generateRandomNumber() {
        return random.nextInt(MAXIMUM_RANDOM_NUMBER_RANGE);
    }
}
