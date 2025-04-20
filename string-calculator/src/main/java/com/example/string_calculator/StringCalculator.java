package com.example.string_calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {
	
	public int add(String numbers) {
	    if (numbers.isEmpty()) return 0;

	    String delimiter = ",|\n";

	    if (numbers.startsWith("//")) {
	        int delimiterEnd = numbers.indexOf("\n");
	        delimiter = Pattern.quote(numbers.substring(2, delimiterEnd));
	        numbers = numbers.substring(delimiterEnd + 1);
	    }

	    String[] parts = numbers.split(delimiter);
	    List<Integer> negatives = new ArrayList<>();
	    int sum = 0;

	    for (String part : parts) {
	        int num = Integer.parseInt(part);
	        if (num < 0) {
	            negatives.add(num);
	        } else {
	            sum += num;
	        }
	    }

	    if (!negatives.isEmpty()) {
	        throw new IllegalArgumentException("negative numbers not allowed: " + negatives);
	    }

	    return sum;
	}
}
