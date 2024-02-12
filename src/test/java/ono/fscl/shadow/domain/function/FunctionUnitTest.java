package ono.fscl.shadow.domain.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import javax.measure.Quantity;
import javax.measure.quantity.ElectricCurrent;
import tec.units.ri.quantity.Quantities;
import static tec.units.ri.unit.Units.AMPERE;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import ono.fscl.core.domain.entity.id.EntityId;
import ono.fscl.core.domain.entity.id.SegmentFormatException;
import ono.fscl.core.domain.function.FunctionBase;
import ono.fscl.core.domain.function.FunctionCode;
import ono.fscl.core.domain.parameters.Parameter;

class FunctionUnitTest {

    class TestFunction extends FunctionBase {
        public TestFunction(
            EntityId<FunctionCode> id, 
            FunctionBase parent, 
            String name, 
            String description) {
            super(id, parent, name, description);
        }

        public TestFunction(EntityId<FunctionCode> id) {
            super(id, null, "", "");
        }
    }

    @Nested
    @DisplayName("GIVEN function code and project name")
    class GivenIdentifier {
    
        private FunctionCode code = new FunctionCode();
        private String project = "Testproject";

        private String EXPECTED_CODE = "=AAA.BAC.023";

        @BeforeEach
        void setup() {
            try {
                this.code.addSegment("AAA");
                this.code.addSegment("BAC");
                this.code.addSegment("023");
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
                func = new TestFunction(new EntityId<FunctionCode>(code, project));
            }

            @Test
            @DisplayName("THEN it should exist")
            void shouldExist() {
                assertNotNull(func);
            }

            @Test
            @DisplayName("THEN it should have the given identifier")
            void shouldHaveIdentifier() {
                EntityId<FunctionCode> id = func.getIdentifier();
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
        @DisplayName("GIVEN a Voltage Parameter")
        class GivenElectricCurrentParam {
            private final Quantity<ElectricCurrent> current = Quantities.getQuantity(120, AMPERE);
            private String PARAM_NAME = "Dickstrom";

            private final Parameter<ElectricCurrent> dickStrom = new Parameter<ElectricCurrent>(PARAM_NAME, current);
            @Nested
            @DisplayName("GIVEN TestFunction")
            class WhenCreated {

                private TestFunction func = null;
                

                @Nested
                @DisplayName("WHEN Parameter added")
                class WhenParamAdded {
                    @BeforeEach
                    void setup() {
                        func = new TestFunction(new EntityId<FunctionCode>(code, project));
                        func.getParameters().add(dickStrom);
                    }

                    @Test
                    @DisplayName("THEN should yield parameter of such name and value")
                    

                } 
            }
        }

    }

    @Nested
    @DisplayName("GIVEN Identity Name Description and a Parent")
    class GivenEverything {

        private FunctionCode code = new FunctionCode();
        private final String project = "Testproject";

        private FunctionCode parentCode = new FunctionCode(); 
        private FunctionBase parent = null;

        private final String NAME = "Bullwurz Poseidon Knuellerkeks";
        private final String DESCRIPTION = "A great German philosopher";

        @BeforeEach
        void setup() {
            try {
                code.addSegment("AAA");
                code.addSegment("BAC");

                parentCode.addSegment("AAA");

                parent = new TestFunction(new EntityId<FunctionCode>(parentCode, project));

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
                    new EntityId<FunctionCode>(parentCode, project),
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
