package ConditionCoverageTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import exercises.Palindrome;

public class Exo1Test {

    // Condition: s == null → true
    @Test
    public void testNull_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> Palindrome.isPalindrome(null));
    }

    // Condition: s == null → false
    @Test
    public void testNotNull_doesNotThrow() {
        assertDoesNotThrow(() -> Palindrome.isPalindrome("a"));
    }

    // Condition: i < j → false (empty string, loop never entered)
    @Test
    public void testEmptyString_loopSkipped_returnsTrue() {
        assertTrue(Palindrome.isPalindrome(""));
    }

    // Condition: i < j → false (single char, i == j)
    @Test
    public void testSingleChar_loopSkipped_returnsTrue() {
        assertTrue(Palindrome.isPalindrome("a"));
    }

    // Condition: i < j → true, charAt(i) != charAt(j) → false (chars match)
    @Test
    public void testPalindrome_charsMatch_returnsTrue() {
        assertTrue(Palindrome.isPalindrome("aba"));
    }

    // Condition: i < j → true, charAt(i) != charAt(j) → true (mismatch)
    @Test
    public void testNotPalindrome_charsMismatch_returnsFalse() {
        assertFalse(Palindrome.isPalindrome("ab"));
    }

    // Condition: toLowerCase active (uppercase input)
    @Test
    public void testUpperCase_normalizedCorrectly() {
        assertTrue(Palindrome.isPalindrome("ABA"));
    }

    // Condition: replaceAll active (spaces in input)
    @Test
    public void testWithSpaces_normalizedCorrectly() {
        assertTrue(Palindrome.isPalindrome("a ba"));
    }
}