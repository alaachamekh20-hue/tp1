package LineCoverageTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import exercises.FizzBuzz;

public class Exo6Test {
    @Test
    public void testFizzBuzzLineCoverage() {
        assertThrows(IllegalArgumentException.class, () -> FizzBuzz.fizzBuzz(1)); // Bug in code: n <= 1
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(15));
        assertEquals("Fizz", FizzBuzz.fizzBuzz(3));
        assertEquals("Buzz", FizzBuzz.fizzBuzz(5));
        assertEquals("2", FizzBuzz.fizzBuzz(2));
    }
}
