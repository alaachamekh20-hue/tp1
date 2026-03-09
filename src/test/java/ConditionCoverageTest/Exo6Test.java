package ConditionCoverageTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import exercises.FizzBuzz;

public class Exo6Test {

    // Condition: n <= 1 → true (n = 1, bug: should be n <= 0)
    @Test
    public void testOne_throwsDueToBug() {
        assertThrows(IllegalArgumentException.class, () -> FizzBuzz.fizzBuzz(1));
    }

    // Condition: n <= 1 → true (n = 0)
    @Test
    public void testZero_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> FizzBuzz.fizzBuzz(0));
    }

    // Condition: n <= 1 → true (n negative)
    @Test
    public void testNegative_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> FizzBuzz.fizzBuzz(-3));
    }

    // Condition: n <= 1 → false AND n % 15 == 0 → true
    @Test
    public void testMultipleOf15_returnsFizzBuzz() {
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(15));
    }

    // Condition: n <= 1 → false AND n % 15 == 0 → false AND n % 3 == 0 → true
    @Test
    public void testMultipleOf3Only_returnsFizz() {
        assertEquals("Fizz", FizzBuzz.fizzBuzz(3));
    }

    // Condition: n % 15 == 0 → false AND n % 3 == 0 → false AND n % 5 == 0 → true
    @Test
    public void testMultipleOf5Only_returnsBuzz() {
        assertEquals("Buzz", FizzBuzz.fizzBuzz(5));
    }

    // Condition: n % 15 == 0 → false AND n % 3 == 0 → false AND n % 5 == 0 → false
    @Test
    public void testPlainNumber_returnsStringValue() {
        assertEquals("2", FizzBuzz.fizzBuzz(2));
    }

    // Condition: n % 15 == 0 → false, n % 3 == 0 → true (multiple of 3, not 15)
    @Test
    public void testMultipleOf3NotOf15_returnsFizz() {
        assertEquals("Fizz", FizzBuzz.fizzBuzz(9));
    }

    // Condition: n % 5 == 0 → true, n % 3 == 0 → false (multiple of 5, not 15)
    @Test
    public void testMultipleOf5NotOf15_returnsBuzz() {
        assertEquals("Buzz", FizzBuzz.fizzBuzz(25));
    }
}