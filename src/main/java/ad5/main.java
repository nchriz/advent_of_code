/*
 * Copyright (c) 2020 Altus Group. All Rights Reserved.
 */
package ad5;

import util.Helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class main {

    private static List<String> testData() {
        List<String> input = new ArrayList<>();
        input.add("FBFBBFFRLR");
        input.add("BFFFBBFRRR");
        input.add("FFFBBBFRRR");
        input.add("BBFFBBFRLL");
        return input;
    }

    public static void main(String[] args) {
//        List<String> input = testData();
        List<String> input = Helper.read("input5.txt");
        List<Integer> idList = new ArrayList<>();

        int top;
        int bot;

        int left;
        int right;

        int i;

        int highest_id = 0;

        for (String boarding : input) {
            int rowNum;
            int column;
            bot = 0;
            top = 127;
            char[] row = boarding.toCharArray();
            for (i = 0; i < 6; i++) {
                if (row[i] == 'B')
                    bot = (int)Math.ceil((top + bot) / 2.0);
                else if (row[i] == 'F')
                    top = (int)Math.floor((top + bot) / 2.0);
            }
            rowNum = row[i] == 'F' ? bot : top;


            left = 0;
            right = 7;

            for (i++; i < 9; i++) {
                if (row[i] == 'R')
                    left = (int) Math.ceil((left+right) / 2.0);
                else
                    right = (int) Math.floor((left+right)/2.0);
            }
            column = row[i] == 'R' ? right : left;
//            System.out.println("Row number:" + rowNum + " Column number:" + column);

            idList.add(rowNum * 8 + column);

            if (highest_id < (rowNum * 8 + column))
                highest_id = rowNum * 8 + column;
        }
        Collections.sort(idList);
        int lowest = idList.get(0);
        for (i = lowest; i < highest_id; i++)
            if (!idList.contains(i))
                System.out.println("Your seat is " + i);
//        System.out.println(idList);
        System.out.println("Highest id is " + highest_id);
    }
}
