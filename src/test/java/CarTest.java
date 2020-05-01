import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("은정");
    }

    @Test
    void 랜덤_4이상_차_이동_테스트() {
        car.move(4);
        assertThat(car.getPosition()).as("check %s's position", car.getName())
                .isEqualTo(1);
    }

    @Test
    void 랜덤_3이하_차_이동_테스트() {
        car.move(3);
        assertThat(car.getPosition()).as("check %s's position", car.getName())
                .isEqualTo(0);
    }

    @Test
    void 자기_위치가_최댓값일때_잘_나오는지_테스트() {
        car.move(Car.randomNumber());
        assertThat(car.isMaxPosition(car.getPosition())).isTrue();
    }

    @Test
    void 자기_위치가_최댓값이_아닐때_잘_나오는지_테스트() {
        car.move(Car.randomNumber());
        assertThat(car.isMaxPosition(car.getPosition()+1)).isFalse();
    }
}
