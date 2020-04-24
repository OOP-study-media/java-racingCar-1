package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class ValidatorTest {
    @Test
    void 문자열_길이_테스트() {
        List<String> carNames = new LinkedList<>();
        carNames.add("kimminsub");
        assertThat(Validator.isValidNameLength(carNames)).isFalse();
    }

    @Test
    void 라운드_숫자_테스트() {
        assertThat(Validator.isValidRoundNumber(-1)).isFalse();
    }

    @Test
    void 중복_이름_테스트() {
        List<String> carNames = new LinkedList<>(Arrays.asList("kim", "min", "sub", "kim"));
        assertThat(Validator.isDuplicatedName(carNames)).isFalse();
    }
}