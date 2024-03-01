package ono.fscl.core.domain.location;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import ono.fscl.core.domain.component.ComponentCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ono.fscl.core.domain.entity.id.SegmentFormatException;
import ono.fscl.core.domain.location.LocationCode;
class LocationCodeUnitTest {

    private LocationCode code;

    @Test
    void shouldAddSingleDigit() {
        String group = "1";
        String expected = "+1";

        try {
            LocationCode code = LocationCode.builder().withSegment(group).build();

            assertEquals(expected, code.toString());

        } catch (SegmentFormatException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void shouldAddSingleUpperCase() {
        String group = "A";
        String expected = "+A";

        try {
            LocationCode code = LocationCode.builder().withSegment(group).build();
            assertEquals(expected, code.toString());
        } catch (SegmentFormatException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void shouldAddSingleLowerCase() {
        String group = "a";
        String expected = "+a";

        try {
            LocationCode code = LocationCode.builder().withSegment(group).build();
            assertEquals(expected, code.toString());
        } catch (SegmentFormatException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void shouldAddFourLowercaseGroups() {

        String group = "abcd";
        String expected = "+abcd.abcd.abcd.abcd";

        try {
            LocationCode code = LocationCode.builder()
                    .withSegment(group)
                    .withSegment(group)
                    .withSegment(group)
                    .withSegment(group)
                    .build();
            assertEquals(expected, code.toString());
        } catch (SegmentFormatException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void shouldAddFourUppercaseGroups() {
        String group = "ABCD";
        String expected = "+ABCD.ABCD.ABCD.ABCD";

        try {
            LocationCode code = LocationCode.builder()
                    .withSegment(group)
                    .withSegment(group)
                    .withSegment(group)
                    .withSegment(group)
                    .build();
            assertEquals(expected, code.toString());
        } catch (SegmentFormatException e) {
            fail(e.getMessage());
        }
    }


    @Test
    void shouldCatchEmptyGroup() {

        String group = "";

        try {
            LocationCode code = LocationCode.builder()
                    .withSegment(group)
                    .build();

            fail("Did not catch empty group.");

        } catch (SegmentFormatException e) {
            assert(true);
        }

    }

}
