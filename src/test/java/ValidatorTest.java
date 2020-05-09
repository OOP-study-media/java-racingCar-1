import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidatorTest {
    private List<String> names;

    @BeforeEach
    void setUp() {
        // given
        names = new ArrayList<>();
        names.add("1");
        names.add("12");
        names.add("123");
        names.add("1234");
        names.add("12345");
    }

    @Test
    void 이름_1이상_5이하일때_테스트() {
        // when
        boolean checkNameLength = Validator.checkNameLength(names);

        // then
        assertThat(checkNameLength).isEqualTo(true);
    }

    @Test
    void 이름_6자_이상일때_테스트() {
        // given
        names.add("123456");

        // when
        boolean checkNameLength = Validator.checkNameLength(names);

        // then
        assertThat(checkNameLength).isEqualTo(false);
    }

    @Test
    void 이름_빈칸일때_테스트() {
        // given
        names.add("");

        // when
        boolean checkNameLength = Validator.checkNameLength(names);

        // then
        assertThat(checkNameLength).isEqualTo(false);
    }

    @Test
    void 횟수_숫자일때_테스트() {
        // given
        String times = "5";

        // when
        boolean checkTimes = Validator.checkTimes(times);

        // then
        assertThat(checkTimes).isEqualTo(true);
    }

    @Test
    void 횟수_숫자_아닐때_테스트() {
        // given
        String times = "ㅎㅎ";

        // when
        boolean checkTimes = Validator.checkTimes(times);

        // then
        assertThat(checkTimes).isEqualTo(false);
    }
}
