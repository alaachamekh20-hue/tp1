package LineCoverageTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import exercises.QuadraticEquation;

public class Exo4Test {
    @Test
    public void testQuadraticEquationLineCoverage() {
        assertThrows(IllegalArgumentException.class, () -> QuadraticEquation.solve(0, 1, 1));
        assertNull(QuadraticEquation.solve(1, 0, 1)); // delta = -4
        assertArrayEquals(new double[] { -1.0 }, QuadraticEquation.solve(1, 2, 1), 0.0001); // delta = 0
        assertNotNull(QuadraticEquation.solve(1, 5, 4)); // delta = 9
    }
}
