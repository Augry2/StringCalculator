package org.example;

import org.junit.jupiter.api.Disabled;
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

    @Disabled("Test no longer in use")
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

    // STEP 3
    @Test
    @DisplayName("allow add to separate the numbers using new line or comma ")
    void allowAddToSeparateTheNumbersUsingNewLineOrComma() {
        StringCalculator calc = new StringCalculator();

        int result = calc.add("1\n2,3");

        assertThat(result).isEqualTo(6);
    }

    // STEP 4
    @Test
    @DisplayName("add can use semi colon as delimiter")
    void addCanUseSemiColonAsDelimiter() {
        StringCalculator calc = new StringCalculator();

        int result = calc.add("//;\n1;2");

        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("add can use hashtag as delimiter")
    void addCanUseHashtagAsDelimiter() {
        StringCalculator calc = new StringCalculator();

        int result = calc.add("//#\n1#2");

        assertThat(result).isEqualTo(3);
    }

    // STEP 5
    @Test
    @DisplayName("calling add with negative number will throw exception")
    void callingAddWithNegativeNumberWillThrowException() {
        StringCalculator calc = new StringCalculator();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calc.add("-5,10");
        });
    }

    @Test
    @DisplayName("exception message will contain the negative numbers that is passed")
    void exceptionMessageWillContainTheNegativeNumbersThatIsPassed() {
        StringCalculator calc = new StringCalculator();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calc.add("-5,10");
        });
        System.out.println(exception);
        assertThat(exception).hasMessageContaining("-5");
    }

    // STEP 6

    
    
    
    
    
    
    
    
    

}