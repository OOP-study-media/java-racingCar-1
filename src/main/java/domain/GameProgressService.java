package domain;

import util.RandomNumberGenerator;

import java.util.LinkedList;
import java.util.List;

public class GameProgressService {
    private GameProgressService() {
        throw new AssertionError();
    }

    public static List<Car> makeCar(List<String> allCarOfRacingGame) {
        List<Car> cars = new LinkedList<>();

        for (int i = 0; i < allCarOfRacingGame.size(); i++) {
            cars.add(new Car(allCarOfRacingGame.get(i).trim()));
        }

        return cars;
    }

    public static void progressRound(List<Car> cars, CarMovingStrategy strategy) {
        for (Car car : cars) {
            car.updatePosition(strategy);
        }
    }
}
