package ono.fscl.core.domain.system;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ono.fscl.core.domain.entity.id.SegmentFormatException;
import ono.fscl.core.domain.system.SystemCode;

class SystemCodeUnitTest {
    private SystemCode code;

    @BeforeEach
    void seup() {
        code = new SystemCode();
    }

    @Test
    void shouldAddSingleDigit() {
        String group = "1";
        String expected = "#1";

        SystemCode code = new SystemCode();
        try {
            code.addSegment(group);

            assertEquals(expected, code.toString());

        } catch (SegmentFormatException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void shouldAddSingleUpperCase() {
        String group = "A";
        String expected = "#A";

        SystemCode code = new SystemCode();
        try {
            code.addSegment(group);
            assertEquals(expected, code.toString());
        } catch (SegmentFormatException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void shouldAddSingleLowerCase() {
        String group = "a";
        String expected = "#a";

        SystemCode code = new SystemCode();
        try {
            code.addSegment(group);
            assertEquals(expected, code.toString());
        } catch (SegmentFormatException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void shouldAddFourLowercaseGroups() {
    
        String group = "abcd";
        String expected = "#abcd.abcd.abcd.abcd";

        SystemCode code = new SystemCode();
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
    void shouldAddFourUppercaseGroups() {
        String group = "ABCD";
        String expected = "#ABCD.ABCD.ABCD.ABCD";

        SystemCode code = new SystemCode();
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
    void shouldCatchEmptyGroup() {
        
        String group = "";
        

        SystemCode code = new SystemCode();

        try {
            code.addSegment(group);

            fail("Did not catch empty group.");

        } catch (SegmentFormatException e) {
            assert(true);
        }

    }

}
