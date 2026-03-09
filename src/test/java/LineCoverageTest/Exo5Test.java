package LineCoverageTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import exercises.RomanNumeral;

public class Exo5Test {
    @Test
    public void testRomanNumeralLineCoverage() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(0));
        // This will likely throw ArrayIndexOutOfBoundsException due to the bug i <=
        // symbols.length
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> RomanNumeral.toRoman(1));
    }
}
