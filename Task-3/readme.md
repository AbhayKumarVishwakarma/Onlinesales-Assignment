# Debugging

The script takes an integer input (n) and performs the following operations:

* If n is less than 10, it calculates the square of n.
* If n is between 10 and 20, it calculates the factorial of (n-10).
* If n is greater than 20, it calculates the sum of all integers between 1 and (n-20).


## Usage

* Clone this repository to your local machine
* Open the application 
* Run the `main.py`
* Enter the Number
* Observe the results in the console


## Example
````
    4 => 16
    15 => 120
    25 => 15
````

## Bug fixed

* In the factorial calculation section, changed `n-10` to `n-11` to correct the range.
* In the sum calculation section, changed the `(out - lim)` to `(out + lim)` to calculate the sum correctly.