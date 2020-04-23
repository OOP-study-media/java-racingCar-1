package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerProgressServiceTest {
    private List<Car> cars = new LinkedList<>();
    private int winnerPosition;

    @BeforeEach
    void setUp() {
        CarMovingStrategy strategy = new PossibleCarMovingStrategyMock();
        List<String> carName = new LinkedList<>(Arrays.asList("kim", "min", "sub"));

        for (int i = 0; i < 3; i++) {
            cars.add(new Car(carName.get(i)));
        }

        cars.get(0).updatePosition(strategy);
        cars.get(0).updatePosition(strategy);
        winnerPosition = WinnerProgressService.calculateWinnerPosition(cars);
    }

    @Test
    void 우승자의_포지션값_테스트() {
        assertThat(winnerPosition).isEqualTo(2);
    }

    @Test
    void 우승자_추출_테스트() {
        List<String> winnerName = WinnerProgressService.extractWinners(cars, winnerPosition);
        assertThat(winnerName).contains("kim");
    }
}