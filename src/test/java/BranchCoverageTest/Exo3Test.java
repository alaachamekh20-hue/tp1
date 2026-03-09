package BranchCoverageTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import exercises.BinarySearch;

public class Exo3Test {

    // Branch: array == null → true
    @Test
    public void testNullArray_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> BinarySearch.binarySearch(null, 0));
    }

    // Branch: while (low < high) → false (never enters)
    @Test
    public void testEmptyArray_returnsMinus1() {
        assertEquals(-1, BinarySearch.binarySearch(new int[] {}, 5));
    }

    // Branch: while (low < high) → false (single element, low == high)
    @Test
    public void testSingleElement_notFound_returnsMinus1() {
        assertEquals(-1, BinarySearch.binarySearch(new int[] { 1 }, 1));
    }

    // Branch: while → true, array[mid] == element → true
    @Test
    public void testElementFoundAtMid_returnsIndex() {
        assertEquals(1, BinarySearch.binarySearch(new int[] { 1, 2, 3 }, 2));
    }

    // Branch: while → true, array[mid] == element → false, array[mid] <= element →
    // true
    @Test
    public void testElementInUpperHalf_takesLowBranch() {
        assertEquals(3, BinarySearch.binarySearch(new int[] { 1, 2, 3, 4, 5 }, 4));
    }

    // Branch: while → true, array[mid] == element → false, array[mid] <= element →
    // false
    @Test
    public void testElementInLowerHalf_takesHighBranch() {
        assertEquals(1, BinarySearch.binarySearch(new int[] { 1, 3, 5, 7, 9 }, 3));
    }

    // Branch: while → true then → false (element not found after full search)
    @Test
    public void testElementNotInArray_returnsMinus1() {
        assertEquals(-1, BinarySearch.binarySearch(new int[] { 1, 2, 3 }, 9));
    }
}