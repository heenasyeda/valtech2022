package com.valtech.training.valtech.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
//import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Nested;

public class ArithmeticTest {

	private Arithmetic arithmetic;
	private static int ZERO;

	@Nested
	public static class DivisionTest {
		
		private Arithmetic arithmetic;

		@Test
		public void  testDivByZero(){
		arithmetic = new ArithmeticImpl();
		assertThrows(ArithmeticException.class,() -> {arithmetic.div(2,ZERO);});
		
		
	}
	}

		@Nested
		@DisplayName("This is for Testing Sub Method of the Arithmetic")

		public static class SubrationTest {
			private Arithmetic arithmetic;

			@ParameterizedTest
			@CsvSource({ "'Subracting 2 Positive Nos',2,3,-1", "'Subracting 2 Negative Nos',-2,-3,1",
					"'Subracting 1 Positive 1 Negative No',-2,3,-5", })
			public void testSub(String name, int a, int b, int res) {
				assertEquals(res, arithmetic.sub(a, b));
			}

		}

		@ParameterizedTest
		@CsvSource({ "'Adding 2 Positive Nos',2,3,5", "'Adding 2 Negative Nos',-2,-3,-5",
				"'Adding 1 Positive 1 Negative No',-2,3,1",

		})
		public void testAdd(String name, int a, int b, int res) {
			assertEquals(res, arithmetic.add(a, b));
		}

		public static Stream<Arguments> argumentsForAdd() { // for version more
															// than
															// 1.8
			return Stream.of(Arguments.of(2, 3, 5), Arguments.of(1, 3, 4));
		}

		@ParameterizedTest
		@MethodSource("argumentsForAdd")
		public void testAdd(int a, int b, int res) {

		}

		@DisplayName("{index})Testing for add with {0} and 0")
		@ParameterizedTest
		@ValueSource(ints = { 2, 3, 4, -1, -2 })
		public void testAddZero(int a) {
			assertEquals(a, arithmetic.add(a, ZERO));
		}

		@DisplayName("Generic test cases for add ...")
		@Test
		public void testAdd() {
			assertEquals(5, arithmetic.add(2, 3));
			assertEquals(5, arithmetic.add(3, 2));
		}

		@BeforeAll
		public static void executeMeFirst() {
			System.out.println("Before All - Executed first");
			ZERO = 0;
		}

		@AfterAll
		public static void executeMeJustBeforeProgramExits() {
			System.out.println("Last method to be executed");
		}

		@BeforeEach
		public void runBeforeTest() {
			arithmetic = new ArithmeticImpl();
			System.out.println("Run Before..");
		}

		@AfterEach
		public void afterTest() {
			System.out.println("After each method");
		}

		@Test
		public void testHello() {
			System.out.println("Hello...");
		}

		@Test
		public void testHi() {
			System.out.println("Hi...");
		}
}