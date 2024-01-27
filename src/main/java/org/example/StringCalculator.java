package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String numbers){

        if (numbers.isEmpty())
            return 0;

        // if no custom delimiter is specified use this
        String delimiter = ",|\\n";


        if (numbers.startsWith("//[")) {
            int startDelimiterIndex = numbers.indexOf("[") + 1;
            int endDelimiterIndex = numbers.indexOf("]");
            String customDelimiter = numbers.substring(startDelimiterIndex, endDelimiterIndex);

            // Update the regular expression to use the custom delimiter
            delimiter = Pattern.quote(customDelimiter) + "|\\n";

            // Remove the custom delimiter part from the input string
            numbers = numbers.substring(endDelimiterIndex + 2); // +2 to skip "]\\n"
        }

        // if a delimiter is specified using //
        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("\n");
            delimiter = numbers.substring(2, delimiterIndex);
            numbers = numbers.substring(delimiterIndex + 1);
        }


        String[] numbersArray = numbers.split(delimiter);

        String negativeNumbers = "";
        for(String curNum : numbersArray){
            if (curNum.startsWith("-"))
                negativeNumbers += curNum + ",";
        }
        if (numbers.contains("-")){ //  todo maybe not so good if the users sends in - as delimter
            throw new IllegalArgumentException("negatives not allowed " + negativeNumbers);
        }

        int sum = 0;
        int num = 0;

        for (String curEle : numbersArray) {
            num = Integer.parseInt(curEle);
            if (num > 1000)
                num = 0;
            sum = sum + num;
        }

        return sum;
    }
}
