package ConditionCoverageTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import exercises.BinarySearch;

public class Exo3Test {

    // Condition: array == null → true
    @Test
    public void testNullArray_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> BinarySearch.binarySearch(null, 0));
    }

    // Condition: array == null → false
    @Test
    public void testNotNullArray_doesNotThrow() {
        assertDoesNotThrow(() -> BinarySearch.binarySearch(new int[] { 1 }, 0));
    }

    // Condition: low < high → false (empty array)
    @Test
    public void testEmptyArray_loopSkipped_returnsMinus1() {
        assertEquals(-1, BinarySearch.binarySearch(new int[] {}, 5));
    }

    // Condition: low < high → false (single element, low == high)
    @Test
    public void testSingleElement_loopSkipped_returnsMinus1() {
        assertEquals(-1, BinarySearch.binarySearch(new int[] { 1 }, 1));
    }

    // Condition: low < high → true, array[mid] == element → true
    @Test
    public void testElementAtMid_returnsIndex() {
        assertEquals(1, BinarySearch.binarySearch(new int[] { 1, 2, 3 }, 2));
    }

    // Condition: low < high → true, array[mid] == element → false,
    // array[mid] <= element → true (low = mid + 1)
    @Test
    public void testElementInUpperHalf_lowBranchTaken() {
        assertEquals(3, BinarySearch.binarySearch(new int[] { 1, 2, 3, 4, 5 }, 4));
    }

    // Condition: low < high → true, array[mid] == element → false,
    // array[mid] <= element → false (high = mid - 1)
    @Test
    public void testElementInLowerHalf_highBranchTaken() {
        assertEquals(1, BinarySearch.binarySearch(new int[] { 1, 3, 5, 7, 9 }, 3));
    }

    // Condition: low < high → true then eventually → false (not found)
    @Test
    public void testElementNotInArray_returnsMinus1() {
        assertEquals(-1, BinarySearch.binarySearch(new int[] { 1, 2, 4, 5 }, 3));
    }
}