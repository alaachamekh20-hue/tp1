package ConditionCoverageTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import exercises.RomanNumeral;

public class Exo5Test {

    // Condition: n < 1 → true
    @Test
    public void testZero_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(0));
    }

    // Condition: n < 1 → true (negative)
    @Test
    public void testNegative_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(-1));
    }

    // Condition: n > 3999 → true
    @Test
    public void testAboveMax_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(4000));
    }

    // Condition: n < 1 → false AND n > 3999 → false (valid input)
    // Condition: i <= symbols.length → true, n > values[i] → false, bug triggers
    @Test
    public void testMinValue_guardFalse_throwsDueToBug() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> RomanNumeral.toRoman(1));
    }

    // Condition: n > values[i] → true (loop body executes), then bug triggers
    @Test
    public void testLargeValue_whileBodyExecuted_throwsDueToBug() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> RomanNumeral.toRoman(3000));
    }

    // Condition: multiple n > values[i] → true iterations before bug
    @Test
    public void testMiddleValue_multipleWhileIterations_throwsDueToBug() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> RomanNumeral.toRoman(1994));
    }

    // Condition: i <= symbols.length → false (loop exits) — unreachable due to bug
    @Test
    public void testMaxValue_throwsDueToBug() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> RomanNumeral.toRoman(3999));
    }
}