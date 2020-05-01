import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidatorTest {
    private List<String> names;

    @BeforeEach
    void setUp() {
        names = new ArrayList<>();
        names.add("1");
        names.add("12");
        names.add("123");
        names.add("1234");
        names.add("12345");
    }

    @Test
    void 이름_1이상_5이하일때_테스트() {
        assertThat(Validator.checkNameLength(names)).isEqualTo(true);
    }

    @Test
    void 이름_6자_이상일때_테스트() {
        names.add("123456");
        assertThat(Validator.checkNameLength(names)).isEqualTo(false);
    }

    @Test
    void 이름_빈칸일때_테스트() {
        names.add("");
        assertThat(Validator.checkNameLength(names)).isEqualTo(false);
    }

    @Test
    void 횟수_숫자일때_테스트() {
        assertThat(Validator.checkTimes("5")).isEqualTo(true);
    }

    @Test
    void 횟수_숫자_아닐때_테스트() {
        assertThat(Validator.checkTimes("ㅎㅎ")).isEqualTo(false);
    }
}
