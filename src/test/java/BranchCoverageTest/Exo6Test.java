package BranchCoverageTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import exercises.FizzBuzz;

public class Exo6Test {

    // Branch: n <= 1 → true (bug: should be n <= 0)
    @Test
    public void testOne_throwsDueToBug() {
        assertThrows(IllegalArgumentException.class, () -> FizzBuzz.fizzBuzz(1));
    }

    // Branch: n <= 1 → true (negative input)
    @Test
    public void testNegative_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> FizzBuzz.fizzBuzz(-1));
    }

    // Branch: n <= 1 → false, n % 15 == 0 → true
    @Test
    public void testMultipleOf15_returnsFizzBuzz() {
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(15));
    }

    // Branch: n % 15 == 0 → false, n % 3 == 0 → true
    @Test
    public void testMultipleOf3Only_returnsFizz() {
        assertEquals("Fizz", FizzBuzz.fizzBuzz(3));
    }

    // Branch: n % 15 == 0 → false, n % 3 == 0 → false, n % 5 == 0 → true
    @Test
    public void testMultipleOf5Only_returnsBuzz() {
        assertEquals("Buzz", FizzBuzz.fizzBuzz(5));
    }

    // Branch: n % 15 == 0 → false, n % 3 == 0 → false, n % 5 == 0 → false
    @Test
    public void testPlainNumber_returnsStringValue() {
        assertEquals("2", FizzBuzz.fizzBuzz(2));
    }
}