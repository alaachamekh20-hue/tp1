package LineCoverageTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import exercises.BinarySearch;

public class Exo3Test {
    @Test
    public void testBinarySearchLineCoverage() {
        assertThrows(NullPointerException.class, () -> BinarySearch.binarySearch(null, 0));
        assertEquals(-1, BinarySearch.binarySearch(new int[] { 1 }, 1));
        assertEquals(-1, BinarySearch.binarySearch(new int[] { 1, 2 }, 3));
    }
}
