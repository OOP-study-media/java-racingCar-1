import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {

    @Test
    void 우승자_목록_잘_나오는지_테스트() {
        int times = 1000;
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("은정1"));
        cars.add(new Car("은정2"));
        cars.add(new Car("은정3"));
        cars.add(new Car("은정4"));
        cars.add(new Car("은정5"));

        while (times != 0) {
            cars.get(0).move();
            times--;
        }
        assertThat(new Winner(cars).winners()).extracting("name").contains("은정1");
        assertThat(new Winner(cars).winners().size()).isEqualTo(1);

    }
}
