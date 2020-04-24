package domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class WinnerProgressService {
    private WinnerProgressService() {
        throw new AssertionError();
    }

    public static int calculateWinnerPosition(List<Car> cars) {
        List<Integer> carsPosition = new LinkedList<>();

        for (Car car : cars) {
            carsPosition.add(car.getPosition());
        }
        Collections.sort(carsPosition);

        return carsPosition.get(carsPosition.size() - 1);
    }

    public static List<String> extractWinners(List<Car> cars, int winnerPosition) {
        List<String> winners = new LinkedList<>();
        for (Car car : cars) {
            if (car.isWinner(winnerPosition)) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
