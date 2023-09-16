# Simulation of an Event that Follows Given Biasness

This application simulates biased events based on a given map of outcomes. It is a generalization of events like rolling a biased dice or flipping a biased coin.

## Features

* Simulate biased events based on provided probabilities.
* Generalize events like rolling a biased dice or flipping a biased coin.
* Handle different scenarios, including empty outcomes, zero probabilities, and negative probabilities.

## Assumptions

* Probabilities are provided as integers, representing the percentage probability of each outcome.
* Each occurrence of the event generates a single outcome, and outcomes are independent of each other.
* The code handles cases where the total probability is zero and negative probabilities by throwing appropriate exceptions.


## Code Structure

* `Main.java` This is the main class that contains the biased event simulation logic.
* `MainTest.java` This class contains unit tests for the Main class using JUnit.


## Unit Tests
* Unit tests have been implemented to ensure the correctness of the biased event simulation. 
* The tests cover various scenarios, including valid outcomes, empty outcomes, zero probabilities, and negative probabilities.

## Usage

* Clone this repository to your local machine
* Run the `Main.java` class
* Observe the results in the console

