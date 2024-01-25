package org.example;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public int add(String numbers) {
        // convert string s to numbers separated with comma
        String[] numbersArray = numbers.split(",");

        if (numbersArray.length > 2)
            return 0;

        int sum = 0;
        int num = 0;

        for (String curEle : numbersArray) {
            num = Integer.parseInt(curEle);
            sum = sum + num;
        }

        return sum;
    }
}
