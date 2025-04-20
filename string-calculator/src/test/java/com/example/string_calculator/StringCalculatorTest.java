package com.example.string_calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
	
	@Test
	void emptyStringReturnsZero() {
	    assertEquals(0, new StringCalculator().add(""));
	}

}
