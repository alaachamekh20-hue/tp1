package BranchCoverageTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import exercises.QuadraticEquation;

public class Exo4Test {

    // Branch: a == 0 → true
    @Test
    public void testAisZero_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> QuadraticEquation.solve(0, 1, 1));
    }

    // Branch: a == 0 → false, delta < 0 → true
    @Test
    public void testNegativeDelta_returnsNull() {
        assertNull(QuadraticEquation.solve(1, 0, 1)); // delta = -4
    }

    // Branch: delta < 0 → false, delta == 0 → true
    @Test
    public void testZeroDelta_returnsOneRoot() {
        assertArrayEquals(new double[] { -1.0 }, QuadraticEquation.solve(1, 2, 1), 0.0001); // delta = 0
    }

    // Branch: delta < 0 → false, delta == 0 → false (delta > 0)
    @Test
    public void testPositiveDelta_returnsTwoRoots() {
        assertArrayEquals(new double[] { -1.0, -4.0 }, QuadraticEquation.solve(1, 5, 4), 0.0001); // delta = 9
    }
}