package ConditionCoverageTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import exercises.Anagram;

public class Exo2Test {

    // Condition: s1 == null → true
    @Test
    public void testFirstNull_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram(null, "abc"));
    }

    // Condition: s2 == null → true
    @Test
    public void testSecondNull_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram("abc", null));
    }

    // Condition: s1 == null → false AND s2 == null → false
    @Test
    public void testBothNotNull_doesNotThrow() {
        assertDoesNotThrow(() -> Anagram.isAnagram("abc", "ab"));
    }

    // Condition: s1.length() != s2.length() → true
    @Test
    public void testDifferentLengths_returnsFalse() {
        assertFalse(Anagram.isAnagram("abc", "ab"));
    }

    // Condition: s1.length() != s2.length() → false, for loop entered, bug triggers
    @Test
    public void testSameLength_loopEntered_throwsDueToBug() {
        assertThrows(StringIndexOutOfBoundsException.class, () -> Anagram.isAnagram("ab", "cd"));
    }

    // Condition: i <= s1.length() → true (loop body executed), bug triggers
    @Test
    public void testLoopConditionTrue_throwsDueToBug() {
        assertThrows(StringIndexOutOfBoundsException.class, () -> Anagram.isAnagram("abc", "bca"));
    }

    // Condition: i <= s1.length() → false (loop exits normally) — unreachable due
    // to bug
    // Condition: c != 0 → true (not anagram) — unreachable due to bug
    // Condition: c != 0 → false (is anagram) — unreachable due to bug
    @Test
    public void testValidAnagram_unreachable_throwsDueToBug() {
        assertThrows(StringIndexOutOfBoundsException.class, () -> Anagram.isAnagram("listen", "silent"));
    }
}