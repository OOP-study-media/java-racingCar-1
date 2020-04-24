package util;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {
    @Test
    void 랜덤숫자_범위_테스트() {
        assertThat(RandomNumberGenerator.generateRandomNumber()).isBetween(0, 9);
    }
}