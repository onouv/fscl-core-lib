package ono.fscl.core.domain.location;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ono.fscl.core.domain.entity.id.SegmentFormatException;
import ono.fscl.core.domain.location.LocationCode;
class LocationCodeUnitTest {

    private LocationCode code;

    @BeforeEach
    void setup() {
        code = new LocationCode();
    }

    @Test
    void shouldAddSingleDigit() {
        String group = "1";
        String expected = "+1";

        LocationCode code = new LocationCode();
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
        String expected = "+A";

        LocationCode code = new LocationCode();
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
        String expected = "+a";

        LocationCode code = new LocationCode();
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
        String expected = "+abcd.abcd.abcd.abcd";

        LocationCode code = new LocationCode();
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
        String expected = "+ABCD.ABCD.ABCD.ABCD";

        LocationCode code = new LocationCode();
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
        

        LocationCode code = new LocationCode();

        try {
            code.addSegment(group);

            fail("Did not catch empty group.");

        } catch (SegmentFormatException e) {
            assert(true);
        }

    }
   
}
