package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameProgressServiceTest {
    public static final int POSSIBLE_FLAG_NUMBER_FOR_UPDATE_POSITION = 4;
    private static final int NO_UPDATE_POSITION = 0;

    private List<Car> cars;

    @BeforeEach
    void setUp() {
        String[] allCarOfName = {"kim  ", "min  ", "sub  "};
        List<String> carNames = Arrays.asList(allCarOfName);
        cars = GameProgressService.makeCar(carNames);
    }

    @Test
    void 자동차_만들기_테스트() {
        assertThat(cars.get(0).getName()).isEqualTo("kim");
        assertThat(cars.get(1).getName()).isEqualTo("min");
        assertThat(cars.get(2).getName()).isEqualTo("sub");
    }

    @Test
    void 라운드_진행_테스트() {
        CarMovingStrategy possibleStrategy = () -> POSSIBLE_FLAG_NUMBER_FOR_UPDATE_POSITION;
        boolean updateFlag = true;


        for (Car car : cars) {
            assertThat(car.getPosition()).isEqualTo(NO_UPDATE_POSITION);
        }

        GameProgressService.progressRound(cars, possibleStrategy);

        for (Car car : cars) {
            if (car.getPosition() == NO_UPDATE_POSITION) {
                updateFlag = false;
            }
        }

        assertThat(updateFlag).isTrue();
    }
}