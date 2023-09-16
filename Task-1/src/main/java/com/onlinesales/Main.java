package com.onlinesales;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    private Map<Object, Integer> outcomes;

    public Main(Map<Object, Integer> outcomes) {
        this.outcomes = outcomes;
    }

    public Map<Object, Integer> generateEventOutcome(int occurrenceTime){
        if (outcomes.isEmpty()) throw new IllegalArgumentException("Not find any outcome!");

        // Calculate the total probability by summing the values in the outcomes map
        int totalProbability = outcomes.values().stream().mapToInt(value -> value).sum();

        // Check if the total probability is non-positive (zero or negative)
        if (totalProbability <= 0) throw new RuntimeException("Provided total probability is zero!");

        Map<Object, Integer> result = new HashMap<>();

        // Simulate the specified number of events
        for (int i = 0; i < occurrenceTime; i++){
            Object outcome = generateSingleEvent(totalProbability);
            result.put(outcome, result.getOrDefault(outcome,0) + 1);
        }

        return result;
    }

    private Object generateSingleEvent(int totalProbability) {

        // Generate a random number within the total probability range
        int randomNum = new Random().nextInt(totalProbability);
        int generatedProbability = 0;

        // Iterate through the outcomes and find the matching outcome
        for (Map.Entry<Object, Integer> entry: outcomes.entrySet()){
            // Check if the provided probability is negative
            if(entry.getValue() < 0) throw new RuntimeException("Probability can't be negative!");
            generatedProbability += entry.getValue();
            if (generatedProbability > randomNum) return entry.getKey();
        }

        // If no outcome is found, throw an exception
        throw new IllegalStateException("Not able to find outcome!");
    }

    public static void main(String[] args) {

        // Example 1: Rolling a biased six-faced dice
        Map<Object, Integer> dice = Map.of(1,10, 2,30, 3,15, 4,15, 5,30, 6,0);
        Main diceSimulator = new Main(dice);
        Map<Object, Integer> diceOutput = diceSimulator.generateEventOutcome(100);
        System.out.println("Dice result: " + diceOutput);

        // Example 2: Flipping a biased coin
        Map<Object, Integer> coin = Map.of( "Head",35, "Tail",65);
        Main coinSimulator = new Main(coin);
        Map<Object, Integer> coinOutput = coinSimulator.generateEventOutcome(1000);
        System.out.println("CoinOutput: " + coinOutput);

    }
}