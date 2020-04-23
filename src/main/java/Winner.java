import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Winner {
    private List<Car> cars;

    Winner(List<Car> cars) {
        this.cars = cars;
    }

    private int getMaxCarPosition() {
        int max = 0;
        for (Car car : cars) {
            if (car.getPosition() > max) {
                max = car.getPosition();
            }
        }
        return max;
    }

    public List<Car> winners() {
        int max = getMaxCarPosition();
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.isMaxPosition(max)) {
                winners.add(car);
            }
        }
        return Collections.unmodifiableList(winners);
    }
}
