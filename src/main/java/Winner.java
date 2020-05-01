import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Winner {

    private static int getMaxCarPosition(List<Car> cars) {
        int max = 0;
        for (Car car : cars) {
            if (car.getPosition() > max) {
                max = car.getPosition();
            }
        }
        return max;
    }

    public static List<Car> getWinners(List<Car> cars) {
        int max = getMaxCarPosition(cars);
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.isMaxPosition(max)) {
                winners.add(car);
            }
        }
        return Collections.unmodifiableList(winners);
    }
}
