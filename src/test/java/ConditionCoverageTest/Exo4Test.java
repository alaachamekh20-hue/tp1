package ConditionCoverageTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import exercises.QuadraticEquation;

public class Exo4Test {

    // Condition: a == 0 → true
    @Test
    public void testAisZero_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> QuadraticEquation.solve(0, 1, 1));
    }

    // Condition: a == 0 → false
    @Test
    public void testAisNotZero_doesNotThrow() {
        assertDoesNotThrow(() -> QuadraticEquation.solve(1, 0, 1));
    }

    // Condition: delta < 0 → true
    @Test
    public void testNegativeDelta_returnsNull() {
        assertNull(QuadraticEquation.solve(1, 0, 1)); // delta = -4
    }

    // Condition: delta < 0 → false AND delta == 0 → true
    @Test
    public void testZeroDelta_returnsOneRoot() {
        assertArrayEquals(new double[] { -1.0 }, QuadraticEquation.solve(1, 2, 1), 0.0001); // delta = 0
    }

    // Condition: delta < 0 → false AND delta == 0 → false (delta > 0)
    @Test
    public void testPositiveDelta_returnsTwoRoots() {
        assertArrayEquals(new double[] { -1.0, -4.0 }, QuadraticEquation.solve(1, 5, 4), 0.0001); // delta = 9
    }

    // Condition: delta exactly 0 (boundary)
    @Test
    public void testDeltaExactlyZero_singleRootValue() {
        double[] result = QuadraticEquation.solve(1, 2, 1);
        assertEquals(1, result.length);
        assertEquals(-1.0, result[0], 0.0001);
    }

    // Condition: delta > 0 — two roots have correct values
    @Test
    public void testPositiveDelta_twoRootsCorrectValues() {
        double[] result = QuadraticEquation.solve(1, 5, 4);
        assertEquals(2, result.length);
        assertEquals(-1.0, result[0], 0.0001);
        assertEquals(-4.0, result[1], 0.0001);
    }
}