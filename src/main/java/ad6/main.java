/*
 * Copyright (c) 2020 Altus Group. All Rights Reserved.
 */
package ad6;

import util.Helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class main {

    private static List<String> testData() {
        List<String> input = new ArrayList<>();
        input.add("abc");
        input.add(" ");
        input.add("a");
        input.add("b");
        input.add("c");
        input.add(" ");
        input.add("ac");
        input.add("ab");
        input.add(" ");
        input.add("a");
        input.add("a");
        input.add("a");
        input.add("a");
        input.add(" ");
        input.add("b");
        return input;
    }

    public static void main(String[] args) {
//        List<String> input = testData();
        List<String> input = Helper.read("input6.txt");

//        partOne(input);
        partTwo(input);
    }

    private static void partOne(List<String> input) {
        int sum = 0;
        Set<Character> charSet = new HashSet<>();
        for (String row : input) {
            if (row.isEmpty() || " ".equalsIgnoreCase(row)) {
                sum += charSet.size();
                charSet = new HashSet<>();
                continue;
            }
            for (Character c : row.toCharArray()) {
                charSet.add(c);
            }
        }

        if (!charSet.isEmpty())
            sum += charSet.size();

        System.out.println("Number of Yes: " + sum);
    }

    private static void partTwo(List<String> input) {
        int sum = 0;
        int passanger = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        for (String row : input) {
            if (row.isEmpty() || " ".equalsIgnoreCase(row)) {
                for (Integer i : charMap.values()) {
                    if (i == passanger)
                        sum++;
                }
                charMap = new HashMap<>();
                passanger = 0;
                continue;
            }
            for (Character c : row.toCharArray()) {
                charMap.compute(c, (k,v) -> {
                    if (v == null)
                        return 1;
                    return ++v;
                });
            }
            passanger++;
        }

        for (Integer i : charMap.values()) {
            if (i == passanger)
                sum++;
        }

        System.out.println("Number of Yes: " + sum);
    }
}
