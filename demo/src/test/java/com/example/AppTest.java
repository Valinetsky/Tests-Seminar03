package com.example;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
	/**
	 * Rigorous Test :-)
	 */
	@Test
	public void shouldAnswerWithTrue() {
		assertTrue(true);
	}
	// --------------------------------------------

	@Test
	@DisplayName("Тест: четность числа. 4 — true")
	void checkEvenNumber() {
		assertTrue(App.evenOddNumber(4));
	}

	@Test
	@DisplayName("Тест: четность числа. 3 — false")
	void checkOddNumber() {
		assertFalse(App.evenOddNumber(3));
	}

	@Test
	@DisplayName("Тест: число в интервале. 25 — true, 100 — true")
	void checkNumberInInterval() {
		assertTrue(App.numberInInterval(25));
		assertTrue(App.numberInInterval(100));
	}

	@Test
	@DisplayName("Тест: число в интервале. 24 — false, 101 — false")
	void checkNumberNotInInterval() {
		assertFalse(App.numberInInterval(24));
		assertFalse(App.numberInInterval(101));
	}

}
