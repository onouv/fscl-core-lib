package ono.fscl.core.domain.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.regex.PatternSyntaxException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ono.fscl.core.domain.entity.id.SegmentFormatException;
import ono.fscl.core.domain.function.FunctionCode;

class FunctionCodeUnitTest {

    @Test
    void shouldCreate() {
        try {
            FunctionCode code = FunctionCode.builder().build();
        } catch (SegmentFormatException e) {
            fail(e.getMessage());
        }
    }

    
    @Test
    void shouldAddSingleGroupOfOneDigits() {
        
        String seg = "1";
        String expected = "=1";

        try {
            FunctionCode code = FunctionCode.builder()
                    .withSegment(seg)
                    .build();
            assertEquals(expected, code.toString());
        } catch (SegmentFormatException e) {
            fail(e.getMessage());
        }
    }
    
    @Test
    void shouldAddMultipleGroupsOfOneDigits() {
        
        String seg = "1";
        String expected = "=1.1.1.1";

        try {
            FunctionCode code = FunctionCode.builder()
                    .withSegment(seg)
                    .withSegment(seg)
                    .withSegment(seg)
                    .withSegment(seg)
                    .build();
            assertEquals(expected, code.toString());
        } catch (SegmentFormatException e) {
            fail(e.getMessage());
        }

    }

    @Test
    void shouldAddSingleGroupOfFourDigits() {
        
        String seg = "1234";
        String expected = "=1234";

        try {
            FunctionCode code = FunctionCode.builder()
                    .withSegment(seg)
                    .build();
            assertEquals(expected, code.toString());
        } catch (SegmentFormatException e) {
            fail(e.getMessage());
        }

    }

    @Test
    void shouldAddMultipleGroupOfFourDigits() {
        
        String seg = "1234";
        String expected = "=1234.1234.1234";

        try {
            FunctionCode code = FunctionCode.builder()
                    .withSegment(seg)
                    .withSegment(seg)
                    .withSegment(seg)
                    .build();
            assertEquals(expected, code.toString());
        } catch (SegmentFormatException e) {
            fail(e.getMessage());
        }

    }

    @Test
    void shouldAddSingleGroupOfFourUpperCases() {
        
        String seg = "ABCD";
        String expected = "=ABCD";

        try {
            FunctionCode code = FunctionCode.builder()
                    .withSegment(seg)
                    .build();
            assertEquals(expected, code.toString());
        } catch (SegmentFormatException e) {
            fail(e.getMessage());
        }

    }

    @Test
    void shouldAddMultipleGroupOfFourUpperCases() {
        
        String seg = "ABCD";
        String expected = "=ABCD.ABCD.ABCD";

        try {
            FunctionCode code = FunctionCode.builder()
                    .withSegment(seg)
                    .withSegment(seg)
                    .withSegment(seg)
                    .build();
            assertEquals(expected, code.toString());
        } catch (SegmentFormatException e) {
            fail(e.getMessage());
        }

    }

    @Test
    void shouldAddSingleGroupOfFourLowerCases() {
        
        String seg = "abcd";
        String expected = "=abcd";

        try {
            FunctionCode code = FunctionCode.builder()
                    .withSegment(seg)
                    .build();
            assertEquals(expected, code.toString());
        } catch (SegmentFormatException e) {
            fail(e.getMessage());
        }

    }

    @Test
    void shouldAddMultipleGroupOfFourLowerCases() {
        
        String seg = "abcd";
        String expected = "=abcd.abcd.abcd";

        try {
            FunctionCode code = FunctionCode.builder()
                    .withSegment(seg)
                    .withSegment(seg)
                    .withSegment(seg)
                    .build();
            assertEquals(expected, code.toString());
        } catch (SegmentFormatException e) {
            fail(e.getMessage());
        }

    }

    @Test
    void shouldCatchGroupsOfFiveLowerCases() {
        
        String seg = "abcde";

        try {
            FunctionCode code = FunctionCode.builder()
                    .withSegment(seg)
                    .build();

            fail("Did not catch group of more than 4 lower cases.");

        } catch (SegmentFormatException e) {
            assert(true);
        }

    }

    @Test
    void shouldCatchGroupsOfFiveUpperCases() {
        
        String group = "ABCDE";


        try {
            FunctionCode code = FunctionCode.builder()
                    .withSegment(group)
                    .build();

            fail("Did not catch group of more than 4 upper cases.");

        } catch (SegmentFormatException e) {
            assert(true);
        }

    }

    @Test
    void shouldCatchGroupsOfFiveDigits() {
        
        String group = "12345";

        try {
            FunctionCode code = FunctionCode.builder()
                    .withSegment(group)
                    .build();

            fail("Did not catch group of more than 4 digits.");

        } catch (SegmentFormatException e) {
            assert(true);
        }
    }

    @Test
    void shouldCatchEmptyGroup() {
        
        String group = "";

        try {
            FunctionCode code = FunctionCode.builder()
                    .withSegment(group)
                    .build();

            fail("Did not catch empty group.");

        } catch (SegmentFormatException e) {
            assert(true);
        }
    }

    @Test
    void whenCreatedEqualShouldCompareEqual() {
        try {
            FunctionCode a = FunctionCode.builder()
                    .withSegment("AA")
                    .withSegment("53")
                    .withSegment("BB")
                    .build();

            FunctionCode b = FunctionCode.builder()
                    .withSegment("AA")
                    .withSegment("53")
                    .withSegment("BB")
                    .build();

            assertEquals(a, b);

        } catch (SegmentFormatException e) {
            fail("Failed in prep for test: " + e.getMessage());
        }
    }

    @Test
    void whenCreatedUnequalShouldCompareUnequal() {
        try {
            FunctionCode a = FunctionCode.builder()
                    .withSegment("AAA")
                    .withSegment("53")
                    .withSegment("BB")
                    .build();

            FunctionCode b = FunctionCode.builder()
                    .withSegment("AA")
                    .withSegment("53")
                    .withSegment("BB")
                    .build();

            assertNotEquals(a, b);

        } catch (SegmentFormatException e) {
            fail("Failed in prep for test: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("WHEN created equal THEN should yield same hashcode")
    void whenCreatedEqualShouldYieldSameHash() {
        try {
            FunctionCode a = FunctionCode.builder()
                    .withSegment("AA")
                    .withSegment("53")
                    .withSegment("BB")
                    .build();

            FunctionCode b = FunctionCode.builder()
                    .withSegment("AA")
                    .withSegment("53")
                    .withSegment("BB")
                    .build();

            assertEquals(a.hashCode(), b.hashCode());

        } catch (SegmentFormatException e) {
            fail("Failed in prep for test: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("WHEN created unequal THEN should yield different hashcode")
    void whenCreatedUnequalShouldYieldDifferentHash() {
        try {
            FunctionCode a = FunctionCode.builder()
                    .withSegment("AA")
                    .withSegment("53")
                    .withSegment("BB")
                    .build();

            FunctionCode b = FunctionCode.builder()
                    .withSegment("AAA")
                    .withSegment("53")
                    .withSegment("BB")
                    .build();

            assertNotEquals(a.hashCode(), b.hashCode());

        } catch (SegmentFormatException e) {
            fail("Failed in prep for test: " + e.getMessage());
        }
    }
}
