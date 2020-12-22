/*
 * Copyright (c) 2020 Altus Group. All Rights Reserved.
 */
package ad2;

import util.Helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class main {

    public static void main(String[] arg) {
        List<String> stringList = Helper.read("input2.txt");

        int sum = 0;
        for (String password : stringList) {
            if (process(password))
                sum++;
        }
        System.out.println(sum);

        sum = 0;
        for (String password : stringList) {
            if (processTwo(password))
                sum++;
        }
        System.out.println(sum);
    }

    private static boolean process(String s) {
        String[] line = s.split(":");
        String[] rule = line[0].split(" ");
        String pws = line[1];
        String letter = rule[1];
        String[] numbers = rule[0].split("-");
        Map<Character, Integer> letterMap = new HashMap<>();
        for (Character c : pws.toCharArray()) {
            letterMap.compute(c, (k,v) -> {
                if (v == null)
                    return 1;
                return v + 1;
            });
        }
        Integer count = letterMap.get(letter.toCharArray()[0]);
        if (count != null) {
            return count >= Integer.parseInt(numbers[0]) && count <= Integer.parseInt(numbers[1]);
        }

        return false;
    }

    private static boolean processTwo(String s) {
        String[] line = s.split(":");
        String[] rule = line[0].split(" ");
        String pws = line[1];
        String letter = rule[1];
        String[] numbers = rule[0].split("-");
        if (pws.charAt(Integer.parseInt(numbers[0])) == letter.charAt(0) &&
                pws.charAt(Integer.parseInt(numbers[1])) != letter.charAt(0)) {
            return true;
        } else if (pws.charAt(Integer.parseInt(numbers[1])) == letter.charAt(0) &&
                pws.charAt(Integer.parseInt(numbers[0])) != letter.charAt(0)) {
            return true;
        }

        return false;
    }
}
