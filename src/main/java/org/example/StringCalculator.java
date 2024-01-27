package org.example;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public int add(String numbers){

        if (numbers.isEmpty())
            return 0;

        if (numbers.contains("-")){ //  todo maybe not so good if the users sends in - as delimter
            throw new IllegalArgumentException("negatives not allowed " + numbers);
        }

        // if no custom delimiter is specified use this
        String delimiter = ",|\\n";

        // if a delimiter is specified using //
        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("\n");
            delimiter = numbers.substring(2, delimiterIndex);
            numbers = numbers.substring(delimiterIndex + 1);
        }

        String[] numbersArray = numbers.split(delimiter);

        int sum = 0;
        int num = 0;

        for (String curEle : numbersArray) {
            num = Integer.parseInt(curEle);
            sum = sum + num;
        }

        return sum;
    }
}
