/*
 * Copyright (c) 2020 Altus Group. All Rights Reserved.
 */
package ad3;

import util.Helper;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String[] args) {
        List<String> input = Helper.read("input3.txt");

        List<List<Character>> map = createMap(input);

        List<Integer> x_move = new ArrayList<>();
        x_move.add(1);
        x_move.add(3);
        x_move.add(5);
        x_move.add(7);
        x_move.add(1);
        List<Integer> y_move = new ArrayList<>();
        y_move.add(1);
        y_move.add(1);
        y_move.add(1);
        y_move.add(1);
        y_move.add(2);
        long sum = 1;
        int modX = map.get(0).size();

        for (int j = 0; j < y_move.size(); j++) {

            int moveX = 0;
            int moveY = 0;
            int number_of_tree = 0;

//            System.out.println("Start pos X: " + moveX + " start pos Y: " + moveY + " number of trees: " + number_of_tree);

            while (moveY < (map.size() - y_move.get(j))) {
                moveX = (moveX + x_move.get(j)) % modX;
                moveY += y_move.get(j);
                if (map.get(moveY).get(moveX) == '#') {
                    number_of_tree++;
//                    map.get(moveY).add(moveX, 'X');
                } else {
//                    map.get(moveY).add(moveX, 'O');
                }
            }

//            for (int i = 0; i < map.get(0).size(); i++)
//                System.out.print('-');
//
//            for (List<Character> test : map)
//                System.out.println(test);

            System.out.println("X move: " + x_move.get(j) + " and Y move: " + y_move.get(j) + " number of trees: " + number_of_tree);
            sum = sum * number_of_tree;
        }

        System.out.println("Sum of trees: " + sum);
    }

    private static List<List<Character>> createMap(List<String> input) {
        List<List<Character>> map = new ArrayList<>();

        for (String inputRow : input) {
            List<Character> row = new ArrayList<>();

            for (Character inputChar : inputRow.toCharArray())
                row.add(inputChar);

            map.add(row);
        }

        return map;
    }
}
