package com.onlinesales;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MainTest {

    @Test
    public void test_EvaluateMathematicalExpression() {
        Main main = new Main();
        List<String> expressions = List.of("2 * 4 * 4", "5 / (7 - 5)", "sqrt(5^2 - 4^2)", "sqrt(-3^2 - 4^2)");
        List<String> result = main.evaluateMathematicalExpression(expressions);

        // Verify that the result matches the expected values
        List<String> expected = List.of("32", "2.5", "3", "5i");
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_WrongMathematicalExpression() {
        Main main = new Main();
        List<String> expressions = List.of("2 * 4", "2 + 4", "abc");
        List<String> result = main.evaluateMathematicalExpression(expressions);

        // Verify that the result matches the expected values
        List<String> expected = List.of("Error in mathematical expression!");
        Assertions.assertEquals(expected, result);
    }

}
