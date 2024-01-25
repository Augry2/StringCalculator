package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class StringCalculatorTest {

    // STEP 1
    @Test
    @DisplayName("add method will return sum of two comma separated numbers")
    void addMethodWillReturnSumOfTwoCommaSeparatedNumbers() {
        StringCalculator calc = new StringCalculator();

        int result = calc.add("1,2");

        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("add method can only take two numbers")
    void addMethodCanOnlyTakeTwoNumbers() {
        StringCalculator calc = new StringCalculator();

        int result = calc.add("1,2,3");

        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("add method returns 0 if empty string")
    void addMethodReturns0IfEmptyString() {
        StringCalculator calc = new StringCalculator();

        int result = calc.add("");

        assertThat(result).isEqualTo(0);
    }

    // STEP 2

    @Test
    @DisplayName("add can handle unknown amount of numbers")
    void addCanHandleUnknownAmountOfNumbers() {
        StringCalculator calc = new StringCalculator();

        int result = calc.add("1,2,3,4,5");

        assertThat(result).isEqualTo(15);
    }


}