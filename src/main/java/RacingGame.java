import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String SPACE = " ";
    private static final int RANGE = 10;

    public void playGame() throws Exception {
        List<String> names = Input.inputNames();
        String times = Input.inputTimes();
        List<Car> winner;

        if (!Validator.checkNameLength(names) || !Validator.checkTimes(times)) {
            return;
        }
        Output.printMessage(RESULT_MESSAGE);
        winner = progressGame(makeCars(names), Integer.parseInt(times));
        Output.printWinner(winner);
    }

    private List<Car> progressGame(List<Car> cars, int times) {
        while (times != 0) {
            moveCars(cars);
            times--;
            Output.printMessage(SPACE);
        }
        return Winner.getWinners(cars);
    }

    private List<Car> makeCars(List<String> names) {
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name));
        }
        return Collections.unmodifiableList(cars);
    }

    private void moveCars(List<Car> cars) {
        for (Car car : cars) {
            car.move(randomNumber());
            Output.printCarResult(car);
        }
    }

    private int randomNumber() {
        return new Random().nextInt(RANGE);
    }
}
