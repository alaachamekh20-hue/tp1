package LineCoverageTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import exercises.Palindrome;

public class Exo1Test {
    @Test
    public void testIsPalindromeLineCoverage() {
        assertThrows(NullPointerException.class, () -> Palindrome.isPalindrome(null));
        assertTrue(Palindrome.isPalindrome("a"));
        assertFalse(Palindrome.isPalindrome("ab"));
    }
}
