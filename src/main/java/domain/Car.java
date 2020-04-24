package domain;

import util.RandomNumberGenerator;

import java.util.Objects;

public class Car {
    private static final int POSSIBLE_NUMBER_FOR_MOVE = 4;
    private static final int START_POSITION = 0;

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = START_POSITION;
    }

    public void updatePosition(CarMovingStrategy strategy) {
        if (isCarMove(strategy.generate())) {
            position++;
        }
    }

    private boolean isCarMove(int random) {
        return random >= POSSIBLE_NUMBER_FOR_MOVE;
    }

    public boolean isWinner(int winnerPosition) {
        return position == winnerPosition;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}

