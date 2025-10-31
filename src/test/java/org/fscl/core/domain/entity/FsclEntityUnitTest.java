package org.fscl.core.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static tech.units.indriya.unit.Units.METRE;

import org.fscl.core.commons.entity.FsclEntityId;
import org.fscl.core.domain.parameter.Parameter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import tech.units.indriya.quantity.Quantities;

class FsclEntityUnitTest {

	class TestFunction extends FsclEntity<TestFunction> {
		public TestFunction(FsclEntityId id, TestFunction parent, String name, String description) {
			super(id, parent, name, description);
		}

		public FsclEntityId getIdentifier() {
			return super.getEntityId();
		}

		public TestFunction(FsclEntityId id) {
			super(id, null, "", "");
		}

		@Override
		public TestFunction getParent() {
			return this.parent;
		}
	}

	@Nested
	@DisplayName("GIVEN function code and project name")
	class GivenIdentifier {

		private final String code = "=AAA.BAC.023";
		private final String project = "Testproject";

		@Nested
		@DisplayName("WHEN Created with only Identifier")
		class WhenCreatedWithIdentifier {
			private TestFunction func = null;

			@BeforeEach
			void setup() {
				func = new TestFunction(new FsclEntityId(project, code));
			}

			@Test
			@DisplayName("THEN it should exist")
			void shouldExist() {
				assertNotNull(func);
			}

			@Test
			@DisplayName("THEN it should have the given identifier")
			void shouldHaveIdentifier() {
				FsclEntityId id = func.getEntityId();
				String EXPECTED_CODE = "=AAA.BAC.023";
				assertEquals(EXPECTED_CODE, id.code());
				assertEquals(project, id.project());
			}

			@Test
			@DisplayName("THEN it should not have a parent")
			void shouldHaveNoParent() {
				assertNull(func.getParent());
			}

			@Test
			@DisplayName("THEN it should not have a Name")
			void shouldHaveNoName() {
				Assertions.assertEquals("", func.getName());
			}

			@Test
			@DisplayName("THEN it should not have a Description")
			void shouldHaveNoDescription() {
				Assertions.assertEquals("", func.getDescription());
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
				private final String DISCHARGE = "Discharge Header";

				@BeforeEach
				void setup() {
					testFunction = new TestFunction(new FsclEntityId(code, project));
					Parameter suctionHeader = Parameter.ofLength(SUCTION, Quantities.getQuantity(3.34, METRE));
					testFunction.addParameter(suctionHeader);
					testFunction.addParameter(DISCHARGE, Parameter.QuantityType.Length,
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

		private final String project = "Testproject";

		private String parentCode;;
		private TestFunction parent = null;

		private final String NAME = "Bullwurz Poseidon Knuellerkeks";
		private final String DESCRIPTION = "A great German philosopher";

		@BeforeEach
		void setup() {
			parent = new TestFunction(new FsclEntityId(parentCode, project));
		}

		@Nested
		@DisplayName("WHEN created")
		class WhenCreated {

			private TestFunction func = null;

			@BeforeEach
			void setup() {
				func = new TestFunction(new FsclEntityId(parentCode, project), parent, NAME, DESCRIPTION);
			}

			@Test
			@DisplayName("THEN it should have the given parent")
			void shouldHaveGivenParent() {
				Assertions.assertEquals(parent, func.getParent());
			}
		}
	}
}
