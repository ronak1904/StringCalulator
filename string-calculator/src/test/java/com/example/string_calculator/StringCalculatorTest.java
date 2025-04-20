package com.example.string_calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
	
	@Test
	void emptyStringReturnsZero() {
	    assertEquals(0, new StringCalculator().add(""));
	}
	
	@Test
	void oneNumberReturnsValue() {
	    StringCalculator calc = new StringCalculator();
	    assertEquals(1, calc.add("1"));
	}
	
	@Test
	void twoNumbersCommaSeparated() {
	    StringCalculator calc = new StringCalculator();
	    assertEquals(3, calc.add("1,2"));
	}
	
	@Test
	void multipleNumbers() {
	    StringCalculator calc = new StringCalculator();
	    assertEquals(10, calc.add("1,2,3,4"));
	}

}
