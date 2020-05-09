import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {
    private static final int MOVE = 4;
    private static final int STAY = 3;

    private List<Car> winners;

    @BeforeEach
    void setUp() {
        // given
        List<Car> cars = new ArrayList<>();

        cars.add(new Car("은정1"));
        cars.add(new Car("은정2"));
        cars.add(new Car("은정3"));
        cars.add(new Car("은정4"));
        cars.add(new Car("은정5"));

        // when
        cars.get(0).move(MOVE);
        cars.get(0).move(MOVE);
        cars.get(0).move(MOVE);

        cars.get(1).move(MOVE);
        cars.get(1).move(MOVE);
        cars.get(1).move(STAY);

        cars.get(2).move(STAY);
        cars.get(2).move(STAY);
        cars.get(2).move(STAY);

        winners = Winner.getWinners(cars);
    }

    @Test
    void 위치_최댓값_잘_계산되는지_테스트() {
        // then
        assertThat(winners).extracting("position").contains(3);
    }

    @Test
    void 우승자_잘_포함됐는지_테스트() {
        // then
        assertThat(winners).extracting("name").contains("은정1");
    }

    @Test
    void 우승자_목록_개수_잘_나오는지_테스트() {
        // then
        assertThat(winners.size()).isEqualTo(1);
    }
}
