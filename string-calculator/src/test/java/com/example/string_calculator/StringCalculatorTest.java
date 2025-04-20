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
	
	@Test
	void handleNewlinesAsDelimiters() {
	    StringCalculator calc = new StringCalculator();
	    assertEquals(6, calc.add("1\n2,3"));
	}
	
	@Test
	void supportCustomDelimiter() {
	    StringCalculator calc = new StringCalculator();
	    assertEquals(3, calc.add("//;\n1;2"));
	}
	
	@Test
	void negativeNumbersThrowException() {
	    StringCalculator calc = new StringCalculator();

	    Exception ex = assertThrows(IllegalArgumentException.class, () -> {
	        calc.add("1,-2,3,-4");
	    });

	    assertEquals("negative numbers not allowed: [-2, -4]", ex.getMessage());
	}




}
