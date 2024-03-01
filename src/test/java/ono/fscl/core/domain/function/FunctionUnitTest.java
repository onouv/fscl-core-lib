package ono.fscl.core.domain.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import ono.fscl.core.domain.parameter.Parameter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import ono.fscl.core.domain.entity.id.FsclEntityId;
import ono.fscl.core.domain.entity.id.SegmentFormatException;
import tech.units.indriya.quantity.Quantities;
import static tech.units.indriya.unit.Units.METRE;

class FunctionUnitTest {

    class TestFunction extends FunctionBase {
        public TestFunction(
            FsclEntityId<FunctionCode> id,
            FunctionBase parent, 
            String name, 
            String description) {
            super(id, parent, name, description);
        }

        @Override
        public FsclEntityId<FunctionCode> getIdentifier() {
            return this.identifier;
        }

        public TestFunction(FsclEntityId<FunctionCode> id) {
            super(id, null, "", "");
        }
    }

    @Nested
    @DisplayName("GIVEN function code and project name")
    class GivenIdentifier {
    
        private FunctionCode code;;
        private String project = "Testproject";

        private String EXPECTED_CODE = "=AAA.BAC.023";

        @BeforeEach
        void setup() {
            try {
                code = FunctionCode.builder()
                        .withSegment("AAA")
                        .withSegment("BAC")
                        .withSegment("023")
                        .build();
            } catch (SegmentFormatException e) {
                fail("Failed in setup with code formatting exception: " + e.getMessage());
            }
        }
        

        @Nested
        @DisplayName("WHEN Created with only Identifier")
        class WhenCreatedWithIdentifier {
            private TestFunction func = null;
            
            @BeforeEach
            void setup() {
                func = new TestFunction(new FsclEntityId<FunctionCode>(code, project));
            }

            @Test
            @DisplayName("THEN it should exist")
            void shouldExist() {
                assertNotNull(func);
            }

            @Test
            @DisplayName("THEN it should have the given identifier")
            void shouldHaveIdentifier() {
                FsclEntityId<FunctionCode> id = func.getIdentifier();
                assertEquals(EXPECTED_CODE, id.code.toString());
                assertEquals(project, id.project);
            }

            @Test
            @DisplayName("THEN it should not have a parent")
            void shouldHaveNoParent() {
                assertNull(func.getParent());
            }

            @Test
            @DisplayName("THEN it should not have a Name")
            void shouldHaveNoName() {
                assertEquals("", func.getName());
            }

            @Test
            @DisplayName("THEN it should not have a Description")
            void shouldHaveNoDescription() {
                assertEquals("", func.getDescription());
            }
        }


        @Nested
        @DisplayName("GIVEN TestFunction")
        class GivenTestFunction {

            private TestFunction testFunction = null;

            @Nested
            @DisplayName("GIVEN 'Suction Header' and 'Discharge Header'")
            class GivenParamsAdded {

                private final String SUCTION = "Suction Header";
                private final String DISCHARGE  = "Discharge Header";

                @BeforeEach
                void setup() {
                    testFunction = new TestFunction(new FsclEntityId<FunctionCode>(code, project));
                    Parameter suctionHeader = Parameter.ofLength(SUCTION, Quantities.getQuantity(3.34, METRE));
                    testFunction.addParameter(suctionHeader);
                    testFunction.addParameter(
                            DISCHARGE,
                            Parameter.QuantityType.Length,
                            Quantities.getQuantity(15, METRE));
                }

                @Nested
                @DisplayName("WHEN queried for 'Suction Header'  and 'Discharge Header'")
                class WhenQueried {

                    private Parameter actualSuction = null;
                    private Parameter actualDischarge = null;

                    @BeforeEach()
                    void setup() {
                        actualSuction = testFunction.getParameter(SUCTION);
                        actualDischarge = testFunction.getParameter(DISCHARGE);
                    }
                    @Test
                    @DisplayName("THEN should yield parameters 'Suction Header'")
                    void shouldYieldSuctionName() {
                        assertNotNull(actualSuction);
                        assertEquals(SUCTION, actualSuction.name);
                    }

                    @Test
                    @DisplayName("THEN should yield parameter 'Discharge Header'")
                    void shouldYieldDischargeName() {
                        assertNotNull(actualDischarge);
                        assertEquals(DISCHARGE, actualDischarge.name);
                    }

                    @Test
                    @DisplayName("THEN should yield 'Suction Header' of 3.34 m length")
                    void shouldYieldSuctionValue() {
                        assertNotNull(actualSuction);
                        assertEquals(3.34, actualSuction.quantity.getValue());
                        assertEquals(METRE, actualSuction.quantity.getUnit());
                        assertEquals("m", actualSuction.quantity.getUnit().getSymbol());
                        assertEquals(Parameter.QuantityType.Length, actualSuction.type);
                    }

                    @Test
                    @DisplayName("THEN should yield 'Discharge Header' of 3.34 m length")
                    void shouldYieldDischargeValue() {
                        assertNotNull(actualDischarge);
                        assertEquals(15, actualDischarge.quantity.getValue());
                        assertEquals(METRE, actualDischarge.quantity.getUnit());
                        assertEquals("m", actualDischarge.quantity.getUnit().getSymbol());
                        assertEquals(Parameter.QuantityType.Length, actualDischarge.type);
                    }


                    @Test
                    @DisplayName("THEN should yield parameters of type Length")
                    void shouldYieldTypeLength() {
                        assertNotNull(actualSuction);
                        assertEquals(Parameter.QuantityType.Length, actualSuction.type);
                        assertNotNull(actualDischarge);
                        assertEquals(Parameter.QuantityType.Length, actualDischarge.type);
                    }
                }

                @Nested
                @DisplayName("WHEN queried for 'Header'")
                class WhenQueriedWrong {

                    @Test
                    @DisplayName("THEN should yield nothing")
                    void shouldYieldNothing() {
                        Parameter actual = testFunction.getParameter("Header");
                        assertNull(actual);
                    }
                }
            }
        }
    }


    @Nested
    @DisplayName("GIVEN Identity Name Description and a Parent")
    class GivenEverything {

        private FunctionCode code;
        private final String project = "Testproject";

        private FunctionCode parentCode;;
        private FunctionBase parent = null;

        private final String NAME = "Bullwurz Poseidon Knuellerkeks";
        private final String DESCRIPTION = "A great German philosopher";

        @BeforeEach
        void setup() {
            try {
                code = FunctionCode.builder()
                        .withSegment("AAA")
                        .build();
                parent = new TestFunction(new FsclEntityId<FunctionCode>(parentCode, project));

            } catch (SegmentFormatException e) {
                fail("Failed in setup with code formatting exception: " + e.getMessage());
            }
        }

        @Nested
        @DisplayName("WHEN created")
        class WhenCreated {

            private TestFunction func = null;
            

            @BeforeEach
            void setup() {
                func = new TestFunction(
                    new FsclEntityId<FunctionCode>(parentCode, project),
                    parent,
                    NAME,
                    DESCRIPTION);
            }

            @Test
            @DisplayName("THEN it should have the given parent")
            void shouldHaveGivenParent() {
                assertEquals(parent, func.getParent());
            }
        }
    }
}
