import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Program {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String SPACE = " ";

    public static void main(String[] args) throws Exception {
        List<String> names = Input.inputNames();
        String times = Input.inputTimes();

        if (Validator.checkNameLength(names) || Validator.checkTimes(times)) {
            return;
        }
        playGame(makeCars(names), Integer.parseInt(times));
    }

    private static void playGame(List<Car> cars, int times) {
        Output.printMessage(RESULT_MESSAGE);

        while (times != 0) {
            moveCars(cars);
            times--;
            Output.printMessage(SPACE);
        }
        Output.printWinner(Winner.getWinners(cars));
    }

    private static List<Car> makeCars(List<String> names) {
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name));
        }
        return Collections.unmodifiableList(cars);
    }

    private static void moveCars(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = Car.randomNumber();
            car.move(randomNumber);

            Output.printCarResult(car);
        }
    }
}
