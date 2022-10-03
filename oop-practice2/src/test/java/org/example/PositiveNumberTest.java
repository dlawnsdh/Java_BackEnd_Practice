package org.example;

import org.example.calculate.PositiveNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

public class PositiveNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {0, -2, -1231243})
    void createTest(int value) {
        assertThatCode(() -> new PositiveNumber(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0 또는 음수는 전달 불가능");
    }
}
