package ono.fscl.shadow.domain.function;

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
            FunctionCode code = new FunctionCode();
        } catch (PatternSyntaxException e) {
            fail(e.getMessage());
        }
    }

    
    @Test
    void shouldAddSingleGroupOfOneDigits() {
        
        String group = "1";
        String expected = "=1";

        FunctionCode code = new FunctionCode();
        try {
            code.addSegment(group);

            assertEquals(expected, code.toString());

        } catch (SegmentFormatException e) {
            fail(e.getMessage());
        }

    }
    
    @Test
    void shouldAddMultipleGroupsOfOneDigits() {
        
        String group = "1";
        String expected = "=1.1.1.1";

        FunctionCode code = new FunctionCode();
        try {
            code.addSegment(group);
            code.addSegment(group);
            code.addSegment(group);
            code.addSegment(group);

            assertEquals(expected, code.toString());

        } catch (SegmentFormatException e) {
            fail(e.getMessage());
        }

    }

    @Test
    void shouldAddSingleGroupOfFourDigits() {
        
        String group = "1234";
        String expected = "=1234";

        FunctionCode code = new FunctionCode();
        try {
            code.addSegment(group);

            assertEquals(expected, code.toString());

        } catch (SegmentFormatException e) {
            fail(e.getMessage());
        }

    }

    @Test
    void shouldAddMultipleGroupOfFourDigits() {
        
        String group = "1234";
        String expected = "=1234.1234.1234";

        FunctionCode code = new FunctionCode();
        try {
            code.addSegment(group);
            code.addSegment(group);
            code.addSegment(group);

            assertEquals(expected, code.toString());

        } catch (SegmentFormatException e) {
            fail(e.getMessage());
        }

    }

    @Test
    void shouldAddSingleGroupOfFourUpperCases() {
        
        String group = "ABCD";
        String expected = "=ABCD";

        FunctionCode code = new FunctionCode();
        try {
            code.addSegment(group);

            assertEquals(expected, code.toString());

        } catch (SegmentFormatException e) {
            fail(e.getMessage());
        }

    }

    @Test
    void shouldAddMultipleGroupOfFourUpperCases() {
        
        String group = "ABCD";
        String expected = "=ABCD.ABCD.ABCD";

        FunctionCode code = new FunctionCode();
        try {
            code.addSegment(group);
            code.addSegment(group);
            code.addSegment(group);

            assertEquals(expected, code.toString());

        } catch (SegmentFormatException e) {
            fail(e.getMessage());
        }

    }

    @Test
    void shouldAddSingleGroupOfFourLowerCases() {
        
        String group = "abcd";
        String expected = "=abcd";

        FunctionCode code = new FunctionCode();
        try {
            code.addSegment(group);

            assertEquals(expected, code.toString());

        } catch (SegmentFormatException e) {
            fail(e.getMessage());
        }

    }

    @Test
    void shouldAddMultipleGroupOfFourLowerCases() {
        
        String group = "abcd";
        String expected = "=abcd.abcd.abcd";

        FunctionCode code = new FunctionCode();
        try {
            code.addSegment(group);
            code.addSegment(group);
            code.addSegment(group);

            assertEquals(expected, code.toString());

        } catch (SegmentFormatException e) {
            fail(e.getMessage());
        }

    }

    @Test
    void shouldCatchGroupsOfFiveLowerCases() {
        
        String group = "abcde";
        

        FunctionCode code = new FunctionCode();

        try {
            code.addSegment(group);

            fail("Did not catch group of more than 4 lower cases.");

        } catch (SegmentFormatException e) {
            assert(true);
        }

    }

    @Test
    void shouldCatchGroupsOfFiveUpperCases() {
        
        String group = "ABCDE";
        

        FunctionCode code = new FunctionCode();

        try {
            code.addSegment(group);

            fail("Did not catch group of more than 4 upper cases.");

        } catch (SegmentFormatException e) {
            assert(true);
        }

    }

    @Test
    void shouldCatchGroupsOfFiveDigits() {
        
        String group = "12345";
        

        FunctionCode code = new FunctionCode();

        try {
            code.addSegment(group);

            fail("Did not catch group of more than 4 digits.");

        } catch (SegmentFormatException e) {
            assert(true);
        }

    }

    @Test
    void shouldCatchEmptyGroup() {
        
        String group = "";
        

        FunctionCode code = new FunctionCode();

        try {
            code.addSegment(group);

            fail("Did not catch empty group.");

        } catch (SegmentFormatException e) {
            assert(true);
        }
    }

    @Test
    void whenCreatedEqualShouldCompareEqual() {
        FunctionCode a = new FunctionCode();
        FunctionCode b = new FunctionCode();

        try {
            a.addSegment("AA");
            b.addSegment("AA");
            a.addSegment("53");
            b.addSegment("53");
            a.addSegment("BB");
            b.addSegment("BB");

            assertTrue(a.equals(b));

        } catch (SegmentFormatException e) {
            fail("Failed in prep for test: " + e.getMessage());
        }
    }

    @Test
    void whenCreatedUnequalShouldCompareUnequal() {
        FunctionCode a = new FunctionCode();
        FunctionCode b = new FunctionCode();

        try {
            a.addSegment("AA");
            b.addSegment("AAA");
            a.addSegment("53");
            b.addSegment("53");
            a.addSegment("BB");
            b.addSegment("BB");

            assertFalse(a.equals(b));

        } catch (SegmentFormatException e) {
            fail("Failed in prep for test: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("WHEN created equal THEN should yield same hashcode")
    void whenCreatedEqualShouldYieldSameHash() {
        FunctionCode a = new FunctionCode();
        FunctionCode b = new FunctionCode();

        try {
            a.addSegment("AA");
            b.addSegment("AA");
            a.addSegment("53");
            b.addSegment("53");
            a.addSegment("BB");
            b.addSegment("BB");

            assertEquals(a.hashCode(), b.hashCode());

        } catch (SegmentFormatException e) {
            fail("Failed in prep for test: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("WHEN created equal THEN should yield same hashcode")
    void whenCreatedUnequalShouldYieldDifferentHash() {
        FunctionCode a = new FunctionCode();
        FunctionCode b = new FunctionCode();

        try {
            a.addSegment("AA");
            b.addSegment("AAA");
            a.addSegment("53");
            b.addSegment("53");
            a.addSegment("BB");
            b.addSegment("BB");

            assertNotEquals(a.hashCode(), b.hashCode());

        } catch (SegmentFormatException e) {
            fail("Failed in prep for test: " + e.getMessage());
        }
    }
}
