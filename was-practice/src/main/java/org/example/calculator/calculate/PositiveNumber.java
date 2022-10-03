package org.example.calculator.calculate;

public class PositiveNumber {
    private final int value;

    public PositiveNumber(int value) {
        valueCheck(value);
        this.value = value;
    }

    private void valueCheck(int value) {
        if (isNegative(value))
            throw new IllegalArgumentException("0 또는 음수는 전달 불가능\n");
    }

    private boolean isNegative(int value) {
        return value <= 0;
    }

    public int toInt() {
        return value;
    }
}
