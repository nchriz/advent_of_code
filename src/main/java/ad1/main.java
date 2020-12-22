/*
 * Copyright (c) 2020 Altus Group. All Rights Reserved.
 */
package ad1;

import util.Helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class main {

    public static void main(String[] args) {
        List<String> stringList = Helper.read("input.txt");
        Map<Integer, Integer> integerMap = new HashMap<Integer, Integer>();
        for (String s : stringList) {
            integerMap.put(Integer.valueOf(s), 1);
        }

        for (Integer i : integerMap.keySet()) {
            if (integerMap.containsKey(2020 - i)) {
                Integer score = (2020 - i) * i;
                System.out.println("Expense is " + score);
                break;
            }
        }

        for (Integer i : integerMap.keySet()) {
            for (Integer j : integerMap.keySet()) {
                if (j == i)
                    continue;
                if (integerMap.containsKey(2020 - i - j)) {
                    Integer score = (2020 - i - j) * j * i;
                    System.out.println("Expense is " + score);
                    break;
                }
            }
        }
    }
}
