package BranchCoverageTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import exercises.Anagram;

public class Exo2Test {

    // Branch: s1 == null → true
    @Test
    public void testFirstNull_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram(null, "abc"));
    }

    // Branch: s2 == null → true
    @Test
    public void testSecondNull_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram("abc", null));
    }

    // Branch: s1 == null || s2 == null → false, length != → true
    @Test
    public void testDifferentLengths_returnsFalse() {
        assertFalse(Anagram.isAnagram("abc", "ab"));
    }

    // Branch: length != → false, for loop entered, bug triggers
    @Test
    public void testSameLength_throwsDueToBug() {
        assertThrows(StringIndexOutOfBoundsException.class, () -> Anagram.isAnagram("abc", "xyz"));
    }

    // Branch: for (int c : count) → c != 0 → true (not anagram), bug prevents reach
    @Test
    public void testNotAnagram_throwsDueToBug() {
        assertThrows(StringIndexOutOfBoundsException.class, () -> Anagram.isAnagram("ab", "cd"));
    }

    // Branch: for (int c : count) → c != 0 → false (is anagram), bug prevents reach
    @Test
    public void testValidAnagram_throwsDueToBug() {
        assertThrows(StringIndexOutOfBoundsException.class, () -> Anagram.isAnagram("listen", "silent"));
    }
}