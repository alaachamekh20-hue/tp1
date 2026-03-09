package BranchCoverageTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import exercises.RomanNumeral;

public class Exo5Test {

    // Branch: n < 1 → true
    @Test
    public void testBelowRange_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(0));
    }

    // Branch: n > 3999 → true
    @Test
    public void testAboveRange_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(4000));
    }

    // Branch: guard → false, for loop entered, while (n > values[i]) → false, bug
    // triggers on i++
    @Test
    public void testSmallValue_throwsDueToBug() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> RomanNumeral.toRoman(1));
    }

    // Branch: while (n > values[i]) → true (appends symbol), then bug triggers
    @Test
    public void testLargeValue_throwsDueToBug() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> RomanNumeral.toRoman(3999));
    }

    // Branch: multiple while → true iterations before bug triggers
    @Test
    public void testMiddleValue_throwsDueToBug() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> RomanNumeral.toRoman(1994));
    }
}