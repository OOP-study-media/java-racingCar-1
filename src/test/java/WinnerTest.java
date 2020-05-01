import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {
    private List<Car> cars;

    @BeforeEach
    void setUp() {
        cars = new ArrayList<>();

        cars.add(new Car("은정1"));
        cars.add(new Car("은정2"));
        cars.add(new Car("은정3"));
        cars.add(new Car("은정4"));
        cars.add(new Car("은정5"));

        cars.get(0).move(5);
        cars.get(0).move(5);
        cars.get(0).move(5);

        cars.get(1).move(5);
        cars.get(1).move(5);
        cars.get(1).move(3);

        cars.get(2).move(3);
        cars.get(2).move(3);
        cars.get(2).move(3);
    }

    @Test
    void 우승자_잘_포함됐는지_테스트() {
        assertThat(Winner.getWinners(cars)).extracting("name").contains("은정1");
    }

    @Test
    void 우승자_목록_개수_잘_나오는지_테스트() {
        assertThat(Winner.getWinners(cars).size()).isEqualTo(1);
    }
}
