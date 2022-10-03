package org.example;

import org.example.calculate.*;

import java.util.List;

public class Calculator {
    private static final List<NewArithmeticOperator> arithmeticOperators = List.of(new AdditionOperator(), new SubtractionOperator(),
            new MultiplicationOperator(), new DivisionOperator());
    // 인터페이스 사용
    public static int calculate(PositiveNumber operand1, String operator, PositiveNumber operand2) {
        return arithmeticOperators.stream()
                .filter(arithmeticOperators -> arithmeticOperators.supports(operator))
                .map(arithmeticOperators -> arithmeticOperators.calculate(operand1, operand2))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아님"));
    }

    // enum 사용
    /*
    public static int calculate(int operand1, String operator, int operand2) {
       return ArithmeticOperator.calculate(operand1, operator, operand2);
    }
    */
}
