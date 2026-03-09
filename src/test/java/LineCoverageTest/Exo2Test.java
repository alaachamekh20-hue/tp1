package LineCoverageTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import exercises.Anagram;

public class Exo2Test {
    @Test
    public void testIsAnagramLineCoverage() {
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram(null, null));
        assertFalse(Anagram.isAnagram("abc", "ab"));
        assertThrows(StringIndexOutOfBoundsException.class, () -> Anagram.isAnagram("a", "a"));
    }
}
