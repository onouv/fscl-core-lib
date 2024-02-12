package ono.fscl.shadow.domain.component;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ono.fscl.core.domain.component.ComponentCode;
import ono.fscl.core.domain.entity.id.SegmentFormatException;

class ComponentCodeUnitTest {
    private ComponentCode code;

    @BeforeEach
    void setup() {
        code = new ComponentCode();
    }

    @Test
    void shouldAddSingleDigit() {
        String group = "1";
        String expected = "-1";

        ComponentCode code = new ComponentCode();
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
        String expected = "-A";

        ComponentCode code = new ComponentCode();
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
        String expected = "-a";

        ComponentCode code = new ComponentCode();
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
        String expected = "-abcd.abcd.abcd.abcd";

        ComponentCode code = new ComponentCode();
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
        String expected = "-ABCD.ABCD.ABCD.ABCD";

        ComponentCode code = new ComponentCode();
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
        

        ComponentCode code = new ComponentCode();

        try {
            code.addSegment(group);

            fail("Did not catch empty group.");

        } catch (SegmentFormatException e) {
            assert(true);
        }

    }

}
