package org.fscl.core.domain.component;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.fscl.core.domain.entity.id.SegmentMismatchException;
import org.junit.jupiter.api.Test;

class ComponentCodeUnitTest {
    private ComponentCode code;

    @Test
    void shouldAddSingleDigit() {
        String group = "1";
        String expected = "-1";

        try {
            ComponentCode code = ComponentCode.builder().withSegment(group).build();

            assertEquals(expected, code.toString());

        } catch (SegmentMismatchException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void shouldAddSingleUpperCase() {
        String group = "A";
        String expected = "-A";

        try {
            ComponentCode code = ComponentCode.builder().withSegment(group).build();
            assertEquals(expected, code.toString());
        } catch (SegmentMismatchException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void shouldAddSingleLowerCase() {
        String group = "a";
        String expected = "-a";

        try {
            ComponentCode code = ComponentCode.builder().withSegment(group).build();
            assertEquals(expected, code.toString());
        } catch (SegmentMismatchException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void shouldAddFourLowercaseGroups() {
    
        String group = "abcd";
        String expected = "-abcd.abcd.abcd.abcd";

        try {
            ComponentCode code = ComponentCode.builder()
                    .withSegment(group)
                    .withSegment(group)
                    .withSegment(group)
                    .withSegment(group)
                    .build();
            assertEquals(expected, code.toString());
        } catch (SegmentMismatchException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void shouldAddFourUppercaseGroups() {
        String group = "ABCD";
        String expected = "-ABCD.ABCD.ABCD.ABCD";

        try {
            ComponentCode code = ComponentCode.builder()
                    .withSegment(group)
                    .withSegment(group)
                    .withSegment(group)
                    .withSegment(group)
                    .build();
            assertEquals(expected, code.toString());
        } catch (SegmentMismatchException e) {
            fail(e.getMessage());
        }
    }


    @Test
    void shouldCatchEmptyGroup() {
        
        String group = "";

        try {
            ComponentCode code = ComponentCode.builder()
                    .withSegment(group)
                    .build();

            fail("Did not catch empty group.");

        } catch (SegmentMismatchException e) {
            assert(true);
        }

    }

}
