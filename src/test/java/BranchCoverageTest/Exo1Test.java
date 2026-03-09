package BranchCoverageTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import exercises.Palindrome;

public class Exo1Test {

    @Test
    public void testNull_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> Palindrome.isPalindrome(null));
    }

    // Branch: while (i < j) → false (never enters loop)
    @Test
    public void testEmptyString_returnsTrue() {
        assertTrue(Palindrome.isPalindrome(""));
    }

    // Branch: while (i < j) → true, if (charAt != charAt) → false (chars match)
    @Test
    public void testValidPalindrome_returnsTrue() {
        assertTrue(Palindrome.isPalindrome("aba"));
    }

    // Branch: while (i < j) → true, if (charAt != charAt) → true (mismatch)
    @Test
    public void testNotPalindrome_returnsFalse() {
        assertFalse(Palindrome.isPalindrome("ab"));
    }

    // Branch: toLowerCase + replaceAll active
    @Test
    public void testMixedCaseWithSpaces_returnsTrue() {
        assertTrue(Palindrome.isPalindrome("A ba"));
    }
}