package com.onlinesales;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class MainTest {

    @Test
    public void test_DiceOutcomes(){
        Map<Object, Integer> dice = Map.of(1,10, 2,30, 3,15, 4,15, 5,30, 6,0);
        Main diceSimulator = new Main(dice);
        Map<Object, Integer> result = diceSimulator.generateEventOutcome(1000);

        Assertions.assertEquals(1000, result.values().stream().mapToInt(Integer::intValue).sum(), "Dice output probability should be 1000");

    }

    @Test
    public void test_CoinOutcomes(){
        Map<Object, Integer> coin = Map.of( "Head",35, "Tail",65);
        Main coinSimulator = new Main(coin);
        Map<Object, Integer> result = coinSimulator.generateEventOutcome(1000);

        Assertions.assertEquals(1000, result.values().stream().mapToInt(Integer::intValue).sum(), "Coin output probability should be 100");

    }

    @Test
    public void test_EmptyMapOutcomes() {
        Map<Object, Integer> emptyMap = new HashMap<>();
        Main main = new Main(emptyMap);

        IllegalArgumentException argumentException = Assertions.assertThrows(IllegalArgumentException.class, () -> main.generateEventOutcome(100), "Empty outcomes found!");
        Assertions.assertEquals("Not find any outcome!", argumentException.getMessage(), "Unexpected Exception message");

    }

    @Test
    public void test_ZeroProbabilityForAllOutcomes(){
        Map<Object, Integer> map = Map.of(1,0, 2,0, 3,0);
        Main main = new Main(map);

        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> main.generateEventOutcome(100), "Empty outcomes found!");
        Assertions.assertEquals("Provided total probability is zero!", exception.getMessage(), "Unexpected Exception message");

    }

    @Test
    public void test_NegativeProbabilityOutcomes(){
        Map<Object, Integer> map = Map.of(1,50, 2,70, 3,-20);
        Main main = new Main(map);

        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> main.generateEventOutcome(100), "Negative outcome found!");
        Assertions.assertEquals("Probability can't be negative!", exception.getMessage(), "Unexpected Exception message");

    }

}
