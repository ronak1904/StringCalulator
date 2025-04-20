package com.example.string_calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
	
	public int add(String input) {
        if (input.isEmpty()) return 0;

        String delimiter = "[,\n]";
        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf("\n");
            String delimiterPart = input.substring(2, newlineIndex);
            input = input.substring(newlineIndex + 1);

            // Handle multiple delimiters like //[***][%]
            if (delimiterPart.startsWith("[") && delimiterPart.contains("]")) {
                List<String> delimiters = new ArrayList<>();
                Matcher m = Pattern.compile("\\[(.*?)]").matcher(delimiterPart);
                while (m.find()) {
                    delimiters.add(Pattern.quote(m.group(1)));
                }
                delimiter = String.join("|", delimiters);
            } else {
                delimiter = Pattern.quote(delimiterPart); // single custom delimiter
            }
        }

        String[] parts = input.split(delimiter);
        List<Integer> negatives = new ArrayList<>();
        int sum = 0;

        for (String part : parts) {
            if (part.isEmpty()) continue;
            int number = Integer.parseInt(part);
            if (number < 0) {
                negatives.add(number);
            } else {
                sum += number;
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("negative numbers not allowed: " + negatives);
        }

        return sum;
    }
}
