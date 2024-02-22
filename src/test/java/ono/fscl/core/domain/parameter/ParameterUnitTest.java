package ono.fscl.core.domain.parameter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import tech.units.indriya.quantity.Quantities;

import static tech.units.indriya.unit.Units.LITRE;
import static tech.units.indriya.unit.Units.METRE;
import javax.measure.Quantity;
import javax.measure.quantity.Length;
import javax.measure.quantity.Volume;

class ParameterUnitTest {


    @Nested
    @DisplayName("GIVEN quantity of 12.4 m length")
    class GivenLength {
        private final double value = 12.4;
        private Quantity<Length> length = null;
        @BeforeEach
        void setUp() {
            length = Quantities.getQuantity(value, METRE);
        }

        @Test
        @DisplayName("Smoke test javax.measure.Quantity system")
        void shouldHave12m() {
            assertEquals(12.4, length.getValue());
            assertEquals(METRE, length.getUnit());
        }

        @Nested
        @DisplayName("WHEN created as 'Stroke'")
        class WhenCreated {
            private Parameter p = null;

            @BeforeEach
            void setup() {
                p = new Parameter("Stroke", Parameter.QuantityType.Length, length);

            }

            @Test
            @DisplayName("THEN have Length type")
            void shouldBHaveLengthType() {
                assertEquals(Parameter.QuantityType.Length, p.type);
            }

            @Test
            @DisplayName("THEN should have name 'Stroke")
            void shouldHaveRightName() {
                assertEquals("Stroke", p.name);
            }

            @Test
            @DisplayName("THEN should have a length of 12.4 m")
            void shouldHaveQuantity() {
                try {
                    Quantity<Length> actual = p.toLength();
                    assertEquals(12.4, actual.getValue());
                    assertEquals("m", actual.getUnit().getSymbol());
                } catch (QuantityTypeException e) {
                    fail(e.getMessage());
                }
            }
        }
    }

    @Nested
    @DisplayName("GIVEN quantity of 355 l volume")
    class GivenVolume {
        private final double value = 355;
        private Quantity<Volume> quantity = null;
        @BeforeEach
        void setUp() {
            quantity = Quantities.getQuantity(value, LITRE);
        }

        @Nested
        @DisplayName("WHEN created as 'Tank Capacity'")
        class WhenCreated {
            private Parameter p = null;

            @BeforeEach
            void setup() {
                p = new Parameter("Tank Capacity", Parameter.QuantityType.Volume, quantity);

            }

            @Test
            @DisplayName("THEN have Volume type")
            void shouldBHaveLengthType() {
                assertEquals(Parameter.QuantityType.Volume, p.type);
            }

            @Test
            @DisplayName("THEN should have name 'Tank Capacity")
            void shouldHaveRightName() {
                assertEquals("Tank Capacity", p.name);
            }

            @Test
            @DisplayName("THEN should have a volume of 355 l")
            void shouldHaveQuantity() {
                try {
                    Quantity<Volume> actual = p.toVolume();
                    assertEquals(355, actual.getValue());
                    assertEquals("l", actual.getUnit().getSymbol());
                } catch (QuantityTypeException e) {
                    fail(e.getMessage());
                }
            }
        }
    }


}