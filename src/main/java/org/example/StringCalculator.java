package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String numbers){

        if (numbers.isEmpty())
            return 0;

        // if no custom delimiter is specified use this
        String delimiter = "[,|\n]";

        // if a delimiter is specified using //
        if (numbers.startsWith("//")) {
            int startDelimiterIndex = numbers.indexOf("//") + 2;
            int endDelimiterIndex = numbers.indexOf("\n");
            String customDelim = numbers.substring(startDelimiterIndex, endDelimiterIndex);
            delimiter = "[" + Pattern.quote(customDelim) + "|\n]";
            numbers = numbers.substring(endDelimiterIndex + 1);
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
            if (!curEle.isEmpty()) {
                num = Integer.parseInt(curEle);
                if (num > 1000)
                    num = 0;
                sum = sum + num;
            }
        }

        return sum;
    }
}
